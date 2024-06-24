package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzao extends zzai {
    public final ArrayList zza;
    public final ArrayList zzb;
    public final zzg zzc;

    public zzao(zzao zzaoVar) {
        super(zzaoVar.zzd);
        ArrayList arrayList = new ArrayList(zzaoVar.zza.size());
        this.zza = arrayList;
        arrayList.addAll(zzaoVar.zza);
        ArrayList arrayList2 = new ArrayList(zzaoVar.zzb.size());
        this.zzb = arrayList2;
        arrayList2.addAll(zzaoVar.zzb);
        this.zzc = zzaoVar.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        zzau zzauVar;
        zzg zza = this.zzc.zza();
        int r1 = 0;
        while (true) {
            ArrayList arrayList = this.zza;
            int size = arrayList.size();
            zzauVar = zzap.zzf;
            if (r1 >= size) {
                break;
            }
            if (r1 < list.size()) {
                zza.zze((String) arrayList.get(r1), zzgVar.zzb((zzap) list.get(r1)));
            } else {
                zza.zze((String) arrayList.get(r1), zzauVar);
            }
            r1++;
        }
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            zzap zzapVar = (zzap) it.next();
            zzap zzb = zza.zzb(zzapVar);
            if (zzb instanceof zzaq) {
                zzb = zza.zzb(zzapVar);
            }
            if (zzb instanceof zzag) {
                return ((zzag) zzb).zza;
            }
        }
        return zzauVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai, com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzao(this);
    }

    public zzao(String str, ArrayList arrayList, List list, zzg zzgVar) {
        super(str);
        this.zza = new ArrayList();
        this.zzc = zzgVar;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.zza.add(((zzap) it.next()).zzi());
            }
        }
        this.zzb = new ArrayList(list);
    }
}
