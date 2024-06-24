package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.DelegateFactory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_GattWriteMtuOverheadFactory;

/* loaded from: classes3.dex */
public final class MtuBasedPayloadSizeLimit_Factory implements Provider {
    public final Provider<Integer> gattWriteMtuOverheadProvider;
    public final Provider<RxBleConnection> rxBleConnectionProvider;

    public MtuBasedPayloadSizeLimit_Factory(DelegateFactory delegateFactory) {
        ConnectionModule_GattWriteMtuOverheadFactory connectionModule_GattWriteMtuOverheadFactory = ConnectionModule_GattWriteMtuOverheadFactory.InstanceHolder.INSTANCE;
        this.rxBleConnectionProvider = delegateFactory;
        this.gattWriteMtuOverheadProvider = connectionModule_GattWriteMtuOverheadFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        RxBleConnection rxBleConnection = this.rxBleConnectionProvider.get();
        this.gattWriteMtuOverheadProvider.get().intValue();
        return new MtuBasedPayloadSizeLimit(rxBleConnection);
    }
}
