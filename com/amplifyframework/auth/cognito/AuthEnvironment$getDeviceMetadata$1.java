package com.amplifyframework.auth.cognito;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AuthEnvironment.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.AuthEnvironment", f = "AuthEnvironment.kt", l = {107}, m = "getDeviceMetadata")
/* loaded from: classes.dex */
public final class AuthEnvironment$getDeviceMetadata$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthEnvironment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthEnvironment$getDeviceMetadata$1(AuthEnvironment authEnvironment, Continuation<? super AuthEnvironment$getDeviceMetadata$1> continuation) {
        super(continuation);
        this.this$0 = authEnvironment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDeviceMetadata(null, this);
    }
}
