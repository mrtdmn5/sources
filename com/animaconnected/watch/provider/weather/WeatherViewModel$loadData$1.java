package com.animaconnected.watch.provider.weather;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WeatherViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.weather.WeatherViewModel", f = "WeatherViewModel.kt", l = {53, 63}, m = "loadData")
/* loaded from: classes3.dex */
public final class WeatherViewModel$loadData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WeatherViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherViewModel$loadData$1(WeatherViewModel weatherViewModel, Continuation<? super WeatherViewModel$loadData$1> continuation) {
        super(continuation);
        this.this$0 = weatherViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadData(this);
    }
}
