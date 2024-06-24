package com.airbnb.lottie.compose;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.airbnb.lottie.LottieComposition;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;

/* compiled from: LottieAnimatable.kt */
@DebugMetadata(c = "com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2", f = "LottieAnimatable.kt", l = {241}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LottieAnimatableImpl$animate$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public final /* synthetic */ LottieCancellationBehavior $cancellationBehavior;
    public final /* synthetic */ LottieClipSpec $clipSpec;
    public final /* synthetic */ LottieComposition $composition;
    public final /* synthetic */ boolean $continueFromPreviousAnimate;
    public final /* synthetic */ float $initialProgress;
    public final /* synthetic */ int $iteration;
    public final /* synthetic */ int $iterations;
    public final /* synthetic */ float $speed;
    public int label;
    public final /* synthetic */ LottieAnimatableImpl this$0;

    /* compiled from: LottieAnimatable.kt */
    @DebugMetadata(c = "com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1", f = "LottieAnimatable.kt", l = {249}, m = "invokeSuspend")
    /* renamed from: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ LottieCancellationBehavior $cancellationBehavior;
        public final /* synthetic */ int $iteration;
        public final /* synthetic */ int $iterations;
        public final /* synthetic */ Job $parentJob;
        public int label;
        public final /* synthetic */ LottieAnimatableImpl this$0;

        /* compiled from: LottieAnimatable.kt */
        /* renamed from: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1$WhenMappings */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[LottieCancellationBehavior.values().length];
                r0[LottieCancellationBehavior.OnIterationFinish.ordinal()] = 1;
                $EnumSwitchMapping$0 = r0;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LottieCancellationBehavior lottieCancellationBehavior, Job job, int r3, int r4, LottieAnimatableImpl lottieAnimatableImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$cancellationBehavior = lottieCancellationBehavior;
            this.$parentJob = job;
            this.$iterations = r3;
            this.$iteration = r4;
            this.this$0 = lottieAnimatableImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$cancellationBehavior, this.$parentJob, this.$iterations, this.$iteration, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0063  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0057 -> B:5:0x005b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r7)
                r1 = r0
                r0 = r6
                goto L5b
            Lf:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L17:
                kotlin.ResultKt.throwOnFailure(r7)
                r7 = r6
            L1b:
                int[] r1 = com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2.AnonymousClass1.WhenMappings.$EnumSwitchMapping$0
                com.airbnb.lottie.compose.LottieCancellationBehavior r3 = r7.$cancellationBehavior
                int r3 = r3.ordinal()
                r1 = r1[r3]
                if (r1 != r2) goto L33
                kotlinx.coroutines.Job r1 = r7.$parentJob
                boolean r1 = r1.isActive()
                if (r1 == 0) goto L30
                goto L33
            L30:
                int r1 = r7.$iteration
                goto L35
            L33:
                int r1 = r7.$iterations
            L35:
                r7.label = r2
                com.airbnb.lottie.compose.LottieAnimatableImpl r3 = r7.this$0
                r3.getClass()
                r4 = 2147483647(0x7fffffff, float:NaN)
                if (r1 != r4) goto L4b
                com.airbnb.lottie.compose.LottieAnimatableImpl$doFrame$2 r4 = new com.airbnb.lottie.compose.LottieAnimatableImpl$doFrame$2
                r4.<init>()
                java.lang.Object r1 = androidx.compose.animation.core.InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(r4, r7)
                goto L54
            L4b:
                com.airbnb.lottie.compose.LottieAnimatableImpl$doFrame$3 r4 = new com.airbnb.lottie.compose.LottieAnimatableImpl$doFrame$3
                r4.<init>()
                java.lang.Object r1 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r4, r7)
            L54:
                if (r1 != r0) goto L57
                return r0
            L57:
                r5 = r0
                r0 = r7
                r7 = r1
                r1 = r5
            L5b:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 != 0) goto L66
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            L66:
                r7 = r0
                r0 = r1
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: LottieAnimatable.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[LottieCancellationBehavior.values().length];
            r0[LottieCancellationBehavior.OnIterationFinish.ordinal()] = 1;
            r0[LottieCancellationBehavior.Immediately.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieAnimatableImpl$animate$2(LottieAnimatableImpl lottieAnimatableImpl, int r2, int r3, float f, LottieClipSpec lottieClipSpec, LottieComposition lottieComposition, float f2, boolean z, LottieCancellationBehavior lottieCancellationBehavior, Continuation<? super LottieAnimatableImpl$animate$2> continuation) {
        super(1, continuation);
        this.this$0 = lottieAnimatableImpl;
        this.$iteration = r2;
        this.$iterations = r3;
        this.$speed = f;
        this.$clipSpec = lottieClipSpec;
        this.$composition = lottieComposition;
        this.$initialProgress = f2;
        this.$continueFromPreviousAnimate = z;
        this.$cancellationBehavior = lottieCancellationBehavior;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new LottieAnimatableImpl$animate$2(this.this$0, this.$iteration, this.$iterations, this.$speed, this.$clipSpec, this.$composition, this.$initialProgress, this.$continueFromPreviousAnimate, this.$cancellationBehavior, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((LottieAnimatableImpl$animate$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Finally extract failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineContext coroutineContext;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        LottieAnimatableImpl lottieAnimatableImpl = this.this$0;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                lottieAnimatableImpl.setIteration(this.$iteration);
                int r13 = this.$iterations;
                lottieAnimatableImpl.iterations$delegate.setValue(Integer.valueOf(r13));
                float f = this.$speed;
                lottieAnimatableImpl.speed$delegate.setValue(Float.valueOf(f));
                lottieAnimatableImpl.clipSpec$delegate.setValue(this.$clipSpec);
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = lottieAnimatableImpl.composition$delegate;
                LottieComposition lottieComposition = this.$composition;
                parcelableSnapshotMutableState.setValue(lottieComposition);
                lottieAnimatableImpl.setProgress(this.$initialProgress);
                if (!this.$continueFromPreviousAnimate) {
                    lottieAnimatableImpl.lastFrameNanos$delegate.setValue(Long.MIN_VALUE);
                }
                if (lottieComposition == null) {
                    lottieAnimatableImpl.isPlaying$delegate.setValue(Boolean.valueOf(false));
                    return Unit.INSTANCE;
                }
                if (!Float.isInfinite(f)) {
                    lottieAnimatableImpl.isPlaying$delegate.setValue(Boolean.valueOf(true));
                    int r132 = WhenMappings.$EnumSwitchMapping$0[this.$cancellationBehavior.ordinal()];
                    if (r132 != 1) {
                        if (r132 == 2) {
                            coroutineContext = EmptyCoroutineContext.INSTANCE;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        coroutineContext = NonCancellable.INSTANCE;
                    }
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$cancellationBehavior, JobKt.getJob(getContext()), this.$iterations, this.$iteration, this.this$0, null);
                    this.label = 1;
                    if (BuildersKt.withContext(coroutineContext, anonymousClass1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    lottieAnimatableImpl.setProgress(lottieAnimatableImpl.getEndProgress());
                    lottieAnimatableImpl.isPlaying$delegate.setValue(Boolean.valueOf(false));
                    lottieAnimatableImpl.setIteration(r13);
                    return Unit.INSTANCE;
                }
            }
            JobKt.ensureActive(getContext());
            lottieAnimatableImpl.isPlaying$delegate.setValue(Boolean.valueOf(false));
            return Unit.INSTANCE;
        } catch (Throwable th) {
            lottieAnimatableImpl.isPlaying$delegate.setValue(Boolean.valueOf(false));
            throw th;
        }
    }
}
