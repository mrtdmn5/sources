package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextLayout.kt */
/* loaded from: classes.dex */
public final class TextLayoutKt {
    public static final TextAndroidCanvas SharedTextAndroidCanvas = new TextAndroidCanvas();
    public static final long ZeroVerticalPadding;

    static {
        long j = 0;
        ZeroVerticalPadding = (j & 4294967295L) | (j << 32);
    }

    public static final TextDirectionHeuristic getTextDirectionHeuristic(int r2) {
        if (r2 != 0) {
            if (r2 != 1) {
                if (r2 != 2) {
                    if (r2 != 3) {
                        if (r2 != 4) {
                            if (r2 != 5) {
                                TextDirectionHeuristic FIRSTSTRONG_LTR = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                                Intrinsics.checkNotNullExpressionValue(FIRSTSTRONG_LTR, "FIRSTSTRONG_LTR");
                                return FIRSTSTRONG_LTR;
                            }
                            TextDirectionHeuristic LOCALE = TextDirectionHeuristics.LOCALE;
                            Intrinsics.checkNotNullExpressionValue(LOCALE, "LOCALE");
                            return LOCALE;
                        }
                        TextDirectionHeuristic ANYRTL_LTR = TextDirectionHeuristics.ANYRTL_LTR;
                        Intrinsics.checkNotNullExpressionValue(ANYRTL_LTR, "ANYRTL_LTR");
                        return ANYRTL_LTR;
                    }
                    TextDirectionHeuristic FIRSTSTRONG_RTL = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    Intrinsics.checkNotNullExpressionValue(FIRSTSTRONG_RTL, "FIRSTSTRONG_RTL");
                    return FIRSTSTRONG_RTL;
                }
                TextDirectionHeuristic FIRSTSTRONG_LTR2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                Intrinsics.checkNotNullExpressionValue(FIRSTSTRONG_LTR2, "FIRSTSTRONG_LTR");
                return FIRSTSTRONG_LTR2;
            }
            TextDirectionHeuristic RTL = TextDirectionHeuristics.RTL;
            Intrinsics.checkNotNullExpressionValue(RTL, "RTL");
            return RTL;
        }
        TextDirectionHeuristic LTR = TextDirectionHeuristics.LTR;
        Intrinsics.checkNotNullExpressionValue(LTR, "LTR");
        return LTR;
    }

    public static final boolean isLineEllipsized(Layout layout, int r2) {
        Intrinsics.checkNotNullParameter(layout, "<this>");
        if (layout.getEllipsisCount(r2) > 0) {
            return true;
        }
        return false;
    }
}
