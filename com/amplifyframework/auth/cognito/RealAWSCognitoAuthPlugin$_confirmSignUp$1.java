package com.amplifyframework.auth.cognito;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RealAWSCognitoAuthPlugin.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin", f = "RealAWSCognitoAuthPlugin.kt", l = {338, 1958}, m = "_confirmSignUp")
/* loaded from: classes.dex */
public final class RealAWSCognitoAuthPlugin$_confirmSignUp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealAWSCognitoAuthPlugin$_confirmSignUp$1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Continuation<? super RealAWSCognitoAuthPlugin$_confirmSignUp$1> continuation) {
        super(continuation);
        this.this$0 = realAWSCognitoAuthPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object _confirmSignUp;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        _confirmSignUp = this.this$0._confirmSignUp(null, null, null, null, null, this);
        return _confirmSignUp;
    }
}
