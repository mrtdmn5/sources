package com.animaconnected.watch.sync;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBConfig.kt */
/* loaded from: classes3.dex */
public final class DBConfig {
    private final String command;
    private final int data_hash;
    private final String identifier;

    /* compiled from: DBConfig.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> data_hashAdapter;

        public Adapter(ColumnAdapter<Integer, Long> data_hashAdapter) {
            Intrinsics.checkNotNullParameter(data_hashAdapter, "data_hashAdapter");
            this.data_hashAdapter = data_hashAdapter;
        }

        public final ColumnAdapter<Integer, Long> getData_hashAdapter() {
            return this.data_hashAdapter;
        }
    }

    public DBConfig(String identifier, String command, int r4) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(command, "command");
        this.identifier = identifier;
        this.command = command;
        this.data_hash = r4;
    }

    public static /* synthetic */ DBConfig copy$default(DBConfig dBConfig, String str, String str2, int r3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = dBConfig.identifier;
        }
        if ((r4 & 2) != 0) {
            str2 = dBConfig.command;
        }
        if ((r4 & 4) != 0) {
            r3 = dBConfig.data_hash;
        }
        return dBConfig.copy(str, str2, r3);
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.command;
    }

    public final int component3() {
        return this.data_hash;
    }

    public final DBConfig copy(String identifier, String command, int r4) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(command, "command");
        return new DBConfig(identifier, command, r4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBConfig)) {
            return false;
        }
        DBConfig dBConfig = (DBConfig) obj;
        if (Intrinsics.areEqual(this.identifier, dBConfig.identifier) && Intrinsics.areEqual(this.command, dBConfig.command) && this.data_hash == dBConfig.data_hash) {
            return true;
        }
        return false;
    }

    public final String getCommand() {
        return this.command;
    }

    public final int getData_hash() {
        return this.data_hash;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return Integer.hashCode(this.data_hash) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.command, this.identifier.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBConfig(identifier=");
        sb.append(this.identifier);
        sb.append(", command=");
        sb.append(this.command);
        sb.append(", data_hash=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.data_hash, ')');
    }
}
