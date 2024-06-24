package com.animaconnected.watch.behaviour.temperature;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import com.animaconnected.watch.assets.WatchAsset;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: WeatherHttpClient.kt */
@Serializable
/* loaded from: classes3.dex */
public final class WeatherInfo {
    private final WatchAsset asset;
    private final String description;
    private final String icon;
    private final int id;
    private final String main;
    private final WatchAsset smallAsset;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.assets.WatchAsset", WatchAsset.values()), EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.assets.WatchAsset", WatchAsset.values())};

    /* compiled from: WeatherHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<WeatherInfo> serializer() {
            return WeatherInfo$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public WeatherInfo(String str, String str2, int r9, String str3) {
        WatchAsset weatherWatchAsset;
        WatchAsset weatherSmallWatchAsset;
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, DetailBottomDialog.keyDescription, str2, "icon", str3, AnalyticsConstants.KEY_MAIN);
        this.description = str;
        this.icon = str2;
        this.id = r9;
        this.main = str3;
        weatherWatchAsset = WeatherHttpClientKt.getWeatherWatchAsset(WeatherHttpClientKt.mapIdToWeather(str2));
        this.asset = weatherWatchAsset;
        weatherSmallWatchAsset = WeatherHttpClientKt.getWeatherSmallWatchAsset(WeatherHttpClientKt.mapIdToWeather(str2));
        this.smallAsset = weatherSmallWatchAsset;
    }

    public static /* synthetic */ WeatherInfo copy$default(WeatherInfo weatherInfo, String str, String str2, int r3, String str3, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = weatherInfo.description;
        }
        if ((r5 & 2) != 0) {
            str2 = weatherInfo.icon;
        }
        if ((r5 & 4) != 0) {
            r3 = weatherInfo.id;
        }
        if ((r5 & 8) != 0) {
            str3 = weatherInfo.main;
        }
        return weatherInfo.copy(str, str2, r3, str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004f, code lost:            if (r1 != r4) goto L16;     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void write$Self$watch_release(com.animaconnected.watch.behaviour.temperature.WeatherInfo r6, kotlinx.serialization.encoding.CompositeEncoder r7, kotlinx.serialization.descriptors.SerialDescriptor r8) {
        /*
            kotlinx.serialization.KSerializer<java.lang.Object>[] r0 = com.animaconnected.watch.behaviour.temperature.WeatherInfo.$childSerializers
            java.lang.String r1 = r6.description
            r2 = 0
            r7.encodeStringElement(r8, r2, r1)
            java.lang.String r1 = r6.icon
            r3 = 1
            r7.encodeStringElement(r8, r3, r1)
            r1 = 2
            int r4 = r6.id
            r7.encodeIntElement(r1, r4, r8)
            r1 = 3
            java.lang.String r4 = r6.main
            r7.encodeStringElement(r8, r1, r4)
            boolean r1 = r7.shouldEncodeElementDefault(r8)
            if (r1 == 0) goto L21
            goto L2f
        L21:
            com.animaconnected.watch.assets.WatchAsset r1 = r6.asset
            java.lang.String r4 = r6.icon
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r4 = com.animaconnected.watch.behaviour.temperature.WeatherHttpClientKt.mapIdToWeather(r4)
            com.animaconnected.watch.assets.WatchAsset r4 = com.animaconnected.watch.behaviour.temperature.WeatherHttpClientKt.access$getWeatherWatchAsset(r4)
            if (r1 == r4) goto L31
        L2f:
            r1 = r3
            goto L32
        L31:
            r1 = r2
        L32:
            if (r1 == 0) goto L3c
            r1 = 4
            r4 = r0[r1]
            com.animaconnected.watch.assets.WatchAsset r5 = r6.asset
            r7.encodeNullableSerializableElement(r8, r1, r4, r5)
        L3c:
            boolean r1 = r7.shouldEncodeElementDefault(r8)
            if (r1 == 0) goto L43
            goto L51
        L43:
            com.animaconnected.watch.assets.WatchAsset r1 = r6.smallAsset
            java.lang.String r4 = r6.icon
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r4 = com.animaconnected.watch.behaviour.temperature.WeatherHttpClientKt.mapIdToWeather(r4)
            com.animaconnected.watch.assets.WatchAsset r4 = com.animaconnected.watch.behaviour.temperature.WeatherHttpClientKt.access$getWeatherSmallWatchAsset(r4)
            if (r1 == r4) goto L52
        L51:
            r2 = r3
        L52:
            if (r2 == 0) goto L5c
            r1 = 5
            r0 = r0[r1]
            com.animaconnected.watch.assets.WatchAsset r6 = r6.smallAsset
            r7.encodeNullableSerializableElement(r8, r1, r0, r6)
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.temperature.WeatherInfo.write$Self$watch_release(com.animaconnected.watch.behaviour.temperature.WeatherInfo, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public final String component1() {
        return this.description;
    }

    public final String component2() {
        return this.icon;
    }

    public final int component3() {
        return this.id;
    }

    public final String component4() {
        return this.main;
    }

    public final WeatherInfo copy(String description, String icon, int r4, String main) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(main, "main");
        return new WeatherInfo(description, icon, r4, main);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeatherInfo)) {
            return false;
        }
        WeatherInfo weatherInfo = (WeatherInfo) obj;
        if (Intrinsics.areEqual(this.description, weatherInfo.description) && Intrinsics.areEqual(this.icon, weatherInfo.icon) && this.id == weatherInfo.id && Intrinsics.areEqual(this.main, weatherInfo.main)) {
            return true;
        }
        return false;
    }

    public final WatchAsset getAsset() {
        return this.asset;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMain() {
        return this.main;
    }

    public final WatchAsset getSmallAsset() {
        return this.smallAsset;
    }

    public int hashCode() {
        return this.main.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.id, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.icon, this.description.hashCode() * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WeatherInfo(description=");
        sb.append(this.description);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", main=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.main, ')');
    }

    public /* synthetic */ WeatherInfo(int r2, String str, String str2, int r5, String str3, WatchAsset watchAsset, WatchAsset watchAsset2, SerializationConstructorMarker serializationConstructorMarker) {
        WatchAsset weatherSmallWatchAsset;
        WatchAsset weatherWatchAsset;
        if (15 != (r2 & 15)) {
            zzac.throwMissingFieldException(r2, 15, WeatherInfo$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.description = str;
        this.icon = str2;
        this.id = r5;
        this.main = str3;
        if ((r2 & 16) == 0) {
            weatherWatchAsset = WeatherHttpClientKt.getWeatherWatchAsset(WeatherHttpClientKt.mapIdToWeather(str2));
            this.asset = weatherWatchAsset;
        } else {
            this.asset = watchAsset;
        }
        if ((r2 & 32) != 0) {
            this.smallAsset = watchAsset2;
        } else {
            weatherSmallWatchAsset = WeatherHttpClientKt.getWeatherSmallWatchAsset(WeatherHttpClientKt.mapIdToWeather(str2));
            this.smallAsset = weatherSmallWatchAsset;
        }
    }
}
