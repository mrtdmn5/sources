package androidx.compose.runtime.snapshots;

import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public final class Snapshot$Companion$registerApplyObserver$2 implements ObserverHandle {
    public final /* synthetic */ Function2<Set<? extends Object>, Snapshot, Unit> $observer;

    /* JADX WARN: Multi-variable type inference failed */
    public Snapshot$Companion$registerApplyObserver$2(Function2<? super Set<? extends Object>, ? super Snapshot, Unit> function2) {
        this.$observer = function2;
    }

    @Override // androidx.compose.runtime.snapshots.ObserverHandle
    public final void dispose() {
        Function2<Set<? extends Object>, Snapshot, Unit> function2 = this.$observer;
        synchronized (SnapshotKt.lock) {
            SnapshotKt.applyObservers.remove(function2);
            Unit unit = Unit.INSTANCE;
        }
    }
}
