package com.animaconnected.secondo.screens.onboarding;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.animaconnected.secondo.provider.status.internal.distress.DistressStatusController$$ExternalSyntheticLambda0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Onboarding.kt */
/* loaded from: classes3.dex */
public final class Onboarding$connectivityChangedReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ Onboarding this$0;

    public Onboarding$connectivityChangedReceiver$1(Onboarding onboarding) {
        this.this$0 = onboarding;
    }

    public static final void onReceive$lambda$0(Onboarding this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateInternetConnectivityEnabled(false);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Handler handler;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        handler = this.this$0.handler;
        handler.post(new DistressStatusController$$ExternalSyntheticLambda0(1, this.this$0));
    }
}
