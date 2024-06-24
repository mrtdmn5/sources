package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class DeviceProperties {
    public static Boolean zzd;
    public static Boolean zze;
    public static Boolean zzg;
    public static Boolean zzi;

    @TargetApi(20)
    public static boolean isWearable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzd == null) {
            zzd = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return zzd.booleanValue();
    }

    @TargetApi(26)
    public static boolean isWearableWithoutPlayStore(Context context) {
        boolean z;
        isWearable(context);
        if (zze == null) {
            zze = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (zze.booleanValue()) {
            if (PlatformVersion.isAtLeastO()) {
                if (Build.VERSION.SDK_INT >= 30) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                }
            }
            return true;
        }
        return false;
    }
}
