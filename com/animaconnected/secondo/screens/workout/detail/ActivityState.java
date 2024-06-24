package com.animaconnected.secondo.screens.workout.detail;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDetailsViewModel.kt */
/* loaded from: classes3.dex */
public final class ActivityState {
    public static final int $stable = 8;
    private final String activityType;
    private final String address;
    private final String date;
    private final int imageId;
    private final List<List<Pair<String, String>>> metrics;
    private final String time;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityState(int r2, String activityType, String date, String address, String time, List<? extends List<Pair<String, String>>> metrics) {
        Intrinsics.checkNotNullParameter(activityType, "activityType");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.imageId = r2;
        this.activityType = activityType;
        this.date = date;
        this.address = address;
        this.time = time;
        this.metrics = metrics;
    }

    public static /* synthetic */ ActivityState copy$default(ActivityState activityState, int r5, String str, String str2, String str3, String str4, List list, int r11, Object obj) {
        if ((r11 & 1) != 0) {
            r5 = activityState.imageId;
        }
        if ((r11 & 2) != 0) {
            str = activityState.activityType;
        }
        String str5 = str;
        if ((r11 & 4) != 0) {
            str2 = activityState.date;
        }
        String str6 = str2;
        if ((r11 & 8) != 0) {
            str3 = activityState.address;
        }
        String str7 = str3;
        if ((r11 & 16) != 0) {
            str4 = activityState.time;
        }
        String str8 = str4;
        if ((r11 & 32) != 0) {
            list = activityState.metrics;
        }
        return activityState.copy(r5, str5, str6, str7, str8, list);
    }

    public final int component1() {
        return this.imageId;
    }

    public final String component2() {
        return this.activityType;
    }

    public final String component3() {
        return this.date;
    }

    public final String component4() {
        return this.address;
    }

    public final String component5() {
        return this.time;
    }

    public final List<List<Pair<String, String>>> component6() {
        return this.metrics;
    }

    public final ActivityState copy(int r9, String activityType, String date, String address, String time, List<? extends List<Pair<String, String>>> metrics) {
        Intrinsics.checkNotNullParameter(activityType, "activityType");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return new ActivityState(r9, activityType, date, address, time, metrics);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityState)) {
            return false;
        }
        ActivityState activityState = (ActivityState) obj;
        if (this.imageId == activityState.imageId && Intrinsics.areEqual(this.activityType, activityState.activityType) && Intrinsics.areEqual(this.date, activityState.date) && Intrinsics.areEqual(this.address, activityState.address) && Intrinsics.areEqual(this.time, activityState.time) && Intrinsics.areEqual(this.metrics, activityState.metrics)) {
            return true;
        }
        return false;
    }

    public final String getActivityType() {
        return this.activityType;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getDate() {
        return this.date;
    }

    public final int getImageId() {
        return this.imageId;
    }

    public final List<List<Pair<String, String>>> getMetrics() {
        return this.metrics;
    }

    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        return this.metrics.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.time, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.address, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.date, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.activityType, Integer.hashCode(this.imageId) * 31, 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ActivityState(imageId=");
        sb.append(this.imageId);
        sb.append(", activityType=");
        sb.append(this.activityType);
        sb.append(", date=");
        sb.append(this.date);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", time=");
        sb.append(this.time);
        sb.append(", metrics=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.metrics, ')');
    }
}
