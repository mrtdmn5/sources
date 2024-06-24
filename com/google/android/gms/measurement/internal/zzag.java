package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzag extends zzgk {
    public Boolean zza;
    public zzaf zzb;
    public Boolean zzc;

    public zzag(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzb = zzae.zza;
    }

    public final String zzB(String str) {
        zzfr zzfrVar = this.zzt;
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str2);
            return str2;
        } catch (ClassNotFoundException e) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(e, "Could not find SystemProperties class");
            return "";
        } catch (IllegalAccessException e2) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(e2, "Could not access SystemProperties.get()");
            return "";
        } catch (NoSuchMethodException e3) {
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzehVar3.zzd.zzb(e3, "Could not find SystemProperties.get() method");
            return "";
        } catch (InvocationTargetException e4) {
            zzeh zzehVar4 = zzfrVar.zzm;
            zzfr.zzR(zzehVar4);
            zzehVar4.zzd.zzb(e4, "SystemProperties.get() threw an exception");
            return "";
        }
    }

    public final double zza(String str, zzdt zzdtVar) {
        if (str == null) {
            return ((Double) zzdtVar.zza(null)).doubleValue();
        }
        String zza = this.zzb.zza(str, zzdtVar.zzb);
        if (TextUtils.isEmpty(zza)) {
            return ((Double) zzdtVar.zza(null)).doubleValue();
        }
        try {
            return ((Double) zzdtVar.zza(Double.valueOf(Double.parseDouble(zza)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzdtVar.zza(null)).doubleValue();
        }
    }

    public final int zzc() {
        zzlb zzlbVar = this.zzt.zzp;
        zzfr.zzP(zzlbVar);
        Boolean bool = zzlbVar.zzt.zzt().zzc;
        if (zzlbVar.zzm() < 201500) {
            if (bool == null || bool.booleanValue()) {
                return 25;
            }
            return 100;
        }
        return 100;
    }

    public final int zze(String str, zzdt zzdtVar) {
        if (str == null) {
            return ((Integer) zzdtVar.zza(null)).intValue();
        }
        String zza = this.zzb.zza(str, zzdtVar.zzb);
        if (TextUtils.isEmpty(zza)) {
            return ((Integer) zzdtVar.zza(null)).intValue();
        }
        try {
            return ((Integer) zzdtVar.zza(Integer.valueOf(Integer.parseInt(zza)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzdtVar.zza(null)).intValue();
        }
    }

    public final void zzh() {
        this.zzt.getClass();
    }

    public final long zzi(String str, zzdt zzdtVar) {
        if (str == null) {
            return ((Long) zzdtVar.zza(null)).longValue();
        }
        String zza = this.zzb.zza(str, zzdtVar.zzb);
        if (TextUtils.isEmpty(zza)) {
            return ((Long) zzdtVar.zza(null)).longValue();
        }
        try {
            return ((Long) zzdtVar.zza(Long.valueOf(Long.parseLong(zza)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzdtVar.zza(null)).longValue();
        }
    }

    public final Bundle zzj() {
        zzfr zzfrVar = this.zzt;
        try {
            if (zzfrVar.zze.getPackageManager() == null) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzfrVar.zze).getApplicationInfo(128, zzfrVar.zze.getPackageName());
            if (applicationInfo == null) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzehVar3.zzd.zzb(e, "Failed to load metadata: Package name not found");
            return null;
        }
    }

    public final Boolean zzk(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzj = zzj();
        if (zzj == null) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (!zzj.containsKey(str)) {
            return null;
        }
        return Boolean.valueOf(zzj.getBoolean(str));
    }

    public final boolean zzs(String str, zzdt zzdtVar) {
        if (str == null) {
            return ((Boolean) zzdtVar.zza(null)).booleanValue();
        }
        String zza = this.zzb.zza(str, zzdtVar.zzb);
        if (TextUtils.isEmpty(zza)) {
            return ((Boolean) zzdtVar.zza(null)).booleanValue();
        }
        return ((Boolean) zzdtVar.zza(Boolean.valueOf("1".equals(zza)))).booleanValue();
    }

    public final boolean zzu() {
        Boolean zzk = zzk("google_analytics_automatic_screen_reporting_enabled");
        if (zzk != null && !zzk.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean zzv() {
        this.zzt.getClass();
        Boolean zzk = zzk("firebase_analytics_collection_deactivated");
        if (zzk != null && zzk.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean zzw(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    public final boolean zzx() {
        if (this.zza == null) {
            Boolean zzk = zzk("app_measurement_lite");
            this.zza = zzk;
            if (zzk == null) {
                this.zza = Boolean.FALSE;
            }
        }
        if (!this.zza.booleanValue() && this.zzt.zzi) {
            return false;
        }
        return true;
    }
}
