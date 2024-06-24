package com.animaconnected.watch.device;

import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MsgPackWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.MsgPackWatch", f = "MsgPackWatch.kt", l = {TipsAndTricksConstants.FIND_PHONE_PRIORITY}, m = "writeComplicationMode")
/* loaded from: classes3.dex */
public final class MsgPackWatch$writeComplicationMode$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MsgPackWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackWatch$writeComplicationMode$1(MsgPackWatch msgPackWatch, Continuation<? super MsgPackWatch$writeComplicationMode$1> continuation) {
        super(continuation);
        this.this$0 = msgPackWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeComplicationMode(0, this);
    }
}
