package com.animaconnected.watch.account.strava;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StravaClient.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.strava.StravaClient", f = "StravaClient.kt", l = {373, 305, 376, 324}, m = "refreshTokens")
/* loaded from: classes3.dex */
public final class StravaClient$refreshTokens$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StravaClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StravaClient$refreshTokens$1(StravaClient stravaClient, Continuation<? super StravaClient$refreshTokens$1> continuation) {
        super(continuation);
        this.this$0 = stravaClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object refreshTokens;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        refreshTokens = this.this$0.refreshTokens(this);
        return refreshTokens;
    }
}
