package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzk extends zzai {
    public final zzab zza;

    public zzk(zzab zzabVar) {
        super("internal.eventLogger");
        this.zza = zzabVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        HashMap hashMap;
        zzh.zzh(this.zzd, 3, list);
        String zzi = zzgVar.zzb((zzap) list.get(0)).zzi();
        long zza = (long) zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
        zzap zzb = zzgVar.zzb((zzap) list.get(2));
        if (zzb instanceof zzam) {
            hashMap = zzh.zzg((zzam) zzb);
        } else {
            hashMap = new HashMap();
        }
        zzab zzabVar = this.zza;
        zzabVar.getClass();
        zzabVar.zzc.add(new zzaa(hashMap, zzi, zza));
        return zzap.zzf;
    }
}
