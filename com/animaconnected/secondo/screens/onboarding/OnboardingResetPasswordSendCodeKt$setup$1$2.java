package com.animaconnected.secondo.screens.onboarding;

import android.view.View;
import com.animaconnected.secondo.databinding.FragmentOnboardingResetPasswordSendCodeBinding;
import com.animaconnected.secondo.screens.settings.PasswordManagementViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: OnboardingResetPasswordSendCode.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordSendCodeKt$setup$1$2", f = "OnboardingResetPasswordSendCode.kt", l = {110}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingResetPasswordSendCodeKt$setup$1$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref$ObjectRef<String> $email;
    final /* synthetic */ PasswordManagementViewModel $passwordViewModel;
    final /* synthetic */ FragmentOnboardingResetPasswordSendCodeBinding $this_apply;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingResetPasswordSendCodeKt$setup$1$2(Ref$ObjectRef<String> ref$ObjectRef, FragmentOnboardingResetPasswordSendCodeBinding fragmentOnboardingResetPasswordSendCodeBinding, PasswordManagementViewModel passwordManagementViewModel, Continuation<? super OnboardingResetPasswordSendCodeKt$setup$1$2> continuation) {
        super(2, continuation);
        this.$email = ref$ObjectRef;
        this.$this_apply = fragmentOnboardingResetPasswordSendCodeBinding;
        this.$passwordViewModel = passwordManagementViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingResetPasswordSendCodeKt$setup$1$2(this.$email, this.$this_apply, this.$passwordViewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((OnboardingResetPasswordSendCodeKt$setup$1$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.String] */
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
            this.$email.element = String.valueOf(this.$this_apply.layoutEmail.editText.getText());
            PasswordManagementViewModel passwordManagementViewModel = this.$passwordViewModel;
            String str = this.$email.element;
            this.label = 1;
            if (passwordManagementViewModel.sendConfirmationCode(str, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
