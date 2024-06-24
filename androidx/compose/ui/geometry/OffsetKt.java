package androidx.compose.ui.geometry;

import kotlinx.coroutines.YieldKt;

/* compiled from: Offset.kt */
/* loaded from: classes.dex */
public final class OffsetKt {
    public static final long Offset(float f, float f2) {
        long floatToIntBits = (Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32);
        int r0 = Offset.$r8$clinit;
        return floatToIntBits;
    }

    /* renamed from: isFinite-k-4lQ0M, reason: not valid java name */
    public static final boolean m265isFinitek4lQ0M(long j) {
        boolean z;
        boolean z2;
        float m259getXimpl = Offset.m259getXimpl(j);
        if (!Float.isInfinite(m259getXimpl) && !Float.isNaN(m259getXimpl)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            float m260getYimpl = Offset.m260getYimpl(j);
            if (!Float.isInfinite(m260getYimpl) && !Float.isNaN(m260getYimpl)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: isSpecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m266isSpecifiedk4lQ0M(long j) {
        int r0 = Offset.$r8$clinit;
        if (j != Offset.Unspecified) {
            return true;
        }
        return false;
    }

    /* renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m267lerpWko1d7g(long j, long j2, float f) {
        return Offset(YieldKt.lerp(Offset.m259getXimpl(j), Offset.m259getXimpl(j2), f), YieldKt.lerp(Offset.m260getYimpl(j), Offset.m260getYimpl(j2), f));
    }
}
