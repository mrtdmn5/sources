package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.secondo.provider.login.LoginState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingCreateAccountFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingCreateAccountFragment$onViewCreated$2", f = "OnboardingCreateAccountFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingCreateAccountFragment$onViewCreated$2 extends SuspendLambda implements Function2<LoginState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OnboardingCreateAccountFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingCreateAccountFragment$onViewCreated$2(OnboardingCreateAccountFragment onboardingCreateAccountFragment, Continuation<? super OnboardingCreateAccountFragment$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = onboardingCreateAccountFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OnboardingCreateAccountFragment$onViewCreated$2 onboardingCreateAccountFragment$onViewCreated$2 = new OnboardingCreateAccountFragment$onViewCreated$2(this.this$0, continuation);
        onboardingCreateAccountFragment$onViewCreated$2.L$0 = obj;
        return onboardingCreateAccountFragment$onViewCreated$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LoginState loginState, Continuation<? super Unit> continuation) {
        return ((OnboardingCreateAccountFragment$onViewCreated$2) create(loginState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LoginState loginState = (LoginState) this.L$0;
            boolean z = true;
            if (Intrinsics.areEqual(loginState, LoginState.ConfirmSignUp.INSTANCE)) {
                this.this$0.getOnboardingViewController().gotoNextFragment(OnboardingVerifyAccountFragment.Companion.newInstance(), true);
            } else {
                if (!Intrinsics.areEqual(loginState, LoginState.Idle.INSTANCE)) {
                    z = Intrinsics.areEqual(loginState, LoginState.Uninitialized.INSTANCE);
                }
                if (!z && Intrinsics.areEqual(loginState, LoginState.SignedIn.INSTANCE)) {
                    this.this$0.onSuccessfulLogin();
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
