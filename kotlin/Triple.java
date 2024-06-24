package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tuples.kt */
/* loaded from: classes.dex */
public final class Triple<A, B, C> implements Serializable {
    public final A first;
    public final B second;
    public final C third;

    public Triple(A a, B b, C c) {
        this.first = a;
        this.second = b;
        this.third = c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        if (Intrinsics.areEqual(this.first, triple.first) && Intrinsics.areEqual(this.second, triple.second) && Intrinsics.areEqual(this.third, triple.third)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int r0 = 0;
        A a = this.first;
        if (a == null) {
            hashCode = 0;
        } else {
            hashCode = a.hashCode();
        }
        int r1 = hashCode * 31;
        B b = this.second;
        if (b == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = b.hashCode();
        }
        int r12 = (r1 + hashCode2) * 31;
        C c = this.third;
        if (c != null) {
            r0 = c.hashCode();
        }
        return r12 + r0;
    }

    public final String toString() {
        return "(" + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
