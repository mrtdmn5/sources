package com.animaconnected.watch.provider.weather;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeatherViewModel.kt */
/* loaded from: classes3.dex */
public final class TodayForecast {
    private final Mitmap icon;
    private final Mitmap iconSmall;
    private final String maxTemp;
    private final String minTemp;
    private final String rain;
    private final String uv;
    private final String weekDay;

    public TodayForecast() {
        this(null, null, null, null, null, null, null, R.styleable.AppTheme_statusTextH5, null);
    }

    public static /* synthetic */ TodayForecast copy$default(TodayForecast todayForecast, String str, String str2, String str3, String str4, String str5, Mitmap mitmap, Mitmap mitmap2, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            str = todayForecast.weekDay;
        }
        if ((r13 & 2) != 0) {
            str2 = todayForecast.maxTemp;
        }
        String str6 = str2;
        if ((r13 & 4) != 0) {
            str3 = todayForecast.minTemp;
        }
        String str7 = str3;
        if ((r13 & 8) != 0) {
            str4 = todayForecast.rain;
        }
        String str8 = str4;
        if ((r13 & 16) != 0) {
            str5 = todayForecast.uv;
        }
        String str9 = str5;
        if ((r13 & 32) != 0) {
            mitmap = todayForecast.icon;
        }
        Mitmap mitmap3 = mitmap;
        if ((r13 & 64) != 0) {
            mitmap2 = todayForecast.iconSmall;
        }
        return todayForecast.copy(str, str6, str7, str8, str9, mitmap3, mitmap2);
    }

    public final String component1() {
        return this.weekDay;
    }

    public final String component2() {
        return this.maxTemp;
    }

    public final String component3() {
        return this.minTemp;
    }

    public final String component4() {
        return this.rain;
    }

    public final String component5() {
        return this.uv;
    }

    public final Mitmap component6() {
        return this.icon;
    }

    public final Mitmap component7() {
        return this.iconSmall;
    }

    public final TodayForecast copy(String weekDay, String maxTemp, String minTemp, String rain, String uv, Mitmap icon, Mitmap iconSmall) {
        Intrinsics.checkNotNullParameter(weekDay, "weekDay");
        Intrinsics.checkNotNullParameter(maxTemp, "maxTemp");
        Intrinsics.checkNotNullParameter(minTemp, "minTemp");
        Intrinsics.checkNotNullParameter(rain, "rain");
        Intrinsics.checkNotNullParameter(uv, "uv");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(iconSmall, "iconSmall");
        return new TodayForecast(weekDay, maxTemp, minTemp, rain, uv, icon, iconSmall);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TodayForecast)) {
            return false;
        }
        TodayForecast todayForecast = (TodayForecast) obj;
        if (Intrinsics.areEqual(this.weekDay, todayForecast.weekDay) && Intrinsics.areEqual(this.maxTemp, todayForecast.maxTemp) && Intrinsics.areEqual(this.minTemp, todayForecast.minTemp) && Intrinsics.areEqual(this.rain, todayForecast.rain) && Intrinsics.areEqual(this.uv, todayForecast.uv) && Intrinsics.areEqual(this.icon, todayForecast.icon) && Intrinsics.areEqual(this.iconSmall, todayForecast.iconSmall)) {
            return true;
        }
        return false;
    }

    public final Mitmap getIcon() {
        return this.icon;
    }

    public final Mitmap getIconSmall() {
        return this.iconSmall;
    }

    public final String getMaxTemp() {
        return this.maxTemp;
    }

    public final String getMinTemp() {
        return this.minTemp;
    }

    public final String getRain() {
        return this.rain;
    }

    public final String getUv() {
        return this.uv;
    }

    public final String getWeekDay() {
        return this.weekDay;
    }

    public int hashCode() {
        return this.iconSmall.hashCode() + ((this.icon.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.uv, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.rain, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.minTemp, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.maxTemp, this.weekDay.hashCode() * 31, 31), 31), 31), 31)) * 31);
    }

    public String toString() {
        return "TodayForecast(weekDay=" + this.weekDay + ", maxTemp=" + this.maxTemp + ", minTemp=" + this.minTemp + ", rain=" + this.rain + ", uv=" + this.uv + ", icon=" + this.icon + ", iconSmall=" + this.iconSmall + ')';
    }

    public TodayForecast(String weekDay, String maxTemp, String minTemp, String rain, String uv, Mitmap icon, Mitmap iconSmall) {
        Intrinsics.checkNotNullParameter(weekDay, "weekDay");
        Intrinsics.checkNotNullParameter(maxTemp, "maxTemp");
        Intrinsics.checkNotNullParameter(minTemp, "minTemp");
        Intrinsics.checkNotNullParameter(rain, "rain");
        Intrinsics.checkNotNullParameter(uv, "uv");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(iconSmall, "iconSmall");
        this.weekDay = weekDay;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.rain = rain;
        this.uv = uv;
        this.icon = icon;
        this.iconSmall = iconSmall;
    }

    public /* synthetic */ TodayForecast(String str, String str2, String str3, String str4, String str5, Mitmap mitmap, Mitmap mitmap2, int r13, DefaultConstructorMarker defaultConstructorMarker) {
        this((r13 & 1) != 0 ? "-" : str, (r13 & 2) != 0 ? "-" : str2, (r13 & 4) != 0 ? "-" : str3, (r13 & 8) != 0 ? "-" : str4, (r13 & 16) == 0 ? str5 : "-", (r13 & 32) != 0 ? GraphicsKt.emptyMitmap() : mitmap, (r13 & 64) != 0 ? GraphicsKt.emptyMitmap() : mitmap2);
    }
}
