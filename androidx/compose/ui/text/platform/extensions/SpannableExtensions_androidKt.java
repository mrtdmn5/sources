package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: SpannableExtensions.android.kt */
/* loaded from: classes.dex */
public final class SpannableExtensions_androidKt {
    /* renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    public static final float m549resolveLineHeightInPxo2QH7mI(long j, float f, Density density) {
        long m597getTypeUIouoOA = TextUnit.m597getTypeUIouoOA(j);
        if (TextUnitType.m601equalsimpl0(m597getTypeUIouoOA, 4294967296L)) {
            return density.mo48toPxR2X_6o(j);
        }
        if (TextUnitType.m601equalsimpl0(m597getTypeUIouoOA, 8589934592L)) {
            return TextUnit.m598getValueimpl(j) * f;
        }
        return Float.NaN;
    }

    /* renamed from: setBackground-RPmYEkk, reason: not valid java name */
    public static final void m550setBackgroundRPmYEkk(Spannable spannable, long j, int r5, int r6) {
        boolean z;
        if (j != Color.Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.m327toArgb8_81llA(j)), r5, r6);
        }
    }

    /* renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m551setColorRPmYEkk(Spannable spannable, long j, int r5, int r6) {
        boolean z;
        if (j != Color.Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.m327toArgb8_81llA(j)), r5, r6);
        }
    }

    /* renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m552setFontSizeKmRG4DE(Spannable spannable, long j, Density density, int r8, int r9) {
        Intrinsics.checkNotNullParameter(density, "density");
        long m597getTypeUIouoOA = TextUnit.m597getTypeUIouoOA(j);
        if (TextUnitType.m601equalsimpl0(m597getTypeUIouoOA, 4294967296L)) {
            setSpan(spannable, new AbsoluteSizeSpan(MathKt__MathJVMKt.roundToInt(density.mo48toPxR2X_6o(j)), false), r8, r9);
        } else if (TextUnitType.m601equalsimpl0(m597getTypeUIouoOA, 8589934592L)) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.m598getValueimpl(j)), r8, r9);
        }
    }

    public static final void setSpan(Spannable spannable, Object span, int r3, int r4) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(span, "span");
        spannable.setSpan(span, r3, r4, 33);
    }
}
