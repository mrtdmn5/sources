package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Path;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RenderNodeApi29.android.kt */
/* loaded from: classes.dex */
public final class RenderNodeApi29 implements DeviceRenderNode {
    public final RenderNode renderNode;

    public RenderNodeApi29(AndroidComposeView ownerView) {
        Intrinsics.checkNotNullParameter(ownerView, "ownerView");
        this.renderNode = RenderNodeApi29$$ExternalSyntheticApiModelOutline41.m();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void drawInto(Canvas canvas) {
        canvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final float getAlpha() {
        float alpha;
        alpha = this.renderNode.getAlpha();
        return alpha;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final int getBottom() {
        int bottom;
        bottom = this.renderNode.getBottom();
        return bottom;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final boolean getClipToBounds() {
        boolean clipToBounds;
        clipToBounds = this.renderNode.getClipToBounds();
        return clipToBounds;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final boolean getClipToOutline() {
        boolean clipToOutline;
        clipToOutline = this.renderNode.getClipToOutline();
        return clipToOutline;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final float getElevation() {
        float elevation;
        elevation = this.renderNode.getElevation();
        return elevation;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final boolean getHasDisplayList() {
        boolean hasDisplayList;
        hasDisplayList = this.renderNode.hasDisplayList();
        return hasDisplayList;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final int getHeight() {
        int height;
        height = this.renderNode.getHeight();
        return height;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final int getLeft() {
        int left;
        left = this.renderNode.getLeft();
        return left;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void getMatrix(Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.renderNode.getMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final int getRight() {
        int right;
        right = this.renderNode.getRight();
        return right;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final int getTop() {
        int top;
        top = this.renderNode.getTop();
        return top;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final int getWidth() {
        int width;
        width = this.renderNode.getWidth();
        return width;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void offsetLeftAndRight(int r2) {
        this.renderNode.offsetLeftAndRight(r2);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void offsetTopAndBottom(int r2) {
        this.renderNode.offsetTopAndBottom(r2);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void record(CanvasHolder canvasHolder, Path path, Function1<? super androidx.compose.ui.graphics.Canvas, Unit> function1) {
        RecordingCanvas beginRecording;
        Intrinsics.checkNotNullParameter(canvasHolder, "canvasHolder");
        RenderNode renderNode = this.renderNode;
        beginRecording = renderNode.beginRecording();
        Intrinsics.checkNotNullExpressionValue(beginRecording, "renderNode.beginRecording()");
        AndroidCanvas androidCanvas = canvasHolder.androidCanvas;
        Canvas canvas = androidCanvas.internalCanvas;
        androidCanvas.internalCanvas = beginRecording;
        if (path != null) {
            androidCanvas.save();
            androidCanvas.mo282clipPathmtrdDE(path, 1);
        }
        function1.invoke(androidCanvas);
        if (path != null) {
            androidCanvas.restore();
        }
        androidCanvas.setInternalCanvas(canvas);
        renderNode.endRecording();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setAlpha(float f) {
        this.renderNode.setAlpha(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setAmbientShadowColor(int r2) {
        this.renderNode.setAmbientShadowColor(r2);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setCameraDistance(float f) {
        this.renderNode.setCameraDistance(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setClipToBounds(boolean z) {
        this.renderNode.setClipToBounds(z);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setClipToOutline(boolean z) {
        this.renderNode.setClipToOutline(z);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    /* renamed from: setCompositingStrategy-aDBOjCE */
    public final void mo497setCompositingStrategyaDBOjCE(int r5) {
        boolean z;
        boolean z2 = false;
        if (r5 == 1) {
            z = true;
        } else {
            z = false;
        }
        RenderNode renderNode = this.renderNode;
        if (z) {
            renderNode.setUseCompositingLayer(true, null);
            renderNode.setHasOverlappingRendering(true);
            return;
        }
        if (r5 == 2) {
            z2 = true;
        }
        if (z2) {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setElevation(float f) {
        this.renderNode.setElevation(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final boolean setHasOverlappingRendering() {
        boolean hasOverlappingRendering;
        hasOverlappingRendering = this.renderNode.setHasOverlappingRendering(true);
        return hasOverlappingRendering;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setOutline(Outline outline) {
        this.renderNode.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setPivotX(float f) {
        this.renderNode.setPivotX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setPivotY(float f) {
        this.renderNode.setPivotY(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final boolean setPosition(int r2, int r3, int r4, int r5) {
        boolean position;
        position = this.renderNode.setPosition(r2, r3, r4, r5);
        return position;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setRenderEffect() {
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeApi29VerificationHelper.INSTANCE.setRenderEffect(this.renderNode, null);
        }
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setRotationX(float f) {
        this.renderNode.setRotationX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setRotationY(float f) {
        this.renderNode.setRotationY(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setRotationZ(float f) {
        this.renderNode.setRotationZ(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setScaleX(float f) {
        this.renderNode.setScaleX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setScaleY(float f) {
        this.renderNode.setScaleY(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setSpotShadowColor(int r2) {
        this.renderNode.setSpotShadowColor(r2);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setTranslationX(float f) {
        this.renderNode.setTranslationX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final void setTranslationY(float f) {
        this.renderNode.setTranslationY(f);
    }
}
