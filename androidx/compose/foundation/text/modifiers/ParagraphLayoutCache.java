package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParagraphLayoutCache.kt */
/* loaded from: classes.dex */
public final class ParagraphLayoutCache {
    public int cachedIntrinsicHeight;
    public int cachedIntrinsicHeightInputWidth;
    public Density density;
    public boolean didOverflow;
    public FontFamily.Resolver fontFamilyResolver;
    public LayoutDirection intrinsicsLayoutDirection;
    public long lastDensity;
    public long layoutSize;
    public MinLinesConstrainer mMinLinesConstrainer;
    public int maxLines;
    public int minLines;
    public int overflow;
    public AndroidParagraph paragraph;
    public ParagraphIntrinsics paragraphIntrinsics;
    public long prevConstraints;
    public boolean softWrap;
    public TextStyle style;
    public String text;

    public ParagraphLayoutCache(String text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int r5, boolean z, int r7, int r8) {
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
        this.lastDensity = InlineDensity.Unspecified;
        this.layoutSize = IntSizeKt.IntSize(0, 0);
        this.prevConstraints = Constraints.Companion.m570fixedJhjzzOo(0, 0);
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
        int ceilToIntPx = TextDelegateKt.ceilToIntPx(m128layoutTextK40F9xA(ConstraintsKt.Constraints(0, r4, 0, Integer.MAX_VALUE), layoutDirection).getHeight());
        this.cachedIntrinsicHeightInputWidth = r4;
        this.cachedIntrinsicHeight = ceilToIntPx;
        return ceilToIntPx;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: layoutText-K40F9xA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.ui.text.AndroidParagraph m128layoutTextK40F9xA(long r10, androidx.compose.ui.unit.LayoutDirection r12) {
        /*
            r9 = this;
            androidx.compose.ui.text.ParagraphIntrinsics r12 = r9.setLayoutDirection(r12)
            boolean r0 = r9.softWrap
            int r1 = r9.overflow
            float r2 = r12.getMaxIntrinsicWidth()
            long r7 = io.ktor.utils.io.CloseElementKt.m1651finalConstraintstfFHcEY(r10, r0, r1, r2)
            boolean r10 = r9.softWrap
            int r11 = r9.overflow
            int r0 = r9.maxLines
            r1 = 2
            r2 = 1
            r3 = 0
            if (r10 != 0) goto L24
            if (r11 != r1) goto L1f
            r10 = r2
            goto L20
        L1f:
            r10 = r3
        L20:
            if (r10 == 0) goto L24
            r10 = r2
            goto L25
        L24:
            r10 = r3
        L25:
            if (r10 == 0) goto L29
            r5 = r2
            goto L2d
        L29:
            if (r0 >= r2) goto L2c
            r0 = r2
        L2c:
            r5 = r0
        L2d:
            if (r11 != r1) goto L31
            r6 = r2
            goto L32
        L31:
            r6 = r3
        L32:
            androidx.compose.ui.text.AndroidParagraph r10 = new androidx.compose.ui.text.AndroidParagraph
            r4 = r12
            androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r4 = (androidx.compose.ui.text.platform.AndroidParagraphIntrinsics) r4
            r3 = r10
            r3.<init>(r4, r5, r6, r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.ParagraphLayoutCache.m128layoutTextK40F9xA(long, androidx.compose.ui.unit.LayoutDirection):androidx.compose.ui.text.AndroidParagraph");
    }

    public final void markDirty() {
        this.paragraph = null;
        this.paragraphIntrinsics = null;
        this.intrinsicsLayoutDirection = null;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
        this.prevConstraints = Constraints.Companion.m570fixedJhjzzOo(0, 0);
        this.layoutSize = IntSizeKt.IntSize(0, 0);
        this.didOverflow = false;
    }

    public final ParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || paragraphIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            String str = this.text;
            TextStyle resolveDefaults = TextStyleKt.resolveDefaults(this.style, layoutDirection);
            Density density = this.density;
            Intrinsics.checkNotNull(density);
            FontFamily.Resolver resolver = this.fontFamilyResolver;
            EmptyList emptyList = EmptyList.INSTANCE;
            paragraphIntrinsics = ParagraphIntrinsicsKt.ParagraphIntrinsics(resolveDefaults, resolver, density, str, emptyList, emptyList);
        }
        this.paragraphIntrinsics = paragraphIntrinsics;
        return paragraphIntrinsics;
    }
}
