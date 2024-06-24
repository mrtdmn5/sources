package com.animaconnected.watch.fitness;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ElevationApi.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.ElevationApi", f = "ElevationApi.kt", l = {72, 86}, m = "getElevation")
/* loaded from: classes3.dex */
public final class ElevationApi$getElevation$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ElevationApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElevationApi$getElevation$1(ElevationApi elevationApi, Continuation<? super ElevationApi$getElevation$1> continuation) {
        super(continuation);
        this.this$0 = elevationApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getElevation(null, null, this);
    }
}
