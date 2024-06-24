package com.google.android.gms.internal.measurement;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzbi extends zzaw {
    public zzbi() {
        this.zza.add(zzbl.ADD);
        this.zza.add(zzbl.DIVIDE);
        this.zza.add(zzbl.MODULUS);
        this.zza.add(zzbl.MULTIPLY);
        this.zza.add(zzbl.NEGATE);
        this.zza.add(zzbl.POST_DECREMENT);
        this.zza.add(zzbl.POST_INCREMENT);
        this.zza.add(zzbl.PRE_DECREMENT);
        this.zza.add(zzbl.PRE_INCREMENT);
        this.zza.add(zzbl.SUBTRACT);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, ArrayList arrayList) {
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 0) {
            if (ordinal != 21) {
                if (ordinal != 59) {
                    if (ordinal != 52 && ordinal != 53) {
                        if (ordinal != 55 && ordinal != 56) {
                            switch (ordinal) {
                                case 44:
                                    return new zzah(Double.valueOf(zzgVar.zzb((zzap) zzav$$ExternalSyntheticOutline0.m(zzbl.MODULUS, 2, arrayList, 0)).zzh().doubleValue() % zzgVar.zzb((zzap) arrayList.get(1)).zzh().doubleValue()));
                                case 45:
                                    return new zzah(Double.valueOf(zzgVar.zzb((zzap) zzav$$ExternalSyntheticOutline0.m(zzbl.MULTIPLY, 2, arrayList, 0)).zzh().doubleValue() * zzgVar.zzb((zzap) arrayList.get(1)).zzh().doubleValue()));
                                case 46:
                                    return new zzah(Double.valueOf(-zzgVar.zzb((zzap) zzav$$ExternalSyntheticOutline0.m(zzbl.NEGATE, 1, arrayList, 0)).zzh().doubleValue()));
                                default:
                                    zzb(str);
                                    throw null;
                            }
                        }
                        zzh.zzh(str, 1, arrayList);
                        return zzgVar.zzb((zzap) arrayList.get(0));
                    }
                    zzh.zzh(str, 2, arrayList);
                    zzap zzb = zzgVar.zzb((zzap) arrayList.get(0));
                    zzgVar.zzb((zzap) arrayList.get(1));
                    return zzb;
                }
                zzap zzb2 = zzgVar.zzb((zzap) zzav$$ExternalSyntheticOutline0.m(zzbl.SUBTRACT, 2, arrayList, 0));
                Double valueOf = Double.valueOf(-zzgVar.zzb((zzap) arrayList.get(1)).zzh().doubleValue());
                if (valueOf == null) {
                    valueOf = Double.valueOf(Double.NaN);
                }
                return new zzah(Double.valueOf(valueOf.doubleValue() + zzb2.zzh().doubleValue()));
            }
            return new zzah(Double.valueOf(zzgVar.zzb((zzap) zzav$$ExternalSyntheticOutline0.m(zzbl.DIVIDE, 2, arrayList, 0)).zzh().doubleValue() / zzgVar.zzb((zzap) arrayList.get(1)).zzh().doubleValue()));
        }
        zzap zzb3 = zzgVar.zzb((zzap) zzav$$ExternalSyntheticOutline0.m(zzbl.ADD, 2, arrayList, 0));
        zzap zzb4 = zzgVar.zzb((zzap) arrayList.get(1));
        if (!(zzb3 instanceof zzal) && !(zzb3 instanceof zzat) && !(zzb4 instanceof zzal) && !(zzb4 instanceof zzat)) {
            return new zzah(Double.valueOf(zzb4.zzh().doubleValue() + zzb3.zzh().doubleValue()));
        }
        return new zzat(String.valueOf(zzb3.zzi()).concat(String.valueOf(zzb4.zzi())));
    }
}
