package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider", f = "WatchProvider.kt", l = {892}, m = "readDeviceDebugDisconnect")
/* loaded from: classes3.dex */
public final class WatchProvider$readDeviceDebugDisconnect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$readDeviceDebugDisconnect$1(WatchProvider watchProvider, Continuation<? super WatchProvider$readDeviceDebugDisconnect$1> continuation) {
        super(continuation);
        this.this$0 = watchProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readDeviceDebugDisconnect;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readDeviceDebugDisconnect = this.this$0.readDeviceDebugDisconnect(this);
        return readDeviceDebugDisconnect;
    }
}
