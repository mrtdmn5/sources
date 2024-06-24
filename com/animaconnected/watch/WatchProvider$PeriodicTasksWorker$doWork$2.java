package com.animaconnected.watch;

import androidx.work.ListenableWorker;
import com.animaconnected.secondo.provider.ProviderFactory;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$PeriodicTasksWorker$doWork$2", f = "WatchProvider.kt", l = {235}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$PeriodicTasksWorker$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
    int label;

    public WatchProvider$PeriodicTasksWorker$doWork$2(Continuation<? super WatchProvider$PeriodicTasksWorker$doWork$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchProvider$PeriodicTasksWorker$doWork$2(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object onHandlePeriodicTasks;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                WatchProvider watch = ProviderFactory.getWatch();
                this.label = 1;
                onHandlePeriodicTasks = watch.onHandlePeriodicTasks(this);
                if (onHandlePeriodicTasks == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return new ListenableWorker.Result.Success();
        } catch (Exception unused) {
            return new ListenableWorker.Result.Failure();
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
        return ((WatchProvider$PeriodicTasksWorker$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
