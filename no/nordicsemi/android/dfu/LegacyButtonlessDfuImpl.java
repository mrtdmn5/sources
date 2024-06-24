package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.preference.PreferenceManager;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"MissingPermission"})
/* loaded from: classes4.dex */
public class LegacyButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private int mVersion;
    static UUID DFU_SERVICE_UUID = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
    static UUID DFU_VERSION_UUID = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1, 4};

    public LegacyButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    private String getVersionFeatures(int r2) {
        if (r2 != 0) {
            if (r2 != 1) {
                if (r2 != 5) {
                    if (r2 != 6) {
                        if (r2 != 7) {
                            if (r2 != 8) {
                                return "Unknown version";
                            }
                            return "Bootloader from SDK 9.0 or newer. Signature supported";
                        }
                        return "Bootloader from SDK 8.0 or newer. SHA-256 used instead of CRC-16 in the Init Packet";
                    }
                    return "Bootloader from SDK 8.0 or newer. Bond sharing supported";
                }
                return "Bootloader from SDK 7.0 or newer. No bond sharing";
            }
            return "Application with Legacy buttonless update from SDK 7.0 or newer";
        }
        return "Bootloader from SDK 6.1 or older";
    }

    private int readVersion(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (this.mConnected) {
            if (!this.mAborted) {
                if (bluetoothGattCharacteristic == null) {
                    return 0;
                }
                this.mReceivedData = null;
                this.mError = 0;
                logi("Reading DFU version number...");
                this.mService.sendLogBroadcast(1, "Reading DFU version number...");
                this.mService.sendLogBroadcast(0, "gatt.readCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
                bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
                try {
                    synchronized (this.mLock) {
                        while (true) {
                            if (((this.mRequestCompleted && this.mReceivedData != null) || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                                break;
                            }
                            this.mRequestCompleted = false;
                            this.mLock.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    loge("Sleeping interrupted", e);
                }
                if (this.mConnected) {
                    if (this.mError == 0) {
                        byte[] bArr = this.mReceivedData;
                        if (bArr == null || bArr.length < 2) {
                            return 0;
                        }
                        return getShort(bArr, 0);
                    }
                    throw new DfuException("Unable to read version number", this.mError);
                }
                throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
            }
            throw new UploadAbortedException();
        }
        throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
    }

    public int getShort(byte[] bArr, int r3) {
        return ((bArr[r3 + 1] & 255) << 8) | (bArr[r3] & 255);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        BluetoothGattCharacteristic characteristic;
        int r0;
        boolean z;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        this.mProgressInfo.setProgress(-2);
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_VERSION_UUID);
        if (characteristic2 != null) {
            r0 = readVersion(bluetoothGatt, characteristic2);
            this.mVersion = r0;
            int r3 = r0 & 15;
            int r4 = r0 >> 8;
            StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("Version number read: ", r4, InstructionFileId.DOT, r3, " -> ");
            m.append(getVersionFeatures(r0));
            logi(m.toString());
            this.mService.sendLogBroadcast(10, HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Version number read: ", r4, InstructionFileId.DOT, r3));
        } else {
            logi("No DFU Version characteristic found -> " + getVersionFeatures(0));
            this.mService.sendLogBroadcast(10, "DFU Version characteristic not found");
            r0 = 0;
        }
        boolean z2 = PreferenceManager.getDefaultSharedPreferences(this.mService).getBoolean(DfuSettingsConstants.SETTINGS_ASSUME_DFU_NODE, false);
        if (intent.hasExtra(DfuBaseService.EXTRA_FORCE_DFU)) {
            z2 = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_DFU, false);
        }
        if (bluetoothGatt.getServices().size() > 3) {
            z = true;
        } else {
            z = false;
        }
        if (r0 == 0 && z) {
            logi("Additional services found -> Bootloader from SDK 6.1. Updating SD and BL supported, extended init packet not supported");
        }
        if (r0 != 1 && (z2 || r0 != 0 || !z)) {
            return false;
        }
        return true;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        logw("Application with legacy buttonless update found");
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        boolean z = true;
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        if (intent.hasExtra(DfuBaseService.EXTRA_MTU)) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_MTU, 517);
            logi(SubMenuBuilder$$ExternalSyntheticOutline0.m("Requesting MTU = ", intExtra));
            requestMtu(intExtra);
        }
        enableCCCD(this.mControlPointCharacteristic, 1);
        this.mService.sendLogBroadcast(10, "Notifications enabled");
        this.mProgressInfo.setProgress(-3);
        logi("Sending Start DFU command (Op Code = 1, Upload Mode = 4)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
        this.mService.sendLogBroadcast(10, "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)");
        BluetoothGatt bluetoothGatt = this.mGatt;
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU, false);
        if (!booleanExtra && this.mVersion != 0) {
            this.mService.waitUntilDisconnected();
            this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        } else {
            this.mService.disconnect(bluetoothGatt);
        }
        logi("Device disconnected");
        if (!booleanExtra && this.mVersion != 0) {
            z = false;
        }
        finalize(intent, false, z);
    }
}
