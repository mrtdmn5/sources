package com.animaconnected.watch.account.fitness;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FitnessCloudSyncApi.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.fitness.FitnessCloudSyncApi", f = "FitnessCloudSyncApi.kt", l = {R.styleable.AppTheme_stepsHistoryColumnColorActivity}, m = "fetchDownloadUrls")
/* loaded from: classes3.dex */
public final class FitnessCloudSyncApi$fetchDownloadUrls$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FitnessCloudSyncApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessCloudSyncApi$fetchDownloadUrls$1(FitnessCloudSyncApi fitnessCloudSyncApi, Continuation<? super FitnessCloudSyncApi$fetchDownloadUrls$1> continuation) {
        super(continuation);
        this.this$0 = fitnessCloudSyncApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchDownloadUrls;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchDownloadUrls = this.this$0.fetchDownloadUrls(null, null, this);
        return fetchDownloadUrls;
    }
}
