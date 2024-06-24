package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HybridWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.HybridWatch", f = "HybridWatch.kt", l = {277}, m = "setConfigSettings")
/* loaded from: classes3.dex */
public final class HybridWatch$setConfigSettings$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HybridWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HybridWatch$setConfigSettings$1(HybridWatch hybridWatch, Continuation<? super HybridWatch$setConfigSettings$1> continuation) {
        super(continuation);
        this.this$0 = hybridWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object configSettings;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        configSettings = this.this$0.setConfigSettings(null, null, this);
        return configSettings;
    }
}
