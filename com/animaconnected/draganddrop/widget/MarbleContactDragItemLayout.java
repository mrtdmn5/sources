package com.animaconnected.draganddrop.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleContactItem;

/* loaded from: classes.dex */
public class MarbleContactDragItemLayout extends DragItemLayout {
    private RelativeLayout mDragAndDropView;
    private ImageView mIconView;
    TextView mInitialsTextView;

    public MarbleContactDragItemLayout(Context context) {
        super(context);
    }

    @Override // com.animaconnected.draganddrop.widget.DragItemLayout
    public View getDragAndDroppableView() {
        return this.mDragAndDropView;
    }

    @Override // com.animaconnected.draganddrop.widget.DragItemLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mDragAndDropView = (RelativeLayout) findViewById(R.id.draganddrop_view);
        this.mInitialsTextView = (TextView) findViewById(R.id.initials_text_view);
        this.mIconView = (ImageView) findViewById(R.id.contact_icon_view);
    }

    @Override // com.animaconnected.draganddrop.widget.DragItemLayout
    public void setupDragAndDroppableView(DragAndDropItem dragAndDropItem) {
        setupDragAndDroppableView(dragAndDropItem, false);
    }

    public MarbleContactDragItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.animaconnected.draganddrop.widget.DragItemLayout
    public void setupDragAndDroppableView(DragAndDropItem dragAndDropItem, boolean z) {
        super.setupDragAndDroppableView(dragAndDropItem);
        if (dragAndDropItem instanceof DragAndDropMarbleContactItem) {
            DragAndDropMarbleContactItem dragAndDropMarbleContactItem = (DragAndDropMarbleContactItem) dragAndDropItem;
            this.mInitialsTextView.setText(dragAndDropMarbleContactItem.getInitials());
            this.mInitialsTextView.setTextAppearance(dragAndDropMarbleContactItem.getTextStyle());
            this.mIconView.setScaleType(ImageView.ScaleType.CENTER);
            this.mIconView.setScaleX(1.0f);
            this.mIconView.setScaleY(1.0f);
            int iconResourceId = dragAndDropMarbleContactItem.getIconResourceId();
            Context context = getContext();
            Object obj = ContextCompat.sLock;
            Drawable drawable = ContextCompat.Api21Impl.getDrawable(context, iconResourceId);
            if (drawable != null) {
                Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
                newDrawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(dragAndDropMarbleContactItem.getIconColor(), BlendModeCompat.SRC_IN));
                this.mIconView.setImageDrawable(newDrawable);
            }
            if (dragAndDropMarbleContactItem.isDropped()) {
                if (z) {
                    fadeInEmptyMarble();
                }
            } else if (z) {
                fadeInView(getContainerView());
            }
            this.mMarbleView.setDroppedDrawableResourceId(dragAndDropMarbleContactItem.getBackgroundDroppedResourceId());
            this.mMarbleView.setDraggedDrawableResourceId(dragAndDropMarbleContactItem.getBackgroundDraggedResourceId());
            return;
        }
        throw new RuntimeException("Unexpected type of data!");
    }

    public MarbleContactDragItemLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
    }
}
