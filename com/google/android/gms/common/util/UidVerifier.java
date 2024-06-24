package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class UidVerifier {
    public static boolean isGooglePlayServicesUid(Context context, int r4) {
        if (!uidHasPackageName(r4, context, "com.google.android.gms")) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
            GoogleSignatureVerifier googleSignatureVerifier = GoogleSignatureVerifier.getInstance(context);
            googleSignatureVerifier.getClass();
            if (packageInfo == null) {
                return false;
            }
            if (!GoogleSignatureVerifier.zzb(packageInfo, false)) {
                if (!GoogleSignatureVerifier.zzb(packageInfo, true)) {
                    return false;
                }
                if (!GooglePlayServicesUtilLight.honorsDebugCertificates(googleSignatureVerifier.zzc)) {
                    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    @TargetApi(19)
    public static boolean uidHasPackageName(int r1, Context context, String str) {
        PackageManagerWrapper packageManager = Wrappers.packageManager(context);
        packageManager.getClass();
        try {
            AppOpsManager appOpsManager = (AppOpsManager) packageManager.zza.getSystemService("appops");
            if (appOpsManager != null) {
                appOpsManager.checkPackage(r1, str);
                return true;
            }
            throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
        } catch (SecurityException unused) {
            return false;
        }
    }
}
