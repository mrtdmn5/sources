package com.animaconnected.watch.fitness;

import com.amazonaws.services.s3.internal.Constants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider", f = "WatchFitnessProvider.kt", l = {Constants.BUCKET_REDIRECT_STATUS_CODE, 378}, m = "processSessionsFromDB")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$processSessionsFromDB$1 extends ContinuationImpl {
    double D$0;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$processSessionsFromDB$1(WatchFitnessProvider watchFitnessProvider, Continuation<? super WatchFitnessProvider$processSessionsFromDB$1> continuation) {
        super(continuation);
        this.this$0 = watchFitnessProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object processSessionsFromDB;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        processSessionsFromDB = this.this$0.processSessionsFromDB(this);
        return processSessionsFromDB;
    }
}
