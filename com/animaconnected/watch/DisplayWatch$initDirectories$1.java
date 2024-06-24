package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DisplayWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.DisplayWatch", f = "DisplayWatch.kt", l = {647, 653, 659, 665, 666, 673, 680, 686}, m = "initDirectories")
/* loaded from: classes3.dex */
public final class DisplayWatch$initDirectories$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DisplayWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayWatch$initDirectories$1(DisplayWatch displayWatch, Continuation<? super DisplayWatch$initDirectories$1> continuation) {
        super(continuation);
        this.this$0 = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object initDirectories;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        initDirectories = this.this$0.initDirectories(null, this);
        return initDirectories;
    }
}
