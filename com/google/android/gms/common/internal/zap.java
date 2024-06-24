package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zap implements PendingResult.StatusListener {
    public final /* synthetic */ PendingResult zaa;
    public final /* synthetic */ TaskCompletionSource zab;
    public final /* synthetic */ PendingResultUtil.ResultConverter zac;

    public zap(BasePendingResult basePendingResult, TaskCompletionSource taskCompletionSource, zar zarVar) {
        this.zaa = basePendingResult;
        this.zab = taskCompletionSource;
        this.zac = zarVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        if (status.isSuccess()) {
            PendingResult pendingResult = this.zaa;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            BasePendingResult basePendingResult = (BasePendingResult) pendingResult;
            Preconditions.checkState("Result has already been consumed.", !basePendingResult.zal);
            try {
                if (!basePendingResult.zaf.await(0L, timeUnit)) {
                    basePendingResult.forceFailureUnlessReady(Status.RESULT_TIMEOUT);
                }
            } catch (InterruptedException unused) {
                basePendingResult.forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
            }
            Preconditions.checkState("Result is not ready.", basePendingResult.isReady());
            this.zab.setResult(this.zac.convert(basePendingResult.zaa()));
            return;
        }
        this.zab.setException(ApiExceptionUtil.fromStatus(status));
    }
}
