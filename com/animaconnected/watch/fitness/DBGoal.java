package com.animaconnected.watch.fitness;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBGoal.kt */
/* loaded from: classes3.dex */
public final class DBGoal {
    private final int exercise;
    private final String hdid;
    private final int stand;
    private final int steps;
    private final long timestamp;

    /* compiled from: DBGoal.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> exerciseAdapter;
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> standAdapter;
        private final ColumnAdapter<Integer, Long> stepsAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> stepsAdapter, ColumnAdapter<Integer, Long> standAdapter, ColumnAdapter<Integer, Long> exerciseAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(stepsAdapter, "stepsAdapter");
            Intrinsics.checkNotNullParameter(standAdapter, "standAdapter");
            Intrinsics.checkNotNullParameter(exerciseAdapter, "exerciseAdapter");
            this.hdidAdapter = hdidAdapter;
            this.stepsAdapter = stepsAdapter;
            this.standAdapter = standAdapter;
            this.exerciseAdapter = exerciseAdapter;
        }

        public final ColumnAdapter<Integer, Long> getExerciseAdapter() {
            return this.exerciseAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getStandAdapter() {
            return this.standAdapter;
        }

        public final ColumnAdapter<Integer, Long> getStepsAdapter() {
            return this.stepsAdapter;
        }
    }

    public /* synthetic */ DBGoal(long j, String str, int r4, int r5, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, r4, r5, r6);
    }

    /* renamed from: copy-AjOicPU$default, reason: not valid java name */
    public static /* synthetic */ DBGoal m1155copyAjOicPU$default(DBGoal dBGoal, long j, String str, int r11, int r12, int r13, int r14, Object obj) {
        if ((r14 & 1) != 0) {
            j = dBGoal.timestamp;
        }
        long j2 = j;
        if ((r14 & 2) != 0) {
            str = dBGoal.hdid;
        }
        String str2 = str;
        if ((r14 & 4) != 0) {
            r11 = dBGoal.steps;
        }
        int r4 = r11;
        if ((r14 & 8) != 0) {
            r12 = dBGoal.stand;
        }
        int r5 = r12;
        if ((r14 & 16) != 0) {
            r13 = dBGoal.exercise;
        }
        return dBGoal.m1157copyAjOicPU(j2, str2, r4, r5, r13);
    }

    public final long component1() {
        return this.timestamp;
    }

    /* renamed from: component2-V9ZILtA, reason: not valid java name */
    public final String m1156component2V9ZILtA() {
        return this.hdid;
    }

    public final int component3() {
        return this.steps;
    }

    public final int component4() {
        return this.stand;
    }

    public final int component5() {
        return this.exercise;
    }

    /* renamed from: copy-AjOicPU, reason: not valid java name */
    public final DBGoal m1157copyAjOicPU(long j, String hdid, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBGoal(j, hdid, r13, r14, r15, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBGoal)) {
            return false;
        }
        DBGoal dBGoal = (DBGoal) obj;
        if (this.timestamp == dBGoal.timestamp && HistoryDeviceId.m1559equalsimpl0(this.hdid, dBGoal.hdid) && this.steps == dBGoal.steps && this.stand == dBGoal.stand && this.exercise == dBGoal.exercise) {
            return true;
        }
        return false;
    }

    public final int getExercise() {
        return this.exercise;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1158getHdidV9ZILtA() {
        return this.hdid;
    }

    public final int getStand() {
        return this.stand;
    }

    public final int getSteps() {
        return this.steps;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Integer.hashCode(this.exercise) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.stand, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.steps, (HistoryDeviceId.m1560hashCodeimpl(this.hdid) + (Long.hashCode(this.timestamp) * 31)) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBGoal(timestamp=");
        sb.append(this.timestamp);
        sb.append(", hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", steps=");
        sb.append(this.steps);
        sb.append(", stand=");
        sb.append(this.stand);
        sb.append(", exercise=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.exercise, ')');
    }

    private DBGoal(long j, String hdid, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.timestamp = j;
        this.hdid = hdid;
        this.steps = r5;
        this.stand = r6;
        this.exercise = r7;
    }
}
