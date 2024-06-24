package com.animaconnected.watch.sync;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBWatchFileSynced.kt */
/* loaded from: classes3.dex */
public final class DBWatchFileSynced {
    private final String device_address;
    private final long file_id;

    public DBWatchFileSynced(String device_address, long j) {
        Intrinsics.checkNotNullParameter(device_address, "device_address");
        this.device_address = device_address;
        this.file_id = j;
    }

    public static /* synthetic */ DBWatchFileSynced copy$default(DBWatchFileSynced dBWatchFileSynced, String str, long j, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = dBWatchFileSynced.device_address;
        }
        if ((r4 & 2) != 0) {
            j = dBWatchFileSynced.file_id;
        }
        return dBWatchFileSynced.copy(str, j);
    }

    public final String component1() {
        return this.device_address;
    }

    public final long component2() {
        return this.file_id;
    }

    public final DBWatchFileSynced copy(String device_address, long j) {
        Intrinsics.checkNotNullParameter(device_address, "device_address");
        return new DBWatchFileSynced(device_address, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBWatchFileSynced)) {
            return false;
        }
        DBWatchFileSynced dBWatchFileSynced = (DBWatchFileSynced) obj;
        if (Intrinsics.areEqual(this.device_address, dBWatchFileSynced.device_address) && this.file_id == dBWatchFileSynced.file_id) {
            return true;
        }
        return false;
    }

    public final String getDevice_address() {
        return this.device_address;
    }

    public final long getFile_id() {
        return this.file_id;
    }

    public int hashCode() {
        return Long.hashCode(this.file_id) + (this.device_address.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBWatchFileSynced(device_address=");
        sb.append(this.device_address);
        sb.append(", file_id=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.file_id, ')');
    }
}
