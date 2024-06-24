package com.animaconnected.secondo.screens.settings;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.distress.detail.DistressFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class SettingsFragment$$ExternalSyntheticLambda9 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Fragment f$0;

    public /* synthetic */ SettingsFragment$$ExternalSyntheticLambda9(Fragment fragment, int r2) {
        this.$r8$classId = r2;
        this.f$0 = fragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        Fragment fragment = this.f$0;
        switch (r0) {
            case 0:
                SettingsFragment.setupLabsSection$lambda$15((SettingsFragment) fragment, view);
                return;
            default:
                DistressFragment.onCreateView$lambda$5((DistressFragment) fragment, view);
                return;
        }
    }
}
