package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetRawHRAndActivty.kt */
/* loaded from: classes3.dex */
public final class GetRawHRAndActivty {
    private final Integer activity_class;
    private final String hdid;
    private final Integer heartrate;
    private final long timestamp;

    public /* synthetic */ GetRawHRAndActivty(String str, long j, Integer num, Integer num2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, num, num2);
    }

    /* renamed from: copy-4i7cvns$default, reason: not valid java name */
    public static /* synthetic */ GetRawHRAndActivty m1433copy4i7cvns$default(GetRawHRAndActivty getRawHRAndActivty, String str, long j, Integer num, Integer num2, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            str = getRawHRAndActivty.hdid;
        }
        if ((r9 & 2) != 0) {
            j = getRawHRAndActivty.timestamp;
        }
        long j2 = j;
        if ((r9 & 4) != 0) {
            num = getRawHRAndActivty.heartrate;
        }
        Integer num3 = num;
        if ((r9 & 8) != 0) {
            num2 = getRawHRAndActivty.activity_class;
        }
        return getRawHRAndActivty.m1435copy4i7cvns(str, j2, num3, num2);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1434component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final Integer component3() {
        return this.heartrate;
    }

    public final Integer component4() {
        return this.activity_class;
    }

    /* renamed from: copy-4i7cvns, reason: not valid java name */
    public final GetRawHRAndActivty m1435copy4i7cvns(String hdid, long j, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new GetRawHRAndActivty(hdid, j, num, num2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetRawHRAndActivty)) {
            return false;
        }
        GetRawHRAndActivty getRawHRAndActivty = (GetRawHRAndActivty) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, getRawHRAndActivty.hdid) && this.timestamp == getRawHRAndActivty.timestamp && Intrinsics.areEqual(this.heartrate, getRawHRAndActivty.heartrate) && Intrinsics.areEqual(this.activity_class, getRawHRAndActivty.activity_class)) {
            return true;
        }
        return false;
    }

    public final Integer getActivity_class() {
        return this.activity_class;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1436getHdidV9ZILtA() {
        return this.hdid;
    }

    public final Integer getHeartrate() {
        return this.heartrate;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int hashCode;
        int m = Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31);
        Integer num = this.heartrate;
        int r2 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Integer num2 = this.activity_class;
        if (num2 != null) {
            r2 = num2.hashCode();
        }
        return r0 + r2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetRawHRAndActivty(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", heartrate=");
        sb.append(this.heartrate);
        sb.append(", activity_class=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.activity_class, ')');
    }

    private GetRawHRAndActivty(String hdid, long j, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.heartrate = num;
        this.activity_class = num2;
    }
}
