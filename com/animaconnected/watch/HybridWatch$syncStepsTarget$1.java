package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HybridWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.HybridWatch", f = "HybridWatch.kt", l = {226}, m = "syncStepsTarget")
/* loaded from: classes3.dex */
public final class HybridWatch$syncStepsTarget$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HybridWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HybridWatch$syncStepsTarget$1(HybridWatch hybridWatch, Continuation<? super HybridWatch$syncStepsTarget$1> continuation) {
        super(continuation);
        this.this$0 = hybridWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object syncStepsTarget;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        syncStepsTarget = this.this$0.syncStepsTarget(this);
        return syncStepsTarget;
    }
}
