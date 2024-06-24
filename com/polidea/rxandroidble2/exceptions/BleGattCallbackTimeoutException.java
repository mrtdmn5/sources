package com.polidea.rxandroidble2.exceptions;

import android.bluetooth.BluetoothGatt;

/* loaded from: classes3.dex */
public class BleGattCallbackTimeoutException extends BleGattException {
    public BleGattCallbackTimeoutException(BluetoothGatt bluetoothGatt, BleGattOperationType bleGattOperationType) {
        super(bluetoothGatt, -1, bleGattOperationType);
    }
}
