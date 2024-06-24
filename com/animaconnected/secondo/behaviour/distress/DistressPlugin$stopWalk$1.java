package com.animaconnected.secondo.behaviour.distress;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DistressPlugin.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.DistressPlugin", f = "DistressPlugin.kt", l = {208}, m = "stopWalk")
/* loaded from: classes3.dex */
public final class DistressPlugin$stopWalk$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DistressPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressPlugin$stopWalk$1(DistressPlugin distressPlugin, Continuation<? super DistressPlugin$stopWalk$1> continuation) {
        super(continuation);
        this.this$0 = distressPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object stopWalk;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        stopWalk = this.this$0.stopWalk(this);
        return stopWalk;
    }
}
