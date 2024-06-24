package com.animaconnected.secondo.screens.settings;

import android.view.View;
import com.animaconnected.secondo.databinding.DialogAccountCreateEmailBinding;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.BottomDialog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: AccountDialogs.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.AccountDialogsKt$showCreateEmailAccountDialog$1$1$1", f = "AccountDialogs.kt", l = {98}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountDialogsKt$showCreateEmailAccountDialog$1$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomDialog $dialog;
    final /* synthetic */ LoginViewModel $loginViewModel;
    final /* synthetic */ DialogAccountCreateEmailBinding $this_apply;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showCreateEmailAccountDialog$1$1$1(LoginViewModel loginViewModel, DialogAccountCreateEmailBinding dialogAccountCreateEmailBinding, BottomDialog bottomDialog, Continuation<? super AccountDialogsKt$showCreateEmailAccountDialog$1$1$1> continuation) {
        super(2, continuation);
        this.$loginViewModel = loginViewModel;
        this.$this_apply = dialogAccountCreateEmailBinding;
        this.$dialog = bottomDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountDialogsKt$showCreateEmailAccountDialog$1$1$1(this.$loginViewModel, this.$this_apply, this.$dialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((AccountDialogsKt$showCreateEmailAccountDialog$1$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
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
            String valueOf = String.valueOf(this.$this_apply.layoutEmail.editText.getText());
            String valueOf2 = String.valueOf(this.$this_apply.layoutPassword.etPassword.getText());
            this.label = 1;
            if (loginViewModel.signUp(valueOf, valueOf2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        this.$dialog.dismiss();
        return Unit.INSTANCE;
    }
}
