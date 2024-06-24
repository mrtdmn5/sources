package com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.provider.model.DragAndDropHeaderItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;

/* loaded from: classes.dex */
public class DragAndDropHeaderSourceGridViewHolder extends DragAndDropSourceGridViewHolderBase {
    private final TextView mTitleTextView;
    private final Space mTopSpace;

    private DragAndDropHeaderSourceGridViewHolder(View view, int r3) {
        super(view);
        TextView textView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleTextView = textView;
        textView.setTextAppearance(r3);
        this.mTopSpace = (Space) view.findViewById(R.id.top_space);
    }

    public static DragAndDropHeaderSourceGridViewHolder newInstance(ViewGroup viewGroup, int r5) {
        return new DragAndDropHeaderSourceGridViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sourcegridview_header, viewGroup, false), r5);
    }

    @Override // com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview.DragAndDropSourceGridViewHolderBase
    public void bind(DragAndDropItem dragAndDropItem) {
        int r3;
        if (dragAndDropItem instanceof DragAndDropHeaderItem) {
            DragAndDropHeaderItem dragAndDropHeaderItem = (DragAndDropHeaderItem) dragAndDropItem;
            this.mTitleTextView.setText(dragAndDropHeaderItem.getHeaderName());
            Space space = this.mTopSpace;
            if (dragAndDropHeaderItem.getIsFirst()) {
                r3 = 8;
            } else {
                r3 = 0;
            }
            space.setVisibility(r3);
            return;
        }
        throw new RuntimeException("Unexpected type of data!");
    }
}
