package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: GetSessionsWithPendingUpload.kt */
/* loaded from: classes3.dex */
public final class GetSessionsWithPendingUpload {
    private final long active_time_ms;
    private final int calories;
    private final int elevationGain;
    private final long end_timestamp;
    private final String failure_reason;
    private final Float fitness_index;
    private final boolean gps;
    private final String hdid;
    private final String hdid_;
    private final long last_attempted_upload;
    private final long session_id;
    private final long start_timestamp;
    private final Integer status;
    private final int steps;
    private final long timestamp;
    private final double total_distance_meter;
    private final long total_time_ms;
    private final int type;

    private GetSessionsWithPendingUpload(String str, long j, long j2, long j3, long j4, double d, int r19, int r20, int r21, int r22, boolean z, long j5, Float f, Integer num, long j6, String str2, String str3, long j7) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, "hdid", str2, "hdid_", str3, "failure_reason");
        this.hdid = str;
        this.start_timestamp = j;
        this.end_timestamp = j2;
        this.total_time_ms = j3;
        this.active_time_ms = j4;
        this.total_distance_meter = d;
        this.steps = r19;
        this.calories = r20;
        this.elevationGain = r21;
        this.type = r22;
        this.gps = z;
        this.session_id = j5;
        this.fitness_index = f;
        this.status = num;
        this.timestamp = j6;
        this.hdid_ = str2;
        this.failure_reason = str3;
        this.last_attempted_upload = j7;
    }

    /* renamed from: copy-MV0Ov2Y$default, reason: not valid java name */
    public static /* synthetic */ GetSessionsWithPendingUpload m1437copyMV0Ov2Y$default(GetSessionsWithPendingUpload getSessionsWithPendingUpload, String str, long j, long j2, long j3, long j4, double d, int r29, int r30, int r31, int r32, boolean z, long j5, Float f, Integer num, long j6, String str2, String str3, long j7, int r44, Object obj) {
        String str4 = (r44 & 1) != 0 ? getSessionsWithPendingUpload.hdid : str;
        long j8 = (r44 & 2) != 0 ? getSessionsWithPendingUpload.start_timestamp : j;
        long j9 = (r44 & 4) != 0 ? getSessionsWithPendingUpload.end_timestamp : j2;
        long j10 = (r44 & 8) != 0 ? getSessionsWithPendingUpload.total_time_ms : j3;
        long j11 = (r44 & 16) != 0 ? getSessionsWithPendingUpload.active_time_ms : j4;
        double d2 = (r44 & 32) != 0 ? getSessionsWithPendingUpload.total_distance_meter : d;
        int r13 = (r44 & 64) != 0 ? getSessionsWithPendingUpload.steps : r29;
        int r14 = (r44 & 128) != 0 ? getSessionsWithPendingUpload.calories : r30;
        int r312 = (r44 & 256) != 0 ? getSessionsWithPendingUpload.elevationGain : r31;
        int r322 = (r44 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? getSessionsWithPendingUpload.type : r32;
        boolean z2 = (r44 & 1024) != 0 ? getSessionsWithPendingUpload.gps : z;
        int r302 = r14;
        long j12 = (r44 & 2048) != 0 ? getSessionsWithPendingUpload.session_id : j5;
        Float f2 = (r44 & 4096) != 0 ? getSessionsWithPendingUpload.fitness_index : f;
        return getSessionsWithPendingUpload.m1440copyMV0Ov2Y(str4, j8, j9, j10, j11, d2, r13, r302, r312, r322, z2, j12, f2, (r44 & DfuBaseService.ERROR_REMOTE_MASK) != 0 ? getSessionsWithPendingUpload.status : num, (r44 & DfuBaseService.ERROR_CONNECTION_MASK) != 0 ? getSessionsWithPendingUpload.timestamp : j6, (r44 & DfuBaseService.ERROR_CONNECTION_STATE_MASK) != 0 ? getSessionsWithPendingUpload.hdid_ : str2, (65536 & r44) != 0 ? getSessionsWithPendingUpload.failure_reason : str3, (r44 & 131072) != 0 ? getSessionsWithPendingUpload.last_attempted_upload : j7);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1438component1V9ZILtA() {
        return this.hdid;
    }

    public final int component10() {
        return this.type;
    }

    public final boolean component11() {
        return this.gps;
    }

    public final long component12() {
        return this.session_id;
    }

    public final Float component13() {
        return this.fitness_index;
    }

    public final Integer component14() {
        return this.status;
    }

    public final long component15() {
        return this.timestamp;
    }

    /* renamed from: component16-V9ZILtA, reason: not valid java name */
    public final String m1439component16V9ZILtA() {
        return this.hdid_;
    }

    public final String component17() {
        return this.failure_reason;
    }

    public final long component18() {
        return this.last_attempted_upload;
    }

    public final long component2() {
        return this.start_timestamp;
    }

    public final long component3() {
        return this.end_timestamp;
    }

    public final long component4() {
        return this.total_time_ms;
    }

    public final long component5() {
        return this.active_time_ms;
    }

    public final double component6() {
        return this.total_distance_meter;
    }

    public final int component7() {
        return this.steps;
    }

    public final int component8() {
        return this.calories;
    }

    public final int component9() {
        return this.elevationGain;
    }

    /* renamed from: copy-MV0Ov2Y, reason: not valid java name */
    public final GetSessionsWithPendingUpload m1440copyMV0Ov2Y(String hdid, long j, long j2, long j3, long j4, double d, int r42, int r43, int r44, int r45, boolean z, long j5, Float f, Integer num, long j6, String hdid_, String failure_reason, long j7) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        Intrinsics.checkNotNullParameter(hdid_, "hdid_");
        Intrinsics.checkNotNullParameter(failure_reason, "failure_reason");
        return new GetSessionsWithPendingUpload(hdid, j, j2, j3, j4, d, r42, r43, r44, r45, z, j5, f, num, j6, hdid_, failure_reason, j7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSessionsWithPendingUpload)) {
            return false;
        }
        GetSessionsWithPendingUpload getSessionsWithPendingUpload = (GetSessionsWithPendingUpload) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, getSessionsWithPendingUpload.hdid) && this.start_timestamp == getSessionsWithPendingUpload.start_timestamp && this.end_timestamp == getSessionsWithPendingUpload.end_timestamp && this.total_time_ms == getSessionsWithPendingUpload.total_time_ms && this.active_time_ms == getSessionsWithPendingUpload.active_time_ms && Double.compare(this.total_distance_meter, getSessionsWithPendingUpload.total_distance_meter) == 0 && this.steps == getSessionsWithPendingUpload.steps && this.calories == getSessionsWithPendingUpload.calories && this.elevationGain == getSessionsWithPendingUpload.elevationGain && this.type == getSessionsWithPendingUpload.type && this.gps == getSessionsWithPendingUpload.gps && this.session_id == getSessionsWithPendingUpload.session_id && Intrinsics.areEqual(this.fitness_index, getSessionsWithPendingUpload.fitness_index) && Intrinsics.areEqual(this.status, getSessionsWithPendingUpload.status) && this.timestamp == getSessionsWithPendingUpload.timestamp && HistoryDeviceId.m1559equalsimpl0(this.hdid_, getSessionsWithPendingUpload.hdid_) && Intrinsics.areEqual(this.failure_reason, getSessionsWithPendingUpload.failure_reason) && this.last_attempted_upload == getSessionsWithPendingUpload.last_attempted_upload) {
            return true;
        }
        return false;
    }

    public final long getActive_time_ms() {
        return this.active_time_ms;
    }

    public final int getCalories() {
        return this.calories;
    }

    public final int getElevationGain() {
        return this.elevationGain;
    }

    public final long getEnd_timestamp() {
        return this.end_timestamp;
    }

    public final String getFailure_reason() {
        return this.failure_reason;
    }

    public final Float getFitness_index() {
        return this.fitness_index;
    }

    public final boolean getGps() {
        return this.gps;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1441getHdidV9ZILtA() {
        return this.hdid;
    }

    /* renamed from: getHdid_-V9ZILtA, reason: not valid java name */
    public final String m1442getHdid_V9ZILtA() {
        return this.hdid_;
    }

    public final long getLast_attempted_upload() {
        return this.last_attempted_upload;
    }

    public final long getSession_id() {
        return this.session_id;
    }

    public final long getStart_timestamp() {
        return this.start_timestamp;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final int getSteps() {
        return this.steps;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final double getTotal_distance_meter() {
        return this.total_distance_meter;
    }

    public final long getTotal_time_ms() {
        return this.total_time_ms;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode;
        int m = Scale$$ExternalSyntheticOutline0.m(this.session_id, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.gps, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.type, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.elevationGain, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.calories, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.steps, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.total_distance_meter, Scale$$ExternalSyntheticOutline0.m(this.active_time_ms, Scale$$ExternalSyntheticOutline0.m(this.total_time_ms, Scale$$ExternalSyntheticOutline0.m(this.end_timestamp, Scale$$ExternalSyntheticOutline0.m(this.start_timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
        Float f = this.fitness_index;
        int r2 = 0;
        if (f == null) {
            hashCode = 0;
        } else {
            hashCode = f.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Integer num = this.status;
        if (num != null) {
            r2 = num.hashCode();
        }
        return Long.hashCode(this.last_attempted_upload) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.failure_reason, (HistoryDeviceId.m1560hashCodeimpl(this.hdid_) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, (r0 + r2) * 31, 31)) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetSessionsWithPendingUpload(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", start_timestamp=");
        sb.append(this.start_timestamp);
        sb.append(", end_timestamp=");
        sb.append(this.end_timestamp);
        sb.append(", total_time_ms=");
        sb.append(this.total_time_ms);
        sb.append(", active_time_ms=");
        sb.append(this.active_time_ms);
        sb.append(", total_distance_meter=");
        sb.append(this.total_distance_meter);
        sb.append(", steps=");
        sb.append(this.steps);
        sb.append(", calories=");
        sb.append(this.calories);
        sb.append(", elevationGain=");
        sb.append(this.elevationGain);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", gps=");
        sb.append(this.gps);
        sb.append(", session_id=");
        sb.append(this.session_id);
        sb.append(", fitness_index=");
        sb.append(this.fitness_index);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", hdid_=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid_, sb, ", failure_reason=");
        sb.append(this.failure_reason);
        sb.append(", last_attempted_upload=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.last_attempted_upload, ')');
    }

    public /* synthetic */ GetSessionsWithPendingUpload(String str, long j, long j2, long j3, long j4, double d, int r12, int r13, int r14, int r15, boolean z, long j5, Float f, Integer num, long j6, String str2, String str3, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, j3, j4, d, r12, r13, r14, r15, z, j5, f, num, j6, str2, str3, j7);
    }
}
