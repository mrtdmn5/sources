package com.animaconnected.secondo.behaviour.rememberthisspot;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.screens.status.distress.DistressActiveEmergencyFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RememberThisSpotFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Fragment f$0;

    public /* synthetic */ RememberThisSpotFragment$$ExternalSyntheticLambda0(Fragment fragment, int r2) {
        this.$r8$classId = r2;
        this.f$0 = fragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        Fragment fragment = this.f$0;
        switch (r0) {
            case 0:
                RememberThisSpotFragment.m787$r8$lambda$IHb4kOlw6VQAhg_cFToUoRjE2M((RememberThisSpotFragment) fragment, view);
                return;
            default:
                ((DistressActiveEmergencyFragment) fragment).lambda$onViewCreated$0(view);
                return;
        }
    }
}
