package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideComputationSchedulerFactory;
import io.reactivex.Scheduler;

/* loaded from: classes3.dex */
public final class ScanPreconditionsVerifierApi24_Factory implements Provider {
    public final Provider<ScanPreconditionsVerifierApi18> scanPreconditionVerifierApi18Provider;
    public final Provider<Scheduler> timeSchedulerProvider;

    public ScanPreconditionsVerifierApi24_Factory(ScanPreconditionsVerifierApi18_Factory scanPreconditionsVerifierApi18_Factory) {
        ClientComponent_ClientModule_ProvideComputationSchedulerFactory clientComponent_ClientModule_ProvideComputationSchedulerFactory = ClientComponent_ClientModule_ProvideComputationSchedulerFactory.InstanceHolder.INSTANCE;
        this.scanPreconditionVerifierApi18Provider = scanPreconditionsVerifierApi18_Factory;
        this.timeSchedulerProvider = clientComponent_ClientModule_ProvideComputationSchedulerFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ScanPreconditionsVerifierApi24(this.scanPreconditionVerifierApi18Provider.get(), this.timeSchedulerProvider.get());
    }
}
