package com.animaconnected.draganddrop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleIconItem;

/* loaded from: classes.dex */
public class MarbleIconSourceGridViewDragItemLayout extends MarbleIconDragItemLayout {
    private TextView mNameTextView;

    public MarbleIconSourceGridViewDragItemLayout(Context context) {
        super(context);
    }

    @Override // com.animaconnected.draganddrop.widget.MarbleIconDragItemLayout, com.animaconnected.draganddrop.widget.DragItemLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mNameTextView = (TextView) findViewById(R.id.name_text_view);
    }

    @Override // com.animaconnected.draganddrop.widget.MarbleIconDragItemLayout, com.animaconnected.draganddrop.widget.DragItemLayout
    public void setupDragAndDroppableView(DragAndDropItem dragAndDropItem) {
        super.setupDragAndDroppableView(dragAndDropItem);
        if (dragAndDropItem instanceof DragAndDropMarbleIconItem) {
            DragAndDropMarbleIconItem dragAndDropMarbleIconItem = (DragAndDropMarbleIconItem) dragAndDropItem;
            this.mNameTextView.setText(dragAndDropMarbleIconItem.getName());
            this.mNameTextView.setTextAppearance(dragAndDropMarbleIconItem.getTextStyle());
            return;
        }
        throw new RuntimeException("Unexpected type of data!");
    }

    public MarbleIconSourceGridViewDragItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarbleIconSourceGridViewDragItemLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
    }
}
