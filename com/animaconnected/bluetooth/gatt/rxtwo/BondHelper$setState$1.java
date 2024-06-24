package com.animaconnected.bluetooth.gatt.rxtwo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BondHelper.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.BondHelper", f = "BondHelper.kt", l = {59, 88, 88, 88}, m = "setState")
/* loaded from: classes.dex */
public final class BondHelper$setState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BondHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BondHelper$setState$1(BondHelper bondHelper, Continuation<? super BondHelper$setState$1> continuation) {
        super(continuation);
        this.this$0 = bondHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setState(0, null, this);
    }
}
