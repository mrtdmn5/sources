package com.animaconnected.watch.sync;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBFile.kt */
/* loaded from: classes3.dex */
public final class DBFile {
    private final String directory;
    private final String hash;
    private final long id;
    private final String name;
    private final String pathHash;
    private final int size;

    /* compiled from: DBFile.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> sizeAdapter;

        public Adapter(ColumnAdapter<Integer, Long> sizeAdapter) {
            Intrinsics.checkNotNullParameter(sizeAdapter, "sizeAdapter");
            this.sizeAdapter = sizeAdapter;
        }

        public final ColumnAdapter<Integer, Long> getSizeAdapter() {
            return this.sizeAdapter;
        }
    }

    public DBFile(long j, String str, String str2, String str3, int r12, String str4) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, "directory", str2, "name", str3, "hash");
        this.id = j;
        this.directory = str;
        this.name = str2;
        this.hash = str3;
        this.size = r12;
        this.pathHash = str4;
    }

    public static /* synthetic */ DBFile copy$default(DBFile dBFile, long j, String str, String str2, String str3, int r14, String str4, int r16, Object obj) {
        long j2;
        String str5;
        String str6;
        String str7;
        int r6;
        String str8;
        if ((r16 & 1) != 0) {
            j2 = dBFile.id;
        } else {
            j2 = j;
        }
        if ((r16 & 2) != 0) {
            str5 = dBFile.directory;
        } else {
            str5 = str;
        }
        if ((r16 & 4) != 0) {
            str6 = dBFile.name;
        } else {
            str6 = str2;
        }
        if ((r16 & 8) != 0) {
            str7 = dBFile.hash;
        } else {
            str7 = str3;
        }
        if ((r16 & 16) != 0) {
            r6 = dBFile.size;
        } else {
            r6 = r14;
        }
        if ((r16 & 32) != 0) {
            str8 = dBFile.pathHash;
        } else {
            str8 = str4;
        }
        return dBFile.copy(j2, str5, str6, str7, r6, str8);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.directory;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.hash;
    }

    public final int component5() {
        return this.size;
    }

    public final String component6() {
        return this.pathHash;
    }

    public final DBFile copy(long j, String directory, String name, String hash, int r15, String str) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hash, "hash");
        return new DBFile(j, directory, name, hash, r15, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBFile)) {
            return false;
        }
        DBFile dBFile = (DBFile) obj;
        if (this.id == dBFile.id && Intrinsics.areEqual(this.directory, dBFile.directory) && Intrinsics.areEqual(this.name, dBFile.name) && Intrinsics.areEqual(this.hash, dBFile.hash) && this.size == dBFile.size && Intrinsics.areEqual(this.pathHash, dBFile.pathHash)) {
            return true;
        }
        return false;
    }

    public final String getDirectory() {
        return this.directory;
    }

    public final String getHash() {
        return this.hash;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPathHash() {
        return this.pathHash;
    }

    public final int getSize() {
        return this.size;
    }

    public int hashCode() {
        int hashCode;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.size, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.hash, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.name, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.directory, Long.hashCode(this.id) * 31, 31), 31), 31), 31);
        String str = this.pathHash;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return m + hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBFile(id=");
        sb.append(this.id);
        sb.append(", directory=");
        sb.append(this.directory);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", hash=");
        sb.append(this.hash);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", pathHash=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.pathHash, ')');
    }
}
