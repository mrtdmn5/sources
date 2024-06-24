package com.animaconnected.secondo.screens.campaigns;

import android.view.View;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.settings.WatchSettingsFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class CampaignFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BaseFragment f$0;

    public /* synthetic */ CampaignFragment$$ExternalSyntheticLambda0(BaseFragment baseFragment, int r2) {
        this.$r8$classId = r2;
        this.f$0 = baseFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        BaseFragment baseFragment = this.f$0;
        switch (r0) {
            case 0:
                CampaignFragment.onCreateView$lambda$1$lambda$0((CampaignFragment) baseFragment, view);
                return;
            default:
                WatchSettingsFragment.onCreateView$lambda$8$lambda$2((WatchSettingsFragment) baseFragment, view);
                return;
        }
    }
}
