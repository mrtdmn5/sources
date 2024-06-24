package com.polidea.rxandroidble2.internal.serialization;

import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.connection.DisconnectionRouterOutput;
import io.reactivex.Scheduler;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class ConnectionOperationQueueImpl_Factory implements Provider {
    public final Provider<Scheduler> callbackSchedulerProvider;
    public final Provider<String> deviceMacAddressProvider;
    public final Provider<DisconnectionRouterOutput> disconnectionRouterOutputProvider;
    public final Provider<ExecutorService> executorServiceProvider;

    public ConnectionOperationQueueImpl_Factory(InstanceFactory instanceFactory, Provider provider, Provider provider2, Provider provider3) {
        this.deviceMacAddressProvider = instanceFactory;
        this.disconnectionRouterOutputProvider = provider;
        this.executorServiceProvider = provider2;
        this.callbackSchedulerProvider = provider3;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ConnectionOperationQueueImpl(this.deviceMacAddressProvider.get(), this.disconnectionRouterOutputProvider.get(), this.executorServiceProvider.get(), this.callbackSchedulerProvider.get());
    }
}
