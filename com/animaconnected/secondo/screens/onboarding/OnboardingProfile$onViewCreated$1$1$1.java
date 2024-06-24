package com.animaconnected.secondo.screens.onboarding;

import android.view.View;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: OnboardingProfile.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingProfile$onViewCreated$1$1$1", f = "OnboardingProfile.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingProfile$onViewCreated$1$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OnboardingProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingProfile$onViewCreated$1$1$1(OnboardingProfile onboardingProfile, Continuation<? super OnboardingProfile$onViewCreated$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = onboardingProfile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingProfile$onViewCreated$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((OnboardingProfile$onViewCreated$1$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Onboarding.setHandled$default(this.this$0.getOnboarding(), Onboarding.State.PROFILE_SETUP, false, 2, null);
            this.this$0.getOnboarding().updateState();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
