package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class DefaultScheduler implements Scheduler {
    public static final Logger LOGGER = Logger.getLogger(TransportRuntime.class.getName());
    public final BackendRegistry backendRegistry;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final WorkScheduler workScheduler;

    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.backendRegistry = backendRegistry;
        this.workScheduler = workScheduler;
        this.eventStore = eventStore;
        this.guard = synchronizationGuard;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.Scheduler
    public final void schedule(final TransportScheduleCallback transportScheduleCallback, final AutoValue_EventInternal autoValue_EventInternal, final AutoValue_TransportContext autoValue_TransportContext) {
        this.executor.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.DefaultScheduler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                final TransportContext transportContext = autoValue_TransportContext;
                TransportScheduleCallback transportScheduleCallback2 = transportScheduleCallback;
                EventInternal eventInternal = autoValue_EventInternal;
                final DefaultScheduler defaultScheduler = DefaultScheduler.this;
                defaultScheduler.getClass();
                Logger logger = DefaultScheduler.LOGGER;
                try {
                    TransportBackend transportBackend = defaultScheduler.backendRegistry.get(transportContext.getBackendName());
                    if (transportBackend == null) {
                        String format = String.format("Transport backend '%s' is not registered", transportContext.getBackendName());
                        logger.warning(format);
                        transportScheduleCallback2.onSchedule(new IllegalArgumentException(format));
                    } else {
                        final AutoValue_EventInternal decorate = transportBackend.decorate(eventInternal);
                        defaultScheduler.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.DefaultScheduler$$ExternalSyntheticLambda1
                            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                            public final Object execute() {
                                DefaultScheduler defaultScheduler2 = DefaultScheduler.this;
                                EventStore eventStore = defaultScheduler2.eventStore;
                                EventInternal eventInternal2 = decorate;
                                TransportContext transportContext2 = transportContext;
                                eventStore.persist(transportContext2, eventInternal2);
                                defaultScheduler2.workScheduler.schedule(transportContext2, 1);
                                return null;
                            }
                        });
                        transportScheduleCallback2.onSchedule(null);
                    }
                } catch (Exception e) {
                    logger.warning("Error scheduling event " + e.getMessage());
                    transportScheduleCallback2.onSchedule(e);
                }
            }
        });
    }
}
