package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBDeletedSessions.kt */
/* loaded from: classes3.dex */
public final class DBDeletedSessions {
    private final String hdid;
    private final long timestamp;

    /* compiled from: DBDeletedSessions.kt */
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

    public /* synthetic */ DBDeletedSessions(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    /* renamed from: copy-cu7-zPM$default, reason: not valid java name */
    public static /* synthetic */ DBDeletedSessions m1131copycu7zPM$default(DBDeletedSessions dBDeletedSessions, String str, long j, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = dBDeletedSessions.hdid;
        }
        if ((r4 & 2) != 0) {
            j = dBDeletedSessions.timestamp;
        }
        return dBDeletedSessions.m1133copycu7zPM(str, j);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1132component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    /* renamed from: copy-cu7-zPM, reason: not valid java name */
    public final DBDeletedSessions m1133copycu7zPM(String hdid, long j) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBDeletedSessions(hdid, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBDeletedSessions)) {
            return false;
        }
        DBDeletedSessions dBDeletedSessions = (DBDeletedSessions) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBDeletedSessions.hdid) && this.timestamp == dBDeletedSessions.timestamp) {
            return true;
        }
        return false;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1134getHdidV9ZILtA() {
        return this.hdid;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Long.hashCode(this.timestamp) + (HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBDeletedSessions(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.timestamp, ')');
    }

    private DBDeletedSessions(String hdid, long j) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
    }
}
