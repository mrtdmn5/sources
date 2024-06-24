package com.animaconnected.watch.account.strava;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StravaClient.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.strava.StravaClient", f = "StravaClient.kt", l = {170, R.styleable.AppTheme_themeBackgroundResource, 368, R.styleable.AppTheme_workoutDetailColorBackground}, m = "pollStatus")
/* loaded from: classes3.dex */
public final class StravaClient$pollStatus$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StravaClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StravaClient$pollStatus$1(StravaClient stravaClient, Continuation<? super StravaClient$pollStatus$1> continuation) {
        super(continuation);
        this.this$0 = stravaClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object pollStatus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        pollStatus = this.this$0.pollStatus(null, this);
        return pollStatus;
    }
}
