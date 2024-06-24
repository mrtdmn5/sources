package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.unit.Density;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Paragraph.kt */
/* loaded from: classes.dex */
public final class ParagraphKt {
    /* renamed from: Paragraph-UdtVg6A$default */
    public static AndroidParagraph m514ParagraphUdtVg6A$default(String text, TextStyle style, long j, Density density, FontFamily.Resolver fontFamilyResolver, EmptyList emptyList, int r20, int r21) {
        EmptyList spanStyles;
        int r0;
        int r1 = r21 & 32;
        EmptyList emptyList2 = EmptyList.INSTANCE;
        if (r1 != 0) {
            spanStyles = emptyList2;
        } else {
            spanStyles = emptyList;
        }
        if ((r21 & 64) == 0) {
            emptyList2 = null;
        }
        EmptyList placeholders = emptyList2;
        if ((r21 & 128) != 0) {
            r0 = Integer.MAX_VALUE;
        } else {
            r0 = r20;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        return new AndroidParagraph(new AndroidParagraphIntrinsics(style, fontFamilyResolver, density, text, spanStyles, placeholders), r0, false, j);
    }
}
