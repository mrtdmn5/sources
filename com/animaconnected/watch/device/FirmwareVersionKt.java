package com.animaconnected.watch.device;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: FirmwareVersion.kt */
/* loaded from: classes3.dex */
public final class FirmwareVersionKt {
    private static final FirmwareVersion highestSupportedPascalVersion;
    private static final FirmwareVersion lowestSupportedPascalVersion;
    private static final Pair<FirmwareVersion, FirmwareVersion> supportedRange;

    static {
        FirmwareVersion firmwareVersion = new FirmwareVersion(3010, 1, 3);
        lowestSupportedPascalVersion = firmwareVersion;
        FirmwareVersion firmwareVersion2 = new FirmwareVersion(3010, Integer.MAX_VALUE, Integer.MAX_VALUE);
        highestSupportedPascalVersion = firmwareVersion2;
        supportedRange = firmwareVersion.rangeTo(firmwareVersion2);
    }

    public static final boolean contains(Pair<FirmwareVersion, FirmwareVersion> pair, FirmwareVersion version) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(version, "version");
        if (version.compareTo(pair.first) >= 0 && version.compareTo(pair.second) <= 0) {
            return true;
        }
        return false;
    }

    public static final FirmwareVersion getHighestSupportedPascalVersion() {
        return highestSupportedPascalVersion;
    }

    public static final FirmwareVersion getLowestSupportedPascalVersion() {
        return lowestSupportedPascalVersion;
    }

    public static final Pair<FirmwareVersion, FirmwareVersion> getSupportedRange() {
        return supportedRange;
    }

    public static final boolean isSupported(FirmwareVersion firmwareVersion) {
        Intrinsics.checkNotNullParameter(firmwareVersion, "<this>");
        return contains(supportedRange, firmwareVersion);
    }

    public static final BaseFirmwareVersion toFirmwareVersion(String str) {
        FirmwareVersion firmwareVersion;
        Intrinsics.checkNotNullParameter(str, "<this>");
        List split$default = StringsKt__StringsKt.split$default(str, new String[]{InstructionFileId.DOT}, 0, 6);
        if (((CharSequence) CollectionsKt___CollectionsKt.first(split$default)).length() == 8) {
            String str2 = (String) CollectionsKt___CollectionsKt.first(split$default);
            Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(StringsKt__StringsKt.substring(str2, RangesKt___RangesKt.until(0, 4)));
            Integer intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(StringsKt__StringsKt.substring(str2, RangesKt___RangesKt.until(4, 6)));
            Integer intOrNull3 = StringsKt__StringNumberConversionsKt.toIntOrNull(StringsKt__StringsKt.substring(str2, RangesKt___RangesKt.until(6, 8)));
            if (intOrNull != null && intOrNull2 != null && intOrNull3 != null) {
                firmwareVersion = new FirmwareVersion(intOrNull.intValue(), intOrNull2.intValue(), intOrNull3.intValue());
            }
            firmwareVersion = null;
        } else {
            if (split$default.size() == 3) {
                Integer intOrNull4 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(0));
                Integer intOrNull5 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(1));
                Integer intOrNull6 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(2));
                if (intOrNull4 != null && intOrNull5 != null && intOrNull6 != null) {
                    firmwareVersion = new FirmwareVersion(intOrNull4.intValue(), intOrNull5.intValue(), intOrNull6.intValue());
                }
            }
            firmwareVersion = null;
        }
        if (firmwareVersion != null) {
            return firmwareVersion;
        }
        if (!(!StringsKt__StringsJVMKt.isBlank(str))) {
            return null;
        }
        return new DebugFirmwareVersion(str);
    }
}
