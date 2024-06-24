package androidx.compose.ui.graphics;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.UnsignedKt;

/* compiled from: Color.kt */
/* loaded from: classes.dex */
public final class Color {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final long value;
    public static final long Black = ColorKt.Color(4278190080L);
    public static final long DarkGray = ColorKt.Color(4282664004L);
    public static final long Gray = ColorKt.Color(4287137928L);
    public static final long LightGray = ColorKt.Color(4291611852L);
    public static final long White = ColorKt.Color(4294967295L);
    public static final long Red = ColorKt.Color(4294901760L);
    public static final long Green = ColorKt.Color(4278255360L);
    public static final long Blue = ColorKt.Color(4278190335L);
    public static final long Yellow = ColorKt.Color(4294967040L);
    public static final long Cyan = ColorKt.Color(4278255615L);
    public static final long Magenta = ColorKt.Color(4294902015L);
    public static final long Transparent = ColorKt.Color(0);
    public static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.Unspecified);

    public /* synthetic */ Color(long j) {
        this.value = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* renamed from: convert-vNxB06k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long m315convertvNxB06k(long r7, androidx.compose.ui.graphics.colorspace.ColorSpace r9) {
        /*
            java.lang.String r0 = "colorSpace"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            androidx.compose.ui.graphics.colorspace.ColorSpace r0 = m320getColorSpaceimpl(r7)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r0)
            if (r1 == 0) goto L10
            return r7
        L10:
            java.lang.String r1 = "$this$connect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            androidx.compose.ui.graphics.colorspace.Rgb r1 = androidx.compose.ui.graphics.colorspace.ColorSpaces.Srgb
            if (r0 != r1) goto L25
            if (r9 != r1) goto L1e
            androidx.compose.ui.graphics.colorspace.Connector$Companion$identity$1 r9 = androidx.compose.ui.graphics.colorspace.Connector.SrgbIdentity
            goto L5b
        L1e:
            androidx.compose.ui.graphics.colorspace.Oklab r1 = androidx.compose.ui.graphics.colorspace.ColorSpaces.Oklab
            if (r9 != r1) goto L2e
            androidx.compose.ui.graphics.colorspace.Connector r9 = androidx.compose.ui.graphics.colorspace.Connector.SrgbToOklabPerceptual
            goto L5b
        L25:
            androidx.compose.ui.graphics.colorspace.Oklab r2 = androidx.compose.ui.graphics.colorspace.ColorSpaces.Oklab
            if (r0 != r2) goto L2e
            if (r9 != r1) goto L2e
            androidx.compose.ui.graphics.colorspace.Connector r9 = androidx.compose.ui.graphics.colorspace.Connector.OklabToSrgbPerceptual
            goto L5b
        L2e:
            if (r0 != r9) goto L38
            androidx.compose.ui.graphics.colorspace.Connector$Companion$identity$1 r9 = androidx.compose.ui.graphics.colorspace.Connector.SrgbIdentity
            androidx.compose.ui.graphics.colorspace.Connector$Companion$identity$1 r9 = new androidx.compose.ui.graphics.colorspace.Connector$Companion$identity$1
            r9.<init>(r0)
            goto L5b
        L38:
            long r1 = androidx.compose.ui.graphics.colorspace.ColorModel.Rgb
            long r3 = r0.model
            boolean r3 = androidx.compose.ui.graphics.colorspace.ColorModel.m348equalsimpl0(r3, r1)
            r4 = 0
            if (r3 == 0) goto L55
            long r5 = r9.model
            boolean r1 = androidx.compose.ui.graphics.colorspace.ColorModel.m348equalsimpl0(r5, r1)
            if (r1 == 0) goto L55
            androidx.compose.ui.graphics.colorspace.Connector$RgbConnector r1 = new androidx.compose.ui.graphics.colorspace.Connector$RgbConnector
            androidx.compose.ui.graphics.colorspace.Rgb r0 = (androidx.compose.ui.graphics.colorspace.Rgb) r0
            androidx.compose.ui.graphics.colorspace.Rgb r9 = (androidx.compose.ui.graphics.colorspace.Rgb) r9
            r1.<init>(r0, r9, r4)
            goto L5a
        L55:
            androidx.compose.ui.graphics.colorspace.Connector r1 = new androidx.compose.ui.graphics.colorspace.Connector
            r1.<init>(r0, r9, r4)
        L5a:
            r9 = r1
        L5b:
            float r0 = m322getRedimpl(r7)
            float r1 = m321getGreenimpl(r7)
            float r2 = m319getBlueimpl(r7)
            float r7 = m318getAlphaimpl(r7)
            long r7 = r9.mo351transformToColorwmQWz5c$ui_graphics_release(r0, r1, r2, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.Color.m315convertvNxB06k(long, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    /* renamed from: copy-wmQWz5c$default */
    public static long m316copywmQWz5c$default(long j, float f) {
        return ColorKt.Color(m322getRedimpl(j), m321getGreenimpl(j), m319getBlueimpl(j), f, m320getColorSpaceimpl(j));
    }

    /* renamed from: equals-impl0 */
    public static final boolean m317equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: getAlpha-impl */
    public static final float m318getAlphaimpl(long j) {
        float ulongToDouble;
        float f;
        if ((63 & j) == 0) {
            ulongToDouble = (float) UnsignedKt.ulongToDouble((j >>> 56) & 255);
            f = 255.0f;
        } else {
            ulongToDouble = (float) UnsignedKt.ulongToDouble((j >>> 6) & 1023);
            f = 1023.0f;
        }
        return ulongToDouble / f;
    }

    /* renamed from: getBlue-impl */
    public static final float m319getBlueimpl(long j) {
        if ((63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble((j >>> 32) & 255)) / 255.0f;
        }
        return Float16.m330toFloatimpl((short) ((j >>> 16) & 65535));
    }

    /* renamed from: getColorSpace-impl */
    public static final ColorSpace m320getColorSpaceimpl(long j) {
        float[] fArr = ColorSpaces.SrgbPrimaries;
        return ColorSpaces.ColorSpacesArray[(int) (j & 63)];
    }

    /* renamed from: getGreen-impl */
    public static final float m321getGreenimpl(long j) {
        if ((63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble((j >>> 40) & 255)) / 255.0f;
        }
        return Float16.m330toFloatimpl((short) ((j >>> 32) & 65535));
    }

    /* renamed from: getRed-impl */
    public static final float m322getRedimpl(long j) {
        if ((63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble((j >>> 48) & 255)) / 255.0f;
        }
        return Float16.m330toFloatimpl((short) ((j >>> 48) & 65535));
    }

    /* renamed from: toString-impl */
    public static String m323toStringimpl(long j) {
        StringBuilder sb = new StringBuilder("Color(");
        sb.append(m322getRedimpl(j));
        sb.append(", ");
        sb.append(m321getGreenimpl(j));
        sb.append(", ");
        sb.append(m319getBlueimpl(j));
        sb.append(", ");
        sb.append(m318getAlphaimpl(j));
        sb.append(", ");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, m320getColorSpaceimpl(j).name, ')');
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Color)) {
            return false;
        }
        if (this.value != ((Color) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.value);
    }

    public final String toString() {
        return m323toStringimpl(this.value);
    }
}
