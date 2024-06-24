package com.animaconnected.future;

import android.util.Log;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* compiled from: FutureCoroutine.kt */
/* loaded from: classes.dex */
public final class FutureCoroutineKt {
    public static final String TAG = "DeferredFuture";

    public static final <T> Future<T> asFuture(final Deferred<? extends T> deferred) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        final Promise promise = new Promise();
        deferred.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.animaconnected.future.FutureCoroutineKt$asFuture$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Throwable completionExceptionOrNull = deferred.getCompletionExceptionOrNull();
                if (th != null) {
                    Log.w(FutureCoroutineKt.TAG, "Error: " + th);
                    promise.reject(th);
                    return;
                }
                if (completionExceptionOrNull != null) {
                    Log.w(FutureCoroutineKt.TAG, "Task cancelled: " + completionExceptionOrNull);
                    promise.reject(completionExceptionOrNull);
                    return;
                }
                try {
                    promise.resolve(deferred.getCompleted());
                } catch (Throwable th2) {
                    Log.e(FutureCoroutineKt.TAG, "Exception in resolving promise: " + th2, th2);
                }
            }
        });
        Future<T> future = promise.getFuture();
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }

    public static final <T> Object getSuspending(Future<T> future, Continuation<? super T> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        future.success(new SuccessCallback() { // from class: com.animaconnected.future.FutureCoroutineKt$getSuspending$2$1
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(T t) {
                safeContinuation.resumeWith(t);
            }
        });
        future.fail(new FailCallback() { // from class: com.animaconnected.future.FutureCoroutineKt$getSuspending$2$2
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                Continuation<T> continuation2 = safeContinuation;
                Intrinsics.checkNotNull(th);
                continuation2.resumeWith(ResultKt.createFailure(th));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }
}
