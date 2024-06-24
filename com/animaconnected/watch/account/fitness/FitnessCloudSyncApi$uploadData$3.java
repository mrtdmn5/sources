package com.animaconnected.watch.account.fitness;

import com.animaconnected.secondo.R;
import io.ktor.client.statement.HttpResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FitnessCloudSyncApi.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.fitness.FitnessCloudSyncApi", f = "FitnessCloudSyncApi.kt", l = {R.styleable.AppTheme_stepsHistoryHintBackgroundColorDetail, R.styleable.AppTheme_stepsHistoryHintBackgroundColorDetail}, m = "uploadData")
/* loaded from: classes3.dex */
public final class FitnessCloudSyncApi$uploadData$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FitnessCloudSyncApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessCloudSyncApi$uploadData$3(FitnessCloudSyncApi fitnessCloudSyncApi, Continuation<? super FitnessCloudSyncApi$uploadData$3> continuation) {
        super(continuation);
        this.this$0 = fitnessCloudSyncApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object uploadData;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        uploadData = this.this$0.uploadData((String) null, (String) null, (Continuation<? super FitnessApiResult<? extends HttpResponse>>) this);
        return uploadData;
    }
}
