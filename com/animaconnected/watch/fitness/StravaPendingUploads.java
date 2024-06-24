package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StravaPendingUploads.kt */
/* loaded from: classes3.dex */
public final class StravaPendingUploads {
    private final String failure_reason;
    private final String hdid;
    private final long last_attempted_upload;
    private final long timestamp;

    /* compiled from: StravaPendingUploads.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            this.hdidAdapter = hdidAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }
    }

    public /* synthetic */ StravaPendingUploads(long j, String str, String str2, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, j2);
    }

    /* renamed from: copy-kRTOawE$default, reason: not valid java name */
    public static /* synthetic */ StravaPendingUploads m1497copykRTOawE$default(StravaPendingUploads stravaPendingUploads, long j, String str, String str2, long j2, int r14, Object obj) {
        if ((r14 & 1) != 0) {
            j = stravaPendingUploads.timestamp;
        }
        long j3 = j;
        if ((r14 & 2) != 0) {
            str = stravaPendingUploads.hdid;
        }
        String str3 = str;
        if ((r14 & 4) != 0) {
            str2 = stravaPendingUploads.failure_reason;
        }
        String str4 = str2;
        if ((r14 & 8) != 0) {
            j2 = stravaPendingUploads.last_attempted_upload;
        }
        return stravaPendingUploads.m1499copykRTOawE(j3, str3, str4, j2);
    }

    public final long component1() {
        return this.timestamp;
    }

    /* renamed from: component2-V9ZILtA, reason: not valid java name */
    public final String m1498component2V9ZILtA() {
        return this.hdid;
    }

    public final String component3() {
        return this.failure_reason;
    }

    public final long component4() {
        return this.last_attempted_upload;
    }

    /* renamed from: copy-kRTOawE, reason: not valid java name */
    public final StravaPendingUploads m1499copykRTOawE(long j, String hdid, String failure_reason, long j2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(failure_reason, "failure_reason");
        return new StravaPendingUploads(j, hdid, failure_reason, j2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StravaPendingUploads)) {
            return false;
        }
        StravaPendingUploads stravaPendingUploads = (StravaPendingUploads) obj;
        if (this.timestamp == stravaPendingUploads.timestamp && HistoryDeviceId.m1559equalsimpl0(this.hdid, stravaPendingUploads.hdid) && Intrinsics.areEqual(this.failure_reason, stravaPendingUploads.failure_reason) && this.last_attempted_upload == stravaPendingUploads.last_attempted_upload) {
            return true;
        }
        return false;
    }

    public final String getFailure_reason() {
        return this.failure_reason;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1500getHdidV9ZILtA() {
        return this.hdid;
    }

    public final long getLast_attempted_upload() {
        return this.last_attempted_upload;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Long.hashCode(this.last_attempted_upload) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.failure_reason, (HistoryDeviceId.m1560hashCodeimpl(this.hdid) + (Long.hashCode(this.timestamp) * 31)) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StravaPendingUploads(timestamp=");
        sb.append(this.timestamp);
        sb.append(", hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", failure_reason=");
        sb.append(this.failure_reason);
        sb.append(", last_attempted_upload=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.last_attempted_upload, ')');
    }

    private StravaPendingUploads(long j, String hdid, String failure_reason, long j2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(failure_reason, "failure_reason");
        this.timestamp = j;
        this.hdid = hdid;
        this.failure_reason = failure_reason;
        this.last_attempted_upload = j2;
    }
}
