package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;

/* compiled from: DerivedState.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class SnapshotStateKt__DerivedStateKt {
    public static final SnapshotThreadLocal<Integer> calculationBlockNestedLevel = new SnapshotThreadLocal<>();
    public static final SnapshotThreadLocal<MutableVector<DerivedStateObserver>> derivedStateObservers = new SnapshotThreadLocal<>();
}
