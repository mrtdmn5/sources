package com.animaconnected.watch.provider.weather;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeatherViewModel.kt */
/* loaded from: classes3.dex */
public final class DailyForecast {
    private final String date;
    private final Mitmap icon;
    private final String temp;

    public DailyForecast() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DailyForecast copy$default(DailyForecast dailyForecast, String str, String str2, Mitmap mitmap, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = dailyForecast.date;
        }
        if ((r4 & 2) != 0) {
            str2 = dailyForecast.temp;
        }
        if ((r4 & 4) != 0) {
            mitmap = dailyForecast.icon;
        }
        return dailyForecast.copy(str, str2, mitmap);
    }

    public final String component1() {
        return this.date;
    }

    public final String component2() {
        return this.temp;
    }

    public final Mitmap component3() {
        return this.icon;
    }

    public final DailyForecast copy(String date, String temp, Mitmap icon) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(temp, "temp");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new DailyForecast(date, temp, icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DailyForecast)) {
            return false;
        }
        DailyForecast dailyForecast = (DailyForecast) obj;
        if (Intrinsics.areEqual(this.date, dailyForecast.date) && Intrinsics.areEqual(this.temp, dailyForecast.temp) && Intrinsics.areEqual(this.icon, dailyForecast.icon)) {
            return true;
        }
        return false;
    }

    public final String getDate() {
        return this.date;
    }

    public final Mitmap getIcon() {
        return this.icon;
    }

    public final String getTemp() {
        return this.temp;
    }

    public int hashCode() {
        return this.icon.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.temp, this.date.hashCode() * 31, 31);
    }

    public String toString() {
        return "DailyForecast(date=" + this.date + ", temp=" + this.temp + ", icon=" + this.icon + ')';
    }

    public DailyForecast(String date, String temp, Mitmap icon) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(temp, "temp");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.date = date;
        this.temp = temp;
        this.icon = icon;
    }

    public /* synthetic */ DailyForecast(String str, String str2, Mitmap mitmap, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? "" : str, (r4 & 2) != 0 ? "-" : str2, (r4 & 4) != 0 ? GraphicsKt.emptyMitmap() : mitmap);
    }
}
