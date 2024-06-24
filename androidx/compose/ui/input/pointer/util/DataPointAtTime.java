package androidx.compose.ui.input.pointer.util;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;

/* compiled from: VelocityTracker.kt */
/* loaded from: classes.dex */
public final class DataPointAtTime {
    public float dataPoint;
    public long time;

    public DataPointAtTime(float f, long j) {
        this.time = j;
        this.dataPoint = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataPointAtTime)) {
            return false;
        }
        DataPointAtTime dataPointAtTime = (DataPointAtTime) obj;
        if (this.time == dataPointAtTime.time && Float.compare(this.dataPoint, dataPointAtTime.dataPoint) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.dataPoint) + (Long.hashCode(this.time) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DataPointAtTime(time=");
        sb.append(this.time);
        sb.append(", dataPoint=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.dataPoint, ')');
    }
}
