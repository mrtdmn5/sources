package com.animaconnected.watch.device;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MsgPackWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.MsgPackWatch", f = "MsgPackWatch.kt", l = {74}, m = "fetchDefinition")
/* loaded from: classes3.dex */
public final class MsgPackWatch$fetchDefinition$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MsgPackWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackWatch$fetchDefinition$1(MsgPackWatch msgPackWatch, Continuation<? super MsgPackWatch$fetchDefinition$1> continuation) {
        super(continuation);
        this.this$0 = msgPackWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchDefinition;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchDefinition = this.this$0.fetchDefinition(null, this);
        return fetchDefinition;
    }
}
