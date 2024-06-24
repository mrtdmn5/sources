package com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview;

import android.animation.ObjectAnimator;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.core.view.GestureDetectorCompat;
import com.animaconnected.draganddrop.DragAndDropController;
import com.animaconnected.draganddrop.dataadapter.OnSourceGridItemClickedListener;
import com.animaconnected.draganddrop.provider.BadgeState;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleIconItem;
import com.animaconnected.draganddrop.widget.DragItemLayout;

/* loaded from: classes.dex */
public abstract class DragAndDropSourceGridViewHolder extends DragAndDropSourceGridViewHolderBase implements GestureDetector.OnGestureListener {
    static final float DISABLED_ALPHA = 0.25f;
    static final float ENABLED_ALPHA = 1.0f;
    public static final int FADE_IN_OUT_DURATION = 250;
    DragAndDropDroppableItem mAdapterItem;
    ObjectAnimator mAnimator;
    ObjectAnimator mBadgeAnimator;
    final DragItemLayout mContent;
    private final GestureDetectorCompat mDetector;
    private final DragAndDropController mDragAndDropController;
    private final DragAndDropProvider mDragAndDropProvider;
    private boolean mFirstStart;
    private boolean mIsOkToStartDragging;
    private final OnSourceGridItemClickedListener mOnSourceGridItemClickedListener;

