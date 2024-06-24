package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieComposition;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: LottieAnimatable.kt */
@DebugMetadata(c = "com.airbnb.lottie.compose.LottieAnimatableImpl$snapTo$2", f = "LottieAnimatable.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LottieAnimatableImpl$snapTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public final /* synthetic */ LottieComposition $composition;
    public final /* synthetic */ int $iteration;
    public final /* synthetic */ float $progress;
    public final /* synthetic */ boolean $resetLastFrameNanos;
    public final /* synthetic */ LottieAnimatableImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieAnimatableImpl$snapTo$2(LottieAnimatableImpl lottieAnimatableImpl, LottieComposition lottieComposition, float f, int r4, boolean z, Continuation<? super LottieAnimatableImpl$snapTo$2> continuation) {
        super(1, continuation);
        this.this$0 = lottieAnimatableImpl;
        this.$composition = lottieComposition;
        this.$progress = f;
        this.$iteration = r4;
        this.$resetLastFrameNanos = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new LottieAnimatableImpl$snapTo$2(this.this$0, this.$composition, this.$progress, this.$iteration, this.$resetLastFrameNanos, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((LottieAnimatableImpl$snapTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        LottieAnimatableImpl lottieAnimatableImpl = this.this$0;
        lottieAnimatableImpl.composition$delegate.setValue(this.$composition);
        lottieAnimatableImpl.setProgress(this.$progress);
        lottieAnimatableImpl.setIteration(this.$iteration);
        lottieAnimatableImpl.isPlaying$delegate.setValue(Boolean.valueOf(false));
        if (this.$resetLastFrameNanos) {
            lottieAnimatableImpl.lastFrameNanos$delegate.setValue(Long.MIN_VALUE);
        }
        return Unit.INSTANCE;
    }
}
