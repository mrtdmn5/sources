package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import no.nordicsemi.android.dfu.BaseDfuImpl;

@SuppressLint({"MissingPermission"})
/* loaded from: classes4.dex */
abstract class BaseButtonlessDfuImpl extends BaseDfuImpl {
    private final ButtonlessBluetoothCallback mBluetoothCallback;

    /* loaded from: classes4.dex */
    public class ButtonlessBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        public ButtonlessBluetoothCallback() {
            super();
        }

        @Override // no.nordicsemi.android.dfu.BaseDfuImpl.BaseBluetoothGattCallback, android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            BaseButtonlessDfuImpl.this.mService.sendLogBroadcast(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
            BaseButtonlessDfuImpl.this.mReceivedData = bluetoothGattCharacteristic.getValue();
            BaseButtonlessDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int r3) {
            BaseButtonlessDfuImpl baseButtonlessDfuImpl = BaseButtonlessDfuImpl.this;
            baseButtonlessDfuImpl.mRequestCompleted = true;
            baseButtonlessDfuImpl.notifyLock();
        }
    }

    public BaseButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.mBluetoothCallback = new ButtonlessBluetoothCallback();
    }

    public void finalize(Intent intent, boolean z, boolean z2) {
        boolean z3 = false;
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_KEEP_BOND, false);
        DfuBaseService dfuBaseService = this.mService;
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (z || !booleanExtra) {
            z3 = true;
        }
        dfuBaseService.refreshDeviceCache(bluetoothGatt, z3);
        this.mService.close(this.mGatt);
        logi("Restarting to bootloader mode");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, z2);
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }
}
