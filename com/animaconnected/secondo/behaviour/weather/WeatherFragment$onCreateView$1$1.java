package com.animaconnected.secondo.behaviour.weather;

import android.graphics.drawable.Drawable;
import com.animaconnected.secondo.databinding.FragmentWeatherBinding;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.watch.provider.weather.WeatherForecastApp;
import com.kronaby.watch.app.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WeatherFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.weather.WeatherFragment$onCreateView$1$1", f = "WeatherFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WeatherFragment$onCreateView$1$1 extends SuspendLambda implements Function2<WeatherForecastApp, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimatedToolbar $animatedToolbar;
    final /* synthetic */ FragmentWeatherBinding $this_apply;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WeatherFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherFragment$onCreateView$1$1(FragmentWeatherBinding fragmentWeatherBinding, WeatherFragment weatherFragment, AnimatedToolbar animatedToolbar, Continuation<? super WeatherFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = fragmentWeatherBinding;
        this.this$0 = weatherFragment;
        this.$animatedToolbar = animatedToolbar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WeatherFragment$onCreateView$1$1 weatherFragment$onCreateView$1$1 = new WeatherFragment$onCreateView$1$1(this.$this_apply, this.this$0, this.$animatedToolbar, continuation);
        weatherFragment$onCreateView$1$1.L$0 = obj;
        return weatherFragment$onCreateView$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WeatherForecastApp weatherForecastApp, Continuation<? super Unit> continuation) {
        return ((WeatherFragment$onCreateView$1$1) create(weatherForecastApp, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int r0;
        Integer weatherIcon;
        Drawable drawable;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            WeatherForecastApp weatherForecastApp = (WeatherForecastApp) this.L$0;
            if (weatherForecastApp.isCelsius()) {
                r0 = R.drawable.ic_celsius;
            } else {
                r0 = R.drawable.ic_fahrenheit;
            }
            this.$this_apply.tvCurrentTemp.setText(weatherForecastApp.getTemp());
            weatherIcon = this.this$0.getWeatherIcon(weatherForecastApp.getWeather());
            if (weatherIcon != null) {
                this.$this_apply.tvCurrentTemp.setCompoundDrawablesWithIntrinsicBounds(0, 0, weatherIcon.intValue(), 0);
                this.$this_apply.tvCurrentTemp.setCompoundDrawablePadding(16);
            }
            AnimatedToolbar animatedToolbar = this.$animatedToolbar;
            if (animatedToolbar != null) {
                drawable = this.this$0.getDrawable(r0);
                animatedToolbar.setHelpActionDrawable(drawable);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
