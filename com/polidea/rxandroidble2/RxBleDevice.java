package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothDevice;
import io.reactivex.internal.operators.observable.ObservableDefer;

/* loaded from: classes3.dex */
public interface RxBleDevice {
    ObservableDefer establishConnection(boolean z);

    BluetoothDevice getBluetoothDevice();

    String getMacAddress();

    String getName();
}
