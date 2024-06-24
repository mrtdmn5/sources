package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzax {
    public final HashMap zza = new HashMap();
    public final zzbj zzb = new zzbj();

    public zzax() {
        zzb(new zzav());
        zzb(new zzay());
        zzb(new zzaz());
        zzb(new zzbc());
        zzb(new zzbh());
        zzb(new zzbi());
        zzb(new zzbk());
    }

    public final zzap zza(zzg zzgVar, zzap zzapVar) {
        zzaw zzawVar;
        zzh.zzc(zzgVar);
        if (zzapVar instanceof zzaq) {
            zzaq zzaqVar = (zzaq) zzapVar;
            ArrayList arrayList = zzaqVar.zzb;
            HashMap hashMap = this.zza;
            String str = zzaqVar.zza;
            if (hashMap.containsKey(str)) {
                zzawVar = (zzaw) hashMap.get(str);
            } else {
                zzawVar = this.zzb;
            }
            return zzawVar.zza(str, zzgVar, arrayList);
        }
        return zzapVar;
    }

    public final void zzb(zzaw zzawVar) {
        Iterator it = zzawVar.zza.iterator();
        while (it.hasNext()) {
            this.zza.put(((zzbl) it.next()).zzb().toString(), zzawVar);
        }
    }
}
