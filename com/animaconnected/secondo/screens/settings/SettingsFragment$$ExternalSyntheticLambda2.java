package com.animaconnected.secondo.screens.settings;

import android.view.View;
import com.animaconnected.secondo.screens.apps.WatchAppListViewHolder;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class SettingsFragment$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SettingsFragment$$ExternalSyntheticLambda2(int r1, Object obj) {
        this.$r8$classId = r1;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        Object obj = this.f$0;
        switch (r0) {
            case 0:
                SettingsFragment.$r8$lambda$rwJrUXJCjLoS3W6gTAlJvVkz468((SettingsFragment) obj, view);
                return;
            default:
                WatchAppListViewHolder.lambda$3$lambda$2((WatchAppListViewHolder) obj, view);
                return;
        }
    }
}
