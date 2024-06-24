package com.animaconnected.watch.device;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MsgPackWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.MsgPackWatch", f = "MsgPackWatch.kt", l = {659}, m = "writeBoolean-0E7RQCE")
/* loaded from: classes3.dex */
public final class MsgPackWatch$writeBoolean$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MsgPackWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackWatch$writeBoolean$1(MsgPackWatch msgPackWatch, Continuation<? super MsgPackWatch$writeBoolean$1> continuation) {
        super(continuation);
        this.this$0 = msgPackWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1075writeBoolean0E7RQCE;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m1075writeBoolean0E7RQCE = this.this$0.m1075writeBoolean0E7RQCE(null, false, this);
        if (m1075writeBoolean0E7RQCE == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return m1075writeBoolean0E7RQCE;
        }
        return new Result(m1075writeBoolean0E7RQCE);
    }
}
