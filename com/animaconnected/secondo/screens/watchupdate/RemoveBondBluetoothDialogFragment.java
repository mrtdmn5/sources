package com.animaconnected.secondo.screens.watchupdate;

import android.view.View;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class RemoveBondBluetoothDialogFragment extends BottomSheetBaseDialogFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreateDialogView$0(View view) {
        ProviderFactory.getWatchDfuProvider().startRemoveBondAutoFlow();
    }

    public static RemoveBondBluetoothDialogFragment newInstance() {
        return new RemoveBondBluetoothDialogFragment();
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog bottomDialog) {
        View inflate = View.inflate(getContext(), R.layout.dialogfragment_update_watch_remove_bond_bluetooth, null);
        inflate.findViewById(R.id.try_again_button).setOnClickListener(new RemoveBondBluetoothDialogFragment$$ExternalSyntheticLambda0());
        bottomDialog.setDismissible(false);
        return inflate;
    }
}
