package com.amplifyframework.auth.cognito.asf;

import android.content.Context;
import android.os.Build;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BuildDataCollector.kt */
/* loaded from: classes.dex */
public final class BuildDataCollector implements DataCollector {
    public static final String BOOTLOADER = "Bootloader";
    public static final String BRAND = "DeviceBrand";
    public static final String BUILD_TYPE = "BuildType";
    public static final Companion Companion = new Companion(null);
    public static final String FINGERPRINT = "DeviceFingerprint";
    public static final String HARDWARE = "DeviceHardware";
    public static final String MANUFACTURER = "DeviceManufacturer";
    public static final String MODEL = "DeviceName";
    public static final String PRODUCT = "Product";
    public static final String VERSION_RELEASE = "DeviceOsReleaseVersion";
    public static final String VERSION_SDK = "DeviceSdkVersion";

    /* compiled from: BuildDataCollector.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.amplifyframework.auth.cognito.asf.DataCollector
    public Map<String, String> collect(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MapsKt__MapsKt.mapOf(new Pair(BRAND, Build.BRAND), new Pair(FINGERPRINT, Build.FINGERPRINT), new Pair(HARDWARE, Build.HARDWARE), new Pair(MODEL, Build.MODEL), new Pair(PRODUCT, Build.PRODUCT), new Pair(BUILD_TYPE, Build.TYPE), new Pair(VERSION_RELEASE, Build.VERSION.RELEASE), new Pair(VERSION_SDK, Build.VERSION.SDK));
    }
}
