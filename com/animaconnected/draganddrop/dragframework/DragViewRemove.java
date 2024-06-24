package com.animaconnected.draganddrop.dragframework;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.dragframework.DragLayer;

/* loaded from: classes.dex */
public class DragViewRemove extends View {
    private static final float sDragAlpha = 1.0f;
    private final Bitmap mBitmap;
    private Bitmap mCrossFadeBitmap;
    private float mCrossFadeProgress;
    private Rect mDragRegion;
    private Point mDragVisualizeOffset;
    private float mInitialScale;
    private float mIntrinsicIconScale;
    private float mOffsetX;
    private float mOffsetY;
    private final Paint mPaint;
    private final int mRegistrationX;
    private final int mRegistrationY;

    public DragViewRemove(Context context, Bitmap bitmap, int r4, int r5, int r6, int r7, int r8, int r9, float f) {
        super(context);
        this.mDragVisualizeOffset = null;
        this.mDragRegion = null;
        this.mCrossFadeProgress = 0.0f;
        this.mOffsetX = 0.0f;
        this.mOffsetY = 0.0f;
        this.mIntrinsicIconScale = sDragAlpha;
        this.mInitialScale = f;
        getResources().getDimensionPixelSize(R.dimen.dragViewScale);
        setScaleX(f);
        setScaleY(f);
        this.mBitmap = Bitmap.createBitmap(bitmap, r6, r7, r8, r9);
        setDragRegion(new Rect(0, 0, r8, r9));
        this.mRegistrationX = r4;
        this.mRegistrationY = r5;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        measure(makeMeasureSpec, makeMeasureSpec);
        this.mPaint = new Paint(2);
        setElevation(getResources().getDimension(R.dimen.drag_elevation_removed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$crossFade$0(ValueAnimator valueAnimator) {
        this.mCrossFadeProgress = valueAnimator.getAnimatedFraction();
    }

    private ValueAnimator ofFloat(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        return valueAnimator;
    }

    public void crossFade(int r4) {
        ValueAnimator ofFloat = ofFloat(0.0f, sDragAlpha);
        ofFloat.setDuration(r4);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.draganddrop.dragframework.DragViewRemove$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DragViewRemove.this.lambda$crossFade$0(valueAnimator);
            }
        });
        ofFloat.start();
    }

    public Rect getDragRegion() {
        return this.mDragRegion;
    }

    public int getDragRegionHeight() {
        return this.mDragRegion.height();
    }

    public int getDragRegionLeft() {
        return this.mDragRegion.left;
    }

    public int getDragRegionTop() {
        return this.mDragRegion.top;
    }

    public int getDragRegionWidth() {
        return this.mDragRegion.width();
    }

    public Point getDragVisualizeOffset() {
        return this.mDragVisualizeOffset;
    }

    public float getInitialScale() {
        return this.mInitialScale;
    }

    public float getIntrinsicIconScaleFactor() {
        return this.mIntrinsicIconScale;
    }

    public float getOffsetY() {
        return this.mOffsetY;
    }

    public void move(int r2, int r3) {
        setTranslationX((r2 - this.mRegistrationX) + ((int) this.mOffsetX));
        setTranslationY((r3 - this.mRegistrationY) + ((int) this.mOffsetY));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        int r0;
        float f = this.mCrossFadeProgress;
        if (f > 0.0f && this.mCrossFadeBitmap != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (z) {
                r0 = (int) ((sDragAlpha - f) * 255.0f);
            } else {
                r0 = 255;
            }
            this.mPaint.setAlpha(r0);
        }
        canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.mPaint);
        if (z) {
            this.mPaint.setAlpha((int) (this.mCrossFadeProgress * 255.0f));
            canvas.save();
            canvas.scale((this.mBitmap.getWidth() * sDragAlpha) / this.mCrossFadeBitmap.getWidth(), (this.mBitmap.getHeight() * sDragAlpha) / this.mCrossFadeBitmap.getHeight());
            canvas.drawBitmap(this.mCrossFadeBitmap, 0.0f, 0.0f, this.mPaint);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        setMeasuredDimension(this.mBitmap.getWidth(), this.mBitmap.getHeight());
    }

    public void resetLayoutParams() {
        this.mOffsetY = 0.0f;
        this.mOffsetX = 0.0f;
        requestLayout();
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        super.setAlpha(f);
        this.mPaint.setAlpha((int) (f * 255.0f));
        invalidate();
    }

    public void setCrossFadeBitmap(Bitmap bitmap) {
        this.mCrossFadeBitmap = bitmap;
    }

    public void setDragRegion(Rect rect) {
        this.mDragRegion = rect;
    }

    public void setDragVisualizeOffset(Point point) {
        this.mDragVisualizeOffset = point;
    }

    public void setIntrinsicIconScaleFactor(float f) {
        this.mIntrinsicIconScale = f;
    }

    public void show(int r3, int r4) {
        DragLayer.LayoutParams layoutParams = new DragLayer.LayoutParams(0, 0);
        ((FrameLayout.LayoutParams) layoutParams).width = this.mBitmap.getWidth();
        ((FrameLayout.LayoutParams) layoutParams).height = this.mBitmap.getHeight();
        layoutParams.customPosition = true;
        setLayoutParams(layoutParams);
        setTranslationX(r3);
        setTranslationY(r4);
    }

    public void updateInitialScaleToCurrentScale() {
        this.mInitialScale = getScaleX();
    }
}
