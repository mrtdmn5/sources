package com.animaconnected.secondo.behaviour.distress;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DistressPlugin.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.DistressPlugin", f = "DistressPlugin.kt", l = {197}, m = "stopDistress")
/* loaded from: classes3.dex */
public final class DistressPlugin$stopDistress$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DistressPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressPlugin$stopDistress$1(DistressPlugin distressPlugin, Continuation<? super DistressPlugin$stopDistress$1> continuation) {
        super(continuation);
        this.this$0 = distressPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object stopDistress;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        stopDistress = this.this$0.stopDistress(this);
        return stopDistress;
    }
}
