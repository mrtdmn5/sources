package com.animaconnected.secondo.screens.labs;

import android.view.View;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class LabsWelcomeDialogFragment extends BottomSheetBaseDialogFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialogView$0(View view) {
        dismiss();
    }

    public static LabsWelcomeDialogFragment newInstance() {
        return new LabsWelcomeDialogFragment();
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog bottomDialog) {
        View inflate = View.inflate(getContext(), R.layout.fragment_labs_welcome_dialog, null);
        inflate.findViewById(R.id.labs_welcome_button).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.labs.LabsWelcomeDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LabsWelcomeDialogFragment.this.lambda$onCreateDialogView$0(view);
            }
        });
        return inflate;
    }
}
