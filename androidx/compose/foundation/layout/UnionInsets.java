package androidx.compose.foundation.layout;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsets.kt */
/* loaded from: classes.dex */
public final class UnionInsets implements WindowInsets {
    public final WindowInsets first;
    public final WindowInsets second;

    public UnionInsets(WindowInsets windowInsets, WindowInsets windowInsets2) {
        this.first = windowInsets;
        this.second = windowInsets2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnionInsets)) {
            return false;
        }
        UnionInsets unionInsets = (UnionInsets) obj;
        if (Intrinsics.areEqual(unionInsets.first, this.first) && Intrinsics.areEqual(unionInsets.second, this.second)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.second.hashCode() * 31) + this.first.hashCode();
    }

    public final String toString() {
        return "(" + this.first + " ∪ " + this.second + ')';
    }
}
