package com.airbnb.lottie.compose;

import androidx.compose.runtime.MutableState;
import com.airbnb.lottie.LottieComposition;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: animateLottieCompositionAsState.kt */
@DebugMetadata(c = "com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3", f = "animateLottieCompositionAsState.kt", l = {68, 73}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ float $actualSpeed;
    public final /* synthetic */ LottieAnimatable $animatable;
    public final /* synthetic */ LottieCancellationBehavior $cancellationBehavior;
    public final /* synthetic */ LottieClipSpec $clipSpec;
    public final /* synthetic */ LottieComposition $composition;
    public final /* synthetic */ boolean $isPlaying;
    public final /* synthetic */ int $iterations;
    public final /* synthetic */ boolean $restartOnPlay;
    public final /* synthetic */ MutableState<Boolean> $wasPlaying$delegate;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3(boolean z, boolean z2, LottieAnimatable lottieAnimatable, LottieComposition lottieComposition, int r5, float f, LottieClipSpec lottieClipSpec, LottieCancellationBehavior lottieCancellationBehavior, MutableState<Boolean> mutableState, Continuation<? super AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3> continuation) {
        super(2, continuation);
        this.$isPlaying = z;
        this.$restartOnPlay = z2;
        this.$animatable = lottieAnimatable;
        this.$composition = lottieComposition;
        this.$iterations = r5;
        this.$actualSpeed = f;
        this.$clipSpec = lottieClipSpec;
        this.$cancellationBehavior = lottieCancellationBehavior;
        this.$wasPlaying$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3(this.$isPlaying, this.$restartOnPlay, this.$animatable, this.$composition, this.$iterations, this.$actualSpeed, this.$clipSpec, this.$cancellationBehavior, this.$wasPlaying$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object animate;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        LottieAnimatable lottieAnimatable = this.$animatable;
        MutableState<Boolean> mutableState = this.$wasPlaying$delegate;
        boolean z = this.$isPlaying;
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
            if (z && !mutableState.getValue().booleanValue() && this.$restartOnPlay) {
                this.label = 1;
                if (LottieAnimatableKt.resetToBeginning(lottieAnimatable, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        mutableState.setValue(Boolean.valueOf(z));
        if (!z) {
            return Unit.INSTANCE;
        }
        LottieComposition lottieComposition = this.$composition;
        int r11 = this.$iterations;
        float f = this.$actualSpeed;
        LottieClipSpec lottieClipSpec = this.$clipSpec;
        float progress = lottieAnimatable.getProgress();
        LottieCancellationBehavior lottieCancellationBehavior = this.$cancellationBehavior;
        this.label = 2;
        animate = lottieAnimatable.animate(lottieComposition, lottieAnimatable.getIteration(), r11, f, lottieClipSpec, progress, false, lottieCancellationBehavior, this);
        if (animate == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }
}
