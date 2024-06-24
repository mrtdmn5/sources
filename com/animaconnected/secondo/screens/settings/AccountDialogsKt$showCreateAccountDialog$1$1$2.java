package com.animaconnected.secondo.screens.settings;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.amplifyframework.auth.AuthProvider;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.settings.profile.ProfileFragment;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountDialogs.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.AccountDialogsKt$showCreateAccountDialog$1$1$2", f = "AccountDialogs.kt", l = {42}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountDialogsKt$showCreateAccountDialog$1$1$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomDialog $dialog;
    final /* synthetic */ LoginViewModel $loginViewModel;
    final /* synthetic */ ProfileFragment $this_showCreateAccountDialog;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showCreateAccountDialog$1$1$2(LoginViewModel loginViewModel, ProfileFragment profileFragment, BottomDialog bottomDialog, Continuation<? super AccountDialogsKt$showCreateAccountDialog$1$1$2> continuation) {
        super(2, continuation);
        this.$loginViewModel = loginViewModel;
        this.$this_showCreateAccountDialog = profileFragment;
        this.$dialog = bottomDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountDialogsKt$showCreateAccountDialog$1$1$2(this.$loginViewModel, this.$this_showCreateAccountDialog, this.$dialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((AccountDialogsKt$showCreateAccountDialog$1$1$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
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
            AuthProvider google = AuthProvider.google();
            Intrinsics.checkNotNullExpressionValue(google, "google(...)");
            FragmentActivity requireActivity = this.$this_showCreateAccountDialog.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            this.label = 1;
            if (loginViewModel.signInWithWebUI(google, requireActivity, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        this.$dialog.dismiss();
        return Unit.INSTANCE;
    }
}
