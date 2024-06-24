package com.animaconnected.watch.behaviour.temperature;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.fitness.TimePeriod;
import com.google.android.gms.tasks.zzac;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: WeatherHttpClient.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Daily {
    private final WatchAsset asset;
    private final long dt;
    private final String iconId;
    private final Instant instant;
    private final double pop;
    private final WatchAsset smallAsset;
    private final Temp temp;
    private final double uvi;
    private final List<WeatherInfo> weather;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, new ArrayListSerializer(WeatherInfo$$serializer.INSTANCE), null, EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.assets.WatchAsset", WatchAsset.values()), EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.assets.WatchAsset", WatchAsset.values()), null};

    /* compiled from: WeatherHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Daily> serializer() {
            return Daily$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Daily(int r8, long j, Temp temp, double d, double d2, List list, Instant instant, WatchAsset watchAsset, WatchAsset watchAsset2, String str, SerializationConstructorMarker serializationConstructorMarker) {
        WatchAsset watchAsset3;
        WatchAsset watchAsset4;
        if (31 != (r8 & 31)) {
            zzac.throwMissingFieldException(r8, 31, Daily$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.dt = j;
        this.temp = temp;
        this.pop = d;
        this.uvi = d2;
        this.weather = list;
        this.instant = (r8 & 32) == 0 ? Instant.Companion.fromEpochSeconds$default(Instant.Companion, j) : instant;
        if ((r8 & 64) == 0) {
            WeatherInfo weatherInfo = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull(list);
            watchAsset3 = weatherInfo != null ? weatherInfo.getAsset() : null;
        } else {
            watchAsset3 = watchAsset;
        }
        this.asset = watchAsset3;
        if ((r8 & 128) == 0) {
            WeatherInfo weatherInfo2 = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull(list);
            watchAsset4 = weatherInfo2 != null ? weatherInfo2.getSmallAsset() : null;
        } else {
            watchAsset4 = watchAsset2;
        }
        this.smallAsset = watchAsset4;
        if ((r8 & 256) != 0) {
            this.iconId = str;
        } else {
            WeatherInfo weatherInfo3 = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull(list);
            this.iconId = weatherInfo3 != null ? weatherInfo3.getIcon() : null;
        }
    }

    public static /* synthetic */ Daily copy$default(Daily daily, long j, Temp temp, double d, double d2, List list, int r18, Object obj) {
        long j2;
        Temp temp2;
        double d3;
        double d4;
        List list2;
        if ((r18 & 1) != 0) {
            j2 = daily.dt;
        } else {
            j2 = j;
        }
        if ((r18 & 2) != 0) {
            temp2 = daily.temp;
        } else {
            temp2 = temp;
        }
        if ((r18 & 4) != 0) {
            d3 = daily.pop;
        } else {
            d3 = d;
        }
        if ((r18 & 8) != 0) {
            d4 = daily.uvi;
        } else {
            d4 = d2;
        }
        if ((r18 & 16) != 0) {
            list2 = daily.weather;
        } else {
            list2 = list;
        }
        return daily.copy(j2, temp2, d3, d4, list2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b4, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r2) == false) goto L43;     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void write$Self$watch_release(com.animaconnected.watch.behaviour.temperature.Daily r7, kotlinx.serialization.encoding.CompositeEncoder r8, kotlinx.serialization.descriptors.SerialDescriptor r9) {
        /*
            kotlinx.serialization.KSerializer<java.lang.Object>[] r0 = com.animaconnected.watch.behaviour.temperature.Daily.$childSerializers
            long r1 = r7.dt
            r3 = 0
            r8.encodeLongElement(r9, r3, r1)
            com.animaconnected.watch.behaviour.temperature.Temp$$serializer r1 = com.animaconnected.watch.behaviour.temperature.Temp$$serializer.INSTANCE
            com.animaconnected.watch.behaviour.temperature.Temp r2 = r7.temp
            r4 = 1
            r8.encodeSerializableElement(r9, r4, r1, r2)
            r1 = 2
            double r5 = r7.pop
            r8.encodeDoubleElement(r9, r1, r5)
            r1 = 3
            double r5 = r7.uvi
            r8.encodeDoubleElement(r9, r1, r5)
            r1 = 4
            r2 = r0[r1]
            java.util.List<com.animaconnected.watch.behaviour.temperature.WeatherInfo> r5 = r7.weather
            r8.encodeSerializableElement(r9, r1, r2, r5)
            boolean r1 = r8.shouldEncodeElementDefault(r9)
            if (r1 == 0) goto L2b
            goto L3b
        L2b:
            kotlinx.datetime.Instant r1 = r7.instant
            kotlinx.datetime.Instant$Companion r2 = kotlinx.datetime.Instant.Companion
            long r5 = r7.dt
            kotlinx.datetime.Instant r2 = kotlinx.datetime.Instant.Companion.fromEpochSeconds$default(r2, r5)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 != 0) goto L3d
        L3b:
            r1 = r4
            goto L3e
        L3d:
            r1 = r3
        L3e:
            if (r1 == 0) goto L48
            kotlinx.datetime.serializers.InstantIso8601Serializer r1 = kotlinx.datetime.serializers.InstantIso8601Serializer.INSTANCE
            kotlinx.datetime.Instant r2 = r7.instant
            r5 = 5
            r8.encodeSerializableElement(r9, r5, r1, r2)
        L48:
            boolean r1 = r8.shouldEncodeElementDefault(r9)
            r2 = 0
            if (r1 == 0) goto L50
            goto L64
        L50:
            com.animaconnected.watch.assets.WatchAsset r1 = r7.asset
            java.util.List<com.animaconnected.watch.behaviour.temperature.WeatherInfo> r5 = r7.weather
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r5)
            com.animaconnected.watch.behaviour.temperature.WeatherInfo r5 = (com.animaconnected.watch.behaviour.temperature.WeatherInfo) r5
            if (r5 == 0) goto L61
            com.animaconnected.watch.assets.WatchAsset r5 = r5.getAsset()
            goto L62
        L61:
            r5 = r2
        L62:
            if (r1 == r5) goto L66
        L64:
            r1 = r4
            goto L67
        L66:
            r1 = r3
        L67:
            if (r1 == 0) goto L71
            r1 = 6
            r5 = r0[r1]
            com.animaconnected.watch.assets.WatchAsset r6 = r7.asset
            r8.encodeNullableSerializableElement(r9, r1, r5, r6)
        L71:
            boolean r1 = r8.shouldEncodeElementDefault(r9)
            if (r1 == 0) goto L78
            goto L8c
        L78:
            com.animaconnected.watch.assets.WatchAsset r1 = r7.smallAsset
            java.util.List<com.animaconnected.watch.behaviour.temperature.WeatherInfo> r5 = r7.weather
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r5)
            com.animaconnected.watch.behaviour.temperature.WeatherInfo r5 = (com.animaconnected.watch.behaviour.temperature.WeatherInfo) r5
            if (r5 == 0) goto L89
            com.animaconnected.watch.assets.WatchAsset r5 = r5.getSmallAsset()
            goto L8a
        L89:
            r5 = r2
        L8a:
            if (r1 == r5) goto L8e
        L8c:
            r1 = r4
            goto L8f
        L8e:
            r1 = r3
        L8f:
            if (r1 == 0) goto L99
            r1 = 7
            r0 = r0[r1]
            com.animaconnected.watch.assets.WatchAsset r5 = r7.smallAsset
            r8.encodeNullableSerializableElement(r9, r1, r0, r5)
        L99:
            boolean r0 = r8.shouldEncodeElementDefault(r9)
            if (r0 == 0) goto La0
            goto Lb6
        La0:
            java.lang.String r0 = r7.iconId
            java.util.List<com.animaconnected.watch.behaviour.temperature.WeatherInfo> r1 = r7.weather
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r1)
            com.animaconnected.watch.behaviour.temperature.WeatherInfo r1 = (com.animaconnected.watch.behaviour.temperature.WeatherInfo) r1
            if (r1 == 0) goto Lb0
            java.lang.String r2 = r1.getIcon()
        Lb0:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 != 0) goto Lb7
        Lb6:
            r3 = r4
        Lb7:
            if (r3 == 0) goto Lc2
            kotlinx.serialization.internal.StringSerializer r0 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.String r7 = r7.iconId
            r1 = 8
            r8.encodeNullableSerializableElement(r9, r1, r0, r7)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.temperature.Daily.write$Self$watch_release(com.animaconnected.watch.behaviour.temperature.Daily, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public final long component1() {
        return this.dt;
    }

    public final Temp component2() {
        return this.temp;
    }

    public final double component3() {
        return this.pop;
    }

    public final double component4() {
        return this.uvi;
    }

    public final List<WeatherInfo> component5() {
        return this.weather;
    }

    public final Daily copy(long j, Temp temp, double d, double d2, List<WeatherInfo> weather) {
        Intrinsics.checkNotNullParameter(temp, "temp");
        Intrinsics.checkNotNullParameter(weather, "weather");
        return new Daily(j, temp, d, d2, weather);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Daily)) {
            return false;
        }
        Daily daily = (Daily) obj;
        if (this.dt == daily.dt && Intrinsics.areEqual(this.temp, daily.temp) && Double.compare(this.pop, daily.pop) == 0 && Double.compare(this.uvi, daily.uvi) == 0 && Intrinsics.areEqual(this.weather, daily.weather)) {
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

    public final double getPop() {
        return this.pop;
    }

    public final WatchAsset getSmallAsset() {
        return this.smallAsset;
    }

    public final Temp getTemp() {
        return this.temp;
    }

    public final TimePeriod getTimePeriod() {
        TimePeriod.Companion companion = TimePeriod.Companion;
        Instant instant = this.instant;
        TimeZone.Companion.getClass();
        return companion.day(instant, TimeZone.UTC);
    }

    public final double getUvi() {
        return this.uvi;
    }

    public final List<WeatherInfo> getWeather() {
        return this.weather;
    }

    public int hashCode() {
        return this.weather.hashCode() + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.uvi, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.pop, (this.temp.hashCode() + (Long.hashCode(this.dt) * 31)) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Daily(dt=");
        sb.append(this.dt);
        sb.append(", temp=");
        sb.append(this.temp);
        sb.append(", pop=");
        sb.append(this.pop);
        sb.append(", uvi=");
        sb.append(this.uvi);
        sb.append(", weather=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.weather, ')');
    }

    public Daily(long j, Temp temp, double d, double d2, List<WeatherInfo> weather) {
        Intrinsics.checkNotNullParameter(temp, "temp");
        Intrinsics.checkNotNullParameter(weather, "weather");
        this.dt = j;
        this.temp = temp;
        this.pop = d;
        this.uvi = d2;
        this.weather = weather;
        this.instant = Instant.Companion.fromEpochSeconds$default(Instant.Companion, j);
        WeatherInfo weatherInfo = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull((List) weather);
        this.asset = weatherInfo != null ? weatherInfo.getAsset() : null;
        WeatherInfo weatherInfo2 = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull((List) weather);
        this.smallAsset = weatherInfo2 != null ? weatherInfo2.getSmallAsset() : null;
        WeatherInfo weatherInfo3 = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull((List) weather);
        this.iconId = weatherInfo3 != null ? weatherInfo3.getIcon() : null;
    }
}
