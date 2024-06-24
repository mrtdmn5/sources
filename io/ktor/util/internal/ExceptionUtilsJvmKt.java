package io.ktor.util.internal;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionUtilsJvm.kt */
/* loaded from: classes3.dex */
public final class ExceptionUtilsJvmKt {
    public static final long ensureAtLeastOneChar(String text, int r2, int r3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (r3 == 0) {
            return TextRangeKt.TextRange(r2, r2);
        }
        if (r2 == 0) {
            if (z) {
                return TextRangeKt.TextRange(StringHelpers_androidKt.findFollowingBreak(0, text), 0);
            }
            return TextRangeKt.TextRange(0, StringHelpers_androidKt.findFollowingBreak(0, text));
        }
        if (r2 == r3) {
            if (z) {
                return TextRangeKt.TextRange(StringHelpers_androidKt.findPrecedingBreak(r3, text), r3);
            }
            return TextRangeKt.TextRange(r3, StringHelpers_androidKt.findPrecedingBreak(r3, text));
        }
        if (z) {
            if (!z2) {
                return TextRangeKt.TextRange(StringHelpers_androidKt.findPrecedingBreak(r2, text), r2);
            }
            return TextRangeKt.TextRange(StringHelpers_androidKt.findFollowingBreak(r2, text), r2);
        }
        if (!z2) {
            return TextRangeKt.TextRange(r2, StringHelpers_androidKt.findFollowingBreak(r2, text));
        }
        return TextRangeKt.TextRange(r2, StringHelpers_androidKt.findPrecedingBreak(r2, text));
    }
}
