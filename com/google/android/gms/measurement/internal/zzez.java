package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzez {
    public final zzfr zza;

    public zzez(zzkt zzktVar) {
        this.zza = zzktVar.zzn;
    }

    public final boolean zza() {
        zzfr zzfrVar = this.zza;
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(zzfrVar.zze);
            if (packageManager == null) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzl.zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            }
            if (packageManager.getPackageInfo(128, "com.android.vending").versionCode < 80837300) {
                return false;
            }
            return true;
        } catch (Exception e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzl.zzb(e, "Failed to retrieve Play Store version for Install Referrer");
            return false;
        }
    }
}
