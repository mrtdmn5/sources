package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import io.ktor.util.internal.ExceptionUtilsJvmKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: SelectionAdjustment.kt */
/* loaded from: classes.dex */
public final class SelectionAdjustment$Companion$CharacterWithWordAccelerate$1 implements SelectionAdjustment {
    public static int snapToWordBoundary(TextLayoutResult textLayoutResult, int r5, int r6, int r7, boolean z, boolean z2) {
        int lineEnd;
        long m520getWordBoundaryjx7JFs = textLayoutResult.m520getWordBoundaryjx7JFs(r5);
        int r2 = (int) (m520getWordBoundaryjx7JFs >> 32);
        if (textLayoutResult.getLineForOffset(r2) != r6) {
            r2 = textLayoutResult.getLineStart(r6);
        }
        if (textLayoutResult.getLineForOffset(TextRange.m523getEndimpl(m520getWordBoundaryjx7JFs)) == r6) {
            lineEnd = TextRange.m523getEndimpl(m520getWordBoundaryjx7JFs);
        } else {
            lineEnd = textLayoutResult.getLineEnd(r6, false);
        }
        if (r2 == r7) {
            return lineEnd;
        }
        if (lineEnd == r7) {
            return r2;
        }
        int r62 = (r2 + lineEnd) / 2;
        if (z ^ z2) {
            if (r5 <= r62) {
                return r2;
            }
        } else if (r5 < r62) {
            return r2;
        }
        return lineEnd;
    }

    public static int updateSelectionBoundary(TextLayoutResult textLayoutResult, int r9, int r10, int r11, int r12, boolean z, boolean z2) {
        boolean z3;
        if (r9 == r10) {
            return r11;
        }
        int lineForOffset = textLayoutResult.getLineForOffset(r9);
        if (lineForOffset != textLayoutResult.getLineForOffset(r11)) {
            return snapToWordBoundary(textLayoutResult, r9, lineForOffset, r12, z, z2);
        }
        boolean z4 = false;
        if (r10 == -1 || (r9 != r10 && (!(z ^ z2) ? r9 > r10 : r9 < r10))) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return r9;
        }
        long m520getWordBoundaryjx7JFs = textLayoutResult.m520getWordBoundaryjx7JFs(r11);
        if (r11 == ((int) (m520getWordBoundaryjx7JFs >> 32)) || r11 == TextRange.m523getEndimpl(m520getWordBoundaryjx7JFs)) {
            z4 = true;
        }
        if (!z4) {
            return r9;
        }
        return snapToWordBoundary(textLayoutResult, r9, lineForOffset, r12, z, z2);
    }

    @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
    /* renamed from: adjust-ZXO7KMw */
    public final long mo139adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int r14, boolean z, TextRange textRange) {
        int updateSelectionBoundary;
        int r0;
        if (textRange == null) {
            return SelectionAdjustment.Companion.m140access$adjustByBoundaryDvylE(textLayoutResult, j, new SelectionAdjustment$Companion$Word$1$adjust$1(textLayoutResult));
        }
        boolean m522getCollapsedimpl = TextRange.m522getCollapsedimpl(j);
        long j2 = textRange.packedValue;
        if (m522getCollapsedimpl) {
            AnnotatedString annotatedString = textLayoutResult.layoutInput.text;
            return ExceptionUtilsJvmKt.ensureAtLeastOneChar(annotatedString.text, (int) (j >> 32), StringsKt__StringsKt.getLastIndex(annotatedString), z, TextRange.m526getReversedimpl(j2));
        }
        if (z) {
            r0 = updateSelectionBoundary(textLayoutResult, (int) (j >> 32), r14, (int) (j2 >> 32), TextRange.m523getEndimpl(j), true, TextRange.m526getReversedimpl(j));
            updateSelectionBoundary = TextRange.m523getEndimpl(j);
        } else {
            int r9 = (int) (j >> 32);
            updateSelectionBoundary = updateSelectionBoundary(textLayoutResult, TextRange.m523getEndimpl(j), r14, TextRange.m523getEndimpl(j2), r9, false, TextRange.m526getReversedimpl(j));
            r0 = r9;
        }
        return TextRangeKt.TextRange(r0, updateSelectionBoundary);
    }
}
