package com.animaconnected.secondo.behaviour.steps;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.screens.status.distress.PendingWalkFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class StepsFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Fragment f$0;

    public /* synthetic */ StepsFragment$$ExternalSyntheticLambda0(Fragment fragment, int r2) {
        this.$r8$classId = r2;
        this.f$0 = fragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        Fragment fragment = this.f$0;
        switch (r0) {
            case 0:
                StepsFragment.$r8$lambda$98OybCtly5Ur_o4s7_Zyrt_efVk((StepsFragment) fragment, view);
                return;
            default:
                ((PendingWalkFragment) fragment).lambda$onViewCreated$2(view);
                return;
        }
    }
}
