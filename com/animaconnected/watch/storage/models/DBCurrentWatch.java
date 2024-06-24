package com.animaconnected.watch.storage.models;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBCurrentWatch.kt */
/* loaded from: classes3.dex */
public final class DBCurrentWatch {
    private final String current_address;
    private final long id;

    public DBCurrentWatch(long j, String str) {
        this.id = j;
        this.current_address = str;
    }

    public static /* synthetic */ DBCurrentWatch copy$default(DBCurrentWatch dBCurrentWatch, long j, String str, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = dBCurrentWatch.id;
        }
        if ((r4 & 2) != 0) {
            str = dBCurrentWatch.current_address;
        }
        return dBCurrentWatch.copy(j, str);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.current_address;
    }

    public final DBCurrentWatch copy(long j, String str) {
        return new DBCurrentWatch(j, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBCurrentWatch)) {
            return false;
        }
        DBCurrentWatch dBCurrentWatch = (DBCurrentWatch) obj;
        if (this.id == dBCurrentWatch.id && Intrinsics.areEqual(this.current_address, dBCurrentWatch.current_address)) {
            return true;
        }
        return false;
    }

    public final String getCurrent_address() {
        return this.current_address;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Long.hashCode(this.id) * 31;
        String str = this.current_address;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBCurrentWatch(id=");
        sb.append(this.id);
        sb.append(", current_address=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.current_address, ')');
    }
}
