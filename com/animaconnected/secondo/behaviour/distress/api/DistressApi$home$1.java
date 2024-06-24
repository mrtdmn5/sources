package com.animaconnected.secondo.behaviour.distress.api;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DistressApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.api.DistressApi", f = "DistressApi.kt", l = {R.styleable.AppTheme_styleMarbleText}, m = "home")
/* loaded from: classes3.dex */
public final class DistressApi$home$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DistressApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressApi$home$1(DistressApi distressApi, Continuation<? super DistressApi$home$1> continuation) {
        super(continuation);
        this.this$0 = distressApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.home(this);
    }
}
