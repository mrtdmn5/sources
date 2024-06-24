package com.animaconnected.watch.behaviour.temperature;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.animaconnected.watch.assets.WatchAsset;
import com.google.android.gms.tasks.zzac;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: WeatherHttpClient.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Current {
    private final WatchAsset asset;
    private final long dt;
    private final String iconId;
    private final Instant instant;
    private final double temp;
    private final double uvi;
    private final List<WeatherInfo> weather;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(WeatherInfo$$serializer.INSTANCE), null, EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.assets.WatchAsset", WatchAsset.values()), null};

    /* compiled from: WeatherHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Current> serializer() {
            return Current$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Current(int r3, long j, double d, double d2, List list, Instant instant, WatchAsset watchAsset, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (r3 & 15)) {
            zzac.throwMissingFieldException(r3, 15, Current$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.dt = j;
        this.temp = d;
        this.uvi = d2;
        this.weather = list;
        this.instant = (r3 & 16) == 0 ? Instant.Companion.fromEpochSeconds$default(Instant.Companion, j) : instant;
        if ((r3 & 32) == 0) {
            WeatherInfo weatherInfo = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull(list);
            watchAsset = weatherInfo != null ? weatherInfo.getAsset() : null;
        }
        this.asset = watchAsset;
        if ((r3 & 64) != 0) {
            this.iconId = str;
        } else {
            WeatherInfo weatherInfo2 = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull(list);
            this.iconId = weatherInfo2 != null ? weatherInfo2.getIcon() : null;
        }
    }

    public static /* synthetic */ Current copy$default(Current current, long j, double d, double d2, List list, int r16, Object obj) {
        long j2;
        double d3;
        double d4;
        List list2;
        if ((r16 & 1) != 0) {
            j2 = current.dt;
        } else {
            j2 = j;
        }
        if ((r16 & 2) != 0) {
            d3 = current.temp;
        } else {
            d3 = d;
        }
        if ((r16 & 4) != 0) {
            d4 = current.uvi;
        } else {
            d4 = d2;
        }
        if ((r16 & 8) != 0) {
            list2 = current.weather;
        } else {
            list2 = list;
        }
        return current.copy(j2, d3, d4, list2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r2) == false) goto L31;     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void write$Self$watch_release(com.animaconnected.watch.behaviour.temperature.Current r7, kotlinx.serialization.encoding.CompositeEncoder r8, kotlinx.serialization.descriptors.SerialDescriptor r9) {
        /*
            kotlinx.serialization.KSerializer<java.lang.Object>[] r0 = com.animaconnected.watch.behaviour.temperature.Current.$childSerializers
            long r1 = r7.dt
            r3 = 0
            r8.encodeLongElement(r9, r3, r1)
            double r1 = r7.temp
            r4 = 1
            r8.encodeDoubleElement(r9, r4, r1)
            r1 = 2
            double r5 = r7.uvi
            r8.encodeDoubleElement(r9, r1, r5)
            r1 = 3
            r2 = r0[r1]
            java.util.List<com.animaconnected.watch.behaviour.temperature.WeatherInfo> r5 = r7.weather
            r8.encodeSerializableElement(r9, r1, r2, r5)
            boolean r1 = r8.shouldEncodeElementDefault(r9)
            if (r1 == 0) goto L23
            goto L33
        L23:
            kotlinx.datetime.Instant r1 = r7.instant
            kotlinx.datetime.Instant$Companion r2 = kotlinx.datetime.Instant.Companion
            long r5 = r7.dt
            kotlinx.datetime.Instant r2 = kotlinx.datetime.Instant.Companion.fromEpochSeconds$default(r2, r5)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 != 0) goto L35
        L33:
            r1 = r4
            goto L36
        L35:
            r1 = r3
        L36:
            if (r1 == 0) goto L40
            kotlinx.datetime.serializers.InstantIso8601Serializer r1 = kotlinx.datetime.serializers.InstantIso8601Serializer.INSTANCE
            kotlinx.datetime.Instant r2 = r7.instant
            r5 = 4
            r8.encodeSerializableElement(r9, r5, r1, r2)
        L40:
            boolean r1 = r8.shouldEncodeElementDefault(r9)
            r2 = 0
            if (r1 == 0) goto L48
            goto L5c
        L48:
            com.animaconnected.watch.assets.WatchAsset r1 = r7.asset
            java.util.List<com.animaconnected.watch.behaviour.temperature.WeatherInfo> r5 = r7.weather
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r5)
            com.animaconnected.watch.behaviour.temperature.WeatherInfo r5 = (com.animaconnected.watch.behaviour.temperature.WeatherInfo) r5
            if (r5 == 0) goto L59
            com.animaconnected.watch.assets.WatchAsset r5 = r5.getAsset()
            goto L5a
        L59:
            r5 = r2
        L5a:
            if (r1 == r5) goto L5e
        L5c:
            r1 = r4
            goto L5f
        L5e:
            r1 = r3
        L5f:
            if (r1 == 0) goto L69
            r1 = 5
            r0 = r0[r1]
            com.animaconnected.watch.assets.WatchAsset r5 = r7.asset
            r8.encodeNullableSerializableElement(r9, r1, r0, r5)
        L69:
            boolean r0 = r8.shouldEncodeElementDefault(r9)
            if (r0 == 0) goto L70
            goto L86
        L70:
            java.lang.String r0 = r7.iconId
            java.util.List<com.animaconnected.watch.behaviour.temperature.WeatherInfo> r1 = r7.weather
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r1)
            com.animaconnected.watch.behaviour.temperature.WeatherInfo r1 = (com.animaconnected.watch.behaviour.temperature.WeatherInfo) r1
            if (r1 == 0) goto L80
            java.lang.String r2 = r1.getIcon()
        L80:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 != 0) goto L87
        L86:
            r3 = r4
        L87:
            if (r3 == 0) goto L91
            kotlinx.serialization.internal.StringSerializer r0 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.String r7 = r7.iconId
            r1 = 6
            r8.encodeNullableSerializableElement(r9, r1, r0, r7)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.temperature.Current.write$Self$watch_release(com.animaconnected.watch.behaviour.temperature.Current, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public final long component1() {
        return this.dt;
    }

    public final double component2() {
        return this.temp;
    }

    public final double component3() {
        return this.uvi;
    }

    public final List<WeatherInfo> component4() {
        return this.weather;
    }

    public final Current copy(long j, double d, double d2, List<WeatherInfo> weather) {
        Intrinsics.checkNotNullParameter(weather, "weather");
        return new Current(j, d, d2, weather);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Current)) {
            return false;
        }
        Current current = (Current) obj;
        if (this.dt == current.dt && Double.compare(this.temp, current.temp) == 0 && Double.compare(this.uvi, current.uvi) == 0 && Intrinsics.areEqual(this.weather, current.weather)) {
            return true;
        }
        return false;
    }

    public final WatchAsset getAsset() {
        return this.asset;
    }

    public final long getDt() {
        return this.dt;
    }

    public final String getIconId() {
        return this.iconId;
    }

    public final Instant getInstant() {
        return this.instant;
    }

    public final double getTemp() {
        return this.temp;
    }

    public final double getUvi() {
        return this.uvi;
    }

    public final List<WeatherInfo> getWeather() {
        return this.weather;
    }

    public int hashCode() {
        return this.weather.hashCode() + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.uvi, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.temp, Long.hashCode(this.dt) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Current(dt=");
        sb.append(this.dt);
        sb.append(", temp=");
        sb.append(this.temp);
        sb.append(", uvi=");
        sb.append(this.uvi);
        sb.append(", weather=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.weather, ')');
    }

    public Current(long j, double d, double d2, List<WeatherInfo> weather) {
        Intrinsics.checkNotNullParameter(weather, "weather");
        this.dt = j;
        this.temp = d;
        this.uvi = d2;
        this.weather = weather;
        this.instant = Instant.Companion.fromEpochSeconds$default(Instant.Companion, j);
        WeatherInfo weatherInfo = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull((List) weather);
        this.asset = weatherInfo != null ? weatherInfo.getAsset() : null;
        WeatherInfo weatherInfo2 = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull((List) weather);
        this.iconId = weatherInfo2 != null ? weatherInfo2.getIcon() : null;
    }
}
