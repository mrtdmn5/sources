package com.animaconnected.secondo.behaviour.counter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.screens.settings.SettingsFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class CounterFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Fragment f$0;

    public /* synthetic */ CounterFragment$$ExternalSyntheticLambda0(Fragment fragment, int r2) {
        this.$r8$classId = r2;
        this.f$0 = fragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        Fragment fragment = this.f$0;
        switch (r0) {
            case 0:
                ((CounterFragment) fragment).lambda$onCreateView$2(view);
                return;
            default:
                SettingsFragment.setupHelpSection$lambda$7((SettingsFragment) fragment, view);
                return;
        }
    }
}
