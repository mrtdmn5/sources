package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotMutationPolicy.kt */
/* loaded from: classes.dex */
public final class StructuralEqualityPolicy implements SnapshotMutationPolicy<Object> {
    public static final StructuralEqualityPolicy INSTANCE = new StructuralEqualityPolicy();

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public final boolean equivalent(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public final String toString() {
        return "StructuralEqualityPolicy";
    }
}
