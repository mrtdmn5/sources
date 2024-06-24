package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.functions.Function0;

/* compiled from: TextSelectionColors.kt */
/* loaded from: classes.dex */
public final class TextSelectionColorsKt {
    public static final TextSelectionColors DefaultTextSelectionColors;
    public static final DynamicProvidableCompositionLocal LocalTextSelectionColors = CompositionLocalKt.compositionLocalOf$default(new Function0<TextSelectionColors>() { // from class: androidx.compose.foundation.text.selection.TextSelectionColorsKt$LocalTextSelectionColors$1
        @Override // kotlin.jvm.functions.Function0
        public final TextSelectionColors invoke() {
            return TextSelectionColorsKt.DefaultTextSelectionColors;
        }
    });

    static {
        long Color;
        long Color2 = ColorKt.Color(4282550004L);
        Color = ColorKt.Color(Color.m322getRedimpl(Color2), Color.m321getGreenimpl(Color2), Color.m319getBlueimpl(Color2), 0.4f, Color.m320getColorSpaceimpl(Color2));
        DefaultTextSelectionColors = new TextSelectionColors(Color2, Color);
    }
}
