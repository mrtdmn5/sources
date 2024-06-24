package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class TextLayer extends BaseLayer {
    public final LongSparseArray<String> codePointCache;
    public final ColorKeyframeAnimation colorAnimation;
    public ValueCallbackKeyframeAnimation colorCallbackAnimation;
    public final LottieComposition composition;
    public final HashMap contentsForCharacter;
    public final AnonymousClass1 fillPaint;
    public final LottieDrawable lottieDrawable;
    public final Matrix matrix;
    public final RectF rectF;
    public final StringBuilder stringBuilder;
    public final ColorKeyframeAnimation strokeColorAnimation;
    public ValueCallbackKeyframeAnimation strokeColorCallbackAnimation;
    public final AnonymousClass2 strokePaint;
    public final FloatKeyframeAnimation strokeWidthAnimation;
    public ValueCallbackKeyframeAnimation strokeWidthCallbackAnimation;
    public final TextKeyframeAnimation textAnimation;
    public ValueCallbackKeyframeAnimation textSizeCallbackAnimation;
    public final FloatKeyframeAnimation trackingAnimation;
    public ValueCallbackKeyframeAnimation trackingCallbackAnimation;
    public ValueCallbackKeyframeAnimation typefaceCallbackAnimation;

    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification;

        static {
            int[] r0 = new int[DocumentData.Justification.values().length];
            $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification = r0;
            try {
                r0[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.airbnb.lottie.model.layer.TextLayer$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.airbnb.lottie.model.layer.TextLayer$2] */
    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableColorValue animatableColorValue;
        AnimatableColorValue animatableColorValue2;
        this.stringBuilder = new StringBuilder(2);
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.fillPaint = new Paint() { // from class: com.airbnb.lottie.model.layer.TextLayer.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint() { // from class: com.airbnb.lottie.model.layer.TextLayer.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.contentsForCharacter = new HashMap();
        this.codePointCache = new LongSparseArray<>();
        this.lottieDrawable = lottieDrawable;
        this.composition = layer.composition;
        TextKeyframeAnimation textKeyframeAnimation = new TextKeyframeAnimation(layer.text.keyframes);
        this.textAnimation = textKeyframeAnimation;
        textKeyframeAnimation.addUpdateListener(this);
        addAnimation(textKeyframeAnimation);
        AnimatableTextProperties animatableTextProperties = layer.textProperties;
        if (animatableTextProperties != null && (animatableColorValue2 = animatableTextProperties.color) != null) {
            BaseKeyframeAnimation<?, ?> createAnimation = animatableColorValue2.createAnimation();
            this.colorAnimation = (ColorKeyframeAnimation) createAnimation;
            createAnimation.addUpdateListener(this);
            addAnimation(createAnimation);
        }
        if (animatableTextProperties != null && (animatableColorValue = animatableTextProperties.stroke) != null) {
            BaseKeyframeAnimation<?, ?> createAnimation2 = animatableColorValue.createAnimation();
            this.strokeColorAnimation = (ColorKeyframeAnimation) createAnimation2;
            createAnimation2.addUpdateListener(this);
            addAnimation(createAnimation2);
        }
        if (animatableTextProperties != null && (animatableFloatValue2 = animatableTextProperties.strokeWidth) != null) {
            BaseKeyframeAnimation<?, ?> createAnimation3 = animatableFloatValue2.createAnimation();
            this.strokeWidthAnimation = (FloatKeyframeAnimation) createAnimation3;
            createAnimation3.addUpdateListener(this);
            addAnimation(createAnimation3);
        }
        if (animatableTextProperties != null && (animatableFloatValue = animatableTextProperties.tracking) != null) {
            BaseKeyframeAnimation<?, ?> createAnimation4 = animatableFloatValue.createAnimation();
            this.trackingAnimation = (FloatKeyframeAnimation) createAnimation4;
            createAnimation4.addUpdateListener(this);
            addAnimation(createAnimation4);
        }
    }

    public static void applyJustification(DocumentData.Justification justification, Canvas canvas, float f) {
        int r2 = AnonymousClass3.$SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[justification.ordinal()];
        if (r2 != 2) {
            if (r2 == 3) {
                canvas.translate((-f) / 2.0f, 0.0f);
                return;
            }
            return;
        }
        canvas.translate(-f, 0.0f);
    }

    public static void drawCharacter(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public static void drawGlyph(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public final void addValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        super.addValueCallback(lottieValueCallback, obj);
        if (obj == LottieProperty.COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorCallbackAnimation;
            if (valueCallbackKeyframeAnimation != null) {
                removeAnimation(valueCallbackKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            addAnimation(this.colorCallbackAnimation);
            return;
        }
        if (obj == LottieProperty.STROKE_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = this.strokeColorCallbackAnimation;
            if (valueCallbackKeyframeAnimation3 != null) {
                removeAnimation(valueCallbackKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.strokeColorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.strokeColorCallbackAnimation = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.addUpdateListener(this);
            addAnimation(this.strokeColorCallbackAnimation);
            return;
        }
        if (obj == LottieProperty.STROKE_WIDTH) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = this.strokeWidthCallbackAnimation;
            if (valueCallbackKeyframeAnimation5 != null) {
                removeAnimation(valueCallbackKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.strokeWidthCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation6 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.strokeWidthCallbackAnimation = valueCallbackKeyframeAnimation6;
            valueCallbackKeyframeAnimation6.addUpdateListener(this);
            addAnimation(this.strokeWidthCallbackAnimation);
            return;
        }
        if (obj == LottieProperty.TEXT_TRACKING) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation7 = this.trackingCallbackAnimation;
            if (valueCallbackKeyframeAnimation7 != null) {
                removeAnimation(valueCallbackKeyframeAnimation7);
            }
            if (lottieValueCallback == null) {
                this.trackingCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation8 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.trackingCallbackAnimation = valueCallbackKeyframeAnimation8;
            valueCallbackKeyframeAnimation8.addUpdateListener(this);
            addAnimation(this.trackingCallbackAnimation);
            return;
        }
        if (obj == LottieProperty.TEXT_SIZE) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation9 = this.textSizeCallbackAnimation;
            if (valueCallbackKeyframeAnimation9 != null) {
                removeAnimation(valueCallbackKeyframeAnimation9);
            }
            if (lottieValueCallback == null) {
                this.textSizeCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation10 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.textSizeCallbackAnimation = valueCallbackKeyframeAnimation10;
            valueCallbackKeyframeAnimation10.addUpdateListener(this);
            addAnimation(this.textSizeCallbackAnimation);
            return;
        }
        if (obj == LottieProperty.TYPEFACE) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation11 = this.typefaceCallbackAnimation;
            if (valueCallbackKeyframeAnimation11 != null) {
                removeAnimation(valueCallbackKeyframeAnimation11);
            }
            if (lottieValueCallback == null) {
                this.typefaceCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation12 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.typefaceCallbackAnimation = valueCallbackKeyframeAnimation12;
            valueCallbackKeyframeAnimation12.addUpdateListener(this);
            addAnimation(this.typefaceCallbackAnimation);
            return;
        }
        if (obj == LottieProperty.TEXT) {
            TextKeyframeAnimation textKeyframeAnimation = this.textAnimation;
            textKeyframeAnimation.getClass();
            textKeyframeAnimation.setValueCallback(new LottieValueCallback<DocumentData>() { // from class: com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation.1
                public final /* synthetic */ DocumentData val$documentData;
                public final /* synthetic */ LottieValueCallback val$valueCallback;

                public AnonymousClass1(LottieValueCallback lottieValueCallback2, DocumentData documentData) {
                    r2 = lottieValueCallback2;
                    r3 = documentData;
                }

                /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
                @Override // com.airbnb.lottie.value.LottieValueCallback
                public final DocumentData getValue(LottieFrameInfo<DocumentData> lottieFrameInfo) {
                    DocumentData documentData;
                    float f = lottieFrameInfo.startFrame;
                    float f2 = lottieFrameInfo.endFrame;
                    ?? r2 = lottieFrameInfo.startValue.text;
                    ?? r3 = lottieFrameInfo.endValue.text;
                    float f3 = lottieFrameInfo.linearKeyframeProgress;
                    float f4 = lottieFrameInfo.interpolatedKeyframeProgress;
                    float f5 = lottieFrameInfo.overallProgress;
                    LottieFrameInfo lottieFrameInfo2 = LottieFrameInfo.this;
                    lottieFrameInfo2.startFrame = f;
                    lottieFrameInfo2.endFrame = f2;
                    lottieFrameInfo2.startValue = r2;
                    lottieFrameInfo2.endValue = r3;
                    lottieFrameInfo2.linearKeyframeProgress = f3;
                    lottieFrameInfo2.interpolatedKeyframeProgress = f4;
                    lottieFrameInfo2.overallProgress = f5;
                    String str = (String) r2.getValue(lottieFrameInfo2);
                    if (lottieFrameInfo.interpolatedKeyframeProgress == 1.0f) {
                        documentData = lottieFrameInfo.endValue;
                    } else {
                        documentData = lottieFrameInfo.startValue;
                    }
                    DocumentData documentData2 = documentData;
                    String str2 = documentData2.fontName;
                    float f6 = documentData2.size;
                    DocumentData.Justification justification = documentData2.justification;
                    int r4 = documentData2.tracking;
                    float f7 = documentData2.lineHeight;
                    float f8 = documentData2.baselineShift;
                    int r7 = documentData2.color;
                    int r8 = documentData2.strokeColor;
                    float f9 = documentData2.strokeWidth;
                    boolean z = documentData2.strokeOverFill;
                    DocumentData documentData3 = r3;
                    documentData3.text = str;
                    documentData3.fontName = str2;
                    documentData3.size = f6;
                    documentData3.justification = justification;
                    documentData3.tracking = r4;
                    documentData3.lineHeight = f7;
                    documentData3.baselineShift = f8;
                    documentData3.color = r7;
                    documentData3.strokeColor = r8;
                    documentData3.strokeWidth = f9;
                    documentData3.strokeOverFill = z;
                    return documentData3;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0410  */
    /* JADX WARN: Type inference failed for: r11v2, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3, types: [T, java.lang.String] */
    @Override // com.airbnb.lottie.model.layer.BaseLayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void drawLayer(android.graphics.Canvas r29, android.graphics.Matrix r30, int r31) {
        /*
            Method dump skipped, instructions count: 1309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.drawLayer(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        LottieComposition lottieComposition = this.composition;
        rectF.set(0.0f, 0.0f, lottieComposition.bounds.width(), lottieComposition.bounds.height());
    }
}
