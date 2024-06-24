package com.polidea.rxandroidble2.internal;

import bleshadow.javax.inject.Provider;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleConnection;

/* loaded from: classes3.dex */
public final class DeviceModule_ProvideConnectionStateRelayFactory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final DeviceModule_ProvideConnectionStateRelayFactory INSTANCE = new DeviceModule_ProvideConnectionStateRelayFactory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        RxBleConnection.RxBleConnectionState rxBleConnectionState = RxBleConnection.RxBleConnectionState.DISCONNECTED;
        BehaviorRelay behaviorRelay = new BehaviorRelay();
        if (rxBleConnectionState != null) {
            behaviorRelay.value.lazySet(rxBleConnectionState);
            return behaviorRelay;
        }
        throw new NullPointerException("defaultValue == null");
    }
}
