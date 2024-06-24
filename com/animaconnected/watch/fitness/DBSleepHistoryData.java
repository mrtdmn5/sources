package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBSleepHistoryData.kt */
/* loaded from: classes3.dex */
public final class DBSleepHistoryData {
    private final long deepSleepMs;
    private final long end;
    private final String hdid;
    private final long lightSleepMs;
    private final long start;

    /* compiled from: DBSleepHistoryData.kt */
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

    public /* synthetic */ DBSleepHistoryData(String str, long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, j3, j4);
    }

    /* renamed from: copy-_w5UW7A$default, reason: not valid java name */
    public static /* synthetic */ DBSleepHistoryData m1191copy_w5UW7A$default(DBSleepHistoryData dBSleepHistoryData, String str, long j, long j2, long j3, long j4, int r20, Object obj) {
        String str2;
        long j5;
        long j6;
        long j7;
        long j8;
        if ((r20 & 1) != 0) {
            str2 = dBSleepHistoryData.hdid;
        } else {
            str2 = str;
        }
        if ((r20 & 2) != 0) {
            j5 = dBSleepHistoryData.start;
        } else {
            j5 = j;
        }
        if ((r20 & 4) != 0) {
            j6 = dBSleepHistoryData.end;
        } else {
            j6 = j2;
        }
        if ((r20 & 8) != 0) {
            j7 = dBSleepHistoryData.lightSleepMs;
        } else {
            j7 = j3;
        }
        if ((r20 & 16) != 0) {
            j8 = dBSleepHistoryData.deepSleepMs;
        } else {
            j8 = j4;
        }
        return dBSleepHistoryData.m1193copy_w5UW7A(str2, j5, j6, j7, j8);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1192component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.start;
    }

    public final long component3() {
        return this.end;
    }

    public final long component4() {
        return this.lightSleepMs;
    }

    public final long component5() {
        return this.deepSleepMs;
    }

    /* renamed from: copy-_w5UW7A, reason: not valid java name */
    public final DBSleepHistoryData m1193copy_w5UW7A(String hdid, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBSleepHistoryData(hdid, j, j2, j3, j4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBSleepHistoryData)) {
            return false;
        }
        DBSleepHistoryData dBSleepHistoryData = (DBSleepHistoryData) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBSleepHistoryData.hdid) && this.start == dBSleepHistoryData.start && this.end == dBSleepHistoryData.end && this.lightSleepMs == dBSleepHistoryData.lightSleepMs && this.deepSleepMs == dBSleepHistoryData.deepSleepMs) {
            return true;
        }
        return false;
    }

    public final long getDeepSleepMs() {
        return this.deepSleepMs;
    }

    public final long getEnd() {
        return this.end;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1194getHdidV9ZILtA() {
        return this.hdid;
    }

    public final long getLightSleepMs() {
        return this.lightSleepMs;
    }

    public final long getStart() {
        return this.start;
    }

    public int hashCode() {
        return Long.hashCode(this.deepSleepMs) + Scale$$ExternalSyntheticOutline0.m(this.lightSleepMs, Scale$$ExternalSyntheticOutline0.m(this.end, Scale$$ExternalSyntheticOutline0.m(this.start, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBSleepHistoryData(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", start=");
        sb.append(this.start);
        sb.append(", end=");
        sb.append(this.end);
        sb.append(", lightSleepMs=");
        sb.append(this.lightSleepMs);
        sb.append(", deepSleepMs=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.deepSleepMs, ')');
    }

    private DBSleepHistoryData(String hdid, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.start = j;
        this.end = j2;
        this.lightSleepMs = j3;
        this.deepSleepMs = j4;
    }
}
