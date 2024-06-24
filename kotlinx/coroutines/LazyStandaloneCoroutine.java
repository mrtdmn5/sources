package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* compiled from: Builders.common.kt */
/* loaded from: classes4.dex */
public final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    public final Continuation<Unit> continuation;

    public LazyStandaloneCoroutine(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.continuation = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onStart() {
        try {
            DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.continuation), Unit.INSTANCE, null);
        } catch (Throwable th) {
            resumeWith(ResultKt.createFailure(th));
            throw th;
        }
    }
}
