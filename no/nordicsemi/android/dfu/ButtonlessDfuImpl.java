package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import com.animaconnected.secondo.notification.handler.DisplayNotificationHandler;
import java.util.Locale;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.error.SecureDfuError;

/* loaded from: classes4.dex */
abstract class ButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1};
    private static final int OP_CODE_ENTER_BOOTLOADER_KEY = 1;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 32;

    public ButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    private int getStatusCode(byte[] bArr, int r6) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length >= 3 && bArr[0] == 32 && bArr[1] == r6 && ((b = bArr[2]) == 1 || b == 2 || b == 4)) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 32, r6);
    }

    public abstract BluetoothGattCharacteristic getButtonlessDfuCharacteristic();

    public abstract int getResponseType();

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        String str;
        byte[] bArr;
        this.mProgressInfo.setProgress(-2);
        BluetoothGatt bluetoothGatt = this.mGatt;
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        BluetoothGattCharacteristic buttonlessDfuCharacteristic = getButtonlessDfuCharacteristic();
        int responseType = getResponseType();
        enableCCCD(buttonlessDfuCharacteristic, getResponseType());
        DfuBaseService dfuBaseService = this.mService;
        if (responseType == 2) {
            str = "Indications";
        } else {
            str = DisplayNotificationHandler.TYPE;
        }
        dfuBaseService.sendLogBroadcast(10, str.concat(" enabled"));
        try {
            this.mProgressInfo.setProgress(-3);
            logi("Sending Enter Bootloader (Op Code = 1)");
            writeOpCode(buttonlessDfuCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
            this.mService.sendLogBroadcast(10, "Enter bootloader sent (Op Code = 1)");
            try {
                bArr = readNotificationResponse();
            } catch (DeviceDisconnectedException unused) {
                bArr = this.mReceivedData;
            }
            if (bArr != null) {
                int statusCode = getStatusCode(bArr, 1);
                logi("Response received (Op Code = " + ((int) bArr[1]) + ", Status = " + statusCode + ")");
                this.mService.sendLogBroadcast(10, "Response received (Op Code = " + ((int) bArr[1]) + ", Status = " + statusCode + ")");
                if (statusCode == 1) {
                    if (shouldScanForBootloader()) {
                        this.mService.disconnect(bluetoothGatt);
                    } else {
                        this.mService.waitUntilDisconnected();
                        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
                    }
                    logi("Device disconnected");
                } else {
                    throw new RemoteDfuException("Device returned error after sending Enter Bootloader", statusCode);
                }
            } else {
                logi("Device disconnected before receiving notification");
            }
            finalize(intent, false, shouldScanForBootloader());
        } catch (RemoteDfuException e) {
            int errorNumber = e.getErrorNumber() | 2048;
            loge(e.getMessage());
            this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", SecureDfuError.parseButtonlessError(errorNumber)));
            this.mService.terminateConnection(bluetoothGatt, errorNumber | DfuBaseService.ERROR_REMOTE_MASK);
        } catch (UnknownResponseException e2) {
            loge(e2.getMessage());
            this.mService.sendLogBroadcast(20, e2.getMessage());
            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INVALID_RESPONSE);
        }
    }

    public abstract boolean shouldScanForBootloader();
}
