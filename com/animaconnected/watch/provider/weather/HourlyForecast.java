package com.animaconnected.watch.provider.weather;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeatherViewModel.kt */
/* loaded from: classes3.dex */
public final class HourlyForecast {
    private final Mitmap bigIcon;
    private final Mitmap icon;
    private final String temp;
    private final String time;

    public HourlyForecast() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ HourlyForecast copy$default(HourlyForecast hourlyForecast, String str, String str2, Mitmap mitmap, Mitmap mitmap2, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = hourlyForecast.time;
        }
        if ((r5 & 2) != 0) {
            str2 = hourlyForecast.temp;
        }
        if ((r5 & 4) != 0) {
            mitmap = hourlyForecast.icon;
        }
        if ((r5 & 8) != 0) {
            mitmap2 = hourlyForecast.bigIcon;
        }
        return hourlyForecast.copy(str, str2, mitmap, mitmap2);
    }

    public final String component1() {
        return this.time;
    }

    public final String component2() {
        return this.temp;
    }

    public final Mitmap component3() {
        return this.icon;
    }

    public final Mitmap component4() {
        return this.bigIcon;
    }

    public final HourlyForecast copy(String time, String temp, Mitmap icon, Mitmap bigIcon) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(temp, "temp");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(bigIcon, "bigIcon");
        return new HourlyForecast(time, temp, icon, bigIcon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HourlyForecast)) {
            return false;
        }
        HourlyForecast hourlyForecast = (HourlyForecast) obj;
        if (Intrinsics.areEqual(this.time, hourlyForecast.time) && Intrinsics.areEqual(this.temp, hourlyForecast.temp) && Intrinsics.areEqual(this.icon, hourlyForecast.icon) && Intrinsics.areEqual(this.bigIcon, hourlyForecast.bigIcon)) {
            return true;
        }
        return false;
    }

    public final Mitmap getBigIcon() {
        return this.bigIcon;
    }

    public final Mitmap getIcon() {
        return this.icon;
    }

    public final String getTemp() {
        return this.temp;
    }

    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        return this.bigIcon.hashCode() + ((this.icon.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.temp, this.time.hashCode() * 31, 31)) * 31);
    }

    public String toString() {
        return "HourlyForecast(time=" + this.time + ", temp=" + this.temp + ", icon=" + this.icon + ", bigIcon=" + this.bigIcon + ')';
    }

    public HourlyForecast(String time, String temp, Mitmap icon, Mitmap bigIcon) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(temp, "temp");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(bigIcon, "bigIcon");
        this.time = time;
        this.temp = temp;
        this.icon = icon;
        this.bigIcon = bigIcon;
    }

    public /* synthetic */ HourlyForecast(String str, String str2, Mitmap mitmap, Mitmap mitmap2, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this((r5 & 1) != 0 ? "" : str, (r5 & 2) != 0 ? "-" : str2, (r5 & 4) != 0 ? GraphicsKt.emptyMitmap() : mitmap, (r5 & 8) != 0 ? GraphicsKt.emptyMitmap() : mitmap2);
    }
}
