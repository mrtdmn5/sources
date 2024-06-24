package androidx.compose.foundation.text;

import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: TextFieldDelegate.kt */
/* loaded from: classes.dex */
public final class TextFieldDelegateKt {
    public static final String EmptyTextReplacement = StringsKt__StringsJVMKt.repeat(10, "H");

    public static final long computeSizeForDefaultText(TextStyle style, Density density, FontFamily.Resolver fontFamilyResolver, String text, int r14) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(text, "text");
        AndroidParagraph m514ParagraphUdtVg6A$default = ParagraphKt.m514ParagraphUdtVg6A$default(text, style, ConstraintsKt.Constraints$default(0, 0, 15), density, fontFamilyResolver, EmptyList.INSTANCE, r14, 64);
        return IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(m514ParagraphUdtVg6A$default.paragraphIntrinsics.getMinIntrinsicWidth()), TextDelegateKt.ceilToIntPx(m514ParagraphUdtVg6A$default.getHeight()));
    }
}
