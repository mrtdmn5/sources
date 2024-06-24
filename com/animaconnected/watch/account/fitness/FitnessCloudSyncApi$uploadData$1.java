package com.animaconnected.watch.account.fitness;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FitnessCloudSyncApi.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.fitness.FitnessCloudSyncApi", f = "FitnessCloudSyncApi.kt", l = {58, 61}, m = "uploadData")
/* loaded from: classes3.dex */
public final class FitnessCloudSyncApi$uploadData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FitnessCloudSyncApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessCloudSyncApi$uploadData$1(FitnessCloudSyncApi fitnessCloudSyncApi, Continuation<? super FitnessCloudSyncApi$uploadData$1> continuation) {
        super(continuation);
        this.this$0 = fitnessCloudSyncApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadData((List<FitnessFile>) null, (String) null, this);
    }
}
