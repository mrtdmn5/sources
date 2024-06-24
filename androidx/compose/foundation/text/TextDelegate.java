package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextDelegate.kt */
/* loaded from: classes.dex */
public final class TextDelegate {
    public final Density density;
    public final FontFamily.Resolver fontFamilyResolver;
    public LayoutDirection intrinsicsLayoutDirection;
    public final int maxLines;
    public final int minLines;
    public final int overflow;
    public MultiParagraphIntrinsics paragraphIntrinsics;
    public final List<AnnotatedString.Range<Placeholder>> placeholders;
    public final boolean softWrap;
    public final TextStyle style;
    public final AnnotatedString text;

    public TextDelegate(AnnotatedString text, TextStyle style, int r4, int r5, boolean z, int r7, Density density, FontFamily.Resolver fontFamilyResolver, List placeholders) {
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        this.text = text;
        this.style = style;
        this.maxLines = r4;
        this.minLines = r5;
        this.softWrap = z;
        this.overflow = r7;
        this.density = density;
        this.fontFamilyResolver = fontFamilyResolver;
        this.placeholders = placeholders;
        if (r4 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (r5 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (r5 <= r4) {
                    return;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void layoutIntrinsics(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        if (multiParagraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || multiParagraphIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            multiParagraphIntrinsics = new MultiParagraphIntrinsics(this.text, TextStyleKt.resolveDefaults(this.style, layoutDirection), this.placeholders, this.density, this.fontFamilyResolver);
        }
        this.paragraphIntrinsics = multiParagraphIntrinsics;
    }
}
