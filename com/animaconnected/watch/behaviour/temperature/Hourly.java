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
public final class Hourly {
    private final WatchAsset bigAsset;
    private final long dt;
    private final Instant instant;
    private final WatchAsset smallAsset;
    private final double temp;
    private final List<WeatherInfo> weather;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(WeatherInfo$$serializer.INSTANCE), null, EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.assets.WatchAsset", WatchAsset.values()), EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.assets.WatchAsset", WatchAsset.values())};

    /* compiled from: WeatherHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Hourly> serializer() {
            return Hourly$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Hourly(int r3, long j, double d, List list, Instant instant, WatchAsset watchAsset, WatchAsset watchAsset2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (r3 & 7)) {
            zzac.throwMissingFieldException(r3, 7, Hourly$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.dt = j;
        this.temp = d;
        this.weather = list;
        this.instant = (r3 & 8) == 0 ? Instant.Companion.fromEpochSeconds$default(Instant.Companion, j) : instant;
        if ((r3 & 16) == 0) {
            WeatherInfo weatherInfo = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull(list);
            watchAsset = weatherInfo != null ? weatherInfo.getSmallAsset() : null;
        }
        this.smallAsset = watchAsset;
        if ((r3 & 32) != 0) {
            this.bigAsset = watchAsset2;
        } else {
            WeatherInfo weatherInfo2 = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull(list);
            this.bigAsset = weatherInfo2 != null ? weatherInfo2.getAsset() : null;
        }
    }

    public static /* synthetic */ Hourly copy$default(Hourly hourly, long j, double d, List list, int r12, Object obj) {
        if ((r12 & 1) != 0) {
            j = hourly.dt;
        }
        long j2 = j;
        if ((r12 & 2) != 0) {
            d = hourly.temp;
        }
        double d2 = d;
        if ((r12 & 4) != 0) {
            list = hourly.weather;
        }
        return hourly.copy(j2, d2, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007a, code lost:            if (r1 != r2) goto L30;     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void write$Self$watch_release(com.animaconnected.watch.behaviour.temperature.Hourly r7, kotlinx.serialization.encoding.CompositeEncoder r8, kotlinx.serialization.descriptors.SerialDescriptor r9) {
        /*
            kotlinx.serialization.KSerializer<java.lang.Object>[] r0 = com.animaconnected.watch.behaviour.temperature.Hourly.$childSerializers
            long r1 = r7.dt
            r3 = 0
            r8.encodeLongElement(r9, r3, r1)
            double r1 = r7.temp
            r4 = 1
            r8.encodeDoubleElement(r9, r4, r1)
            r1 = 2
            r2 = r0[r1]
            java.util.List<com.animaconnected.watch.behaviour.temperature.WeatherInfo> r5 = r7.weather
            r8.encodeSerializableElement(r9, r1, r2, r5)
            boolean r1 = r8.shouldEncodeElementDefault(r9)
            if (r1 == 0) goto L1d
            goto L2d
        L1d:
            kotlinx.datetime.Instant r1 = r7.instant
            kotlinx.datetime.Instant$Companion r2 = kotlinx.datetime.Instant.Companion
            long r5 = r7.dt
            kotlinx.datetime.Instant r2 = kotlinx.datetime.Instant.Companion.fromEpochSeconds$default(r2, r5)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 != 0) goto L2f
        L2d:
            r1 = r4
            goto L30
        L2f:
            r1 = r3
        L30:
            if (r1 == 0) goto L3a
            kotlinx.datetime.serializers.InstantIso8601Serializer r1 = kotlinx.datetime.serializers.InstantIso8601Serializer.INSTANCE
            kotlinx.datetime.Instant r2 = r7.instant
            r5 = 3
            r8.encodeSerializableElement(r9, r5, r1, r2)
        L3a:
            boolean r1 = r8.shouldEncodeElementDefault(r9)
            r2 = 0
            if (r1 == 0) goto L42
            goto L56
        L42:
            com.animaconnected.watch.assets.WatchAsset r1 = r7.smallAsset
            java.util.List<com.animaconnected.watch.behaviour.temperature.WeatherInfo> r5 = r7.weather
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r5)
            com.animaconnected.watch.behaviour.temperature.WeatherInfo r5 = (com.animaconnected.watch.behaviour.temperature.WeatherInfo) r5
            if (r5 == 0) goto L53
            com.animaconnected.watch.assets.WatchAsset r5 = r5.getSmallAsset()
            goto L54
        L53:
            r5 = r2
        L54:
            if (r1 == r5) goto L58
        L56:
            r1 = r4
            goto L59
        L58:
            r1 = r3
        L59:
            if (r1 == 0) goto L63
            r1 = 4
            r5 = r0[r1]
            com.animaconnected.watch.assets.WatchAsset r6 = r7.smallAsset
            r8.encodeNullableSerializableElement(r9, r1, r5, r6)
        L63:
            boolean r1 = r8.shouldEncodeElementDefault(r9)
            if (r1 == 0) goto L6a
            goto L7c
        L6a:
            com.animaconnected.watch.assets.WatchAsset r1 = r7.bigAsset
            java.util.List<com.animaconnected.watch.behaviour.temperature.WeatherInfo> r5 = r7.weather
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r5)
            com.animaconnected.watch.behaviour.temperature.WeatherInfo r5 = (com.animaconnected.watch.behaviour.temperature.WeatherInfo) r5
            if (r5 == 0) goto L7a
            com.animaconnected.watch.assets.WatchAsset r2 = r5.getAsset()
        L7a:
            if (r1 == r2) goto L7d
        L7c:
            r3 = r4
        L7d:
            if (r3 == 0) goto L87
            r1 = 5
            r0 = r0[r1]
            com.animaconnected.watch.assets.WatchAsset r7 = r7.bigAsset
            r8.encodeNullableSerializableElement(r9, r1, r0, r7)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.temperature.Hourly.write$Self$watch_release(com.animaconnected.watch.behaviour.temperature.Hourly, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public final long component1() {
        return this.dt;
    }

    public final double component2() {
        return this.temp;
    }

    public final List<WeatherInfo> component3() {
        return this.weather;
    }

    public final Hourly copy(long j, double d, List<WeatherInfo> weather) {
        Intrinsics.checkNotNullParameter(weather, "weather");
        return new Hourly(j, d, weather);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Hourly)) {
            return false;
        }
        Hourly hourly = (Hourly) obj;
        if (this.dt == hourly.dt && Double.compare(this.temp, hourly.temp) == 0 && Intrinsics.areEqual(this.weather, hourly.weather)) {
            return true;
        }
        return false;
    }

    public final WatchAsset getBigAsset() {
        return this.bigAsset;
    }

    public final long getDt() {
        return this.dt;
    }

    public final Instant getInstant() {
        return this.instant;
    }

    public final WatchAsset getSmallAsset() {
        return this.smallAsset;
    }

    public final double getTemp() {
        return this.temp;
    }

    public final List<WeatherInfo> getWeather() {
        return this.weather;
    }

    public int hashCode() {
        return this.weather.hashCode() + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.temp, Long.hashCode(this.dt) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Hourly(dt=");
        sb.append(this.dt);
        sb.append(", temp=");
        sb.append(this.temp);
        sb.append(", weather=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.weather, ')');
    }

    public Hourly(long j, double d, List<WeatherInfo> weather) {
        Intrinsics.checkNotNullParameter(weather, "weather");
        this.dt = j;
        this.temp = d;
        this.weather = weather;
        this.instant = Instant.Companion.fromEpochSeconds$default(Instant.Companion, j);
        WeatherInfo weatherInfo = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull((List) weather);
        this.smallAsset = weatherInfo != null ? weatherInfo.getSmallAsset() : null;
        WeatherInfo weatherInfo2 = (WeatherInfo) CollectionsKt___CollectionsKt.firstOrNull((List) weather);
        this.bigAsset = weatherInfo2 != null ? weatherInfo2.getAsset() : null;
    }
}
