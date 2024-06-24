package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import io.reactivex.Scheduler;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideFinalizationCloseableFactory implements Provider {
    public final Provider<Scheduler> callbacksSchedulerProvider;
    public final Provider<ExecutorService> connectionQueueExecutorServiceProvider;
    public final Provider<ExecutorService> interactionExecutorServiceProvider;

    public ClientComponent_ClientModule_ProvideFinalizationCloseableFactory(Provider<ExecutorService> provider, Provider<Scheduler> provider2, Provider<ExecutorService> provider3) {
        this.interactionExecutorServiceProvider = provider;
        this.callbacksSchedulerProvider = provider2;
        this.connectionQueueExecutorServiceProvider = provider3;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        final ExecutorService executorService = this.interactionExecutorServiceProvider.get();
        final Scheduler scheduler = this.callbacksSchedulerProvider.get();
        final ExecutorService executorService2 = this.connectionQueueExecutorServiceProvider.get();
        return new ClientComponent$ClientComponentFinalizer() { // from class: com.polidea.rxandroidble2.ClientComponent$ClientModule$1
            @Override // com.polidea.rxandroidble2.ClientComponent$ClientComponentFinalizer
            public final void onFinalize() {
                executorService.shutdown();
                scheduler.shutdown();
                executorService2.shutdown();
            }
        };
    }
}
