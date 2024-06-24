package androidx.compose.runtime;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PausableMonotonicFrameClock.kt */
/* loaded from: classes.dex */
public final class PausableMonotonicFrameClock implements MonotonicFrameClock {
    public final MonotonicFrameClock frameClock;
    public final Latch latch = new Latch();

    public PausableMonotonicFrameClock(MonotonicFrameClock monotonicFrameClock) {
        this.frameClock = monotonicFrameClock;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke(r, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CoroutineContext.DefaultImpls.plus(this, context);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008a A[PHI: r8
  0x008a: PHI (r8v9 java.lang.Object) = (r8v8 java.lang.Object), (r8v1 java.lang.Object) binds: [B:17:0x0087, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // androidx.compose.runtime.MonotonicFrameClock
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <R> java.lang.Object withFrameNanos(kotlin.jvm.functions.Function1<? super java.lang.Long, ? extends R> r7, kotlin.coroutines.Continuation<? super R> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.runtime.PausableMonotonicFrameClock$withFrameNanos$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.runtime.PausableMonotonicFrameClock$withFrameNanos$1 r0 = (androidx.compose.runtime.PausableMonotonicFrameClock$withFrameNanos$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.runtime.PausableMonotonicFrameClock$withFrameNanos$1 r0 = new androidx.compose.runtime.PausableMonotonicFrameClock$withFrameNanos$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L8a
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.jvm.functions.Function1 r7 = r0.L$1
            androidx.compose.runtime.PausableMonotonicFrameClock r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7a
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.runtime.Latch r8 = r6.latch
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r2 = r8.lock
            monitor-enter(r2)
            boolean r5 = r8._isOpen     // Catch: java.lang.Throwable -> L8e
            monitor-exit(r2)
            if (r5 == 0) goto L50
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            goto L76
        L50:
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r2.<init>(r4, r5)
            r2.initCancellability()
            java.lang.Object r4 = r8.lock
            monitor-enter(r4)
            java.util.List<kotlin.coroutines.Continuation<kotlin.Unit>> r5 = r8.awaiters     // Catch: java.lang.Throwable -> L8b
            r5.add(r2)     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r4)
            androidx.compose.runtime.Latch$await$2$2 r4 = new androidx.compose.runtime.Latch$await$2$2
            r4.<init>()
            r2.invokeOnCancellation(r4)
            java.lang.Object r8 = r2.getResult()
            if (r8 != r1) goto L74
            goto L76
        L74:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
        L76:
            if (r8 != r1) goto L79
            return r1
        L79:
            r2 = r6
        L7a:
            androidx.compose.runtime.MonotonicFrameClock r8 = r2.frameClock
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r8 = r8.withFrameNanos(r7, r0)
            if (r8 != r1) goto L8a
            return r1
        L8a:
            return r8
        L8b:
            r7 = move-exception
            monitor-exit(r4)
            throw r7
        L8e:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.PausableMonotonicFrameClock.withFrameNanos(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
