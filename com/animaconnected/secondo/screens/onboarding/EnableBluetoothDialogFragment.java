package com.animaconnected.secondo.screens.onboarding;

import android.os.Build;
import android.view.View;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnableBluetoothDialogFragment.kt */
/* loaded from: classes3.dex */
public final class EnableBluetoothDialogFragment extends BottomSheetBaseDialogFragment {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialogView$lambda$2$lambda$1$lambda$0(View view) {
        ConnectionFactory.getConnection().enable();
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        View inflate = View.inflate(getContext(), R.layout.dialogfragment_onboarding_enable_bluetooth, null);
        dialog.setDismissible(false);
        View findViewById = inflate.findViewById(R.id.btn_turn_on_bluetooth);
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.checkNotNull(findViewById);
            ViewKt.gone(findViewById);
        }
        findViewById.setOnClickListener(new EnableBluetoothDialogFragment$$ExternalSyntheticLambda0());
        return inflate;
    }
}
