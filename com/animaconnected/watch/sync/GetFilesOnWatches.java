package com.animaconnected.watch.sync;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetFilesOnWatches.kt */
/* loaded from: classes3.dex */
public final class GetFilesOnWatches {
    private final String device_address;
    private final String directory;
    private final String hash;
    private final String name;
    private final int size;

    public GetFilesOnWatches(String str, String str2, String str3, String str4, int r11) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str2, "directory", str3, "name", str4, "hash");
        this.device_address = str;
        this.directory = str2;
        this.name = str3;
        this.hash = str4;
        this.size = r11;
    }

    public static /* synthetic */ GetFilesOnWatches copy$default(GetFilesOnWatches getFilesOnWatches, String str, String str2, String str3, String str4, int r8, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            str = getFilesOnWatches.device_address;
        }
        if ((r9 & 2) != 0) {
            str2 = getFilesOnWatches.directory;
        }
        String str5 = str2;
        if ((r9 & 4) != 0) {
            str3 = getFilesOnWatches.name;
        }
        String str6 = str3;
        if ((r9 & 8) != 0) {
            str4 = getFilesOnWatches.hash;
        }
        String str7 = str4;
        if ((r9 & 16) != 0) {
            r8 = getFilesOnWatches.size;
        }
        return getFilesOnWatches.copy(str, str5, str6, str7, r8);
    }

    public final String component1() {
        return this.device_address;
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

    public final GetFilesOnWatches copy(String str, String directory, String name, String hash, int r12) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hash, "hash");
        return new GetFilesOnWatches(str, directory, name, hash, r12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetFilesOnWatches)) {
            return false;
        }
        GetFilesOnWatches getFilesOnWatches = (GetFilesOnWatches) obj;
        if (Intrinsics.areEqual(this.device_address, getFilesOnWatches.device_address) && Intrinsics.areEqual(this.directory, getFilesOnWatches.directory) && Intrinsics.areEqual(this.name, getFilesOnWatches.name) && Intrinsics.areEqual(this.hash, getFilesOnWatches.hash) && this.size == getFilesOnWatches.size) {
            return true;
        }
        return false;
    }

    public final String getDevice_address() {
        return this.device_address;
    }

    public final String getDirectory() {
        return this.directory;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSize() {
        return this.size;
    }

    public int hashCode() {
        int hashCode;
        String str = this.device_address;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return Integer.hashCode(this.size) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.hash, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.name, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.directory, hashCode * 31, 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetFilesOnWatches(device_address=");
        sb.append(this.device_address);
        sb.append(", directory=");
        sb.append(this.directory);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", hash=");
        sb.append(this.hash);
        sb.append(", size=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.size, ')');
    }
}
