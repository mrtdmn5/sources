package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideComputationSchedulerFactory;
import io.reactivex.Scheduler;

/* loaded from: classes3.dex */
public final class ScanSettingsEmulator_Factory implements Provider {
    public final Provider<Scheduler> schedulerProvider = ClientComponent_ClientModule_ProvideComputationSchedulerFactory.InstanceHolder.INSTANCE;

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ScanSettingsEmulator(this.schedulerProvider.get());
    }
}
