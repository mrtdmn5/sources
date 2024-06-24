package com.animaconnected.watch.device.files;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WatchFile.kt */
/* loaded from: classes3.dex */
public abstract class FileEntry {
    public /* synthetic */ FileEntry(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getFullPath();

    public abstract String getName();

    /* renamed from: getPathHash-pVg5ArA */
    public abstract int mo1102getPathHashpVg5ArA();

    public abstract boolean isDirectory();

    private FileEntry() {
    }
}
