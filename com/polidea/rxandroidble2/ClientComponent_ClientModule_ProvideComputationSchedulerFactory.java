package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideComputationSchedulerFactory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final ClientComponent_ClientModule_ProvideComputationSchedulerFactory INSTANCE = new ClientComponent_ClientModule_ProvideComputationSchedulerFactory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        Scheduler scheduler = Schedulers.COMPUTATION;
        UnsignedKt.checkNotNullFromProvides(scheduler);
        return scheduler;
    }
}
