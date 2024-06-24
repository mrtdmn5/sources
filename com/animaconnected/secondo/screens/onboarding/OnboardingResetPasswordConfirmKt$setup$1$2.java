package com.animaconnected.secondo.screens.onboarding;

import android.view.View;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.screens.settings.FormValidationViewModel;
import com.animaconnected.secondo.screens.settings.PasswordManagementViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: OnboardingResetPasswordConfirm.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$setup$1$2", f = "OnboardingResetPasswordConfirm.kt", l = {R.styleable.AppTheme_tabTextColor}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingResetPasswordConfirmKt$setup$1$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $email;
    final /* synthetic */ FormValidationViewModel $formValidationViewModel;
    final /* synthetic */ String $newPassword;
    final /* synthetic */ PasswordManagementViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingResetPasswordConfirmKt$setup$1$2(PasswordManagementViewModel passwordManagementViewModel, String str, String str2, FormValidationViewModel formValidationViewModel, Continuation<? super OnboardingResetPasswordConfirmKt$setup$1$2> continuation) {
        super(2, continuation);
        this.$viewModel = passwordManagementViewModel;
        this.$email = str;
        this.$newPassword = str2;
        this.$formValidationViewModel = formValidationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingResetPasswordConfirmKt$setup$1$2(this.$viewModel, this.$email, this.$newPassword, this.$formValidationViewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((OnboardingResetPasswordConfirmKt$setup$1$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

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
            PasswordManagementViewModel passwordManagementViewModel = this.$viewModel;
            String str = this.$email;
            String str2 = this.$newPassword;
            String confirmationCode = this.$formValidationViewModel.getConfirmationCode();
            this.label = 1;
            if (passwordManagementViewModel.enterConfirmationCode(str, str2, confirmationCode, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
