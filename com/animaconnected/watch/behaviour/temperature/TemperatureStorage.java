package com.animaconnected.watch.behaviour.temperature;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.location.Spot;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;

/* compiled from: TemperatureStorage.kt */
/* loaded from: classes3.dex */
public final class TemperatureStorage {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_IS_CELSIUS = "isCelsius";
    private static final String KEY_LAST_FETCH_TIME = "lastFetchTimestamp";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_TEMPERATURE = "temperature";
    private static final String KEY_USE_MINUTES = "useMinutes";
    private static final String TEMPERATURE_STORAGE = "temperatureStorage";
    private final BasicStorage storage = ServiceLocator.INSTANCE.getStorageFactory().createStorage(TEMPERATURE_STORAGE);

    /* compiled from: TemperatureStorage.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: TemperatureStorage.kt */
    /* loaded from: classes3.dex */
    public static final class TemperatureMeasurement {
        private final float temperatureCelsius;
        private final Instant timeFetched;

        public TemperatureMeasurement(Instant timeFetched, float f) {
            Intrinsics.checkNotNullParameter(timeFetched, "timeFetched");
            this.timeFetched = timeFetched;
            this.temperatureCelsius = f;
        }

        public static /* synthetic */ TemperatureMeasurement copy$default(TemperatureMeasurement temperatureMeasurement, Instant instant, float f, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                instant = temperatureMeasurement.timeFetched;
            }
            if ((r3 & 2) != 0) {
                f = temperatureMeasurement.temperatureCelsius;
            }
            return temperatureMeasurement.copy(instant, f);
        }

        public final Instant component1() {
            return this.timeFetched;
        }

        public final float component2() {
            return this.temperatureCelsius;
        }

        public final TemperatureMeasurement copy(Instant timeFetched, float f) {
            Intrinsics.checkNotNullParameter(timeFetched, "timeFetched");
            return new TemperatureMeasurement(timeFetched, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TemperatureMeasurement)) {
                return false;
            }
            TemperatureMeasurement temperatureMeasurement = (TemperatureMeasurement) obj;
            if (Intrinsics.areEqual(this.timeFetched, temperatureMeasurement.timeFetched) && Float.compare(this.temperatureCelsius, temperatureMeasurement.temperatureCelsius) == 0) {
                return true;
            }
            return false;
        }

        public final float getTemperatureCelsius() {
            return this.temperatureCelsius;
        }

        public final Instant getTimeFetched() {
            return this.timeFetched;
        }

        public int hashCode() {
            return Float.hashCode(this.temperatureCelsius) + (this.timeFetched.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("TemperatureMeasurement(timeFetched=");
            sb.append(this.timeFetched);
            sb.append(", temperatureCelsius=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.temperatureCelsius, ')');
        }
    }

    public final TemperatureMeasurement getLastMeasurement() {
        Instant instant;
        float f;
        Long l = this.storage.getLong(KEY_LAST_FETCH_TIME);
        if (l != null) {
            instant = Instant.Companion.fromEpochSeconds$default(Instant.Companion, l.longValue());
        } else {
            Instant.Companion.getClass();
            instant = Instant.DISTANT_PAST;
        }
        Float f2 = this.storage.getFloat(KEY_TEMPERATURE);
        if (f2 != null) {
            f = f2.floatValue();
        } else {
            f = Float.MIN_VALUE;
        }
        return new TemperatureMeasurement(instant, f);
    }

    public final Spot getLocation() {
        String string = this.storage.getString(KEY_LOCATION);
        if (string != null) {
            Json.Default r1 = Json.Default;
            r1.getClass();
            return (Spot) r1.decodeFromString(BuiltinSerializersKt.getNullable(Spot.Companion.serializer()), string);
        }
        return null;
    }

    public final boolean getUseMinutes() {
        Boolean bool = this.storage.getBoolean(KEY_USE_MINUTES);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final boolean isCelsius() {
        Boolean bool = this.storage.getBoolean(KEY_IS_CELSIUS);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final void setCelsius(boolean z) {
        this.storage.put(KEY_IS_CELSIUS, z);
    }

    public final void setLastMeasurement(TemperatureMeasurement lastTempCelsius) {
        Intrinsics.checkNotNullParameter(lastTempCelsius, "lastTempCelsius");
        this.storage.put(KEY_LAST_FETCH_TIME, lastTempCelsius.getTimeFetched().getEpochSeconds());
        this.storage.put(KEY_TEMPERATURE, lastTempCelsius.getTemperatureCelsius());
    }

    public final void setLocation(Spot spot) {
        BasicStorage basicStorage = this.storage;
        Json.Default r1 = Json.Default;
        r1.getClass();
        basicStorage.put(KEY_LOCATION, r1.encodeToString(BuiltinSerializersKt.getNullable(Spot.Companion.serializer()), spot));
    }

    public final void setUseMinutes(boolean z) {
        this.storage.put(KEY_USE_MINUTES, z);
    }
}
