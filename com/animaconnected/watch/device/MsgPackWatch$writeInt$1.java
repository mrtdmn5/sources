package com.animaconnected.watch.device;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MsgPackWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.MsgPackWatch", f = "MsgPackWatch.kt", l = {653}, m = "writeInt-0E7RQCE")
/* loaded from: classes3.dex */
public final class MsgPackWatch$writeInt$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MsgPackWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackWatch$writeInt$1(MsgPackWatch msgPackWatch, Continuation<? super MsgPackWatch$writeInt$1> continuation) {
        super(continuation);
        this.this$0 = msgPackWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1076writeInt0E7RQCE;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m1076writeInt0E7RQCE = this.this$0.m1076writeInt0E7RQCE(null, 0, this);
        if (m1076writeInt0E7RQCE == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return m1076writeInt0E7RQCE;
        }
        return new Result(m1076writeInt0E7RQCE);
    }
}
