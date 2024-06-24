package com.animaconnected.watch.display;

import com.animaconnected.watch.device.files.FileDescriptor;
import com.animaconnected.watch.sync.DBFile;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* compiled from: ResourceSynchronizer.kt */
/* loaded from: classes3.dex */
public final class ResourceSynchronizerKt {
    public static final FileDescriptor toFileDescriptor(DBFile dBFile, Long l) {
        Intrinsics.checkNotNullParameter(dBFile, "<this>");
        return new FileDescriptor(dBFile.getDirectory(), dBFile.getName(), dBFile.getSize(), new UInt(UStringsKt.toUInt(dBFile.getHash())), l, null, 32, null);
    }

    public static /* synthetic */ FileDescriptor toFileDescriptor$default(DBFile dBFile, Long l, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            l = null;
        }
        return toFileDescriptor(dBFile, l);
    }
}
