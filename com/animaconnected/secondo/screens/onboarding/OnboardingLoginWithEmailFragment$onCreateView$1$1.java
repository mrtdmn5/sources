package com.animaconnected.secondo.screens.onboarding;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: OnboardingLoginWithEmailFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onCreateView$1$1", f = "OnboardingLoginWithEmailFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingLoginWithEmailFragment$onCreateView$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OnboardingLoginWithEmailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingLoginWithEmailFragment$onCreateView$1$1(OnboardingLoginWithEmailFragment onboardingLoginWithEmailFragment, Continuation<? super OnboardingLoginWithEmailFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = onboardingLoginWithEmailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingLoginWithEmailFragment$onCreateView$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((OnboardingLoginWithEmailFragment$onCreateView$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getOnboardingViewController().gotoNextFragment(OnboardingResetPasswordSendCode.Companion.newInstance(), true);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
