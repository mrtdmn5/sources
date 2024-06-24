package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBRestingHeartrateData.kt */
/* loaded from: classes3.dex */
public final class DBRestingHeartrateData {
    private final String hdid;
    private final int restingHeartrate;
    private final long timestamp;

    /* compiled from: DBRestingHeartrateData.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> restingHeartrateAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> restingHeartrateAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(restingHeartrateAdapter, "restingHeartrateAdapter");
            this.hdidAdapter = hdidAdapter;
            this.restingHeartrateAdapter = restingHeartrateAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getRestingHeartrateAdapter() {
            return this.restingHeartrateAdapter;
        }
    }

    public /* synthetic */ DBRestingHeartrateData(String str, long j, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ DBRestingHeartrateData m1175copyOZHprlw$default(DBRestingHeartrateData dBRestingHeartrateData, String str, long j, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = dBRestingHeartrateData.hdid;
        }
        if ((r5 & 2) != 0) {
            j = dBRestingHeartrateData.timestamp;
        }
        if ((r5 & 4) != 0) {
            r4 = dBRestingHeartrateData.restingHeartrate;
        }
        return dBRestingHeartrateData.m1177copyOZHprlw(str, j, r4);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1176component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.restingHeartrate;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final DBRestingHeartrateData m1177copyOZHprlw(String hdid, long j, int r11) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBRestingHeartrateData(hdid, j, r11, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBRestingHeartrateData)) {
            return false;
        }
        DBRestingHeartrateData dBRestingHeartrateData = (DBRestingHeartrateData) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBRestingHeartrateData.hdid) && this.timestamp == dBRestingHeartrateData.timestamp && this.restingHeartrate == dBRestingHeartrateData.restingHeartrate) {
            return true;
        }
        return false;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1178getHdidV9ZILtA() {
        return this.hdid;
    }

    public final int getRestingHeartrate() {
        return this.restingHeartrate;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Integer.hashCode(this.restingHeartrate) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBRestingHeartrateData(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", restingHeartrate=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.restingHeartrate, ')');
    }

    private DBRestingHeartrateData(String hdid, long j, int r5) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.restingHeartrate = r5;
    }
}
