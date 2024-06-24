package com.animaconnected.secondo.screens.settings;

import com.animaconnected.secondo.utils.Loading;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: AccountDialogs.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.AccountDialogsKt$showVerifyDialog$1$1$loadingJob$1", f = "AccountDialogs.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountDialogsKt$showVerifyDialog$1$1$loadingJob$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ Loading $loading;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showVerifyDialog$1$1$loadingJob$1(Loading loading, Continuation<? super AccountDialogsKt$showVerifyDialog$1$1$loadingJob$1> continuation) {
        super(2, continuation);
        this.$loading = loading;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountDialogsKt$showVerifyDialog$1$1$loadingJob$1 accountDialogsKt$showVerifyDialog$1$1$loadingJob$1 = new AccountDialogsKt$showVerifyDialog$1$1$loadingJob$1(this.$loading, continuation);
        accountDialogsKt$showVerifyDialog$1$1$loadingJob$1.Z$0 = ((Boolean) obj).booleanValue();
        return accountDialogsKt$showVerifyDialog$1$1$loadingJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$loading.invalidate(this.Z$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((AccountDialogsKt$showVerifyDialog$1$1$loadingJob$1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
