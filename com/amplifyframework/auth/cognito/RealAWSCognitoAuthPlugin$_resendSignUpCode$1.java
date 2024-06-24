package com.amplifyframework.auth.cognito;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RealAWSCognitoAuthPlugin.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin", f = "RealAWSCognitoAuthPlugin.kt", l = {410, 1958}, m = "_resendSignUpCode")
/* loaded from: classes.dex */
public final class RealAWSCognitoAuthPlugin$_resendSignUpCode$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealAWSCognitoAuthPlugin$_resendSignUpCode$1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Continuation<? super RealAWSCognitoAuthPlugin$_resendSignUpCode$1> continuation) {
        super(continuation);
        this.this$0 = realAWSCognitoAuthPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object _resendSignUpCode;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        _resendSignUpCode = this.this$0._resendSignUpCode(null, null, null, null, this);
        return _resendSignUpCode;
    }
}
