package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBSessionData.kt */
/* loaded from: classes3.dex */
public final class DBSessionData {
    private final Boolean gps;
    private final String hdid;
    private final long session_id;
    private final int state;
    private final long timestamp;
    private final Integer type;

    /* compiled from: DBSessionData.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> stateAdapter;
        private final ColumnAdapter<Integer, Long> typeAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> stateAdapter, ColumnAdapter<Integer, Long> typeAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(stateAdapter, "stateAdapter");
            Intrinsics.checkNotNullParameter(typeAdapter, "typeAdapter");
            this.hdidAdapter = hdidAdapter;
            this.stateAdapter = stateAdapter;
            this.typeAdapter = typeAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getStateAdapter() {
            return this.stateAdapter;
        }

        public final ColumnAdapter<Integer, Long> getTypeAdapter() {
            return this.typeAdapter;
        }
    }

    public /* synthetic */ DBSessionData(String str, long j, int r4, Integer num, Boolean bool, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4, num, bool, j2);
    }

    /* renamed from: copy-FGKXf14$default, reason: not valid java name */
    public static /* synthetic */ DBSessionData m1183copyFGKXf14$default(DBSessionData dBSessionData, String str, long j, int r13, Integer num, Boolean bool, long j2, int r18, Object obj) {
        String str2;
        long j3;
        int r4;
        Integer num2;
        Boolean bool2;
        long j4;
        if ((r18 & 1) != 0) {
            str2 = dBSessionData.hdid;
        } else {
            str2 = str;
        }
        if ((r18 & 2) != 0) {
            j3 = dBSessionData.timestamp;
        } else {
            j3 = j;
        }
        if ((r18 & 4) != 0) {
            r4 = dBSessionData.state;
        } else {
            r4 = r13;
        }
        if ((r18 & 8) != 0) {
            num2 = dBSessionData.type;
        } else {
            num2 = num;
        }
        if ((r18 & 16) != 0) {
            bool2 = dBSessionData.gps;
        } else {
            bool2 = bool;
        }
        if ((r18 & 32) != 0) {
            j4 = dBSessionData.session_id;
        } else {
            j4 = j2;
        }
        return dBSessionData.m1185copyFGKXf14(str2, j3, r4, num2, bool2, j4);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1184component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.state;
    }

    public final Integer component4() {
        return this.type;
    }

    public final Boolean component5() {
        return this.gps;
    }

    public final long component6() {
        return this.session_id;
    }

    /* renamed from: copy-FGKXf14, reason: not valid java name */
    public final DBSessionData m1185copyFGKXf14(String hdid, long j, int r15, Integer num, Boolean bool, long j2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBSessionData(hdid, j, r15, num, bool, j2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBSessionData)) {
            return false;
        }
        DBSessionData dBSessionData = (DBSessionData) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBSessionData.hdid) && this.timestamp == dBSessionData.timestamp && this.state == dBSessionData.state && Intrinsics.areEqual(this.type, dBSessionData.type) && Intrinsics.areEqual(this.gps, dBSessionData.gps) && this.session_id == dBSessionData.session_id) {
            return true;
        }
        return false;
    }

    public final Boolean getGps() {
        return this.gps;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1186getHdidV9ZILtA() {
        return this.hdid;
    }

    public final long getSession_id() {
        return this.session_id;
    }

    public final int getState() {
        return this.state;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.state, Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31), 31);
        Integer num = this.type;
        int r2 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Boolean bool = this.gps;
        if (bool != null) {
            r2 = bool.hashCode();
        }
        return Long.hashCode(this.session_id) + ((r0 + r2) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBSessionData(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", gps=");
        sb.append(this.gps);
        sb.append(", session_id=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.session_id, ')');
    }

    private DBSessionData(String hdid, long j, int r5, Integer num, Boolean bool, long j2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.state = r5;
        this.type = num;
        this.gps = bool;
        this.session_id = j2;
    }
}
