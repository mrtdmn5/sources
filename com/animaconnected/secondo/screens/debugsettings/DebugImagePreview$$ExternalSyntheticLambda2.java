package com.animaconnected.secondo.screens.debugsettings;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.temperature.TemperatureFragment;
import com.animaconnected.secondo.screens.status.distress.WaitingForResponseFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class DebugImagePreview$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Fragment f$0;

    public /* synthetic */ DebugImagePreview$$ExternalSyntheticLambda2(Fragment fragment, int r2) {
        this.$r8$classId = r2;
        this.f$0 = fragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        Fragment fragment = this.f$0;
        switch (r0) {
            case 0:
                DebugImagePreview.$r8$lambda$YksYrJupnTmH9odL2W_qmPxvDl0((DebugImagePreview) fragment, view);
                return;
            case 1:
                TemperatureFragment.$r8$lambda$mpYGJbfcfF3GQdCfnMD5JCkRDUA((TemperatureFragment) fragment, view);
                return;
            default:
                ((WaitingForResponseFragment) fragment).lambda$onCreateView$0(view);
                return;
        }
    }
}
