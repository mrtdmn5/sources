package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBFitnessIndexProcessed.kt */
/* loaded from: classes3.dex */
public final class DBFitnessIndexProcessed {
    private final String hdid;
    private final Float processed_fitness_index;
    private final long session_timestamp;

    /* compiled from: DBFitnessIndexProcessed.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Float, Double> processed_fitness_indexAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Float, Double> processed_fitness_indexAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(processed_fitness_indexAdapter, "processed_fitness_indexAdapter");
            this.hdidAdapter = hdidAdapter;
            this.processed_fitness_indexAdapter = processed_fitness_indexAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Float, Double> getProcessed_fitness_indexAdapter() {
            return this.processed_fitness_indexAdapter;
        }
    }

    public /* synthetic */ DBFitnessIndexProcessed(String str, long j, Float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, f);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ DBFitnessIndexProcessed m1151copyOZHprlw$default(DBFitnessIndexProcessed dBFitnessIndexProcessed, String str, long j, Float f, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = dBFitnessIndexProcessed.hdid;
        }
        if ((r5 & 2) != 0) {
            j = dBFitnessIndexProcessed.session_timestamp;
        }
        if ((r5 & 4) != 0) {
            f = dBFitnessIndexProcessed.processed_fitness_index;
        }
        return dBFitnessIndexProcessed.m1153copyOZHprlw(str, j, f);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1152component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.session_timestamp;
    }

    public final Float component3() {
        return this.processed_fitness_index;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final DBFitnessIndexProcessed m1153copyOZHprlw(String hdid, long j, Float f) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBFitnessIndexProcessed(hdid, j, f, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBFitnessIndexProcessed)) {
            return false;
        }
        DBFitnessIndexProcessed dBFitnessIndexProcessed = (DBFitnessIndexProcessed) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBFitnessIndexProcessed.hdid) && this.session_timestamp == dBFitnessIndexProcessed.session_timestamp && Intrinsics.areEqual(this.processed_fitness_index, dBFitnessIndexProcessed.processed_fitness_index)) {
            return true;
        }
        return false;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1154getHdidV9ZILtA() {
        return this.hdid;
    }

    public final Float getProcessed_fitness_index() {
        return this.processed_fitness_index;
    }

    public final long getSession_timestamp() {
        return this.session_timestamp;
    }

    public int hashCode() {
        int hashCode;
        int m = Scale$$ExternalSyntheticOutline0.m(this.session_timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31);
        Float f = this.processed_fitness_index;
        if (f == null) {
            hashCode = 0;
        } else {
            hashCode = f.hashCode();
        }
        return m + hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBFitnessIndexProcessed(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", session_timestamp=");
        sb.append(this.session_timestamp);
        sb.append(", processed_fitness_index=");
        sb.append(this.processed_fitness_index);
        sb.append(')');
        return sb.toString();
    }

    private DBFitnessIndexProcessed(String hdid, long j, Float f) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.session_timestamp = j;
        this.processed_fitness_index = f;
    }
}
