package androidx.compose.ui.geometry;

/* compiled from: Offset.kt */
/* loaded from: classes.dex */
public final class Offset {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final long packedValue;
    public static final long Zero = OffsetKt.Offset(0.0f, 0.0f);
    public static final long Infinite = OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final long Unspecified = OffsetKt.Offset(Float.NaN, Float.NaN);

    /* renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static long m256copydBAh8RU$default(long j, int r4) {
        float f;
        float f2 = 0.0f;
        if ((r4 & 1) != 0) {
            f = m259getXimpl(j);
        } else {
            f = 0.0f;
        }
        if ((r4 & 2) != 0) {
            f2 = m260getYimpl(j);
        }
        return OffsetKt.Offset(f, f2);
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m257equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m258getDistanceimpl(long j) {
        return (float) Math.sqrt((m260getYimpl(j) * m260getYimpl(j)) + (m259getXimpl(j) * m259getXimpl(j)));
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m259getXimpl(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Float.intBitsToFloat((int) (j >> 32));
        }
        throw new IllegalStateException("Offset is unspecified".toString());
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m260getYimpl(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }
        throw new IllegalStateException("Offset is unspecified".toString());
    }

    /* renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m261minusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m259getXimpl(j) - m259getXimpl(j2), m260getYimpl(j) - m260getYimpl(j2));
    }

    /* renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m262plusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m259getXimpl(j2) + m259getXimpl(j), m260getYimpl(j2) + m260getYimpl(j));
    }

    /* renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m263timestuRUvjQ(float f, long j) {
        return OffsetKt.Offset(m259getXimpl(j) * f, m260getYimpl(j) * f);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m264toStringimpl(long j) {
        if (OffsetKt.m266isSpecifiedk4lQ0M(j)) {
            return "Offset(" + GeometryUtilsKt.toStringAsFixed(m259getXimpl(j)) + ", " + GeometryUtilsKt.toStringAsFixed(m260getYimpl(j)) + ')';
        }
        return "Offset.Unspecified";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Offset)) {
            return false;
        }
        if (this.packedValue != ((Offset) obj).packedValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m264toStringimpl(this.packedValue);
    }
}
