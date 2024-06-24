package aws.smithy.kotlin.runtime.util;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: LazyAsyncValue.kt */
/* loaded from: classes.dex */
public final class LazyAsyncValueImpl<T> {
    public Function1<? super Continuation<? super T>, ? extends Object> initializer;

    /* renamed from: mu, reason: collision with root package name */
    public final MutexImpl f132mu = MutexKt.Mutex$default();
    public Object value = ExecutorsKt.INSTANCE;

    public LazyAsyncValueImpl(Function1<? super Continuation<? super T>, ? extends Object> function1) {
        this.initializer = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:12:0x002d, B:13:0x0071, B:14:0x0079, B:22:0x0055, B:24:0x005b), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v7, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(kotlin.coroutines.Continuation<? super T> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl$get$1
            if (r0 == 0) goto L13
            r0 = r8
            aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl$get$1 r0 = (aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl$get$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl$get$1 r0 = new aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl$get$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl r1 = r0.L$2
            kotlinx.coroutines.sync.Mutex r2 = r0.L$1
            aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L77
            goto L71
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L39:
            kotlinx.coroutines.sync.Mutex r2 = r0.L$1
            aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl r4 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r7
            kotlinx.coroutines.sync.MutexImpl r8 = r7.f132mu
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r8.lock(r5, r0)
            if (r2 != r1) goto L53
            return r1
        L53:
            r4 = r7
            r2 = r8
        L55:
            java.lang.Object r8 = r4.value     // Catch: java.lang.Throwable -> L77
            kotlinx.coroutines.ExecutorsKt r6 = kotlinx.coroutines.ExecutorsKt.INSTANCE     // Catch: java.lang.Throwable -> L77
            if (r8 != r6) goto L79
            kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r8 = r4.initializer     // Catch: java.lang.Throwable -> L77
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch: java.lang.Throwable -> L77
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L77
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L77
            r0.L$2 = r4     // Catch: java.lang.Throwable -> L77
            r0.label = r3     // Catch: java.lang.Throwable -> L77
            java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L77
            if (r8 != r1) goto L6f
            return r1
        L6f:
            r0 = r4
            r1 = r0
        L71:
            r1.value = r8     // Catch: java.lang.Throwable -> L77
            r0.initializer = r5     // Catch: java.lang.Throwable -> L77
            r4 = r0
            goto L79
        L77:
            r8 = move-exception
            goto L7f
        L79:
            java.lang.Object r8 = r4.value     // Catch: java.lang.Throwable -> L77
            r2.unlock(r5)
            return r8
        L7f:
            r2.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl.get(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
