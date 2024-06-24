package com.animaconnected.watch.device;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: DeviceWriter.kt */
/* loaded from: classes3.dex */
public final class DeviceWriterKt {
    public static final int maxTransferSize = 247;

    public static final boolean isEmulator(WatchBackend watchBackend) {
        Intrinsics.checkNotNullParameter(watchBackend, "<this>");
        return StringsKt__StringsJVMKt.startsWith(watchBackend.getIdentifier(), "EMULATOR", false);
    }
}
