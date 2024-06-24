package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldSize.kt */
/* loaded from: classes.dex */
public final class TextFieldSize {
    public Density density;
    public FontFamily.Resolver fontFamilyResolver;
    public LayoutDirection layoutDirection;
    public long minSize;
    public TextStyle resolvedStyle;
    public Object typeface;

    public TextFieldSize(LayoutDirection layoutDirection, Density density, FontFamily.Resolver fontFamilyResolver, TextStyle resolvedStyle, Object typeface) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(resolvedStyle, "resolvedStyle");
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.layoutDirection = layoutDirection;
        this.density = density;
        this.fontFamilyResolver = fontFamilyResolver;
        this.resolvedStyle = resolvedStyle;
        this.typeface = typeface;
        this.minSize = TextFieldDelegateKt.computeSizeForDefaultText(resolvedStyle, density, fontFamilyResolver, TextFieldDelegateKt.EmptyTextReplacement, 1);
    }
}
