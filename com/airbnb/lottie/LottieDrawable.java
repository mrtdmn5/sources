package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Choreographer;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public int alpha;
    public final LottieValueAnimator animator;
    public Rect canvasClipBounds;
    public RectF canvasClipBoundsRectF;
    public boolean clipToCompositionBounds;
    public LottieComposition composition;
    public CompositionLayer compositionLayer;
    public boolean enableMergePaths;
    public FontAssetManager fontAssetManager;
    public boolean ignoreSystemAnimationsDisabled;
    public ImageAssetManager imageAssetManager;
    public String imageAssetsFolder;
    public boolean isApplyingOpacityToLayersEnabled;
    public boolean isDirty;
    public final ArrayList<LazyCompositionTask> lazyCompositionTasks;
    public boolean maintainOriginalImageBounds;
    public OnVisibleAction onVisibleAction;
    public boolean outlineMasksAndMattes;
    public boolean performanceTrackingEnabled;
    public RenderMode renderMode;
    public final Matrix renderingMatrix;
    public boolean safeMode;
    public Bitmap softwareRenderingBitmap;
    public Canvas softwareRenderingCanvas;
    public Rect softwareRenderingDstBoundsRect;
    public RectF softwareRenderingDstBoundsRectF;
    public Matrix softwareRenderingOriginalCanvasMatrix;
    public Matrix softwareRenderingOriginalCanvasMatrixInverse;
    public LPaint softwareRenderingPaint;
    public Rect softwareRenderingSrcBoundsRect;
    public RectF softwareRenderingTransformedBounds;
    public boolean systemAnimationsEnabled;
    public boolean useSoftwareRendering;

    /* renamed from: com.airbnb.lottie.LottieDrawable$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            LottieDrawable lottieDrawable = LottieDrawable.this;
            CompositionLayer compositionLayer = lottieDrawable.compositionLayer;
            if (compositionLayer != null) {
                LottieValueAnimator lottieValueAnimator = lottieDrawable.animator;
                LottieComposition lottieComposition = lottieValueAnimator.composition;
                if (lottieComposition == null) {
                    f = 0.0f;
                } else {
                    float f2 = lottieValueAnimator.frame;
                    float f3 = lottieComposition.startFrame;
                    f = (f2 - f3) / (lottieComposition.endFrame - f3);
                }
                compositionLayer.setProgress(f);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface LazyCompositionTask {
        void run();
    }

    /* loaded from: classes.dex */
    public enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.animator = lottieValueAnimator;
        this.systemAnimationsEnabled = true;
        this.ignoreSystemAnimationsDisabled = false;
        this.safeMode = false;
        this.onVisibleAction = OnVisibleAction.NONE;
        this.lazyCompositionTasks = new ArrayList<>();
        AnonymousClass1 anonymousClass1 = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.LottieDrawable.1
            public AnonymousClass1() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f;
                LottieDrawable lottieDrawable = LottieDrawable.this;
                CompositionLayer compositionLayer = lottieDrawable.compositionLayer;
                if (compositionLayer != null) {
                    LottieValueAnimator lottieValueAnimator2 = lottieDrawable.animator;
                    LottieComposition lottieComposition = lottieValueAnimator2.composition;
                    if (lottieComposition == null) {
                        f = 0.0f;
                    } else {
                        float f2 = lottieValueAnimator2.frame;
                        float f3 = lottieComposition.startFrame;
                        f = (f2 - f3) / (lottieComposition.endFrame - f3);
                    }
                    compositionLayer.setProgress(f);
                }
            }
        };
        this.maintainOriginalImageBounds = false;
        this.clipToCompositionBounds = true;
        this.alpha = 255;
        this.renderMode = RenderMode.AUTOMATIC;
        this.useSoftwareRendering = false;
        this.renderingMatrix = new Matrix();
        this.isDirty = false;
        lottieValueAnimator.addUpdateListener(anonymousClass1);
    }

    public static void convertRect(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public final <T> void addValueCallback(final KeyPath keyPath, final T t, final LottieValueCallback<T> lottieValueCallback) {
        float f;
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda8
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.addValueCallback(keyPath, t, lottieValueCallback);
                }
            });
            return;
        }
        boolean z = true;
        if (keyPath == KeyPath.COMPOSITION) {
            compositionLayer.addValueCallback(lottieValueCallback, t);
        } else {
            KeyPathElement keyPathElement = keyPath.resolvedElement;
            if (keyPathElement != null) {
                keyPathElement.addValueCallback(lottieValueCallback, t);
            } else {
                ArrayList arrayList = new ArrayList();
                this.compositionLayer.resolveKeyPath(keyPath, 0, arrayList, new KeyPath(new String[0]));
                for (int r4 = 0; r4 < arrayList.size(); r4++) {
                    ((KeyPath) arrayList.get(r4)).resolvedElement.addValueCallback(lottieValueCallback, t);
                }
                z = true ^ arrayList.isEmpty();
            }
        }
        if (z) {
            invalidateSelf();
            if (t == LottieProperty.TIME_REMAP) {
                LottieValueAnimator lottieValueAnimator = this.animator;
                LottieComposition lottieComposition = lottieValueAnimator.composition;
                if (lottieComposition == null) {
                    f = 0.0f;
                } else {
                    float f2 = lottieValueAnimator.frame;
                    float f3 = lottieComposition.startFrame;
                    f = (f2 - f3) / (lottieComposition.endFrame - f3);
                }
                setProgress(f);
            }
        }
    }

    public final boolean animationsEnabled() {
        if (!this.systemAnimationsEnabled && !this.ignoreSystemAnimationsDisabled) {
            return false;
        }
        return true;
    }

    public final void buildCompositionLayer() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return;
        }
        JsonReader.Options options = LayerParser.NAMES;
        Rect rect = lottieComposition.bounds;
        CompositionLayer compositionLayer = new CompositionLayer(this, new Layer(Collections.emptyList(), lottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false, null, null), lottieComposition.layers, lottieComposition);
        this.compositionLayer = compositionLayer;
        if (this.outlineMasksAndMattes) {
            compositionLayer.setOutlineMasksAndMattes(true);
        }
        this.compositionLayer.clipToCompositionBounds = this.clipToCompositionBounds;
    }

    public final void clearComposition() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator.running) {
            lottieValueAnimator.cancel();
            if (!isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        lottieValueAnimator.composition = null;
        lottieValueAnimator.minFrame = -2.1474836E9f;
        lottieValueAnimator.maxFrame = 2.1474836E9f;
        invalidateSelf();
    }

    public final void computeRenderMode() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return;
        }
        this.useSoftwareRendering = this.renderMode.useSoftwareRendering(Build.VERSION.SDK_INT, lottieComposition.hasDashPattern, lottieComposition.maskAndMatteCount);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.safeMode) {
            try {
                if (this.useSoftwareRendering) {
                    renderAndDrawAsBitmap(canvas, this.compositionLayer);
                } else {
                    drawDirectlyToCanvas(canvas);
                }
            } catch (Throwable unused) {
                Logger.INSTANCE.getClass();
            }
        } else if (this.useSoftwareRendering) {
            renderAndDrawAsBitmap(canvas, this.compositionLayer);
        } else {
            drawDirectlyToCanvas(canvas);
        }
        this.isDirty = false;
        L.endSection();
    }

    public final void drawDirectlyToCanvas(Canvas canvas) {
        CompositionLayer compositionLayer = this.compositionLayer;
        LottieComposition lottieComposition = this.composition;
        if (compositionLayer != null && lottieComposition != null) {
            Matrix matrix = this.renderingMatrix;
            matrix.reset();
            if (!getBounds().isEmpty()) {
                matrix.preScale(r3.width() / lottieComposition.bounds.width(), r3.height() / lottieComposition.bounds.height());
            }
            compositionLayer.draw(canvas, matrix, this.alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.bounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.bounds.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        if (this.isDirty) {
            return;
        }
        this.isDirty = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.running;
    }

    public final void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.removeFrameCallback(true);
        if (!isVisible()) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
    }

    public final void playAnimation() {
        float minFrame;
        float maxFrame;
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda10
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.playAnimation();
                }
            });
            return;
        }
        computeRenderMode();
        boolean animationsEnabled = animationsEnabled();
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (animationsEnabled || lottieValueAnimator.getRepeatCount() == 0) {
            if (isVisible()) {
                lottieValueAnimator.running = true;
                boolean isReversed = lottieValueAnimator.isReversed();
                Iterator it = lottieValueAnimator.listeners.iterator();
                while (it.hasNext()) {
                    Animator.AnimatorListener animatorListener = (Animator.AnimatorListener) it.next();
                    if (Build.VERSION.SDK_INT >= 26) {
                        animatorListener.onAnimationStart(lottieValueAnimator, isReversed);
                    } else {
                        animatorListener.onAnimationStart(lottieValueAnimator);
                    }
                }
                if (lottieValueAnimator.isReversed()) {
                    minFrame = lottieValueAnimator.getMaxFrame();
                } else {
                    minFrame = lottieValueAnimator.getMinFrame();
                }
                lottieValueAnimator.setFrame((int) minFrame);
                lottieValueAnimator.lastFrameTimeNs = 0L;
                lottieValueAnimator.repeatCount = 0;
                if (lottieValueAnimator.running) {
                    lottieValueAnimator.removeFrameCallback(false);
                    Choreographer.getInstance().postFrameCallback(lottieValueAnimator);
                }
                this.onVisibleAction = OnVisibleAction.NONE;
            } else {
                this.onVisibleAction = OnVisibleAction.PLAY;
            }
        }
        if (!animationsEnabled()) {
            if (lottieValueAnimator.speed < 0.0f) {
                maxFrame = lottieValueAnimator.getMinFrame();
            } else {
                maxFrame = lottieValueAnimator.getMaxFrame();
            }
            setFrame((int) maxFrame);
            lottieValueAnimator.removeFrameCallback(true);
            lottieValueAnimator.notifyEnd(lottieValueAnimator.isReversed());
            if (!isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void renderAndDrawAsBitmap(android.graphics.Canvas r10, com.airbnb.lottie.model.layer.CompositionLayer r11) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieDrawable.renderAndDrawAsBitmap(android.graphics.Canvas, com.airbnb.lottie.model.layer.CompositionLayer):void");
    }

    public final void resumeAnimation() {
        float maxFrame;
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda4
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.resumeAnimation();
                }
            });
            return;
        }
        computeRenderMode();
        boolean animationsEnabled = animationsEnabled();
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (animationsEnabled || lottieValueAnimator.getRepeatCount() == 0) {
            if (isVisible()) {
                lottieValueAnimator.running = true;
                lottieValueAnimator.removeFrameCallback(false);
                Choreographer.getInstance().postFrameCallback(lottieValueAnimator);
                lottieValueAnimator.lastFrameTimeNs = 0L;
                if (lottieValueAnimator.isReversed() && lottieValueAnimator.frame == lottieValueAnimator.getMinFrame()) {
                    lottieValueAnimator.frame = lottieValueAnimator.getMaxFrame();
                } else if (!lottieValueAnimator.isReversed() && lottieValueAnimator.frame == lottieValueAnimator.getMaxFrame()) {
                    lottieValueAnimator.frame = lottieValueAnimator.getMinFrame();
                }
                this.onVisibleAction = OnVisibleAction.NONE;
            } else {
                this.onVisibleAction = OnVisibleAction.RESUME;
            }
        }
        if (!animationsEnabled()) {
            if (lottieValueAnimator.speed < 0.0f) {
                maxFrame = lottieValueAnimator.getMinFrame();
            } else {
                maxFrame = lottieValueAnimator.getMaxFrame();
            }
            setFrame((int) maxFrame);
            lottieValueAnimator.removeFrameCallback(true);
            lottieValueAnimator.notifyEnd(lottieValueAnimator.isReversed());
            if (!isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
        this.alpha = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Logger.warning("Use addColorFilter instead.");
    }

    public final boolean setComposition(LottieComposition lottieComposition) {
        boolean z = false;
        if (this.composition == lottieComposition) {
            return false;
        }
        this.isDirty = true;
        clearComposition();
        this.composition = lottieComposition;
        buildCompositionLayer();
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator.composition == null) {
            z = true;
        }
        lottieValueAnimator.composition = lottieComposition;
        if (z) {
            lottieValueAnimator.setMinAndMaxFrames(Math.max(lottieValueAnimator.minFrame, lottieComposition.startFrame), Math.min(lottieValueAnimator.maxFrame, lottieComposition.endFrame));
        } else {
            lottieValueAnimator.setMinAndMaxFrames((int) lottieComposition.startFrame, (int) lottieComposition.endFrame);
        }
        float f = lottieValueAnimator.frame;
        lottieValueAnimator.frame = 0.0f;
        lottieValueAnimator.setFrame((int) f);
        lottieValueAnimator.notifyUpdate();
        setProgress(lottieValueAnimator.getAnimatedFraction());
        ArrayList<LazyCompositionTask> arrayList = this.lazyCompositionTasks;
        Iterator it = new ArrayList(arrayList).iterator();
        while (it.hasNext()) {
            LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.run();
            }
            it.remove();
        }
        arrayList.clear();
        lottieComposition.performanceTracker.enabled = this.performanceTrackingEnabled;
        computeRenderMode();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public final void setFrame(final int r3) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda11
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.setFrame(r3);
                }
            });
        } else {
            this.animator.setFrame(r3);
        }
    }

    public final void setMaxFrame(final int r3) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda3
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.setMaxFrame(r3);
                }
            });
            return;
        }
        LottieValueAnimator lottieValueAnimator = this.animator;
        lottieValueAnimator.setMinAndMaxFrames(lottieValueAnimator.minFrame, r3 + 0.99f);
    }

    public final void setMaxProgress(final float f) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda9
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.setMaxProgress(f);
                }
            });
            return;
        }
        float f2 = lottieComposition.startFrame;
        float f3 = lottieComposition.endFrame;
        PointF pointF = MiscUtils.pathFromDataCurrentPoint;
        float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f3, f2, f, f2);
        LottieValueAnimator lottieValueAnimator = this.animator;
        lottieValueAnimator.setMinAndMaxFrames(lottieValueAnimator.minFrame, m);
    }

    public final void setMinAndMaxFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda12
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.setMinAndMaxFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int r4 = (int) marker.startFrame;
            setMinAndMaxFrame(r4, ((int) marker.durationFrames) + r4);
            return;
        }
        throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("Cannot find marker with name ", str, InstructionFileId.DOT));
    }

    public final void setMinFrame(final int r3) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda1
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.setMinFrame(r3);
                }
            });
        } else {
            this.animator.setMinAndMaxFrames(r3, (int) r0.maxFrame);
        }
    }

    public final void setMinProgress(final float f) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda2
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.setMinProgress(f);
                }
            });
            return;
        }
        float f2 = lottieComposition.startFrame;
        float f3 = lottieComposition.endFrame;
        PointF pointF = MiscUtils.pathFromDataCurrentPoint;
        setMinFrame((int) DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f3, f2, f, f2));
    }

    public final void setProgress(final float f) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda0
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.setProgress(f);
                }
            });
            return;
        }
        float f2 = lottieComposition.startFrame;
        float f3 = lottieComposition.endFrame;
        PointF pointF = MiscUtils.pathFromDataCurrentPoint;
        this.animator.setFrame(((f3 - f2) * f) + f2);
        L.endSection();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean z3 = !isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            OnVisibleAction onVisibleAction = this.onVisibleAction;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                playAnimation();
            } else if (onVisibleAction == OnVisibleAction.RESUME) {
                resumeAnimation();
            }
        } else if (this.animator.running) {
            pauseAnimation();
            this.onVisibleAction = OnVisibleAction.RESUME;
        } else if (!z3) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        playAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.lazyCompositionTasks.clear();
        LottieValueAnimator lottieValueAnimator = this.animator;
        lottieValueAnimator.removeFrameCallback(true);
        lottieValueAnimator.notifyEnd(lottieValueAnimator.isReversed());
        if (!isVisible()) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final void setMaxFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda5
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.setMaxFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMaxFrame((int) (marker.startFrame + marker.durationFrames));
            return;
        }
        throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("Cannot find marker with name ", str, InstructionFileId.DOT));
    }

    public final void setMinFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda7
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.setMinFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMinFrame((int) marker.startFrame);
            return;
        }
        throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("Cannot find marker with name ", str, InstructionFileId.DOT));
    }

    public final void setMinAndMaxFrame(final String str, final String str2, final boolean z) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda6
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.setMinAndMaxFrame(str, str2, z);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int r4 = (int) marker.startFrame;
            Marker marker2 = this.composition.getMarker(str2);
            if (marker2 != null) {
                setMinAndMaxFrame(r4, (int) (marker2.startFrame + (z ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("Cannot find marker with name ", str2, InstructionFileId.DOT));
        }
        throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("Cannot find marker with name ", str, InstructionFileId.DOT));
    }

    public final void setMinAndMaxFrame(final int r3, final int r4) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda13
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    LottieDrawable.this.setMinAndMaxFrame(r3, r4);
                }
            });
        } else {
            this.animator.setMinAndMaxFrames(r3, r4 + 0.99f);
        }
    }
}
