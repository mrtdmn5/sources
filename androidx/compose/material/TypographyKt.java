package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.jvm.functions.Function0;

/* compiled from: Typography.kt */
/* loaded from: classes.dex */
public final class TypographyKt {
    public static final TextStyle DefaultTextStyle = TextStyle.m529copyv2rsoow$default(16252927, 0, 0, 0, DefaultPlatformTextStyle_androidKt.DefaultPlatformTextStyle, TextStyle.Default, null, null);
    public static final StaticProvidableCompositionLocal LocalTypography = CompositionLocalKt.staticCompositionLocalOf(new Function0<Typography>() { // from class: androidx.compose.material.TypographyKt$LocalTypography$1
        @Override // kotlin.jvm.functions.Function0
        public final Typography invoke() {
            return new Typography(null, null, null, null, null, null, null, null, null, null, 16383);
        }
    });

    public static final TextStyle access$withDefaultFontFamily(TextStyle textStyle, FontFamily fontFamily) {
        if (textStyle.spanStyle.fontFamily == null) {
            return TextStyle.m529copyv2rsoow$default(16777183, 0L, 0L, 0L, null, textStyle, fontFamily, null);
        }
        return textStyle;
    }
}
