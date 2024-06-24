package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.DropShadowEffect;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class ShapeLayer extends BaseLayer {
    public final CompositionLayer compositionLayer;
    public final ContentGroup contentGroup;

    public ShapeLayer(LottieDrawable lottieDrawable, Layer layer, CompositionLayer compositionLayer) {
        super(lottieDrawable, layer);
        this.compositionLayer = compositionLayer;
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.shapes, false));
        this.contentGroup = contentGroup;
        contentGroup.setContents(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void drawLayer(Canvas canvas, Matrix matrix, int r4) {
        this.contentGroup.draw(canvas, matrix, r4);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final BlurEffect getBlurEffect() {
        BlurEffect blurEffect = this.layerModel.blurEffect;
        if (blurEffect != null) {
            return blurEffect;
        }
        return this.compositionLayer.layerModel.blurEffect;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        this.contentGroup.getBounds(rectF, this.boundsMatrix, z);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final DropShadowEffect getDropShadowEffect() {
        DropShadowEffect dropShadowEffect = this.layerModel.dropShadowEffect;
        if (dropShadowEffect != null) {
            return dropShadowEffect;
        }
        return this.compositionLayer.layerModel.dropShadowEffect;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void resolveChildKeyPath(KeyPath keyPath, int r3, ArrayList arrayList, KeyPath keyPath2) {
        this.contentGroup.resolveKeyPath(keyPath, r3, arrayList, keyPath2);
    }
}
