package com.animaconnected.secondo.screens.watchupdate;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class UpdateFailedDialogFragment extends BottomSheetBaseDialogFragment {
    private static final String DESCRIPTION_TEXT_ID = "descriptionText";
    private String mDescriptionText;

    /* loaded from: classes3.dex */
    public interface UpdateFailedDialogFragmentCallback {
        void onTryAgainClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialogView$0(View view) {
        ((UpdateFailedDialogFragmentCallback) getParentFragment()).onTryAgainClicked();
    }

    public static UpdateFailedDialogFragment newInstance(String str) {
        UpdateFailedDialogFragment updateFailedDialogFragment = new UpdateFailedDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DESCRIPTION_TEXT_ID, str);
        updateFailedDialogFragment.setArguments(bundle);
        return updateFailedDialogFragment;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mDescriptionText = getArguments().getString(DESCRIPTION_TEXT_ID);
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog bottomDialog) {
        View inflate = View.inflate(getContext(), R.layout.dialogfragment_update_failed, null);
        ((TextView) inflate.findViewById(R.id.dialog_update_failed_description)).setText(this.mDescriptionText);
        inflate.findViewById(R.id.try_again_button).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.watchupdate.UpdateFailedDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpdateFailedDialogFragment.this.lambda$onCreateDialogView$0(view);
            }
        });
        bottomDialog.setDismissible(false);
        return inflate;
    }
}
