package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DisplayWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.DisplayWatch", f = "DisplayWatch.kt", l = {337}, m = "removeApp")
/* loaded from: classes3.dex */
public final class DisplayWatch$removeApp$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DisplayWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayWatch$removeApp$1(DisplayWatch displayWatch, Continuation<? super DisplayWatch$removeApp$1> continuation) {
        super(continuation);
        this.this$0 = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object removeApp;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        removeApp = this.this$0.removeApp(0, this);
        return removeApp;
    }
}
