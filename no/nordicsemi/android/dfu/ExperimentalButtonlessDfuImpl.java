package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class ExperimentalButtonlessDfuImpl extends ButtonlessDfuImpl {
    static final UUID DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
    static final UUID DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID;
    static UUID EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
    static UUID EXPERIMENTAL_BUTTONLESS_DFU_UUID;
    private BluetoothGattCharacteristic mButtonlessDfuCharacteristic;

    static {
        UUID r0 = new UUID(-8196551313441075360L, -6937650605005804976L);
        DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = r0;
        UUID r5 = new UUID(-8196551313441075360L, -6937650605005804976L);
        DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID = r5;
        EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = r0;
        EXPERIMENTAL_BUTTONLESS_DFU_UUID = r5;
    }

    public ExperimentalButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    @Override // no.nordicsemi.android.dfu.ButtonlessDfuImpl
    public BluetoothGattCharacteristic getButtonlessDfuCharacteristic() {
        return this.mButtonlessDfuCharacteristic;
    }

    @Override // no.nordicsemi.android.dfu.ButtonlessDfuImpl
    public int getResponseType() {
        return 1;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(EXPERIMENTAL_BUTTONLESS_DFU_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mButtonlessDfuCharacteristic = characteristic;
        return true;
    }

    @Override // no.nordicsemi.android.dfu.ButtonlessDfuImpl, no.nordicsemi.android.dfu.DfuService
    public void performDfu(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        logi("Experimental buttonless service found -> SDK 12.x");
        super.performDfu(intent);
    }

    @Override // no.nordicsemi.android.dfu.ButtonlessDfuImpl
    public boolean shouldScanForBootloader() {
        return true;
    }
}
