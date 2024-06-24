package com.animaconnected.watch.workout;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.graphs.PointEntry;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeartRateViewModel.kt */
/* loaded from: classes3.dex */
public final class HeartRateSummary {
    private final String averageValue;
    private final boolean isEmpty;
    private final String maxValue;
    private final String minValue;
    private final List<PointEntry> points;

    public HeartRateSummary(String maxValue, String minValue, String averageValue, List<PointEntry> points, boolean z) {
        Intrinsics.checkNotNullParameter(maxValue, "maxValue");
        Intrinsics.checkNotNullParameter(minValue, "minValue");
        Intrinsics.checkNotNullParameter(averageValue, "averageValue");
        Intrinsics.checkNotNullParameter(points, "points");
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.averageValue = averageValue;
        this.points = points;
        this.isEmpty = z;
    }

    public static /* synthetic */ HeartRateSummary copy$default(HeartRateSummary heartRateSummary, String str, String str2, String str3, List list, boolean z, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            str = heartRateSummary.maxValue;
        }
        if ((r9 & 2) != 0) {
            str2 = heartRateSummary.minValue;
        }
        String str4 = str2;
        if ((r9 & 4) != 0) {
            str3 = heartRateSummary.averageValue;
        }
        String str5 = str3;
        if ((r9 & 8) != 0) {
            list = heartRateSummary.points;
        }
        List list2 = list;
        if ((r9 & 16) != 0) {
            z = heartRateSummary.isEmpty;
        }
        return heartRateSummary.copy(str, str4, str5, list2, z);
    }

    public final String component1() {
        return this.maxValue;
    }

    public final String component2() {
        return this.minValue;
    }

    public final String component3() {
        return this.averageValue;
    }

    public final List<PointEntry> component4() {
        return this.points;
    }

    public final boolean component5() {
        return this.isEmpty;
    }

    public final HeartRateSummary copy(String maxValue, String minValue, String averageValue, List<PointEntry> points, boolean z) {
        Intrinsics.checkNotNullParameter(maxValue, "maxValue");
        Intrinsics.checkNotNullParameter(minValue, "minValue");
        Intrinsics.checkNotNullParameter(averageValue, "averageValue");
        Intrinsics.checkNotNullParameter(points, "points");
        return new HeartRateSummary(maxValue, minValue, averageValue, points, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeartRateSummary)) {
            return false;
        }
        HeartRateSummary heartRateSummary = (HeartRateSummary) obj;
        if (Intrinsics.areEqual(this.maxValue, heartRateSummary.maxValue) && Intrinsics.areEqual(this.minValue, heartRateSummary.minValue) && Intrinsics.areEqual(this.averageValue, heartRateSummary.averageValue) && Intrinsics.areEqual(this.points, heartRateSummary.points) && this.isEmpty == heartRateSummary.isEmpty) {
            return true;
        }
        return false;
    }

    public final String getAverageValue() {
        return this.averageValue;
    }

    public final String getMaxValue() {
        return this.maxValue;
    }

    public final String getMinValue() {
        return this.minValue;
    }

    public final List<PointEntry> getPoints() {
        return this.points;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isEmpty) + VectorGroup$$ExternalSyntheticOutline0.m(this.points, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.averageValue, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.minValue, this.maxValue.hashCode() * 31, 31), 31), 31);
    }

    public final boolean isEmpty() {
        return this.isEmpty;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HeartRateSummary(maxValue=");
        sb.append(this.maxValue);
        sb.append(", minValue=");
        sb.append(this.minValue);
        sb.append(", averageValue=");
        sb.append(this.averageValue);
        sb.append(", points=");
        sb.append(this.points);
        sb.append(", isEmpty=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isEmpty, ')');
    }
}
