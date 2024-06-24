package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.DaggerClientComponent$DeviceComponentImpl;
import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import io.reactivex.Scheduler;

/* loaded from: classes3.dex */
public final class ConnectorImpl_Factory implements Provider {
    public final Provider<Scheduler> callbacksSchedulerProvider;
    public final Provider<ClientOperationQueue> clientOperationQueueProvider;
    public final Provider<ConnectionComponent.Builder> connectionComponentBuilderProvider;

    public ConnectorImpl_Factory(Provider provider, DaggerClientComponent$DeviceComponentImpl.AnonymousClass1 anonymousClass1, Provider provider2) {
        this.clientOperationQueueProvider = provider;
        this.connectionComponentBuilderProvider = anonymousClass1;
        this.callbacksSchedulerProvider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ConnectorImpl(this.clientOperationQueueProvider.get(), this.connectionComponentBuilderProvider.get(), this.callbacksSchedulerProvider.get());
    }
}
