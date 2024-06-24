package com.animaconnected.secondo.screens.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Keep;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.R;

/* loaded from: classes3.dex */
public class ActivityView extends View {
    private static final int LINE_STROKE_WIDTH_DP = 1;
    private static final float LINE_TO_ACTIVITY_OFFSET_DP_FACTOR = 32.0f;
    private static final int MARK_STROKE_WIDTH_DP = 1;
    private static final String MAX_ACTIVITY = "100";
    private static final float MAX_SPAN_ANGLE = 300.0f;
    private static final String MIN_ACTIVITY = "0";
    private static final float MIN_ANGLE = 270.0f;
    private static final float START_AND_END_LINES_END_OFFSET_DP_FACTOR = 2.286f;
    private static final float START_AND_END_LINES_START_OFFSET_DP_FACTOR = 2.9f;
    private static final int START_AND_END_LINES_WIDTH_DP = 2;
    private static final int STEP_MARKS = 60;
    private static final int STEP_MARKS_SHOWN = 50;
    private static final float TEXT_OFFSET_X_DP_FACTOR = 20.0f;
    private static final float TEXT_SIZE_SP_FACTOR = 22.857f;
    private static final float TWO_PI = 6.2831855f;
    private final RectF mActivityViewRect;
    private int mActivityViewStrokeWidth;
    private final PointF mCenter;
    private float mChange;
    private final Context mContext;
    private float mEndLineEndX;
    private float mEndLineEndY;
    private float mEndLineStartX;
    private float mEndLineStartY;
    private final Paint mLinePaint;
    private final RectF mLineViewRect;
    private int mMarkLinesEndOffset;
    private final Paint mMarkPaint1;
    private final Paint mMarkPaint2;
    private int mMarkStrokeColor1;
    private int mMarkStrokeColor2;
    private int mMaxSteps;
    private boolean mOnSizeChangedCalled;
    private boolean mScaling;
    private boolean mShouldStartAnimations;
    private float mSpanAngleAnimation;
    private float mSpanAngleTarget;
    private final Paint mStartAndEndLinesPaint;
    private int mStartAndEndLinesStartOffset;
    private float mStartLineEndX;
    private float mStartLineEndY;
    private float mStartLineStartX;
    private float mStartLineStartY;
    private int mSteps;
    private int mStepsAnimationTarget;
    private ObjectAnimator mStepsAnimator;
    private int mStepsLineColor;
    private final Paint mStepsPaint;
    private int mStepsStrokeColor;
    private int mTextOffsetX;
    private final Paint mTextPaint;
    private int mTextSize;

    public ActivityView(Context context) {
        super(context);
        this.mCenter = new PointF();
        this.mActivityViewRect = new RectF();
        this.mLineViewRect = new RectF();
        this.mStepsPaint = new Paint(1);
        this.mLinePaint = new Paint(1);
        this.mStartAndEndLinesPaint = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mMarkPaint1 = new Paint(1);
        this.mMarkPaint2 = new Paint(1);
        this.mMaxSteps = 0;
        this.mSteps = 0;
        this.mStepsAnimationTarget = 0;
        this.mSpanAngleTarget = 0.0f;
        this.mSpanAngleAnimation = 0.0f;
        this.mChange = 0.0f;
        this.mStepsStrokeColor = 1346855055;
        this.mStepsLineColor = 1346855055;
        this.mMarkStrokeColor1 = 869849304;
        this.mMarkStrokeColor2 = 1725487320;
        this.mActivityViewStrokeWidth = 40;
        this.mContext = context;
        init(null);
    }

    private void drawLine(Canvas canvas) {
        canvas.drawArc(this.mLineViewRect, MIN_ANGLE, MAX_SPAN_ANGLE, false, this.mLinePaint);
    }

