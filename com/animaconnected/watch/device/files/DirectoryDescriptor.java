package com.animaconnected.watch.device.files;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.device.FileResult;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchFile.kt */
/* loaded from: classes3.dex */
public final class DirectoryDescriptor extends FileEntry {
    private final String fullPath;
    private final boolean isDirectory;
    private final String name;
    private final String path;
    private final int pathHash;
    private final FileResult status;

    public /* synthetic */ DirectoryDescriptor(String str, String str2, FileResult fileResult, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (r4 & 4) != 0 ? null : fileResult);
    }

    public static /* synthetic */ DirectoryDescriptor copy$default(DirectoryDescriptor directoryDescriptor, String str, String str2, FileResult fileResult, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = directoryDescriptor.path;
        }
        if ((r4 & 2) != 0) {
            str2 = directoryDescriptor.name;
        }
        if ((r4 & 4) != 0) {
            fileResult = directoryDescriptor.status;
        }
        return directoryDescriptor.copy(str, str2, fileResult);
    }

    public final String component1() {
        return this.path;
    }

    public final String component2() {
        return this.name;
    }

    public final FileResult component3() {
        return this.status;
    }

    public final DirectoryDescriptor copy(String path, String name, FileResult fileResult) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        return new DirectoryDescriptor(path, name, fileResult);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DirectoryDescriptor)) {
            return false;
        }
        DirectoryDescriptor directoryDescriptor = (DirectoryDescriptor) obj;
        if (Intrinsics.areEqual(this.path, directoryDescriptor.path) && Intrinsics.areEqual(this.name, directoryDescriptor.name) && this.status == directoryDescriptor.status) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.device.files.FileEntry
    public String getFullPath() {
        return this.fullPath;
    }

    @Override // com.animaconnected.watch.device.files.FileEntry
    public String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    @Override // com.animaconnected.watch.device.files.FileEntry
    /* renamed from: getPathHash-pVg5ArA */
    public int mo1102getPathHashpVg5ArA() {
        return this.pathHash;
    }

    public final FileResult getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode;
        int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.name, this.path.hashCode() * 31, 31);
        FileResult fileResult = this.status;
        if (fileResult == null) {
            hashCode = 0;
        } else {
            hashCode = fileResult.hashCode();
        }
        return m + hashCode;
    }

    @Override // com.animaconnected.watch.device.files.FileEntry
    public boolean isDirectory() {
        return this.isDirectory;
    }

    public String toString() {
        return "DirectoryDescriptor(path=" + this.path + ", name=" + this.name + ", status=" + this.status + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryDescriptor(String path, String name, FileResult fileResult) {
        super(null);
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        this.path = path;
        this.name = name;
        this.status = fileResult;
        this.fullPath = WatchFileKt.fullPath(path, getName());
        this.isDirectory = true;
        this.pathHash = WatchFileKt.dekHash(getFullPath());
    }
}
