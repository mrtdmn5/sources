package com.animaconnected.secondo.screens.status.dfu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.status.DfuFailedStatus;
import com.animaconnected.secondo.provider.status.StatusModel;
import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import com.animaconnected.secondo.screens.watchupdate.WatchUpdateFragmentFactory;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DfuFailedFragment.kt */
/* loaded from: classes3.dex */
public final class DfuFailedFragment extends BaseStatusFragment {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$lambda$0(DfuFailedFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onGoToUpdateClicked();
    }

    private final void onGoToUpdateClicked() {
        DfuFailedStatus dfuFailedStatus;
        StatusModel status = getStatus();
        if (status instanceof DfuFailedStatus) {
            dfuFailedStatus = (DfuFailedStatus) status;
        } else {
            dfuFailedStatus = null;
        }
        if (dfuFailedStatus != null) {
            getMainController().gotoNextFragment(WatchUpdateFragmentFactory.INSTANCE.getWatchUpdateFragment$secondo_kronabyRelease(ProviderFactory.getWatch().getFirmwareUpdate()));
        }
    }

    @Override // com.animaconnected.secondo.screens.status.BaseStatusFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_status_dfu_failed, viewGroup, false);
        inflate.findViewById(R.id.go_to_dfu_btn).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.status.dfu.DfuFailedFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DfuFailedFragment.onCreateView$lambda$1$lambda$0(DfuFailedFragment.this, view);
            }
        });
        return inflate;
    }
}
