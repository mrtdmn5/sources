package com.animaconnected.secondo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.animaconnected.secondo.app.animation.WatchHandsAnimation;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class WatchLayoutWithTwoSubComplications extends WatchLayout {
    private WatchHandsAnimation.WatchHandModel mComplicationWatchHandModel1;
    private WatchHandsAnimation.WatchHandModel mComplicationWatchHandModel2;
    private WatchHandsAnimation mComplicationWatchHandsAnimation1;
    private WatchHandsAnimation mComplicationWatchHandsAnimation2;
    private ImageView mImageViewWatchHandHoursComplication1;
    private ImageView mImageViewWatchHandHoursComplication2;

    public WatchLayoutWithTwoSubComplications(Context context) {
        this(context, null, 0);
    }

    @Override // com.animaconnected.secondo.widget.WatchLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mImageViewWatchHandHoursComplication1 = (ImageView) findViewById(R.id.imageViewWatchHandHoursComplication1);
        this.mImageViewWatchHandHoursComplication2 = (ImageView) findViewById(R.id.imageViewWatchHandHoursComplication2);
    }

    @Override // com.animaconnected.secondo.widget.WatchLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int r5, int r6, int r7, int r8) {
        super.onLayout(z, r5, r6, r7, r8);
        int measuredWidth = this.mImageViewMeter.getMeasuredWidth();
        int measuredHeight = this.mImageViewMeter.getMeasuredHeight();
        ImageView imageView = this.mImageViewWatchHandHoursComplication1;
        if (imageView != null) {
            int measuredWidth2 = imageView.getMeasuredWidth();
            int measuredHeight2 = this.mImageViewWatchHandHoursComplication1.getMeasuredHeight();
            this.mImageViewWatchHandHoursComplication1.layout(measuredWidth - measuredWidth2, measuredHeight - measuredHeight2, measuredWidth, measuredHeight);
            this.mImageViewWatchHandHoursComplication1.setPivotX(measuredWidth2 / 2.0f);
            this.mImageViewWatchHandHoursComplication1.setPivotY(measuredHeight2 / 2.0f);
        }
        ImageView imageView2 = this.mImageViewWatchHandHoursComplication2;
        if (imageView2 != null) {
            int measuredWidth3 = imageView2.getMeasuredWidth();
            int measuredHeight3 = this.mImageViewWatchHandHoursComplication2.getMeasuredHeight();
            this.mImageViewWatchHandHoursComplication2.layout(0, measuredHeight - measuredHeight3, measuredWidth3, measuredHeight);
            this.mImageViewWatchHandHoursComplication2.setPivotX(measuredWidth3 / 2.0f);
            this.mImageViewWatchHandHoursComplication2.setPivotY(measuredHeight3 / 2.0f);
        }
    }

    @Override // com.animaconnected.secondo.widget.WatchLayout
    public void setSubComplicationWatchHandModel1(WatchHandsAnimation.WatchHandModel watchHandModel) {
        this.mComplicationWatchHandModel1 = watchHandModel;
        WatchHandsAnimation watchHandsAnimation = this.mComplicationWatchHandsAnimation1;
        if (watchHandsAnimation != null) {
            watchHandsAnimation.setWatchHandModel(watchHandModel);
        }
    }

    @Override // com.animaconnected.secondo.widget.WatchLayout
    public void setSubComplicationWatchHandModel2(WatchHandsAnimation.WatchHandModel watchHandModel) {
        this.mComplicationWatchHandModel2 = watchHandModel;
        WatchHandsAnimation watchHandsAnimation = this.mComplicationWatchHandsAnimation2;
        if (watchHandsAnimation != null) {
            watchHandsAnimation.setWatchHandModel(watchHandModel);
        }
    }

    @Override // com.animaconnected.secondo.widget.WatchLayout
    public void updateHands(boolean z) {
        WatchHandsAnimation.WatchHandModel watchHandModel = this.mComplicationWatchHandModel1;
        if (watchHandModel != null) {
            if (this.mComplicationWatchHandsAnimation1 == null) {
                this.mComplicationWatchHandsAnimation1 = new WatchHandsAnimation(null, this.mImageViewWatchHandHoursComplication1, watchHandModel);
            }
            this.mComplicationWatchHandsAnimation1.update(z);
        }
        WatchHandsAnimation.WatchHandModel watchHandModel2 = this.mComplicationWatchHandModel2;
        if (watchHandModel2 != null) {
            if (this.mComplicationWatchHandsAnimation2 == null) {
                this.mComplicationWatchHandsAnimation2 = new WatchHandsAnimation(null, this.mImageViewWatchHandHoursComplication2, watchHandModel2);
            }
            this.mComplicationWatchHandsAnimation2.update(z);
        }
        super.updateHands(z);
    }

    public WatchLayoutWithTwoSubComplications(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WatchLayoutWithTwoSubComplications(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
    }
}
