package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class CompositionLayer extends BaseLayer {
    public boolean clipToCompositionBounds;
    public final Paint layerPaint;
    public final ArrayList layers;
    public final RectF newClipRect;
    public final RectF rect;
    public BaseKeyframeAnimation<Float, Float> timeRemapping;

    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;

        static {
            int[] r0 = new int[Layer.MatteType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = r0;
            try {
                r0[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        BaseLayer baseLayer;
        BaseLayer shapeLayer;
        this.layers = new ArrayList();
        this.rect = new RectF();
        this.newClipRect = new RectF();
        this.layerPaint = new Paint();
        this.clipToCompositionBounds = true;
        AnimatableFloatValue animatableFloatValue = layer.timeRemapping;
        if (animatableFloatValue != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = animatableFloatValue.createAnimation();
            this.timeRemapping = createAnimation;
            addAnimation(createAnimation);
            this.timeRemapping.addUpdateListener(this);
        } else {
            this.timeRemapping = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.layers.size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size >= 0) {
                Layer layer2 = list.get(size);
                switch (BaseLayer.AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[layer2.layerType.ordinal()]) {
                    case 1:
                        shapeLayer = new ShapeLayer(lottieDrawable, layer2, this);
                        break;
                    case 2:
                        shapeLayer = new CompositionLayer(lottieDrawable, layer2, lottieComposition.precomps.get(layer2.refId), lottieComposition);
                        break;
                    case 3:
                        shapeLayer = new SolidLayer(lottieDrawable, layer2);
                        break;
                    case 4:
                        shapeLayer = new ImageLayer(lottieDrawable, layer2);
                        break;
                    case 5:
                        shapeLayer = new NullLayer(lottieDrawable, layer2);
                        break;
                    case 6:
                        shapeLayer = new TextLayer(lottieDrawable, layer2);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder("Unknown layer type ");
                        sb.append(layer2.layerType);
                        Logger.warning(sb.toString());
                        shapeLayer = null;
                        break;
                }
                if (shapeLayer != null) {
                    longSparseArray.put(shapeLayer.layerModel.layerId, shapeLayer);
                    if (baseLayer2 != null) {
                        baseLayer2.matteLayer = shapeLayer;
                        baseLayer2 = null;
                    } else {
                        this.layers.add(0, shapeLayer);
                        int r4 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[layer2.matteType.ordinal()];
                        if (r4 == 1 || r4 == 2) {
                            baseLayer2 = shapeLayer;
                        }
                    }
                }
                size--;
            } else {
                for (int r42 = 0; r42 < longSparseArray.size(); r42++) {
                    if (longSparseArray.mGarbage) {
                        longSparseArray.gc();
                    }
                    BaseLayer baseLayer3 = (BaseLayer) longSparseArray.get(longSparseArray.mKeys[r42], null);
                    if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.get(baseLayer3.layerModel.parentId, null)) != null) {
                        baseLayer3.parentLayer = baseLayer;
                    }
                }
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public final void addValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        super.addValueCallback(lottieValueCallback, obj);
        if (obj == LottieProperty.TIME_REMAP) {
            if (lottieValueCallback == null) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.timeRemapping;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.setValueCallback(null);
                    return;
                }
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.timeRemapping = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            addAnimation(this.timeRemapping);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void drawLayer(Canvas canvas, Matrix matrix, int r12) {
        boolean z;
        boolean z2;
        boolean z3;
        RectF rectF = this.newClipRect;
        Layer layer = this.layerModel;
        rectF.set(0.0f, 0.0f, layer.preCompWidth, layer.preCompHeight);
        matrix.mapRect(rectF);
        boolean z4 = this.lottieDrawable.isApplyingOpacityToLayersEnabled;
        ArrayList arrayList = this.layers;
        if (z4 && arrayList.size() > 1 && r12 != 255) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Paint paint = this.layerPaint;
            paint.setAlpha(r12);
            Utils.AnonymousClass1 anonymousClass1 = Utils.threadLocalPathMeasure;
            canvas.saveLayer(rectF, paint);
            L.endSection();
        } else {
            canvas.save();
        }
        if (z) {
            r12 = 255;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!this.clipToCompositionBounds && "__container".equals(layer.layerName)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !rectF.isEmpty()) {
                z3 = canvas.clipRect(rectF);
            } else {
                z3 = true;
            }
            if (z3) {
                ((BaseLayer) arrayList.get(size)).draw(canvas, matrix, r12);
            }
        }
        canvas.restore();
        L.endSection();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        ArrayList arrayList = this.layers;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            RectF rectF2 = this.rect;
            rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((BaseLayer) arrayList.get(size)).getBounds(rectF2, this.boundsMatrix, true);
            rectF.union(rectF2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void resolveChildKeyPath(KeyPath keyPath, int r5, ArrayList arrayList, KeyPath keyPath2) {
        int r0 = 0;
        while (true) {
            ArrayList arrayList2 = this.layers;
            if (r0 < arrayList2.size()) {
                ((BaseLayer) arrayList2.get(r0)).resolveKeyPath(keyPath, r5, arrayList, keyPath2);
                r0++;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void setOutlineMasksAndMattes(boolean z) {
        super.setOutlineMasksAndMattes(z);
        Iterator it = this.layers.iterator();
        while (it.hasNext()) {
            ((BaseLayer) it.next()).setOutlineMasksAndMattes(z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void setProgress(float f) {
        super.setProgress(f);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.timeRemapping;
        Layer layer = this.layerModel;
        if (baseKeyframeAnimation != null) {
            LottieComposition lottieComposition = this.lottieDrawable.composition;
            f = ((baseKeyframeAnimation.getValue().floatValue() * layer.composition.frameRate) - layer.composition.startFrame) / ((lottieComposition.endFrame - lottieComposition.startFrame) + 0.01f);
        }
        if (this.timeRemapping == null) {
            LottieComposition lottieComposition2 = layer.composition;
            f -= layer.startFrame / (lottieComposition2.endFrame - lottieComposition2.startFrame);
        }
        if (layer.timeStretch != 0.0f && !"__container".equals(layer.layerName)) {
            f /= layer.timeStretch;
        }
        ArrayList arrayList = this.layers;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                ((BaseLayer) arrayList.get(size)).setProgress(f);
            } else {
                return;
            }
        }
    }
}
