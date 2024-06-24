package com.polidea.rxandroidble2.internal.util;

import android.bluetooth.BluetoothManager;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideBluetoothManagerFactory;

/* loaded from: classes3.dex */
public final class BluetoothManagerWrapper_Factory implements Provider {
    public final Provider<BluetoothManager> bluetoothManagerProvider;

    public BluetoothManagerWrapper_Factory(ClientComponent_ClientModule_ProvideBluetoothManagerFactory clientComponent_ClientModule_ProvideBluetoothManagerFactory) {
        this.bluetoothManagerProvider = clientComponent_ClientModule_ProvideBluetoothManagerFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        this.bluetoothManagerProvider.get();
        return new BluetoothManagerWrapper();
    }
}
