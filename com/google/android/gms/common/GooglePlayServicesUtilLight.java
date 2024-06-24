package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public class GooglePlayServicesUtilLight {
    public static boolean zza = false;
    public static boolean zzb = false;
    public static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
    public static final AtomicBoolean zzc = new AtomicBoolean();

    public static boolean honorsDebugCertificates(Context context) {
        try {
            if (!zza) {
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(64, "com.google.android.gms");
                GoogleSignatureVerifier.getInstance(context);
                if (packageInfo != null && !GoogleSignatureVerifier.zzb(packageInfo, false) && GoogleSignatureVerifier.zzb(packageInfo, true)) {
                    zzb = true;
                } else {
                    zzb = false;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
        } finally {
            zza = true;
        }
        if (!zzb && "user".equals(Build.TYPE)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00b3  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int isGooglePlayServicesAvailable(android.content.Context r8, int r9) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(android.content.Context, int):int");
    }

    @TargetApi(21)
    public static boolean zza(Context context) {
        try {
            Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (it.hasNext()) {
                if ("com.google.android.gms".equals(it.next().getAppPackageName())) {
                    return true;
                }
            }
            return context.getPackageManager().getApplicationInfo("com.google.android.gms", DfuBaseService.ERROR_REMOTE_MASK).enabled;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }
}
