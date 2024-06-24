package com.animaconnected.secondo.screens.settings;

import android.view.View;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.settings.profile.ProfileFragment;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: AccountDialogs.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.AccountDialogsKt$showCreateAccountDialog$1$1$3", f = "AccountDialogs.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountDialogsKt$showCreateAccountDialog$1$1$3 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomDialog $dialog;
    final /* synthetic */ ProfileFragment $this_showCreateAccountDialog;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showCreateAccountDialog$1$1$3(BottomDialog bottomDialog, ProfileFragment profileFragment, Continuation<? super AccountDialogsKt$showCreateAccountDialog$1$1$3> continuation) {
        super(2, continuation);
        this.$dialog = bottomDialog;
        this.$this_showCreateAccountDialog = profileFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountDialogsKt$showCreateAccountDialog$1$1$3(this.$dialog, this.$this_showCreateAccountDialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((AccountDialogsKt$showCreateAccountDialog$1$1$3) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$dialog.dismiss();
            AccountDialogsKt.showCreateEmailAccountDialog(this.$this_showCreateAccountDialog);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
