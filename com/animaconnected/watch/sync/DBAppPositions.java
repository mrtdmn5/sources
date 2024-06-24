package com.animaconnected.watch.sync;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBAppPositions.kt */
/* loaded from: classes3.dex */
public final class DBAppPositions {
    private final int appId;
    private final long position;

    /* compiled from: DBAppPositions.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> appIdAdapter;

        public Adapter(ColumnAdapter<Integer, Long> appIdAdapter) {
            Intrinsics.checkNotNullParameter(appIdAdapter, "appIdAdapter");
            this.appIdAdapter = appIdAdapter;
        }

        public final ColumnAdapter<Integer, Long> getAppIdAdapter() {
            return this.appIdAdapter;
        }
    }

    public DBAppPositions(int r1, long j) {
        this.appId = r1;
        this.position = j;
    }

    public static /* synthetic */ DBAppPositions copy$default(DBAppPositions dBAppPositions, int r1, long j, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            r1 = dBAppPositions.appId;
        }
        if ((r4 & 2) != 0) {
            j = dBAppPositions.position;
        }
        return dBAppPositions.copy(r1, j);
    }

    public final int component1() {
        return this.appId;
    }

    public final long component2() {
        return this.position;
    }

    public final DBAppPositions copy(int r2, long j) {
        return new DBAppPositions(r2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBAppPositions)) {
            return false;
        }
        DBAppPositions dBAppPositions = (DBAppPositions) obj;
        if (this.appId == dBAppPositions.appId && this.position == dBAppPositions.position) {
            return true;
        }
        return false;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final long getPosition() {
        return this.position;
    }

    public int hashCode() {
        return Long.hashCode(this.position) + (Integer.hashCode(this.appId) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBAppPositions(appId=");
        sb.append(this.appId);
        sb.append(", position=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.position, ')');
    }
}
