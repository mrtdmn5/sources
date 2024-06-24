package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBDebug.kt */
/* loaded from: classes3.dex */
public final class DBDebug {
    private final String hdid;
    private final long timestamp;
    private final int type;
    private final int value_;

    /* compiled from: DBDebug.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> typeAdapter;
        private final ColumnAdapter<Integer, Long> value_Adapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> typeAdapter, ColumnAdapter<Integer, Long> value_Adapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(typeAdapter, "typeAdapter");
            Intrinsics.checkNotNullParameter(value_Adapter, "value_Adapter");
            this.hdidAdapter = hdidAdapter;
            this.typeAdapter = typeAdapter;
            this.value_Adapter = value_Adapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getTypeAdapter() {
            return this.typeAdapter;
        }

        public final ColumnAdapter<Integer, Long> getValue_Adapter() {
            return this.value_Adapter;
        }
    }

    public /* synthetic */ DBDebug(String str, long j, int r4, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4, r5);
    }

    /* renamed from: copy-4i7cvns$default, reason: not valid java name */
    public static /* synthetic */ DBDebug m1127copy4i7cvns$default(DBDebug dBDebug, String str, long j, int r7, int r8, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            str = dBDebug.hdid;
        }
        if ((r9 & 2) != 0) {
            j = dBDebug.timestamp;
        }
        long j2 = j;
        if ((r9 & 4) != 0) {
            r7 = dBDebug.type;
        }
        int r10 = r7;
        if ((r9 & 8) != 0) {
            r8 = dBDebug.value_;
        }
        return dBDebug.m1129copy4i7cvns(str, j2, r10, r8);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1128component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.type;
    }

    public final int component4() {
        return this.value_;
    }

    /* renamed from: copy-4i7cvns, reason: not valid java name */
    public final DBDebug m1129copy4i7cvns(String hdid, long j, int r12, int r13) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBDebug(hdid, j, r12, r13, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBDebug)) {
            return false;
        }
        DBDebug dBDebug = (DBDebug) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBDebug.hdid) && this.timestamp == dBDebug.timestamp && this.type == dBDebug.type && this.value_ == dBDebug.value_) {
            return true;
        }
        return false;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1130getHdidV9ZILtA() {
        return this.hdid;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getType() {
        return this.type;
    }

    public final int getValue_() {
        return this.value_;
    }

    public int hashCode() {
        return Integer.hashCode(this.value_) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.type, Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBDebug(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", value_=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.value_, ')');
    }

    private DBDebug(String hdid, long j, int r5, int r6) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.type = r5;
        this.value_ = r6;
    }
}
