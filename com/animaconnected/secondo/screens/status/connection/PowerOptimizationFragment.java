package com.animaconnected.secondo.screens.status.connection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.status.internal.app.PowerOptimizationStatusController;
import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PowerOptimizationFragment.kt */
/* loaded from: classes3.dex */
public final class PowerOptimizationFragment extends BaseStatusFragment {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$lambda$0(View view) {
        PowerOptimizationStatusController powerOptimizationController = ProviderFactory.getStatusProvider().getPowerOptimizationController();
        if (powerOptimizationController != null) {
            powerOptimizationController.requestIgnorePowerOptimizations();
        }
    }

    @Override // com.animaconnected.secondo.screens.status.BaseStatusFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_status_power_optimization, viewGroup, false);
        inflate.findViewById(R.id.opt_out_button).setOnClickListener(new PowerOptimizationFragment$$ExternalSyntheticLambda0());
        return inflate;
    }
}
