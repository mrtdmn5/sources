package androidx.compose.ui.layout;

/* compiled from: ScaleFactor.kt */
/* loaded from: classes.dex */
public final class ScaleFactor {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Unspecified = ScaleFactorKt.ScaleFactor(Float.NaN, Float.NaN);

    /* renamed from: getScaleX-impl, reason: not valid java name */
    public static final float m437getScaleXimpl(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Float.intBitsToFloat((int) (j >> 32));
        }
        throw new IllegalStateException("ScaleFactor is unspecified".toString());
    }

    /* renamed from: getScaleY-impl, reason: not valid java name */
    public static final float m438getScaleYimpl(long j) {
        boolean z;
        if (j != Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }
        throw new IllegalStateException("ScaleFactor is unspecified".toString());
    }
}
