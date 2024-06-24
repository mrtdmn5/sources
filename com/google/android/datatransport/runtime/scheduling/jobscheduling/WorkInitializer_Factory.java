package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class WorkInitializer_Factory implements Factory<WorkInitializer> {
    public final Provider<Executor> executorProvider;
    public final Provider<SynchronizationGuard> guardProvider;
    public final Provider<WorkScheduler> schedulerProvider;
    public final Provider<EventStore> storeProvider;

    public WorkInitializer_Factory(Provider provider, Provider provider2, SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactory, Provider provider3) {
        this.executorProvider = provider;
        this.storeProvider = provider2;
        this.schedulerProvider = schedulingModule_WorkSchedulerFactory;
        this.guardProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new WorkInitializer(this.executorProvider.get(), this.storeProvider.get(), this.schedulerProvider.get(), this.guardProvider.get());
    }
}
