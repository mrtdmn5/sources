package com.animaconnected.watch.provider.weather;

import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.provider.weather.WeatherViewModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeatherViewModel.kt */
/* loaded from: classes3.dex */
public final class CurrentForecast {
    private final Mitmap icon;
    private final String temp;
    private final WeatherViewModel.Weather type;

    public CurrentForecast() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CurrentForecast copy$default(CurrentForecast currentForecast, String str, Mitmap mitmap, WeatherViewModel.Weather weather, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = currentForecast.temp;
        }
        if ((r4 & 2) != 0) {
            mitmap = currentForecast.icon;
        }
        if ((r4 & 4) != 0) {
            weather = currentForecast.type;
        }
        return currentForecast.copy(str, mitmap, weather);
    }

    public final String component1() {
        return this.temp;
    }

    public final Mitmap component2() {
        return this.icon;
    }

    public final WeatherViewModel.Weather component3() {
        return this.type;
    }

    public final CurrentForecast copy(String temp, Mitmap icon, WeatherViewModel.Weather type) {
        Intrinsics.checkNotNullParameter(temp, "temp");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(type, "type");
        return new CurrentForecast(temp, icon, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CurrentForecast)) {
            return false;
        }
        CurrentForecast currentForecast = (CurrentForecast) obj;
        if (Intrinsics.areEqual(this.temp, currentForecast.temp) && Intrinsics.areEqual(this.icon, currentForecast.icon) && this.type == currentForecast.type) {
            return true;
        }
        return false;
    }

    public final Mitmap getIcon() {
        return this.icon;
    }

    public final String getTemp() {
        return this.temp;
    }

    public final WeatherViewModel.Weather getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode() + ((this.icon.hashCode() + (this.temp.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "CurrentForecast(temp=" + this.temp + ", icon=" + this.icon + ", type=" + this.type + ')';
    }

    public CurrentForecast(String temp, Mitmap icon, WeatherViewModel.Weather type) {
        Intrinsics.checkNotNullParameter(temp, "temp");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(type, "type");
        this.temp = temp;
        this.icon = icon;
        this.type = type;
    }

    public /* synthetic */ CurrentForecast(String str, Mitmap mitmap, WeatherViewModel.Weather weather, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? "-" : str, (r4 & 2) != 0 ? GraphicsKt.emptyMitmap() : mitmap, (r4 & 4) != 0 ? WeatherViewModel.Weather.Unknown : weather);
    }
}
