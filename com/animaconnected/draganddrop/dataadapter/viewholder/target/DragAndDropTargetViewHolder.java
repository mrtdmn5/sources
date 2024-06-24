package com.animaconnected.draganddrop.dataadapter.viewholder.target;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.GestureDetectorCompat;
import com.animaconnected.draganddrop.DragAndDropController;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.provider.BadgeVisualState;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.utils.LayoutPool;
import com.animaconnected.draganddrop.widget.DragItemLayout;

/* loaded from: classes.dex */
public class DragAndDropTargetViewHolder implements GestureDetector.OnGestureListener {
    private static final float DISABLED_ALPHA = 0.25f;
    private static final float ENABLED_ALPHA = 1.0f;
    DragAndDropDroppableItem mAdapterItem;
    private ObjectAnimator mBadgeAnimator;
    final DragItemLayout mContent;
    private final GestureDetectorCompat mDetector;
    private final DragAndDropController mDragAndDropController;
    private final DragAndDropProvider mDragAndDropProvider;
    private boolean mEnabled = true;
    private final int mGridPosition;
    private final int mGroup;
    private final OnTargetItemClickedListener mOnTargetItemClickedListener;
    private boolean mShouldReceiveTouchEvents;

    /* loaded from: classes.dex */
    public interface OnTargetItemClickedListener {
        void onTargetItemClicked(DragAndDropTargetViewHolder dragAndDropTargetViewHolder);

        void onTargetItemDragged(DragAndDropTargetViewHolder dragAndDropTargetViewHolder);
    }

