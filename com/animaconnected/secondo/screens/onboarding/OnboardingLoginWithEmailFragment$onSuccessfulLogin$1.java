package com.animaconnected.secondo.screens.onboarding;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: OnboardingLoginWithEmailFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment", f = "OnboardingLoginWithEmailFragment.kt", l = {92}, m = "onSuccessfulLogin")
/* loaded from: classes3.dex */
public final class OnboardingLoginWithEmailFragment$onSuccessfulLogin$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnboardingLoginWithEmailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingLoginWithEmailFragment$onSuccessfulLogin$1(OnboardingLoginWithEmailFragment onboardingLoginWithEmailFragment, Continuation<? super OnboardingLoginWithEmailFragment$onSuccessfulLogin$1> continuation) {
        super(continuation);
        this.this$0 = onboardingLoginWithEmailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object onSuccessfulLogin;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        onSuccessfulLogin = this.this$0.onSuccessfulLogin(this);
        return onSuccessfulLogin;
    }
}
