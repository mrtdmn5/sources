package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzv extends zzai {
    public final zzz zza;

    public zzv(zzz zzzVar) {
        super("internal.registerCallback");
        this.zza = zzzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        int r5;
        TreeMap treeMap;
        zzh.zzh(this.zzd, 3, list);
        zzgVar.zzb((zzap) list.get(0)).zzi();
        zzap zzb = zzgVar.zzb((zzap) list.get(1));
        if (zzb instanceof zzao) {
            zzap zzb2 = zzgVar.zzb((zzap) list.get(2));
            if (zzb2 instanceof zzam) {
                zzam zzamVar = (zzam) zzb2;
                if (zzamVar.zzt("type")) {
                    String zzi = zzamVar.zzf("type").zzi();
                    if (zzamVar.zzt("priority")) {
                        r5 = zzh.zzb(zzamVar.zzf("priority").zzh().doubleValue());
                    } else {
                        r5 = 1000;
                    }
                    zzao zzaoVar = (zzao) zzb;
                    zzz zzzVar = this.zza;
                    zzzVar.getClass();
                    if ("create".equals(zzi)) {
                        treeMap = zzzVar.zzb;
                    } else if ("edit".equals(zzi)) {
                        treeMap = zzzVar.zza;
                    } else {
                        throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(zzi)));
                    }
                    if (treeMap.containsKey(Integer.valueOf(r5))) {
                        r5 = ((Integer) treeMap.lastKey()).intValue() + 1;
                    }
                    treeMap.put(Integer.valueOf(r5), zzaoVar);
                    return zzap.zzf;
                }
                throw new IllegalArgumentException("Undefined rule type");
            }
            throw new IllegalArgumentException("Invalid callback params");
        }
        throw new IllegalArgumentException("Invalid callback type");
    }
}
