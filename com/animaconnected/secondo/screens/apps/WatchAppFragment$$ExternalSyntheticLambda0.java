package com.animaconnected.secondo.screens.apps;

import android.view.View;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.settings.SettingsFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class WatchAppFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BaseFragment f$0;

    public /* synthetic */ WatchAppFragment$$ExternalSyntheticLambda0(BaseFragment baseFragment, int r2) {
        this.$r8$classId = r2;
        this.f$0 = baseFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        BaseFragment baseFragment = this.f$0;
        switch (r0) {
            case 0:
                WatchAppFragment.m832$r8$lambda$ZbaBoyfKdXVyOBOOyShwAoMP84((WatchAppFragment) baseFragment, view);
                return;
            default:
                SettingsFragment.setupAboutSection$lambda$1((SettingsFragment) baseFragment, view);
                return;
        }
    }
}
