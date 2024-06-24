package com.animaconnected.secondo.screens.tipsandtricks;

import androidx.compose.runtime.MutableState;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimatable;
import com.airbnb.lottie.compose.LottieAnimatableKt;
import com.airbnb.lottie.compose.LottieCancellationBehavior;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TipsAndTricksPascalFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$animateLottieResetOnStop$1", f = "TipsAndTricksPascalFragment.kt", l = {197, 202}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class TipsAndTricksPascalFragment$animateLottieResetOnStop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LottieAnimatable $animatable;
    final /* synthetic */ LottieComposition $composition;
    final /* synthetic */ boolean $isPlaying;
    final /* synthetic */ MutableState<Boolean> $wasPlaying$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TipsAndTricksPascalFragment$animateLottieResetOnStop$1(boolean z, LottieAnimatable lottieAnimatable, LottieComposition lottieComposition, MutableState<Boolean> mutableState, Continuation<? super TipsAndTricksPascalFragment$animateLottieResetOnStop$1> continuation) {
        super(2, continuation);
        this.$isPlaying = z;
        this.$animatable = lottieAnimatable;
        this.$composition = lottieComposition;
        this.$wasPlaying$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TipsAndTricksPascalFragment$animateLottieResetOnStop$1(this.$isPlaying, this.$animatable, this.$composition, this.$wasPlaying$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean animateLottieResetOnStop$lambda$11;
        Object animate;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            if (!this.$isPlaying) {
                animateLottieResetOnStop$lambda$11 = TipsAndTricksPascalFragment.animateLottieResetOnStop$lambda$11(this.$wasPlaying$delegate);
                if (animateLottieResetOnStop$lambda$11) {
                    LottieAnimatable lottieAnimatable = this.$animatable;
                    this.label = 1;
                    if (LottieAnimatableKt.resetToBeginning(lottieAnimatable, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
        }
        TipsAndTricksPascalFragment.animateLottieResetOnStop$lambda$12(this.$wasPlaying$delegate, this.$isPlaying);
        if (!this.$isPlaying) {
            return Unit.INSTANCE;
        }
        LottieAnimatable lottieAnimatable2 = this.$animatable;
        LottieComposition lottieComposition = this.$composition;
        float progress = lottieAnimatable2.getProgress();
        LottieCancellationBehavior lottieCancellationBehavior = LottieCancellationBehavior.Immediately;
        this.label = 2;
        animate = lottieAnimatable2.animate(lottieComposition, lottieAnimatable2.getIteration(), Integer.MAX_VALUE, 1.0f, null, progress, false, lottieCancellationBehavior, this);
        if (animate == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TipsAndTricksPascalFragment$animateLottieResetOnStop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
