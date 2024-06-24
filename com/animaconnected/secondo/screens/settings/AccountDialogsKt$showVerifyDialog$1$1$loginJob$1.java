package com.animaconnected.secondo.screens.settings;

import com.animaconnected.secondo.provider.login.LoginState;
import com.animaconnected.secondo.screens.BottomDialog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: AccountDialogs.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.AccountDialogsKt$showVerifyDialog$1$1$loginJob$1", f = "AccountDialogs.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountDialogsKt$showVerifyDialog$1$1$loginJob$1 extends SuspendLambda implements Function2<LoginState, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomDialog $dialog;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showVerifyDialog$1$1$loginJob$1(BottomDialog bottomDialog, Continuation<? super AccountDialogsKt$showVerifyDialog$1$1$loginJob$1> continuation) {
        super(2, continuation);
        this.$dialog = bottomDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountDialogsKt$showVerifyDialog$1$1$loginJob$1 accountDialogsKt$showVerifyDialog$1$1$loginJob$1 = new AccountDialogsKt$showVerifyDialog$1$1$loginJob$1(this.$dialog, continuation);
        accountDialogsKt$showVerifyDialog$1$1$loginJob$1.L$0 = obj;
        return accountDialogsKt$showVerifyDialog$1$1$loginJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LoginState loginState, Continuation<? super Unit> continuation) {
        return ((AccountDialogsKt$showVerifyDialog$1$1$loginJob$1) create(loginState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LoginState loginState = (LoginState) this.L$0;
            if ((loginState instanceof LoginState.Idle) || (loginState instanceof LoginState.SignedIn)) {
                this.$dialog.dismiss();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
