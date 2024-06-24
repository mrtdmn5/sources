package com.animaconnected.secondo.screens.watchupdate;

import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.watch.device.FirmwareVersion;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BundledFirmware.kt */
/* loaded from: classes3.dex */
public final class BundledFirmwareKt {
    public static final BundledFirmware getBundledFirmware(DeviceType deviceType, FirmwareVariant variant) {
        Integer value;
        Intrinsics.checkNotNullParameter(variant, "variant");
        if (deviceType == DeviceType.PASCAL && (value = variant.getValue()) != null && value.intValue() == 16) {
            return new BundledFirmware(new FirmwareVersion(3010, 1, 3), R.raw.fw_pascal_16_3010_1_3);
        }
        return null;
    }
}
