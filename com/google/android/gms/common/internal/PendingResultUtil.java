package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class PendingResultUtil {

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public interface ResultConverter<R extends Result, T> {
        T convert(R r);
    }

    static {
        new zao();
    }

    public static zzw toVoidTask(BasePendingResult basePendingResult) {
        zar zarVar = new zar();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        basePendingResult.addStatusListener(new zap(basePendingResult, taskCompletionSource, zarVar));
        return taskCompletionSource.zza;
    }
}
