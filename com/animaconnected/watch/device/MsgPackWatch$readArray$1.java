package com.animaconnected.watch.device;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MsgPackWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.MsgPackWatch", f = "MsgPackWatch.kt", l = {99}, m = "readArray")
/* loaded from: classes3.dex */
public final class MsgPackWatch$readArray$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MsgPackWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackWatch$readArray$1(MsgPackWatch msgPackWatch, Continuation<? super MsgPackWatch$readArray$1> continuation) {
        super(continuation);
        this.this$0 = msgPackWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readArray;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readArray = this.this$0.readArray(null, null, this);
        return readArray;
    }
}
