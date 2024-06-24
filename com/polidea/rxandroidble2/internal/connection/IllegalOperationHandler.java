package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.internal.BleIllegalOperationException;

/* loaded from: classes3.dex */
public abstract class IllegalOperationHandler {
    public final IllegalOperationMessageCreator messageCreator;

    public IllegalOperationHandler(IllegalOperationMessageCreator illegalOperationMessageCreator) {
        this.messageCreator = illegalOperationMessageCreator;
    }

    public abstract BleIllegalOperationException handleMismatchData(BluetoothGattCharacteristic bluetoothGattCharacteristic, int r2);
}