    private void drawMarks(Canvas canvas) {
        for (int r0 = 0; r0 <= Math.min(60, 50); r0++) {
            double d = (r0 / 60.0f) * 6.2831854820251465d;
            float sin = ((float) Math.sin(d)) * this.mStartAndEndLinesStartOffset;
            float f = ((float) (-Math.cos(d))) * this.mStartAndEndLinesStartOffset;
            float sin2 = ((float) Math.sin(d)) * this.mMarkLinesEndOffset;
            float f2 = ((float) (-Math.cos(d))) * this.mMarkLinesEndOffset;
            if (r0 % 5 != 0) {
                PointF pointF = this.mCenter;
                float f3 = pointF.x;
                float f4 = pointF.y;
                canvas.drawLine(f3 + sin, f4 + f, f3 + sin2, f4 + f2, this.mMarkPaint1);
            } else {
                PointF pointF2 = this.mCenter;
                float f5 = pointF2.x;
                float f6 = pointF2.y;
                canvas.drawLine(f5 + sin, f6 + f, f5 + sin2, f6 + f2, this.mMarkPaint2);
            }
        }
    }

    private void drawStartAndEndActivity(Canvas canvas) {
        canvas.drawText(MIN_ACTIVITY, this.mCenter.x, this.mTextSize, this.mTextPaint);
        PointF pointF = this.mCenter;
        canvas.drawText(MAX_ACTIVITY, (pointF.x + this.mEndLineEndX) - this.mTextOffsetX, pointF.y + this.mEndLineEndY, this.mTextPaint);
    }

