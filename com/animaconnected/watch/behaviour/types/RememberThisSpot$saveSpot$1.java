package com.animaconnected.watch.behaviour.types;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RememberThisSpot.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.types.RememberThisSpot", f = "RememberThisSpot.kt", l = {64, 70}, m = "saveSpot")
/* loaded from: classes3.dex */
public final class RememberThisSpot$saveSpot$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RememberThisSpot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberThisSpot$saveSpot$1(RememberThisSpot rememberThisSpot, Continuation<? super RememberThisSpot$saveSpot$1> continuation) {
        super(continuation);
        this.this$0 = rememberThisSpot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object saveSpot;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        saveSpot = this.this$0.saveSpot(null, this);
        return saveSpot;
    }
}
