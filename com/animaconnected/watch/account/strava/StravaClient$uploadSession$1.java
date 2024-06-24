package com.animaconnected.watch.account.strava;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StravaClient.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.strava.StravaClient", f = "StravaClient.kt", l = {373, 73, 72, 376, 79, 380, 80, 82, 83, 86}, m = "uploadSession")
/* loaded from: classes3.dex */
public final class StravaClient$uploadSession$1 extends ContinuationImpl {
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
    public StravaClient$uploadSession$1(StravaClient stravaClient, Continuation<? super StravaClient$uploadSession$1> continuation) {
        super(continuation);
        this.this$0 = stravaClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadSession(null, this);
    }
}
