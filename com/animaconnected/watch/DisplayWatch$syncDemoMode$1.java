package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DisplayWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.DisplayWatch", f = "DisplayWatch.kt", l = {308}, m = "syncDemoMode")
/* loaded from: classes3.dex */
public final class DisplayWatch$syncDemoMode$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DisplayWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayWatch$syncDemoMode$1(DisplayWatch displayWatch, Continuation<? super DisplayWatch$syncDemoMode$1> continuation) {
        super(continuation);
        this.this$0 = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object syncDemoMode;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        syncDemoMode = this.this$0.syncDemoMode(this);
        return syncDemoMode;
    }
}
