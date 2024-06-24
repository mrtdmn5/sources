package com.animaconnected.secondo.screens.onboarding;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: OnboardingLoginFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment", f = "OnboardingLoginFragment.kt", l = {87}, m = "onNotNowClick")
/* loaded from: classes3.dex */
public final class OnboardingLoginFragment$onNotNowClick$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnboardingLoginFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingLoginFragment$onNotNowClick$1(OnboardingLoginFragment onboardingLoginFragment, Continuation<? super OnboardingLoginFragment$onNotNowClick$1> continuation) {
        super(continuation);
        this.this$0 = onboardingLoginFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object onNotNowClick;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        onNotNowClick = this.this$0.onNotNowClick(this);
        return onNotNowClick;
    }
}
