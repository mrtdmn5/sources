package com.animaconnected.secondo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.animaconnected.secondo.app.animation.WatchHandsAnimation;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class WatchLayoutWithOneSubComplication extends WatchLayout {
    private WatchHandsAnimation.WatchHandModel mComplicationWatchHandModel1;
    private WatchHandsAnimation mComplicationWatchHandsAnimation1;
    private ImageView mImageViewWatchHandHoursComplication;
    private ImageView mImageViewWatchHandMinutesComplication;

    public WatchLayoutWithOneSubComplication(Context context) {
        this(context, null, 0);
    }

    @Override // com.animaconnected.secondo.widget.WatchLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mImageViewWatchHandHoursComplication = (ImageView) findViewById(R.id.imageViewWatchHandHoursComplication);
        this.mImageViewWatchHandMinutesComplication = (ImageView) findViewById(R.id.imageViewWatchHandMinutesComplication);
    }

    @Override // com.animaconnected.secondo.widget.WatchLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int r2, int r3, int r4, int r5) {
        super.onLayout(z, r2, r3, r4, r5);
        int r42 = r4 - r2;
        int paddingLeft = r42 - (getPaddingLeft() + getPaddingRight());
        ImageView imageView = this.mImageViewWatchHandMinutesComplication;
        if (imageView != null) {
            layoutImageViewWatchHand(imageView, paddingLeft);
        }
        ImageView imageView2 = this.mImageViewWatchHandHoursComplication;
        if (imageView2 != null) {
            layoutImageViewWatchHand(imageView2, paddingLeft);
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
    public void updateHands(boolean z) {
        WatchHandsAnimation.WatchHandModel watchHandModel = this.mComplicationWatchHandModel1;
        if (watchHandModel != null) {
            if (this.mComplicationWatchHandsAnimation1 == null) {
                this.mComplicationWatchHandsAnimation1 = new WatchHandsAnimation(this.mImageViewWatchHandMinutesComplication, this.mImageViewWatchHandHoursComplication, watchHandModel);
            }
            this.mComplicationWatchHandsAnimation1.update(z);
        }
        super.updateHands(z);
    }

    public WatchLayoutWithOneSubComplication(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WatchLayoutWithOneSubComplication(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
    }
}
