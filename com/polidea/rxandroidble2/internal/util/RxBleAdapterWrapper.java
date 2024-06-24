package com.polidea.rxandroidble2.internal.util;

import android.bluetooth.BluetoothAdapter;
import com.polidea.rxandroidble2.exceptions.BleException;

/* loaded from: classes3.dex */
public final class RxBleAdapterWrapper {
    public static final BleException nullBluetoothAdapter = new BleException("bluetoothAdapter is null");
    public final BluetoothAdapter bluetoothAdapter;

    public RxBleAdapterWrapper(BluetoothAdapter bluetoothAdapter) {
        this.bluetoothAdapter = bluetoothAdapter;
    }
}
