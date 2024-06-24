package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBSleepData.kt */
/* loaded from: classes3.dex */
public final class DBSleepData {
    private final String hdid;
    private final int sleep_state;
    private final long timestamp;

    /* compiled from: DBSleepData.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> sleep_stateAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> sleep_stateAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(sleep_stateAdapter, "sleep_stateAdapter");
            this.hdidAdapter = hdidAdapter;
            this.sleep_stateAdapter = sleep_stateAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getSleep_stateAdapter() {
            return this.sleep_stateAdapter;
        }
    }

    public /* synthetic */ DBSleepData(String str, long j, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ DBSleepData m1187copyOZHprlw$default(DBSleepData dBSleepData, String str, long j, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = dBSleepData.hdid;
        }
        if ((r5 & 2) != 0) {
            j = dBSleepData.timestamp;
        }
        if ((r5 & 4) != 0) {
            r4 = dBSleepData.sleep_state;
        }
        return dBSleepData.m1189copyOZHprlw(str, j, r4);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1188component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.sleep_state;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final DBSleepData m1189copyOZHprlw(String hdid, long j, int r11) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBSleepData(hdid, j, r11, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBSleepData)) {
            return false;
        }
        DBSleepData dBSleepData = (DBSleepData) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBSleepData.hdid) && this.timestamp == dBSleepData.timestamp && this.sleep_state == dBSleepData.sleep_state) {
            return true;
        }
        return false;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1190getHdidV9ZILtA() {
        return this.hdid;
    }

    public final int getSleep_state() {
        return this.sleep_state;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Integer.hashCode(this.sleep_state) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBSleepData(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", sleep_state=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.sleep_state, ')');
    }

    private DBSleepData(String hdid, long j, int r5) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.sleep_state = r5;
    }
}
