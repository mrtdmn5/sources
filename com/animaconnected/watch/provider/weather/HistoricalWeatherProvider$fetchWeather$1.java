package com.animaconnected.watch.provider.weather;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HistoricalWeatherProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.weather.HistoricalWeatherProvider", f = "HistoricalWeatherProvider.kt", l = {69, 76}, m = "fetchWeather")
/* loaded from: classes3.dex */
public final class HistoricalWeatherProvider$fetchWeather$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HistoricalWeatherProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoricalWeatherProvider$fetchWeather$1(HistoricalWeatherProvider historicalWeatherProvider, Continuation<? super HistoricalWeatherProvider$fetchWeather$1> continuation) {
        super(continuation);
        this.this$0 = historicalWeatherProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchWeather(this);
    }
}
