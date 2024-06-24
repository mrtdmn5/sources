package com.polidea.rxandroidble2.internal.util;

import android.bluetooth.BluetoothAdapter;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideBluetoothAdapterFactory;

/* loaded from: classes3.dex */
public final class RxBleAdapterWrapper_Factory implements Provider {
    public final Provider<BluetoothAdapter> bluetoothAdapterProvider = ClientComponent_ClientModule_ProvideBluetoothAdapterFactory.InstanceHolder.INSTANCE;

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new RxBleAdapterWrapper(this.bluetoothAdapterProvider.get());
    }
}
