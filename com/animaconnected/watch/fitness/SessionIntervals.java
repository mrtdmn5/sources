package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: FitnessDataUtils.kt */
/* loaded from: classes3.dex */
public final class SessionIntervals {
    private final List<Interval> activeIntervals;
    private final Interval completeInterval;
    private final boolean gps;
    private final String historyDeviceId;
    private final long sessionId;
    private final SessionStatus status;
    private final SessionType type;

    public /* synthetic */ SessionIntervals(String str, long j, SessionType sessionType, boolean z, Interval interval, List list, SessionStatus sessionStatus, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, sessionType, z, interval, list, sessionStatus);
    }

    /* renamed from: copy-EBUUAns$default, reason: not valid java name */
    public static /* synthetic */ SessionIntervals m1473copyEBUUAns$default(SessionIntervals sessionIntervals, String str, long j, SessionType sessionType, boolean z, Interval interval, List list, SessionStatus sessionStatus, int r18, Object obj) {
        String str2;
        long j2;
        SessionType sessionType2;
        boolean z2;
        Interval interval2;
        List list2;
        SessionStatus sessionStatus2;
        if ((r18 & 1) != 0) {
            str2 = sessionIntervals.historyDeviceId;
        } else {
            str2 = str;
        }
        if ((r18 & 2) != 0) {
            j2 = sessionIntervals.sessionId;
        } else {
            j2 = j;
        }
        if ((r18 & 4) != 0) {
            sessionType2 = sessionIntervals.type;
        } else {
            sessionType2 = sessionType;
        }
        if ((r18 & 8) != 0) {
            z2 = sessionIntervals.gps;
        } else {
            z2 = z;
        }
        if ((r18 & 16) != 0) {
            interval2 = sessionIntervals.completeInterval;
        } else {
            interval2 = interval;
        }
        if ((r18 & 32) != 0) {
            list2 = sessionIntervals.activeIntervals;
        } else {
            list2 = list;
        }
        if ((r18 & 64) != 0) {
            sessionStatus2 = sessionIntervals.status;
        } else {
            sessionStatus2 = sessionStatus;
        }
        return sessionIntervals.m1475copyEBUUAns(str2, j2, sessionType2, z2, interval2, list2, sessionStatus2);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1474component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.sessionId;
    }

    public final SessionType component3() {
        return this.type;
    }

    public final boolean component4() {
        return this.gps;
    }

    public final Interval component5() {
        return this.completeInterval;
    }

    public final List<Interval> component6() {
        return this.activeIntervals;
    }

    public final SessionStatus component7() {
        return this.status;
    }

    /* renamed from: copy-EBUUAns, reason: not valid java name */
    public final SessionIntervals m1475copyEBUUAns(String historyDeviceId, long j, SessionType type, boolean z, Interval completeInterval, List<Interval> activeIntervals, SessionStatus status) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(completeInterval, "completeInterval");
        Intrinsics.checkNotNullParameter(activeIntervals, "activeIntervals");
        Intrinsics.checkNotNullParameter(status, "status");
        return new SessionIntervals(historyDeviceId, j, type, z, completeInterval, activeIntervals, status, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionIntervals)) {
            return false;
        }
        SessionIntervals sessionIntervals = (SessionIntervals) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, sessionIntervals.historyDeviceId) && this.sessionId == sessionIntervals.sessionId && this.type == sessionIntervals.type && this.gps == sessionIntervals.gps && Intrinsics.areEqual(this.completeInterval, sessionIntervals.completeInterval) && Intrinsics.areEqual(this.activeIntervals, sessionIntervals.activeIntervals) && this.status == sessionIntervals.status) {
            return true;
        }
        return false;
    }

    public final List<Interval> getActiveIntervals() {
        return this.activeIntervals;
    }

    public final Interval getCompleteInterval() {
        return this.completeInterval;
    }

    public final boolean getGps() {
        return this.gps;
    }

    /* renamed from: getHistoryDeviceId-V9ZILtA, reason: not valid java name */
    public final String m1476getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    public final long getSessionId() {
        return this.sessionId;
    }

    public final SessionStatus getStatus() {
        return this.status;
    }

    public final SessionType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.status.hashCode() + VectorGroup$$ExternalSyntheticOutline0.m(this.activeIntervals, (this.completeInterval.hashCode() + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.gps, (this.type.hashCode() + Scale$$ExternalSyntheticOutline0.m(this.sessionId, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31)) * 31, 31)) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SessionIntervals(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", sessionId=");
        sb.append(this.sessionId);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", gps=");
        sb.append(this.gps);
        sb.append(", completeInterval=");
        sb.append(this.completeInterval);
        sb.append(", activeIntervals=");
        sb.append(this.activeIntervals);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(')');
        return sb.toString();
    }

    private SessionIntervals(String historyDeviceId, long j, SessionType type, boolean z, Interval completeInterval, List<Interval> activeIntervals, SessionStatus status) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(completeInterval, "completeInterval");
        Intrinsics.checkNotNullParameter(activeIntervals, "activeIntervals");
        Intrinsics.checkNotNullParameter(status, "status");
        this.historyDeviceId = historyDeviceId;
        this.sessionId = j;
        this.type = type;
        this.gps = z;
        this.completeInterval = completeInterval;
        this.activeIntervals = activeIntervals;
        this.status = status;
    }
}
