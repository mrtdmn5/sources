package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ContextScope;

/* compiled from: CoroutineWorker.kt */
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    private final CoroutineDispatcher coroutineContext;
    private final SettableFuture<ListenableWorker.Result> future;
    private final CompletableJob job;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context appContext, WorkerParameters params) {
        super(appContext, params);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(params, "params");
        this.job = JobKt.Job$default();
        SettableFuture<ListenableWorker.Result> settableFuture = new SettableFuture<>();
        this.future = settableFuture;
        settableFuture.addListener(new Runnable() { // from class: androidx.work.CoroutineWorker.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CoroutineWorker.this.getFuture$work_runtime_ktx_release().value instanceof AbstractFuture.Cancellation) {
                    CoroutineWorker.this.getJob$work_runtime_ktx_release().cancel(null);
                }
            }
        }, ((WorkManagerTaskExecutor) getTaskExecutor()).mBackgroundExecutor);
        this.coroutineContext = Dispatchers.Default;
    }

    public static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, Continuation continuation) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object doWork(Continuation<? super ListenableWorker.Result> continuation);

    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object getForegroundInfo(Continuation<? super ForegroundInfo> continuation) {
        return getForegroundInfo$suspendImpl(this, continuation);
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        JobImpl Job$default = JobKt.Job$default();
        ContextScope CoroutineScope = CoroutineScopeKt.CoroutineScope(getCoroutineContext().plus(Job$default));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(Job$default);
        BuildersKt.launch$default(CoroutineScope, null, null, new CoroutineWorker$getForegroundInfoAsync$1(jobListenableFuture, this, null), 3);
        return jobListenableFuture;
    }

    public final SettableFuture<ListenableWorker.Result> getFuture$work_runtime_ktx_release() {
        return this.future;
    }

    public final CompletableJob getJob$work_runtime_ktx_release() {
        return this.job;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, Continuation<? super Unit> continuation) {
        Object obj;
        ListenableFuture<Void> foregroundAsync = setForegroundAsync(foregroundInfo);
        Intrinsics.checkNotNullExpressionValue(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        if (foregroundAsync.isDone()) {
            try {
                obj = foregroundAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        } else {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
            cancellableContinuationImpl.initCancellability();
            foregroundAsync.addListener(new ListenableFutureKt$await$2$1(cancellableContinuationImpl, foregroundAsync), DirectExecutor.INSTANCE);
            cancellableContinuationImpl.invokeOnCancellation(new ListenableFutureKt$await$2$2(foregroundAsync));
            obj = cancellableContinuationImpl.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        }
        if (obj == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return obj;
        }
        return Unit.INSTANCE;
    }

    public final Object setProgress(Data data, Continuation<? super Unit> continuation) {
        Object obj;
        ListenableFuture<Void> progressAsync = setProgressAsync(data);
        Intrinsics.checkNotNullExpressionValue(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                obj = progressAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        } else {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
            cancellableContinuationImpl.initCancellability();
            progressAsync.addListener(new ListenableFutureKt$await$2$1(cancellableContinuationImpl, progressAsync), DirectExecutor.INSTANCE);
            cancellableContinuationImpl.invokeOnCancellation(new ListenableFutureKt$await$2$2(progressAsync));
            obj = cancellableContinuationImpl.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        }
        if (obj == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return obj;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(getCoroutineContext().plus(this.job)), null, null, new CoroutineWorker$startWork$1(this, null), 3);
        return this.future;
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }
}
