package com.animaconnected.watch.behaviour.temperature;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WeatherHttpClient.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.temperature.WeatherHttpClient", f = "WeatherHttpClient.kt", l = {184, 185}, m = "fetchHistoricalWeather")
/* loaded from: classes3.dex */
public final class WeatherHttpClient$fetchHistoricalWeather$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WeatherHttpClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherHttpClient$fetchHistoricalWeather$1(WeatherHttpClient weatherHttpClient, Continuation<? super WeatherHttpClient$fetchHistoricalWeather$1> continuation) {
        super(continuation);
        this.this$0 = weatherHttpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchHistoricalWeather(null, this);
    }
}
