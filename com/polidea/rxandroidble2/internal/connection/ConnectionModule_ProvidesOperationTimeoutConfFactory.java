package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideComputationSchedulerFactory;
import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import io.reactivex.Scheduler;

/* loaded from: classes3.dex */
public final class ConnectionModule_ProvidesOperationTimeoutConfFactory implements Provider {
    public final Provider<Timeout> operationTimeoutProvider;
    public final Provider<Scheduler> timeoutSchedulerProvider = ClientComponent_ClientModule_ProvideComputationSchedulerFactory.InstanceHolder.INSTANCE;

    public ConnectionModule_ProvidesOperationTimeoutConfFactory(InstanceFactory instanceFactory) {
        this.operationTimeoutProvider = instanceFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        Scheduler scheduler = this.timeoutSchedulerProvider.get();
        Timeout timeout = this.operationTimeoutProvider.get();
        return new TimeoutConfiguration(timeout.timeout, timeout.timeUnit, scheduler);
    }
}
