package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothInteractionSchedulerFactory implements Provider {
    public final Provider<ExecutorService> serviceProvider;

    public ClientComponent_ClientModule_ProvideBluetoothInteractionSchedulerFactory(Provider<ExecutorService> provider) {
        this.serviceProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        ExecutorService executorService = this.serviceProvider.get();
        Scheduler scheduler = Schedulers.SINGLE;
        return new ExecutorScheduler(executorService);
    }
}
