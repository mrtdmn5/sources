package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import mu.KMarkerFactory;

/* compiled from: LayoutNodeDrawScope.kt */
/* loaded from: classes.dex */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    public final CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
    public DrawModifierNode drawNode;

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-yD3GUKo */
    public final void mo357drawArcyD3GUKo(long j, float f, float f2, long j2, long j3, float f3, DrawStyle style, ColorFilter colorFilter, int r26) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.canvasDrawScope.mo357drawArcyD3GUKo(j, f, f2, j2, j3, f3, style, colorFilter, r26);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-VaOC9Bg */
    public final void mo358drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle style, ColorFilter colorFilter, int r20) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.canvasDrawScope.mo358drawCircleVaOC9Bg(j, f, j2, f2, style, colorFilter, r20);
    }

    @Override // androidx.compose.ui.graphics.drawscope.ContentDrawScope
    public final void drawContent() {
        boolean z;
        boolean z2;
        Canvas canvas = this.canvasDrawScope.drawContext.getCanvas();
        DrawModifierNode drawModifierNode = this.drawNode;
        Intrinsics.checkNotNull(drawModifierNode);
        Modifier.Node node = drawModifierNode.getNode().child;
        if (node != null && (node.aggregateChildKindSet & 4) != 0) {
            while (node != null) {
                int r3 = node.kindSet;
                if ((r3 & 2) != 0) {
                    break;
                } else if ((r3 & 4) != 0) {
                    break;
                } else {
                    node = node.child;
                }
            }
        }
        node = null;
        if (node != null) {
            MutableVector mutableVector = null;
            while (node != null) {
                if (node instanceof DrawModifierNode) {
                    DrawModifierNode drawModifierNode2 = (DrawModifierNode) node;
                    Intrinsics.checkNotNullParameter(canvas, "canvas");
                    NodeCoordinator m441requireCoordinator64DMado = DelegatableNodeKt.m441requireCoordinator64DMado(drawModifierNode2, 4);
                    long m595toSizeozmzZPI = IntSizeKt.m595toSizeozmzZPI(m441requireCoordinator64DMado.measuredSize);
                    LayoutNode layoutNode = m441requireCoordinator64DMado.layoutNode;
                    layoutNode.getClass();
                    LayoutNodeKt.requireOwner(layoutNode).getSharedDrawScope().m450drawDirectx_KDEd0$ui_release(canvas, m595toSizeozmzZPI, m441requireCoordinator64DMado, drawModifierNode2);
                } else {
                    if ((node.kindSet & 4) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && (node instanceof DelegatingNode)) {
                        int r5 = 0;
                        for (Modifier.Node node2 = ((DelegatingNode) node).delegate; node2 != null; node2 = node2.child) {
                            if ((node2.kindSet & 4) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                r5++;
                                if (r5 == 1) {
                                    node = node2;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (node != null) {
                                        mutableVector.add(node);
                                        node = null;
                                    }
                                    mutableVector.add(node2);
                                }
                            }
                        }
                        if (r5 == 1) {
                        }
                    }
                }
                node = DelegatableNodeKt.access$pop(mutableVector);
            }
            return;
        }
        NodeCoordinator m441requireCoordinator64DMado2 = DelegatableNodeKt.m441requireCoordinator64DMado(drawModifierNode, 4);
        if (m441requireCoordinator64DMado2.getTail() == drawModifierNode.getNode()) {
            m441requireCoordinator64DMado2 = m441requireCoordinator64DMado2.wrapped;
            Intrinsics.checkNotNull(m441requireCoordinator64DMado2);
        }
        m441requireCoordinator64DMado2.performDraw(canvas);
    }

    /* renamed from: drawDirect-x_KDEd0$ui_release */
    public final void m450drawDirectx_KDEd0$ui_release(Canvas canvas, long j, NodeCoordinator coordinator, DrawModifierNode drawModifierNode) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        DrawModifierNode drawModifierNode2 = this.drawNode;
        this.drawNode = drawModifierNode;
        LayoutDirection layoutDirection = coordinator.layoutNode.layoutDirection;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.drawParams;
        Density density = drawParams.density;
        LayoutDirection layoutDirection2 = drawParams.layoutDirection;
        Canvas canvas2 = drawParams.canvas;
        long j2 = drawParams.size;
        drawParams.density = coordinator;
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        drawParams.layoutDirection = layoutDirection;
        drawParams.canvas = canvas;
        drawParams.size = j;
        canvas.save();
        drawModifierNode.draw(this);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.drawParams;
        drawParams2.getClass();
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        drawParams2.density = density;
        Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
        drawParams2.layoutDirection = layoutDirection2;
        Intrinsics.checkNotNullParameter(canvas2, "<set-?>");
        drawParams2.canvas = canvas2;
        drawParams2.size = j2;
        this.drawNode = drawModifierNode2;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-AZ2fEMs */
    public final void mo359drawImageAZ2fEMs(ImageBitmap image, long j, long j2, long j3, long j4, float f, DrawStyle style, ColorFilter colorFilter, int r29, int r30) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(style, "style");
        this.canvasDrawScope.mo359drawImageAZ2fEMs(image, j, j2, j3, j4, f, style, colorFilter, r29, r30);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-gbVJVH8 */
    public final void mo360drawImagegbVJVH8(ImageBitmap image, long j, float f, DrawStyle style, ColorFilter colorFilter, int r16) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(style, "style");
        this.canvasDrawScope.mo360drawImagegbVJVH8(image, j, f, style, colorFilter, r16);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-1RTmtNc */
    public final void mo361drawLine1RTmtNc(Brush brush, long j, long j2, float f, int r20, KMarkerFactory kMarkerFactory, float f2, ColorFilter colorFilter, int r24) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.canvasDrawScope.mo361drawLine1RTmtNc(brush, j, j2, f, r20, kMarkerFactory, f2, colorFilter, r24);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-NGM6Ib0 */
    public final void mo362drawLineNGM6Ib0(long j, long j2, long j3, float f, int r22, KMarkerFactory kMarkerFactory, float f2, ColorFilter colorFilter, int r26) {
        this.canvasDrawScope.mo362drawLineNGM6Ib0(j, j2, j3, f, r22, kMarkerFactory, f2, colorFilter, r26);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-GBMwjPU */
    public final void mo363drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle style, ColorFilter colorFilter, int r14) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        this.canvasDrawScope.mo363drawPathGBMwjPU(path, brush, f, style, colorFilter, r14);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-LG529CI */
    public final void mo364drawPathLG529CI(Path path, long j, float f, DrawStyle style, ColorFilter colorFilter, int r16) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(style, "style");
        this.canvasDrawScope.mo364drawPathLG529CI(path, j, f, style, colorFilter, r16);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-F8ZwMP8 */
    public final void mo365drawPointsF8ZwMP8(ArrayList arrayList, long j, float f, int r16, KMarkerFactory kMarkerFactory, float f2, ColorFilter colorFilter, int r20) {
        this.canvasDrawScope.mo365drawPointsF8ZwMP8(arrayList, j, f, r16, kMarkerFactory, f2, colorFilter, r20);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-AsUm42w */
    public final void mo366drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle style, ColorFilter colorFilter, int r20) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        this.canvasDrawScope.mo366drawRectAsUm42w(brush, j, j2, f, style, colorFilter, r20);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-n-J9OG0 */
    public final void mo367drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle style, ColorFilter colorFilter, int r22) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.canvasDrawScope.mo367drawRectnJ9OG0(j, j2, j3, f, style, colorFilter, r22);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-ZuiqVtQ */
    public final void mo368drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle style, ColorFilter colorFilter, int r24) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        this.canvasDrawScope.mo368drawRoundRectZuiqVtQ(brush, j, j2, j3, f, style, colorFilter, r24);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-u-Aw5IA */
    public final void mo369drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle style, float f, ColorFilter colorFilter, int r26) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.canvasDrawScope.mo369drawRoundRectuAw5IA(j, j2, j3, j4, style, f, colorFilter, r26);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: getCenter-F1C5BW0 */
    public final long mo390getCenterF1C5BW0() {
        return this.canvasDrawScope.mo390getCenterF1C5BW0();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final CanvasDrawScope$drawContext$1 getDrawContext() {
        return this.canvasDrawScope.drawContext;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.drawParams.layoutDirection;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: getSize-NH-jbRc */
    public final long mo391getSizeNHjbRc() {
        return this.canvasDrawScope.mo391getSizeNHjbRc();
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public final int mo44roundToPx0680j_4(float f) {
        return this.canvasDrawScope.mo44roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public final float mo46toDpu2uoSUM(int r2) {
        return this.canvasDrawScope.mo46toDpu2uoSUM(r2);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public final long mo47toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.mo47toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public final float mo48toPxR2X_6o(long j) {
        return this.canvasDrawScope.mo48toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public final float mo49toPx0680j_4(float f) {
        return this.canvasDrawScope.getDensity() * f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public final long mo50toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.mo50toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public final float mo45toDpu2uoSUM(float f) {
        return f / this.canvasDrawScope.getDensity();
    }
}
