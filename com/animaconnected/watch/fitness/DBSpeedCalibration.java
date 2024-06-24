package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBSpeedCalibration.kt */
/* loaded from: classes3.dex */
public final class DBSpeedCalibration {
    private final int coefficient;
    private final String hdid;
    private final long timestamp;

    /* compiled from: DBSpeedCalibration.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> coefficientAdapter;
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> coefficientAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(coefficientAdapter, "coefficientAdapter");
            this.hdidAdapter = hdidAdapter;
            this.coefficientAdapter = coefficientAdapter;
        }

        public final ColumnAdapter<Integer, Long> getCoefficientAdapter() {
            return this.coefficientAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }
    }

    public /* synthetic */ DBSpeedCalibration(String str, long j, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ DBSpeedCalibration m1195copyOZHprlw$default(DBSpeedCalibration dBSpeedCalibration, String str, long j, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = dBSpeedCalibration.hdid;
        }
        if ((r5 & 2) != 0) {
            j = dBSpeedCalibration.timestamp;
        }
        if ((r5 & 4) != 0) {
            r4 = dBSpeedCalibration.coefficient;
        }
        return dBSpeedCalibration.m1197copyOZHprlw(str, j, r4);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1196component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.coefficient;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final DBSpeedCalibration m1197copyOZHprlw(String hdid, long j, int r11) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBSpeedCalibration(hdid, j, r11, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBSpeedCalibration)) {
            return false;
        }
        DBSpeedCalibration dBSpeedCalibration = (DBSpeedCalibration) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBSpeedCalibration.hdid) && this.timestamp == dBSpeedCalibration.timestamp && this.coefficient == dBSpeedCalibration.coefficient) {
            return true;
        }
        return false;
    }

    public final int getCoefficient() {
        return this.coefficient;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1198getHdidV9ZILtA() {
        return this.hdid;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Integer.hashCode(this.coefficient) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBSpeedCalibration(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", coefficient=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.coefficient, ')');
    }

    private DBSpeedCalibration(String hdid, long j, int r5) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.coefficient = r5;
    }
}
