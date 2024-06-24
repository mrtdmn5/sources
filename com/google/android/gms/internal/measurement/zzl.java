package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzl extends zzam {
    public final zzab zzb;

    public zzl(zzab zzabVar) {
        this.zzb = zzabVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.zzam, com.google.android.gms.internal.measurement.zzap
    public final zzap zzbR(String str, zzg zzgVar, ArrayList arrayList) {
        char c;
        zzl zzlVar;
        Object obj;
        switch (str.hashCode()) {
            case 21624207:
                if (str.equals("getEventName")) {
                    c = 0;
                    zzlVar = this;
                    break;
                }
                c = 65535;
                zzlVar = this;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    zzlVar = this;
                    c = 3;
                    break;
                }
                c = 65535;
                zzlVar = this;
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    zzlVar = this;
                    c = 1;
                    break;
                }
                c = 65535;
                zzlVar = this;
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    zzlVar = this;
                    c = 2;
                    break;
                }
                c = 65535;
                zzlVar = this;
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    c = 5;
                    zzlVar = this;
                    break;
                }
                c = 65535;
                zzlVar = this;
            case 1570616835:
                if (str.equals("setEventName")) {
                    zzlVar = this;
                    c = 4;
                    break;
                }
                c = 65535;
                zzlVar = this;
                break;
            default:
                c = 65535;
                zzlVar = this;
                break;
        }
        zzab zzabVar = zzlVar.zzb;
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            if (c != 5) {
                                return super.zzbR(str, zzgVar, arrayList);
                            }
                            zzh.zzh("setParamValue", 2, arrayList);
                            String zzi = zzgVar.zzb((zzap) arrayList.get(0)).zzi();
                            zzap zzb = zzgVar.zzb((zzap) arrayList.get(1));
                            zzaa zzaaVar = zzabVar.zzb;
                            Object zzf = zzh.zzf(zzb);
                            HashMap hashMap = zzaaVar.zzc;
                            if (zzf == null) {
                                hashMap.remove(zzi);
                            } else {
                                hashMap.put(zzi, zzf);
                            }
                            return zzb;
                        }
                        zzh.zzh("setEventName", 1, arrayList);
                        zzap zzb2 = zzgVar.zzb((zzap) arrayList.get(0));
                        if (!zzap.zzf.equals(zzb2) && !zzap.zzg.equals(zzb2)) {
                            zzabVar.zzb.zza = zzb2.zzi();
                            return new zzat(zzb2.zzi());
                        }
                        throw new IllegalArgumentException("Illegal event name");
                    }
                    zzh.zzh("getTimestamp", 0, arrayList);
                    return new zzah(Double.valueOf(zzabVar.zzb.zzb));
                }
                zzh.zzh("getParams", 0, arrayList);
                HashMap hashMap2 = zzabVar.zzb.zzc;
                zzam zzamVar = new zzam();
                for (String str2 : hashMap2.keySet()) {
                    zzamVar.zzr(str2, zzi.zzb(hashMap2.get(str2)));
                }
                return zzamVar;
            }
            zzh.zzh("getParamValue", 1, arrayList);
            String zzi2 = zzgVar.zzb((zzap) arrayList.get(0)).zzi();
            HashMap hashMap3 = zzabVar.zzb.zzc;
            if (hashMap3.containsKey(zzi2)) {
                obj = hashMap3.get(zzi2);
            } else {
                obj = null;
            }
            return zzi.zzb(obj);
        }
        zzh.zzh("getEventName", 0, arrayList);
        return new zzat(zzabVar.zzb.zza);
    }
}