    public DragAndDropTargetViewHolder(int r2, int r3, DragItemLayout dragItemLayout, DragAndDropDroppableItem dragAndDropDroppableItem, OnTargetItemClickedListener onTargetItemClickedListener, DragAndDropProvider dragAndDropProvider, DragAndDropController dragAndDropController, boolean z) {
        this.mShouldReceiveTouchEvents = true;
        this.mGridPosition = r2;
        this.mGroup = r3;
        this.mContent = dragItemLayout;
        this.mAdapterItem = dragAndDropDroppableItem;
        this.mOnTargetItemClickedListener = onTargetItemClickedListener;
        this.mDetector = new GestureDetectorCompat(dragItemLayout.getContext(), this);
        this.mShouldReceiveTouchEvents = z;
        dragItemLayout.getDragAndDroppableView().setOnTouchListener(new View.OnTouchListener() { // from class: com.animaconnected.draganddrop.dataadapter.viewholder.target.DragAndDropTargetViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean lambda$new$0;
                lambda$new$0 = DragAndDropTargetViewHolder.this.lambda$new$0(view, motionEvent);
                return lambda$new$0;
            }
        });
        this.mDragAndDropProvider = dragAndDropProvider;
        this.mDragAndDropController = dragAndDropController;
        initializeViewHolder();
    }

    private void initializeViewHolder() {
        DragAndDropDroppableItem dragAndDropDroppableItem = this.mAdapterItem;
        if (dragAndDropDroppableItem != null) {
            if (dragAndDropDroppableItem.getBadgeVisualState() == BadgeVisualState.AnimateIn) {
                setBadgeVisibilityAnimated(true);
            } else if (this.mAdapterItem.getBadgeVisualState() == BadgeVisualState.AnimateOut) {
                setBadgeVisibilityAnimated(false);
            } else if (this.mAdapterItem.getBadgeVisualState() == BadgeVisualState.Visible) {
                this.mContent.getBadgeView().setScaleX(ENABLED_ALPHA);
                this.mContent.getBadgeView().setScaleY(ENABLED_ALPHA);
            } else if (this.mAdapterItem.getBadgeVisualState() == BadgeVisualState.Invisible) {
                this.mContent.getBadgeView().setScaleX(0.0f);
                this.mContent.getBadgeView().setScaleY(0.0f);
            }
            View dragAndDroppableView = this.mContent.getDragAndDroppableView();
            dragAndDroppableView.setVisibility(0);
            dragAndDroppableView.setAlpha(ENABLED_ALPHA);
            dragAndDroppableView.setScaleX(ENABLED_ALPHA);
            dragAndDroppableView.setScaleY(ENABLED_ALPHA);
            dragAndDroppableView.setTranslationX(0.0f);
            dragAndDroppableView.setTranslationY(0.0f);
        }
        this.mContent.setSelected(false, this.mDragAndDropProvider.getBackgroundSelectedDrawable(this.mGroup), this.mDragAndDropProvider.getBackgroundNotSelectedDrawable(this.mGroup));
        this.mContent.setAlpha(ENABLED_ALPHA);
        this.mContent.setDragAndDroppableViewHovered(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$new$0(View view, MotionEvent motionEvent) {
        if (this.mShouldReceiveTouchEvents) {
            return this.mDetector.mImpl.mDetector.onTouchEvent(motionEvent);
        }
        return true;
    }

    public static DragAndDropTargetViewHolder newInstance(int r11, int r12, DragAndDropDroppableItem dragAndDropDroppableItem, OnTargetItemClickedListener onTargetItemClickedListener, Context context, DragAndDropProvider dragAndDropProvider, DragAndDropController dragAndDropController) {
        DragItemLayout dragItemLayout = (DragItemLayout) LayoutPool.getInstance().getViewOrCreateIfNeeded(context, R.layout.dragitemlayout_target);
        if (dragAndDropDroppableItem != null) {
            Integer resId = dragAndDropDroppableItem.getBadgeState().getResId();
            ImageView badgeView = dragItemLayout.getBadgeView();
            if (resId != null && badgeView != null) {
                badgeView.setImageDrawable(context.getDrawable(resId.intValue()));
            }
        }
        return new DragAndDropTargetViewHolder(r11, r12, dragItemLayout, dragAndDropDroppableItem, onTargetItemClickedListener, dragAndDropProvider, dragAndDropController, true);
    }

    private boolean startDrag(View view) {
        DragAndDropDroppableItem dragAndDropDroppableItem = this.mAdapterItem;
        if (dragAndDropDroppableItem == null || !dragAndDropDroppableItem.isDropped(this.mDragAndDropController.getAdapterType()) || this.mDragAndDropController.isAnimatorRunning() || !this.mDragAndDropProvider.belongsToAdapterType(getGroup(), this.mDragAndDropController.getAdapterType())) {
            return false;
        }
        this.mAdapterItem.setDropped(false, this.mDragAndDropController.getAdapterType());
        setBadgeVisibilityAnimated(false);
        view.setTag(this.mAdapterItem);
        this.mOnTargetItemClickedListener.onTargetItemDragged(this);
        return true;
    }

    public void enableOrDisableViewHolder(boolean z) {
        float f;
        this.mEnabled = z;
        DragItemLayout dragItemLayout = this.mContent;
        if (z) {
            f = ENABLED_ALPHA;
        } else {
            f = DISABLED_ALPHA;
        }
        dragItemLayout.setAlpha(f);
        this.mContent.getDragAndDroppableView().invalidate();
    }

    public DragAndDropDroppableItem getAdapterItem() {
        return this.mAdapterItem;
    }

    public DragItemLayout getContentView() {
        return this.mContent;
    }

    public View getDragAndDroppableView() {
        return this.mContent.getDragAndDroppableView();
    }

    public View getDragAndDroppableViewForAnimation() {
        return this.mContent.getDragAndDroppableViewForAnimation();
    }

    public View getEmptyView() {
        return this.mContent.getEmptyView();
    }

    public int getGridPosition() {
        return this.mGridPosition;
    }

    public int getGroup() {
        return this.mGroup;
    }

    public void hideOrShowViewHolder(boolean z) {
        float f;
        DragItemLayout dragItemLayout = this.mContent;
        if (z) {
            f = 0.0f;
        } else {
            f = ENABLED_ALPHA;
        }
        dragItemLayout.setAlpha(f);
        this.mContent.getDragAndDroppableView().invalidate();
    }

    public boolean isEnabled() {
        return this.mEnabled;
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
        startDrag(this.mContent.getDragAndDroppableView());
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        startDrag(this.mContent.getDragAndDroppableView());
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (!this.mDragAndDropController.isAnimatorRunning() && this.mDragAndDropProvider.belongsToAdapterType(getGroup(), this.mDragAndDropController.getAdapterType())) {
            this.mOnTargetItemClickedListener.onTargetItemClicked(this);
            return true;
        }
        return false;
    }

    public void setAdapterItem(DragAndDropDroppableItem dragAndDropDroppableItem) {
        this.mAdapterItem = dragAndDropDroppableItem;
    }

    public void setBadgeVisibilityAnimated(boolean z) {
        float f;
        BadgeVisualState badgeVisualState = this.mAdapterItem.getBadgeVisualState();
        BadgeVisualState badgeVisualState2 = BadgeVisualState.Invisible;
        if (badgeVisualState != badgeVisualState2 || z) {
            BadgeVisualState badgeVisualState3 = this.mAdapterItem.getBadgeVisualState();
            BadgeVisualState badgeVisualState4 = BadgeVisualState.Visible;
            if (badgeVisualState3 == badgeVisualState4 && z) {
                return;
            }
            ImageView badgeView = this.mContent.getBadgeView();
            DragAndDropDroppableItem dragAndDropDroppableItem = this.mAdapterItem;
            if (z) {
                badgeVisualState2 = badgeVisualState4;
            }
            dragAndDropDroppableItem.setBadgeVisualState(badgeVisualState2);
            if (badgeView != null) {
                ObjectAnimator objectAnimator = this.mBadgeAnimator;
                if (objectAnimator != null && objectAnimator.isRunning()) {
                    this.mBadgeAnimator.cancel();
                }
                float f2 = ENABLED_ALPHA;
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                if (z) {
                    f2 = 0.0f;
                }
                badgeView.setScaleX(f2);
                badgeView.setScaleY(f2);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(badgeView, PropertyValuesHolder.ofFloat("scaleX", f), PropertyValuesHolder.ofFloat("scaleY", f));
                this.mBadgeAnimator = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(150L);
                this.mBadgeAnimator.start();
            }
        }
    }

    public void setDragAndDroppableViewHovered(boolean z) {
        this.mContent.setDragAndDroppableViewHovered(z);
    }

    public void setSelected(boolean z) {
        this.mContent.setSelected(z, this.mDragAndDropProvider.getBackgroundSelectedDrawable(this.mGroup), this.mDragAndDropProvider.getBackgroundNotSelectedDrawable(this.mGroup));
    }

    public void updateViewHolder() {
        DragAndDropDroppableItem dragAndDropDroppableItem = this.mAdapterItem;
        if (dragAndDropDroppableItem != null && dragAndDropDroppableItem.isDropped(this.mDragAndDropController.getAdapterType())) {
            this.mContent.getDragAndDroppableView().setVisibility(0);
            this.mContent.setupDragAndDroppableView(this.mAdapterItem);
        } else {
            this.mContent.getDragAndDroppableView().setVisibility(4);
            this.mContent.setSelected(false, this.mDragAndDropProvider.getBackgroundSelectedDrawable(this.mGroup), this.mDragAndDropProvider.getBackgroundNotSelectedDrawable(this.mGroup));
        }
        this.mContent.getDragAndDroppableView().invalidate();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
