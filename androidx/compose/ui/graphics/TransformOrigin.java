package androidx.compose.ui.graphics;

/* compiled from: TransformOrigin.kt */
/* loaded from: classes.dex */
public final class TransformOrigin {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Center = TransformOriginKt.TransformOrigin(0.5f, 0.5f);
    public final long packedValue;

    /* renamed from: getPivotFractionY-impl, reason: not valid java name */
    public static final float m345getPivotFractionYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m346toStringimpl(long j) {
        return "TransformOrigin(packedValue=" + j + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TransformOrigin)) {
            return false;
        }
        if (this.packedValue != ((TransformOrigin) obj).packedValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m346toStringimpl(this.packedValue);
    }
}
