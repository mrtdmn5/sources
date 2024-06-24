package com.animaconnected.widget;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionCard.kt */
/* loaded from: classes3.dex */
public final class SessionCardData {
    public static final int $stable = 0;
    private final int activityIcon;
    private final String activityTitle;
    private final String duration;
    private final String hourMinute;
    private final String metric;
    private final String timeAgo;
    private final long timestamp;

    public SessionCardData(long j, String activityTitle, int r5, String metric, String hourMinute, String duration, String timeAgo) {
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(hourMinute, "hourMinute");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(timeAgo, "timeAgo");
        this.timestamp = j;
        this.activityTitle = activityTitle;
        this.activityIcon = r5;
        this.metric = metric;
        this.hourMinute = hourMinute;
        this.duration = duration;
        this.timeAgo = timeAgo;
    }

    public static /* synthetic */ SessionCardData copy$default(SessionCardData sessionCardData, long j, String str, int r13, String str2, String str3, String str4, String str5, int r18, Object obj) {
        long j2;
        String str6;
        int r4;
        String str7;
        String str8;
        String str9;
        String str10;
        if ((r18 & 1) != 0) {
            j2 = sessionCardData.timestamp;
        } else {
            j2 = j;
        }
        if ((r18 & 2) != 0) {
            str6 = sessionCardData.activityTitle;
        } else {
            str6 = str;
        }
        if ((r18 & 4) != 0) {
            r4 = sessionCardData.activityIcon;
        } else {
            r4 = r13;
        }
        if ((r18 & 8) != 0) {
            str7 = sessionCardData.metric;
        } else {
            str7 = str2;
        }
        if ((r18 & 16) != 0) {
            str8 = sessionCardData.hourMinute;
        } else {
            str8 = str3;
        }
        if ((r18 & 32) != 0) {
            str9 = sessionCardData.duration;
        } else {
            str9 = str4;
        }
        if ((r18 & 64) != 0) {
            str10 = sessionCardData.timeAgo;
        } else {
            str10 = str5;
        }
        return sessionCardData.copy(j2, str6, r4, str7, str8, str9, str10);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final String component2() {
        return this.activityTitle;
    }

    public final int component3() {
        return this.activityIcon;
    }

    public final String component4() {
        return this.metric;
    }

    public final String component5() {
        return this.hourMinute;
    }

    public final String component6() {
        return this.duration;
    }

    public final String component7() {
        return this.timeAgo;
    }

    public final SessionCardData copy(long j, String activityTitle, int r14, String metric, String hourMinute, String duration, String timeAgo) {
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(hourMinute, "hourMinute");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(timeAgo, "timeAgo");
        return new SessionCardData(j, activityTitle, r14, metric, hourMinute, duration, timeAgo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionCardData)) {
            return false;
        }
        SessionCardData sessionCardData = (SessionCardData) obj;
        if (this.timestamp == sessionCardData.timestamp && Intrinsics.areEqual(this.activityTitle, sessionCardData.activityTitle) && this.activityIcon == sessionCardData.activityIcon && Intrinsics.areEqual(this.metric, sessionCardData.metric) && Intrinsics.areEqual(this.hourMinute, sessionCardData.hourMinute) && Intrinsics.areEqual(this.duration, sessionCardData.duration) && Intrinsics.areEqual(this.timeAgo, sessionCardData.timeAgo)) {
            return true;
        }
        return false;
    }

    public final int getActivityIcon() {
        return this.activityIcon;
    }

    public final String getActivityTitle() {
        return this.activityTitle;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getHourMinute() {
        return this.hourMinute;
    }

    public final String getMetric() {
        return this.metric;
    }

    public final String getTimeAgo() {
        return this.timeAgo;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return this.timeAgo.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.duration, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.hourMinute, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.metric, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.activityIcon, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.activityTitle, Long.hashCode(this.timestamp) * 31, 31), 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SessionCardData(timestamp=");
        sb.append(this.timestamp);
        sb.append(", activityTitle=");
        sb.append(this.activityTitle);
        sb.append(", activityIcon=");
        sb.append(this.activityIcon);
        sb.append(", metric=");
        sb.append(this.metric);
        sb.append(", hourMinute=");
        sb.append(this.hourMinute);
        sb.append(", duration=");
        sb.append(this.duration);
        sb.append(", timeAgo=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.timeAgo, ')');
    }
}
