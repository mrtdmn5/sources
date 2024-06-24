package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: DBElevation.kt */
/* loaded from: classes3.dex */
public final class DBElevation {
    private final double elevation;
    private final String hdid;
    private final double lat;

    /* renamed from: long, reason: not valid java name */
    private final double f107long;
    private final int number;
    private final double resolution;
    private final long session_timestamp;

    /* compiled from: DBElevation.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> numberAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> numberAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(numberAdapter, "numberAdapter");
            this.hdidAdapter = hdidAdapter;
            this.numberAdapter = numberAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getNumberAdapter() {
            return this.numberAdapter;
        }
    }

    public /* synthetic */ DBElevation(String str, long j, int r4, double d, double d2, double d3, double d4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4, d, d2, d3, d4);
    }

    /* renamed from: copy-EBUUAns$default, reason: not valid java name */
    public static /* synthetic */ DBElevation m1139copyEBUUAns$default(DBElevation dBElevation, String str, long j, int r17, double d, double d2, double d3, double d4, int r26, Object obj) {
        String str2;
        long j2;
        int r4;
        double d5;
        double d6;
        double d7;
        double d8;
        if ((r26 & 1) != 0) {
            str2 = dBElevation.hdid;
        } else {
            str2 = str;
        }
        if ((r26 & 2) != 0) {
            j2 = dBElevation.session_timestamp;
        } else {
            j2 = j;
        }
        if ((r26 & 4) != 0) {
            r4 = dBElevation.number;
        } else {
            r4 = r17;
        }
        if ((r26 & 8) != 0) {
            d5 = dBElevation.f107long;
        } else {
            d5 = d;
        }
        if ((r26 & 16) != 0) {
            d6 = dBElevation.lat;
        } else {
            d6 = d2;
        }
        if ((r26 & 32) != 0) {
            d7 = dBElevation.elevation;
        } else {
            d7 = d3;
        }
        if ((r26 & 64) != 0) {
            d8 = dBElevation.resolution;
        } else {
            d8 = d4;
        }
        return dBElevation.m1141copyEBUUAns(str2, j2, r4, d5, d6, d7, d8);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1140component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.session_timestamp;
    }

    public final int component3() {
        return this.number;
    }

    public final double component4() {
        return this.f107long;
    }

    public final double component5() {
        return this.lat;
    }

    public final double component6() {
        return this.elevation;
    }

    public final double component7() {
        return this.resolution;
    }

    /* renamed from: copy-EBUUAns, reason: not valid java name */
    public final DBElevation m1141copyEBUUAns(String hdid, long j, int r19, double d, double d2, double d3, double d4) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBElevation(hdid, j, r19, d, d2, d3, d4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBElevation)) {
            return false;
        }
        DBElevation dBElevation = (DBElevation) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBElevation.hdid) && this.session_timestamp == dBElevation.session_timestamp && this.number == dBElevation.number && Double.compare(this.f107long, dBElevation.f107long) == 0 && Double.compare(this.lat, dBElevation.lat) == 0 && Double.compare(this.elevation, dBElevation.elevation) == 0 && Double.compare(this.resolution, dBElevation.resolution) == 0) {
            return true;
        }
        return false;
    }

    public final double getElevation() {
        return this.elevation;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1142getHdidV9ZILtA() {
        return this.hdid;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLong() {
        return this.f107long;
    }

    public final int getNumber() {
        return this.number;
    }

    public final double getResolution() {
        return this.resolution;
    }

    public final long getSession_timestamp() {
        return this.session_timestamp;
    }

    public int hashCode() {
        return Double.hashCode(this.resolution) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.elevation, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.lat, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.f107long, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.number, Scale$$ExternalSyntheticOutline0.m(this.session_timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31), 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBElevation(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", session_timestamp=");
        sb.append(this.session_timestamp);
        sb.append(", number=");
        sb.append(this.number);
        sb.append(", long=");
        sb.append(this.f107long);
        sb.append(", lat=");
        sb.append(this.lat);
        sb.append(", elevation=");
        sb.append(this.elevation);
        sb.append(", resolution=");
        sb.append(this.resolution);
        sb.append(')');
        return sb.toString();
    }

    private DBElevation(String hdid, long j, int r5, double d, double d2, double d3, double d4) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.session_timestamp = j;
        this.number = r5;
        this.f107long = d;
        this.lat = d2;
        this.elevation = d3;
        this.resolution = d4;
    }
}
