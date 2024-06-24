package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzbh extends zzaw {
    public zzbh() {
        this.zza.add(zzbl.FOR_IN);
        this.zza.add(zzbl.FOR_IN_CONST);
        this.zza.add(zzbl.FOR_IN_LET);
        this.zza.add(zzbl.FOR_LET);
        this.zza.add(zzbl.FOR_OF);
        this.zza.add(zzbl.FOR_OF_CONST);
        this.zza.add(zzbl.FOR_OF_LET);
        this.zza.add(zzbl.WHILE);
    }

    public static zzap zzc(zzbf zzbfVar, Iterator it, zzap zzapVar) {
        if (it != null) {
            while (it.hasNext()) {
                zzap zzc = zzbfVar.zza((zzap) it.next()).zzc((zzae) zzapVar);
                if (zzc instanceof zzag) {
                    zzag zzagVar = (zzag) zzc;
                    if ("break".equals(zzagVar.zzb)) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzagVar.zzb)) {
                        return zzagVar;
                    }
                }
            }
        }
        return zzap.zzf;
    }

    public static zzap zze(zzbf zzbfVar, zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof Iterable) {
            return zzc(zzbfVar, ((Iterable) zzapVar).iterator(), zzapVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, ArrayList arrayList) {
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 65) {
            switch (ordinal) {
                case 26:
                    if (zzav$$ExternalSyntheticOutline0.m(zzbl.FOR_IN, 3, arrayList, 0) instanceof zzat) {
                        String zzi = ((zzap) arrayList.get(0)).zzi();
                        zzap zzb = zzgVar.zzb((zzap) arrayList.get(1));
                        zzap zzb2 = zzgVar.zzb((zzap) arrayList.get(2));
                        Iterator zzl = zzb.zzl();
                        if (zzl != null) {
                            while (zzl.hasNext()) {
                                zzgVar.zze(zzi, (zzap) zzl.next());
                                zzap zzc = zzgVar.zzc((zzae) zzb2);
                                if (zzc instanceof zzag) {
                                    zzag zzagVar = (zzag) zzc;
                                    if ("break".equals(zzagVar.zzb)) {
                                        return zzap.zzf;
                                    }
                                    if ("return".equals(zzagVar.zzb)) {
                                        return zzagVar;
                                    }
                                }
                            }
                        }
                        return zzap.zzf;
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                case 27:
                    if (zzav$$ExternalSyntheticOutline0.m(zzbl.FOR_IN_CONST, 3, arrayList, 0) instanceof zzat) {
                        return zzc(new zzbd(zzgVar, ((zzap) arrayList.get(0)).zzi()), zzgVar.zzb((zzap) arrayList.get(1)).zzl(), zzgVar.zzb((zzap) arrayList.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                case 28:
                    if (zzav$$ExternalSyntheticOutline0.m(zzbl.FOR_IN_LET, 3, arrayList, 0) instanceof zzat) {
                        return zzc(new zzbe(zzgVar, ((zzap) arrayList.get(0)).zzi()), zzgVar.zzb((zzap) arrayList.get(1)).zzl(), zzgVar.zzb((zzap) arrayList.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                case 29:
                    zzap zzb3 = zzgVar.zzb((zzap) zzav$$ExternalSyntheticOutline0.m(zzbl.FOR_LET, 4, arrayList, 0));
                    if (zzb3 instanceof zzae) {
                        zzae zzaeVar = (zzae) zzb3;
                        zzap zzapVar = (zzap) arrayList.get(1);
                        zzap zzapVar2 = (zzap) arrayList.get(2);
                        zzap zzb4 = zzgVar.zzb((zzap) arrayList.get(3));
                        zzg zza = zzgVar.zza();
                        for (int r5 = 0; r5 < zzaeVar.zzc(); r5++) {
                            String zzi2 = zzaeVar.zze(r5).zzi();
                            zza.zzg(zzi2, zzgVar.zzd(zzi2));
                        }
                        while (zzgVar.zzb(zzapVar).zzg().booleanValue()) {
                            zzap zzc2 = zzgVar.zzc((zzae) zzb4);
                            if (zzc2 instanceof zzag) {
                                zzag zzagVar2 = (zzag) zzc2;
                                if ("break".equals(zzagVar2.zzb)) {
                                    return zzap.zzf;
                                }
                                if ("return".equals(zzagVar2.zzb)) {
                                    return zzagVar2;
                                }
                            }
                            zzg zza2 = zzgVar.zza();
                            for (int r6 = 0; r6 < zzaeVar.zzc(); r6++) {
                                String zzi3 = zzaeVar.zze(r6).zzi();
                                zza2.zzg(zzi3, zza.zzd(zzi3));
                            }
                            zza2.zzb(zzapVar2);
                            zza = zza2;
                        }
                        return zzap.zzf;
                    }
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                case 30:
                    if (zzav$$ExternalSyntheticOutline0.m(zzbl.FOR_OF, 3, arrayList, 0) instanceof zzat) {
                        return zze(new zzbg(zzgVar, ((zzap) arrayList.get(0)).zzi()), zzgVar.zzb((zzap) arrayList.get(1)), zzgVar.zzb((zzap) arrayList.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                case 31:
                    if (zzav$$ExternalSyntheticOutline0.m(zzbl.FOR_OF_CONST, 3, arrayList, 0) instanceof zzat) {
                        return zze(new zzbd(zzgVar, ((zzap) arrayList.get(0)).zzi()), zzgVar.zzb((zzap) arrayList.get(1)), zzgVar.zzb((zzap) arrayList.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                case 32:
                    if (zzav$$ExternalSyntheticOutline0.m(zzbl.FOR_OF_LET, 3, arrayList, 0) instanceof zzat) {
                        return zze(new zzbe(zzgVar, ((zzap) arrayList.get(0)).zzi()), zzgVar.zzb((zzap) arrayList.get(1)), zzgVar.zzb((zzap) arrayList.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                default:
                    zzb(str);
                    throw null;
            }
        }
        zzap zzapVar3 = (zzap) zzav$$ExternalSyntheticOutline0.m(zzbl.WHILE, 4, arrayList, 0);
        zzap zzapVar4 = (zzap) arrayList.get(1);
        zzap zzapVar5 = (zzap) arrayList.get(2);
        zzap zzb5 = zzgVar.zzb((zzap) arrayList.get(3));
        if (zzgVar.zzb(zzapVar5).zzg().booleanValue()) {
            zzap zzc3 = zzgVar.zzc((zzae) zzb5);
            if (zzc3 instanceof zzag) {
                zzag zzagVar3 = (zzag) zzc3;
                if ("break".equals(zzagVar3.zzb)) {
                    return zzap.zzf;
                }
                if ("return".equals(zzagVar3.zzb)) {
                    return zzagVar3;
                }
            }
        }
        while (zzgVar.zzb(zzapVar3).zzg().booleanValue()) {
            zzap zzc4 = zzgVar.zzc((zzae) zzb5);
            if (zzc4 instanceof zzag) {
                zzag zzagVar4 = (zzag) zzc4;
                if ("break".equals(zzagVar4.zzb)) {
                    return zzap.zzf;
                }
                if ("return".equals(zzagVar4.zzb)) {
                    return zzagVar4;
                }
            }
            zzgVar.zzb(zzapVar4);
        }
        return zzap.zzf;
    }
}
