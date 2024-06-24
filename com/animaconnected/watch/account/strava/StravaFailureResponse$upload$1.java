package com.animaconnected.watch.account.strava;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Errors.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.strava.StravaFailureResponse", f = "Errors.kt", l = {14}, m = "upload")
/* loaded from: classes3.dex */
public final class StravaFailureResponse$upload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StravaFailureResponse this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StravaFailureResponse$upload$1(StravaFailureResponse stravaFailureResponse, Continuation<? super StravaFailureResponse$upload$1> continuation) {
        super(continuation);
        this.this$0 = stravaFailureResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.upload(null, this);
    }
}
