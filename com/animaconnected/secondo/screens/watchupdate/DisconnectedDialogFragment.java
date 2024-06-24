package com.animaconnected.secondo.screens.watchupdate;

import android.view.View;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class DisconnectedDialogFragment extends BottomSheetBaseDialogFragment {
    public static DisconnectedDialogFragment newInstance() {
        return new DisconnectedDialogFragment();
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog bottomDialog) {
        View inflate = View.inflate(getContext(), R.layout.dialogfragment_update_watch_disconnected, null);
        bottomDialog.setDismissible(false);
        return inflate;
    }
}
