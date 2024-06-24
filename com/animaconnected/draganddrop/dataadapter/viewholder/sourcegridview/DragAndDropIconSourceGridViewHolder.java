package com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.dataadapter.OnSourceGridItemClickedListener;
import com.animaconnected.draganddrop.provider.model.DragAndDropIconItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;

/* loaded from: classes.dex */
public class DragAndDropIconSourceGridViewHolder extends DragAndDropSourceGridViewHolderBase {
    private DragAndDropItem mDragAndDropItem;
    private final ImageView mIconImageView;
    private final TextView mNameTextView;
    private final OnSourceGridItemClickedListener mOnSourceGridItemClickedListener;

    private DragAndDropIconSourceGridViewHolder(View view, OnSourceGridItemClickedListener onSourceGridItemClickedListener) {
        super(view);
        this.mIconImageView = (ImageView) view.findViewById(R.id.icon_image_view);
        this.mNameTextView = (TextView) view.findViewById(R.id.icon_text_view);
        this.mOnSourceGridItemClickedListener = onSourceGridItemClickedListener;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview.DragAndDropIconSourceGridViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DragAndDropIconSourceGridViewHolder.this.lambda$new$0(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        this.mOnSourceGridItemClickedListener.onSourceGridItemClicked(null, this.mDragAndDropItem);
    }

    public static DragAndDropIconSourceGridViewHolder newInstance(ViewGroup viewGroup, OnSourceGridItemClickedListener onSourceGridItemClickedListener) {
        return new DragAndDropIconSourceGridViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sourcegridview_icon, viewGroup, false), onSourceGridItemClickedListener);
    }

    @Override // com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview.DragAndDropSourceGridViewHolderBase
    public void bind(DragAndDropItem dragAndDropItem) {
        this.mDragAndDropItem = dragAndDropItem;
        if (dragAndDropItem instanceof DragAndDropIconItem) {
            DragAndDropIconItem dragAndDropIconItem = (DragAndDropIconItem) dragAndDropItem;
            this.mIconImageView.setBackgroundResource(dragAndDropIconItem.getIconResourceId());
            this.mNameTextView.setText(dragAndDropIconItem.getIconText());
            this.mNameTextView.setTextAppearance(dragAndDropIconItem.getTextStyle());
            return;
        }
        throw new RuntimeException("Unexpected type of data!");
    }
}
