package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zznx;
import com.google.android.gms.internal.measurement.zzpd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkb {
    public final /* synthetic */ zzkc zza;

    public zzkb(zzkc zzkcVar) {
        this.zza = zzkcVar;
    }

    public final void zza() {
        zzkc zzkcVar = this.zza;
        zzkcVar.zzg();
        zzfr zzfrVar = zzkcVar.zzt;
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        zzfrVar.zzr.getClass();
        if (zzewVar.zzk(System.currentTimeMillis())) {
            zzew zzewVar2 = zzfrVar.zzl;
            zzfr.zzP(zzewVar2);
            zzewVar2.zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzl.zza("Detected application was in foreground");
                zzfrVar.zzr.getClass();
                zzc(System.currentTimeMillis(), false);
            }
        }
    }

    public final void zzb(long j, boolean z) {
        zzkc zzkcVar = this.zza;
        zzkcVar.zzg();
        zzkcVar.zzm$2();
        zzfr zzfrVar = zzkcVar.zzt;
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        if (zzewVar.zzk(j)) {
            zzew zzewVar2 = zzfrVar.zzl;
            zzfr.zzP(zzewVar2);
            zzewVar2.zzg.zza(true);
            zzpd.zzc();
            if (zzfrVar.zzk.zzs(null, zzdu.zzam)) {
                zzfrVar.zzh().zzo();
            }
        }
        zzew zzewVar3 = zzfrVar.zzl;
        zzfr.zzP(zzewVar3);
        zzewVar3.zzj.zzb(j);
        zzew zzewVar4 = zzfrVar.zzl;
        zzfr.zzP(zzewVar4);
        if (zzewVar4.zzg.zzb()) {
            zzc(j, z);
        }
    }

    public final void zzc(long j, boolean z) {
        zzkc zzkcVar = this.zza;
        zzkcVar.zzg();
        zzfr zzfrVar = zzkcVar.zzt;
        if (!zzfrVar.zzJ()) {
            return;
        }
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        zzewVar.zzj.zzb(j);
        zzfrVar.zzr.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zzb(Long.valueOf(elapsedRealtime), "Session started, time");
        Long valueOf = Long.valueOf(j / 1000);
        zzhx zzhxVar = zzfrVar.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzY(j, valueOf, "auto", "_sid");
        zzew zzewVar2 = zzfrVar.zzl;
        zzfr.zzP(zzewVar2);
        zzewVar2.zzk.zzb(valueOf.longValue());
        zzew zzewVar3 = zzfrVar.zzl;
        zzfr.zzP(zzewVar3);
        zzewVar3.zzg.zza(false);
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", valueOf.longValue());
        if (zzfrVar.zzk.zzs(null, zzdu.zzZ) && z) {
            bundle.putLong("_aib", 1L);
        }
        zzhx zzhxVar2 = zzfrVar.zzt;
        zzfr.zzQ(zzhxVar2);
        zzhxVar2.zzH(j, bundle, "auto", "_s");
        ((zznx) zznw.zza.zzb.zza()).zza();
        if (zzfrVar.zzk.zzs(null, zzdu.zzac)) {
            zzew zzewVar4 = zzfrVar.zzl;
            zzfr.zzP(zzewVar4);
            String zza = zzewVar4.zzp.zza();
            if (!TextUtils.isEmpty(zza)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", zza);
                zzhx zzhxVar3 = zzfrVar.zzt;
                zzfr.zzQ(zzhxVar3);
                zzhxVar3.zzH(j, bundle2, "auto", "_ssr");
            }
        }
    }
}
