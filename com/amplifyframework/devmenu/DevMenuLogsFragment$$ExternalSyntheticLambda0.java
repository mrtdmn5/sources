package com.amplifyframework.devmenu;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.screens.settings.SettingsFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class DevMenuLogsFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Fragment f$0;

    public /* synthetic */ DevMenuLogsFragment$$ExternalSyntheticLambda0(Fragment fragment, int r2) {
        this.$r8$classId = r2;
        this.f$0 = fragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        Fragment fragment = this.f$0;
        switch (r0) {
            case 0:
                DevMenuLogsFragment.$r8$lambda$GErhYQPaEccs2qxscWja8gnD9jQ((DevMenuLogsFragment) fragment, view);
                return;
            default:
                SettingsFragment.setupRateUsSection$lambda$14((SettingsFragment) fragment, view);
                return;
        }
    }
}
