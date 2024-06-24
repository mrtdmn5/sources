package com.animaconnected.watch.account.fitness;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FitnessCloudSyncApi.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.fitness.FitnessCloudSyncApi", f = "FitnessCloudSyncApi.kt", l = {121}, m = "fetchUploadUrls")
/* loaded from: classes3.dex */
public final class FitnessCloudSyncApi$fetchUploadUrls$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FitnessCloudSyncApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessCloudSyncApi$fetchUploadUrls$1(FitnessCloudSyncApi fitnessCloudSyncApi, Continuation<? super FitnessCloudSyncApi$fetchUploadUrls$1> continuation) {
        super(continuation);
        this.this$0 = fitnessCloudSyncApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchUploadUrls;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchUploadUrls = this.this$0.fetchUploadUrls(null, null, this);
        return fetchUploadUrls;
    }
}
