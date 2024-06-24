package com.animaconnected.watch.storage;

import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.behaviour.temperature.Current;
import com.animaconnected.watch.behaviour.temperature.Daily;
import com.animaconnected.watch.behaviour.temperature.Hourly;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.location.Spot;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: WeatherStorage.kt */
/* loaded from: classes3.dex */
public final class WeatherStorage {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_LAST_FETCH_TS = "lastFetchTimestamp";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_WEATHER_CURRENT = "current";
    private static final String KEY_WEATHER_DAILY = "daily";
    private static final String KEY_WEATHER_HOURLY = "hourly";
    private final BasicStorage storage = ServiceLocator.INSTANCE.getStorageFactory().createStorage("Weather-storage");

    /* compiled from: WeatherStorage.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final /* synthetic */ <T> T decode(String str) {
        if (this.storage.getString(str) == null) {
            return null;
        }
        Json.Default.getClass();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    private final /* synthetic */ <T> void encodeToJson(String str, T t) {
        Json.Default.getClass();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public final Current getCurrent() {
        Object obj;
        String string = this.storage.getString("current");
        if (string != null) {
            Json.Default r1 = Json.Default;
            r1.getClass();
            obj = r1.decodeFromString(BuiltinSerializersKt.getNullable(Current.Companion.serializer()), string);
        } else {
            obj = null;
        }
        return (Current) obj;
    }

    public final List<Daily> getDaily() {
        Object obj;
        String string = this.storage.getString(KEY_WEATHER_DAILY);
        if (string != null) {
            Json.Default r1 = Json.Default;
            r1.getClass();
            obj = r1.decodeFromString(BuiltinSerializersKt.getNullable(new ArrayListSerializer(Daily.Companion.serializer())), string);
        } else {
            obj = null;
        }
        List<Daily> list = (List) obj;
        if (list == null) {
            return EmptyList.INSTANCE;
        }
        return list;
    }

    public final List<Hourly> getHourly() {
        Object obj;
        String string = this.storage.getString(KEY_WEATHER_HOURLY);
        if (string != null) {
            Json.Default r1 = Json.Default;
            r1.getClass();
            obj = r1.decodeFromString(BuiltinSerializersKt.getNullable(new ArrayListSerializer(Hourly.Companion.serializer())), string);
        } else {
            obj = null;
        }
        List<Hourly> list = (List) obj;
        if (list == null) {
            return EmptyList.INSTANCE;
        }
        return list;
    }

    public final Instant getLastMeasurement() {
        Long l = this.storage.getLong(KEY_LAST_FETCH_TS);
        if (l != null) {
            Instant fromEpochSeconds$default = Instant.Companion.fromEpochSeconds$default(Instant.Companion, l.longValue());
            if (fromEpochSeconds$default != null) {
                return fromEpochSeconds$default;
            }
        }
        Instant.Companion.getClass();
        return Instant.DISTANT_PAST;
    }

    public final Spot getLocation() {
        Object obj;
        String string = this.storage.getString(KEY_LOCATION);
        if (string != null) {
            Json.Default r1 = Json.Default;
            r1.getClass();
            obj = r1.decodeFromString(BuiltinSerializersKt.getNullable(Spot.Companion.serializer()), string);
        } else {
            obj = null;
        }
        return (Spot) obj;
    }

    /* renamed from: getTimeSinceLastFetch-UwyO8pc, reason: not valid java name */
    public final long m1570getTimeSinceLastFetchUwyO8pc() {
        Instant.Companion.getClass();
        return new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()")).m1704minus5sfh64U(getLastMeasurement());
    }

    public final void setCurrent(Current current) {
        BasicStorage basicStorage = this.storage;
        Json.Default r1 = Json.Default;
        r1.getClass();
        basicStorage.put("current", r1.encodeToString(BuiltinSerializersKt.getNullable(Current.Companion.serializer()), current));
    }

    public final void setDaily(List<Daily> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        BasicStorage basicStorage = this.storage;
        Json.Default r1 = Json.Default;
        r1.getClass();
        basicStorage.put(KEY_WEATHER_DAILY, r1.encodeToString(new ArrayListSerializer(Daily.Companion.serializer()), value));
    }

    public final void setHourly(List<Hourly> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        BasicStorage basicStorage = this.storage;
        Json.Default r1 = Json.Default;
        r1.getClass();
        basicStorage.put(KEY_WEATHER_HOURLY, r1.encodeToString(new ArrayListSerializer(Hourly.Companion.serializer()), value));
    }

    public final void setLastMeasurement(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        this.storage.put(KEY_LAST_FETCH_TS, instant.getEpochSeconds());
    }

    public final void setLocation(Spot spot) {
        BasicStorage basicStorage = this.storage;
        Json.Default r1 = Json.Default;
        r1.getClass();
        basicStorage.put(KEY_LOCATION, r1.encodeToString(BuiltinSerializersKt.getNullable(Spot.Companion.serializer()), spot));
    }
}
