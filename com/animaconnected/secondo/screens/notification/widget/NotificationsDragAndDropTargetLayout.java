package com.animaconnected.secondo.screens.notification.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.animaconnected.draganddrop.DragAndDropTargetLayout;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.kronaby.watch.app.R;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class NotificationsDragAndDropTargetLayout extends DragAndDropTargetLayout {
    private boolean mFinishedInflating;
    protected View mLeftVerticalDivider;
    protected View mRightVerticalDivider;
    private final Rect mTmpRect;

    public NotificationsDragAndDropTargetLayout(Context context) {
        this(context, null, 0);
    }

    private boolean isOnHairLine(View view, int r3, int r4) {
        view.getGlobalVisibleRect(this.mTmpRect);
        return this.mTmpRect.contains(r3, r4);
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public RelativeLayout getDragAndDropTargetRemoveLayout() {
        if (this.mFinishedInflating) {
            if (this.mDragAndDropTargetRemoveLayout == null) {
                this.mDragAndDropTargetRemoveLayout = (RelativeLayout) findViewById(R.id.draganddrop_source_grid_view_place_holder);
            }
            return this.mDragAndDropTargetRemoveLayout;
        }
        throw new RuntimeException("Not finished inflating!");
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public View getDropTargetLayer() {
        return findViewById(R.id.drop_target_layer);
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public FrameLayout getDropTargetsContainerLayout() {
        return null;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public FrameLayout getDropTargetsExtraViewContainerLayout() {
        return null;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public View getDropTargetsExtraViewLayout() {
        return null;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public View getExtraView() {
        return null;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public View getOnChildContainerLayoutView(int r5, int r6) {
        Iterator<View> it = this.mContainerLayoutViews.iterator();
        View view = null;
        while (it.hasNext()) {
            View next = it.next();
            next.getGlobalVisibleRect(this.mTmpRect);
            if (this.mTmpRect.contains(r5, r6)) {
                view = next;
            }
        }
        if (isOnHairLine(this.mLeftVerticalDivider, r5, r6) || isOnHairLine(this.mRightVerticalDivider, r5, r6)) {
            return this.mContainerLayoutViews.get(1);
        }
        return view;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        int r7;
        super.onFinishInflate();
        FillLayout fillLayout = (FillLayout) findViewById(R.id.drop_container_1);
        FillLayout fillLayout2 = (FillLayout) findViewById(R.id.drop_container_2);
        FillLayout fillLayout3 = (FillLayout) findViewById(R.id.drop_container_3);
        FillLayout fillLayout4 = (FillLayout) findViewById(R.id.drop_container_4);
        FillLayout fillLayout5 = (FillLayout) findViewById(R.id.drop_container_5);
        FillLayout fillLayout6 = (FillLayout) findViewById(R.id.drop_container_6);
        this.mLeftVerticalDivider = findViewById(R.id.container_left_vertical_divider);
        this.mRightVerticalDivider = findViewById(R.id.container_right_vertical_divider);
        View findViewById = findViewById(R.id.notifications_bottom_line);
        if (ThemeProviderBase.getBoolean(getContext(), R.attr.notificationsBottomLine)) {
            r7 = 0;
        } else {
            r7 = 8;
        }
        findViewById.setVisibility(r7);
        this.mContainerLayoutViews.add(fillLayout);
        if (fillLayout4 != null) {
            this.mContainerLayoutViews.add(fillLayout4);
        }
        this.mContainerLayoutViews.add(fillLayout2);
        if (fillLayout5 != null) {
            this.mContainerLayoutViews.add(fillLayout5);
        }
        this.mContainerLayoutViews.add(fillLayout3);
        if (fillLayout6 != null) {
            this.mContainerLayoutViews.add(fillLayout6);
        }
        this.mFinishedInflating = true;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public void resetContainerLayoutViews() {
        Iterator<View> it = this.mContainerLayoutViews.iterator();
        while (it.hasNext()) {
            View next = it.next();
            Context dragAndDropContext = this.mDragAndDropController.getDragAndDropContext();
            Object obj = ContextCompat.sLock;
            next.setBackgroundColor(ContextCompat.Api23Impl.getColor(dragAndDropContext, R.color.transparent));
        }
    }

    public NotificationsDragAndDropTargetLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NotificationsDragAndDropTargetLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mTmpRect = new Rect();
    }
}
