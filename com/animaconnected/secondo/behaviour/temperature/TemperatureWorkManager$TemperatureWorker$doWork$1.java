package com.animaconnected.secondo.behaviour.temperature;

import com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: TemperatureWorkManager.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager$TemperatureWorker", f = "TemperatureWorkManager.kt", l = {63}, m = "doWork")
/* loaded from: classes3.dex */
public final class TemperatureWorkManager$TemperatureWorker$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TemperatureWorkManager.TemperatureWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemperatureWorkManager$TemperatureWorker$doWork$1(TemperatureWorkManager.TemperatureWorker temperatureWorker, Continuation<? super TemperatureWorkManager$TemperatureWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = temperatureWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
