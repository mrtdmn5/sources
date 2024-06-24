package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBActivityData.kt */
/* loaded from: classes3.dex */
public final class DBActivityData {
    private final Integer activity_class;
    private final Integer calories;
    private final Integer distance;
    private final String hdid;
    private final Integer other_steps;
    private final Integer rhythmic_steps_cadence;
    private final Integer run_steps;
    private final Float speed;
    private final long timestamp;
    private final Integer walk_steps;

    /* compiled from: DBActivityData.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> activity_classAdapter;
        private final ColumnAdapter<Integer, Long> caloriesAdapter;
        private final ColumnAdapter<Integer, Long> distanceAdapter;
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> other_stepsAdapter;
        private final ColumnAdapter<Integer, Long> rhythmic_steps_cadenceAdapter;
        private final ColumnAdapter<Integer, Long> run_stepsAdapter;
        private final ColumnAdapter<Float, Double> speedAdapter;
        private final ColumnAdapter<Integer, Long> walk_stepsAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> activity_classAdapter, ColumnAdapter<Integer, Long> walk_stepsAdapter, ColumnAdapter<Integer, Long> run_stepsAdapter, ColumnAdapter<Integer, Long> other_stepsAdapter, ColumnAdapter<Integer, Long> rhythmic_steps_cadenceAdapter, ColumnAdapter<Float, Double> speedAdapter, ColumnAdapter<Integer, Long> distanceAdapter, ColumnAdapter<Integer, Long> caloriesAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(activity_classAdapter, "activity_classAdapter");
            Intrinsics.checkNotNullParameter(walk_stepsAdapter, "walk_stepsAdapter");
            Intrinsics.checkNotNullParameter(run_stepsAdapter, "run_stepsAdapter");
            Intrinsics.checkNotNullParameter(other_stepsAdapter, "other_stepsAdapter");
            Intrinsics.checkNotNullParameter(rhythmic_steps_cadenceAdapter, "rhythmic_steps_cadenceAdapter");
            Intrinsics.checkNotNullParameter(speedAdapter, "speedAdapter");
            Intrinsics.checkNotNullParameter(distanceAdapter, "distanceAdapter");
            Intrinsics.checkNotNullParameter(caloriesAdapter, "caloriesAdapter");
            this.hdidAdapter = hdidAdapter;
            this.activity_classAdapter = activity_classAdapter;
            this.walk_stepsAdapter = walk_stepsAdapter;
            this.run_stepsAdapter = run_stepsAdapter;
            this.other_stepsAdapter = other_stepsAdapter;
            this.rhythmic_steps_cadenceAdapter = rhythmic_steps_cadenceAdapter;
            this.speedAdapter = speedAdapter;
            this.distanceAdapter = distanceAdapter;
            this.caloriesAdapter = caloriesAdapter;
        }

        public final ColumnAdapter<Integer, Long> getActivity_classAdapter() {
            return this.activity_classAdapter;
        }

        public final ColumnAdapter<Integer, Long> getCaloriesAdapter() {
            return this.caloriesAdapter;
        }

        public final ColumnAdapter<Integer, Long> getDistanceAdapter() {
            return this.distanceAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getOther_stepsAdapter() {
            return this.other_stepsAdapter;
        }

        public final ColumnAdapter<Integer, Long> getRhythmic_steps_cadenceAdapter() {
            return this.rhythmic_steps_cadenceAdapter;
        }

        public final ColumnAdapter<Integer, Long> getRun_stepsAdapter() {
            return this.run_stepsAdapter;
        }

        public final ColumnAdapter<Float, Double> getSpeedAdapter() {
            return this.speedAdapter;
        }

        public final ColumnAdapter<Integer, Long> getWalk_stepsAdapter() {
            return this.walk_stepsAdapter;
        }
    }

    public /* synthetic */ DBActivityData(String str, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, num, num2, num3, num4, num5, f, num6, num7);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1124component1V9ZILtA() {
        return this.hdid;
    }

    public final Integer component10() {
        return this.calories;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final Integer component3() {
        return this.activity_class;
    }

    public final Integer component4() {
        return this.walk_steps;
    }

    public final Integer component5() {
        return this.run_steps;
    }

    public final Integer component6() {
        return this.other_steps;
    }

    public final Integer component7() {
        return this.rhythmic_steps_cadence;
    }

    public final Float component8() {
        return this.speed;
    }

    public final Integer component9() {
        return this.distance;
    }

    /* renamed from: copy-hSv7xU0, reason: not valid java name */
    public final DBActivityData m1125copyhSv7xU0(String hdid, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBActivityData(hdid, j, num, num2, num3, num4, num5, f, num6, num7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBActivityData)) {
            return false;
        }
        DBActivityData dBActivityData = (DBActivityData) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBActivityData.hdid) && this.timestamp == dBActivityData.timestamp && Intrinsics.areEqual(this.activity_class, dBActivityData.activity_class) && Intrinsics.areEqual(this.walk_steps, dBActivityData.walk_steps) && Intrinsics.areEqual(this.run_steps, dBActivityData.run_steps) && Intrinsics.areEqual(this.other_steps, dBActivityData.other_steps) && Intrinsics.areEqual(this.rhythmic_steps_cadence, dBActivityData.rhythmic_steps_cadence) && Intrinsics.areEqual(this.speed, dBActivityData.speed) && Intrinsics.areEqual(this.distance, dBActivityData.distance) && Intrinsics.areEqual(this.calories, dBActivityData.calories)) {
            return true;
        }
        return false;
    }

    public final Integer getActivity_class() {
        return this.activity_class;
    }

    public final Integer getCalories() {
        return this.calories;
    }

    public final Integer getDistance() {
        return this.distance;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1126getHdidV9ZILtA() {
        return this.hdid;
    }

    public final Integer getOther_steps() {
        return this.other_steps;
    }

    public final Integer getRhythmic_steps_cadence() {
        return this.rhythmic_steps_cadence;
    }

    public final Integer getRun_steps() {
        return this.run_steps;
    }

    public final Float getSpeed() {
        return this.speed;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Integer getWalk_steps() {
        return this.walk_steps;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int m = Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31);
        Integer num = this.activity_class;
        int r2 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Integer num2 = this.walk_steps;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        Integer num3 = this.run_steps;
        if (num3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num3.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        Integer num4 = this.other_steps;
        if (num4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = num4.hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        Integer num5 = this.rhythmic_steps_cadence;
        if (num5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = num5.hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        Float f = this.speed;
        if (f == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = f.hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        Integer num6 = this.distance;
        if (num6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = num6.hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        Integer num7 = this.calories;
        if (num7 != null) {
            r2 = num7.hashCode();
        }
        return r07 + r2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBActivityData(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", activity_class=");
        sb.append(this.activity_class);
        sb.append(", walk_steps=");
        sb.append(this.walk_steps);
        sb.append(", run_steps=");
        sb.append(this.run_steps);
        sb.append(", other_steps=");
        sb.append(this.other_steps);
        sb.append(", rhythmic_steps_cadence=");
        sb.append(this.rhythmic_steps_cadence);
        sb.append(", speed=");
        sb.append(this.speed);
        sb.append(", distance=");
        sb.append(this.distance);
        sb.append(", calories=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.calories, ')');
    }

    private DBActivityData(String hdid, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.activity_class = num;
        this.walk_steps = num2;
        this.run_steps = num3;
        this.other_steps = num4;
        this.rhythmic_steps_cadence = num5;
        this.speed = f;
        this.distance = num6;
        this.calories = num7;
    }
}
