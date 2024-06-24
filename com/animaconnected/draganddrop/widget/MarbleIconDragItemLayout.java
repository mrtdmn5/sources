package com.animaconnected.draganddrop.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleIconItem;

/* loaded from: classes.dex */
public class MarbleIconDragItemLayout extends DragItemLayout {
    private static final float DEFAULT_ICON_DRAWABLE_SCALE = 0.6f;
    private FrameLayout mDragAndDropView;
    private ImageView mIconView;

    public MarbleIconDragItemLayout(Context context) {
        super(context);
    }

    @Override // com.animaconnected.draganddrop.widget.DragItemLayout
    public View getDragAndDroppableView() {
        return this.mDragAndDropView;
    }

    @Override // com.animaconnected.draganddrop.widget.DragItemLayout
    public View getIconView() {
        return this.mIconView;
    }

    @Override // com.animaconnected.draganddrop.widget.DragItemLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mIconView = (ImageView) findViewById(R.id.marble_icon_view);
        this.mDragAndDropView = (FrameLayout) findViewById(R.id.draganddrop_view);
    }

    @Override // com.animaconnected.draganddrop.widget.DragItemLayout
    public void setupDragAndDroppableView(DragAndDropItem dragAndDropItem, boolean z) {
        setupDragAndDroppableView(dragAndDropItem);
    }

    public MarbleIconDragItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.animaconnected.draganddrop.widget.DragItemLayout
    public void setupDragAndDroppableView(DragAndDropItem dragAndDropItem) {
        super.setupDragAndDroppableView(dragAndDropItem);
        if (dragAndDropItem instanceof DragAndDropMarbleIconItem) {
            DragAndDropMarbleIconItem dragAndDropMarbleIconItem = (DragAndDropMarbleIconItem) dragAndDropItem;
            Drawable iconAsDrawable = dragAndDropMarbleIconItem.getIconAsDrawable();
            if (iconAsDrawable != null) {
                if (dragAndDropMarbleIconItem.getIconColor() != null) {
                    iconAsDrawable = iconAsDrawable.mutate().getConstantState().newDrawable();
                    iconAsDrawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(dragAndDropMarbleIconItem.getIconColor().intValue(), BlendModeCompat.SRC_IN));
                }
                this.mIconView.setImageDrawable(iconAsDrawable);
                this.mIconView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.mIconView.setScaleX(DEFAULT_ICON_DRAWABLE_SCALE);
                this.mIconView.setScaleY(DEFAULT_ICON_DRAWABLE_SCALE);
            } else {
                this.mIconView.setScaleType(ImageView.ScaleType.CENTER);
                this.mIconView.setScaleX(1.0f);
                this.mIconView.setScaleY(1.0f);
                int iconResourceId = dragAndDropMarbleIconItem.getIconResourceId();
                if (iconResourceId != -1) {
                    Context context = getContext();
                    Object obj = ContextCompat.sLock;
                    Drawable drawable = ContextCompat.Api21Impl.getDrawable(context, iconResourceId);
                    if (dragAndDropMarbleIconItem.getIconColor() != null && drawable != null) {
                        drawable = drawable.mutate().getConstantState().newDrawable();
                        drawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(dragAndDropMarbleIconItem.getIconColor().intValue(), BlendModeCompat.SRC_IN));
                    }
                    this.mIconView.setImageDrawable(drawable);
                } else {
                    this.mIconView.setImageDrawable(null);
                }
            }
            this.mMarbleView.setDroppedDrawableResourceId(dragAndDropMarbleIconItem.getBackgroundDroppedResourceId());
            this.mMarbleView.setDraggedDrawableResourceId(dragAndDropMarbleIconItem.getBackgroundDraggedResourceId());
            return;
        }
        throw new RuntimeException("Unexpected type of data!");
    }

    public MarbleIconDragItemLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
    }
}
