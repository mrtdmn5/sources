package com.polidea.rxandroidble2.internal;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideComputationSchedulerFactory;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import io.reactivex.Scheduler;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class DeviceModule_ProvidesDisconnectTimeoutConfFactory implements Provider {
    public final Provider<Scheduler> timeoutSchedulerProvider = ClientComponent_ClientModule_ProvideComputationSchedulerFactory.InstanceHolder.INSTANCE;

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new TimeoutConfiguration(10L, TimeUnit.SECONDS, this.timeoutSchedulerProvider.get());
    }
}
