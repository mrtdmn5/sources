package com.animaconnected.secondo.screens.onboarding;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.provider.lottie.LottieKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ResetWatchDialogFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.ResetWatchDialogFragment$onCreateDialogView$1$1", f = "ResetWatchDialogFragment.kt", l = {23}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ResetWatchDialogFragment$onCreateDialogView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LottieAnimationView $lottieAnimationView;
    final /* synthetic */ ProgressBar $setupProgressBar;
    final /* synthetic */ View $this_apply;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetWatchDialogFragment$onCreateDialogView$1$1(View view, ProgressBar progressBar, LottieAnimationView lottieAnimationView, Continuation<? super ResetWatchDialogFragment$onCreateDialogView$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = view;
        this.$setupProgressBar = progressBar;
        this.$lottieAnimationView = lottieAnimationView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResetWatchDialogFragment$onCreateDialogView$1$1(this.$this_apply, this.$setupProgressBar, this.$lottieAnimationView, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Context context = this.$this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            LottieFile lottieFile = LottieFile.OnboardingResetwatch;
            this.label = 1;
            obj = LottieKt.loadLottieAnimation(context, lottieFile, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        LottieComposition lottieComposition = (LottieComposition) obj;
        if (lottieComposition != null) {
            this.$lottieAnimationView.setComposition(lottieComposition);
        }
        this.$setupProgressBar.setVisibility(4);
        this.$lottieAnimationView.setVisibility(0);
        this.$lottieAnimationView.setRepeatCount(-1);
        this.$lottieAnimationView.playAnimation();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ResetWatchDialogFragment$onCreateDialogView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
