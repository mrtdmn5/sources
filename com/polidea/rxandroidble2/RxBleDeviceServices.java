package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothGattService;
import java.util.List;

/* loaded from: classes3.dex */
public final class RxBleDeviceServices {
    public final List<BluetoothGattService> bluetoothGattServices;

    public RxBleDeviceServices(List<BluetoothGattService> list) {
        this.bluetoothGattServices = list;
    }
}
