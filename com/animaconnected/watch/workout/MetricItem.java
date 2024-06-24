package com.animaconnected.watch.workout;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class MetricItem {
    private final MetricType type;
    private final String value;

    public MetricItem(MetricType type, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        this.type = type;
        this.value = value;
    }

    public static /* synthetic */ MetricItem copy$default(MetricItem metricItem, MetricType metricType, String str, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            metricType = metricItem.type;
        }
        if ((r3 & 2) != 0) {
            str = metricItem.value;
        }
        return metricItem.copy(metricType, str);
    }

    public final MetricType component1() {
        return this.type;
    }

    public final String component2() {
        return this.value;
    }

    public final MetricItem copy(MetricType type, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        return new MetricItem(type, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetricItem)) {
            return false;
        }
        MetricItem metricItem = (MetricItem) obj;
        if (this.type == metricItem.type && Intrinsics.areEqual(this.value, metricItem.value)) {
            return true;
        }
        return false;
    }

    public final MetricType getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() + (this.type.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MetricItem(type=");
        sb.append(this.type);
        sb.append(", value=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.value, ')');
    }
}
