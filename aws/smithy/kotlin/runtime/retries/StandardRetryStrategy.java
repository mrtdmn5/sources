package aws.smithy.kotlin.runtime.retries;

import aws.smithy.kotlin.runtime.retries.delay.DelayProvider;
import aws.smithy.kotlin.runtime.retries.delay.ExponentialBackoffWithJitter;
import aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket;
import aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket;
import kotlin.Result;

/* compiled from: StandardRetryStrategy.kt */
/* loaded from: classes.dex */
public final class StandardRetryStrategy implements RetryStrategy {
    public final DelayProvider delayProvider;
    public final StandardRetryStrategyOptions options;
    public final RetryTokenBucket tokenBucket;

    public StandardRetryStrategy() {
        this(0);
    }

    public static void throwFailure(int r2, Object obj) {
        Throwable m1661exceptionOrNullimpl = Result.m1661exceptionOrNullimpl(obj);
        if (m1661exceptionOrNullimpl == null) {
            if (obj instanceof Result.Failure) {
                obj = null;
            }
            throw new RetryFailureException(r2, obj);
        }
        throw m1661exceptionOrNullimpl;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:38|39|40|41|42|(1:44)(3:45|13|(3:17|18|(2:24|(2:70|71)(2:26|(2:68|69)(2:28|(2:30|(1:32)(3:33|34|(1:36)(7:37|38|39|40|41|42|(0)(0))))(2:66|67))))(2:20|(1:22)(1:23)))(1:15))) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e7, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e8, code lost:            r16 = r12;        r12 = r1;        r1 = r11;        r11 = r3;        r3 = r16;     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ef, code lost:            r0 = kotlin.ResultKt.createFailure(r0);     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0165 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00dd -> B:13:0x00f4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <R> java.lang.Object doTryLoop(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r18, aws.smithy.kotlin.runtime.retries.policy.RetryPolicy<? super R> r19, int r20, aws.smithy.kotlin.runtime.retries.delay.RetryToken r21, kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.retries.Outcome<? extends R>> r22) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.retries.StandardRetryStrategy.doTryLoop(kotlin.jvm.functions.Function1, aws.smithy.kotlin.runtime.retries.policy.RetryPolicy, int, aws.smithy.kotlin.runtime.retries.delay.RetryToken, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // aws.smithy.kotlin.runtime.retries.RetryStrategy
    public final StandardRetryStrategyOptions getOptions() {
        return this.options;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0071 A[PHI: r11
  0x0071: PHI (r11v6 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:17:0x006e, B:10:0x0027] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r10v2, types: [aws.smithy.kotlin.runtime.retries.policy.RetryPolicy] */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.jvm.functions.Function1] */
    @Override // aws.smithy.kotlin.runtime.retries.RetryStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object retry(aws.smithy.kotlin.runtime.http.middleware.PolicyLogger r9, aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$result$outcome$1 r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$retry$1
            if (r0 == 0) goto L13
            r0 = r11
            aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$retry$1 r0 = (aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$retry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$retry$1 r0 = new aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$retry$1
            r0.<init>(r8, r11)
        L18:
            r6 = r0
            java.lang.Object r11 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L44
            if (r1 == r3) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r11)
            goto L71
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            int r9 = r6.I$0
            aws.smithy.kotlin.runtime.retries.policy.RetryPolicy r10 = r6.L$2
            kotlin.jvm.functions.Function1 r1 = r6.L$1
            aws.smithy.kotlin.runtime.retries.StandardRetryStrategy r3 = r6.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            r4 = r9
            r7 = r3
            r3 = r10
            r10 = r1
            r1 = r7
            goto L5d
        L44:
            kotlin.ResultKt.throwOnFailure(r11)
            r6.L$0 = r8
            r6.L$1 = r10
            r6.L$2 = r9
            r6.I$0 = r3
            r6.label = r3
            aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket r11 = r8.tokenBucket
            java.lang.Object r11 = r11.acquireToken(r6)
            if (r11 != r0) goto L5a
            return r0
        L5a:
            r1 = r8
            r4 = r3
            r3 = r9
        L5d:
            r5 = r11
            aws.smithy.kotlin.runtime.retries.delay.RetryToken r5 = (aws.smithy.kotlin.runtime.retries.delay.RetryToken) r5
            r9 = 0
            r6.L$0 = r9
            r6.L$1 = r9
            r6.L$2 = r9
            r6.label = r2
            r2 = r10
            java.lang.Object r11 = r1.doTryLoop(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L71
            return r0
        L71:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.retries.StandardRetryStrategy.retry(aws.smithy.kotlin.runtime.http.middleware.PolicyLogger, aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$result$outcome$1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <R> java.lang.Object success(aws.smithy.kotlin.runtime.retries.delay.RetryToken r5, int r6, java.lang.Object r7, kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.retries.Outcome<? extends R>> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$success$1
            if (r0 == 0) goto L13
            r0 = r8
            aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$success$1 r0 = (aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$success$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$success$1 r0 = new aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$success$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L43
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r7
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.notifySuccess(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            boolean r5 = r7 instanceof kotlin.Result.Failure
            if (r5 == 0) goto L49
            r5 = 0
            goto L4a
        L49:
            r5 = r7
        L4a:
            if (r5 != 0) goto L59
            aws.smithy.kotlin.runtime.retries.Outcome$Exception r5 = new aws.smithy.kotlin.runtime.retries.Outcome$Exception
            java.lang.Throwable r7 = kotlin.Result.m1661exceptionOrNullimpl(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r5.<init>(r6, r7)
            goto L5f
        L59:
            aws.smithy.kotlin.runtime.retries.Outcome$Response r7 = new aws.smithy.kotlin.runtime.retries.Outcome$Response
            r7.<init>(r6, r5)
            r5 = r7
        L5f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.retries.StandardRetryStrategy.success(aws.smithy.kotlin.runtime.retries.delay.RetryToken, int, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void throwTooManyAttempts(int r5, Object obj) {
        Object obj2;
        Throwable m1661exceptionOrNullimpl = Result.m1661exceptionOrNullimpl(obj);
        if (m1661exceptionOrNullimpl == null) {
            String str = "Took more than " + this.options.getMaxAttempts().intValue() + " to get a successful response";
            if (obj instanceof Result.Failure) {
                obj2 = null;
            } else {
                obj2 = obj;
            }
            Result.m1661exceptionOrNullimpl(obj);
            throw new TooManyAttemptsException(str, null, r5, obj2);
        }
        throw m1661exceptionOrNullimpl;
    }

    public StandardRetryStrategy(int r3) {
        StandardRetryStrategyOptions standardRetryStrategyOptions = StandardRetryStrategyOptions.Default;
        StandardRetryTokenBucket standardRetryTokenBucket = new StandardRetryTokenBucket(0);
        ExponentialBackoffWithJitter exponentialBackoffWithJitter = new ExponentialBackoffWithJitter();
        this.options = standardRetryStrategyOptions;
        this.tokenBucket = standardRetryTokenBucket;
        this.delayProvider = exponentialBackoffWithJitter;
    }
}
