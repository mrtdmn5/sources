package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TransformedText;

/* compiled from: TextFieldScroll.kt */
/* loaded from: classes.dex */
public final class TextFieldScrollKt {

    /* compiled from: TextFieldScroll.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Orientation.values().length];
            try {
                r0[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final Rect access$getCursorRectInScroller(MeasureScope measureScope, int r2, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean z, int r6) {
        Rect rect;
        float f;
        float f2;
        if (textLayoutResult != null) {
            rect = textLayoutResult.getCursorRect(transformedText.offsetMapping.originalToTransformed(r2));
        } else {
            rect = Rect.Zero;
        }
        int mo44roundToPx0680j_4 = measureScope.mo44roundToPx0680j_4(TextFieldCursorKt.DefaultCursorThickness);
        float f3 = rect.left;
        if (z) {
            f = (r6 - f3) - mo44roundToPx0680j_4;
        } else {
            f = f3;
        }
        if (z) {
            f2 = r6 - f3;
        } else {
            f2 = mo44roundToPx0680j_4 + f3;
        }
        return new Rect(f, rect.top, f2, rect.bottom);
    }
}
