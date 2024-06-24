package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.watch.account.profile.ProfileState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: OnboardingProfile.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingProfile$onViewCreated$2", f = "OnboardingProfile.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingProfile$onViewCreated$2 extends SuspendLambda implements Function2<ProfileState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OnboardingProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingProfile$onViewCreated$2(OnboardingProfile onboardingProfile, Continuation<? super OnboardingProfile$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = onboardingProfile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OnboardingProfile$onViewCreated$2 onboardingProfile$onViewCreated$2 = new OnboardingProfile$onViewCreated$2(this.this$0, continuation);
        onboardingProfile$onViewCreated$2.L$0 = obj;
        return onboardingProfile$onViewCreated$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProfileState profileState, Continuation<? super Unit> continuation) {
        return ((OnboardingProfile$onViewCreated$2) create(profileState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.renderProfileState((ProfileState) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
