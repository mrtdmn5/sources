package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzz {
    public final TreeMap zza = new TreeMap();
    public final TreeMap zzb = new TreeMap();

    public final void zzb(zzg zzgVar, zzab zzabVar) {
        int r3;
        zzl zzlVar = new zzl(zzabVar);
        TreeMap treeMap = this.zza;
        for (Integer num : treeMap.keySet()) {
            zzaa clone = zzabVar.zzb.clone();
            zzap zza = ((zzao) treeMap.get(num)).zza(zzgVar, Collections.singletonList(zzlVar));
            if (zza instanceof zzah) {
                r3 = zzh.zzb(zza.zzh().doubleValue());
            } else {
                r3 = -1;
            }
            if (r3 == 2 || r3 == -1) {
                zzabVar.zzb = clone;
            }
        }
        TreeMap treeMap2 = this.zzb;
        Iterator it = treeMap2.keySet().iterator();
        while (it.hasNext()) {
            zzap zza2 = ((zzao) treeMap2.get((Integer) it.next())).zza(zzgVar, Collections.singletonList(zzlVar));
            if (zza2 instanceof zzah) {
                zzh.zzb(zza2.zzh().doubleValue());
            }
        }
    }
}
