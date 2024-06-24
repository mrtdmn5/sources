package com.animaconnected.watch.workout.utils;

import com.animaconnected.watch.graphs.LineChartValue;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeartrateCompressor.kt */
/* loaded from: classes3.dex */
public final class DataPoint {
    private final LineChartValue avgValue;
    private final long timestamp;

    public DataPoint(long j, LineChartValue avgValue) {
        Intrinsics.checkNotNullParameter(avgValue, "avgValue");
        this.timestamp = j;
        this.avgValue = avgValue;
    }

    public static /* synthetic */ DataPoint copy$default(DataPoint dataPoint, long j, LineChartValue lineChartValue, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = dataPoint.timestamp;
        }
        if ((r4 & 2) != 0) {
            lineChartValue = dataPoint.avgValue;
        }
        return dataPoint.copy(j, lineChartValue);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final LineChartValue component2() {
        return this.avgValue;
    }

    public final DataPoint copy(long j, LineChartValue avgValue) {
        Intrinsics.checkNotNullParameter(avgValue, "avgValue");
        return new DataPoint(j, avgValue);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataPoint)) {
            return false;
        }
        DataPoint dataPoint = (DataPoint) obj;
        if (this.timestamp == dataPoint.timestamp && Intrinsics.areEqual(this.avgValue, dataPoint.avgValue)) {
            return true;
        }
        return false;
    }

    public final LineChartValue getAvgValue() {
        return this.avgValue;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return this.avgValue.hashCode() + (Long.hashCode(this.timestamp) * 31);
    }

    public String toString() {
        return "DataPoint(timestamp=" + this.timestamp + ", avgValue=" + this.avgValue + ')';
    }
}
