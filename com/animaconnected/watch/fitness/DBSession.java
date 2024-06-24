package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: DBSession.kt */
/* loaded from: classes3.dex */
public final class DBSession {
    private final long active_time_ms;
    private final int calories;
    private final int elevationGain;
    private final long end_timestamp;
    private final Float fitness_index;
    private final boolean gps;
    private final String hdid;
    private final long session_id;
    private final long start_timestamp;
    private final Integer status;
    private final int steps;
    private final double total_distance_meter;
    private final long total_time_ms;
    private final int type;

    /* compiled from: DBSession.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> caloriesAdapter;
        private final ColumnAdapter<Integer, Long> elevationGainAdapter;
        private final ColumnAdapter<Float, Double> fitness_indexAdapter;
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> statusAdapter;
        private final ColumnAdapter<Integer, Long> stepsAdapter;
        private final ColumnAdapter<Integer, Long> typeAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> stepsAdapter, ColumnAdapter<Integer, Long> caloriesAdapter, ColumnAdapter<Integer, Long> elevationGainAdapter, ColumnAdapter<Integer, Long> typeAdapter, ColumnAdapter<Float, Double> fitness_indexAdapter, ColumnAdapter<Integer, Long> statusAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(stepsAdapter, "stepsAdapter");
            Intrinsics.checkNotNullParameter(caloriesAdapter, "caloriesAdapter");
            Intrinsics.checkNotNullParameter(elevationGainAdapter, "elevationGainAdapter");
            Intrinsics.checkNotNullParameter(typeAdapter, "typeAdapter");
            Intrinsics.checkNotNullParameter(fitness_indexAdapter, "fitness_indexAdapter");
            Intrinsics.checkNotNullParameter(statusAdapter, "statusAdapter");
            this.hdidAdapter = hdidAdapter;
            this.stepsAdapter = stepsAdapter;
            this.caloriesAdapter = caloriesAdapter;
            this.elevationGainAdapter = elevationGainAdapter;
            this.typeAdapter = typeAdapter;
            this.fitness_indexAdapter = fitness_indexAdapter;
            this.statusAdapter = statusAdapter;
        }

        public final ColumnAdapter<Integer, Long> getCaloriesAdapter() {
            return this.caloriesAdapter;
        }

        public final ColumnAdapter<Integer, Long> getElevationGainAdapter() {
            return this.elevationGainAdapter;
        }

        public final ColumnAdapter<Float, Double> getFitness_indexAdapter() {
            return this.fitness_indexAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getStatusAdapter() {
            return this.statusAdapter;
        }

        public final ColumnAdapter<Integer, Long> getStepsAdapter() {
            return this.stepsAdapter;
        }

        public final ColumnAdapter<Integer, Long> getTypeAdapter() {
            return this.typeAdapter;
        }
    }

    public /* synthetic */ DBSession(String str, long j, long j2, long j3, long j4, double d, int r12, int r13, int r14, int r15, boolean z, long j5, Float f, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, j3, j4, d, r12, r13, r14, r15, z, j5, f, num);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1180component1V9ZILtA() {
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

    /* renamed from: copy-us9H8TY, reason: not valid java name */
    public final DBSession m1181copyus9H8TY(String hdid, long j, long j2, long j3, long j4, double d, int r36, int r37, int r38, int r39, boolean z, long j5, Float f, Integer num) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBSession(hdid, j, j2, j3, j4, d, r36, r37, r38, r39, z, j5, f, num, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBSession)) {
            return false;
        }
        DBSession dBSession = (DBSession) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBSession.hdid) && this.start_timestamp == dBSession.start_timestamp && this.end_timestamp == dBSession.end_timestamp && this.total_time_ms == dBSession.total_time_ms && this.active_time_ms == dBSession.active_time_ms && Double.compare(this.total_distance_meter, dBSession.total_distance_meter) == 0 && this.steps == dBSession.steps && this.calories == dBSession.calories && this.elevationGain == dBSession.elevationGain && this.type == dBSession.type && this.gps == dBSession.gps && this.session_id == dBSession.session_id && Intrinsics.areEqual(this.fitness_index, dBSession.fitness_index) && Intrinsics.areEqual(this.status, dBSession.status)) {
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

    public final Float getFitness_index() {
        return this.fitness_index;
    }

    public final boolean getGps() {
        return this.gps;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1182getHdidV9ZILtA() {
        return this.hdid;
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
        return r0 + r2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBSession(hdid=");
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
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.status, ')');
    }

    private DBSession(String hdid, long j, long j2, long j3, long j4, double d, int r15, int r16, int r17, int r18, boolean z, long j5, Float f, Integer num) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.start_timestamp = j;
        this.end_timestamp = j2;
        this.total_time_ms = j3;
        this.active_time_ms = j4;
        this.total_distance_meter = d;
        this.steps = r15;
        this.calories = r16;
        this.elevationGain = r17;
        this.type = r18;
        this.gps = z;
        this.session_id = j5;
        this.fitness_index = f;
        this.status = num;
    }
}
