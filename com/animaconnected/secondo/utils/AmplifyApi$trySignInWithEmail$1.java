package com.animaconnected.secondo.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AmplifyApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi", f = "AmplifyApi.kt", l = {64, 64}, m = "trySignInWithEmail")
/* loaded from: classes3.dex */
public final class AmplifyApi$trySignInWithEmail$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AmplifyApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmplifyApi$trySignInWithEmail$1(AmplifyApi amplifyApi, Continuation<? super AmplifyApi$trySignInWithEmail$1> continuation) {
        super(continuation);
        this.this$0 = amplifyApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.trySignInWithEmail(null, null, this);
    }
}
