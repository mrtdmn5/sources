package com.animaconnected.watch.sync;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBApp.kt */
/* loaded from: classes3.dex */
public final class DBApp {
    private final int appId;
    private final long data_hash;

    /* compiled from: DBApp.kt */
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

    public DBApp(int r1, long j) {
        this.appId = r1;
        this.data_hash = j;
    }

    public static /* synthetic */ DBApp copy$default(DBApp dBApp, int r1, long j, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            r1 = dBApp.appId;
        }
        if ((r4 & 2) != 0) {
            j = dBApp.data_hash;
        }
        return dBApp.copy(r1, j);
    }

    public final int component1() {
        return this.appId;
    }

    public final long component2() {
        return this.data_hash;
    }

    public final DBApp copy(int r2, long j) {
        return new DBApp(r2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBApp)) {
            return false;
        }
        DBApp dBApp = (DBApp) obj;
        if (this.appId == dBApp.appId && this.data_hash == dBApp.data_hash) {
            return true;
        }
        return false;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final long getData_hash() {
        return this.data_hash;
    }

    public int hashCode() {
        return Long.hashCode(this.data_hash) + (Integer.hashCode(this.appId) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBApp(appId=");
        sb.append(this.appId);
        sb.append(", data_hash=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.data_hash, ')');
    }
}
