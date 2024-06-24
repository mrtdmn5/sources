package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzha implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzhx zzb;

    public zzha(zzhx zzhxVar, long j) {
        this.zzb = zzhxVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhx zzhxVar = this.zzb;
        zzew zzewVar = zzhxVar.zzt.zzl;
        zzfr.zzP(zzewVar);
        zzes zzesVar = zzewVar.zzf;
        long j = this.zza;
        zzesVar.zzb(j);
        zzeh zzehVar = zzhxVar.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zzb(Long.valueOf(j), "Session timeout duration set");
    }
}
