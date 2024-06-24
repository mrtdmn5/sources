package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.TextLayoutResult;

/* compiled from: SelectionController.kt */
/* loaded from: classes.dex */
public final class SelectionControllerKt {
    /* renamed from: access$outOfBoundary-2x9bVx0, reason: not valid java name */
    public static final boolean m129access$outOfBoundary2x9bVx0(TextLayoutResult textLayoutResult, long j, long j2) {
        if (textLayoutResult == null) {
            return false;
        }
        int length = textLayoutResult.layoutInput.text.text.length();
        int m519getOffsetForPositionk4lQ0M = textLayoutResult.m519getOffsetForPositionk4lQ0M(j);
        int m519getOffsetForPositionk4lQ0M2 = textLayoutResult.m519getOffsetForPositionk4lQ0M(j2);
        int r1 = length - 1;
        if ((m519getOffsetForPositionk4lQ0M < r1 || m519getOffsetForPositionk4lQ0M2 < r1) && (m519getOffsetForPositionk4lQ0M >= 0 || m519getOffsetForPositionk4lQ0M2 >= 0)) {
            return false;
        }
        return true;
    }
}
