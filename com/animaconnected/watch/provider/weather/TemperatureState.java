package com.animaconnected.watch.provider.weather;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: WeatherViewModel.kt */
/* loaded from: classes3.dex */
public final class TemperatureState {
    private final boolean isCelsius;
    private final boolean isMinutes;
    private final String temperature;

    public TemperatureState(String temperature, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        this.temperature = temperature;
        this.isMinutes = z;
        this.isCelsius = z2;
    }

    public static /* synthetic */ TemperatureState copy$default(TemperatureState temperatureState, String str, boolean z, boolean z2, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = temperatureState.temperature;
        }
        if ((r4 & 2) != 0) {
            z = temperatureState.isMinutes;
        }
        if ((r4 & 4) != 0) {
            z2 = temperatureState.isCelsius;
        }
        return temperatureState.copy(str, z, z2);
    }

    public final String component1() {
        return this.temperature;
    }

    public final boolean component2() {
        return this.isMinutes;
    }

    public final boolean component3() {
        return this.isCelsius;
    }

    public final TemperatureState copy(String temperature, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        return new TemperatureState(temperature, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemperatureState)) {
            return false;
        }
        TemperatureState temperatureState = (TemperatureState) obj;
        if (Intrinsics.areEqual(this.temperature, temperatureState.temperature) && this.isMinutes == temperatureState.isMinutes && this.isCelsius == temperatureState.isCelsius) {
            return true;
        }
        return false;
    }

    public final String getTemperature() {
        return this.temperature;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isCelsius) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isMinutes, this.temperature.hashCode() * 31, 31);
    }

    public final boolean isCelsius() {
        return this.isCelsius;
    }

    public final boolean isMinutes() {
        return this.isMinutes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TemperatureState(temperature=");
        sb.append(this.temperature);
        sb.append(", isMinutes=");
        sb.append(this.isMinutes);
        sb.append(", isCelsius=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isCelsius, ')');
    }
}
