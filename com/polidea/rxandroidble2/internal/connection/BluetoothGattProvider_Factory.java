package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class BluetoothGattProvider_Factory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final BluetoothGattProvider_Factory INSTANCE = new BluetoothGattProvider_Factory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new BluetoothGattProvider();
    }
}
