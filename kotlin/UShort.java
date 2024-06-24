package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: UShort.kt */
/* loaded from: classes.dex */
public final class UShort implements Comparable<UShort> {
    public final short data;

    public /* synthetic */ UShort(short s) {
        this.data = s;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1665toStringimpl(short s) {
        return String.valueOf(s & 65535);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(this.data & 65535, uShort.data & 65535);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof UShort)) {
            return false;
        }
        if (this.data != ((UShort) obj).data) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Short.hashCode(this.data);
    }

    public final String toString() {
        return m1665toStringimpl(this.data);
    }
}
