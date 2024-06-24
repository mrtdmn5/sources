package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.internal.BleIllegalOperationException;

/* loaded from: classes3.dex */
public final class ThrowingIllegalOperationHandler extends IllegalOperationHandler {
    @Override // com.polidea.rxandroidble2.internal.connection.IllegalOperationHandler
    public final BleIllegalOperationException handleMismatchData(BluetoothGattCharacteristic bluetoothGattCharacteristic, int r3) {
        String createMismatchMessage = this.messageCreator.createMismatchMessage(bluetoothGattCharacteristic, r3);
        bluetoothGattCharacteristic.getUuid();
        bluetoothGattCharacteristic.getProperties();
        return new BleIllegalOperationException(createMismatchMessage);
    }
}
