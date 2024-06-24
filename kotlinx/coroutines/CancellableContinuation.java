package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes4.dex */
public interface CancellableContinuation<T> extends Continuation<T> {
    boolean cancel(Throwable th);

    void completeResume(Object obj);

    void invokeOnCancellation(Function1<? super Throwable, Unit> function1);

    boolean isActive();

    boolean isCompleted();

    void resume(T t, Function1<? super Throwable, Unit> function1);

    void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, Unit unit);

    Symbol tryResume(Object obj, Function1 function1);

    Symbol tryResumeWithException(Throwable th);
}
