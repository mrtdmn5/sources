package com.animaconnected.secondo.screens.settings;

import android.view.View;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: AccountDialogs.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.AccountDialogsKt$showVerifyDialog$1$1$3", f = "AccountDialogs.kt", l = {207}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountDialogsKt$showVerifyDialog$1$1$3 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ FormValidationViewModel $formValidationVm;
    final /* synthetic */ LoginViewModel $loginViewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showVerifyDialog$1$1$3(LoginViewModel loginViewModel, FormValidationViewModel formValidationViewModel, Continuation<? super AccountDialogsKt$showVerifyDialog$1$1$3> continuation) {
        super(2, continuation);
        this.$loginViewModel = loginViewModel;
        this.$formValidationVm = formValidationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountDialogsKt$showVerifyDialog$1$1$3(this.$loginViewModel, this.$formValidationVm, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((AccountDialogsKt$showVerifyDialog$1$1$3) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
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
            LoginViewModel loginViewModel = this.$loginViewModel;
            String confirmationCode = this.$formValidationVm.getConfirmationCode();
            this.label = 1;
            if (loginViewModel.confirmSignUp(confirmationCode, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
