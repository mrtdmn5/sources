package com.animaconnected.cloud;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Cloud.kt */
@DebugMetadata(c = "com.animaconnected.cloud.Cloud", f = "Cloud.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_themeGradientOpacity}, m = "getCognitoId")
/* loaded from: classes.dex */
public final class Cloud$getCognitoId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Cloud this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cloud$getCognitoId$1(Cloud cloud, Continuation<? super Cloud$getCognitoId$1> continuation) {
        super(continuation);
        this.this$0 = cloud;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getCognitoId(this);
    }
}
