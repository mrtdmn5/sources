package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.internal.BleIllegalOperationException;
import com.polidea.rxandroidble2.internal.RxBleLog;

/* loaded from: classes3.dex */
public final class LoggingIllegalOperationHandler extends IllegalOperationHandler {
    @Override // com.polidea.rxandroidble2.internal.connection.IllegalOperationHandler
    public final BleIllegalOperationException handleMismatchData(BluetoothGattCharacteristic bluetoothGattCharacteristic, int r3) {
        RxBleLog.w(this.messageCreator.createMismatchMessage(bluetoothGattCharacteristic, r3), new Object[0]);
        return null;
    }
}
