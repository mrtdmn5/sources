package com.airbnb.lottie.model.layer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public final class ImageLayer extends BaseLayer {
    public ValueCallbackKeyframeAnimation colorFilterAnimation;
    public final Rect dst;
    public ValueCallbackKeyframeAnimation imageAnimation;
    public final LottieImageAsset lottieImageAsset;
    public final LPaint paint;
    public final Rect src;

    public ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        LottieImageAsset lottieImageAsset;
        this.paint = new LPaint(3);
        this.src = new Rect();
        this.dst = new Rect();
        LottieComposition lottieComposition = lottieDrawable.composition;
        if (lottieComposition == null) {
            lottieImageAsset = null;
        } else {
            lottieImageAsset = lottieComposition.images.get(layer.refId);
        }
        this.lottieImageAsset = lottieImageAsset;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public final void addValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        super.addValueCallback(lottieValueCallback, obj);
        if (obj == LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            } else {
                this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
                return;
            }
        }
        if (obj == LottieProperty.IMAGE) {
            if (lottieValueCallback == null) {
                this.imageAnimation = null;
            } else {
                this.imageAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x011a  */
    @Override // com.airbnb.lottie.model.layer.BaseLayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void drawLayer(android.graphics.Canvas r13, android.graphics.Matrix r14, int r15) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.ImageLayer.drawLayer(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        if (this.lottieImageAsset != null) {
            float dpScale = Utils.dpScale();
            rectF.set(0.0f, 0.0f, r3.width * dpScale, r3.height * dpScale);
            this.boundsMatrix.mapRect(rectF);
        }
    }
}
