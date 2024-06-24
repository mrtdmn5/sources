package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzim extends zzf {
    public zzie zza;
    public volatile zzie zzb;
    public volatile zzie zzc;
    public final ConcurrentHashMap zzd;
    public Activity zze;
    public volatile boolean zzf;
    public volatile zzie zzg;
    public zzie zzh;
    public boolean zzi;
    public final Object zzj;

    public zzim(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzA(com.google.android.gms.measurement.internal.zzie r18, com.google.android.gms.measurement.internal.zzie r19, long r20, boolean r22, android.os.Bundle r23) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzim.zzA(com.google.android.gms.measurement.internal.zzie, com.google.android.gms.measurement.internal.zzie, long, boolean, android.os.Bundle):void");
    }

    public final void zzB(zzie zzieVar, boolean z, long j) {
        boolean z2;
        zzfr zzfrVar = this.zzt;
        zzd zzd = zzfrVar.zzd();
        zzfrVar.zzr.getClass();
        zzd.zzf(SystemClock.elapsedRealtime());
        if (zzieVar != null && zzieVar.zzd) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzkc zzkcVar = zzfrVar.zzo;
        zzfr.zzQ(zzkcVar);
        if (zzkcVar.zzb.zzd(z2, z, j) && zzieVar != null) {
            zzieVar.zzd = false;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    public final zzie zzj(boolean z) {
        zza();
        zzg();
        if (!z) {
            return this.zza;
        }
        zzie zzieVar = this.zza;
        if (zzieVar != null) {
            return zzieVar;
        }
        return this.zzh;
    }

    public final String zzl(Class cls) {
        String str;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        if (length > 0) {
            str = split[length - 1];
        } else {
            str = "";
        }
        int length2 = str.length();
        this.zzt.getClass();
        if (length2 > 100) {
            return str.substring(0, 100);
        }
        return str;
    }

    public final void zzr(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.zzt.zzk.zzu() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzie(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(ConfigurationItem.COLUMN_NAME_ID)));
    }

    public final zzie zzy(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzie zzieVar = (zzie) this.zzd.get(activity);
        if (zzieVar == null) {
            String zzl = zzl(activity.getClass());
            zzlb zzlbVar = this.zzt.zzp;
            zzfr.zzP(zzlbVar);
            zzie zzieVar2 = new zzie(null, zzl, zzlbVar.zzq());
            this.zzd.put(activity, zzieVar2);
            zzieVar = zzieVar2;
        }
        if (this.zzg != null) {
            return this.zzg;
        }
        return zzieVar;
    }

    public final void zzz(Activity activity, zzie zzieVar, boolean z) {
        zzie zzieVar2;
        zzie zzieVar3;
        String str;
        if (this.zzb == null) {
            zzieVar2 = this.zzc;
        } else {
            zzieVar2 = this.zzb;
        }
        zzie zzieVar4 = zzieVar2;
        if (zzieVar.zzb == null) {
            if (activity != null) {
                str = zzl(activity.getClass());
            } else {
                str = null;
            }
            zzieVar3 = new zzie(zzieVar.zza, str, zzieVar.zzc, zzieVar.zze, zzieVar.zzf);
        } else {
            zzieVar3 = zzieVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzieVar3;
        this.zzt.zzr.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        zzfo zzfoVar = this.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzih(this, zzieVar3, zzieVar4, elapsedRealtime, z));
    }
}
