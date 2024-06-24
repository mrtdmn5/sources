package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider", f = "WatchProvider.kt", l = {909}, m = "writeDeviceSettings")
/* loaded from: classes3.dex */
public final class WatchProvider$writeDeviceSettings$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$writeDeviceSettings$1(WatchProvider watchProvider, Continuation<? super WatchProvider$writeDeviceSettings$1> continuation) {
        super(continuation);
        this.this$0 = watchProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object writeDeviceSettings;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        writeDeviceSettings = this.this$0.writeDeviceSettings(this);
        return writeDeviceSettings;
    }
}
