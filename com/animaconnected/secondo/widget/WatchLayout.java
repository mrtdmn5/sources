package com.animaconnected.secondo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.app.animation.WatchHandsAnimation;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class WatchLayout extends FrameLayout {
    private final Context mContext;
    private View mImageViewGlass;
    protected ImageView mImageViewMeter;
    protected ImageView mImageViewWatchHandHours;
    protected ImageView mImageViewWatchHandMinutes;
    private boolean mScalingEnabled;
    private WatchHandsAnimation.WatchHandModel mWatchHandModel;
    private WatchHandsAnimation mWatchHandsAnimation;

    public WatchLayout(Context context) {
        super(context);
        this.mScalingEnabled = true;
        this.mContext = context;
        init(null);
    }

    public static WatchHandsAnimation.WatchHandModel createDefaultWatchHandModel() {
        final GregorianCalendar gregorianCalendar = new GregorianCalendar();
        return new WatchHandsAnimation.WatchHandModel() { // from class: com.animaconnected.secondo.widget.WatchLayout.1
            @Override // com.animaconnected.secondo.app.animation.WatchHandsAnimation.WatchHandModel
            public float getHoursInDegrees() {
                gregorianCalendar.setTimeInMillis(System.currentTimeMillis());
                gregorianCalendar.setTimeZone(TimeZone.getDefault());
                return (((gregorianCalendar.get(12) / 60.0f) + (gregorianCalendar.get(11) % 12)) / 12.0f) * 360.0f;
            }

            @Override // com.animaconnected.secondo.app.animation.WatchHandsAnimation.WatchHandModel
            public float getMinutesInDegrees() {
                gregorianCalendar.setTimeInMillis(System.currentTimeMillis());
                gregorianCalendar.setTimeZone(TimeZone.getDefault());
                return (gregorianCalendar.get(12) / 60.0f) * 360.0f;
            }
        };
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.getTheme().obtainStyledAttributes(attributeSet, R.styleable.WatchLayout, 0, 0);
            try {
                this.mScalingEnabled = obtainStyledAttributes.getBoolean(0, this.mScalingEnabled);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void layoutImageViewWatchHand(ImageView imageView, int r7) {
        int measuredWidth = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        int paddingLeft = ((r7 - measuredWidth) / 2) + getPaddingLeft();
        int paddingTop = getPaddingTop();
        imageView.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
        float f = measuredWidth / 2.0f;
        imageView.setPivotX(f);
        imageView.setPivotY(measuredHeight - f);
    }

    public void measureImageViewWatchHand(ImageView imageView, int r3, float f) {
        imageView.measure(r3, r3);
        imageView.measure(View.MeasureSpec.makeMeasureSpec((int) (imageView.getMeasuredWidth() / f), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (imageView.getMeasuredHeight() / f), 1073741824));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mImageViewMeter = (ImageView) findViewById(com.kronaby.watch.app.R.id.imageViewMeter);
        this.mImageViewWatchHandMinutes = (ImageView) findViewById(com.kronaby.watch.app.R.id.imageViewWatchHandMinutes);
        this.mImageViewWatchHandHours = (ImageView) findViewById(com.kronaby.watch.app.R.id.imageViewWatchHandHours);
        this.mImageViewGlass = findViewById(com.kronaby.watch.app.R.id.imageViewWatchGlass);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int r3, int r4, int r5, int r6) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int r52 = (r5 - r3) - paddingLeft;
        int measuredHeight = getMeasuredHeight() - (getPaddingBottom() + getPaddingTop());
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int r62 = paddingLeft2 + r52;
        int r2 = measuredHeight + paddingTop;
        this.mImageViewMeter.layout(paddingLeft2, paddingTop, r62, r2);
        View view = this.mImageViewGlass;
        if (view != null) {
            view.layout(paddingLeft2, paddingTop, r62, r2);
        }
        ImageView imageView = this.mImageViewWatchHandMinutes;
        if (imageView != null) {
            layoutImageViewWatchHand(imageView, r52);
        }
        ImageView imageView2 = this.mImageViewWatchHandHours;
        if (imageView2 != null) {
            layoutImageViewWatchHand(imageView2, r52);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r9, int r10) {
        if (!this.mScalingEnabled) {
            super.onMeasure(r9, r10);
            return;
        }
        int size = View.MeasureSpec.getSize(r9);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int r102 = size - paddingLeft;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mImageViewMeter.measure(makeMeasureSpec, makeMeasureSpec);
        float measuredWidth = this.mImageViewMeter.getMeasuredWidth();
        float measuredHeight = measuredWidth / this.mImageViewMeter.getMeasuredHeight();
        float f = measuredWidth / size;
        int r92 = (int) (r102 / measuredHeight);
        this.mImageViewMeter.measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(r92, 1073741824));
        View view = this.mImageViewGlass;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(r92, 1073741824));
        }
        ImageView imageView = this.mImageViewWatchHandMinutes;
        if (imageView != null) {
            measureImageViewWatchHand(imageView, makeMeasureSpec, f);
        }
        ImageView imageView2 = this.mImageViewWatchHandHours;
        if (imageView2 != null) {
            measureImageViewWatchHand(imageView2, makeMeasureSpec, f);
        }
        setMeasuredDimension(r102 + paddingLeft, r92 + paddingBottom);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.mWatchHandsAnimation == null) {
            updateHands(true);
        }
    }

    public void setScalingEnabled(boolean z) {
        this.mScalingEnabled = z;
    }

    public void setWatchHandModel(WatchHandsAnimation.WatchHandModel watchHandModel) {
        this.mWatchHandModel = watchHandModel;
        WatchHandsAnimation watchHandsAnimation = this.mWatchHandsAnimation;
        if (watchHandsAnimation != null) {
            watchHandsAnimation.setWatchHandModel(watchHandModel);
        }
    }

    public void updateHands(boolean z) {
        WatchHandsAnimation.WatchHandModel watchHandModel = this.mWatchHandModel;
        if (watchHandModel != null) {
            if (this.mWatchHandsAnimation == null) {
                this.mWatchHandsAnimation = new WatchHandsAnimation(this.mImageViewWatchHandMinutes, this.mImageViewWatchHandHours, watchHandModel);
            }
            this.mWatchHandsAnimation.update(z);
        }
    }

    public WatchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScalingEnabled = true;
        this.mContext = context;
        init(attributeSet);
    }

    public WatchLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mScalingEnabled = true;
        this.mContext = context;
        init(attributeSet);
    }

    public void setSubComplicationWatchHandModel1(WatchHandsAnimation.WatchHandModel watchHandModel) {
    }

    public void setSubComplicationWatchHandModel2(WatchHandsAnimation.WatchHandModel watchHandModel) {
    }
}
