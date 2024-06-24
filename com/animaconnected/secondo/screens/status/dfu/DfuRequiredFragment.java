package com.animaconnected.secondo.screens.status.dfu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.status.DfuRequiredStatus;
import com.animaconnected.secondo.provider.status.StatusModel;
import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import com.animaconnected.secondo.screens.watchupdate.WatchUpdateFragmentFactory;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DfuRequiredFragment.kt */
/* loaded from: classes3.dex */
public final class DfuRequiredFragment extends BaseStatusFragment {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$lambda$0(DfuRequiredFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onResumeUpdateClicked();
    }

    private final void onResumeUpdateClicked() {
        DfuRequiredStatus dfuRequiredStatus;
        StatusModel status = getStatus();
        if (status instanceof DfuRequiredStatus) {
            dfuRequiredStatus = (DfuRequiredStatus) status;
        } else {
            dfuRequiredStatus = null;
        }
        if (dfuRequiredStatus != null) {
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
        View inflate = inflater.inflate(R.layout.fragment_status_dfu_required, viewGroup, false);
        inflate.findViewById(R.id.resume_dfu_btn).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.status.dfu.DfuRequiredFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DfuRequiredFragment.onCreateView$lambda$1$lambda$0(DfuRequiredFragment.this, view);
            }
        });
        return inflate;
    }
}
