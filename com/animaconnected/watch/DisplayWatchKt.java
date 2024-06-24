package com.animaconnected.watch;

import com.animaconnected.watch.device.FileResult;
import com.animaconnected.watch.device.files.FileDescriptor;
import com.animaconnected.watch.device.files.WatchFile;
import kotlin.UInt;

/* compiled from: DisplayWatch.kt */
/* loaded from: classes3.dex */
public final class DisplayWatchKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final FileDescriptor toFileDescriptor(WatchFile watchFile, FileResult fileResult) {
        return new FileDescriptor(watchFile.getDirectory(), watchFile.getName(), watchFile.getSize(), new UInt(watchFile.m1107getDataHashpVg5ArA()), null, fileResult, 16, null);
    }
}
