package com.animaconnected.watch.provider.weather;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import com.animaconnected.watch.provider.weather.WeatherViewModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeatherViewModel.kt */
/* loaded from: classes3.dex */
public final class WeatherForecastApp {
    private final boolean isCelsius;
    private final String temp;
    private final WeatherViewModel.Weather weather;

    public WeatherForecastApp(String temp, WeatherViewModel.Weather weather, boolean z) {
        Intrinsics.checkNotNullParameter(temp, "temp");
        Intrinsics.checkNotNullParameter(weather, "weather");
        this.temp = temp;
        this.weather = weather;
        this.isCelsius = z;
    }

    public static /* synthetic */ WeatherForecastApp copy$default(WeatherForecastApp weatherForecastApp, String str, WeatherViewModel.Weather weather, boolean z, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = weatherForecastApp.temp;
        }
        if ((r4 & 2) != 0) {
            weather = weatherForecastApp.weather;
        }
        if ((r4 & 4) != 0) {
            z = weatherForecastApp.isCelsius;
        }
        return weatherForecastApp.copy(str, weather, z);
    }

    public final String component1() {
        return this.temp;
    }

    public final WeatherViewModel.Weather component2() {
        return this.weather;
    }

    public final boolean component3() {
        return this.isCelsius;
    }

    public final WeatherForecastApp copy(String temp, WeatherViewModel.Weather weather, boolean z) {
        Intrinsics.checkNotNullParameter(temp, "temp");
        Intrinsics.checkNotNullParameter(weather, "weather");
        return new WeatherForecastApp(temp, weather, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeatherForecastApp)) {
            return false;
        }
        WeatherForecastApp weatherForecastApp = (WeatherForecastApp) obj;
        if (Intrinsics.areEqual(this.temp, weatherForecastApp.temp) && this.weather == weatherForecastApp.weather && this.isCelsius == weatherForecastApp.isCelsius) {
            return true;
        }
        return false;
    }

    public final String getTemp() {
        return this.temp;
    }

    public final WeatherViewModel.Weather getWeather() {
        return this.weather;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isCelsius) + ((this.weather.hashCode() + (this.temp.hashCode() * 31)) * 31);
    }

    public final boolean isCelsius() {
        return this.isCelsius;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WeatherForecastApp(temp=");
        sb.append(this.temp);
        sb.append(", weather=");
        sb.append(this.weather);
        sb.append(", isCelsius=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isCelsius, ')');
    }

    public /* synthetic */ WeatherForecastApp(String str, WeatherViewModel.Weather weather, boolean z, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? "-" : str, (r4 & 2) != 0 ? WeatherViewModel.Weather.Unknown : weather, z);
    }
}
