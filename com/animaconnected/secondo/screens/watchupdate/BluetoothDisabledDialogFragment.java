package com.animaconnected.secondo.screens.watchupdate;

import android.os.Build;
import android.view.View;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BluetoothDisabledDialogFragment.kt */
/* loaded from: classes3.dex */
public final class BluetoothDisabledDialogFragment extends BottomSheetBaseDialogFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: BluetoothDisabledDialogFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BluetoothDisabledDialogFragment newInstance() {
            return new BluetoothDisabledDialogFragment();
        }

        private Companion() {
        }
    }

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
        View inflate = View.inflate(getContext(), R.layout.dialogfragment_update_watch_bluetooth_disabled, null);
        View findViewById = inflate.findViewById(R.id.turn_on_bluetooth_button);
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.checkNotNull(findViewById);
            ViewKt.gone(findViewById);
        }
        findViewById.setOnClickListener(new BluetoothDisabledDialogFragment$$ExternalSyntheticLambda0());
        dialog.setDismissible(false);
        return inflate;
    }
}
