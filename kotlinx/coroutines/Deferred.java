package kotlinx.coroutines;

import kotlin.coroutines.Continuation;

/* compiled from: Deferred.kt */
/* loaded from: classes4.dex */
public interface Deferred<T> extends Job {
    Object await(Continuation<? super T> continuation);

    T getCompleted();

    Throwable getCompletionExceptionOrNull();
}
