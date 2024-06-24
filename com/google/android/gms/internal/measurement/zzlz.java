package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzlz {
    public static final Class zza;
    public static final zzmo zzb;
    public static final zzmo zzc;
    public static final zzmq zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzab(false);
        zzc = zzab(true);
        zzd = new zzmq();
    }

    public static void zzC(Object obj, int r7, zzkm zzkmVar, zzkj zzkjVar, zzmo zzmoVar) {
        if (zzkjVar == null) {
            return;
        }
        zzmp zzmpVar = null;
        if (zzkmVar instanceof RandomAccess) {
            int size = zzkmVar.size();
            int r3 = 0;
            for (int r2 = 0; r2 < size; r2++) {
                int intValue = ((Integer) zzkmVar.get(r2)).intValue();
                if (zzkjVar.zza(intValue)) {
                    if (r2 != r3) {
                        zzkmVar.set(r3, Integer.valueOf(intValue));
                    }
                    r3++;
                } else {
                    if (zzmpVar == null) {
                        zzmpVar = zzmoVar.zzc(obj);
                    }
                    zzmoVar.zzf(intValue, r7, zzmpVar);
                }
            }
            if (r3 != size) {
                zzkmVar.subList(r3, size).clear();
                return;
            }
            return;
        }
        Iterator it = zzkmVar.iterator();
        while (it.hasNext()) {
            int intValue2 = ((Integer) it.next()).intValue();
            if (!zzkjVar.zza(intValue2)) {
                if (zzmpVar == null) {
                    zzmpVar = zzmoVar.zzc(obj);
                }
                zzmoVar.zzf(intValue2, r7, zzmpVar);
                it.remove();
            }
        }
    }

    public static void zzH(int r2, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    ((Boolean) list.get(r22)).booleanValue();
                    r5++;
                }
                zzjmVar.zzq(r5);
                while (r0 < list.size()) {
                    zzjmVar.zzb(((Boolean) list.get(r0)).booleanValue() ? (byte) 1 : (byte) 0);
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzd(r2, ((Boolean) list.get(r0)).booleanValue());
                r0++;
            }
        }
    }

    public static void zzI(int r3, List list, zzjn zzjnVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.getClass();
            for (int r0 = 0; r0 < list.size(); r0++) {
                zzjnVar.zza.zze(r3, (zzje) list.get(r0));
            }
        }
    }

    public static void zzJ(int r3, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    ((Double) list.get(r32)).doubleValue();
                    r6 += 8;
                }
                zzjmVar.zzq(r6);
                while (r0 < list.size()) {
                    zzjmVar.zzi(Double.doubleToRawLongBits(((Double) list.get(r0)).doubleValue()));
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzh(r3, Double.doubleToRawLongBits(((Double) list.get(r0)).doubleValue()));
                r0++;
            }
        }
    }

    public static void zzK(int r2, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    r5 += zzjm.zzv(((Integer) list.get(r22)).intValue());
                }
                zzjmVar.zzq(r5);
                while (r0 < list.size()) {
                    zzjmVar.zzk(((Integer) list.get(r0)).intValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzj(r2, ((Integer) list.get(r0)).intValue());
                r0++;
            }
        }
    }

    public static void zzL(int r2, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    ((Integer) list.get(r22)).intValue();
                    r5 += 4;
                }
                zzjmVar.zzq(r5);
                while (r0 < list.size()) {
                    zzjmVar.zzg(((Integer) list.get(r0)).intValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzf(r2, ((Integer) list.get(r0)).intValue());
                r0++;
            }
        }
    }

    public static void zzM(int r3, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    ((Long) list.get(r32)).longValue();
                    r6 += 8;
                }
                zzjmVar.zzq(r6);
                while (r0 < list.size()) {
                    zzjmVar.zzi(((Long) list.get(r0)).longValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzh(r3, ((Long) list.get(r0)).longValue());
                r0++;
            }
        }
    }

    public static void zzN(int r2, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    ((Float) list.get(r22)).floatValue();
                    r5 += 4;
                }
                zzjmVar.zzq(r5);
                while (r0 < list.size()) {
                    zzjmVar.zzg(Float.floatToRawIntBits(((Float) list.get(r0)).floatValue()));
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzf(r2, Float.floatToRawIntBits(((Float) list.get(r0)).floatValue()));
                r0++;
            }
        }
    }

    public static void zzO(int r2, List list, zzjn zzjnVar, zzlx zzlxVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int r0 = 0; r0 < list.size(); r0++) {
                zzjnVar.zzq(r2, zzlxVar, list.get(r0));
            }
        }
    }

    public static void zzP(int r2, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    r5 += zzjm.zzv(((Integer) list.get(r22)).intValue());
                }
                zzjmVar.zzq(r5);
                while (r0 < list.size()) {
                    zzjmVar.zzk(((Integer) list.get(r0)).intValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzj(r2, ((Integer) list.get(r0)).intValue());
                r0++;
            }
        }
    }

    public static void zzQ(int r3, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    r6 += zzjm.zzB(((Long) list.get(r32)).longValue());
                }
                zzjmVar.zzq(r6);
                while (r0 < list.size()) {
                    zzjmVar.zzs(((Long) list.get(r0)).longValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzr(r3, ((Long) list.get(r0)).longValue());
                r0++;
            }
        }
    }

    public static void zzR(int r2, List list, zzjn zzjnVar, zzlx zzlxVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int r0 = 0; r0 < list.size(); r0++) {
                zzjnVar.zzv(r2, zzlxVar, list.get(r0));
            }
        }
    }

    public static void zzS(int r2, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    ((Integer) list.get(r22)).intValue();
                    r5 += 4;
                }
                zzjmVar.zzq(r5);
                while (r0 < list.size()) {
                    zzjmVar.zzg(((Integer) list.get(r0)).intValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzf(r2, ((Integer) list.get(r0)).intValue());
                r0++;
            }
        }
    }

    public static void zzT(int r3, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    ((Long) list.get(r32)).longValue();
                    r6 += 8;
                }
                zzjmVar.zzq(r6);
                while (r0 < list.size()) {
                    zzjmVar.zzi(((Long) list.get(r0)).longValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzh(r3, ((Long) list.get(r0)).longValue());
                r0++;
            }
        }
    }

    public static void zzU(int r3, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    int intValue = ((Integer) list.get(r32)).intValue();
                    r6 += zzjm.zzA((intValue >> 31) ^ (intValue + intValue));
                }
                zzjmVar.zzq(r6);
                while (r0 < list.size()) {
                    int intValue2 = ((Integer) list.get(r0)).intValue();
                    zzjmVar.zzq((intValue2 >> 31) ^ (intValue2 + intValue2));
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                int intValue3 = ((Integer) list.get(r0)).intValue();
                zzjmVar.zzp(r3, (intValue3 >> 31) ^ (intValue3 + intValue3));
                r0++;
            }
        }
    }

    public static void zzV(int r6, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r1 = 0;
            if (z) {
                zzjmVar.zzo(r6, 2);
                int r9 = 0;
                for (int r62 = 0; r62 < list.size(); r62++) {
                    long longValue = ((Long) list.get(r62)).longValue();
                    r9 += zzjm.zzB((longValue >> 63) ^ (longValue + longValue));
                }
                zzjmVar.zzq(r9);
                while (r1 < list.size()) {
                    long longValue2 = ((Long) list.get(r1)).longValue();
                    zzjmVar.zzs((longValue2 >> 63) ^ (longValue2 + longValue2));
                    r1++;
                }
                return;
            }
            while (r1 < list.size()) {
                long longValue3 = ((Long) list.get(r1)).longValue();
                zzjmVar.zzr(r6, (longValue3 >> 63) ^ (longValue3 + longValue3));
                r1++;
            }
        }
    }

    public static void zzW(int r4, List list, zzjn zzjnVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.getClass();
            boolean z = list instanceof zzku;
            int r1 = 0;
            zzjm zzjmVar = zzjnVar.zza;
            if (z) {
                zzku zzkuVar = (zzku) list;
                while (r1 < list.size()) {
                    Object zzf = zzkuVar.zzf(r1);
                    if (zzf instanceof String) {
                        zzjmVar.zzm(r4, (String) zzf);
                    } else {
                        zzjmVar.zze(r4, (zzje) zzf);
                    }
                    r1++;
                }
                return;
            }
            while (r1 < list.size()) {
                zzjmVar.zzm(r4, (String) list.get(r1));
                r1++;
            }
        }
    }

    public static void zzX(int r2, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    r5 += zzjm.zzA(((Integer) list.get(r22)).intValue());
                }
                zzjmVar.zzq(r5);
                while (r0 < list.size()) {
                    zzjmVar.zzq(((Integer) list.get(r0)).intValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzp(r2, ((Integer) list.get(r0)).intValue());
                r0++;
            }
        }
    }

    public static void zzY(int r3, List list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjm zzjmVar = zzjnVar.zza;
            int r0 = 0;
            if (z) {
                zzjmVar.zzo(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    r6 += zzjm.zzB(((Long) list.get(r32)).longValue());
                }
                zzjmVar.zzq(r6);
                while (r0 < list.size()) {
                    zzjmVar.zzs(((Long) list.get(r0)).longValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                zzjmVar.zzr(r3, ((Long) list.get(r0)).longValue());
                r0++;
            }
        }
    }

    public static boolean zzZ(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    public static int zza(int r0, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjm.zzA(r0 << 3) + 1) * size;
    }

    public static zzmo zzab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzmo) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int zzb(List list) {
        return list.size();
    }

    public static int zzc(int r3, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzjm.zzz(r3) * size;
        for (int r1 = 0; r1 < list.size(); r1++) {
            int zzd2 = ((zzje) list.get(r1)).zzd();
            zzz += zzjm.zzA(zzd2) + zzd2;
        }
        return zzz;
    }

    public static int zzd(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjm.zzz(r1) * size) + zze(list);
    }

    public static int zze(List list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            r2 = 0;
            while (r1 < size) {
                zzkgVar.zzj(r1);
                r2 += zzjm.zzv(zzkgVar.zzb[r1]);
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                r2 += zzjm.zzv(((Integer) list.get(r1)).intValue());
                r1++;
            }
        }
        return r2;
    }

    public static int zzf(int r0, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjm.zzA(r0 << 3) + 4) * size;
    }

    public static int zzg(List list) {
        return list.size() * 4;
    }

    public static int zzh(int r0, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjm.zzA(r0 << 3) + 8) * size;
    }

    public static int zzi(List list) {
        return list.size() * 8;
    }

    public static int zzj(int r4, List list, zzlx zzlxVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r2 = 0;
        for (int r1 = 0; r1 < size; r1++) {
            r2 += zzjm.zzu(r4, (zzlm) list.get(r1), zzlxVar);
        }
        return r2;
    }

    public static int zzk(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjm.zzz(r1) * size) + zzl(list);
    }

    public static int zzl(List list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            r2 = 0;
            while (r1 < size) {
                zzkgVar.zzj(r1);
                r2 += zzjm.zzv(zzkgVar.zzb[r1]);
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                r2 += zzjm.zzv(((Integer) list.get(r1)).intValue());
                r1++;
            }
        }
        return r2;
    }

    public static int zzm(int r1, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzjm.zzz(r1) * list.size()) + zzn(list);
    }

    public static int zzn(List list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            r2 = 0;
            while (r1 < size) {
                zzlbVar.zzi(r1);
                r2 += zzjm.zzB(zzlbVar.zzb[r1]);
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                r2 += zzjm.zzB(((Long) list.get(r1)).longValue());
                r1++;
            }
        }
        return r2;
    }

    public static int zzo(int r1, zzlx zzlxVar, Object obj) {
        int r2;
        if (obj instanceof zzks) {
            zzks zzksVar = (zzks) obj;
            int zzA = zzjm.zzA(r1 << 3);
            if (zzksVar.zzc != null) {
                r2 = ((zzjb) zzksVar.zzc).zza.length;
            } else if (zzksVar.zza != null) {
                r2 = zzksVar.zza.zzbw();
            } else {
                r2 = 0;
            }
            return zzjm.zzA(r2) + r2 + zzA;
        }
        int zzA2 = zzjm.zzA(r1 << 3);
        int zzbr = ((zzio) ((zzlm) obj)).zzbr(zzlxVar);
        return zzjm.zzA(zzbr) + zzbr + zzA2;
    }

    public static int zzp(int r5, List list, zzlx zzlxVar) {
        int zzbr;
        int zzA;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzjm.zzz(r5) * size;
        for (int r2 = 0; r2 < size; r2++) {
            Object obj = list.get(r2);
            if (obj instanceof zzks) {
                zzks zzksVar = (zzks) obj;
                if (zzksVar.zzc != null) {
                    zzbr = ((zzjb) zzksVar.zzc).zza.length;
                } else if (zzksVar.zza != null) {
                    zzbr = zzksVar.zza.zzbw();
                } else {
                    zzbr = 0;
                }
                zzA = zzjm.zzA(zzbr);
            } else {
                zzbr = ((zzio) ((zzlm) obj)).zzbr(zzlxVar);
                zzA = zzjm.zzA(zzbr);
            }
            zzz = zzA + zzbr + zzz;
        }
        return zzz;
    }

    public static int zzq(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjm.zzz(r1) * size) + zzr(list);
    }

    public static int zzr(List list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            r2 = 0;
            while (r1 < size) {
                zzkgVar.zzj(r1);
                int r3 = zzkgVar.zzb[r1];
                r2 += zzjm.zzA((r3 >> 31) ^ (r3 + r3));
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                int intValue = ((Integer) list.get(r1)).intValue();
                r2 += zzjm.zzA((intValue >> 31) ^ (intValue + intValue));
                r1++;
            }
        }
        return r2;
    }

    public static int zzs(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjm.zzz(r1) * size) + zzt(list);
    }

    public static int zzt(List list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            r2 = 0;
            while (r1 < size) {
                zzlbVar.zzi(r1);
                long j = zzlbVar.zzb[r1];
                r2 += zzjm.zzB((j >> 63) ^ (j + j));
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                long longValue = ((Long) list.get(r1)).longValue();
                r2 += zzjm.zzB((longValue >> 63) ^ (longValue + longValue));
                r1++;
            }
        }
        return r2;
    }

    public static int zzu(int r4, List list) {
        int zzy;
        int zzy2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzjm.zzz(r4) * size;
        if (list instanceof zzku) {
            zzku zzkuVar = (zzku) list;
            while (r1 < size) {
                Object zzf = zzkuVar.zzf(r1);
                if (zzf instanceof zzje) {
                    int zzd2 = ((zzje) zzf).zzd();
                    zzy2 = zzjm.zzA(zzd2) + zzd2;
                } else {
                    zzy2 = zzjm.zzy((String) zzf);
                }
                zzz += zzy2;
                r1++;
            }
        } else {
            while (r1 < size) {
                Object obj = list.get(r1);
                if (obj instanceof zzje) {
                    int zzd3 = ((zzje) obj).zzd();
                    zzy = zzjm.zzA(zzd3) + zzd3;
                } else {
                    zzy = zzjm.zzy((String) obj);
                }
                zzz += zzy;
                r1++;
            }
        }
        return zzz;
    }

    public static int zzv(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjm.zzz(r1) * size) + zzw(list);
    }

    public static int zzw(List list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            r2 = 0;
            while (r1 < size) {
                zzkgVar.zzj(r1);
                r2 += zzjm.zzA(zzkgVar.zzb[r1]);
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                r2 += zzjm.zzA(((Integer) list.get(r1)).intValue());
                r1++;
            }
        }
        return r2;
    }

    public static int zzx(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjm.zzz(r1) * size) + zzy(list);
    }

    public static int zzy(List list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            r2 = 0;
            while (r1 < size) {
                zzlbVar.zzi(r1);
                r2 += zzjm.zzB(zzlbVar.zzb[r1]);
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                r2 += zzjm.zzB(((Long) list.get(r1)).longValue());
                r1++;
            }
        }
        return r2;
    }
}
