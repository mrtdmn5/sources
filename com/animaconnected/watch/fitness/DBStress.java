package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBStress.kt */
/* loaded from: classes3.dex */
public final class DBStress {
    private final String hdid;
    private final int stress;
    private final long timestamp;

    /* compiled from: DBStress.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> stressAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> stressAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(stressAdapter, "stressAdapter");
            this.hdidAdapter = hdidAdapter;
            this.stressAdapter = stressAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getStressAdapter() {
            return this.stressAdapter;
        }
    }

    public /* synthetic */ DBStress(String str, long j, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ DBStress m1203copyOZHprlw$default(DBStress dBStress, String str, long j, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = dBStress.hdid;
        }
        if ((r5 & 2) != 0) {
            j = dBStress.timestamp;
        }
        if ((r5 & 4) != 0) {
            r4 = dBStress.stress;
        }
        return dBStress.m1205copyOZHprlw(str, j, r4);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1204component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.stress;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final DBStress m1205copyOZHprlw(String hdid, long j, int r11) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBStress(hdid, j, r11, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBStress)) {
            return false;
        }
        DBStress dBStress = (DBStress) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBStress.hdid) && this.timestamp == dBStress.timestamp && this.stress == dBStress.stress) {
            return true;
        }
        return false;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1206getHdidV9ZILtA() {
        return this.hdid;
    }

    public final int getStress() {
        return this.stress;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Integer.hashCode(this.stress) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBStress(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", stress=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.stress, ')');
    }

    private DBStress(String hdid, long j, int r5) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.stress = r5;
    }
}
