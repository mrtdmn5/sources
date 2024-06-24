package com.animaconnected.watch.device.files;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchFile.kt */
/* loaded from: classes3.dex */
public final class Directory extends FileEntry {
    private final List<FileEntry> entries;
    private final String fullPath;
    private final boolean isDirectory;
    private final String name;
    private final String path;
    private final int pathHash;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Directory(String path, String name, List<? extends FileEntry> entries) {
        super(null);
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.path = path;
        this.name = name;
        this.entries = entries;
        this.fullPath = WatchFileKt.fullPath(path, getName());
        this.isDirectory = true;
        this.pathHash = WatchFileKt.dekHash(getFullPath());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Directory copy$default(Directory directory, String str, String str2, List list, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = directory.path;
        }
        if ((r4 & 2) != 0) {
            str2 = directory.name;
        }
        if ((r4 & 4) != 0) {
            list = directory.entries;
        }
        return directory.copy(str, str2, list);
    }

    public final String component1() {
        return this.path;
    }

    public final String component2() {
        return this.name;
    }

    public final List<FileEntry> component3() {
        return this.entries;
    }

    public final Directory copy(String path, String name, List<? extends FileEntry> entries) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new Directory(path, name, entries);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Directory)) {
            return false;
        }
        Directory directory = (Directory) obj;
        if (Intrinsics.areEqual(this.path, directory.path) && Intrinsics.areEqual(this.name, directory.name) && Intrinsics.areEqual(this.entries, directory.entries)) {
            return true;
        }
        return false;
    }

    public final List<FileEntry> getEntries() {
        return this.entries;
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
    /* renamed from: getPathHash-pVg5ArA, reason: not valid java name */
    public int mo1102getPathHashpVg5ArA() {
        return this.pathHash;
    }

    public int hashCode() {
        return this.entries.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.name, this.path.hashCode() * 31, 31);
    }

    @Override // com.animaconnected.watch.device.files.FileEntry
    public boolean isDirectory() {
        return this.isDirectory;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Directory(path=");
        sb.append(this.path);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", entries=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.entries, ')');
    }
}
