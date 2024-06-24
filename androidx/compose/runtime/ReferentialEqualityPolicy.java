package androidx.compose.runtime;

/* compiled from: SnapshotMutationPolicy.kt */
/* loaded from: classes.dex */
public final class ReferentialEqualityPolicy implements SnapshotMutationPolicy<Object> {
    public static final ReferentialEqualityPolicy INSTANCE = new ReferentialEqualityPolicy();

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public final boolean equivalent(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "ReferentialEqualityPolicy";
    }
}
