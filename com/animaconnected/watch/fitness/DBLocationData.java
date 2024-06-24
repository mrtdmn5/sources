package com.animaconnected.watch.fitness;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: DBLocationData.kt */
/* loaded from: classes3.dex */
public final class DBLocationData {
    private final boolean accepted;
    private final float accuracy;
    private final double altitude;
    private final String hdid;
    private final double lat;

    /* renamed from: long, reason: not valid java name */
    private final double f108long;
    private final long timestamp;

    /* compiled from: DBLocationData.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Float, Double> accuracyAdapter;
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Float, Double> accuracyAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(accuracyAdapter, "accuracyAdapter");
            this.hdidAdapter = hdidAdapter;
            this.accuracyAdapter = accuracyAdapter;
        }

        public final ColumnAdapter<Float, Double> getAccuracyAdapter() {
            return this.accuracyAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }
    }

    public /* synthetic */ DBLocationData(String str, long j, double d, double d2, float f, double d3, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, d, d2, f, d3, z);
    }

    /* renamed from: copy-EBUUAns$default, reason: not valid java name */
    public static /* synthetic */ DBLocationData m1167copyEBUUAns$default(DBLocationData dBLocationData, String str, long j, double d, double d2, float f, double d3, boolean z, int r24, Object obj) {
        String str2;
        long j2;
        double d4;
        double d5;
        float f2;
        double d6;
        boolean z2;
        if ((r24 & 1) != 0) {
            str2 = dBLocationData.hdid;
        } else {
            str2 = str;
        }
        if ((r24 & 2) != 0) {
            j2 = dBLocationData.timestamp;
        } else {
            j2 = j;
        }
        if ((r24 & 4) != 0) {
            d4 = dBLocationData.f108long;
        } else {
            d4 = d;
        }
        if ((r24 & 8) != 0) {
            d5 = dBLocationData.lat;
        } else {
            d5 = d2;
        }
        if ((r24 & 16) != 0) {
            f2 = dBLocationData.accuracy;
        } else {
            f2 = f;
        }
        if ((r24 & 32) != 0) {
            d6 = dBLocationData.altitude;
        } else {
            d6 = d3;
        }
        if ((r24 & 64) != 0) {
            z2 = dBLocationData.accepted;
        } else {
            z2 = z;
        }
        return dBLocationData.m1169copyEBUUAns(str2, j2, d4, d5, f2, d6, z2);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1168component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final double component3() {
        return this.f108long;
    }

    public final double component4() {
        return this.lat;
    }

    public final float component5() {
        return this.accuracy;
    }

    public final double component6() {
        return this.altitude;
    }

    public final boolean component7() {
        return this.accepted;
    }

    /* renamed from: copy-EBUUAns, reason: not valid java name */
    public final DBLocationData m1169copyEBUUAns(String hdid, long j, double d, double d2, float f, double d3, boolean z) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBLocationData(hdid, j, d, d2, f, d3, z, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBLocationData)) {
            return false;
        }
        DBLocationData dBLocationData = (DBLocationData) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBLocationData.hdid) && this.timestamp == dBLocationData.timestamp && Double.compare(this.f108long, dBLocationData.f108long) == 0 && Double.compare(this.lat, dBLocationData.lat) == 0 && Float.compare(this.accuracy, dBLocationData.accuracy) == 0 && Double.compare(this.altitude, dBLocationData.altitude) == 0 && this.accepted == dBLocationData.accepted) {
            return true;
        }
        return false;
    }

    public final boolean getAccepted() {
        return this.accepted;
    }

    public final float getAccuracy() {
        return this.accuracy;
    }

    public final double getAltitude() {
        return this.altitude;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1170getHdidV9ZILtA() {
        return this.hdid;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLong() {
        return this.f108long;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Boolean.hashCode(this.accepted) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.altitude, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.accuracy, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.lat, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.f108long, Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31), 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBLocationData(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", long=");
        sb.append(this.f108long);
        sb.append(", lat=");
        sb.append(this.lat);
        sb.append(", accuracy=");
        sb.append(this.accuracy);
        sb.append(", altitude=");
        sb.append(this.altitude);
        sb.append(", accepted=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.accepted, ')');
    }

    private DBLocationData(String hdid, long j, double d, double d2, float f, double d3, boolean z) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.f108long = d;
        this.lat = d2;
        this.accuracy = f;
        this.altitude = d3;
        this.accepted = z;
    }
}
