package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class Uploader_Factory implements Factory<Uploader> {
    public final Provider<BackendRegistry> backendRegistryProvider;
    public final Provider<ClientHealthMetricsStore> clientHealthMetricsStoreProvider;
    public final Provider<Clock> clockProvider;
    public final Provider<Context> contextProvider;
    public final Provider<EventStore> eventStoreProvider;
    public final Provider<Executor> executorProvider;
    public final Provider<SynchronizationGuard> guardProvider;
    public final Provider<Clock> uptimeClockProvider;
    public final Provider<WorkScheduler> workSchedulerProvider;

    public Uploader_Factory(Provider provider, Provider provider2, Provider provider3, SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactory, Provider provider4, Provider provider5, Provider provider6) {
        TimeModule_EventClockFactory timeModule_EventClockFactory = TimeModule_EventClockFactory.InstanceHolder.INSTANCE;
        TimeModule_UptimeClockFactory timeModule_UptimeClockFactory = TimeModule_UptimeClockFactory.InstanceHolder.INSTANCE;
        this.contextProvider = provider;
        this.backendRegistryProvider = provider2;
        this.eventStoreProvider = provider3;
        this.workSchedulerProvider = schedulingModule_WorkSchedulerFactory;
        this.executorProvider = provider4;
        this.guardProvider = provider5;
        this.clockProvider = timeModule_EventClockFactory;
        this.uptimeClockProvider = timeModule_UptimeClockFactory;
        this.clientHealthMetricsStoreProvider = provider6;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new Uploader(this.contextProvider.get(), this.backendRegistryProvider.get(), this.eventStoreProvider.get(), this.workSchedulerProvider.get(), this.executorProvider.get(), this.guardProvider.get(), this.clockProvider.get(), this.uptimeClockProvider.get(), this.clientHealthMetricsStoreProvider.get());
    }
}
