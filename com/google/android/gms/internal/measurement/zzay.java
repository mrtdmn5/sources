package com.google.android.gms.internal.measurement;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzay extends zzaw {
    public zzay() {
        this.zza.add(zzbl.EQUALS);
        this.zza.add(zzbl.GREATER_THAN);
        this.zza.add(zzbl.GREATER_THAN_EQUALS);
        this.zza.add(zzbl.IDENTITY_EQUALS);
        this.zza.add(zzbl.IDENTITY_NOT_EQUALS);
        this.zza.add(zzbl.LESS_THAN);
        this.zza.add(zzbl.LESS_THAN_EQUALS);
        this.zza.add(zzbl.NOT_EQUALS);
    }

    public static boolean zzc(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar.getClass().equals(zzapVar2.getClass())) {
            if ((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) {
                return true;
            }
            if (zzapVar instanceof zzah) {
                if (Double.isNaN(zzapVar.zzh().doubleValue()) || Double.isNaN(zzapVar2.zzh().doubleValue()) || zzapVar.zzh().doubleValue() != zzapVar2.zzh().doubleValue()) {
                    return false;
                }
                return true;
            }
            if (zzapVar instanceof zzat) {
                return zzapVar.zzi().equals(zzapVar2.zzi());
            }
            if (zzapVar instanceof zzaf) {
                return zzapVar.zzg().equals(zzapVar2.zzg());
            }
            if (zzapVar != zzapVar2) {
                return false;
            }
            return true;
        }
        if (((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) && ((zzapVar2 instanceof zzau) || (zzapVar2 instanceof zzan))) {
            return true;
        }
        boolean z = zzapVar instanceof zzah;
        if (z && (zzapVar2 instanceof zzat)) {
            return zzc(zzapVar, new zzah(zzapVar2.zzh()));
        }
        boolean z2 = zzapVar instanceof zzat;
        if (z2 && (zzapVar2 instanceof zzah)) {
            return zzc(new zzah(zzapVar.zzh()), zzapVar2);
        }
        if (zzapVar instanceof zzaf) {
            return zzc(new zzah(zzapVar.zzh()), zzapVar2);
        }
        if (zzapVar2 instanceof zzaf) {
            return zzc(zzapVar, new zzah(zzapVar2.zzh()));
        }
        if ((!z2 && !z) || !(zzapVar2 instanceof zzal)) {
            if (!(zzapVar instanceof zzal) || (!(zzapVar2 instanceof zzat) && !(zzapVar2 instanceof zzah))) {
                return false;
            }
            return zzc(new zzat(zzapVar.zzi()), zzapVar2);
        }
        return zzc(zzapVar, new zzat(zzapVar2.zzi()));
    }

    public static boolean zzd(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof zzal) {
            zzapVar = new zzat(zzapVar.zzi());
        }
        if (zzapVar2 instanceof zzal) {
            zzapVar2 = new zzat(zzapVar2.zzi());
        }
        if ((zzapVar instanceof zzat) && (zzapVar2 instanceof zzat)) {
            if (zzapVar.zzi().compareTo(zzapVar2.zzi()) < 0) {
                return true;
            }
            return false;
        }
        double doubleValue = zzapVar.zzh().doubleValue();
        double doubleValue2 = zzapVar2.zzh().doubleValue();
        if (!Double.isNaN(doubleValue) && !Double.isNaN(doubleValue2) && ((doubleValue != 0.0d || doubleValue2 != 0.0d) && ((doubleValue != 0.0d || doubleValue2 != 0.0d) && Double.compare(doubleValue, doubleValue2) < 0))) {
            return true;
        }
        return false;
    }

    public static boolean zze(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof zzal) {
            zzapVar = new zzat(zzapVar.zzi());
        }
        if (zzapVar2 instanceof zzal) {
            zzapVar2 = new zzat(zzapVar2.zzi());
        }
        if (((!(zzapVar instanceof zzat) || !(zzapVar2 instanceof zzat)) && (Double.isNaN(zzapVar.zzh().doubleValue()) || Double.isNaN(zzapVar2.zzh().doubleValue()))) || zzd(zzapVar2, zzapVar)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x003a. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, ArrayList arrayList) {
        boolean zzc;
        boolean zzc2;
        zzh.zzh(zzh.zze(str).name(), 2, arrayList);
        zzap zzb = zzgVar.zzb((zzap) arrayList.get(0));
        zzap zzb2 = zzgVar.zzb((zzap) arrayList.get(1));
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 23) {
            if (ordinal != 48) {
                if (ordinal != 42) {
                    if (ordinal != 43) {
                        switch (ordinal) {
                            case 37:
                                zzc = zzd(zzb2, zzb);
                                break;
                            case 38:
                                zzc = zze(zzb2, zzb);
                                break;
                            case 39:
                                zzc = zzh.zzl(zzb, zzb2);
                                break;
                            case 40:
                                zzc2 = zzh.zzl(zzb, zzb2);
                                break;
                            default:
                                zzb(str);
                                throw null;
                        }
                    } else {
                        zzc = zze(zzb, zzb2);
                    }
                } else {
                    zzc = zzd(zzb, zzb2);
                }
            } else {
                zzc2 = zzc(zzb, zzb2);
            }
            zzc = !zzc2;
        } else {
            zzc = zzc(zzb, zzb2);
        }
        if (zzc) {
            return zzap.zzk;
        }
        return zzap.zzl;
    }
}
