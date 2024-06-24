package com.animaconnected.cloud;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Cloud.kt */
@DebugMetadata(c = "com.animaconnected.cloud.Cloud", f = "Cloud.kt", l = {186}, m = "getCognitoToken-IoAF18A")
/* loaded from: classes.dex */
public final class Cloud$getCognitoToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Cloud this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cloud$getCognitoToken$1(Cloud cloud, Continuation<? super Cloud$getCognitoToken$1> continuation) {
        super(continuation);
        this.this$0 = cloud;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m695getCognitoTokenIoAF18A = this.this$0.m695getCognitoTokenIoAF18A(this);
        if (m695getCognitoTokenIoAF18A == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return m695getCognitoTokenIoAF18A;
        }
        return new Result(m695getCognitoTokenIoAF18A);
    }
}
