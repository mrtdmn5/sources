package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlinx.coroutines.YieldKt;

/* compiled from: SpanStyle.kt */
/* loaded from: classes.dex */
public final class SpanStyleKt {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long DefaultBackgroundColor;
    public static final long DefaultColor;
    public static final long DefaultFontSize = TextUnitKt.getSp(14);
    public static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    static {
        int r0 = Color.$r8$clinit;
        DefaultBackgroundColor = Color.Transparent;
        DefaultColor = Color.Black;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x007f, code lost:            if (androidx.compose.ui.graphics.Color.m317equalsimpl0(r39, r4.mo553getColor0d7_KjU()) == false) goto L23;     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x024b A[RETURN] */
    /* renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.text.SpanStyle m517fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle r38, long r39, androidx.compose.ui.graphics.Brush r41, float r42, long r43, androidx.compose.ui.text.font.FontWeight r45, androidx.compose.ui.text.font.FontStyle r46, androidx.compose.ui.text.font.FontSynthesis r47, androidx.compose.ui.text.font.FontFamily r48, java.lang.String r49, long r50, androidx.compose.ui.text.style.BaselineShift r52, androidx.compose.ui.text.style.TextGeometricTransform r53, androidx.compose.ui.text.intl.LocaleList r54, long r55, androidx.compose.ui.text.style.TextDecoration r57, androidx.compose.ui.graphics.Shadow r58, androidx.compose.ui.text.PlatformSpanStyle r59, androidx.compose.ui.graphics.drawscope.DrawStyle r60) {
        /*
            Method dump skipped, instructions count: 746
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyleKt.m517fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle, long, androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, androidx.compose.ui.graphics.drawscope.DrawStyle):androidx.compose.ui.text.SpanStyle");
    }

    public static final Object lerpDiscrete(float f, Object obj, Object obj2) {
        if (f >= 0.5d) {
            return obj2;
        }
        return obj;
    }

    /* renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m518lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        boolean z;
        if (!TextUnitKt.m600isUnspecifiedR2X_6o(j) && !TextUnitKt.m600isUnspecifiedR2X_6o(j2)) {
            if (!TextUnitKt.m600isUnspecifiedR2X_6o(j) && !TextUnitKt.m600isUnspecifiedR2X_6o(j2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (TextUnitType.m601equalsimpl0(TextUnit.m597getTypeUIouoOA(j), TextUnit.m597getTypeUIouoOA(j2))) {
                    return TextUnitKt.pack(YieldKt.lerp(TextUnit.m598getValueimpl(j), TextUnit.m598getValueimpl(j2), f), 1095216660480L & j);
                }
                throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.m602toStringimpl(TextUnit.m597getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m602toStringimpl(TextUnit.m597getTypeUIouoOA(j2)))).toString());
            }
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
        return ((TextUnit) lerpDiscrete(f, new TextUnit(j), new TextUnit(j2))).packedValue;
    }
}
