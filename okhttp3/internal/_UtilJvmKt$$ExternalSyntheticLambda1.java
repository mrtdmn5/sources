package okhttp3.internal;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class _UtilJvmKt$$ExternalSyntheticLambda1 implements SynchronizationGuard.CriticalSection, EventListener.Factory {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ _UtilJvmKt$$ExternalSyntheticLambda1(Object obj) {
        this.f$0 = obj;
    }

    @Override // okhttp3.EventListener.Factory
    public final EventListener create(Call it) {
        EventListener this_asFactory = (EventListener) this.f$0;
        Intrinsics.checkNotNullParameter(this_asFactory, "$this_asFactory");
        Intrinsics.checkNotNullParameter(it, "it");
        return this_asFactory;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public final Object execute() {
        WorkInitializer workInitializer = (WorkInitializer) this.f$0;
        Iterator<TransportContext> it = workInitializer.store.loadActiveContexts().iterator();
        while (it.hasNext()) {
            workInitializer.scheduler.schedule(it.next(), 1);
        }
        return null;
    }
}
