package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothAdapter;
import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothAdapterFactory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final ClientComponent_ClientModule_ProvideBluetoothAdapterFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothAdapterFactory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return BluetoothAdapter.getDefaultAdapter();
    }
}
