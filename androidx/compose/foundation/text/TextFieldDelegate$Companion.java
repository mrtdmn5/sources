package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldDelegate.kt */
/* loaded from: classes.dex */
public final class TextFieldDelegate$Companion {
    public static void notifyFocusedRect$foundation_release(TextFieldValue value, TextDelegate textDelegate, TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, TextInputSession textInputSession, boolean z, OffsetMapping offsetMapping) {
        Rect rect;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(textDelegate, "textDelegate");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        if (!z) {
            return;
        }
        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m524getMaximpl(value.selection));
        if (originalToTransformed < textLayoutResult.layoutInput.text.length()) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed);
        } else if (originalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, IntSize.m593getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textDelegate.style, textDelegate.density, textDelegate.fontFamilyResolver, TextFieldDelegateKt.EmptyTextReplacement, 1)));
        }
        float f = rect.left;
        float f2 = rect.top;
        long mo425localToRootMKHz9U = layoutCoordinates.mo425localToRootMKHz9U(OffsetKt.Offset(f, f2));
        Rect m271Recttz77jQw = RectKt.m271Recttz77jQw(OffsetKt.Offset(Offset.m259getXimpl(mo425localToRootMKHz9U), Offset.m260getYimpl(mo425localToRootMKHz9U)), SizeKt.Size(rect.right - rect.left, rect.bottom - f2));
        if (textInputSession.isOpen()) {
            textInputSession.platformTextInputService.notifyFocusedRect(m271Recttz77jQw);
        }
    }
}
