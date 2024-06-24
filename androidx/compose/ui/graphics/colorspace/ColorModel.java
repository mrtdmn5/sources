package androidx.compose.ui.graphics.colorspace;

/* compiled from: ColorModel.kt */
/* loaded from: classes.dex */
public final class ColorModel {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Cmyk;
    public static final long Lab;
    public static final long Rgb;
    public static final long Xyz;

    static {
        long j = 3;
        long j2 = j << 32;
        Rgb = (0 & 4294967295L) | j2;
        Xyz = (1 & 4294967295L) | j2;
        Lab = j2 | (2 & 4294967295L);
        Cmyk = (j & 4294967295L) | (4 << 32);
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m348equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m349toStringimpl(long j) {
        if (m348equalsimpl0(j, Rgb)) {
            return "Rgb";
        }
        if (m348equalsimpl0(j, Xyz)) {
            return "Xyz";
        }
        if (m348equalsimpl0(j, Lab)) {
            return "Lab";
        }
        if (m348equalsimpl0(j, Cmyk)) {
            return "Cmyk";
        }
        return "Unknown";
    }
}
