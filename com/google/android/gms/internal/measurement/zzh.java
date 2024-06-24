package com.google.android.gms.internal.measurement;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzh {
    public static double zza(double d) {
        int r0;
        if (Double.isNaN(d)) {
            return 0.0d;
        }
        if (!Double.isInfinite(d) && d != 0.0d && d != 0.0d) {
            if (d > 0.0d) {
                r0 = 1;
            } else {
                r0 = -1;
            }
            return Math.floor(Math.abs(d)) * r0;
        }
        return d;
    }

    public static int zzb(double d) {
        int r0;
        if (!Double.isNaN(d) && !Double.isInfinite(d) && d != 0.0d) {
            if (d > 0.0d) {
                r0 = 1;
            } else {
                r0 = -1;
            }
            return (int) ((Math.floor(Math.abs(d)) * r0) % 4.294967296E9d);
        }
        return 0;
    }

    public static void zzc(zzg zzgVar) {
        int zzb = zzb(zzgVar.zzd("runtime.counter").zzh().doubleValue() + 1.0d);
        if (zzb <= 1000000) {
            zzgVar.zzg("runtime.counter", new zzah(Double.valueOf(zzb)));
            return;
        }
        throw new IllegalStateException("Instructions allowed exceeded");
    }

    public static long zzd(double d) {
        return zzb(d) & 4294967295L;
    }

    public static zzbl zze(String str) {
        zzbl zzblVar = null;
        if (str != null && !str.isEmpty()) {
            zzblVar = zzbl.zza(Integer.parseInt(str));
        }
        if (zzblVar != null) {
            return zzblVar;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", str));
    }

    public static Object zzf(zzap zzapVar) {
        boolean z;
        if (zzap.zzg.equals(zzapVar)) {
            return null;
        }
        if (zzap.zzf.equals(zzapVar)) {
            return "";
        }
        if (zzapVar instanceof zzam) {
            return zzg((zzam) zzapVar);
        }
        if (zzapVar instanceof zzae) {
            ArrayList arrayList = new ArrayList();
            zzae zzaeVar = (zzae) zzapVar;
            zzaeVar.getClass();
            int r2 = 0;
            while (true) {
                if (r2 < zzaeVar.zzc()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (r2 < zzaeVar.zzc()) {
                        int r3 = r2 + 1;
                        Object zzf = zzf(zzaeVar.zze(r2));
                        if (zzf != null) {
                            arrayList.add(zzf);
                        }
                        r2 = r3;
                    } else {
                        throw new NoSuchElementException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Out of bounds index: ", r2));
                    }
                } else {
                    return arrayList;
                }
            }
        } else {
            if (!zzapVar.zzh().isNaN()) {
                return zzapVar.zzh();
            }
            return zzapVar.zzi();
        }
    }

    public static HashMap zzg(zzam zzamVar) {
        HashMap hashMap = new HashMap();
        zzamVar.getClass();
        Iterator it = new ArrayList(zzamVar.zza.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object zzf = zzf(zzamVar.zzf(str));
            if (zzf != null) {
                hashMap.put(str, zzf);
            }
        }
        return hashMap;
    }

    public static void zzh(String str, int r2, List list) {
        if (list.size() == r2) {
        } else {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", str, Integer.valueOf(r2), Integer.valueOf(list.size())));
        }
    }

    public static void zzi(String str, int r2, List list) {
        if (list.size() >= r2) {
        } else {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", str, Integer.valueOf(r2), Integer.valueOf(list.size())));
        }
    }

    public static void zzj(String str, int r2, ArrayList arrayList) {
        if (arrayList.size() <= r2) {
        } else {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", str, Integer.valueOf(r2), Integer.valueOf(arrayList.size())));
        }
    }

    public static boolean zzk(zzap zzapVar) {
        if (zzapVar == null) {
            return false;
        }
        Double zzh = zzapVar.zzh();
        if (zzh.isNaN() || zzh.doubleValue() < 0.0d || !zzh.equals(Double.valueOf(Math.floor(zzh.doubleValue())))) {
            return false;
        }
        return true;
    }

    public static boolean zzl(zzap zzapVar, zzap zzapVar2) {
        if (!zzapVar.getClass().equals(zzapVar2.getClass())) {
            return false;
        }
        if ((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) {
            return true;
        }
        if (zzapVar instanceof zzah) {
            if (Double.isNaN(zzapVar.zzh().doubleValue()) || Double.isNaN(zzapVar2.zzh().doubleValue())) {
                return false;
            }
            return zzapVar.zzh().equals(zzapVar2.zzh());
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
}
