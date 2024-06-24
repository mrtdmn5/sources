package com.animaconnected.watch.provider.weather;

import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeatherViewModel.kt */
/* loaded from: classes3.dex */
public final class WeatherForecastWatch {
    private final CurrentForecast current;
    private final List<DailyForecast> daily;
    private final List<HourlyForecast> hourly;
    private final TodayForecast today;

    public WeatherForecastWatch() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WeatherForecastWatch copy$default(WeatherForecastWatch weatherForecastWatch, CurrentForecast currentForecast, TodayForecast todayForecast, List list, List list2, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            currentForecast = weatherForecastWatch.current;
        }
        if ((r5 & 2) != 0) {
            todayForecast = weatherForecastWatch.today;
        }
        if ((r5 & 4) != 0) {
            list = weatherForecastWatch.hourly;
        }
        if ((r5 & 8) != 0) {
            list2 = weatherForecastWatch.daily;
        }
        return weatherForecastWatch.copy(currentForecast, todayForecast, list, list2);
    }

    public final CurrentForecast component1() {
        return this.current;
    }

    public final TodayForecast component2() {
        return this.today;
    }

    public final List<HourlyForecast> component3() {
        return this.hourly;
    }

    public final List<DailyForecast> component4() {
        return this.daily;
    }

    public final WeatherForecastWatch copy(CurrentForecast current, TodayForecast today, List<HourlyForecast> hourly, List<DailyForecast> daily) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(today, "today");
        Intrinsics.checkNotNullParameter(hourly, "hourly");
        Intrinsics.checkNotNullParameter(daily, "daily");
        return new WeatherForecastWatch(current, today, hourly, daily);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeatherForecastWatch)) {
            return false;
        }
        WeatherForecastWatch weatherForecastWatch = (WeatherForecastWatch) obj;
        if (Intrinsics.areEqual(this.current, weatherForecastWatch.current) && Intrinsics.areEqual(this.today, weatherForecastWatch.today) && Intrinsics.areEqual(this.hourly, weatherForecastWatch.hourly) && Intrinsics.areEqual(this.daily, weatherForecastWatch.daily)) {
            return true;
        }
        return false;
    }

    public final CurrentForecast getCurrent() {
        return this.current;
    }

    public final List<DailyForecast> getDaily() {
        return this.daily;
    }

    public final List<HourlyForecast> getHourly() {
        return this.hourly;
    }

    public final TodayForecast getToday() {
        return this.today;
    }

    public int hashCode() {
        return this.daily.hashCode() + VectorGroup$$ExternalSyntheticOutline0.m(this.hourly, (this.today.hashCode() + (this.current.hashCode() * 31)) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WeatherForecastWatch(current=");
        sb.append(this.current);
        sb.append(", today=");
        sb.append(this.today);
        sb.append(", hourly=");
        sb.append(this.hourly);
        sb.append(", daily=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.daily, ')');
    }

    public WeatherForecastWatch(CurrentForecast current, TodayForecast today, List<HourlyForecast> hourly, List<DailyForecast> daily) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(today, "today");
        Intrinsics.checkNotNullParameter(hourly, "hourly");
        Intrinsics.checkNotNullParameter(daily, "daily");
        this.current = current;
        this.today = today;
        this.hourly = hourly;
        this.daily = daily;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ WeatherForecastWatch(com.animaconnected.watch.provider.weather.CurrentForecast r13, com.animaconnected.watch.provider.weather.TodayForecast r14, java.util.List r15, java.util.List r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r12 = this;
            r0 = r17 & 1
            if (r0 == 0) goto L10
            com.animaconnected.watch.provider.weather.CurrentForecast r0 = new com.animaconnected.watch.provider.weather.CurrentForecast
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 7
            r6 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L11
        L10:
            r0 = r13
        L11:
            r1 = r17 & 2
            if (r1 == 0) goto L26
            com.animaconnected.watch.provider.weather.TodayForecast r1 = new com.animaconnected.watch.provider.weather.TodayForecast
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 127(0x7f, float:1.78E-43)
            r11 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            goto L27
        L26:
            r1 = r14
        L27:
            r2 = r17 & 4
            kotlin.collections.EmptyList r3 = kotlin.collections.EmptyList.INSTANCE
            if (r2 == 0) goto L2f
            r2 = r3
            goto L30
        L2f:
            r2 = r15
        L30:
            r4 = r17 & 8
            if (r4 == 0) goto L36
            r4 = r12
            goto L39
        L36:
            r4 = r12
            r3 = r16
        L39:
            r12.<init>(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.weather.WeatherForecastWatch.<init>(com.animaconnected.watch.provider.weather.CurrentForecast, com.animaconnected.watch.provider.weather.TodayForecast, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
