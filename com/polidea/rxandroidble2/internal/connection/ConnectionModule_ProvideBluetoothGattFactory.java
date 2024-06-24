package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import bleshadow.javax.inject.Provider;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ConnectionModule_ProvideBluetoothGattFactory implements Provider {
    public final Provider<BluetoothGattProvider> bluetoothGattProvider;

    public ConnectionModule_ProvideBluetoothGattFactory(Provider<BluetoothGattProvider> provider) {
        this.bluetoothGattProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        BluetoothGatt bluetoothGatt = this.bluetoothGattProvider.get().reference.get();
        UnsignedKt.checkNotNullFromProvides(bluetoothGatt);
        return bluetoothGatt;
    }
}
