package androidx.compose.foundation.shape;

/* compiled from: RoundedCornerShape.kt */
/* loaded from: classes.dex */
public final class RoundedCornerShapeKt {
    public static final RoundedCornerShape CircleShape;

    static {
        PercentCornerSize percentCornerSize = new PercentCornerSize(50);
        CircleShape = new RoundedCornerShape(percentCornerSize, percentCornerSize, percentCornerSize, percentCornerSize);
    }

    /* renamed from: RoundedCornerShape-0680j_4, reason: not valid java name */
    public static final RoundedCornerShape m112RoundedCornerShape0680j_4(float f) {
        DpCornerSize dpCornerSize = new DpCornerSize(f);
        return new RoundedCornerShape(dpCornerSize, dpCornerSize, dpCornerSize, dpCornerSize);
    }
}
