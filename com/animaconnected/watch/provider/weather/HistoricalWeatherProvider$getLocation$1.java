package com.animaconnected.watch.provider.weather;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HistoricalWeatherProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.weather.HistoricalWeatherProvider", f = "HistoricalWeatherProvider.kt", l = {R.styleable.AppTheme_stepsHistoryHintRoundnessDetail}, m = "getLocation")
/* loaded from: classes3.dex */
public final class HistoricalWeatherProvider$getLocation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HistoricalWeatherProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoricalWeatherProvider$getLocation$1(HistoricalWeatherProvider historicalWeatherProvider, Continuation<? super HistoricalWeatherProvider$getLocation$1> continuation) {
        super(continuation);
        this.this$0 = historicalWeatherProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object location;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        location = this.this$0.getLocation(this);
        return location;
    }
}
