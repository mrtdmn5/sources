package com.animaconnected.watch.device;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MsgPackWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.MsgPackWatch", f = "MsgPackWatch.kt", l = {R.styleable.AppTheme_stepsHistoryBackgroundDetail, 133}, m = "readStringMap")
/* loaded from: classes3.dex */
public final class MsgPackWatch$readStringMap$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MsgPackWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackWatch$readStringMap$1(MsgPackWatch msgPackWatch, Continuation<? super MsgPackWatch$readStringMap$1> continuation) {
        super(continuation);
        this.this$0 = msgPackWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readStringMap;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readStringMap = this.this$0.readStringMap(null, null, this);
        return readStringMap;
    }
}
