package com.polidea.rxandroidble2.exceptions;

import android.bluetooth.BluetoothGatt;

/* loaded from: classes3.dex */
public class BleGattCannotStartException extends BleGattException {
    public BleGattCannotStartException(BluetoothGatt bluetoothGatt, BleGattOperationType bleGattOperationType) {
        super(bluetoothGatt, -1, bleGattOperationType);
    }
}
