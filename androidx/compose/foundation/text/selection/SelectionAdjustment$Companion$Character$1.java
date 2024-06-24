package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import io.ktor.util.internal.ExceptionUtilsJvmKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: SelectionAdjustment.kt */
/* loaded from: classes.dex */
public final class SelectionAdjustment$Companion$Character$1 implements SelectionAdjustment {
    @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
    /* renamed from: adjust-ZXO7KMw */
    public final long mo139adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int r6, boolean z, TextRange textRange) {
        boolean z2;
        if (TextRange.m522getCollapsedimpl(j)) {
            if (textRange != null) {
                z2 = TextRange.m526getReversedimpl(textRange.packedValue);
            } else {
                z2 = false;
            }
            AnnotatedString annotatedString = textLayoutResult.layoutInput.text;
            return ExceptionUtilsJvmKt.ensureAtLeastOneChar(annotatedString.text, (int) (j >> 32), StringsKt__StringsKt.getLastIndex(annotatedString), z, z2);
        }
        return j;
    }
}
