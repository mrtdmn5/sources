package com.animaconnected.secondo.screens.debugsettings;

import android.view.View;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.watchupdate.WatchUpdateCompletedFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class DeviceInfoFragment$$ExternalSyntheticLambda8 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BaseFragment f$0;

    public /* synthetic */ DeviceInfoFragment$$ExternalSyntheticLambda8(BaseFragment baseFragment, int r2) {
        this.$r8$classId = r2;
        this.f$0 = baseFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        BaseFragment baseFragment = this.f$0;
        switch (r0) {
            case 0:
                ((DeviceInfoFragment) baseFragment).lambda$onCreateView$0(view);
                return;
            default:
                WatchUpdateCompletedFragment.$r8$lambda$JBFzz8mPbgLGvIlxxVLeARAQzpA((WatchUpdateCompletedFragment) baseFragment, view);
                return;
        }
    }
}
