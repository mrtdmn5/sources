package com.animaconnected.secondo.screens.detailspicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class DetailsPickerViewHolder extends RecyclerView.ViewHolder {
    private final ViewGroup mContainer;
    private final OnListItemClickedListener mOnListItemClickedListener;
    private final TextView mOptionName;
    private final TextView mOptionSub;
    protected PickerOption mPickerOption;
    private final ImageView mSelectedItem;

    /* loaded from: classes3.dex */
    public interface OnListItemClickedListener {
        void onListItemClicked(PickerOption pickerOption);
    }

    private DetailsPickerViewHolder(View view, OnListItemClickedListener onListItemClickedListener) {
        super(view);
        this.mOnListItemClickedListener = onListItemClickedListener;
        this.mContainer = (ViewGroup) view.findViewById(R.id.container);
        this.mOptionName = (TextView) view.findViewById(R.id.option_name);
        this.mOptionSub = (TextView) view.findViewById(R.id.option_sub);
        this.mSelectedItem = (ImageView) view.findViewById(R.id.selected);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.detailspicker.DetailsPickerViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DetailsPickerViewHolder.this.lambda$new$0(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        this.mOnListItemClickedListener.onListItemClicked(this.mPickerOption);
    }

    public static DetailsPickerViewHolder newInstance(ViewGroup viewGroup, OnListItemClickedListener onListItemClickedListener) {
        return new DetailsPickerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_details_chooser, viewGroup, false), onListItemClickedListener);
    }

    public void bind(PickerOption pickerOption, boolean z) {
        this.mPickerOption = pickerOption;
        this.mOptionName.setText(pickerOption.getDisplayText());
        this.mOptionSub.setText(pickerOption.getSubText());
        if (z) {
            ViewGroup viewGroup = this.mContainer;
            Context context = this.itemView.getContext();
            Object obj = ContextCompat.sLock;
            viewGroup.setBackgroundColor(ContextCompat.Api23Impl.getColor(context, R.color.colorSelectedListItemApp));
            this.mSelectedItem.setVisibility(0);
            return;
        }
        ViewGroup viewGroup2 = this.mContainer;
        Context context2 = this.itemView.getContext();
        Object obj2 = ContextCompat.sLock;
        viewGroup2.setBackgroundColor(ContextCompat.Api23Impl.getColor(context2, R.color.colorTransparent));
        this.mSelectedItem.setVisibility(8);
    }
}
