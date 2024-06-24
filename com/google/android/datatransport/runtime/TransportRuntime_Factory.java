package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TransportRuntime_Factory implements Factory<TransportRuntime> {
    public final Provider<Clock> eventClockProvider;
    public final Provider<WorkInitializer> initializerProvider;
    public final Provider<Scheduler> schedulerProvider;
    public final Provider<Uploader> uploaderProvider;
    public final Provider<Clock> uptimeClockProvider;

    public TransportRuntime_Factory(DefaultScheduler_Factory defaultScheduler_Factory, Uploader_Factory uploader_Factory, WorkInitializer_Factory workInitializer_Factory) {
        TimeModule_EventClockFactory timeModule_EventClockFactory = TimeModule_EventClockFactory.InstanceHolder.INSTANCE;
        TimeModule_UptimeClockFactory timeModule_UptimeClockFactory = TimeModule_UptimeClockFactory.InstanceHolder.INSTANCE;
        this.eventClockProvider = timeModule_EventClockFactory;
        this.uptimeClockProvider = timeModule_UptimeClockFactory;
        this.schedulerProvider = defaultScheduler_Factory;
        this.uploaderProvider = uploader_Factory;
        this.initializerProvider = workInitializer_Factory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new TransportRuntime(this.eventClockProvider.get(), this.uptimeClockProvider.get(), this.schedulerProvider.get(), this.uploaderProvider.get(), this.initializerProvider.get());
    }
}
