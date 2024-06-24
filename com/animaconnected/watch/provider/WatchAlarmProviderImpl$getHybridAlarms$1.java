package com.animaconnected.watch.provider;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchAlarmProviderImpl.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.WatchAlarmProviderImpl", f = "WatchAlarmProviderImpl.kt", l = {24}, m = "getHybridAlarms")
/* loaded from: classes3.dex */
public final class WatchAlarmProviderImpl$getHybridAlarms$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchAlarmProviderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchAlarmProviderImpl$getHybridAlarms$1(WatchAlarmProviderImpl watchAlarmProviderImpl, Continuation<? super WatchAlarmProviderImpl$getHybridAlarms$1> continuation) {
        super(continuation);
        this.this$0 = watchAlarmProviderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getHybridAlarms(false, this);
    }
}
