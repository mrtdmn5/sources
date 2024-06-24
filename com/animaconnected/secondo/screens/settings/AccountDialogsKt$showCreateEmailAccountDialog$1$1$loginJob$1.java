package com.animaconnected.secondo.screens.settings;

import com.animaconnected.secondo.provider.login.LoginState;
import com.animaconnected.secondo.screens.settings.profile.ProfileFragment;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: AccountDialogs.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.AccountDialogsKt$showCreateEmailAccountDialog$1$1$loginJob$1", f = "AccountDialogs.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountDialogsKt$showCreateEmailAccountDialog$1$1$loginJob$1 extends SuspendLambda implements Function2<LoginState, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProfileFragment $this_showCreateEmailAccountDialog;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showCreateEmailAccountDialog$1$1$loginJob$1(ProfileFragment profileFragment, Continuation<? super AccountDialogsKt$showCreateEmailAccountDialog$1$1$loginJob$1> continuation) {
        super(2, continuation);
        this.$this_showCreateEmailAccountDialog = profileFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountDialogsKt$showCreateEmailAccountDialog$1$1$loginJob$1 accountDialogsKt$showCreateEmailAccountDialog$1$1$loginJob$1 = new AccountDialogsKt$showCreateEmailAccountDialog$1$1$loginJob$1(this.$this_showCreateEmailAccountDialog, continuation);
        accountDialogsKt$showCreateEmailAccountDialog$1$1$loginJob$1.L$0 = obj;
        return accountDialogsKt$showCreateEmailAccountDialog$1$1$loginJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LoginState loginState, Continuation<? super Unit> continuation) {
        return ((AccountDialogsKt$showCreateEmailAccountDialog$1$1$loginJob$1) create(loginState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (((LoginState) this.L$0) instanceof LoginState.ConfirmSignUp) {
                AccountDialogsKt.showVerifyDialog(this.$this_showCreateEmailAccountDialog);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
