package com.animaconnected.secondo.provider.login;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LoginViewModel.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.login.LoginViewModel", f = "LoginViewModel.kt", l = {115}, m = "signInWithWebUI")
/* loaded from: classes3.dex */
public final class LoginViewModel$signInWithWebUI$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginViewModel$signInWithWebUI$1(LoginViewModel loginViewModel, Continuation<? super LoginViewModel$signInWithWebUI$1> continuation) {
        super(continuation);
        this.this$0 = loginViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.signInWithWebUI(null, null, this);
    }
}
