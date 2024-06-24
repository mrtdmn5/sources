package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBDiagnostics.kt */
/* loaded from: classes3.dex */
public final class DBDiagnostics {
    private final String hdid;
    private final String key;
    private final long timestamp;
    private final int value_;

    /* compiled from: DBDiagnostics.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> value_Adapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> value_Adapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(value_Adapter, "value_Adapter");
            this.hdidAdapter = hdidAdapter;
            this.value_Adapter = value_Adapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getValue_Adapter() {
            return this.value_Adapter;
        }
    }

    public /* synthetic */ DBDiagnostics(String str, long j, String str2, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, r5);
    }

    /* renamed from: copy-4i7cvns$default, reason: not valid java name */
    public static /* synthetic */ DBDiagnostics m1135copy4i7cvns$default(DBDiagnostics dBDiagnostics, String str, long j, String str2, int r8, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            str = dBDiagnostics.hdid;
        }
        if ((r9 & 2) != 0) {
            j = dBDiagnostics.timestamp;
        }
        long j2 = j;
        if ((r9 & 4) != 0) {
            str2 = dBDiagnostics.key;
        }
        String str3 = str2;
        if ((r9 & 8) != 0) {
            r8 = dBDiagnostics.value_;
        }
        return dBDiagnostics.m1137copy4i7cvns(str, j2, str3, r8);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1136component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.key;
    }

    public final int component4() {
        return this.value_;
    }

    /* renamed from: copy-4i7cvns, reason: not valid java name */
    public final DBDiagnostics m1137copy4i7cvns(String hdid, long j, String key, int r13) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(key, "key");
        return new DBDiagnostics(hdid, j, key, r13, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBDiagnostics)) {
            return false;
        }
        DBDiagnostics dBDiagnostics = (DBDiagnostics) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBDiagnostics.hdid) && this.timestamp == dBDiagnostics.timestamp && Intrinsics.areEqual(this.key, dBDiagnostics.key) && this.value_ == dBDiagnostics.value_) {
            return true;
        }
        return false;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1138getHdidV9ZILtA() {
        return this.hdid;
    }

    public final String getKey() {
        return this.key;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getValue_() {
        return this.value_;
    }

    public int hashCode() {
        return Integer.hashCode(this.value_) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.key, Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBDiagnostics(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", key=");
        sb.append(this.key);
        sb.append(", value_=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.value_, ')');
    }

    private DBDiagnostics(String hdid, long j, String key, int r6) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(key, "key");
        this.hdid = hdid;
        this.timestamp = j;
        this.key = key;
        this.value_ = r6;
    }
}
