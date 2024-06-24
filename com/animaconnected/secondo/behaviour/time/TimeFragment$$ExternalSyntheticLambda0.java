package com.animaconnected.secondo.behaviour.time;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPageFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class TimeFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Fragment f$0;

    public /* synthetic */ TimeFragment$$ExternalSyntheticLambda0(Fragment fragment, int r2) {
        this.$r8$classId = r2;
        this.f$0 = fragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        Fragment fragment = this.f$0;
        switch (r0) {
            case 0:
                TimeFragment.$r8$lambda$kGZD9fDNNMylEiYKaY5GUbT3iuA((TimeFragment) fragment, view);
                return;
            default:
                TipsAndTricksPageFragment.onCreateView$lambda$6$lambda$4$lambda$3((TipsAndTricksPageFragment) fragment, view);
                return;
        }
    }
}
