package com.animaconnected.bluetooth.gatt.rxtwo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RxJavaTwoGattConnection.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection", f = "RxJavaTwoGattConnection.kt", l = {86}, m = "discoverServices")
/* loaded from: classes.dex */
public final class RxJavaTwoGattConnection$discoverServices$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RxJavaTwoGattConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattConnection$discoverServices$1(RxJavaTwoGattConnection rxJavaTwoGattConnection, Continuation<? super RxJavaTwoGattConnection$discoverServices$1> continuation) {
        super(continuation);
        this.this$0 = rxJavaTwoGattConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.discoverServices(this);
    }
}
