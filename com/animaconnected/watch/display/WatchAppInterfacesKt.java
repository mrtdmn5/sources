package com.animaconnected.watch.display;

import com.animaconnected.watch.SyncFlags;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAppInterfaces.kt */
/* loaded from: classes3.dex */
public final class WatchAppInterfacesKt {
    public static final SyncFlags synchronizedPart(WatchString watchString) {
        Intrinsics.checkNotNullParameter(watchString, "<this>");
        if (watchString instanceof FlashString) {
            return SyncFlags.FlashTranslations;
        }
        if (watchString instanceof RamString) {
            return SyncFlags.RamTranslations;
        }
        if (watchString instanceof ExpiringString) {
            return SyncFlags.RamTranslations;
        }
        throw new NoWhenBranchMatchedException();
    }
}
