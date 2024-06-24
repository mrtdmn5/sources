package com.animaconnected.secondo.screens.onboarding;

import android.view.View;
import com.animaconnected.watch.account.profile.ProfileViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: OnboardingProfile.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingProfile$onCreateView$1$6", f = "OnboardingProfile.kt", l = {82}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingProfile$onCreateView$1$6 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OnboardingProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingProfile$onCreateView$1$6(OnboardingProfile onboardingProfile, Continuation<? super OnboardingProfile$onCreateView$1$6> continuation) {
        super(2, continuation);
        this.this$0 = onboardingProfile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingProfile$onCreateView$1$6(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((OnboardingProfile$onCreateView$1$6) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ProfileViewModel profileViewModel;
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
            profileViewModel = this.this$0.getProfileViewModel();
            this.label = 1;
            if (profileViewModel.setMeasurementUnit(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
