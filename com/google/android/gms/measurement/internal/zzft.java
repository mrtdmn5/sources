package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzft implements Runnable {
    public final /* synthetic */ zzac zza;
    public final /* synthetic */ zzq zzb;
    public final /* synthetic */ zzgj zzc;

    public zzft(zzgj zzgjVar, zzac zzacVar, zzq zzqVar) {
        this.zzc = zzgjVar;
        this.zza = zzacVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgj zzgjVar = this.zzc;
        zzgjVar.zza.zzA$1();
        zzac zzacVar = this.zza;
        Object zza = zzacVar.zzc.zza();
        zzkt zzktVar = zzgjVar.zza;
        zzq zzqVar = this.zzb;
        if (zza == null) {
            zzktVar.zzO(zzacVar, zzqVar);
        } else {
            zzktVar.zzU(zzacVar, zzqVar);
        }
    }
}