    private void drawStartAndEndLines(Canvas canvas) {
        PointF pointF = this.mCenter;
        float f = pointF.x;
        float f2 = f + this.mStartLineStartX;
        float f3 = pointF.y;
        canvas.drawLine(f2, f3 + this.mStartLineStartY, f + this.mStartLineEndX, f3 + this.mStartLineEndY, this.mStartAndEndLinesPaint);
        PointF pointF2 = this.mCenter;
        float f4 = pointF2.x;
        float f5 = f4 + this.mEndLineStartX;
        float f6 = pointF2.y;
        canvas.drawLine(f5, f6 + this.mEndLineStartY, f4 + this.mEndLineEndX, f6 + this.mEndLineEndY, this.mStartAndEndLinesPaint);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ActivityView, 0, 0);
            try {
                this.mStepsStrokeColor = obtainStyledAttributes.getInteger(4, this.mStepsStrokeColor);
                this.mStepsLineColor = obtainStyledAttributes.getInteger(0, this.mStepsLineColor);
                this.mMarkStrokeColor1 = obtainStyledAttributes.getInteger(2, this.mMarkStrokeColor1);
                this.mMarkStrokeColor2 = obtainStyledAttributes.getInteger(1, this.mMarkStrokeColor2);
                this.mActivityViewStrokeWidth = obtainStyledAttributes.getDimensionPixelOffset(5, this.mActivityViewStrokeWidth);
                this.mScaling = obtainStyledAttributes.getBoolean(3, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.mStepsPaint.setStyle(Paint.Style.STROKE);
        this.mLinePaint.setStyle(Paint.Style.STROKE);
        this.mStartAndEndLinesPaint.setStyle(Paint.Style.STROKE);
        this.mMarkPaint1.setStyle(Paint.Style.STROKE);
        this.mMarkPaint2.setStyle(Paint.Style.STROKE);
        setStepsStrokeColor(this.mStepsStrokeColor);
        setStrokeWidth(this.mActivityViewStrokeWidth);
        int applyDimension = (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics());
        int applyDimension3 = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.mLinePaint.setStrokeWidth(applyDimension);
        this.mLinePaint.setColor(this.mStepsLineColor);
        this.mStartAndEndLinesPaint.setStrokeWidth(applyDimension3);
        this.mStartAndEndLinesPaint.setColor(this.mStepsLineColor);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setColor(this.mStepsLineColor);
        this.mMarkPaint1.setColor(this.mMarkStrokeColor1);
        this.mMarkPaint2.setColor(this.mMarkStrokeColor2);
        float f = applyDimension2;
        this.mMarkPaint1.setStrokeWidth(f);
        this.mMarkPaint2.setStrokeWidth(f);
    }

    private void initOffsets() {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int width = getWidth() - paddingLeft;
        int height = getHeight() - paddingBottom;
        float f = width / 2.0f;
        float f2 = height;
        float f3 = f2 / 2.0f;
        double radians = Math.toRadians(300.0d);
        int r7 = (int) (f2 / LINE_TO_ACTIVITY_OFFSET_DP_FACTOR);
        int r8 = (int) (f2 / START_AND_END_LINES_START_OFFSET_DP_FACTOR);
        this.mStartAndEndLinesStartOffset = r8;
        int r9 = (int) (f2 / START_AND_END_LINES_END_OFFSET_DP_FACTOR);
        PointF pointF = this.mCenter;
        pointF.x = f + ((getWidth() / 2.0f) - f);
        pointF.y = f3 + ((getHeight() / 2.0f) - f3);
        int r0 = this.mActivityViewStrokeWidth;
        this.mMarkLinesEndOffset = r8 + r0;
        this.mTextOffsetX = (int) (f2 / TEXT_OFFSET_X_DP_FACTOR);
        int r2 = r8 + r0 + r7;
        int r1 = (int) (f2 / TEXT_SIZE_SP_FACTOR);
        this.mTextSize = r1;
        this.mTextPaint.setTextSize(r1);
        this.mStartLineStartX = ((float) Math.sin(0.0d)) * this.mStartAndEndLinesStartOffset;
        this.mStartLineStartY = ((float) (-Math.cos(0.0d))) * this.mStartAndEndLinesStartOffset;
        float f4 = r9;
        this.mStartLineEndX = ((float) Math.sin(0.0d)) * f4;
        this.mStartLineEndY = ((float) (-Math.cos(0.0d))) * f4;
        this.mEndLineStartX = ((float) Math.sin(radians)) * this.mStartAndEndLinesStartOffset;
        this.mEndLineStartY = ((float) (-Math.cos(radians))) * this.mStartAndEndLinesStartOffset;
        this.mEndLineEndX = ((float) Math.sin(radians)) * f4;
        this.mEndLineEndY = ((float) (-Math.cos(radians))) * f4;
        RectF rectF = this.mLineViewRect;
        PointF pointF2 = this.mCenter;
        float f5 = pointF2.x;
        float f6 = r2;
        float f7 = pointF2.y;
        rectF.set(f5 - f6, f7 - f6, f5 + f6, f7 + f6);
        RectF rectF2 = this.mActivityViewRect;
        PointF pointF3 = this.mCenter;
        float f8 = pointF3.x;
        float f9 = (r0 / 2) + r8;
        float f10 = pointF3.y;
        rectF2.set(f8 - f9, f10 - f9, f8 + f9, f10 + f9);
    }

    private void setStepsSpan() {
        this.mSpanAngleAnimation = (this.mSteps / this.mMaxSteps) * MAX_SPAN_ANGLE;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimations(float f) {
        long j = (f * 1000.0f) + 700;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", 0.0f, 1.0f);
        this.mStepsAnimator = ofFloat;
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.animaconnected.secondo.screens.activity.ActivityView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ActivityView.this.mSteps != ActivityView.this.mStepsAnimationTarget) {
                    if (ActivityView.this.mSteps <= ActivityView.this.mMaxSteps || ActivityView.this.mSpanAngleTarget < ActivityView.MAX_SPAN_ANGLE) {
                        ActivityView.this.mChange = Math.abs(r3.mSteps - ActivityView.this.mStepsAnimationTarget) / ActivityView.this.mMaxSteps;
                        if (ActivityView.this.mChange > 1.0f) {
                            ActivityView.this.mChange = 1.0f;
                        }
                        ActivityView activityView = ActivityView.this;
                        activityView.mStepsAnimationTarget = activityView.mSteps;
                        ActivityView activityView2 = ActivityView.this;
                        activityView2.startAnimations(activityView2.mChange);
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.mStepsAnimator.setDuration(j).start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawStartAndEndActivity(canvas);
        drawLine(canvas);
        drawMarks(canvas);
        canvas.drawArc(this.mActivityViewRect, MIN_ANGLE, this.mSpanAngleAnimation, false, this.mStepsPaint);
        drawStartAndEndLines(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int r2, int r3, int r4, int r5) {
        super.onLayout(z, r2, r3, r4, r5);
        initOffsets();
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        int size = View.MeasureSpec.getSize(r2);
        if (this.mScaling) {
            setMeasuredDimension(size, Math.min(size, View.MeasureSpec.getSize(r3)));
        } else {
            int r22 = (size / 10) * 9;
            setMeasuredDimension(r22, r22);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.mShouldStartAnimations) {
            this.mStepsAnimationTarget = this.mSteps;
            startAnimations(this.mChange);
            this.mShouldStartAnimations = false;
        }
        this.mOnSizeChangedCalled = true;
    }

    @Keep
    public void setProgress(float f) {
        float f2 = this.mStepsAnimationTarget / this.mMaxSteps;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f3 = f2 * MAX_SPAN_ANGLE;
        float f4 = this.mSpanAngleTarget;
        this.mSpanAngleAnimation = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f3, f4, f, f4);
        if (f == 1.0f) {
            this.mSpanAngleTarget = f3;
        }
        invalidate();
    }

    public void setSteps(int r1, int r2, boolean z) {
        this.mMaxSteps = r2;
        if (!z) {
            this.mSteps = r1;
            setStepsSpan();
            return;
        }
        float abs = Math.abs(this.mSteps - r1) / this.mMaxSteps;
        this.mChange = abs;
        if (abs > 1.0f) {
            this.mChange = 1.0f;
        }
        this.mSteps = r1;
        if (this.mOnSizeChangedCalled) {
            ObjectAnimator objectAnimator = this.mStepsAnimator;
            if (objectAnimator == null) {
                this.mStepsAnimationTarget = r1;
                startAnimations(this.mChange);
                return;
            } else {
                if (!objectAnimator.isRunning()) {
                    int r12 = this.mSteps;
                    if (r12 <= this.mMaxSteps || this.mSpanAngleTarget < MAX_SPAN_ANGLE) {
                        this.mStepsAnimationTarget = r12;
                        startAnimations(this.mChange);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.mShouldStartAnimations = true;
    }

    public void setStepsStrokeColor(int r2) {
        this.mStepsPaint.setColor(r2);
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.mStepsPaint.setStrokeWidth(f);
        requestLayout();
        invalidate();
    }

    public ActivityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCenter = new PointF();
        this.mActivityViewRect = new RectF();
        this.mLineViewRect = new RectF();
        this.mStepsPaint = new Paint(1);
        this.mLinePaint = new Paint(1);
        this.mStartAndEndLinesPaint = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mMarkPaint1 = new Paint(1);
        this.mMarkPaint2 = new Paint(1);
        this.mMaxSteps = 0;
        this.mSteps = 0;
        this.mStepsAnimationTarget = 0;
        this.mSpanAngleTarget = 0.0f;
        this.mSpanAngleAnimation = 0.0f;
        this.mChange = 0.0f;
        this.mStepsStrokeColor = 1346855055;
        this.mStepsLineColor = 1346855055;
        this.mMarkStrokeColor1 = 869849304;
        this.mMarkStrokeColor2 = 1725487320;
        this.mActivityViewStrokeWidth = 40;
        this.mContext = context;
        init(attributeSet);
    }

    public ActivityView(Context context, AttributeSet attributeSet, int r4) {
        super(context, attributeSet, r4);
        this.mCenter = new PointF();
        this.mActivityViewRect = new RectF();
        this.mLineViewRect = new RectF();
        this.mStepsPaint = new Paint(1);
        this.mLinePaint = new Paint(1);
        this.mStartAndEndLinesPaint = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mMarkPaint1 = new Paint(1);
        this.mMarkPaint2 = new Paint(1);
        this.mMaxSteps = 0;
        this.mSteps = 0;
        this.mStepsAnimationTarget = 0;
        this.mSpanAngleTarget = 0.0f;
        this.mSpanAngleAnimation = 0.0f;
        this.mChange = 0.0f;
        this.mStepsStrokeColor = 1346855055;
        this.mStepsLineColor = 1346855055;
        this.mMarkStrokeColor1 = 869849304;
        this.mMarkStrokeColor2 = 1725487320;
        this.mActivityViewStrokeWidth = 40;
        this.mContext = context;
        init(attributeSet);
    }
}
