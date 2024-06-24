package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Objects;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class Uploader$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Uploader f$0;
    public final /* synthetic */ TransportContext f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Runnable f$3;

    public /* synthetic */ Uploader$$ExternalSyntheticLambda0(Uploader uploader, AutoValue_TransportContext autoValue_TransportContext, int r3, Runnable runnable) {
        this.f$0 = uploader;
        this.f$1 = autoValue_TransportContext;
        this.f$2 = r3;
        this.f$3 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        final TransportContext transportContext = this.f$1;
        final int r1 = this.f$2;
        Runnable runnable = this.f$3;
        final Uploader uploader = this.f$0;
        SynchronizationGuard synchronizationGuard = uploader.guard;
        try {
            try {
                final EventStore eventStore = uploader.eventStore;
                Objects.requireNonNull(eventStore);
                synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda1
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        return Integer.valueOf(EventStore.this.cleanUp());
                    }
                });
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) uploader.context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda2
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Uploader.this.workScheduler.schedule(transportContext, r1 + 1);
                            return null;
                        }
                    });
                } else {
                    uploader.logAndUpdateState(transportContext, r1);
                }
            } catch (SynchronizationException unused) {
                uploader.workScheduler.schedule(transportContext, r1 + 1);
            }
        } finally {
            runnable.run();
        }
    }
}
