package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParagraphIntrinsics.kt */
/* loaded from: classes.dex */
public final class ParagraphIntrinsicsKt {
    public static final AndroidParagraphIntrinsics ParagraphIntrinsics(TextStyle textStyle, FontFamily.Resolver fontFamilyResolver, Density density, String text, List spanStyles, List placeholders) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        return new AndroidParagraphIntrinsics(textStyle, fontFamilyResolver, density, text, spanStyles, placeholders);
    }
}
