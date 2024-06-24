package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_MinimumMtuFactory;

/* loaded from: classes3.dex */
public final class MtuWatcher_Factory implements Provider {
    public final Provider<Integer> initialValueProvider;
    public final Provider<RxBleGattCallback> rxBleGattCallbackProvider;

    public MtuWatcher_Factory(Provider provider) {
        ConnectionModule_MinimumMtuFactory connectionModule_MinimumMtuFactory = ConnectionModule_MinimumMtuFactory.InstanceHolder.INSTANCE;
        this.rxBleGattCallbackProvider = provider;
        this.initialValueProvider = connectionModule_MinimumMtuFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        RxBleGattCallback rxBleGattCallback = this.rxBleGattCallbackProvider.get();
        this.initialValueProvider.get().intValue();
        return new MtuWatcher(rxBleGattCallback);
    }
}
