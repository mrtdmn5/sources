package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: MultiWidgetSelectionDelegate.kt */
/* loaded from: classes.dex */
public final class MultiWidgetSelectionDelegateKt {
    /* renamed from: getAssembledSelectionInfo-vJH6DeI, reason: not valid java name */
    public static final Selection m137getAssembledSelectionInfovJH6DeI(long j, boolean z, long j2, TextLayoutResult textLayoutResult) {
        int r2 = TextRange.$r8$clinit;
        int r22 = (int) (j >> 32);
        return new Selection(new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(r22), r22, j2), new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(Math.max(TextRange.m523getEndimpl(j) - 1, 0)), TextRange.m523getEndimpl(j), j2), z);
    }

    /* renamed from: getOffsetForPosition-0AR0LA0, reason: not valid java name */
    public static final int m138getOffsetForPosition0AR0LA0(TextLayoutResult textLayoutResult, Rect rect, long j) {
        int length = textLayoutResult.layoutInput.text.length();
        if (rect.m268containsk4lQ0M(j)) {
            return RangesKt___RangesKt.coerceIn(textLayoutResult.m519getOffsetForPositionk4lQ0M(j), 0, length);
        }
        if (SelectionMode.Vertical.mo147compare3MmeM6k$foundation_release(j, rect) < 0) {
            return 0;
        }
        return length;
    }
}
