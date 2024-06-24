package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.internal.measurement.zzof;
import com.google.android.gms.internal.measurement.zzog;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzka {
    public long zza;
    public long zzb;
    public final /* synthetic */ zzkc zzc;
    public final zzjz zzd;

    public zzka(zzkc zzkcVar) {
        this.zzc = zzkcVar;
        this.zzd = new zzjz(this, zzkcVar.zzt);
        zzkcVar.zzt.zzr.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    public final boolean zzd(boolean z, boolean z2, long j) {
        zzkc zzkcVar = this.zzc;
        zzkcVar.zzg();
        zzkcVar.zza();
        ((zzog) zzof.zza.zzb.zza()).zza();
        zzfr zzfrVar = zzkcVar.zzt;
        if (zzfrVar.zzk.zzs(null, zzdu.zzad)) {
            if (zzfrVar.zzJ()) {
                zzew zzewVar = zzfrVar.zzl;
                zzfr.zzP(zzewVar);
                zzfrVar.zzr.getClass();
                zzewVar.zzj.zzb(System.currentTimeMillis());
            }
        } else {
            zzew zzewVar2 = zzfrVar.zzl;
            zzfr.zzP(zzewVar2);
            zzfrVar.zzr.getClass();
            zzewVar2.zzj.zzb(System.currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (!z && j2 < 1000) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zzb(Long.valueOf(j2), "Screen exposed for less than 1000 ms. Event not sent. time");
            return false;
        }
        if (!z2) {
            j2 = j - this.zzb;
            this.zzb = j;
        }
        zzeh zzehVar2 = zzfrVar.zzm;
        zzfr.zzR(zzehVar2);
        zzehVar2.zzl.zzb(Long.valueOf(j2), "Recording user engagement, ms");
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        boolean zzu = zzfrVar.zzk.zzu();
        zzim zzimVar = zzfrVar.zzs;
        zzfr.zzQ(zzimVar);
        zzlb.zzK(zzimVar.zzj(!zzu), bundle, true);
        if (!z2) {
            zzhx zzhxVar = zzfrVar.zzt;
            zzfr.zzQ(zzhxVar);
            zzhxVar.zzG("auto", "_e", bundle);
        }
        this.zza = j;
        zzjz zzjzVar = this.zzd;
        zzjzVar.zzb();
        zzjzVar.zzd(3600000L);
        return true;
    }
}
