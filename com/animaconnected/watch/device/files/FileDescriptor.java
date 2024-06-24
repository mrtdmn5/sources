package com.animaconnected.watch.device.files;

import com.animaconnected.watch.device.FileResult;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchFile.kt */
/* loaded from: classes3.dex */
public final class FileDescriptor extends FileEntry {
    private final UInt dataHash;
    private final String directory;
    private final String fullPath;
    private final boolean isDirectory;
    private final String name;
    private final int pathHash;
    private final int size;
    private final FileResult status;
    private final Long timestamp;

    public /* synthetic */ FileDescriptor(String str, String str2, int r3, UInt uInt, Long l, FileResult fileResult, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, r3, uInt, l, fileResult);
    }

    /* renamed from: copy-2lSx-G8$default, reason: not valid java name */
    public static /* synthetic */ FileDescriptor m1103copy2lSxG8$default(FileDescriptor fileDescriptor, String str, String str2, int r7, UInt uInt, Long l, FileResult fileResult, int r11, Object obj) {
        if ((r11 & 1) != 0) {
            str = fileDescriptor.directory;
        }
        if ((r11 & 2) != 0) {
            str2 = fileDescriptor.name;
        }
        String str3 = str2;
        if ((r11 & 4) != 0) {
            r7 = fileDescriptor.size;
        }
        int r0 = r7;
        if ((r11 & 8) != 0) {
            uInt = fileDescriptor.dataHash;
        }
        UInt uInt2 = uInt;
        if ((r11 & 16) != 0) {
            l = fileDescriptor.timestamp;
        }
        Long l2 = l;
        if ((r11 & 32) != 0) {
            fileResult = fileDescriptor.status;
        }
        return fileDescriptor.m1105copy2lSxG8(str, str3, r0, uInt2, l2, fileResult);
    }

    public final String component1() {
        return this.directory;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.size;
    }

    /* renamed from: component4-0hXNFcg, reason: not valid java name */
    public final UInt m1104component40hXNFcg() {
        return this.dataHash;
    }

    public final Long component5() {
        return this.timestamp;
    }

    public final FileResult component6() {
        return this.status;
    }

    /* renamed from: copy-2lSx-G8, reason: not valid java name */
    public final FileDescriptor m1105copy2lSxG8(String directory, String name, int r12, UInt uInt, Long l, FileResult fileResult) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        return new FileDescriptor(directory, name, r12, uInt, l, fileResult, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FileDescriptor.class != obj.getClass()) {
            return false;
        }
        FileDescriptor fileDescriptor = (FileDescriptor) obj;
        if (!Intrinsics.areEqual(this.directory, fileDescriptor.directory) || !Intrinsics.areEqual(getName(), fileDescriptor.getName()) || this.size != fileDescriptor.size) {
            return false;
        }
        return Intrinsics.areEqual(this.dataHash, fileDescriptor.dataHash);
    }

    /* renamed from: getDataHash-0hXNFcg, reason: not valid java name */
    public final UInt m1106getDataHash0hXNFcg() {
        return this.dataHash;
    }

    public final String getDirectory() {
        return this.directory;
    }

    public final String getExtension() {
        return WatchFileKt.extension(getName());
    }

    @Override // com.animaconnected.watch.device.files.FileEntry
    public String getFullPath() {
        return this.fullPath;
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

    public final FileResult getStatus() {
        return this.status;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int r0;
        int hashCode = (((getName().hashCode() + (this.directory.hashCode() * 31)) * 31) + this.size) * 31;
        UInt uInt = this.dataHash;
        if (uInt != null) {
            r0 = Integer.hashCode(uInt.data);
        } else {
            r0 = 0;
        }
        return hashCode + r0;
    }

    @Override // com.animaconnected.watch.device.files.FileEntry
    public boolean isDirectory() {
        return this.isDirectory;
    }

    public String toString() {
        return "FileDescriptor(directory=" + this.directory + ", name=" + this.name + ", size=" + this.size + ", dataHash=" + this.dataHash + ", timestamp=" + this.timestamp + ", status=" + this.status + ')';
    }

    public /* synthetic */ FileDescriptor(String str, String str2, int r13, UInt uInt, Long l, FileResult fileResult, int r17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, r13, (r17 & 8) != 0 ? null : uInt, (r17 & 16) != 0 ? null : l, (r17 & 32) != 0 ? null : fileResult, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private FileDescriptor(String directory, String name, int r4, UInt uInt, Long l, FileResult fileResult) {
        super(null);
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        this.directory = directory;
        this.name = name;
        this.size = r4;
        this.dataHash = uInt;
        this.timestamp = l;
        this.status = fileResult;
        this.fullPath = WatchFileKt.fullPath(directory, getName());
        this.pathHash = WatchFileKt.dekHash(getFullPath());
    }
}
