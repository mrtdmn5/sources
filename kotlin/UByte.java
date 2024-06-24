package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: UByte.kt */
/* loaded from: classes.dex */
public final class UByte implements Comparable<UByte> {
    public final byte data;

    public /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1663toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.compare(this.data & 255, uByte.data & 255);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof UByte)) {
            return false;
        }
        if (this.data != ((UByte) obj).data) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Byte.hashCode(this.data);
    }

    public final String toString() {
        return m1663toStringimpl(this.data);
    }
}
