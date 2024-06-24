package com.animaconnected.watch.utils;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.files.WatchFileKt;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.UnsignedKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.UStringsKt;

/* compiled from: HistoryDeviceIdUtils.kt */
/* loaded from: classes3.dex */
public final class HistoryDeviceIdUtilsKt {
    private static final String baseInstallIdKey = "baseInstallId";
    private static String baseInstallTestId;
    private static final Lazy storage$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BasicStorage>() { // from class: com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt$storage$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BasicStorage invoke() {
            return ServiceLocator.INSTANCE.getStorageFactory().createStorage("history_device_id");
        }
    });
    private static final Lazy baseInstallId$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt$baseInstallId$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            BasicStorage storage;
            BasicStorage storage2;
            if (HistoryDeviceIdUtilsKt.getBaseInstallTestId() != null) {
                return HistoryDeviceIdUtilsKt.getBaseInstallTestId();
            }
            storage = HistoryDeviceIdUtilsKt.getStorage();
            String string = storage.getString("baseInstallId");
            if (string != null) {
                return string;
            }
            StringBuilder sb = new StringBuilder();
            Random.Default r2 = Random.Default;
            Intrinsics.checkNotNullParameter(r2, "<this>");
            long nextLong = r2.nextLong();
            CharsKt__CharKt.checkRadix(16);
            sb.append(UnsignedKt.ulongToString(16, nextLong));
            Intrinsics.checkNotNullParameter(r2, "<this>");
            long nextLong2 = r2.nextLong();
            CharsKt__CharKt.checkRadix(16);
            sb.append(UnsignedKt.ulongToString(16, nextLong2));
            String sb2 = sb.toString();
            storage2 = HistoryDeviceIdUtilsKt.getStorage();
            storage2.put("baseInstallId", sb2);
            return sb2;
        }
    });

    private static final String getBaseInstallId() {
        return (String) baseInstallId$delegate.getValue();
    }

    public static final String getBaseInstallTestId() {
        return baseInstallTestId;
    }

    public static final String getHistoryDeviceId(String serialNumber) {
        Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
        String upperCase = StringsKt__StringsKt.padStart(UStringsKt.m1669toStringV7xB4Y4(WatchFileKt.dekHash(getBaseInstallId() + "_history_" + serialNumber)), 8, '0').toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return HistoryDeviceId.m1557constructorimpl("A-".concat(upperCase));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BasicStorage getStorage() {
        return (BasicStorage) storage$delegate.getValue();
    }

    public static final String mock(HistoryDeviceId.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return HistoryDeviceId.m1557constructorimpl("A-Mock");
    }

    public static final String none(HistoryDeviceId.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return HistoryDeviceId.m1557constructorimpl("A-None");
    }

    public static final void setBaseInstallTestId(String str) {
        baseInstallTestId = str;
    }
}
