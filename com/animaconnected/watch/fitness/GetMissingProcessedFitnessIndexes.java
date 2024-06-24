package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetMissingProcessedFitnessIndexes.kt */
/* loaded from: classes3.dex */
public final class GetMissingProcessedFitnessIndexes {
    private final String hdid;
    private final long start_timestamp;

    public /* synthetic */ GetMissingProcessedFitnessIndexes(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    /* renamed from: copy-cu7-zPM$default, reason: not valid java name */
    public static /* synthetic */ GetMissingProcessedFitnessIndexes m1429copycu7zPM$default(GetMissingProcessedFitnessIndexes getMissingProcessedFitnessIndexes, String str, long j, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = getMissingProcessedFitnessIndexes.hdid;
        }
        if ((r4 & 2) != 0) {
            j = getMissingProcessedFitnessIndexes.start_timestamp;
        }
        return getMissingProcessedFitnessIndexes.m1431copycu7zPM(str, j);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1430component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.start_timestamp;
    }

    /* renamed from: copy-cu7-zPM, reason: not valid java name */
    public final GetMissingProcessedFitnessIndexes m1431copycu7zPM(String hdid, long j) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new GetMissingProcessedFitnessIndexes(hdid, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetMissingProcessedFitnessIndexes)) {
            return false;
        }
        GetMissingProcessedFitnessIndexes getMissingProcessedFitnessIndexes = (GetMissingProcessedFitnessIndexes) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, getMissingProcessedFitnessIndexes.hdid) && this.start_timestamp == getMissingProcessedFitnessIndexes.start_timestamp) {
            return true;
        }
        return false;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1432getHdidV9ZILtA() {
        return this.hdid;
    }

    public final long getStart_timestamp() {
        return this.start_timestamp;
    }

    public int hashCode() {
        return Long.hashCode(this.start_timestamp) + (HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetMissingProcessedFitnessIndexes(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", start_timestamp=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.start_timestamp, ')');
    }

    private GetMissingProcessedFitnessIndexes(String hdid, long j) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.start_timestamp = j;
    }
}
