package com.animaconnected.secondo.provider.googlefit;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: GoogleFitProvider.kt */
/* loaded from: classes3.dex */
public final class GoogleFitProviderKt {
    private static final String KEY_GOOGLE_FIT_BADGE = "badge-visible";
    private static final String STORAGE_NAME = "google-fit-badge-storage";

    public static final <TResult> Object getSuspending(Task<TResult> task, Continuation<? super TResult> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        if (task.isComplete()) {
            cancellableContinuationImpl.resumeWith(task.getResult());
        } else {
            task.addOnCompleteListener(new OnCompleteListener() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProviderKt$getSuspending$2$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task<TResult> result) {
                    Pair pair;
                    Intrinsics.checkNotNullParameter(result, "result");
                    try {
                        pair = new Pair(result.getResult(), null);
                    } catch (Exception e) {
                        pair = new Pair(null, e);
                    }
                    Exception exc = (Exception) pair.second;
                    if (cancellableContinuationImpl.isActive()) {
                        if (exc != null) {
                            cancellableContinuationImpl.resumeWith(ResultKt.createFailure(exc));
                        } else {
                            cancellableContinuationImpl.resumeWith(pair.first);
                        }
                    }
                }
            });
            task.addOnCanceledListener(new OnCanceledListener() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProviderKt$getSuspending$2$2
                @Override // com.google.android.gms.tasks.OnCanceledListener
                public final void onCanceled() {
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resumeWith(ResultKt.createFailure(new CancellationException("Task Cancelled")));
                    }
                }
            });
            task.addOnFailureListener(new OnFailureListener() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProviderKt$getSuspending$2$3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exception) {
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resumeWith(ResultKt.createFailure(exception));
                    }
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }
}
