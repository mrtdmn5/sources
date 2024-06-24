package com.google.android.gms.internal.measurement;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzbc extends zzaw {
    public zzbc() {
        this.zza.add(zzbl.AND);
        this.zza.add(zzbl.NOT);
        this.zza.add(zzbl.OR);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, ArrayList arrayList) {
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 1) {
            if (ordinal != 47) {
                if (ordinal == 50) {
                    zzap zzb = zzgVar.zzb((zzap) zzav$$ExternalSyntheticOutline0.m(zzbl.OR, 2, arrayList, 0));
                    if (zzb.zzg().booleanValue()) {
                        return zzb;
                    }
                    return zzgVar.zzb((zzap) arrayList.get(1));
                }
                zzb(str);
                throw null;
            }
            return new zzaf(Boolean.valueOf(!zzgVar.zzb((zzap) zzav$$ExternalSyntheticOutline0.m(zzbl.NOT, 1, arrayList, 0)).zzg().booleanValue()));
        }
        zzap zzb2 = zzgVar.zzb((zzap) zzav$$ExternalSyntheticOutline0.m(zzbl.AND, 2, arrayList, 0));
        if (!zzb2.zzg().booleanValue()) {
            return zzb2;
        }
        return zzgVar.zzb((zzap) arrayList.get(1));
    }
}
