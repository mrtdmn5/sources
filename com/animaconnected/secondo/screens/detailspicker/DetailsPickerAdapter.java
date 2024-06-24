package com.animaconnected.secondo.screens.detailspicker;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.screens.detailspicker.DetailsPickerViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DetailsPickerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int FOOTER_AND_HEADER_COUNT = 2;
    private static final int HEADER_OFFSET = 1;
    private static final int VIEW_TYPE_FOOTER = 2;
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_OPTION_ITEM = 1;
    private String mButtonText;
    private DetailsPickerAdapterButtonListener mDetailsPickerAdapterButtonListener;
    private DetailsPickerAdapterListener mDetailsPickerAdapterListener;
    private String mHeadline;
    private boolean mShowButton;
    protected final ArrayList<PickerOption> mOptions = new ArrayList<>();
    private int mSelectedOption = -1;
    private final DetailsPickerViewHolder.OnListItemClickedListener mOnListItemClicked = new DetailsPickerViewHolder.OnListItemClickedListener() { // from class: com.animaconnected.secondo.screens.detailspicker.DetailsPickerAdapter$$ExternalSyntheticLambda0
        @Override // com.animaconnected.secondo.screens.detailspicker.DetailsPickerViewHolder.OnListItemClickedListener
        public final void onListItemClicked(PickerOption pickerOption) {
            DetailsPickerAdapter.this.lambda$new$0(pickerOption);
        }
    };

    /* loaded from: classes3.dex */
    public interface DetailsPickerAdapterButtonListener {
        void onButtonClicked();
    }

    /* loaded from: classes3.dex */
    public interface DetailsPickerAdapterListener {
        void onListItemClicked(PickerOption pickerOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(PickerOption pickerOption) {
        this.mDetailsPickerAdapterListener.onListItemClicked(pickerOption);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mOptions.size() + 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r3) {
        if (r3 == 0) {
            return 0;
        }
        if (r3 != this.mOptions.size() + 1) {
            return 1;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int r5) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType != 0) {
            boolean z = true;
            if (itemViewType != 1) {
                if (itemViewType == 2 && this.mShowButton) {
                    ((DetailsPickerFooterViewHolder) viewHolder).bind(this.mButtonText);
                    return;
                }
                return;
            }
            int r52 = r5 - 1;
            PickerOption pickerOption = this.mOptions.get(r52);
            DetailsPickerViewHolder detailsPickerViewHolder = (DetailsPickerViewHolder) viewHolder;
            if (r52 != this.mSelectedOption) {
                z = false;
            }
            detailsPickerViewHolder.bind(pickerOption, z);
            return;
        }
        ((DetailsPickerHeaderViewHolder) viewHolder).bind(this.mHeadline);
    }

    public void onButtonClick() {
        this.mDetailsPickerAdapterButtonListener.onButtonClicked();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int r3) {
        if (r3 == 0) {
            return DetailsPickerHeaderViewHolder.newInstance(viewGroup);
        }
        if (r3 == 2) {
            return DetailsPickerFooterViewHolder.newInstance(viewGroup, this);
        }
        return DetailsPickerViewHolder.newInstance(viewGroup, this.mOnListItemClicked);
    }

    public void refreshButton() {
        notifyItemChanged(this.mOptions.size() + 1);
    }

    public void setButtonText(String str) {
        this.mButtonText = str;
    }

    public void setData(List<PickerOption> list) {
        this.mOptions.clear();
        this.mOptions.addAll(list);
        notifyDataSetChanged();
    }

    public void setDetailsPickerAdapterButtonListener(DetailsPickerAdapterButtonListener detailsPickerAdapterButtonListener) {
        this.mDetailsPickerAdapterButtonListener = detailsPickerAdapterButtonListener;
    }

    public void setDetailsPickerAdapterListener(DetailsPickerAdapterListener detailsPickerAdapterListener) {
        this.mDetailsPickerAdapterListener = detailsPickerAdapterListener;
    }

    public void setHeadline(String str) {
        this.mHeadline = str;
    }

    public void setSelectedIndex(int r1) {
        this.mSelectedOption = r1;
        notifyDataSetChanged();
    }

    public void setShowButton(boolean z) {
        this.mShowButton = z;
    }
}
