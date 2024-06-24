package com.animaconnected.watch.device.files;

import com.animaconnected.info.ByteUtils;
import com.animaconnected.info.DateTimeUtilsKt;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchFile.kt */
/* loaded from: classes3.dex */
public final class WatchFile extends FileEntry {
    private final byte[] bytes;
    private final int dataHash;
    private final String directory;
    private final boolean editable;
    private final String editablePathHash;
    private final String fullPath;
    private final boolean isDirectory;
    private final Integer modifiedTimestamp;
    private final String name;
    private final int pathHash;
    private final int size;

    public /* synthetic */ WatchFile(String str, String str2, byte[] bArr, boolean z, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, bArr, (r5 & 8) != 0 ? false : z);
    }

    public static /* synthetic */ WatchFile copy$default(WatchFile watchFile, String str, String str2, byte[] bArr, boolean z, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = watchFile.directory;
        }
        if ((r5 & 2) != 0) {
            str2 = watchFile.name;
        }
        if ((r5 & 4) != 0) {
            bArr = watchFile.bytes;
        }
        if ((r5 & 8) != 0) {
            z = watchFile.editable;
        }
        return watchFile.copy(str, str2, bArr, z);
    }

    public final String component1() {
        return this.directory;
    }

    public final String component2() {
        return this.name;
    }

    public final byte[] component3() {
        return this.bytes;
    }

    public final boolean component4() {
        return this.editable;
    }

    public final WatchFile copy(String directory, String name, byte[] bytes, boolean z) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return new WatchFile(directory, name, bytes, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WatchFile.class != obj.getClass()) {
            return false;
        }
        WatchFile watchFile = (WatchFile) obj;
        if (Intrinsics.areEqual(getFullPath(), watchFile.getFullPath()) && this.dataHash == watchFile.dataHash) {
            return true;
        }
        return false;
    }

    public final byte[] getBytes() {
        return this.bytes;
    }

    /* renamed from: getDataHash-pVg5ArA, reason: not valid java name */
    public final int m1107getDataHashpVg5ArA() {
        return this.dataHash;
    }

    public final String getDirectory() {
        return this.directory;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final String getEditablePathHash() {
        return this.editablePathHash;
    }

    public final String getExtension() {
        return WatchFileKt.extension(getName());
    }

    @Override // com.animaconnected.watch.device.files.FileEntry
    public String getFullPath() {
        return this.fullPath;
    }

    public final Integer getModifiedTimestamp() {
        return this.modifiedTimestamp;
    }

    @Override // com.animaconnected.watch.device.files.FileEntry
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.watch.device.files.FileEntry
    /* renamed from: getPathHash-pVg5ArA */
    public int mo1102getPathHashpVg5ArA() {
        return this.pathHash;
    }

    public final int getSize() {
        return this.size;
    }

    public int hashCode() {
        return mo1102getPathHashpVg5ArA() + this.dataHash;
    }

    @Override // com.animaconnected.watch.device.files.FileEntry
    public boolean isDirectory() {
        return this.isDirectory;
    }

    public String toString() {
        return "WatchFile(fullPath='" + getFullPath() + "', size=" + this.size + ", dataHash=" + ByteUtils.m748toHexStringqim9Vi0$default(this.dataHash, 0, 1, null) + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFile(String directory, String name, byte[] bytes, boolean z) {
        super(0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.directory = directory;
        this.name = name;
        this.bytes = bytes;
        this.editable = z;
        this.fullPath = WatchFileKt.fullPath(directory, getName());
        this.pathHash = WatchFileKt.dekHash(getFullPath());
        this.editablePathHash = z ? Long.toString(WatchFileKt.dekHash(getFullPath()) & 4294967295L, 10) : null;
        this.modifiedTimestamp = z ? Integer.valueOf((int) DateTimeUtilsKt.now().getEpochSeconds()) : null;
        this.size = bytes.length;
        byte[] copyOf = Arrays.copyOf(bytes, bytes.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.dataHash = WatchFileKt.m1108dekHashGBYM_sE(copyOf);
    }
}
