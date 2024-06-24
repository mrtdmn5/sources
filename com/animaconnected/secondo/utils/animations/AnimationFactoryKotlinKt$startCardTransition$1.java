package com.animaconnected.secondo.utils.animations;

import android.view.View;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.screens.BaseFragment;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: AnimationFactoryKotlin.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt$startCardTransition$1", f = "AnimationFactoryKotlin.kt", l = {123, R.styleable.AppTheme_statusTopStripeImportant}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AnimationFactoryKotlinKt$startCardTransition$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $contentView;
    final /* synthetic */ BaseFragment $destination;
    final /* synthetic */ BaseFragment $this_startCardTransition;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimationFactoryKotlinKt$startCardTransition$1(View view, BaseFragment baseFragment, BaseFragment baseFragment2, Continuation<? super AnimationFactoryKotlinKt$startCardTransition$1> continuation) {
        super(2, continuation);
        this.$contentView = view;
        this.$this_startCardTransition = baseFragment;
        this.$destination = baseFragment2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnimationFactoryKotlinKt$startCardTransition$1(this.$contentView, this.$this_startCardTransition, this.$destination, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    AnimationFactoryKotlinKt.isTransitionRunning = false;
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            AnimationFactoryKotlinKt.isTransitionRunning = true;
            AnimatorsKt.fadeOutAnimator$default(this.$contentView, 150L, null, 2, null).start();
            this.label = 1;
            if (DelayKt.delay(75L, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        this.$this_startCardTransition.getMainController().gotoRevealedFragment(this.$destination);
        this.label = 2;
        if (DelayKt.delay(500L, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        AnimationFactoryKotlinKt.isTransitionRunning = false;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnimationFactoryKotlinKt$startCardTransition$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
