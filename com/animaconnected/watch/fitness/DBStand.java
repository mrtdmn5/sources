package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBStand.kt */
/* loaded from: classes3.dex */
public final class DBStand {
    private final String hdid;
    private final int successful_stands;
    private final long timestamp;

    /* compiled from: DBStand.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> successful_standsAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> successful_standsAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(successful_standsAdapter, "successful_standsAdapter");
            this.hdidAdapter = hdidAdapter;
            this.successful_standsAdapter = successful_standsAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getSuccessful_standsAdapter() {
            return this.successful_standsAdapter;
        }
    }

    public /* synthetic */ DBStand(String str, long j, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ DBStand m1199copyOZHprlw$default(DBStand dBStand, String str, long j, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = dBStand.hdid;
        }
        if ((r5 & 2) != 0) {
            j = dBStand.timestamp;
        }
        if ((r5 & 4) != 0) {
            r4 = dBStand.successful_stands;
        }
        return dBStand.m1201copyOZHprlw(str, j, r4);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1200component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.successful_stands;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final DBStand m1201copyOZHprlw(String hdid, long j, int r11) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBStand(hdid, j, r11, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBStand)) {
            return false;
        }
        DBStand dBStand = (DBStand) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBStand.hdid) && this.timestamp == dBStand.timestamp && this.successful_stands == dBStand.successful_stands) {
            return true;
        }
        return false;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1202getHdidV9ZILtA() {
        return this.hdid;
    }

    public final int getSuccessful_stands() {
        return this.successful_stands;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Integer.hashCode(this.successful_stands) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBStand(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", successful_stands=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.successful_stands, ')');
    }

    private DBStand(String hdid, long j, int r5) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.successful_stands = r5;
    }
}
