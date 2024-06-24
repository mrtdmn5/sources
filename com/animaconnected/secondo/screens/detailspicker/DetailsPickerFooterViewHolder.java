package com.animaconnected.secondo.screens.detailspicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
class DetailsPickerFooterViewHolder extends RecyclerView.ViewHolder {
    private final Button mButton;
    private final View mButtonContainer;

    private DetailsPickerFooterViewHolder(View view, final DetailsPickerAdapter detailsPickerAdapter) {
        super(view);
        Button button = (Button) view.findViewById(R.id.button);
        this.mButton = button;
        this.mButtonContainer = view.findViewById(R.id.button_container);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.detailspicker.DetailsPickerFooterViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DetailsPickerAdapter.this.onButtonClick();
            }
        });
    }

    public static DetailsPickerFooterViewHolder newInstance(ViewGroup viewGroup, DetailsPickerAdapter detailsPickerAdapter) {
        return new DetailsPickerFooterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_details_chooser_footer, viewGroup, false), detailsPickerAdapter);
    }

    public void bind(String str) {
        this.mButtonContainer.setVisibility(0);
        this.mButton.setText(str);
    }
}
