package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjv implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzkc zzb;

    public zzjv(zzkc zzkcVar, long j) {
        this.zzb = zzkcVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j = this.zza;
        zzkc zzkcVar = this.zzb;
        zzkcVar.zzg();
        zzkcVar.zzm$2();
        zzfr zzfrVar = zzkcVar.zzt;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zzb(Long.valueOf(j), "Activity paused, time");
        zzjy zzjyVar = zzkcVar.zzc;
        zzkc zzkcVar2 = zzjyVar.zza;
        zzkcVar2.zzt.zzr.getClass();
        zzjx zzjxVar = new zzjx(zzjyVar, System.currentTimeMillis(), j);
        zzjyVar.zzb = zzjxVar;
        zzkcVar2.zzd.postDelayed(zzjxVar, 2000L);
        if (zzfrVar.zzk.zzu()) {
            zzkcVar.zzb.zzd.zzb();
        }
    }
}
