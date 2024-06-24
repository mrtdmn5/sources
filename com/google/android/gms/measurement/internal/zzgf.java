package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgf implements Runnable {
    public final /* synthetic */ zzkw zza;
    public final /* synthetic */ zzq zzb;
    public final /* synthetic */ zzgj zzc;

    public zzgf(zzgj zzgjVar, zzkw zzkwVar, zzq zzqVar) {
        this.zzc = zzgjVar;
        this.zza = zzkwVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgj zzgjVar = this.zzc;
        zzgjVar.zza.zzA$1();
        zzkw zzkwVar = this.zza;
        Object zza = zzkwVar.zza();
        zzkt zzktVar = zzgjVar.zza;
        zzq zzqVar = this.zzb;
        if (zza == null) {
            zzktVar.zzP(zzkwVar, zzqVar);
        } else {
            zzktVar.zzW(zzkwVar, zzqVar);
        }
    }
}
