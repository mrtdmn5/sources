package com.animaconnected.secondo.screens.pickerdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.kronaby.watch.app.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PickerDialogFragment extends BottomSheetBaseDialogFragment {
    private static final String KEY_CURRENT_VALUE_INDEX = "currentValueIndex";
    private static final String KEY_DIALOG_ID = "dialogId";
    private static final String KEY_PICKER_VALUES = "pickerValues";
    private static final String KEY_TITLE = "title";
    private int mCurrentValueIndex;
    private int mDialogId;
    private ArrayList<String> mPickerValues;
    private String mTitle;

    private PickerDialogFragmentCallback getPickerDialogFragmentCallback() {
        return (PickerDialogFragmentCallback) getParentFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialogView$0(NumberPicker numberPicker, View view) {
        getPickerDialogFragmentCallback().onIndexSelected(numberPicker.getValue(), this.mDialogId);
        dismiss();
    }

    public static PickerDialogFragment newInstance(int r3, String str, ArrayList<String> arrayList, int r6) {
        PickerDialogFragment pickerDialogFragment = new PickerDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putStringArrayList(KEY_PICKER_VALUES, arrayList);
        bundle.putInt(KEY_CURRENT_VALUE_INDEX, r6);
        bundle.putInt(KEY_DIALOG_ID, r3);
        pickerDialogFragment.setArguments(bundle);
        return pickerDialogFragment;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTitle = getArguments().getString("title");
        this.mPickerValues = getArguments().getStringArrayList(KEY_PICKER_VALUES);
        this.mCurrentValueIndex = getArguments().getInt(KEY_CURRENT_VALUE_INDEX);
        this.mDialogId = getArguments().getInt(KEY_DIALOG_ID);
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog bottomDialog) {
        View inflate = View.inflate(getContext(), R.layout.dialogfragment_scroll_picker, null);
        ((TextView) inflate.findViewById(R.id.picker_title)).setText(this.mTitle);
        final NumberPicker numberPicker = (NumberPicker) inflate.findViewById(R.id.numberPicker);
        ArrayList<String> arrayList = this.mPickerValues;
        numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[arrayList.size()]));
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(this.mPickerValues.size() - 1);
        numberPicker.setValue(this.mCurrentValueIndex);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDescendantFocusability(393216);
        inflate.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.pickerdialog.PickerDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PickerDialogFragment.this.lambda$onCreateDialogView$0(numberPicker, view);
            }
        });
        bottomDialog.setDismissible(false);
        return inflate;
    }
}
