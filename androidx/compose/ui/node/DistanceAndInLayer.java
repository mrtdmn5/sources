package androidx.compose.ui.node;

/* compiled from: HitTestResult.kt */
/* loaded from: classes.dex */
public final class DistanceAndInLayer {
    /* renamed from: compareTo-S_HNhKs, reason: not valid java name */
    public static final int m442compareToS_HNhKs(long j, long j2) {
        boolean m443isInLayerimpl = m443isInLayerimpl(j);
        if (m443isInLayerimpl != m443isInLayerimpl(j2)) {
            if (m443isInLayerimpl) {
                return -1;
            }
            return 1;
        }
        return (int) Math.signum(Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32)));
    }

    /* renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m443isInLayerimpl(long j) {
        if (((int) (j & 4294967295L)) != 0) {
            return true;
        }
        return false;
    }
}
