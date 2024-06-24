package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgb implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzgj zzb;

    public zzgb(zzgj zzgjVar, zzq zzqVar) {
        this.zzb = zzgjVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgj zzgjVar = this.zzb;
        zzgjVar.zza.zzA$1();
        zzkt zzktVar = zzgjVar.zza;
        zzktVar.zzaz().zzg();
        zzktVar.zzB$1();
        zzq zzqVar = this.zza;
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzai zzb = zzai.zzb(zzqVar.zzv);
        String str = zzqVar.zza;
        zzai zzh = zzktVar.zzh(str);
        zzktVar.zzay().zzl.zzc(str, zzb, "Setting consent, package, consent");
        zzktVar.zzV(str, zzb);
        if (zzb.zzl(zzh, (zzah[]) zzb.zzb.keySet().toArray(new zzah[0]))) {
            zzktVar.zzQ(zzqVar);
        }
    }
}
