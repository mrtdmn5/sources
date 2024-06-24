package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: UInt.kt */
/* loaded from: classes.dex */
public final class UInt implements Comparable<UInt> {
    public final int data;

    public /* synthetic */ UInt(int r1) {
        this.data = r1;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1664toStringimpl(int r4) {
        return String.valueOf(r4 & 4294967295L);
    }

    @Override // java.lang.Comparable
    public final int compareTo(UInt uInt) {
        return Intrinsics.compare(this.data ^ Integer.MIN_VALUE, uInt.data ^ Integer.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof UInt)) {
            return false;
        }
        if (this.data != ((UInt) obj).data) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.data);
    }

    public final String toString() {
        return m1664toStringimpl(this.data);
    }
}
