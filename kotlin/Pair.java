package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tuples.kt */
/* loaded from: classes.dex */
public final class Pair<A, B> implements Serializable {
    public final A first;
    public final B second;

    public Pair(A a, B b) {
        this.first = a;
        this.second = b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (Intrinsics.areEqual(this.first, pair.first) && Intrinsics.areEqual(this.second, pair.second)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int r0 = 0;
        A a = this.first;
        if (a == null) {
            hashCode = 0;
        } else {
            hashCode = a.hashCode();
        }
        int r1 = hashCode * 31;
        B b = this.second;
        if (b != null) {
            r0 = b.hashCode();
        }
        return r1 + r0;
    }

    public final String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }
}
