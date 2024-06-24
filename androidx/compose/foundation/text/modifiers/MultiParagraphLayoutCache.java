package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiParagraphLayoutCache.kt */
/* loaded from: classes.dex */
public final class MultiParagraphLayoutCache {
    public int cachedIntrinsicHeight;
    public int cachedIntrinsicHeightInputWidth;
    public Density density;
    public FontFamily.Resolver fontFamilyResolver;
    public LayoutDirection intrinsicsLayoutDirection;
    public long lastDensity;
    public TextLayoutResult layoutCache;
    public MinLinesConstrainer mMinLinesConstrainer;
    public int maxLines;
    public int minLines;
    public int overflow;
    public MultiParagraphIntrinsics paragraphIntrinsics;
    public List<AnnotatedString.Range<Placeholder>> placeholders;
    public boolean softWrap;
    public TextStyle style;
    public AnnotatedString text;

    public MultiParagraphLayoutCache(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int r5, boolean z, int r7, int r8, List list) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = r5;
        this.softWrap = z;
        this.maxLines = r7;
        this.minLines = r8;
        this.placeholders = list;
        this.lastDensity = InlineDensity.Unspecified;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    public final int intrinsicHeight(int r4, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int r0 = this.cachedIntrinsicHeightInputWidth;
        int r1 = this.cachedIntrinsicHeight;
        if (r4 == r0 && r0 != -1) {
            return r1;
        }
        int ceilToIntPx = TextDelegateKt.ceilToIntPx(m126layoutTextK40F9xA(ConstraintsKt.Constraints(0, r4, 0, Integer.MAX_VALUE), layoutDirection).height);
        this.cachedIntrinsicHeightInputWidth = r4;
        this.cachedIntrinsicHeight = ceilToIntPx;
        return ceilToIntPx;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: layoutText-K40F9xA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.ui.text.MultiParagraph m126layoutTextK40F9xA(long r8, androidx.compose.ui.unit.LayoutDirection r10) {
        /*
            r7 = this;
            androidx.compose.ui.text.MultiParagraphIntrinsics r1 = r7.setLayoutDirection(r10)
            androidx.compose.ui.text.MultiParagraph r10 = new androidx.compose.ui.text.MultiParagraph
            boolean r0 = r7.softWrap
            int r2 = r7.overflow
            float r3 = r1.getMaxIntrinsicWidth()
            long r2 = io.ktor.utils.io.CloseElementKt.m1651finalConstraintstfFHcEY(r8, r0, r2, r3)
            boolean r8 = r7.softWrap
            int r9 = r7.overflow
            int r0 = r7.maxLines
            r4 = 2
            r5 = 1
            r6 = 0
            if (r8 != 0) goto L26
            if (r9 != r4) goto L21
            r8 = r5
            goto L22
        L21:
            r8 = r6
        L22:
            if (r8 == 0) goto L26
            r8 = r5
            goto L27
        L26:
            r8 = r6
        L27:
            if (r8 == 0) goto L2b
            r8 = r5
            goto L2f
        L2b:
            if (r0 >= r5) goto L2e
            r0 = r5
        L2e:
            r8 = r0
        L2f:
            if (r9 != r4) goto L32
            goto L33
        L32:
            r5 = r6
        L33:
            r0 = r10
            r4 = r8
            r0.<init>(r1, r2, r4, r5)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache.m126layoutTextK40F9xA(long, androidx.compose.ui.unit.LayoutDirection):androidx.compose.ui.text.MultiParagraph");
    }

    public final MultiParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        if (multiParagraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || multiParagraphIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            AnnotatedString annotatedString = this.text;
            TextStyle resolveDefaults = TextStyleKt.resolveDefaults(this.style, layoutDirection);
            Density density = this.density;
            Intrinsics.checkNotNull(density);
            FontFamily.Resolver resolver = this.fontFamilyResolver;
            List list = this.placeholders;
            if (list == null) {
                list = EmptyList.INSTANCE;
            }
            multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, resolveDefaults, list, density, resolver);
        }
        this.paragraphIntrinsics = multiParagraphIntrinsics;
        return multiParagraphIntrinsics;
    }

    /* renamed from: textLayoutResult-VKLhPVY, reason: not valid java name */
    public final TextLayoutResult m127textLayoutResultVKLhPVY(LayoutDirection layoutDirection, long j, MultiParagraph multiParagraph) {
        AnnotatedString annotatedString = this.text;
        TextStyle textStyle = this.style;
        List list = this.placeholders;
        if (list == null) {
            list = EmptyList.INSTANCE;
        }
        int r7 = this.maxLines;
        boolean z = this.softWrap;
        int r9 = this.overflow;
        Density density = this.density;
        Intrinsics.checkNotNull(density);
        return new TextLayoutResult(new TextLayoutInput(annotatedString, textStyle, list, r7, z, r9, density, layoutDirection, this.fontFamilyResolver, j), multiParagraph, ConstraintsKt.m573constrain4WqzIAM(j, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(multiParagraph.width), TextDelegateKt.ceilToIntPx(multiParagraph.height))));
    }
}
