package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DisplayWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.DisplayWatch", f = "DisplayWatch.kt", l = {267}, m = "syncFitnessConfig")
/* loaded from: classes3.dex */
public final class DisplayWatch$syncFitnessConfig$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DisplayWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayWatch$syncFitnessConfig$1(DisplayWatch displayWatch, Continuation<? super DisplayWatch$syncFitnessConfig$1> continuation) {
        super(continuation);
        this.this$0 = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object syncFitnessConfig;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        syncFitnessConfig = this.this$0.syncFitnessConfig(this);
        return syncFitnessConfig;
    }
}
