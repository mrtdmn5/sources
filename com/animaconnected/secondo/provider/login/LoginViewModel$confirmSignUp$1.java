package com.animaconnected.secondo.provider.login;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LoginViewModel.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.login.LoginViewModel", f = "LoginViewModel.kt", l = {R.styleable.AppTheme_themeBackgroundResource, R.styleable.AppTheme_toolbarActionTextStyle}, m = "confirmSignUp")
/* loaded from: classes3.dex */
public final class LoginViewModel$confirmSignUp$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginViewModel$confirmSignUp$1(LoginViewModel loginViewModel, Continuation<? super LoginViewModel$confirmSignUp$1> continuation) {
        super(continuation);
        this.this$0 = loginViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.confirmSignUp(null, this);
    }
}
