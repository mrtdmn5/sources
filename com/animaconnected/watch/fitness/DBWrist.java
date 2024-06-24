package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBWrist.kt */
/* loaded from: classes3.dex */
public final class DBWrist {
    private final String hdid;
    private final int state;
    private final long timestamp;

    /* compiled from: DBWrist.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> stateAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> stateAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(stateAdapter, "stateAdapter");
            this.hdidAdapter = hdidAdapter;
            this.stateAdapter = stateAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getStateAdapter() {
            return this.stateAdapter;
        }
    }

    public /* synthetic */ DBWrist(String str, long j, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ DBWrist m1207copyOZHprlw$default(DBWrist dBWrist, String str, long j, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = dBWrist.hdid;
        }
        if ((r5 & 2) != 0) {
            j = dBWrist.timestamp;
        }
        if ((r5 & 4) != 0) {
            r4 = dBWrist.state;
        }
        return dBWrist.m1209copyOZHprlw(str, j, r4);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1208component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.state;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final DBWrist m1209copyOZHprlw(String hdid, long j, int r11) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBWrist(hdid, j, r11, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBWrist)) {
            return false;
        }
        DBWrist dBWrist = (DBWrist) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBWrist.hdid) && this.timestamp == dBWrist.timestamp && this.state == dBWrist.state) {
            return true;
        }
        return false;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1210getHdidV9ZILtA() {
        return this.hdid;
    }

    public final int getState() {
        return this.state;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Integer.hashCode(this.state) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBWrist(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", state=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.state, ')');
    }

    private DBWrist(String hdid, long j, int r5) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.state = r5;
    }
}
