package com.animaconnected.draganddrop.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;

/* loaded from: classes.dex */
public class DragItemLayout extends RelativeLayout {
    private ImageView mBadge;
    private ImageView mEmptyIconView;
    private ImageView mEmptyView;
    protected MarbleView mMarbleView;
    private Drawable mPanelDropZoneNotSelectedDrawable;
    private Drawable mPanelDropZoneSelectedDrawable;
    private int mTopMarginInPx;

    public DragItemLayout(Context context) {
        super(context);
    }

    public void fadeInEmptyMarble() {
        fadeInView(this.mEmptyView);
        fadeInView(this.mEmptyIconView);
    }

    public void fadeInView(View view) {
        if (view == null) {
            return;
        }
        view.setAlpha(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(400L);
        ofFloat.start();
    }

    public ImageView getBadgeView() {
        return this.mBadge;
    }

    public View getDragAndDroppableView() {
        return this.mMarbleView;
    }

    public View getDragAndDroppableViewForAnimation() {
        return this.mMarbleView;
    }

    public ImageView getEmptyView() {
        return this.mEmptyView;
    }

    public View getIconView() {
        return null;
    }

    public int getTopMargin() {
        return this.mTopMarginInPx;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mEmptyView = (ImageView) findViewById(R.id.marble_empty_view);
        MarbleView marbleView = (MarbleView) findViewById(R.id.marble_view);
        this.mMarbleView = marbleView;
        marbleView.setFocusable(true);
        this.mEmptyIconView = (ImageView) findViewById(R.id.marble_empty_icon_view);
        this.mBadge = (ImageView) findViewById(R.id.marble_badge);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.topMargin = this.mTopMarginInPx;
        setLayoutParams(marginLayoutParams);
    }

    public void setDragAndDroppableViewHovered(boolean z) {
        this.mMarbleView.setDragAndDroppableViewHovered(z);
    }

    public void setEmptyViewIcon(Drawable drawable, int r3) {
        this.mEmptyIconView.setImageDrawable(drawable);
        this.mEmptyIconView.setColorFilter(r3, PorterDuff.Mode.SRC_IN);
    }

    public void setPanelDropZoneNotSelectedDrawable(Drawable drawable) {
        this.mPanelDropZoneNotSelectedDrawable = drawable;
    }

    public void setPanelDropZoneSelectedDrawable(Drawable drawable) {
        this.mPanelDropZoneSelectedDrawable = drawable;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        if (z) {
            getEmptyView().setBackground(this.mPanelDropZoneSelectedDrawable);
        } else {
            getEmptyView().setBackground(this.mPanelDropZoneNotSelectedDrawable);
        }
    }

    public void setTopMargin(int r1) {
        this.mTopMarginInPx = r1;
    }

    public void setupDragAndDroppableView(DragAndDropItem dragAndDropItem) {
    }

    public DragItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setupDragAndDroppableView(DragAndDropItem dragAndDropItem, boolean z) {
    }

    public DragItemLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
    }

    public void setEmptyViewIcon(int r2, int r3) {
        this.mEmptyIconView.setImageResource(r2);
        this.mEmptyIconView.setColorFilter(r3, PorterDuff.Mode.SRC_IN);
        this.mEmptyIconView.setScaleX(0.7f);
        this.mEmptyIconView.setScaleY(0.7f);
    }

    public void setSelected(boolean z, Drawable drawable, Drawable drawable2) {
        if (z) {
            getEmptyView().setBackground(drawable);
        } else {
            getEmptyView().setBackground(drawable2);
        }
    }

    public View getContainerView() {
        return this;
    }
}
