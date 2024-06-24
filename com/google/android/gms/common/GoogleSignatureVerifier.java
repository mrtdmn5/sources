package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.animaconnected.secondo.R;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.RestrictedInheritance;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes3.dex */
public final class GoogleSignatureVerifier {
    public static GoogleSignatureVerifier zza;
    public final Context zzc;
    public volatile String zzd;

    public GoogleSignatureVerifier(Context context) {
        this.zzc = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzh zzhVar = zzn.zzc;
                synchronized (zzn.class) {
                    if (zzn.zzg == null) {
                        zzn.zzg = context.getApplicationContext();
                    } else {
                        Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
                    }
                }
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    public static final zzj zza(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
        for (int r2 = 0; r2 < zzjVarArr.length; r2++) {
            if (zzjVarArr[r2].equals(zzkVar)) {
                return zzjVarArr[r2];
            }
        }
        return null;
    }

    public static final boolean zzb(PackageInfo packageInfo, boolean z) {
        zzj zza2;
        if (z && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null || (applicationInfo.flags & R.styleable.AppTheme_statusTopStripeImportant) == 0) {
                z = false;
            } else {
                z = true;
            }
        }
        if (packageInfo != null && packageInfo.signatures != null) {
            if (z) {
                zza2 = zza(packageInfo, zzm.zza);
            } else {
                zza2 = zza(packageInfo, zzm.zza[0]);
            }
            if (zza2 != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isUidGoogleSigned(int r22) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.isUidGoogleSigned(int):boolean");
    }
}
