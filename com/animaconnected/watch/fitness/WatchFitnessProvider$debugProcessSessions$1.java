package com.animaconnected.watch.fitness;

import com.animaconnected.bluetooth.gatt.GattId;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider", f = "WatchFitnessProvider.kt", l = {GattId.Company.SOPROD}, m = "debugProcessSessions")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$debugProcessSessions$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$debugProcessSessions$1(WatchFitnessProvider watchFitnessProvider, Continuation<? super WatchFitnessProvider$debugProcessSessions$1> continuation) {
        super(continuation);
        this.this$0 = watchFitnessProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.debugProcessSessions(this);
    }
}
