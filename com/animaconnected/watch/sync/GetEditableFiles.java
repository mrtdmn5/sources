package com.animaconnected.watch.sync;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetEditableFiles.kt */
/* loaded from: classes3.dex */
public final class GetEditableFiles {
    private final String directory;
    private final String hash;
    private final long id;
    private final String name;
    private final String pathHash;
    private final int size;

    public GetEditableFiles(long j, String directory, String name, String hash, int r7, String pathHash) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(pathHash, "pathHash");
        this.id = j;
        this.directory = directory;
        this.name = name;
        this.hash = hash;
        this.size = r7;
        this.pathHash = pathHash;
    }

    public static /* synthetic */ GetEditableFiles copy$default(GetEditableFiles getEditableFiles, long j, String str, String str2, String str3, int r14, String str4, int r16, Object obj) {
        long j2;
        String str5;
        String str6;
        String str7;
        int r6;
        String str8;
        if ((r16 & 1) != 0) {
            j2 = getEditableFiles.id;
        } else {
            j2 = j;
        }
        if ((r16 & 2) != 0) {
            str5 = getEditableFiles.directory;
        } else {
            str5 = str;
        }
        if ((r16 & 4) != 0) {
            str6 = getEditableFiles.name;
        } else {
            str6 = str2;
        }
        if ((r16 & 8) != 0) {
            str7 = getEditableFiles.hash;
        } else {
            str7 = str3;
        }
        if ((r16 & 16) != 0) {
            r6 = getEditableFiles.size;
        } else {
            r6 = r14;
        }
        if ((r16 & 32) != 0) {
            str8 = getEditableFiles.pathHash;
        } else {
            str8 = str4;
        }
        return getEditableFiles.copy(j2, str5, str6, str7, r6, str8);
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

    public final GetEditableFiles copy(long j, String directory, String name, String hash, int r15, String pathHash) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(pathHash, "pathHash");
        return new GetEditableFiles(j, directory, name, hash, r15, pathHash);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetEditableFiles)) {
            return false;
        }
        GetEditableFiles getEditableFiles = (GetEditableFiles) obj;
        if (this.id == getEditableFiles.id && Intrinsics.areEqual(this.directory, getEditableFiles.directory) && Intrinsics.areEqual(this.name, getEditableFiles.name) && Intrinsics.areEqual(this.hash, getEditableFiles.hash) && this.size == getEditableFiles.size && Intrinsics.areEqual(this.pathHash, getEditableFiles.pathHash)) {
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
        return this.pathHash.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.size, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.hash, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.name, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.directory, Long.hashCode(this.id) * 31, 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetEditableFiles(id=");
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
