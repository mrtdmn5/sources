package kotlin;

/* compiled from: ULong.kt */
/* loaded from: classes.dex */
public final class ULong implements Comparable<ULong> {
    public final long data;

    public /* synthetic */ ULong(long j) {
        this.data = j;
    }

    @Override // java.lang.Comparable
    public final int compareTo(ULong uLong) {
        long j = uLong.data;
        long j2 = this.data ^ Long.MIN_VALUE;
        long j3 = j ^ Long.MIN_VALUE;
        if (j2 < j3) {
            return -1;
        }
        if (j2 == j3) {
            return 0;
        }
        return 1;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ULong)) {
            return false;
        }
        if (this.data != ((ULong) obj).data) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.data);
    }

    public final String toString() {
        return UnsignedKt.ulongToString(10, this.data);
    }
}
