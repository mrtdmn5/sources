package androidx.compose.runtime;

/* compiled from: SnapshotMutationPolicy.kt */
/* loaded from: classes.dex */
public final class NeverEqualPolicy implements SnapshotMutationPolicy<Object> {
    public static final NeverEqualPolicy INSTANCE = new NeverEqualPolicy();

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public final boolean equivalent(Object obj, Object obj2) {
        return false;
    }

    public final String toString() {
        return "NeverEqualPolicy";
    }
}
