package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BtDevice.kt */
@DebugMetadata(c = "com.animaconnected.watch.BtDevice", f = "BtDevice.kt", l = {211}, m = "getDeviceInformation")
/* loaded from: classes3.dex */
public final class BtDevice$getDeviceInformation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BtDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BtDevice$getDeviceInformation$1(BtDevice btDevice, Continuation<? super BtDevice$getDeviceInformation$1> continuation) {
        super(continuation);
        this.this$0 = btDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object deviceInformation;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        deviceInformation = this.this$0.getDeviceInformation(this);
        return deviceInformation;
    }
}
