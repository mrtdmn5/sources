package com.animaconnected.watch;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BtDevice.kt */
@DebugMetadata(c = "com.animaconnected.watch.BtDevice", f = "BtDevice.kt", l = {389}, m = "removeBond-IoAF18A")
/* loaded from: classes3.dex */
public final class BtDevice$removeBond$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BtDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BtDevice$removeBond$1(BtDevice btDevice, Continuation<? super BtDevice$removeBond$1> continuation) {
        super(continuation);
        this.this$0 = btDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1044removeBondIoAF18A = this.this$0.mo1044removeBondIoAF18A(this);
        if (mo1044removeBondIoAF18A == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return mo1044removeBondIoAF18A;
        }
        return new Result(mo1044removeBondIoAF18A);
    }
}
