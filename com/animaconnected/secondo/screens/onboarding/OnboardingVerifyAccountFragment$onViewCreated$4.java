package com.animaconnected.secondo.screens.onboarding;

import androidx.fragment.app.FragmentActivity;
import com.animaconnected.secondo.provider.login.LoginState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingVerifyAccountFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$4", f = "OnboardingVerifyAccountFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingVerifyAccountFragment$onViewCreated$4 extends SuspendLambda implements Function2<LoginState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OnboardingVerifyAccountFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingVerifyAccountFragment$onViewCreated$4(OnboardingVerifyAccountFragment onboardingVerifyAccountFragment, Continuation<? super OnboardingVerifyAccountFragment$onViewCreated$4> continuation) {
        super(2, continuation);
        this.this$0 = onboardingVerifyAccountFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OnboardingVerifyAccountFragment$onViewCreated$4 onboardingVerifyAccountFragment$onViewCreated$4 = new OnboardingVerifyAccountFragment$onViewCreated$4(this.this$0, continuation);
        onboardingVerifyAccountFragment$onViewCreated$4.L$0 = obj;
        return onboardingVerifyAccountFragment$onViewCreated$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LoginState loginState, Continuation<? super Unit> continuation) {
        return ((OnboardingVerifyAccountFragment$onViewCreated$4) create(loginState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FragmentActivity activity;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LoginState loginState = (LoginState) this.L$0;
            if (Intrinsics.areEqual(loginState, LoginState.SignedIn.INSTANCE)) {
                this.this$0.goToPairingScreen();
            } else if (Intrinsics.areEqual(loginState, LoginState.Idle.INSTANCE) && (activity = this.this$0.getActivity()) != null) {
                activity.onBackPressed();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
