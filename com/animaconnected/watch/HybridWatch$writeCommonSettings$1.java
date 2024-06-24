package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HybridWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.HybridWatch", f = "HybridWatch.kt", l = {242, 242, 246, 250, 259, 260, 262, 266, 270}, m = "writeCommonSettings")
/* loaded from: classes3.dex */
public final class HybridWatch$writeCommonSettings$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HybridWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HybridWatch$writeCommonSettings$1(HybridWatch hybridWatch, Continuation<? super HybridWatch$writeCommonSettings$1> continuation) {
        super(continuation);
        this.this$0 = hybridWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object writeCommonSettings;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        writeCommonSettings = this.this$0.writeCommonSettings(null, this);
        return writeCommonSettings;
    }
}
