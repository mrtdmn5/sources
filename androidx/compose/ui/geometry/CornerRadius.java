package androidx.compose.ui.geometry;

/* compiled from: CornerRadius.kt */
/* loaded from: classes.dex */
public final class CornerRadius {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Zero = CornerRadiusKt.CornerRadius(0.0f, 0.0f);

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m252equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m253getXimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m254getYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m255toStringimpl(long j) {
        boolean z;
        if (m253getXimpl(j) == m254getYimpl(j)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(m253getXimpl(j)) + ')';
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(m253getXimpl(j)) + ", " + GeometryUtilsKt.toStringAsFixed(m254getYimpl(j)) + ')';
    }
}
