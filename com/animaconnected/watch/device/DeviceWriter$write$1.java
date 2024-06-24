package com.animaconnected.watch.device;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DeviceWriter.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.DeviceWriter", f = "DeviceWriter.kt", l = {87}, m = "write-0E7RQCE")
/* loaded from: classes3.dex */
public final class DeviceWriter$write$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceWriter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceWriter$write$1(DeviceWriter deviceWriter, Continuation<? super DeviceWriter$write$1> continuation) {
        super(continuation);
        this.this$0 = deviceWriter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m1065write0E7RQCE = this.this$0.m1065write0E7RQCE(null, null, this);
        if (m1065write0E7RQCE == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return m1065write0E7RQCE;
        }
        return new Result(m1065write0E7RQCE);
    }
}
