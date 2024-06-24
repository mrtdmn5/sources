package com.animaconnected.secondo.provider.googlefit;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GoogleFitApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitApi", f = "GoogleFitApi.kt", l = {122}, m = "insertData-gIAlu-s")
/* loaded from: classes3.dex */
public final class GoogleFitApi$insertData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GoogleFitApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitApi$insertData$1(GoogleFitApi googleFitApi, Continuation<? super GoogleFitApi$insertData$1> continuation) {
        super(continuation);
        this.this$0 = googleFitApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m801insertDatagIAlus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m801insertDatagIAlus = this.this$0.m801insertDatagIAlus(null, this);
        if (m801insertDatagIAlus == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return m801insertDatagIAlus;
        }
        return new Result(m801insertDatagIAlus);
    }
}
