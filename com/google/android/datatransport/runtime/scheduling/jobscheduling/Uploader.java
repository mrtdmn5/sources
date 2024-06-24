package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class Uploader {
    public final BackendRegistry backendRegistry;
    public final ClientHealthMetricsStore clientHealthMetricsStore;
    public final Clock clock;
    public final Context context;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final Clock uptimeClock;
    public final WorkScheduler workScheduler;

    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.context = context;
        this.backendRegistry = backendRegistry;
        this.eventStore = eventStore;
        this.workScheduler = workScheduler;
        this.executor = executor;
        this.guard = synchronizationGuard;
        this.clock = clock;
        this.uptimeClock = clock2;
        this.clientHealthMetricsStore = clientHealthMetricsStore;
    }

    public final void logAndUpdateState(final TransportContext transportContext, int r18) {
        boolean z;
        AutoValue_BackendResponse send;
        TransportBackend transportBackend = this.backendRegistry.get(transportContext.getBackendName());
        new AutoValue_BackendResponse(BackendResponse.Status.OK, 0L);
        final long j = 0;
        while (true) {
            SynchronizationGuard.CriticalSection criticalSection = new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda3
                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    return Boolean.valueOf(Uploader.this.eventStore.hasPendingEventsFor(transportContext));
                }
            };
            SynchronizationGuard synchronizationGuard = this.guard;
            if (((Boolean) synchronizationGuard.runCriticalSection(criticalSection)).booleanValue()) {
                final Iterable iterable = (Iterable) synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda4
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        return Uploader.this.eventStore.loadBatch(transportContext);
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return;
                }
                boolean z2 = false;
                if (transportBackend == null) {
                    Logging.d(transportContext, "Uploader", "Unknown backend for %s, deleting event batch for it...");
                    send = new AutoValue_BackendResponse(BackendResponse.Status.FATAL_ERROR, -1L);
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((PersistedEvent) it.next()).getEvent());
                    }
                    if (transportContext.getExtras() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        final ClientHealthMetricsStore clientHealthMetricsStore = this.clientHealthMetricsStore;
                        Objects.requireNonNull(clientHealthMetricsStore);
                        ClientMetrics clientMetrics = (ClientMetrics) synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda9
                            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                            public final Object execute() {
                                return ClientHealthMetricsStore.this.loadClientMetrics();
                            }
                        });
                        AutoValue_EventInternal.Builder builder = new AutoValue_EventInternal.Builder();
                        builder.autoMetadata = new HashMap();
                        builder.eventMillis = Long.valueOf(this.clock.getTime());
                        builder.uptimeMillis = Long.valueOf(this.uptimeClock.getTime());
                        builder.setTransportName("GDT_CLIENT_METRICS");
                        Encoding encoding = new Encoding("proto");
                        clientMetrics.getClass();
                        ProtobufEncoder protobufEncoder = ProtoEncoderDoNotUse.ENCODER;
                        protobufEncoder.getClass();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            protobufEncoder.encode(clientMetrics, byteArrayOutputStream);
                        } catch (IOException unused) {
                        }
                        builder.setEncodedPayload(new EncodedPayload(encoding, byteArrayOutputStream.toByteArray()));
                        arrayList.add(transportBackend.decorate(builder.build()));
                    }
                    send = transportBackend.send(new AutoValue_BackendRequest(arrayList, transportContext.getExtras()));
                }
                if (send.status == BackendResponse.Status.TRANSIENT_ERROR) {
                    synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda5
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Uploader uploader = Uploader.this;
                            EventStore eventStore = uploader.eventStore;
                            eventStore.recordFailure(iterable);
                            eventStore.recordNextCallTime(uploader.clock.getTime() + j, transportContext);
                            return null;
                        }
                    });
                    this.workScheduler.schedule(transportContext, r18 + 1, true);
                    return;
                }
                synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda6
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        Uploader.this.eventStore.recordSuccess(iterable);
                        return null;
                    }
                });
                BackendResponse.Status status = BackendResponse.Status.OK;
                BackendResponse.Status status2 = send.status;
                if (status2 == status) {
                    j = Math.max(j, send.nextRequestWaitMillis);
                    if (transportContext.getExtras() != null) {
                        z2 = true;
                    }
                    if (z2) {
                        synchronizationGuard.runCriticalSection(new InputConnectionCompat$$ExternalSyntheticLambda0(this));
                    }
                } else if (status2 == BackendResponse.Status.INVALID_PAYLOAD) {
                    final HashMap hashMap = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String transportName = ((PersistedEvent) it2.next()).getEvent().getTransportName();
                        if (!hashMap.containsKey(transportName)) {
                            hashMap.put(transportName, 1);
                        } else {
                            hashMap.put(transportName, Integer.valueOf(((Integer) hashMap.get(transportName)).intValue() + 1));
                        }
                    }
                    synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda7
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Uploader uploader = Uploader.this;
                            uploader.getClass();
                            Iterator it3 = hashMap.entrySet().iterator();
                            while (it3.hasNext()) {
                                uploader.clientHealthMetricsStore.recordLogEventDropped(((Integer) r2.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) ((Map.Entry) it3.next()).getKey());
                            }
                            return null;
                        }
                    });
                }
            } else {
                synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda8
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        Uploader uploader = Uploader.this;
                        uploader.eventStore.recordNextCallTime(uploader.clock.getTime() + j, transportContext);
                        return null;
                    }
                });
                return;
            }
        }
    }
}
