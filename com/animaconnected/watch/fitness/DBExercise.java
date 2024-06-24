package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBExercise.kt */
/* loaded from: classes3.dex */
public final class DBExercise {
    private final int active_minutes;
    private final String hdid;
    private final long timestamp;

    /* compiled from: DBExercise.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> active_minutesAdapter;
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> active_minutesAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(active_minutesAdapter, "active_minutesAdapter");
            this.hdidAdapter = hdidAdapter;
            this.active_minutesAdapter = active_minutesAdapter;
        }

        public final ColumnAdapter<Integer, Long> getActive_minutesAdapter() {
            return this.active_minutesAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }
    }

    public /* synthetic */ DBExercise(String str, long j, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ DBExercise m1143copyOZHprlw$default(DBExercise dBExercise, String str, long j, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = dBExercise.hdid;
        }
        if ((r5 & 2) != 0) {
            j = dBExercise.timestamp;
        }
        if ((r5 & 4) != 0) {
            r4 = dBExercise.active_minutes;
        }
        return dBExercise.m1145copyOZHprlw(str, j, r4);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1144component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.active_minutes;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final DBExercise m1145copyOZHprlw(String hdid, long j, int r11) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBExercise(hdid, j, r11, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBExercise)) {
            return false;
        }
        DBExercise dBExercise = (DBExercise) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBExercise.hdid) && this.timestamp == dBExercise.timestamp && this.active_minutes == dBExercise.active_minutes) {
            return true;
        }
        return false;
    }

    public final int getActive_minutes() {
        return this.active_minutes;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1146getHdidV9ZILtA() {
        return this.hdid;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Integer.hashCode(this.active_minutes) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBExercise(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", active_minutes=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.active_minutes, ')');
    }

    private DBExercise(String hdid, long j, int r5) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.active_minutes = r5;
    }
}
