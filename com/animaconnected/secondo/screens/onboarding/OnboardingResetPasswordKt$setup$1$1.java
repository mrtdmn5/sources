package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.secondo.databinding.FragmentOnboardingResetPasswordBinding;
import com.animaconnected.secondo.screens.settings.FormUiState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: OnboardingResetPassword.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordKt$setup$1$1", f = "OnboardingResetPassword.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingResetPasswordKt$setup$1$1 extends SuspendLambda implements Function2<FormUiState, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentOnboardingResetPasswordBinding $binding;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingResetPasswordKt$setup$1$1(FragmentOnboardingResetPasswordBinding fragmentOnboardingResetPasswordBinding, Continuation<? super OnboardingResetPasswordKt$setup$1$1> continuation) {
        super(2, continuation);
        this.$binding = fragmentOnboardingResetPasswordBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OnboardingResetPasswordKt$setup$1$1 onboardingResetPasswordKt$setup$1$1 = new OnboardingResetPasswordKt$setup$1$1(this.$binding, continuation);
        onboardingResetPasswordKt$setup$1$1.L$0 = obj;
        return onboardingResetPasswordKt$setup$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FormUiState formUiState, Continuation<? super Unit> continuation) {
        return ((OnboardingResetPasswordKt$setup$1$1) create(formUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$binding.btnSave.setEnabled(((FormUiState) this.L$0).isPasswordValid());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
