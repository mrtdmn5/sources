package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.reflect.KProperty;

/* compiled from: TextStringSimpleNode.kt */
/* loaded from: classes.dex */
public final class TextStringSimpleNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public ParagraphLayoutCache _layoutCache;
    public Map<AlignmentLine, Integer> baselineCache;
    public FontFamily.Resolver fontFamilyResolver;
    public int maxLines;
    public int minLines;
    public int overflow;
    public ColorProducer overrideColor;
    public TextStringSimpleNode$applySemantics$1 semanticsTextLayoutResult;
    public boolean softWrap;
    public TextStyle style;
    public String text;

    public TextStringSimpleNode(String text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int r5, boolean z, int r7, int r8, ColorProducer colorProducer) {
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
        this.overrideColor = colorProducer;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$1] */
    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "<this>");
        TextStringSimpleNode$applySemantics$1 textStringSimpleNode$applySemantics$1 = this.semanticsTextLayoutResult;
        TextStringSimpleNode$applySemantics$1 textStringSimpleNode$applySemantics$12 = textStringSimpleNode$applySemantics$1;
        if (textStringSimpleNode$applySemantics$1 == null) {
            ?? r0 = new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$1
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:14:0x0093  */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Boolean invoke(java.util.List<androidx.compose.ui.text.TextLayoutResult> r24) {
                    /*
                        r23 = this;
                        r0 = r24
                        java.util.List r0 = (java.util.List) r0
                        java.lang.String r1 = "textLayoutResult"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                        r1 = r23
                        androidx.compose.foundation.text.modifiers.TextStringSimpleNode r2 = androidx.compose.foundation.text.modifiers.TextStringSimpleNode.this
                        androidx.compose.foundation.text.modifiers.ParagraphLayoutCache r2 = r2.getLayoutCache()
                        androidx.compose.ui.unit.LayoutDirection r11 = r2.intrinsicsLayoutDirection
                        r3 = 0
                        if (r11 != 0) goto L18
                        goto L2e
                    L18:
                        androidx.compose.ui.unit.Density r15 = r2.density
                        if (r15 != 0) goto L1d
                        goto L2e
                    L1d:
                        androidx.compose.ui.text.AnnotatedString r13 = new androidx.compose.ui.text.AnnotatedString
                        java.lang.String r4 = r2.text
                        r5 = 6
                        r13.<init>(r4, r3, r5)
                        androidx.compose.ui.text.AndroidParagraph r4 = r2.paragraph
                        if (r4 != 0) goto L2a
                        goto L2e
                    L2a:
                        androidx.compose.ui.text.ParagraphIntrinsics r4 = r2.paragraphIntrinsics
                        if (r4 != 0) goto L32
                    L2e:
                        r24 = r0
                        goto L91
                    L32:
                        long r3 = r2.prevConstraints
                        r18 = 0
                        r19 = 0
                        r20 = 0
                        r21 = 0
                        r22 = 10
                        r16 = r3
                        long r16 = androidx.compose.ui.unit.Constraints.m558copyZbe2FdA$default(r16, r18, r19, r20, r21, r22)
                        androidx.compose.ui.text.TextLayoutResult r14 = new androidx.compose.ui.text.TextLayoutResult
                        androidx.compose.ui.text.TextLayoutInput r12 = new androidx.compose.ui.text.TextLayoutInput
                        androidx.compose.ui.text.TextStyle r5 = r2.style
                        kotlin.collections.EmptyList r18 = kotlin.collections.EmptyList.INSTANCE
                        int r7 = r2.maxLines
                        boolean r8 = r2.softWrap
                        int r9 = r2.overflow
                        androidx.compose.ui.text.font.FontFamily$Resolver r10 = r2.fontFamilyResolver
                        r3 = r12
                        r4 = r13
                        r6 = r18
                        r19 = r10
                        r10 = r15
                        r1 = r12
                        r12 = r19
                        r24 = r0
                        r19 = r13
                        r0 = r14
                        r13 = r16
                        r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                        androidx.compose.ui.text.MultiParagraph r3 = new androidx.compose.ui.text.MultiParagraph
                        androidx.compose.ui.text.MultiParagraphIntrinsics r10 = new androidx.compose.ui.text.MultiParagraphIntrinsics
                        androidx.compose.ui.text.TextStyle r6 = r2.style
                        androidx.compose.ui.text.font.FontFamily$Resolver r9 = r2.fontFamilyResolver
                        r4 = r10
                        r5 = r19
                        r7 = r18
                        r8 = r15
                        r4.<init>(r5, r6, r7, r8, r9)
                        int r9 = r2.maxLines
                        int r4 = r2.overflow
                        r5 = 2
                        if (r4 != r5) goto L82
                        r4 = 1
                        goto L83
                    L82:
                        r4 = 0
                    L83:
                        r5 = r3
                        r6 = r10
                        r7 = r16
                        r10 = r4
                        r5.<init>(r6, r7, r9, r10)
                        long r4 = r2.layoutSize
                        r0.<init>(r1, r3, r4)
                        r3 = r0
                    L91:
                        if (r3 == 0) goto L98
                        r0 = r24
                        r0.add(r3)
                    L98:
                        java.lang.Boolean r0 = java.lang.Boolean.FALSE
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$1.invoke(java.lang.Object):java.lang.Object");
                }
            };
            this.semanticsTextLayoutResult = r0;
            textStringSimpleNode$applySemantics$12 = r0;
        }
        AnnotatedString annotatedString = new AnnotatedString(this.text, null, 6);
        KProperty<Object>[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        semanticsConfiguration.set(SemanticsProperties.Text, CollectionsKt__CollectionsKt.listOf(annotatedString));
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsConfiguration, textStringSimpleNode$applySemantics$12);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(ContentDrawScope contentDrawScope) {
        long j;
        boolean z;
        long j2;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        if (!this.isAttached) {
            return;
        }
        AndroidParagraph androidParagraph = getLayoutCache().paragraph;
        if (androidParagraph != null) {
            Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
            boolean z2 = getLayoutCache().didOverflow;
            boolean z3 = true;
            if (z2) {
                Rect m271Recttz77jQw = RectKt.m271Recttz77jQw(Offset.Zero, SizeKt.Size((int) (getLayoutCache().layoutSize >> 32), IntSize.m593getHeightimpl(getLayoutCache().layoutSize)));
                canvas.save();
                canvas.m314clipRectmtrdDE(m271Recttz77jQw, 1);
            }
            try {
                SpanStyle spanStyle = this.style.spanStyle;
                TextDecoration textDecoration = spanStyle.textDecoration;
                if (textDecoration == null) {
                    textDecoration = TextDecoration.None;
                }
                TextDecoration textDecoration2 = textDecoration;
                Shadow shadow = spanStyle.shadow;
                if (shadow == null) {
                    shadow = Shadow.None;
                }
                Shadow shadow2 = shadow;
                DrawStyle drawStyle = spanStyle.drawStyle;
                if (drawStyle == null) {
                    drawStyle = Fill.INSTANCE;
                }
                DrawStyle drawStyle2 = drawStyle;
                Brush brush = spanStyle.getBrush();
                if (brush != null) {
                    androidParagraph.mo510painthn5TExg(canvas, brush, this.style.spanStyle.textForegroundStyle.getAlpha(), shadow2, textDecoration2, drawStyle2, 3);
                } else {
                    ColorProducer colorProducer = this.overrideColor;
                    if (colorProducer != null) {
                        j = colorProducer.mo219invoke0d7_KjU();
                    } else {
                        j = Color.Unspecified;
                    }
                    long j3 = Color.Unspecified;
                    if (j != j3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (this.style.m531getColor0d7_KjU() == j3) {
                            z3 = false;
                        }
                        if (z3) {
                            j2 = this.style.m531getColor0d7_KjU();
                        } else {
                            j2 = Color.Black;
                        }
                        j = j2;
                    }
                    androidParagraph.mo509paintLG529CI(canvas, j, shadow2, textDecoration2, drawStyle2, 3);
                }
                if (z2) {
                    return;
                } else {
                    return;
                }
            } finally {
                if (z2) {
                    canvas.restore();
                }
            }
        }
        throw new IllegalArgumentException("no paragraph".toString());
    }

    public final ParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new ParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
        }
        ParagraphLayoutCache paragraphLayoutCache = this._layoutCache;
        Intrinsics.checkNotNull(paragraphLayoutCache);
        return paragraphLayoutCache;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r3) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(r3, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r3) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        ParagraphLayoutCache layoutCache = getLayoutCache(intrinsicMeasureScope);
        LayoutDirection layoutDirection = intrinsicMeasureScope.getLayoutDirection();
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(layoutCache.setLayoutDirection(layoutDirection).getMaxIntrinsicWidth());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ParagraphIntrinsics paragraphIntrinsics;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        ParagraphLayoutCache layoutCache = getLayoutCache(measure);
        LayoutDirection layoutDirection = measure.getLayoutDirection();
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        boolean z5 = true;
        if (layoutCache.minLines > 1) {
            MinLinesConstrainer minLinesConstrainer = layoutCache.mMinLinesConstrainer;
            TextStyle textStyle = layoutCache.style;
            Density density = layoutCache.density;
            Intrinsics.checkNotNull(density);
            MinLinesConstrainer from = MinLinesConstrainer.Companion.from(minLinesConstrainer, layoutDirection, textStyle, density, layoutCache.fontFamilyResolver);
            layoutCache.mMinLinesConstrainer = from;
            j = from.m125coerceMinLinesOh53vG4$foundation_release(layoutCache.minLines, j);
        }
        AndroidParagraph androidParagraph = layoutCache.paragraph;
        if (androidParagraph != null && (paragraphIntrinsics = layoutCache.paragraphIntrinsics) != null && !paragraphIntrinsics.getHasStaleResolvedFonts() && layoutDirection == layoutCache.intrinsicsLayoutDirection && (Constraints.m559equalsimpl0(j, layoutCache.prevConstraints) || (Constraints.m565getMaxWidthimpl(j) == Constraints.m565getMaxWidthimpl(layoutCache.prevConstraints) && Constraints.m564getMaxHeightimpl(j) >= androidParagraph.getHeight() && !androidParagraph.layout.didExceedMaxLines))) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (!Constraints.m559equalsimpl0(j, layoutCache.prevConstraints)) {
                AndroidParagraph androidParagraph2 = layoutCache.paragraph;
                Intrinsics.checkNotNull(androidParagraph2);
                layoutCache.layoutSize = ConstraintsKt.m573constrain4WqzIAM(j, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(androidParagraph2.getWidth()), TextDelegateKt.ceilToIntPx(androidParagraph2.getHeight())));
                if (layoutCache.overflow == 3) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4 || (((int) (r12 >> 32)) >= androidParagraph2.getWidth() && IntSize.m593getHeightimpl(r12) >= androidParagraph2.getHeight())) {
                    z5 = false;
                }
                layoutCache.didOverflow = z5;
            }
            z5 = false;
        } else {
            AndroidParagraph m128layoutTextK40F9xA = layoutCache.m128layoutTextK40F9xA(j, layoutDirection);
            layoutCache.prevConstraints = j;
            layoutCache.layoutSize = ConstraintsKt.m573constrain4WqzIAM(j, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(m128layoutTextK40F9xA.getWidth()), TextDelegateKt.ceilToIntPx(m128layoutTextK40F9xA.getHeight())));
            if (layoutCache.overflow == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && (((int) (r12 >> 32)) < m128layoutTextK40F9xA.getWidth() || IntSize.m593getHeightimpl(r12) < m128layoutTextK40F9xA.getHeight())) {
                z3 = true;
            } else {
                z3 = false;
            }
            layoutCache.didOverflow = z3;
            layoutCache.paragraph = m128layoutTextK40F9xA;
        }
        ParagraphIntrinsics paragraphIntrinsics2 = layoutCache.paragraphIntrinsics;
        if (paragraphIntrinsics2 != null) {
            paragraphIntrinsics2.getHasStaleResolvedFonts();
        }
        Unit unit = Unit.INSTANCE;
        AndroidParagraph androidParagraph3 = layoutCache.paragraph;
        Intrinsics.checkNotNull(androidParagraph3);
        long j2 = layoutCache.layoutSize;
        if (z5) {
            LayoutModifierNodeKt.invalidateLayer(this);
            Map<AlignmentLine, Integer> map = this.baselineCache;
            if (map == null) {
                map = new LinkedHashMap<>(2);
            }
            map.put(AlignmentLineKt.FirstBaseline, Integer.valueOf(MathKt__MathJVMKt.roundToInt(androidParagraph3.layout.getLineBaseline(0))));
            map.put(AlignmentLineKt.LastBaseline, Integer.valueOf(MathKt__MathJVMKt.roundToInt(androidParagraph3.getLastBaseline())));
            this.baselineCache = map;
        }
        int r12 = (int) (j2 >> 32);
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(Constraints.Companion.m570fixedJhjzzOo(r12, IntSize.m593getHeightimpl(j2)));
        int m593getHeightimpl = IntSize.m593getHeightimpl(j2);
        Map<AlignmentLine, Integer> map2 = this.baselineCache;
        Intrinsics.checkNotNull(map2);
        return measure.layout(r12, m593getHeightimpl, map2, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.place(Placeable.this, 0, 0, 0.0f);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r3) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(r3, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r3) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        ParagraphLayoutCache layoutCache = getLayoutCache(intrinsicMeasureScope);
        LayoutDirection layoutDirection = intrinsicMeasureScope.getLayoutDirection();
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(layoutCache.setLayoutDirection(layoutDirection).getMinIntrinsicWidth());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:            if ((r0.lastDensity == r2) == false) goto L14;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.foundation.text.modifiers.ParagraphLayoutCache getLayoutCache(androidx.compose.ui.unit.Density r9) {
        /*
            r8 = this;
            androidx.compose.foundation.text.modifiers.ParagraphLayoutCache r0 = r8.getLayoutCache()
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
            goto L44
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
            if (r1 != 0) goto L44
        L3d:
            r0.density = r9
            r0.lastDensity = r2
            r0.markDirty()
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextStringSimpleNode.getLayoutCache(androidx.compose.ui.unit.Density):androidx.compose.foundation.text.modifiers.ParagraphLayoutCache");
    }
}
