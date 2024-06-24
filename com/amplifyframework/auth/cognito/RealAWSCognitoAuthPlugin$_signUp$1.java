package com.amplifyframework.auth.cognito;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RealAWSCognitoAuthPlugin.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin", f = "RealAWSCognitoAuthPlugin.kt", l = {229, 1962}, m = "_signUp")
/* loaded from: classes.dex */
public final class RealAWSCognitoAuthPlugin$_signUp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealAWSCognitoAuthPlugin$_signUp$1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Continuation<? super RealAWSCognitoAuthPlugin$_signUp$1> continuation) {
        super(continuation);
        this.this$0 = realAWSCognitoAuthPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object _signUp;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        _signUp = this.this$0._signUp(null, null, null, null, null, this);
        return _signUp;
    }
}
