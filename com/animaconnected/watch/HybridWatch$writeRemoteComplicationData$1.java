package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HybridWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.HybridWatch", f = "HybridWatch.kt", l = {106, 115}, m = "writeRemoteComplicationData")
/* loaded from: classes3.dex */
public final class HybridWatch$writeRemoteComplicationData$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HybridWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HybridWatch$writeRemoteComplicationData$1(HybridWatch hybridWatch, Continuation<? super HybridWatch$writeRemoteComplicationData$1> continuation) {
        super(continuation);
        this.this$0 = hybridWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object writeRemoteComplicationData;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        writeRemoteComplicationData = this.this$0.writeRemoteComplicationData(null, this);
        return writeRemoteComplicationData;
    }
}
