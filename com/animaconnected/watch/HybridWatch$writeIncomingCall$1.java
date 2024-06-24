package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HybridWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.HybridWatch", f = "HybridWatch.kt", l = {379}, m = "writeIncomingCall")
/* loaded from: classes3.dex */
public final class HybridWatch$writeIncomingCall$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HybridWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HybridWatch$writeIncomingCall$1(HybridWatch hybridWatch, Continuation<? super HybridWatch$writeIncomingCall$1> continuation) {
        super(continuation);
        this.this$0 = hybridWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeIncomingCall(0, false, null, this);
    }
}
