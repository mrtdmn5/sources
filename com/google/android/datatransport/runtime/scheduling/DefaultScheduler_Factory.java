package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {
    public final Provider<BackendRegistry> backendRegistryProvider;
    public final Provider<EventStore> eventStoreProvider;
    public final Provider<Executor> executorProvider;
    public final Provider<SynchronizationGuard> guardProvider;
    public final Provider<WorkScheduler> workSchedulerProvider;

    public DefaultScheduler_Factory(Provider provider, Provider provider2, SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactory, Provider provider3, Provider provider4) {
        this.executorProvider = provider;
        this.backendRegistryProvider = provider2;
        this.workSchedulerProvider = schedulingModule_WorkSchedulerFactory;
        this.eventStoreProvider = provider3;
        this.guardProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new DefaultScheduler(this.executorProvider.get(), this.backendRegistryProvider.get(), this.workSchedulerProvider.get(), this.eventStoreProvider.get(), this.guardProvider.get());
    }
}
