package com.animaconnected.secondo.provider.status.internal.distress;

import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.onboarding.Onboarding$connectivityChangedReceiver$1;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class DistressStatusController$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ DistressStatusController$$ExternalSyntheticLambda0(int r1, Object obj) {
        this.$r8$classId = r1;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.$r8$classId;
        Object obj = this.f$0;
        switch (r0) {
            case 0:
                DistressStatusController.update$lambda$0((DistressStatusController) obj);
                return;
            default:
                Onboarding$connectivityChangedReceiver$1.m945$r8$lambda$OJ82BnwDQ7g9Eeh7HfNLTJmPac((Onboarding) obj);
                return;
        }
    }
}
