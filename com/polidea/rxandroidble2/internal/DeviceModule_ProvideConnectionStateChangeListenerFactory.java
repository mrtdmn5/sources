package com.polidea.rxandroidble2.internal;

import bleshadow.javax.inject.Provider;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;

/* loaded from: classes3.dex */
public final class DeviceModule_ProvideConnectionStateChangeListenerFactory implements Provider {
    public final Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> connectionStateBehaviorRelayProvider;

    public DeviceModule_ProvideConnectionStateChangeListenerFactory(Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provider) {
        this.connectionStateBehaviorRelayProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        final BehaviorRelay<RxBleConnection.RxBleConnectionState> behaviorRelay = this.connectionStateBehaviorRelayProvider.get();
        return new ConnectionStateChangeListener() { // from class: com.polidea.rxandroidble2.internal.DeviceModule$1
            @Override // com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener
            public final void onConnectionStateChange(RxBleConnection.RxBleConnectionState rxBleConnectionState) {
                BehaviorRelay.this.accept(rxBleConnectionState);
            }
        };
    }
}
