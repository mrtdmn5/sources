package com.animaconnected.watch.fitness;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CSEMLogs.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.CSEMLogs", f = "CSEMLogs.kt", l = {56}, m = "enable")
/* loaded from: classes3.dex */
public final class CSEMLogs$enable$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CSEMLogs this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSEMLogs$enable$1(CSEMLogs cSEMLogs, Continuation<? super CSEMLogs$enable$1> continuation) {
        super(continuation);
        this.this$0 = cSEMLogs;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.enable(null, this);
    }
}
