package com.animaconnected.watch.fitness;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBFitnessIndex.kt */
/* loaded from: classes3.dex */
public final class DBFitnessIndex {
    private final float fitness_index;
    private final String hdid;
    private final long timestamp;

    /* compiled from: DBFitnessIndex.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Float, Double> fitness_indexAdapter;
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Float, Double> fitness_indexAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(fitness_indexAdapter, "fitness_indexAdapter");
            this.hdidAdapter = hdidAdapter;
            this.fitness_indexAdapter = fitness_indexAdapter;
        }

        public final ColumnAdapter<Float, Double> getFitness_indexAdapter() {
            return this.fitness_indexAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }
    }

    public /* synthetic */ DBFitnessIndex(String str, long j, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, f);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ DBFitnessIndex m1147copyOZHprlw$default(DBFitnessIndex dBFitnessIndex, String str, long j, float f, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = dBFitnessIndex.hdid;
        }
        if ((r5 & 2) != 0) {
            j = dBFitnessIndex.timestamp;
        }
        if ((r5 & 4) != 0) {
            f = dBFitnessIndex.fitness_index;
        }
        return dBFitnessIndex.m1149copyOZHprlw(str, j, f);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1148component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final float component3() {
        return this.fitness_index;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final DBFitnessIndex m1149copyOZHprlw(String hdid, long j, float f) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBFitnessIndex(hdid, j, f, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBFitnessIndex)) {
            return false;
        }
        DBFitnessIndex dBFitnessIndex = (DBFitnessIndex) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBFitnessIndex.hdid) && this.timestamp == dBFitnessIndex.timestamp && Float.compare(this.fitness_index, dBFitnessIndex.fitness_index) == 0) {
            return true;
        }
        return false;
    }

    public final float getFitness_index() {
        return this.fitness_index;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1150getHdidV9ZILtA() {
        return this.hdid;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Float.hashCode(this.fitness_index) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBFitnessIndex(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", fitness_index=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.fitness_index, ')');
    }

    private DBFitnessIndex(String hdid, long j, float f) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.fitness_index = f;
    }
}
