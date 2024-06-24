package com.animaconnected.watch.account.strava;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StravaClient.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.strava.StravaClient", f = "StravaClient.kt", l = {251, 257}, m = "revokeAccess")
/* loaded from: classes3.dex */
public final class StravaClient$revokeAccess$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StravaClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StravaClient$revokeAccess$1(StravaClient stravaClient, Continuation<? super StravaClient$revokeAccess$1> continuation) {
        super(continuation);
        this.this$0 = stravaClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.revokeAccess(this);
    }
}
