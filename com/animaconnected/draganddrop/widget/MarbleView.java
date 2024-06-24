package com.animaconnected.draganddrop.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.animaconnected.draganddrop.R;

/* loaded from: classes.dex */
public class MarbleView extends View {
    private final Context mContext;
    private Drawable mDraggedDrawable;
    private Drawable mDroppedDrawable;
    private Drawable mDroppedDrawableHovered;

    public MarbleView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        setIsDragged(false);
    }

    public void setDragAndDroppableViewHovered(boolean z) {
        if (z) {
            setBackground(this.mDroppedDrawableHovered);
        } else {
            setBackground(this.mDroppedDrawable);
        }
    }

    public void setDraggedDrawableResourceId(int r3) {
        Context context = this.mContext;
        Object obj = ContextCompat.sLock;
        this.mDraggedDrawable = ContextCompat.Api21Impl.getDrawable(context, r3);
        Drawable drawable = ContextCompat.Api21Impl.getDrawable(this.mContext, r3);
        this.mDroppedDrawableHovered = drawable;
        if (drawable.getConstantState() != null) {
            this.mDroppedDrawableHovered = this.mDroppedDrawableHovered.getConstantState().newDrawable().mutate();
            this.mDroppedDrawableHovered.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.Api23Impl.getColor(getContext(), R.color.drop_target_layout_color_hovered), BlendModeCompat.SRC_IN));
        }
        setIsDragged(false);
    }

    public void setDroppedDrawableResourceId(int r3) {
        Context context = this.mContext;
        Object obj = ContextCompat.sLock;
        this.mDroppedDrawable = ContextCompat.Api21Impl.getDrawable(context, r3);
        setIsDragged(false);
    }

    public void setIsDragged(boolean z) {
        if (z) {
            setBackground(this.mDraggedDrawable);
        } else {
            setBackground(this.mDroppedDrawable);
        }
    }

    public MarbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public MarbleView(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mContext = context;
        init();
    }
}
