package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class Session {
    private final long activeTimeMs;
    private final List<ActivityEntry> activityEntries;
    private int bmr;
    private final int calories;
    private final List<Elevation> elevation;
    private final int elevationGain;
    private final long endTs;
    private final Float fitnessIndex;
    private boolean gps;
    private final List<HeartrateEntry> heartrateEntries;
    private String historyDeviceId;
    private final List<Interval> intervals;
    private final List<LocationEntry> locationEntries;
    private final long sessionId;
    private final long startTs;
    private final SessionStatus status;
    private final int steps;
    private final double totalDistanceMeter;
    private final long totalTimeMs;
    private SessionType type;

    public /* synthetic */ Session(String str, long j, SessionType sessionType, boolean z, long j2, long j3, long j4, long j5, double d, int r16, int r17, int r18, int r19, Float f, List list, List list2, List list3, List list4, List list5, SessionStatus sessionStatus, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, sessionType, z, j2, j3, j4, j5, d, r16, r17, r18, r19, f, list, list2, list3, list4, list5, sessionStatus);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1465component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final int component10() {
        return this.steps;
    }

    public final int component11() {
        return this.calories;
    }

    public final int component12() {
        return this.bmr;
    }

    public final int component13() {
        return this.elevationGain;
    }

    public final Float component14() {
        return this.fitnessIndex;
    }

    public final List<HeartrateEntry> component15() {
        return this.heartrateEntries;
    }

    public final List<ActivityEntry> component16() {
        return this.activityEntries;
    }

    public final List<LocationEntry> component17() {
        return this.locationEntries;
    }

    public final List<Elevation> component18() {
        return this.elevation;
    }

    public final List<Interval> component19() {
        return this.intervals;
    }

    public final long component2() {
        return this.sessionId;
    }

    public final SessionStatus component20() {
        return this.status;
    }

    public final SessionType component3() {
        return this.type;
    }

    public final boolean component4() {
        return this.gps;
    }

    public final long component5() {
        return this.startTs;
    }

    public final long component6() {
        return this.endTs;
    }

    public final long component7() {
        return this.totalTimeMs;
    }

    public final long component8() {
        return this.activeTimeMs;
    }

    public final double component9() {
        return this.totalDistanceMeter;
    }

    /* renamed from: copy-iXt3iNo, reason: not valid java name */
    public final Session m1466copyiXt3iNo(String historyDeviceId, long j, SessionType type, boolean z, long j2, long j3, long j4, long j5, double d, int r46, int r47, int r48, int r49, Float f, List<HeartrateEntry> heartrateEntries, List<ActivityEntry> activityEntries, List<LocationEntry> locationEntries, List<Elevation> elevation, List<Interval> intervals, SessionStatus status) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(heartrateEntries, "heartrateEntries");
        Intrinsics.checkNotNullParameter(activityEntries, "activityEntries");
        Intrinsics.checkNotNullParameter(locationEntries, "locationEntries");
        Intrinsics.checkNotNullParameter(elevation, "elevation");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Intrinsics.checkNotNullParameter(status, "status");
        return new Session(historyDeviceId, j, type, z, j2, j3, j4, j5, d, r46, r47, r48, r49, f, heartrateEntries, activityEntries, locationEntries, elevation, intervals, status, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Session)) {
            return false;
        }
        Session session = (Session) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, session.historyDeviceId) && this.sessionId == session.sessionId && this.type == session.type && this.gps == session.gps && this.startTs == session.startTs && this.endTs == session.endTs && this.totalTimeMs == session.totalTimeMs && this.activeTimeMs == session.activeTimeMs && Double.compare(this.totalDistanceMeter, session.totalDistanceMeter) == 0 && this.steps == session.steps && this.calories == session.calories && this.bmr == session.bmr && this.elevationGain == session.elevationGain && Intrinsics.areEqual(this.fitnessIndex, session.fitnessIndex) && Intrinsics.areEqual(this.heartrateEntries, session.heartrateEntries) && Intrinsics.areEqual(this.activityEntries, session.activityEntries) && Intrinsics.areEqual(this.locationEntries, session.locationEntries) && Intrinsics.areEqual(this.elevation, session.elevation) && Intrinsics.areEqual(this.intervals, session.intervals) && this.status == session.status) {
            return true;
        }
        return false;
    }

    public final long getActiveTimeMs() {
        return this.activeTimeMs;
    }

    public final List<ActivityEntry> getActivityEntries() {
        return this.activityEntries;
    }

    public final int getBmr() {
        return this.bmr;
    }

    public final int getCalories() {
        return this.calories;
    }

    public final List<Elevation> getElevation() {
        return this.elevation;
    }

    public final int getElevationGain() {
        return this.elevationGain;
    }

    public final long getEndTs() {
        return this.endTs;
    }

    public final Float getFitnessIndex() {
        return this.fitnessIndex;
    }

    public final boolean getGps() {
        return this.gps;
    }

    public final List<HeartrateEntry> getHeartrateEntries() {
        return this.heartrateEntries;
    }

    /* renamed from: getHistoryDeviceId-V9ZILtA, reason: not valid java name */
    public final String m1467getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    public final List<Interval> getIntervals() {
        return this.intervals;
    }

    public final List<LocationEntry> getLocationEntries() {
        return this.locationEntries;
    }

    public final long getSessionId() {
        return this.sessionId;
    }

    public final long getStartTs() {
        return this.startTs;
    }

    public final SessionStatus getStatus() {
        return this.status;
    }

    public final int getSteps() {
        return this.steps;
    }

    public final double getTotalDistanceMeter() {
        return this.totalDistanceMeter;
    }

    public final long getTotalTimeMs() {
        return this.totalTimeMs;
    }

    public final SessionType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.elevationGain, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.bmr, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.calories, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.steps, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.totalDistanceMeter, Scale$$ExternalSyntheticOutline0.m(this.activeTimeMs, Scale$$ExternalSyntheticOutline0.m(this.totalTimeMs, Scale$$ExternalSyntheticOutline0.m(this.endTs, Scale$$ExternalSyntheticOutline0.m(this.startTs, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.gps, (this.type.hashCode() + Scale$$ExternalSyntheticOutline0.m(this.sessionId, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31)) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
        Float f = this.fitnessIndex;
        if (f == null) {
            hashCode = 0;
        } else {
            hashCode = f.hashCode();
        }
        return this.status.hashCode() + VectorGroup$$ExternalSyntheticOutline0.m(this.intervals, VectorGroup$$ExternalSyntheticOutline0.m(this.elevation, VectorGroup$$ExternalSyntheticOutline0.m(this.locationEntries, VectorGroup$$ExternalSyntheticOutline0.m(this.activityEntries, VectorGroup$$ExternalSyntheticOutline0.m(this.heartrateEntries, (m + hashCode) * 31, 31), 31), 31), 31), 31);
    }

    public final void setBmr(int r1) {
        this.bmr = r1;
    }

    public final void setGps(boolean z) {
        this.gps = z;
    }

    /* renamed from: setHistoryDeviceId-Y1s2hH8, reason: not valid java name */
    public final void m1468setHistoryDeviceIdY1s2hH8(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.historyDeviceId = str;
    }

    public final void setType(SessionType sessionType) {
        Intrinsics.checkNotNullParameter(sessionType, "<set-?>");
        this.type = sessionType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Session(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", sessionId=");
        sb.append(this.sessionId);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", gps=");
        sb.append(this.gps);
        sb.append(", startTs=");
        sb.append(this.startTs);
        sb.append(", endTs=");
        sb.append(this.endTs);
        sb.append(", totalTimeMs=");
        sb.append(this.totalTimeMs);
        sb.append(", activeTimeMs=");
        sb.append(this.activeTimeMs);
        sb.append(", totalDistanceMeter=");
        sb.append(this.totalDistanceMeter);
        sb.append(", steps=");
        sb.append(this.steps);
        sb.append(", calories=");
        sb.append(this.calories);
        sb.append(", bmr=");
        sb.append(this.bmr);
        sb.append(", elevationGain=");
        sb.append(this.elevationGain);
        sb.append(", fitnessIndex=");
        sb.append(this.fitnessIndex);
        sb.append(", heartrateEntries=");
        sb.append(this.heartrateEntries);
        sb.append(", activityEntries=");
        sb.append(this.activityEntries);
        sb.append(", locationEntries=");
        sb.append(this.locationEntries);
        sb.append(", elevation=");
        sb.append(this.elevation);
        sb.append(", intervals=");
        sb.append(this.intervals);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(')');
        return sb.toString();
    }

    private Session(String historyDeviceId, long j, SessionType type, boolean z, long j2, long j3, long j4, long j5, double d, int r27, int r28, int r29, int r30, Float f, List<HeartrateEntry> heartrateEntries, List<ActivityEntry> activityEntries, List<LocationEntry> locationEntries, List<Elevation> elevation, List<Interval> intervals, SessionStatus status) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(heartrateEntries, "heartrateEntries");
        Intrinsics.checkNotNullParameter(activityEntries, "activityEntries");
        Intrinsics.checkNotNullParameter(locationEntries, "locationEntries");
        Intrinsics.checkNotNullParameter(elevation, "elevation");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Intrinsics.checkNotNullParameter(status, "status");
        this.historyDeviceId = historyDeviceId;
        this.sessionId = j;
        this.type = type;
        this.gps = z;
        this.startTs = j2;
        this.endTs = j3;
        this.totalTimeMs = j4;
        this.activeTimeMs = j5;
        this.totalDistanceMeter = d;
        this.steps = r27;
        this.calories = r28;
        this.bmr = r29;
        this.elevationGain = r30;
        this.fitnessIndex = f;
        this.heartrateEntries = heartrateEntries;
        this.activityEntries = activityEntries;
        this.locationEntries = locationEntries;
        this.elevation = elevation;
        this.intervals = intervals;
        this.status = status;
    }
}
