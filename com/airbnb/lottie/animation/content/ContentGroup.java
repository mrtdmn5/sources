package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    public final List<Content> contents;
    public final boolean hidden;
    public final LottieDrawable lottieDrawable;
    public final Matrix matrix;
    public final String name;
    public final LPaint offScreenPaint;
    public final RectF offScreenRectF;
    public final Path path;
    public ArrayList pathContents;
    public final RectF rect;
    public final TransformKeyframeAnimation transformAnimation;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ContentGroup(com.airbnb.lottie.LottieDrawable r8, com.airbnb.lottie.model.layer.BaseLayer r9, com.airbnb.lottie.model.content.ShapeGroup r10) {
        /*
            r7 = this;
            java.lang.String r3 = r10.name
            boolean r4 = r10.hidden
            java.util.ArrayList r5 = new java.util.ArrayList
            java.util.List<com.airbnb.lottie.model.content.ContentModel> r10 = r10.items
            int r0 = r10.size()
            r5.<init>(r0)
            r0 = 0
            r1 = r0
        L11:
            int r2 = r10.size()
            if (r1 >= r2) goto L29
            java.lang.Object r2 = r10.get(r1)
            com.airbnb.lottie.model.content.ContentModel r2 = (com.airbnb.lottie.model.content.ContentModel) r2
            com.airbnb.lottie.animation.content.Content r2 = r2.toContent(r8, r9)
            if (r2 == 0) goto L26
            r5.add(r2)
        L26:
            int r1 = r1 + 1
            goto L11
        L29:
            int r1 = r10.size()
            if (r0 >= r1) goto L40
            java.lang.Object r1 = r10.get(r0)
            com.airbnb.lottie.model.content.ContentModel r1 = (com.airbnb.lottie.model.content.ContentModel) r1
            boolean r2 = r1 instanceof com.airbnb.lottie.model.animatable.AnimatableTransform
            if (r2 == 0) goto L3d
            com.airbnb.lottie.model.animatable.AnimatableTransform r1 = (com.airbnb.lottie.model.animatable.AnimatableTransform) r1
            r6 = r1
            goto L42
        L3d:
            int r0 = r0 + 1
            goto L29
        L40:
            r10 = 0
            r6 = r10
        L42:
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.ContentGroup.<init>(com.airbnb.lottie.LottieDrawable, com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.content.ShapeGroup):void");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void addValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.applyValueCallback(lottieValueCallback, obj);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void draw(Canvas canvas, Matrix matrix, int r10) {
        boolean z;
        int intValue;
        if (this.hidden) {
            return;
        }
        Matrix matrix2 = this.matrix;
        matrix2.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            matrix2.preConcat(transformKeyframeAnimation.getMatrix());
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = transformKeyframeAnimation.opacity;
            if (baseKeyframeAnimation == null) {
                intValue = 100;
            } else {
                intValue = baseKeyframeAnimation.getValue().intValue();
            }
            r10 = (int) ((((intValue / 100.0f) * r10) / 255.0f) * 255.0f);
        }
        boolean z2 = this.lottieDrawable.isApplyingOpacityToLayersEnabled;
        boolean z3 = false;
        List<Content> list = this.contents;
        if (z2) {
            int r9 = 0;
            int r5 = 0;
            while (true) {
                if (r9 < list.size()) {
                    if ((list.get(r9) instanceof DrawingContent) && (r5 = r5 + 1) >= 2) {
                        z = true;
                        break;
                    }
                    r9++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z && r10 != 255) {
                z3 = true;
            }
        }
        if (z3) {
            RectF rectF = this.offScreenRectF;
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            getBounds(rectF, matrix2, true);
            LPaint lPaint = this.offScreenPaint;
            lPaint.setAlpha(r10);
            Utils.AnonymousClass1 anonymousClass1 = Utils.threadLocalPathMeasure;
            canvas.saveLayer(rectF, lPaint);
            L.endSection();
        }
        if (z3) {
            r10 = 255;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).draw(canvas, matrix2, r10);
            }
        }
        if (z3) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getBounds(RectF rectF, Matrix matrix, boolean z) {
        Matrix matrix2 = this.matrix;
        matrix2.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            matrix2.preConcat(transformKeyframeAnimation.getMatrix());
        }
        RectF rectF2 = this.rect;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        List<Content> list = this.contents;
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                Content content = list.get(size);
                if (content instanceof DrawingContent) {
                    ((DrawingContent) content).getBounds(rectF2, matrix2, z);
                    rectF.union(rectF2);
                }
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path getPath() {
        Matrix matrix = this.matrix;
        matrix.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            matrix.set(transformKeyframeAnimation.getMatrix());
        }
        Path path = this.path;
        path.reset();
        if (this.hidden) {
            return path;
        }
        List<Content> list = this.contents;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof PathContent) {
                path.addPath(((PathContent) content).getPath(), matrix);
            }
        }
        return path;
    }

    public final List<PathContent> getPathList() {
        if (this.pathContents == null) {
            this.pathContents = new ArrayList();
            int r0 = 0;
            while (true) {
                List<Content> list = this.contents;
                if (r0 >= list.size()) {
                    break;
                }
                Content content = list.get(r0);
                if (content instanceof PathContent) {
                    this.pathContents.add((PathContent) content);
                }
                r0++;
            }
        }
        return this.pathContents;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void resolveKeyPath(KeyPath keyPath, int r5, ArrayList arrayList, KeyPath keyPath2) {
        String str = this.name;
        if (!keyPath.matches(r5, str) && !"__container".equals(str)) {
            return;
        }
        if (!"__container".equals(str)) {
            keyPath2.getClass();
            KeyPath keyPath3 = new KeyPath(keyPath2);
            keyPath3.keys.add(str);
            if (keyPath.fullyResolvesTo(r5, str)) {
                KeyPath keyPath4 = new KeyPath(keyPath3);
                keyPath4.resolvedElement = this;
                arrayList.add(keyPath4);
            }
            keyPath2 = keyPath3;
        }
        if (keyPath.propagateToChildren(r5, str)) {
            int incrementDepthBy = keyPath.incrementDepthBy(r5, str) + r5;
            int r52 = 0;
            while (true) {
                List<Content> list = this.contents;
                if (r52 < list.size()) {
                    Content content = list.get(r52);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).resolveKeyPath(keyPath, incrementDepthBy, arrayList, keyPath2);
                    }
                    r52++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void setContents(List<Content> list, List<Content> list2) {
        int size = list.size();
        List<Content> list3 = this.contents;
        ArrayList arrayList = new ArrayList(list3.size() + size);
        arrayList.addAll(list);
        for (int size2 = list3.size() - 1; size2 >= 0; size2--) {
            Content content = list3.get(size2);
            content.setContents(arrayList, list3.subList(0, size2));
            arrayList.add(content);
        }
    }

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z, ArrayList arrayList, AnimatableTransform animatableTransform) {
        this.offScreenPaint = new LPaint();
        this.offScreenRectF = new RectF();
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = str;
        this.lottieDrawable = lottieDrawable;
        this.hidden = z;
        this.contents = arrayList;
        if (animatableTransform != null) {
            TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
            this.transformAnimation = transformKeyframeAnimation;
            transformKeyframeAnimation.addAnimationsToLayer(baseLayer);
            transformKeyframeAnimation.addListener(this);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            Content content = (Content) arrayList.get(size);
            if (content instanceof GreedyContent) {
                arrayList2.add((GreedyContent) content);
            }
        }
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                return;
            } else {
                ((GreedyContent) arrayList2.get(size2)).absorbContent(arrayList.listIterator(arrayList.size()));
            }
        }
    }
}
