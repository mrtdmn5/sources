package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;

/* compiled from: SelectionAdjustment.kt */
/* loaded from: classes.dex */
public final class SelectionAdjustment$Companion$Word$1 implements SelectionAdjustment {
    @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
    /* renamed from: adjust-ZXO7KMw */
    public final long mo139adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int r4, boolean z, TextRange textRange) {
        return SelectionAdjustment.Companion.m140access$adjustByBoundaryDvylE(textLayoutResult, j, new SelectionAdjustment$Companion$Word$1$adjust$1(textLayoutResult));
    }
}
