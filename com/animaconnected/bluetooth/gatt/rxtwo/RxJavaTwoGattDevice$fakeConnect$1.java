package com.animaconnected.bluetooth.gatt.rxtwo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RxJavaTwoGattDevice.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice", f = "RxJavaTwoGattDevice.kt", l = {453, 455, 455}, m = "fakeConnect")
/* loaded from: classes.dex */
public final class RxJavaTwoGattDevice$fakeConnect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RxJavaTwoGattDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattDevice$fakeConnect$1(RxJavaTwoGattDevice rxJavaTwoGattDevice, Continuation<? super RxJavaTwoGattDevice$fakeConnect$1> continuation) {
        super(continuation);
        this.this$0 = rxJavaTwoGattDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fakeConnect(this);
    }
}
