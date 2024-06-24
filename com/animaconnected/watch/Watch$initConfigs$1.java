package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Watch.kt */
@DebugMetadata(c = "com.animaconnected.watch.Watch", f = "Watch.kt", l = {238}, m = "initConfigs")
/* loaded from: classes3.dex */
public final class Watch$initConfigs$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Watch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Watch$initConfigs$1(Watch watch, Continuation<? super Watch$initConfigs$1> continuation) {
        super(continuation);
        this.this$0 = watch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initConfigs(null, this);
    }
}
