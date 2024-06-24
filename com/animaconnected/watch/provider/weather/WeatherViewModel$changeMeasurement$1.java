package com.animaconnected.watch.provider.weather;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WeatherViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.weather.WeatherViewModel", f = "WeatherViewModel.kt", l = {R.styleable.AppTheme_workoutDetailColorBackground, R.styleable.AppTheme_workoutDetailTintColor, 183}, m = "changeMeasurement")
/* loaded from: classes3.dex */
public final class WeatherViewModel$changeMeasurement$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WeatherViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherViewModel$changeMeasurement$1(WeatherViewModel weatherViewModel, Continuation<? super WeatherViewModel$changeMeasurement$1> continuation) {
        super(continuation);
        this.this$0 = weatherViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.changeMeasurement(null, this);
    }
}
