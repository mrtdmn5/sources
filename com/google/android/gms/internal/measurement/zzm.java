package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzm extends zzai {
    public final /* synthetic */ com.google.android.gms.measurement.internal.zzfh zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(com.google.android.gms.measurement.internal.zzfh zzfhVar) {
        super("getValue");
        this.zza = zzfhVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        zzh.zzh("getValue", 2, list);
        zzap zzb = zzgVar.zzb((zzap) list.get(0));
        zzap zzb2 = zzgVar.zzb((zzap) list.get(1));
        String zzi = zzb.zzi();
        com.google.android.gms.measurement.internal.zzfh zzfhVar = this.zza;
        String str = null;
        Map map = (Map) zzfhVar.zzb.zzg.getOrDefault(zzfhVar.zza, null);
        if (map != null && map.containsKey(zzi)) {
            str = (String) map.get(zzi);
        }
        if (str != null) {
            return new zzat(str);
        }
        return zzb2;
    }
}
