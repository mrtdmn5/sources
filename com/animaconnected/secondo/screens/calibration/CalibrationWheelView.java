package com.animaconnected.secondo.screens.calibration;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import androidx.core.content.ContextCompat;
import com.animaconnected.bluetooth.util.MathsUtils;
import com.animaconnected.secondo.app.animation.CalibrationWheelAnimator;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class CalibrationWheelView extends View {
    private static final int LINES_IN_WHEEL = 120;
    private CalibrationWheelAnimator mAnimator;
    private AnimatorRestarter mAnimatorRestarter;
    private int mCenterX;
    private int mCenterY;
    private double mCurrentAngle;
    private boolean mDrawFinger;
    private double mDrawLineAngle;
    private float mFingerAlphaFade;
    private int mFingerColor;
    private float mFingerDistanceFromCenter;
    private float mFingerRadiusOuter;
    private int mFingerRingColor;
    private float mFingerRingDistanceFromEdge;
    private float mFingerRingStrokeWidth;
    private int mFingerShadowColor;
    private float mFingerShadowStrokeWidth;
    private int mLineColor;
    private float mLineDistanceFromEdge;
    private float mLineStrokeWidth;
    private Paint mPaint;
    private int mStrokeWidth;
    private int mWheelColor;
    private int mWheelHighlightColor;
    private WheelListener mWheelListener;
    private int mWheelRadiusOuter;
    private float mWheelShadowAndHighlightOffset;
    private int mWheelShadowColor;

    /* loaded from: classes3.dex */
    public static class AnimatorRestarter implements Runnable {
        final WeakReference<CalibrationWheelAnimator> mAnimatorRef;

        public AnimatorRestarter(CalibrationWheelAnimator calibrationWheelAnimator) {
            this.mAnimatorRef = new WeakReference<>(calibrationWheelAnimator);
        }

        @Override // java.lang.Runnable
        public void run() {
            CalibrationWheelAnimator calibrationWheelAnimator = this.mAnimatorRef.get();
            if (calibrationWheelAnimator != null) {
                calibrationWheelAnimator.start();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface WheelListener {
        void onCalibrationWheelTouched();

        void onNewCalibrationReached(double d);
    }

    public CalibrationWheelView(Context context) {
        super(context);
        init(context);
    }

    private double calculateAngleFromCenter(float f, float f2) {
        return Math.atan2(f2 - (getHeight() / 2.0f), f - (getWidth() / 2.0f));
    }

    private boolean coordinatesOutsideArea(float f, float f2) {
        int r0 = this.mCenterX;
        float f3 = (f - r0) * (f - r0);
        int r02 = this.mCenterY;
        double sqrt = Math.sqrt(DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f2, r02, f2 - r02, f3));
        int r03 = this.mWheelRadiusOuter;
        if (sqrt >= r03 - this.mStrokeWidth && sqrt <= r03) {
            return false;
        }
        return true;
    }

    private void drawFinger(Canvas canvas) {
        float cos = (float) ((Math.cos(this.mDrawLineAngle) * this.mFingerDistanceFromCenter) + this.mCenterX);
        float sin = (float) ((Math.sin(this.mDrawLineAngle) * this.mFingerDistanceFromCenter) + this.mCenterY);
        this.mPaint.setColor(getColorWithFadedAlpha(this.mFingerColor, this.mFingerAlphaFade));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cos, sin, this.mFingerRadiusOuter, this.mPaint);
        this.mPaint.setColor(getColorWithFadedAlpha(this.mFingerRingColor, this.mFingerAlphaFade));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mFingerRingStrokeWidth);
        canvas.drawCircle(cos, sin, (this.mFingerRadiusOuter - this.mFingerRingDistanceFromEdge) - (this.mFingerRingStrokeWidth / 2.0f), this.mPaint);
        this.mPaint.setColor(getColorWithFadedAlpha(this.mFingerShadowColor, this.mFingerAlphaFade));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mFingerShadowStrokeWidth);
        canvas.drawCircle(cos, sin, (this.mFingerShadowStrokeWidth / 2.0f) + this.mFingerRadiusOuter, this.mPaint);
    }

    private void drawLines(Canvas canvas) {
        this.mPaint.setColor(this.mLineColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mLineStrokeWidth);
        double d = this.mDrawLineAngle + 0.0d;
        int r1 = this.mWheelRadiusOuter;
        float f = r1 - this.mStrokeWidth;
        float f2 = this.mLineDistanceFromEdge;
        float f3 = f + f2;
        float f4 = r1 - f2;
        for (int r5 = 0; r5 < 120; r5++) {
            double d2 = (((r5 * 2) * 3.141592653589793d) / 120.0d) + d;
            double d3 = f3;
            double d4 = f4;
            canvas.drawLine((float) ((Math.cos(d2) * d3) + this.mCenterX), (float) ((Math.sin(d2) * d3) + this.mCenterY), (float) ((Math.cos(d2) * d4) + this.mCenterX), (float) ((Math.sin(d2) * d4) + this.mCenterY), this.mPaint);
        }
    }

    private void drawWheel(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setColor(this.mWheelHighlightColor);
        canvas.drawCircle(this.mCenterX, this.mCenterY - this.mWheelShadowAndHighlightOffset, this.mWheelRadiusOuter - (this.mStrokeWidth / 2.0f), this.mPaint);
        this.mPaint.setColor(this.mWheelShadowColor);
        canvas.drawCircle(this.mCenterX, this.mCenterY + this.mWheelShadowAndHighlightOffset, this.mWheelRadiusOuter - (this.mStrokeWidth / 2.0f), this.mPaint);
        this.mPaint.setColor(this.mWheelColor);
        canvas.drawCircle(this.mCenterX, this.mCenterY, this.mWheelRadiusOuter - (this.mStrokeWidth / 2.0f), this.mPaint);
    }

    private int getColorWithFadedAlpha(int r3, float f) {
        int alpha = (int) ((Color.alpha(r3) * f) + 0.5f);
        if (alpha < 0) {
            alpha = 0;
        } else if (alpha > 255) {
            alpha = 255;
        }
        return Color.argb(alpha, Color.red(r3), Color.green(r3), Color.blue(r3));
    }

    private void init(Context context) {
        Resources resources = getResources();
        Object obj = ContextCompat.sLock;
        this.mWheelColor = ContextCompat.Api23Impl.getColor(context, R.color.calibrationWheelColor);
        this.mWheelHighlightColor = ContextCompat.Api23Impl.getColor(context, R.color.calibrationWheelHighlightColor);
        this.mWheelShadowColor = ContextCompat.Api23Impl.getColor(context, R.color.calibrationFingerShadowColor);
        this.mLineStrokeWidth = resources.getDimension(R.dimen.calibration_wheel_line_stroke);
        this.mLineColor = ContextCompat.Api23Impl.getColor(context, R.color.calibrationLineColor);
        this.mFingerColor = ContextCompat.Api23Impl.getColor(context, R.color.calibrationFingerColor);
        this.mFingerRingDistanceFromEdge = resources.getDimension(R.dimen.calibration_wheel_finger_ring_distance_from_edge);
        this.mFingerRingStrokeWidth = resources.getDimension(R.dimen.calibration_wheel_finger_ring_stroke);
        this.mFingerRingColor = ContextCompat.Api23Impl.getColor(context, R.color.calibrationFingerRingColor);
        this.mFingerShadowStrokeWidth = resources.getDimension(R.dimen.calibration_wheel_finger_shadow_stroke);
        this.mFingerShadowColor = ContextCompat.Api23Impl.getColor(context, R.color.calibrationFingerShadowColor);
        this.mPaint = new Paint(1);
        CalibrationWheelAnimator calibrationWheelAnimator = new CalibrationWheelAnimator();
        this.mAnimator = calibrationWheelAnimator;
        calibrationWheelAnimator.setListener(new CalibrationWheelAnimator.Listener() { // from class: com.animaconnected.secondo.screens.calibration.CalibrationWheelView.1
            @Override // com.animaconnected.secondo.app.animation.CalibrationWheelAnimator.Listener
            public void onWheelAnimationEnd(CalibrationWheelAnimator calibrationWheelAnimator2) {
                CalibrationWheelView calibrationWheelView = CalibrationWheelView.this;
                calibrationWheelView.mAnimatorRestarter = new AnimatorRestarter(calibrationWheelView.mAnimator);
                CalibrationWheelView calibrationWheelView2 = CalibrationWheelView.this;
                calibrationWheelView2.postDelayed(calibrationWheelView2.mAnimatorRestarter, 3000L);
            }

            @Override // com.animaconnected.secondo.app.animation.CalibrationWheelAnimator.Listener
            public void onWheelAnimationUpdate(float f, float f2) {
                CalibrationWheelView.this.mDrawLineAngle = f;
                CalibrationWheelView.this.mFingerAlphaFade = f2;
                CalibrationWheelView.this.invalidate();
            }
        });
    }

    public void cancelHintAnimation() {
        this.mDrawFinger = false;
        this.mAnimator.cancel();
        AnimatorRestarter animatorRestarter = this.mAnimatorRestarter;
        if (animatorRestarter != null) {
            removeCallbacks(animatorRestarter);
            this.mAnimatorRestarter = null;
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        drawWheel(canvas);
        drawLines(canvas);
        if (this.mDrawFinger) {
            drawFinger(canvas);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int r4, int r5, int r6, int r7) {
        super.onLayout(z, r4, r5, r6, r7);
        int paddingLeft = ((r6 - r4) - getPaddingLeft()) - getPaddingRight();
        int paddingTop = ((r7 - r5) - getPaddingTop()) - getPaddingBottom();
        this.mWheelRadiusOuter = (int) (Math.min(paddingLeft, paddingTop) / 2.5d);
        this.mCenterX = (paddingLeft / 2) + getPaddingLeft();
        this.mCenterY = (paddingTop / 2) + getPaddingBottom();
        int r3 = this.mWheelRadiusOuter;
        int r42 = r3 / 2;
        this.mStrokeWidth = r42;
        this.mWheelShadowAndHighlightOffset = r42 * 0.02f;
        this.mLineDistanceFromEdge = r42 * 0.1f;
        this.mFingerDistanceFromCenter = r3 - (r42 / 2.0f);
        this.mFingerRadiusOuter = (r42 * 0.8f) / 2.0f;
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        int size = View.MeasureSpec.getSize(r2);
        int size2 = View.MeasureSpec.getSize(r3);
        if (View.MeasureSpec.getMode(r3) != 0) {
            size2 = size;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                double calculateAngleFromCenter = calculateAngleFromCenter(x, y);
                if (coordinatesOutsideArea(x, y)) {
                    this.mCurrentAngle = calculateAngleFromCenter;
                    return true;
                }
                this.mDrawLineAngle = calculateAngleFromCenter;
                invalidate();
                this.mWheelListener.onNewCalibrationReached(MathsUtils.floorMod((calculateAngleFromCenter - this.mCurrentAngle) + 3.141592653589793d, 6.283185307179586d) - 3.141592653589793d);
                this.mCurrentAngle = calculateAngleFromCenter;
            }
        } else {
            if (coordinatesOutsideArea(x, y)) {
                return true;
            }
            cancelHintAnimation();
            this.mCurrentAngle = calculateAngleFromCenter(x, y);
            this.mWheelListener.onCalibrationWheelTouched();
        }
        return true;
    }

    public void setWheelListener(WheelListener wheelListener) {
        this.mWheelListener = wheelListener;
    }

    public void startHintAnimation() {
        this.mDrawFinger = true;
        this.mAnimator.start();
    }

    public CalibrationWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CalibrationWheelView(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        init(context);
    }
}