    public DragAndDropSourceGridViewHolder(DragItemLayout dragItemLayout, OnSourceGridItemClickedListener onSourceGridItemClickedListener, DragAndDropProvider dragAndDropProvider, DragAndDropController dragAndDropController) {
        super(dragItemLayout);
        this.mContent = dragItemLayout;
        this.mOnSourceGridItemClickedListener = onSourceGridItemClickedListener;
        this.mDetector = new GestureDetectorCompat(dragItemLayout.getContext(), this);
        this.mDragAndDropController = dragAndDropController;
        this.mDragAndDropProvider = dragAndDropProvider;
        dragItemLayout.getDragAndDroppableView().setOnTouchListener(new View.OnTouchListener() { // from class: com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview.DragAndDropSourceGridViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean lambda$new$0;
                lambda$new$0 = DragAndDropSourceGridViewHolder.this.lambda$new$0(view, motionEvent);
                return lambda$new$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$new$0(View view, MotionEvent motionEvent) {
        if (!this.mDragAndDropController.canStartDragFromSourceGridView()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 3 && this.mIsOkToStartDragging) {
                this.mIsOkToStartDragging = false;
                this.mAdapterItem.setDraggedFromSourceGridView(true);
                this.mOnSourceGridItemClickedListener.onDragStarted(this.mContent.getDragAndDroppableView(), this.mAdapterItem);
                return true;
            }
        } else {
            this.mIsOkToStartDragging = true;
        }
        return this.mDetector.mImpl.mDetector.onTouchEvent(motionEvent);
    }

    @Override // com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview.DragAndDropSourceGridViewHolderBase
    public void bind(DragAndDropItem dragAndDropItem) {
        float f;
        if (dragAndDropItem instanceof DragAndDropDroppableItem) {
            DragAndDropDroppableItem dragAndDropDroppableItem = (DragAndDropDroppableItem) dragAndDropItem;
            this.mAdapterItem = dragAndDropDroppableItem;
            if (!dragAndDropDroppableItem.isDraggedFromSourceGridView() && !this.mAdapterItem.isDropped(this.mDragAndDropController.getAdapterType())) {
                this.mContent.getDragAndDroppableView().setVisibility(0);
                if (this.mContent.getIconView() != null) {
                    this.mContent.getIconView().setVisibility(0);
                }
            } else {
                this.mContent.getDragAndDroppableView().setVisibility(4);
                if (this.mContent.getIconView() != null) {
                    this.mContent.getIconView().setVisibility(4);
                }
                if (this.mDragAndDropProvider.shouldDrawEmptyIcon()) {
                    DragAndDropDroppableItem dragAndDropDroppableItem2 = this.mAdapterItem;
                    if (dragAndDropDroppableItem2 instanceof DragAndDropMarbleIconItem) {
                        int iconResourceId = ((DragAndDropMarbleIconItem) dragAndDropDroppableItem2).getIconResourceId();
                        int emptyIconColor = ((DragAndDropMarbleIconItem) this.mAdapterItem).getEmptyIconColor();
                        if (iconResourceId != -1) {
                            this.mContent.setEmptyViewIcon(iconResourceId, emptyIconColor);
                        }
                    }
                } else {
                    this.mContent.setEmptyViewIcon(this.mDragAndDropProvider.getGroupDrawable(this.mAdapterItem.getGroup()), this.mDragAndDropProvider.getEmptyMarbleColorInt());
                }
            }
            ObjectAnimator objectAnimator = this.mBadgeAnimator;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.mBadgeAnimator.cancel();
            }
            ImageView badgeView = this.mContent.getBadgeView();
            BadgeState badgeState = this.mAdapterItem.getBadgeState();
            float f2 = ENABLED_ALPHA;
            if (badgeView != null) {
                Integer resId = this.mAdapterItem.getBadgeState().getResId();
                if (resId != null && badgeState == BadgeState.Positive) {
                    badgeView.setImageDrawable(this.mContent.getContext().getDrawable(resId.intValue()));
                } else {
                    badgeView.setImageDrawable(null);
                }
                if (!this.mAdapterItem.isDraggedFromSourceGridView() && !this.mAdapterItem.isDropped(this.mDragAndDropController.getAdapterType())) {
                    badgeView.setScaleX(ENABLED_ALPHA);
                    badgeView.setScaleY(ENABLED_ALPHA);
                } else {
                    badgeView.setScaleX(0.0f);
                    badgeView.setScaleY(0.0f);
                }
            }
            this.mContent.setPanelDropZoneSelectedDrawable(this.mDragAndDropProvider.getPanelDropZoneSelectedDrawable());
            this.mContent.setPanelDropZoneNotSelectedDrawable(this.mDragAndDropProvider.getPanelDropZoneNotSelectedDrawable());
            this.mContent.setSelected(this.mAdapterItem.isSelected());
            ObjectAnimator objectAnimator2 = this.mAnimator;
            if (objectAnimator2 != null && objectAnimator2.isRunning()) {
                this.mAnimator.cancel();
            }
            if (this.mAdapterItem.shouldAnimate() && !this.mAdapterItem.isAnimatedBack()) {
                View view = this.itemView;
                if (this.mAdapterItem.isEnabled()) {
                    f = 0.25f;
                } else {
                    f = 1.0f;
                }
                view.setAlpha(f);
                View view2 = this.itemView;
                float[] fArr = new float[1];
                if (!this.mAdapterItem.isEnabled()) {
                    f2 = 0.25f;
                }
                fArr[0] = f2;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "alpha", fArr);
                this.mAnimator = ofFloat;
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                this.mAnimator.setDuration(250L);
                this.mAnimator.start();
            } else {
                View view3 = this.itemView;
                if (!this.mAdapterItem.isEnabled()) {
                    f2 = 0.25f;
                }
                view3.setAlpha(f2);
            }
            this.mContent.setupDragAndDroppableView(this.mAdapterItem, this.mFirstStart);
            return;
        }
        throw new RuntimeException("Unexpected type of data!");
    }

    public DragAndDropDroppableItem getAdapterItem() {
        return this.mAdapterItem;
    }

    public DragItemLayout getContent() {
        return this.mContent;
    }

    public View getDragAndDroppableViewForAnimation() {
        return this.mContent.getDragAndDroppableViewForAnimation();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.mIsOkToStartDragging) {
            this.mIsOkToStartDragging = false;
            this.mAdapterItem.setDraggedFromSourceGridView(true);
            this.mOnSourceGridItemClickedListener.onDragStarted(this.mContent.getDragAndDroppableView(), this.mAdapterItem);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mIsOkToStartDragging) {
            this.mIsOkToStartDragging = false;
            this.mAdapterItem.setDraggedFromSourceGridView(true);
            this.mOnSourceGridItemClickedListener.onDragStarted(this.mContent.getDragAndDroppableView(), this.mAdapterItem);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mOnSourceGridItemClickedListener.onSourceGridItemClicked(this.mContent.getDragAndDroppableView(), this.mAdapterItem);
        return true;
    }

    public void setFirstStart(boolean z) {
        this.mFirstStart = z;
    }

    public void setSelected(boolean z) {
        this.mAdapterItem.setSelected(z);
        this.mContent.setSelected(z);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
