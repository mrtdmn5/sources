package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBInterval.kt */
/* loaded from: classes3.dex */
public final class DBInterval {
    private final long end_timestamp;
    private final String hdid;
    private final long session_timestamp;
    private final long start_timestamp;

    /* compiled from: DBInterval.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            this.hdidAdapter = hdidAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }
    }

    public /* synthetic */ DBInterval(String str, long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, j3);
    }

    /* renamed from: copy-4i7cvns$default, reason: not valid java name */
    public static /* synthetic */ DBInterval m1163copy4i7cvns$default(DBInterval dBInterval, String str, long j, long j2, long j3, int r12, Object obj) {
        if ((r12 & 1) != 0) {
            str = dBInterval.hdid;
        }
        if ((r12 & 2) != 0) {
            j = dBInterval.session_timestamp;
        }
        long j4 = j;
        if ((r12 & 4) != 0) {
            j2 = dBInterval.start_timestamp;
        }
        long j5 = j2;
        if ((r12 & 8) != 0) {
            j3 = dBInterval.end_timestamp;
        }
        return dBInterval.m1165copy4i7cvns(str, j4, j5, j3);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1164component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.session_timestamp;
    }

    public final long component3() {
        return this.start_timestamp;
    }

    public final long component4() {
        return this.end_timestamp;
    }

    /* renamed from: copy-4i7cvns, reason: not valid java name */
    public final DBInterval m1165copy4i7cvns(String hdid, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBInterval(hdid, j, j2, j3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBInterval)) {
            return false;
        }
        DBInterval dBInterval = (DBInterval) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBInterval.hdid) && this.session_timestamp == dBInterval.session_timestamp && this.start_timestamp == dBInterval.start_timestamp && this.end_timestamp == dBInterval.end_timestamp) {
            return true;
        }
        return false;
    }

    public final long getEnd_timestamp() {
        return this.end_timestamp;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1166getHdidV9ZILtA() {
        return this.hdid;
    }

    public final long getSession_timestamp() {
        return this.session_timestamp;
    }

    public final long getStart_timestamp() {
        return this.start_timestamp;
    }

    public int hashCode() {
        return Long.hashCode(this.end_timestamp) + Scale$$ExternalSyntheticOutline0.m(this.start_timestamp, Scale$$ExternalSyntheticOutline0.m(this.session_timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBInterval(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", session_timestamp=");
        sb.append(this.session_timestamp);
        sb.append(", start_timestamp=");
        sb.append(this.start_timestamp);
        sb.append(", end_timestamp=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.end_timestamp, ')');
    }

    private DBInterval(String hdid, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.session_timestamp = j;
        this.start_timestamp = j2;
        this.end_timestamp = j3;
    }
}
