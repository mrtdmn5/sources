package com.animaconnected.secondo.screens.settings;

import com.animaconnected.secondo.databinding.DialogAccountLogInEmailBinding;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: AccountDialogs.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.AccountDialogsKt$showLoginEmailDialog$1$1$formValidationJob$1", f = "AccountDialogs.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountDialogsKt$showLoginEmailDialog$1$1$formValidationJob$1 extends SuspendLambda implements Function2<FormUiState, Continuation<? super Unit>, Object> {
    final /* synthetic */ DialogAccountLogInEmailBinding $this_apply;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showLoginEmailDialog$1$1$formValidationJob$1(DialogAccountLogInEmailBinding dialogAccountLogInEmailBinding, Continuation<? super AccountDialogsKt$showLoginEmailDialog$1$1$formValidationJob$1> continuation) {
        super(2, continuation);
        this.$this_apply = dialogAccountLogInEmailBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountDialogsKt$showLoginEmailDialog$1$1$formValidationJob$1 accountDialogsKt$showLoginEmailDialog$1$1$formValidationJob$1 = new AccountDialogsKt$showLoginEmailDialog$1$1$formValidationJob$1(this.$this_apply, continuation);
        accountDialogsKt$showLoginEmailDialog$1$1$formValidationJob$1.L$0 = obj;
        return accountDialogsKt$showLoginEmailDialog$1$1$formValidationJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FormUiState formUiState, Continuation<? super Unit> continuation) {
        return ((AccountDialogsKt$showLoginEmailDialog$1$1$formValidationJob$1) create(formUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$this_apply.btnLogIn.setEnabled(((FormUiState) this.L$0).isFormValid());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
