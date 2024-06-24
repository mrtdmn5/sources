package com.animaconnected.draganddrop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleContactItem;

/* loaded from: classes.dex */
public class MarbleContactSourceGridViewDragItemLayout extends MarbleContactDragItemLayout {
    private TextView mFirstNameTextView;
    private TextView mLastNameTextView;

    public MarbleContactSourceGridViewDragItemLayout(Context context) {
        super(context);
    }

    @Override // com.animaconnected.draganddrop.widget.MarbleContactDragItemLayout, com.animaconnected.draganddrop.widget.DragItemLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mFirstNameTextView = (TextView) findViewById(R.id.first_name_text_view);
        this.mLastNameTextView = (TextView) findViewById(R.id.last_name_text_view);
    }

    @Override // com.animaconnected.draganddrop.widget.MarbleContactDragItemLayout, com.animaconnected.draganddrop.widget.DragItemLayout
    public void setupDragAndDroppableView(DragAndDropItem dragAndDropItem, boolean z) {
        super.setupDragAndDroppableView(dragAndDropItem, z);
        if (dragAndDropItem instanceof DragAndDropMarbleContactItem) {
            DragAndDropMarbleContactItem dragAndDropMarbleContactItem = (DragAndDropMarbleContactItem) dragAndDropItem;
            this.mInitialsTextView.setText(dragAndDropMarbleContactItem.getInitials());
            this.mFirstNameTextView.setText(dragAndDropMarbleContactItem.getFirstName());
            this.mLastNameTextView.setText(dragAndDropMarbleContactItem.getLastName());
            this.mFirstNameTextView.setTextAppearance(dragAndDropMarbleContactItem.getTextStyle());
            this.mLastNameTextView.setTextAppearance(dragAndDropMarbleContactItem.getTextStyle());
            return;
        }
        throw new RuntimeException("Unexpected type of data!");
    }

    public MarbleContactSourceGridViewDragItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarbleContactSourceGridViewDragItemLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
    }
}
