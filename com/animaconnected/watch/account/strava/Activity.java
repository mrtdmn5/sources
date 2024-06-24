package com.animaconnected.watch.account.strava;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.datetime.Instant;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StravaTcx.kt */
/* loaded from: classes3.dex */
public final class Activity {
    private final String activityType;
    private final int calories;
    private final boolean hasGps;
    private final List<TrackPoint> points;
    private final Instant startTime;
    private final double totalDistanceMeter;
    private final long totalTime;

    public /* synthetic */ Activity(String str, Instant instant, long j, int r5, double d, boolean z, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, instant, j, r5, d, z, list);
    }

    /* renamed from: copy-SYHnMyU$default, reason: not valid java name */
    public static /* synthetic */ Activity m1054copySYHnMyU$default(Activity activity, String str, Instant instant, long j, int r15, double d, boolean z, List list, int r20, Object obj) {
        String str2;
        Instant instant2;
        long j2;
        int r5;
        double d2;
        boolean z2;
        List list2;
        if ((r20 & 1) != 0) {
            str2 = activity.activityType;
        } else {
            str2 = str;
        }
        if ((r20 & 2) != 0) {
            instant2 = activity.startTime;
        } else {
            instant2 = instant;
        }
        if ((r20 & 4) != 0) {
            j2 = activity.totalTime;
        } else {
            j2 = j;
        }
        if ((r20 & 8) != 0) {
            r5 = activity.calories;
        } else {
            r5 = r15;
        }
        if ((r20 & 16) != 0) {
            d2 = activity.totalDistanceMeter;
        } else {
            d2 = d;
        }
        if ((r20 & 32) != 0) {
            z2 = activity.hasGps;
        } else {
            z2 = z;
        }
        if ((r20 & 64) != 0) {
            list2 = activity.points;
        } else {
            list2 = list;
        }
        return activity.m1056copySYHnMyU(str2, instant2, j2, r5, d2, z2, list2);
    }

    public final String component1() {
        return this.activityType;
    }

    public final Instant component2() {
        return this.startTime;
    }

    /* renamed from: component3-UwyO8pc, reason: not valid java name */
    public final long m1055component3UwyO8pc() {
        return this.totalTime;
    }

    public final int component4() {
        return this.calories;
    }

    public final double component5() {
        return this.totalDistanceMeter;
    }

    public final boolean component6() {
        return this.hasGps;
    }

    public final List<TrackPoint> component7() {
        return this.points;
    }

    /* renamed from: copy-SYHnMyU, reason: not valid java name */
    public final Activity m1056copySYHnMyU(String activityType, Instant startTime, long j, int r17, double d, boolean z, List<TrackPoint> points) {
        Intrinsics.checkNotNullParameter(activityType, "activityType");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(points, "points");
        return new Activity(activityType, startTime, j, r17, d, z, points, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) obj;
        if (Intrinsics.areEqual(this.activityType, activity.activityType) && Intrinsics.areEqual(this.startTime, activity.startTime) && Duration.m1675equalsimpl0(this.totalTime, activity.totalTime) && this.calories == activity.calories && Double.compare(this.totalDistanceMeter, activity.totalDistanceMeter) == 0 && this.hasGps == activity.hasGps && Intrinsics.areEqual(this.points, activity.points)) {
            return true;
        }
        return false;
    }

    public final String getActivityType() {
        return this.activityType;
    }

    public final int getCalories() {
        return this.calories;
    }

    public final boolean getHasGps() {
        return this.hasGps;
    }

    public final List<TrackPoint> getPoints() {
        return this.points;
    }

    public final Instant getStartTime() {
        return this.startTime;
    }

    public final double getTotalDistanceMeter() {
        return this.totalDistanceMeter;
    }

    /* renamed from: getTotalTime-UwyO8pc, reason: not valid java name */
    public final long m1057getTotalTimeUwyO8pc() {
        return this.totalTime;
    }

    public int hashCode() {
        int hashCode = (this.startTime.hashCode() + (this.activityType.hashCode() * 31)) * 31;
        long j = this.totalTime;
        int r0 = Duration.$r8$clinit;
        return this.points.hashCode() + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.hasGps, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.totalDistanceMeter, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.calories, Scale$$ExternalSyntheticOutline0.m(j, hashCode, 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Activity(activityType=");
        sb.append(this.activityType);
        sb.append(", startTime=");
        sb.append(this.startTime);
        sb.append(", totalTime=");
        sb.append((Object) Duration.m1690toStringimpl(this.totalTime));
        sb.append(", calories=");
        sb.append(this.calories);
        sb.append(", totalDistanceMeter=");
        sb.append(this.totalDistanceMeter);
        sb.append(", hasGps=");
        sb.append(this.hasGps);
        sb.append(", points=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.points, ')');
    }

    private Activity(String activityType, Instant startTime, long j, int r6, double d, boolean z, List<TrackPoint> points) {
        Intrinsics.checkNotNullParameter(activityType, "activityType");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(points, "points");
        this.activityType = activityType;
        this.startTime = startTime;
        this.totalTime = j;
        this.calories = r6;
        this.totalDistanceMeter = d;
        this.hasGps = z;
        this.points = points;
    }
}
