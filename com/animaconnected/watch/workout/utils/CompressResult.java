package com.animaconnected.watch.workout.utils;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.animaconnected.watch.graphs.LineChartValue;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeartrateCompressor.kt */
/* loaded from: classes3.dex */
public final class CompressResult {
    private final LineChartValue avg;
    private final List<DataPoint> data;
    private final Integer max;
    private final Integer min;

    public CompressResult(Integer num, LineChartValue avg, Integer num2, List<DataPoint> data) {
        Intrinsics.checkNotNullParameter(avg, "avg");
        Intrinsics.checkNotNullParameter(data, "data");
        this.min = num;
        this.avg = avg;
        this.max = num2;
        this.data = data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CompressResult copy$default(CompressResult compressResult, Integer num, LineChartValue lineChartValue, Integer num2, List list, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            num = compressResult.min;
        }
        if ((r5 & 2) != 0) {
            lineChartValue = compressResult.avg;
        }
        if ((r5 & 4) != 0) {
            num2 = compressResult.max;
        }
        if ((r5 & 8) != 0) {
            list = compressResult.data;
        }
        return compressResult.copy(num, lineChartValue, num2, list);
    }

    public final Integer component1() {
        return this.min;
    }

    public final LineChartValue component2() {
        return this.avg;
    }

    public final Integer component3() {
        return this.max;
    }

    public final List<DataPoint> component4() {
        return this.data;
    }

    public final CompressResult copy(Integer num, LineChartValue avg, Integer num2, List<DataPoint> data) {
        Intrinsics.checkNotNullParameter(avg, "avg");
        Intrinsics.checkNotNullParameter(data, "data");
        return new CompressResult(num, avg, num2, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompressResult)) {
            return false;
        }
        CompressResult compressResult = (CompressResult) obj;
        if (Intrinsics.areEqual(this.min, compressResult.min) && Intrinsics.areEqual(this.avg, compressResult.avg) && Intrinsics.areEqual(this.max, compressResult.max) && Intrinsics.areEqual(this.data, compressResult.data)) {
            return true;
        }
        return false;
    }

    public final LineChartValue getAvg() {
        return this.avg;
    }

    public final List<DataPoint> getData() {
        return this.data;
    }

    public final Integer getMax() {
        return this.max;
    }

    public final Integer getMin() {
        return this.min;
    }

    public int hashCode() {
        int hashCode;
        Integer num = this.min;
        int r1 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int hashCode2 = (this.avg.hashCode() + (hashCode * 31)) * 31;
        Integer num2 = this.max;
        if (num2 != null) {
            r1 = num2.hashCode();
        }
        return this.data.hashCode() + ((hashCode2 + r1) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CompressResult(min=");
        sb.append(this.min);
        sb.append(", avg=");
        sb.append(this.avg);
        sb.append(", max=");
        sb.append(this.max);
        sb.append(", data=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.data, ')');
    }
}
