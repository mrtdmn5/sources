package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$success$1;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.time.Duration;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: StandardRetryTokenBucket.kt */
/* loaded from: classes.dex */
public final class StandardRetryTokenBucket implements RetryTokenBucket {
    public int capacity;
    public TimeMark lastTimeMark;
    public final MutexImpl mutex;
    public final StandardRetryTokenBucketOptions options;
    public final TimeSource timeSource;

    /* compiled from: StandardRetryTokenBucket.kt */
    /* loaded from: classes.dex */
    public final class StandardRetryToken implements RetryToken {
        public final int returnSize;

        /* compiled from: StandardRetryTokenBucket.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[RetryErrorType.values().length];
                try {
                    r0[RetryErrorType.Timeout.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[RetryErrorType.Throttling.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = r0;
            }
        }

        public StandardRetryToken(int r2) {
            this.returnSize = r2;
        }

        @Override // aws.smithy.kotlin.runtime.retries.delay.RetryToken
        public final Unit notifyFailure() {
            return Unit.INSTANCE;
        }

        @Override // aws.smithy.kotlin.runtime.retries.delay.RetryToken
        public final Object notifySuccess(StandardRetryStrategy$success$1 standardRetryStrategy$success$1) {
            Object access$returnCapacity = StandardRetryTokenBucket.access$returnCapacity(StandardRetryTokenBucket.this, this.returnSize, standardRetryStrategy$success$1);
            if (access$returnCapacity == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return access$returnCapacity;
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        @Override // aws.smithy.kotlin.runtime.retries.delay.RetryToken
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object scheduleRetry(aws.smithy.kotlin.runtime.retries.policy.RetryErrorType r5, kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.retries.delay.RetryToken> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1
                if (r0 == 0) goto L13
                r0 = r6
                aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1 r0 = (aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1 r0 = new aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L33
                if (r2 != r3) goto L2b
                int r5 = r0.I$0
                aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken r0 = r0.L$0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L5c
            L2b:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L33:
                kotlin.ResultKt.throwOnFailure(r6)
                int[] r6 = aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket.StandardRetryToken.WhenMappings.$EnumSwitchMapping$0
                int r5 = r5.ordinal()
                r5 = r6[r5]
                aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket r6 = aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket.this
                if (r5 == r3) goto L4a
                r2 = 2
                if (r5 == r2) goto L4a
                aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucketOptions r5 = r6.options
                int r5 = r5.retryCost
                goto L4e
            L4a:
                aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucketOptions r5 = r6.options
                int r5 = r5.timeoutRetryCost
            L4e:
                r0.L$0 = r4
                r0.I$0 = r5
                r0.label = r3
                java.lang.Object r6 = r6.checkoutCapacity(r5, r0)
                if (r6 != r1) goto L5b
                return r1
            L5b:
                r0 = r4
            L5c:
                aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken r6 = new aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken
                aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket r0 = aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket.this
                r6.<init>(r5)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket.StandardRetryToken.scheduleRetry(aws.smithy.kotlin.runtime.retries.policy.RetryErrorType, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public StandardRetryTokenBucket(int r2) {
        StandardRetryTokenBucketOptions standardRetryTokenBucketOptions = StandardRetryTokenBucketOptions.Default;
        TimeSource.Monotonic monotonic = TimeSource.Monotonic.INSTANCE;
        this.options = standardRetryTokenBucketOptions;
        this.timeSource = monotonic;
        this.capacity = 500;
        this.lastTimeMark = monotonic.markNow();
        this.mutex = MutexKt.Mutex$default();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$returnCapacity(aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            r5.getClass()
            boolean r0 = r7 instanceof aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$returnCapacity$1
            if (r0 == 0) goto L16
            r0 = r7
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$returnCapacity$1 r0 = (aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$returnCapacity$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$returnCapacity$1 r0 = new aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$returnCapacity$1
            r0.<init>(r5, r7)
        L1b:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            int r6 = r0.I$0
            kotlinx.coroutines.sync.MutexImpl r5 = r0.L$1
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r5
            r5 = r0
            goto L4f
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            kotlinx.coroutines.sync.MutexImpl r7 = r5.mutex
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r0 = r7.lock(r3, r0)
            if (r0 != r1) goto L4f
            goto L6e
        L4f:
            r5.refillCapacity()     // Catch: java.lang.Throwable -> L6f
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucketOptions r0 = r5.options     // Catch: java.lang.Throwable -> L6f
            int r0 = r0.maxCapacity     // Catch: java.lang.Throwable -> L6f
            int r1 = r5.capacity     // Catch: java.lang.Throwable -> L6f
            int r1 = r1 + r6
            int r6 = java.lang.Math.min(r0, r1)     // Catch: java.lang.Throwable -> L6f
            r5.capacity = r6     // Catch: java.lang.Throwable -> L6f
            kotlin.time.TimeSource r6 = r5.timeSource     // Catch: java.lang.Throwable -> L6f
            kotlin.time.TimeSource$Monotonic$ValueTimeMark r6 = r6.markNow()     // Catch: java.lang.Throwable -> L6f
            r5.lastTimeMark = r6     // Catch: java.lang.Throwable -> L6f
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L6f
            r7.unlock(r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L6e:
            return r1
        L6f:
            r5 = move-exception
            r7.unlock(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket.access$returnCapacity(aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object acquireToken(kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.retries.delay.RetryToken> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$acquireToken$1
            if (r0 == 0) goto L13
            r0 = r5
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$acquireToken$1 r0 = (aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$acquireToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$acquireToken$1 r0 = new aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$acquireToken$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucketOptions r5 = r4.options
            int r5 = r5.initialTryCost
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.checkoutCapacity(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            r0 = r4
        L44:
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken r5 = new aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucketOptions r1 = r0.options
            int r1 = r1.initialTrySuccessIncrement
            r5.<init>(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket.acquireToken(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0060 A[Catch: all -> 0x00a5, TryCatch #0 {all -> 0x00a5, blocks: (B:28:0x0059, B:30:0x0060, B:31:0x0065, B:33:0x006b, B:37:0x009f, B:38:0x00a4), top: B:27:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0065 A[Catch: all -> 0x00a5, TryCatch #0 {all -> 0x00a5, blocks: (B:28:0x0059, B:30:0x0060, B:31:0x0065, B:33:0x006b, B:37:0x009f, B:38:0x00a4), top: B:27:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkoutCapacity(int r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$checkoutCapacity$1
            if (r0 == 0) goto L13
            r0 = r10
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$checkoutCapacity$1 r0 = (aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$checkoutCapacity$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$checkoutCapacity$1 r0 = new aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$checkoutCapacity$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            kotlinx.coroutines.sync.Mutex r9 = r0.L$1
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L2f
            goto L89
        L2f:
            r10 = move-exception
            goto L9d
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            int r9 = r0.I$0
            kotlinx.coroutines.sync.Mutex r2 = r0.L$1
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket r4 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L59
        L44:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r8
            kotlinx.coroutines.sync.MutexImpl r2 = r8.mutex
            r0.L$1 = r2
            r0.I$0 = r9
            r0.label = r4
            java.lang.Object r10 = r2.lock(r5, r0)
            if (r10 != r1) goto L58
            return r1
        L58:
            r4 = r8
        L59:
            r4.refillCapacity()     // Catch: java.lang.Throwable -> La5
            int r10 = r4.capacity     // Catch: java.lang.Throwable -> La5
            if (r9 > r10) goto L65
            int r10 = r10 - r9
            r4.capacity = r10     // Catch: java.lang.Throwable -> La5
            r9 = r2
            goto L8d
        L65:
            aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucketOptions r6 = r4.options     // Catch: java.lang.Throwable -> La5
            boolean r7 = r6.circuitBreakerMode     // Catch: java.lang.Throwable -> La5
            if (r7 != 0) goto L9f
            int r9 = r9 - r10
            double r9 = (double) r9     // Catch: java.lang.Throwable -> La5
            int r6 = r6.refillUnitsPerSecond     // Catch: java.lang.Throwable -> La5
            double r6 = (double) r6     // Catch: java.lang.Throwable -> La5
            double r9 = r9 / r6
            r6 = 1000(0x3e8, float:1.401E-42)
            double r6 = (double) r6     // Catch: java.lang.Throwable -> La5
            double r9 = r9 * r6
            double r9 = java.lang.Math.ceil(r9)     // Catch: java.lang.Throwable -> La5
            long r9 = (long) r9     // Catch: java.lang.Throwable -> La5
            r0.L$0 = r4     // Catch: java.lang.Throwable -> La5
            r0.L$1 = r2     // Catch: java.lang.Throwable -> La5
            r0.label = r3     // Catch: java.lang.Throwable -> La5
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r9, r0)     // Catch: java.lang.Throwable -> La5
            if (r9 != r1) goto L87
            return r1
        L87:
            r9 = r2
            r0 = r4
        L89:
            r10 = 0
            r0.capacity = r10     // Catch: java.lang.Throwable -> L2f
            r4 = r0
        L8d:
            kotlin.time.TimeSource r10 = r4.timeSource     // Catch: java.lang.Throwable -> L2f
            kotlin.time.TimeSource$Monotonic$ValueTimeMark r10 = r10.markNow()     // Catch: java.lang.Throwable -> L2f
            r4.lastTimeMark = r10     // Catch: java.lang.Throwable -> L2f
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L2f
            r9.unlock(r5)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L9d:
            r2 = r9
            goto La7
        L9f:
            aws.smithy.kotlin.runtime.retries.delay.RetryCapacityExceededException r9 = new aws.smithy.kotlin.runtime.retries.delay.RetryCapacityExceededException     // Catch: java.lang.Throwable -> La5
            r9.<init>()     // Catch: java.lang.Throwable -> La5
            throw r9     // Catch: java.lang.Throwable -> La5
        La5:
            r9 = move-exception
            r10 = r9
        La7:
            r2.unlock(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket.checkoutCapacity(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void refillCapacity() {
        long m1677getInWholeMillisecondsimpl = Duration.m1677getInWholeMillisecondsimpl(this.lastTimeMark.mo1692elapsedNowUwyO8pc());
        this.capacity = Math.min(this.options.maxCapacity, this.capacity + ((int) Math.floor((r2.refillUnitsPerSecond / 1000) * m1677getInWholeMillisecondsimpl)));
    }
}
