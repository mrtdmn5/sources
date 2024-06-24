package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import bleshadow.javax.inject.Provider;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothManagerFactory implements Provider {
    public final Provider<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideBluetoothManagerFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        BluetoothManager bluetoothManager = (BluetoothManager) this.contextProvider.get().getSystemService("bluetooth");
        UnsignedKt.checkNotNullFromProvides(bluetoothManager);
        return bluetoothManager;
    }
}
