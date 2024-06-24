package com.animaconnected.watch.provider;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchAlarmProviderImpl.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.WatchAlarmProviderImpl", f = "WatchAlarmProviderImpl.kt", l = {62}, m = "migrate")
/* loaded from: classes3.dex */
public final class WatchAlarmProviderImpl$migrate$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchAlarmProviderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchAlarmProviderImpl$migrate$1(WatchAlarmProviderImpl watchAlarmProviderImpl, Continuation<? super WatchAlarmProviderImpl$migrate$1> continuation) {
        super(continuation);
        this.this$0 = watchAlarmProviderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.migrate(null, this);
    }
}
