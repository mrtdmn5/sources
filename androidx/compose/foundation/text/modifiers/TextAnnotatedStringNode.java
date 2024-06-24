package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: TextAnnotatedStringNode.kt */
/* loaded from: classes.dex */
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public MultiParagraphLayoutCache _layoutCache;
    public Map<AlignmentLine, Integer> baselineCache;
    public FontFamily.Resolver fontFamilyResolver;
    public int maxLines;
    public int minLines;
    public Function1<? super List<Rect>, Unit> onPlaceholderLayout;
    public Function1<? super TextLayoutResult, Unit> onTextLayout;
    public int overflow;
    public ColorProducer overrideColor;
    public List<AnnotatedString.Range<Placeholder>> placeholders;
    public SelectionController selectionController;
    public TextAnnotatedStringNode$applySemantics$1 semanticsTextLayoutResult;
    public boolean softWrap;
    public TextStyle style;
    public AnnotatedString text;

    public TextAnnotatedStringNode(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, Function1 function1, int r6, boolean z, int r8, int r9, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.onTextLayout = function1;
        this.overflow = r6;
        this.softWrap = z;
        this.maxLines = r8;
        this.minLines = r9;
        this.placeholders = list;
        this.onPlaceholderLayout = function12;
        this.selectionController = selectionController;
        this.overrideColor = colorProducer;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$1] */
    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "<this>");
        TextAnnotatedStringNode$applySemantics$1 textAnnotatedStringNode$applySemantics$1 = this.semanticsTextLayoutResult;
        TextAnnotatedStringNode$applySemantics$1 textAnnotatedStringNode$applySemantics$12 = textAnnotatedStringNode$applySemantics$1;
        if (textAnnotatedStringNode$applySemantics$1 == null) {
            ?? r0 = new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(List<TextLayoutResult> list) {
                    boolean z;
                    List<TextLayoutResult> textLayoutResult = list;
                    Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                    TextLayoutResult textLayoutResult2 = TextAnnotatedStringNode.this.getLayoutCache().layoutCache;
                    if (textLayoutResult2 != null) {
                        textLayoutResult.add(textLayoutResult2);
                    } else {
                        textLayoutResult2 = null;
                    }
                    if (textLayoutResult2 != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            };
            this.semanticsTextLayoutResult = r0;
            textAnnotatedStringNode$applySemantics$12 = r0;
        }
        AnnotatedString value = this.text;
        KProperty<Object>[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        Intrinsics.checkNotNullParameter(value, "value");
        semanticsConfiguration.set(SemanticsProperties.Text, CollectionsKt__CollectionsKt.listOf(value));
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsConfiguration, textAnnotatedStringNode$applySemantics$12);
    }

    public final void doInvalidations(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!this.isAttached) {
            return;
        }
        if (z2 || (z && this.semanticsTextLayoutResult != null)) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (z2 || z3 || z4) {
            MultiParagraphLayoutCache layoutCache = getLayoutCache();
            AnnotatedString text = this.text;
            TextStyle style = this.style;
            FontFamily.Resolver fontFamilyResolver = this.fontFamilyResolver;
            int r1 = this.overflow;
            boolean z5 = this.softWrap;
            int r3 = this.maxLines;
            int r4 = this.minLines;
            List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
            layoutCache.text = text;
            layoutCache.style = style;
            layoutCache.fontFamilyResolver = fontFamilyResolver;
            layoutCache.overflow = r1;
            layoutCache.softWrap = z5;
            layoutCache.maxLines = r3;
            layoutCache.minLines = r4;
            layoutCache.placeholders = list;
            layoutCache.paragraphIntrinsics = null;
            layoutCache.layoutCache = null;
            LayoutModifierNodeKt.invalidateMeasurement(this);
            DrawModifierNodeKt.invalidateDraw(this);
        }
        if (z) {
            DrawModifierNodeKt.invalidateDraw(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0118 A[Catch: all -> 0x018e, TryCatch #0 {all -> 0x018e, blocks: (B:55:0x0110, B:57:0x0118, B:58:0x011a, B:60:0x0120, B:61:0x0122, B:63:0x0128, B:64:0x012a, B:66:0x0132, B:78:0x0141, B:80:0x0145, B:81:0x014c, B:86:0x0172, B:87:0x0159, B:91:0x0168, B:92:0x016f, B:95:0x014a), top: B:54:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0120 A[Catch: all -> 0x018e, TryCatch #0 {all -> 0x018e, blocks: (B:55:0x0110, B:57:0x0118, B:58:0x011a, B:60:0x0120, B:61:0x0122, B:63:0x0128, B:64:0x012a, B:66:0x0132, B:78:0x0141, B:80:0x0145, B:81:0x014c, B:86:0x0172, B:87:0x0159, B:91:0x0168, B:92:0x016f, B:95:0x014a), top: B:54:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0128 A[Catch: all -> 0x018e, TryCatch #0 {all -> 0x018e, blocks: (B:55:0x0110, B:57:0x0118, B:58:0x011a, B:60:0x0120, B:61:0x0122, B:63:0x0128, B:64:0x012a, B:66:0x0132, B:78:0x0141, B:80:0x0145, B:81:0x014c, B:86:0x0172, B:87:0x0159, B:91:0x0168, B:92:0x016f, B:95:0x014a), top: B:54:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0132 A[Catch: all -> 0x018e, TryCatch #0 {all -> 0x018e, blocks: (B:55:0x0110, B:57:0x0118, B:58:0x011a, B:60:0x0120, B:61:0x0122, B:63:0x0128, B:64:0x012a, B:66:0x0132, B:78:0x0141, B:80:0x0145, B:81:0x014c, B:86:0x0172, B:87:0x0159, B:91:0x0168, B:92:0x016f, B:95:0x014a), top: B:54:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0178 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0141 A[Catch: all -> 0x018e, TryCatch #0 {all -> 0x018e, blocks: (B:55:0x0110, B:57:0x0118, B:58:0x011a, B:60:0x0120, B:61:0x0122, B:63:0x0128, B:64:0x012a, B:66:0x0132, B:78:0x0141, B:80:0x0145, B:81:0x014c, B:86:0x0172, B:87:0x0159, B:91:0x0168, B:92:0x016f, B:95:0x014a), top: B:54:0x0110 }] */
    @Override // androidx.compose.ui.node.DrawModifierNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope r20) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope):void");
    }

    public final MultiParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
        }
        MultiParagraphLayoutCache multiParagraphLayoutCache = this._layoutCache;
        Intrinsics.checkNotNull(multiParagraphLayoutCache);
        return multiParagraphLayoutCache;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r3) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(r3, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r3) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        MultiParagraphLayoutCache layoutCache = getLayoutCache(intrinsicMeasureScope);
        LayoutDirection layoutDirection = intrinsicMeasureScope.getLayoutDirection();
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(layoutCache.setLayoutDirection(layoutDirection).getMaxIntrinsicWidth());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d  */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.ui.layout.MeasureResult mo31measure3p2s80s(androidx.compose.ui.layout.MeasureScope r9, androidx.compose.ui.layout.Measurable r10, long r11) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.mo31measure3p2s80s(androidx.compose.ui.layout.MeasureScope, androidx.compose.ui.layout.Measurable, long):androidx.compose.ui.layout.MeasureResult");
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r3) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(r3, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r3) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        MultiParagraphLayoutCache layoutCache = getLayoutCache(intrinsicMeasureScope);
        LayoutDirection layoutDirection = intrinsicMeasureScope.getLayoutDirection();
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(layoutCache.setLayoutDirection(layoutDirection).getMinIntrinsicWidth());
    }

    public final boolean updateCallbacks(Function1<? super TextLayoutResult, Unit> function1, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController) {
        boolean z;
        if (!Intrinsics.areEqual(this.onTextLayout, function1)) {
            this.onTextLayout = function1;
            z = true;
        } else {
            z = false;
        }
        if (!Intrinsics.areEqual(this.onPlaceholderLayout, function12)) {
            this.onPlaceholderLayout = function12;
            z = true;
        }
        if (!Intrinsics.areEqual(this.selectionController, selectionController)) {
            this.selectionController = selectionController;
            return true;
        }
        return z;
    }

    /* renamed from: updateLayoutRelatedArgs-MPT68mk, reason: not valid java name */
    public final boolean m130updateLayoutRelatedArgsMPT68mk(TextStyle style, List<AnnotatedString.Range<Placeholder>> list, int r5, int r6, boolean z, FontFamily.Resolver fontFamilyResolver, int r9) {
        boolean z2;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        boolean z3 = !this.style.hasSameLayoutAffectingAttributes(style);
        this.style = style;
        if (!Intrinsics.areEqual(this.placeholders, list)) {
            this.placeholders = list;
            z3 = true;
        }
        if (this.minLines != r5) {
            this.minLines = r5;
            z3 = true;
        }
        if (this.maxLines != r6) {
            this.maxLines = r6;
            z3 = true;
        }
        if (this.softWrap != z) {
            this.softWrap = z;
            z3 = true;
        }
        if (!Intrinsics.areEqual(this.fontFamilyResolver, fontFamilyResolver)) {
            this.fontFamilyResolver = fontFamilyResolver;
            z3 = true;
        }
        if (this.overflow == r9) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            this.overflow = r9;
            return true;
        }
        return z3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:            if ((r0.lastDensity == r2) == false) goto L14;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache getLayoutCache(androidx.compose.ui.unit.Density r9) {
        /*
            r8 = this;
            androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache r0 = r8.getLayoutCache()
            androidx.compose.ui.unit.Density r1 = r0.density
            if (r9 == 0) goto L27
            int r2 = androidx.compose.foundation.text.modifiers.InlineDensity.$r8$clinit
            float r2 = r9.getDensity()
            float r3 = r9.getFontScale()
            int r2 = java.lang.Float.floatToIntBits(r2)
            long r4 = (long) r2
            int r2 = java.lang.Float.floatToIntBits(r3)
            long r2 = (long) r2
            r6 = 32
            long r4 = r4 << r6
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r6
            long r2 = r2 | r4
            goto L29
        L27:
            long r2 = androidx.compose.foundation.text.modifiers.InlineDensity.Unspecified
        L29:
            if (r1 != 0) goto L30
            r0.density = r9
            r0.lastDensity = r2
            goto L46
        L30:
            if (r9 == 0) goto L3d
            long r4 = r0.lastDensity
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 != 0) goto L3a
            r1 = 1
            goto L3b
        L3a:
            r1 = 0
        L3b:
            if (r1 != 0) goto L46
        L3d:
            r0.density = r9
            r0.lastDensity = r2
            r9 = 0
            r0.paragraphIntrinsics = r9
            r0.layoutCache = r9
        L46:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.getLayoutCache(androidx.compose.ui.unit.Density):androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache");
    }
}
