package com.animaconnected.secondo.screens.detailspicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
class DetailsPickerHeaderViewHolder extends RecyclerView.ViewHolder {
    private final TextView mPrimaryTextView;

    private DetailsPickerHeaderViewHolder(View view) {
        super(view);
        this.mPrimaryTextView = (TextView) view.findViewById(R.id.title_text_view);
    }

    public static DetailsPickerHeaderViewHolder newInstance(ViewGroup viewGroup) {
        return new DetailsPickerHeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_details_chooser_header, viewGroup, false));
    }

    public void bind(String str) {
        this.mPrimaryTextView.setText(str);
    }
}
