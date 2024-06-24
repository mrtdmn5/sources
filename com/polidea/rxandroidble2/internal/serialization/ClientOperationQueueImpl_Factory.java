package com.polidea.rxandroidble2.internal.serialization;

import bleshadow.javax.inject.Provider;
import io.reactivex.Scheduler;

/* loaded from: classes3.dex */
public final class ClientOperationQueueImpl_Factory implements Provider {
    public final Provider<Scheduler> callbackSchedulerProvider;

    public ClientOperationQueueImpl_Factory(Provider<Scheduler> provider) {
        this.callbackSchedulerProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ClientOperationQueueImpl(this.callbackSchedulerProvider.get());
    }
}
