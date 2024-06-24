package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewLayer.android.kt */
/* loaded from: classes.dex */
public final class ViewLayer extends View implements OwnedLayer {
    public static boolean hasRetrievedMethod;
    public static Field recreateDisplayList;
    public static boolean shouldUseDispatchDraw;
    public static Method updateDisplayListIfDirtyMethod;
    public final CanvasHolder canvasHolder;
    public Rect clipBoundsCache;
    public boolean clipToBounds;
    public final DrawChildContainer container;
    public Function1<? super Canvas, Unit> drawBlock;
    public boolean drawnWithZ;
    public Function0<Unit> invalidateParentLayer;
    public boolean isInvalidated;
    public final long layerId;
    public boolean mHasOverlappingRendering;
    public long mTransformOrigin;
    public final LayerMatrixCache<View> matrixCache;
    public final OutlineResolver outlineResolver;
    public final AndroidComposeView ownerView;
    public static final ViewLayer$Companion$getMatrix$1 getMatrix = ViewLayer$Companion$getMatrix$1.INSTANCE;
    public static final ViewLayer$Companion$OutlineProvider$1 OutlineProvider = new ViewLayer$Companion$OutlineProvider$1();

    /* compiled from: ViewLayer.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        @SuppressLint({"BanUncheckedReflection"})
        public static void updateDisplayList(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                if (!ViewLayer.hasRetrievedMethod) {
                    ViewLayer.hasRetrievedMethod = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.updateDisplayListIfDirtyMethod = View.class.getDeclaredMethod("updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                    } else {
                        ViewLayer.updateDisplayListIfDirtyMethod = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(View.class, "mRecreateDisplayList");
                    }
                    Method method = ViewLayer.updateDisplayListIfDirtyMethod;
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    Field field = ViewLayer.recreateDisplayList;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = ViewLayer.recreateDisplayList;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method2 = ViewLayer.updateDisplayListIfDirtyMethod;
                if (method2 != null) {
                    method2.invoke(view, new Object[0]);
                }
            } catch (Throwable unused) {
                ViewLayer.shouldUseDispatchDraw = true;
            }
        }
    }

    /* compiled from: ViewLayer.android.kt */
    /* loaded from: classes.dex */
    public static final class UniqueDrawingIdApi29 {
        public static final long getUniqueDrawingId(View view) {
            long uniqueDrawingId;
            Intrinsics.checkNotNullParameter(view, "view");
            uniqueDrawingId = view.getUniqueDrawingId();
            return uniqueDrawingId;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewLayer(AndroidComposeView ownerView, DrawChildContainer drawChildContainer, Function1 drawBlock, NodeCoordinator$invalidateParentLayer$1 invalidateParentLayer) {
        super(ownerView.getContext());
        Intrinsics.checkNotNullParameter(ownerView, "ownerView");
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        this.ownerView = ownerView;
        this.container = drawChildContainer;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        this.outlineResolver = new OutlineResolver(ownerView.getDensity());
        this.canvasHolder = new CanvasHolder();
        this.matrixCache = new LayerMatrixCache<>(getMatrix);
        this.mTransformOrigin = TransformOrigin.Center;
        this.mHasOverlappingRendering = true;
        setWillNotDraw(false);
        drawChildContainer.addView(this);
        this.layerId = View.generateViewId();
    }

    private final Path getManualClipPath() {
        if (getClipToOutline()) {
            OutlineResolver outlineResolver = this.outlineResolver;
            if (!(!outlineResolver.usePathForClip)) {
                outlineResolver.updateCache();
                return outlineResolver.outlinePath;
            }
        }
        return null;
    }

    private final void setInvalidated(boolean z) {
        if (z != this.isInvalidated) {
            this.isInvalidated = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final void destroy() {
        setInvalidated(false);
        AndroidComposeView androidComposeView = this.ownerView;
        androidComposeView.observationClearRequested = true;
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        androidComposeView.recycle$ui_release(this);
        this.container.removeViewInLayout(this);
    }

    @Override // android.view.View
    public final void dispatchDraw(android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        boolean z = false;
        setInvalidated(false);
        CanvasHolder canvasHolder = this.canvasHolder;
        AndroidCanvas androidCanvas = canvasHolder.androidCanvas;
        android.graphics.Canvas canvas2 = androidCanvas.internalCanvas;
        androidCanvas.getClass();
        androidCanvas.internalCanvas = canvas;
        Path manualClipPath = getManualClipPath();
        AndroidCanvas androidCanvas2 = canvasHolder.androidCanvas;
        if (manualClipPath != null || !canvas.isHardwareAccelerated()) {
            androidCanvas2.save();
            this.outlineResolver.clipToOutline(androidCanvas2);
            z = true;
        }
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke(androidCanvas2);
        }
        if (z) {
            androidCanvas2.restore();
        }
        androidCanvas2.setInternalCanvas(canvas2);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final void drawLayer(Canvas canvas) {
        boolean z;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getElevation() > 0.0f) {
            z = true;
        } else {
            z = false;
        }
        this.drawnWithZ = z;
        if (z) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    public final DrawChildContainer getContainer() {
        return this.container;
    }

    public long getLayerId() {
        return this.layerId;
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1L;
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    @Override // android.view.View, androidx.compose.ui.node.OwnedLayer
    public final void invalidate() {
        if (!this.isInvalidated) {
            setInvalidated(true);
            super.invalidate();
            this.ownerView.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public final boolean mo477isInLayerk4lQ0M(long j) {
        float m259getXimpl = Offset.m259getXimpl(j);
        float m260getYimpl = Offset.m260getYimpl(j);
        if (this.clipToBounds) {
            if (0.0f <= m259getXimpl && m259getXimpl < getWidth() && 0.0f <= m260getYimpl && m260getYimpl < getHeight()) {
                return true;
            }
            return false;
        }
        if (!getClipToOutline()) {
            return true;
        }
        return this.outlineResolver.m502isInOutlinek4lQ0M(j);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final void mapBounds(MutableRect mutableRect, boolean z) {
        LayerMatrixCache<View> layerMatrixCache = this.matrixCache;
        if (z) {
            float[] m500calculateInverseMatrixbWbORWo = layerMatrixCache.m500calculateInverseMatrixbWbORWo(this);
            if (m500calculateInverseMatrixbWbORWo != null) {
                Matrix.m339mapimpl(m500calculateInverseMatrixbWbORWo, mutableRect);
                return;
            }
            mutableRect.left = 0.0f;
            mutableRect.top = 0.0f;
            mutableRect.right = 0.0f;
            mutableRect.bottom = 0.0f;
            return;
        }
        Matrix.m339mapimpl(layerMatrixCache.m501calculateMatrixGrdbGEg(this), mutableRect);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public final long mo478mapOffset8S9VItk(long j, boolean z) {
        LayerMatrixCache<View> layerMatrixCache = this.matrixCache;
        if (z) {
            float[] m500calculateInverseMatrixbWbORWo = layerMatrixCache.m500calculateInverseMatrixbWbORWo(this);
            if (m500calculateInverseMatrixbWbORWo != null) {
                return Matrix.m338mapMKHz9U(m500calculateInverseMatrixbWbORWo, j);
            }
            int r2 = Offset.$r8$clinit;
            return Offset.Infinite;
        }
        return Matrix.m338mapMKHz9U(layerMatrixCache.m501calculateMatrixGrdbGEg(this), j);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public final void mo479movegyyYBs(long j) {
        int r0 = IntOffset.$r8$clinit;
        int r02 = (int) (j >> 32);
        int left = getLeft();
        LayerMatrixCache<View> layerMatrixCache = this.matrixCache;
        if (r02 != left) {
            offsetLeftAndRight(r02 - getLeft());
            layerMatrixCache.invalidate();
        }
        int m590getYimpl = IntOffset.m590getYimpl(j);
        if (m590getYimpl != getTop()) {
            offsetTopAndBottom(m590getYimpl - getTop());
            layerMatrixCache.invalidate();
        }
    }

    public final void resetClipBounds() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Intrinsics.checkNotNull(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public final void mo480resizeozmzZPI(long j) {
        ViewLayer$Companion$OutlineProvider$1 viewLayer$Companion$OutlineProvider$1;
        int r1 = (int) (j >> 32);
        int m593getHeightimpl = IntSize.m593getHeightimpl(j);
        if (r1 != getWidth() || m593getHeightimpl != getHeight()) {
            long j2 = this.mTransformOrigin;
            int r8 = TransformOrigin.$r8$clinit;
            float f = r1;
            setPivotX(Float.intBitsToFloat((int) (j2 >> 32)) * f);
            float f2 = m593getHeightimpl;
            setPivotY(TransformOrigin.m345getPivotFractionYimpl(this.mTransformOrigin) * f2);
            long Size = SizeKt.Size(f, f2);
            OutlineResolver outlineResolver = this.outlineResolver;
            if (!Size.m273equalsimpl0(outlineResolver.size, Size)) {
                outlineResolver.size = Size;
                outlineResolver.cacheIsDirty = true;
            }
            if (outlineResolver.getOutline() != null) {
                viewLayer$Companion$OutlineProvider$1 = OutlineProvider;
            } else {
                viewLayer$Companion$OutlineProvider$1 = null;
            }
            setOutlineProvider(viewLayer$Companion$OutlineProvider$1);
            layout(getLeft(), getTop(), getLeft() + r1, getTop() + m593getHeightimpl);
            resetClipBounds();
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final void reuseLayer(Function1 drawBlock, NodeCoordinator$invalidateParentLayer$1 invalidateParentLayer) {
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        this.container.addView(this);
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.Center;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    public final void setCameraDistancePx(float f) {
        setCameraDistance(f * getResources().getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final void updateDisplayList() {
        if (this.isInvalidated && !shouldUseDispatchDraw) {
            setInvalidated(false);
            Companion.updateDisplayList(this);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: updateLayerProperties-dDxr-wY */
    public final void mo481updateLayerPropertiesdDxrwY(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, long j2, long j3, int r31, LayoutDirection layoutDirection, Density density) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        this.mTransformOrigin = j;
        setScaleX(f);
        setScaleY(f2);
        setAlpha(f3);
        setTranslationX(f4);
        setTranslationY(f5);
        setElevation(f6);
        setRotation(f9);
        setRotationX(f7);
        setRotationY(f8);
        long j4 = this.mTransformOrigin;
        int r3 = TransformOrigin.$r8$clinit;
        setPivotX(Float.intBitsToFloat((int) (j4 >> 32)) * getWidth());
        setPivotY(TransformOrigin.m345getPivotFractionYimpl(this.mTransformOrigin) * getHeight());
        setCameraDistancePx(f10);
        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = RectangleShapeKt.RectangleShape;
        boolean z2 = true;
        this.clipToBounds = z && shape == rectangleShapeKt$RectangleShape$1;
        resetClipBounds();
        boolean z3 = getManualClipPath() != null;
        setClipToOutline(z && shape != rectangleShapeKt$RectangleShape$1);
        boolean update = this.outlineResolver.update(shape, getAlpha(), getClipToOutline(), getElevation(), layoutDirection, density);
        setOutlineProvider(this.outlineResolver.getOutline() != null ? OutlineProvider : null);
        boolean z4 = getManualClipPath() != null;
        if (z3 != z4 || (z4 && update)) {
            invalidate();
        }
        if (!this.drawnWithZ && getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        this.matrixCache.invalidate();
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 28) {
            ViewLayerVerificationHelper28 viewLayerVerificationHelper28 = ViewLayerVerificationHelper28.INSTANCE;
            viewLayerVerificationHelper28.setOutlineAmbientShadowColor(this, ColorKt.m327toArgb8_81llA(j2));
            viewLayerVerificationHelper28.setOutlineSpotShadowColor(this, ColorKt.m327toArgb8_81llA(j3));
        }
        if (r1 >= 31) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this, null);
        }
        if (r31 == 1) {
            setLayerType(2, null);
        } else {
            if (r31 == 2) {
                setLayerType(0, null);
                z2 = false;
            } else {
                setLayerType(0, null);
            }
        }
        this.mHasOverlappingRendering = z2;
    }

    @Override // android.view.View
    public final void forceLayout() {
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
    }
}
