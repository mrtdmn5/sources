package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SchedulingModule_WorkSchedulerFactory implements Factory<WorkScheduler> {
    public final Provider<Clock> clockProvider;
    public final Provider<SchedulerConfig> configProvider;
    public final Provider<Context> contextProvider;
    public final Provider<EventStore> eventStoreProvider;

    public SchedulingModule_WorkSchedulerFactory(Provider provider, Provider provider2, SchedulingConfigModule_ConfigFactory schedulingConfigModule_ConfigFactory) {
        TimeModule_UptimeClockFactory timeModule_UptimeClockFactory = TimeModule_UptimeClockFactory.InstanceHolder.INSTANCE;
        this.contextProvider = provider;
        this.eventStoreProvider = provider2;
        this.configProvider = schedulingConfigModule_ConfigFactory;
        this.clockProvider = timeModule_UptimeClockFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Context context = this.contextProvider.get();
        EventStore eventStore = this.eventStoreProvider.get();
        SchedulerConfig schedulerConfig = this.configProvider.get();
        this.clockProvider.get();
        return new JobInfoScheduler(context, eventStore, schedulerConfig);
    }
}
