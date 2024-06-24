package androidx.compose.ui.platform;

import android.os.Build;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RenderNodeLayer.android.kt */
/* loaded from: classes.dex */
public final class RenderNodeLayer implements OwnedLayer {
    public static final RenderNodeLayer$Companion$getMatrix$1 getMatrix = RenderNodeLayer$Companion$getMatrix$1.INSTANCE;
    public final CanvasHolder canvasHolder;
    public Function1<? super Canvas, Unit> drawBlock;
    public boolean drawnWithZ;
    public Function0<Unit> invalidateParentLayer;
    public boolean isDestroyed;
    public boolean isDirty;
    public final LayerMatrixCache<DeviceRenderNode> matrixCache;
    public final OutlineResolver outlineResolver;
    public final AndroidComposeView ownerView;
    public final DeviceRenderNode renderNode;
    public AndroidPaint softwareLayerPaint;
    public long transformOrigin;

    public RenderNodeLayer(AndroidComposeView ownerView, Function1 drawBlock, NodeCoordinator$invalidateParentLayer$1 invalidateParentLayer) {
        DeviceRenderNode renderNodeApi23;
        Intrinsics.checkNotNullParameter(ownerView, "ownerView");
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        this.ownerView = ownerView;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        this.outlineResolver = new OutlineResolver(ownerView.getDensity());
        this.matrixCache = new LayerMatrixCache<>(getMatrix);
        this.canvasHolder = new CanvasHolder();
        this.transformOrigin = TransformOrigin.Center;
        if (Build.VERSION.SDK_INT >= 29) {
            renderNodeApi23 = new RenderNodeApi29(ownerView);
        } else {
            renderNodeApi23 = new RenderNodeApi23(ownerView);
        }
        renderNodeApi23.setHasOverlappingRendering();
        this.renderNode = renderNodeApi23;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final void destroy() {
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.getHasDisplayList()) {
            deviceRenderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        AndroidComposeView androidComposeView = this.ownerView;
        androidComposeView.observationClearRequested = true;
        androidComposeView.recycle$ui_release(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final void drawLayer(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
        android.graphics.Canvas canvas3 = ((AndroidCanvas) canvas).internalCanvas;
        boolean isHardwareAccelerated = canvas3.isHardwareAccelerated();
        boolean z = false;
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (isHardwareAccelerated) {
            updateDisplayList();
            if (deviceRenderNode.getElevation() > 0.0f) {
                z = true;
            }
            this.drawnWithZ = z;
            if (z) {
                canvas.enableZ();
            }
            deviceRenderNode.drawInto(canvas3);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = deviceRenderNode.getLeft();
        float top = deviceRenderNode.getTop();
        float right = deviceRenderNode.getRight();
        float bottom = deviceRenderNode.getBottom();
        if (deviceRenderNode.getAlpha() < 1.0f) {
            AndroidPaint androidPaint = this.softwareLayerPaint;
            if (androidPaint == null) {
                androidPaint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = androidPaint;
            }
            androidPaint.setAlpha(deviceRenderNode.getAlpha());
            canvas3.saveLayer(left, top, right, bottom, androidPaint.internalPaint);
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.mo284concat58bKbWc(this.matrixCache.m501calculateMatrixGrdbGEg(deviceRenderNode));
        if (deviceRenderNode.getClipToOutline() || deviceRenderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke(canvas);
        }
        canvas.restore();
        setDirty(false);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final void invalidate() {
        if (!this.isDirty && !this.isDestroyed) {
            this.ownerView.invalidate();
            setDirty(true);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public final boolean mo477isInLayerk4lQ0M(long j) {
        float m259getXimpl = Offset.m259getXimpl(j);
        float m260getYimpl = Offset.m260getYimpl(j);
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.getClipToBounds()) {
            if (0.0f <= m259getXimpl && m259getXimpl < deviceRenderNode.getWidth() && 0.0f <= m260getYimpl && m260getYimpl < deviceRenderNode.getHeight()) {
                return true;
            }
            return false;
        }
        if (!deviceRenderNode.getClipToOutline()) {
            return true;
        }
        return this.outlineResolver.m502isInOutlinek4lQ0M(j);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final void mapBounds(MutableRect mutableRect, boolean z) {
        DeviceRenderNode deviceRenderNode = this.renderNode;
        LayerMatrixCache<DeviceRenderNode> layerMatrixCache = this.matrixCache;
        if (z) {
            float[] m500calculateInverseMatrixbWbORWo = layerMatrixCache.m500calculateInverseMatrixbWbORWo(deviceRenderNode);
            if (m500calculateInverseMatrixbWbORWo == null) {
                mutableRect.left = 0.0f;
                mutableRect.top = 0.0f;
                mutableRect.right = 0.0f;
                mutableRect.bottom = 0.0f;
                return;
            }
            Matrix.m339mapimpl(m500calculateInverseMatrixbWbORWo, mutableRect);
            return;
        }
        Matrix.m339mapimpl(layerMatrixCache.m501calculateMatrixGrdbGEg(deviceRenderNode), mutableRect);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public final long mo478mapOffset8S9VItk(long j, boolean z) {
        DeviceRenderNode deviceRenderNode = this.renderNode;
        LayerMatrixCache<DeviceRenderNode> layerMatrixCache = this.matrixCache;
        if (z) {
            float[] m500calculateInverseMatrixbWbORWo = layerMatrixCache.m500calculateInverseMatrixbWbORWo(deviceRenderNode);
            if (m500calculateInverseMatrixbWbORWo != null) {
                return Matrix.m338mapMKHz9U(m500calculateInverseMatrixbWbORWo, j);
            }
            int r3 = Offset.$r8$clinit;
            return Offset.Infinite;
        }
        return Matrix.m338mapMKHz9U(layerMatrixCache.m501calculateMatrixGrdbGEg(deviceRenderNode), j);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public final void mo479movegyyYBs(long j) {
        DeviceRenderNode deviceRenderNode = this.renderNode;
        int left = deviceRenderNode.getLeft();
        int top = deviceRenderNode.getTop();
        int r3 = (int) (j >> 32);
        int m590getYimpl = IntOffset.m590getYimpl(j);
        if (left != r3 || top != m590getYimpl) {
            if (left != r3) {
                deviceRenderNode.offsetLeftAndRight(r3 - left);
            }
            if (top != m590getYimpl) {
                deviceRenderNode.offsetTopAndBottom(m590getYimpl - top);
            }
            int r6 = Build.VERSION.SDK_INT;
            AndroidComposeView androidComposeView = this.ownerView;
            if (r6 >= 26) {
                WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(androidComposeView);
            } else {
                androidComposeView.invalidate();
            }
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public final void mo480resizeozmzZPI(long j) {
        int r1 = (int) (j >> 32);
        int m593getHeightimpl = IntSize.m593getHeightimpl(j);
        long j2 = this.transformOrigin;
        int r8 = TransformOrigin.$r8$clinit;
        float f = r1;
        float intBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) * f;
        DeviceRenderNode deviceRenderNode = this.renderNode;
        deviceRenderNode.setPivotX(intBitsToFloat);
        float f2 = m593getHeightimpl;
        deviceRenderNode.setPivotY(TransformOrigin.m345getPivotFractionYimpl(this.transformOrigin) * f2);
        if (deviceRenderNode.setPosition(deviceRenderNode.getLeft(), deviceRenderNode.getTop(), deviceRenderNode.getLeft() + r1, deviceRenderNode.getTop() + m593getHeightimpl)) {
            long Size = SizeKt.Size(f, f2);
            OutlineResolver outlineResolver = this.outlineResolver;
            if (!Size.m273equalsimpl0(outlineResolver.size, Size)) {
                outlineResolver.size = Size;
                outlineResolver.cacheIsDirty = true;
            }
            deviceRenderNode.setOutline(outlineResolver.getOutline());
            if (!this.isDirty && !this.isDestroyed) {
                this.ownerView.invalidate();
                setDirty(true);
            }
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final void reuseLayer(Function1 drawBlock, NodeCoordinator$invalidateParentLayer$1 invalidateParentLayer) {
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.Center;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    public final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.ui.node.OwnedLayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateDisplayList() {
        /*
            r4 = this;
            boolean r0 = r4.isDirty
            androidx.compose.ui.platform.DeviceRenderNode r1 = r4.renderNode
            if (r0 != 0) goto Lc
            boolean r0 = r1.getHasDisplayList()
            if (r0 != 0) goto L2e
        Lc:
            r0 = 0
            r4.setDirty(r0)
            boolean r0 = r1.getClipToOutline()
            if (r0 == 0) goto L24
            androidx.compose.ui.platform.OutlineResolver r0 = r4.outlineResolver
            boolean r2 = r0.usePathForClip
            r2 = r2 ^ 1
            if (r2 != 0) goto L24
            r0.updateCache()
            androidx.compose.ui.graphics.Path r0 = r0.outlinePath
            goto L25
        L24:
            r0 = 0
        L25:
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.Canvas, kotlin.Unit> r2 = r4.drawBlock
            if (r2 == 0) goto L2e
            androidx.compose.ui.graphics.CanvasHolder r3 = r4.canvasHolder
            r1.record(r3, r0, r2)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.RenderNodeLayer.updateDisplayList():void");
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: updateLayerProperties-dDxr-wY */
    public final void mo481updateLayerPropertiesdDxrwY(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, long j2, long j3, int r33, LayoutDirection layoutDirection, Density density) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        this.transformOrigin = j;
        DeviceRenderNode deviceRenderNode = this.renderNode;
        boolean clipToOutline = deviceRenderNode.getClipToOutline();
        OutlineResolver outlineResolver = this.outlineResolver;
        boolean z2 = false;
        boolean z3 = clipToOutline && !(outlineResolver.usePathForClip ^ true);
        deviceRenderNode.setScaleX(f);
        deviceRenderNode.setScaleY(f2);
        deviceRenderNode.setAlpha(f3);
        deviceRenderNode.setTranslationX(f4);
        deviceRenderNode.setTranslationY(f5);
        deviceRenderNode.setElevation(f6);
        deviceRenderNode.setAmbientShadowColor(ColorKt.m327toArgb8_81llA(j2));
        deviceRenderNode.setSpotShadowColor(ColorKt.m327toArgb8_81llA(j3));
        deviceRenderNode.setRotationZ(f9);
        deviceRenderNode.setRotationX(f7);
        deviceRenderNode.setRotationY(f8);
        deviceRenderNode.setCameraDistance(f10);
        int r7 = TransformOrigin.$r8$clinit;
        deviceRenderNode.setPivotX(Float.intBitsToFloat((int) (j >> 32)) * deviceRenderNode.getWidth());
        deviceRenderNode.setPivotY(TransformOrigin.m345getPivotFractionYimpl(j) * deviceRenderNode.getHeight());
        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = RectangleShapeKt.RectangleShape;
        deviceRenderNode.setClipToOutline(z && shape != rectangleShapeKt$RectangleShape$1);
        deviceRenderNode.setClipToBounds(z && shape == rectangleShapeKt$RectangleShape$1);
        deviceRenderNode.setRenderEffect();
        deviceRenderNode.mo497setCompositingStrategyaDBOjCE(r33);
        boolean update = this.outlineResolver.update(shape, deviceRenderNode.getAlpha(), deviceRenderNode.getClipToOutline(), deviceRenderNode.getElevation(), layoutDirection, density);
        deviceRenderNode.setOutline(outlineResolver.getOutline());
        if (deviceRenderNode.getClipToOutline() && !(!outlineResolver.usePathForClip)) {
            z2 = true;
        }
        AndroidComposeView androidComposeView = this.ownerView;
        if (z3 == z2 && (!z2 || !update)) {
            if (Build.VERSION.SDK_INT >= 26) {
                WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(androidComposeView);
            } else {
                androidComposeView.invalidate();
            }
        } else if (!this.isDirty && !this.isDestroyed) {
            androidComposeView.invalidate();
            setDirty(true);
        }
        if (!this.drawnWithZ && deviceRenderNode.getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        this.matrixCache.invalidate();
    }
}
