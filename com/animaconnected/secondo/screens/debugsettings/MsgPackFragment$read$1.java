package com.animaconnected.secondo.screens.debugsettings;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MsgPackFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.MsgPackFragment", f = "MsgPackFragment.kt", l = {184}, m = "read")
/* loaded from: classes3.dex */
public final class MsgPackFragment$read$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MsgPackFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackFragment$read$1(MsgPackFragment msgPackFragment, Continuation<? super MsgPackFragment$read$1> continuation) {
        super(continuation);
        this.this$0 = msgPackFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object read;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        read = this.this$0.read(null, null, this);
        return read;
    }
}
