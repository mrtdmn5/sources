package com.animaconnected.secondo.screens.watchupdate;

import com.animaconnected.watch.device.FirmwareUpdate;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchUpdateFragmentFactory.kt */
/* loaded from: classes3.dex */
public final class WatchUpdateFragmentFactory {
    public static final int $stable = 0;
    public static final WatchUpdateFragmentFactory INSTANCE = new WatchUpdateFragmentFactory();

    private WatchUpdateFragmentFactory() {
    }

    public final BaseWatchUpdateFragment getWatchUpdateFragment$secondo_kronabyRelease(FirmwareUpdate firmwareUpdate) {
        Intrinsics.checkNotNullParameter(firmwareUpdate, "firmwareUpdate");
        if (firmwareUpdate == FirmwareUpdate.FOTA) {
            return WatchFotaUpdateFragment.Companion.newInstance();
        }
        if (firmwareUpdate.isDfu()) {
            return WatchDfuUpdateFragment.Companion.newInstance();
        }
        throw new IllegalArgumentException("firmwareUpdate must be DFU or FOTA");
    }
}
