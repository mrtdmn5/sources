package com.animaconnected.watch;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider", f = "WatchProvider.kt", l = {1119}, m = "resetDevice-IoAF18A")
/* loaded from: classes3.dex */
public final class WatchProvider$resetDevice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$resetDevice$1(WatchProvider watchProvider, Continuation<? super WatchProvider$resetDevice$1> continuation) {
        super(continuation);
        this.this$0 = watchProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m1052resetDeviceIoAF18A = this.this$0.m1052resetDeviceIoAF18A(this);
        if (m1052resetDeviceIoAF18A == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return m1052resetDeviceIoAF18A;
        }
        return new Result(m1052resetDeviceIoAF18A);
    }
}
