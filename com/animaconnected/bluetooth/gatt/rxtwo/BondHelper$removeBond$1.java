package com.animaconnected.bluetooth.gatt.rxtwo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BondHelper.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.BondHelper", f = "BondHelper.kt", l = {103, 104, 104, 104}, m = "removeBond")
/* loaded from: classes.dex */
public final class BondHelper$removeBond$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BondHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BondHelper$removeBond$1(BondHelper bondHelper, Continuation<? super BondHelper$removeBond$1> continuation) {
        super(continuation);
        this.this$0 = bondHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeBond(this);
    }
}
