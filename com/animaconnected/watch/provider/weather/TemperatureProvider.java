package com.animaconnected.watch.provider.weather;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.behaviour.temperature.TemperatureStorage;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: TemperatureProvider.kt */
/* loaded from: classes3.dex */
public final class TemperatureProvider {
    private final long maxTemperatureAge;
    private final TemperatureStorage storage = new TemperatureStorage();
    private MutableStateFlow<Float> _lastMeasurementFlow = StateFlowKt.MutableStateFlow(getValue());
    private final float totalDegrees = 360.0f;
    private final int minutes = 60;
    private final int hundredExtended = 120;

    public TemperatureProvider() {
        int r0 = Duration.$r8$clinit;
        this.maxTemperatureAge = DurationKt.toDuration(2, DurationUnit.HOURS);
    }

    private final float fmod(float f, float f2) {
        return ((f % f2) + f2) % f2;
    }

    private final float toFahrenheit(float f) {
        return ((f * 9) / 5) + 32;
    }

    public final TemperatureStorage.TemperatureMeasurement getLastMeasurement() {
        return this.storage.getLastMeasurement();
    }

    public final Float getRotation(boolean z) {
        Float f;
        int r0;
        if (z) {
            f = getValue();
        } else {
            Float value = getValue();
            if (value != null) {
                f = Float.valueOf(toFahrenheit(value.floatValue()));
            } else {
                f = null;
            }
        }
        if (f == null) {
            return null;
        }
        float floatValue = f.floatValue();
        if (this.storage.getUseMinutes()) {
            r0 = this.minutes;
        } else {
            r0 = this.hundredExtended;
        }
        float f2 = floatValue / r0;
        float f3 = this.totalDegrees;
        return Float.valueOf(fmod(f2 * f3, f3));
    }

    /* renamed from: getTimeSinceLastFetch-UwyO8pc, reason: not valid java name */
    public final long m1569getTimeSinceLastFetchUwyO8pc() {
        return DateTimeUtilsKt.now().m1704minus5sfh64U(this.storage.getLastMeasurement().getTimeFetched());
    }

    public final boolean getUseMinuteScale() {
        return this.storage.getUseMinutes();
    }

    public final Float getValue() {
        if (Duration.m1672compareToLRDsOJo(DateTimeUtilsKt.now().m1704minus5sfh64U(this.storage.getLastMeasurement().getTimeFetched()), this.maxTemperatureAge) >= 0) {
            return null;
        }
        return Float.valueOf(this.storage.getLastMeasurement().getTemperatureCelsius());
    }

    public final CommonFlow<Float> observe() {
        return FlowExtensionsKt.asCommonFlow(this._lastMeasurementFlow);
    }

    public final void setLastMeasurement(TemperatureStorage.TemperatureMeasurement measurement) {
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        this.storage.setLastMeasurement(measurement);
        this._lastMeasurementFlow.setValue(getValue());
    }

    public final void setUseMinuteScale(boolean z) {
        this.storage.setUseMinutes(z);
    }
}
