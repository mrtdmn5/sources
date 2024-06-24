package com.animaconnected.watch.device;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MsgPackWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.MsgPackWatch", f = "MsgPackWatch.kt", l = {647}, m = "write-0E7RQCE$watch_release")
/* loaded from: classes3.dex */
public final class MsgPackWatch$write$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MsgPackWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackWatch$write$1(MsgPackWatch msgPackWatch, Continuation<? super MsgPackWatch$write$1> continuation) {
        super(continuation);
        this.this$0 = msgPackWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m1079write0E7RQCE$watch_release = this.this$0.m1079write0E7RQCE$watch_release(null, null, this);
        if (m1079write0E7RQCE$watch_release == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return m1079write0E7RQCE$watch_release;
        }
        return new Result(m1079write0E7RQCE$watch_release);
    }
}
