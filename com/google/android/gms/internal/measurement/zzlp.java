package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzlp<T> implements zzlx<T> {
    public static final int[] zza = new int[0];
    public static final Unsafe zzb = zzmy.zzg();
    public final int[] zzc;
    public final Object[] zzd;
    public final int zze;
    public final int zzf;
    public final zzlm zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int[] zzj;
    public final int zzk;
    public final int zzl;
    public final zzla zzm;
    public final zzmo zzn;
    public final zzjs zzo;

    public zzlp(int[] r1, Object[] objArr, int r3, int r4, zzlm zzlmVar, boolean z, int[] r7, int r8, int r9, zzla zzlaVar, zzmo zzmoVar, zzjs zzjsVar, zzlh zzlhVar) {
        this.zzc = r1;
        this.zzd = objArr;
        this.zze = r3;
        this.zzf = r4;
        this.zzi = z;
        this.zzh = zzjsVar != null && zzjsVar.zzc(zzlmVar);
        this.zzj = r7;
        this.zzk = r8;
        this.zzl = r9;
        this.zzm = zzlaVar;
        this.zzn = zzmoVar;
        this.zzo = zzjsVar;
        this.zzg = zzlmVar;
    }

    public static long zzC(long j, Object obj) {
        return ((Long) zzmy.zzf(j, obj)).longValue();
    }

    public static Field zzI(String str, Class cls) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static void zzJ(Object obj) {
        if (zzW(obj)) {
        } else {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    public static boolean zzW(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzkf) {
            return ((zzkf) obj).zzbO();
        }
        return true;
    }

    public static final void zzZ(int r1, Object obj, zzjn zzjnVar) throws IOException {
        if (obj instanceof String) {
            zzjnVar.zza.zzm(r1, (String) obj);
        } else {
            zzjnVar.zzd(r1, (zzje) obj);
        }
    }

    public static zzmp zzd(Object obj) {
        zzkf zzkfVar = (zzkf) obj;
        zzmp zzmpVar = zzkfVar.zzc;
        if (zzmpVar == zzmp.zza) {
            zzmp zzf = zzmp.zzf();
            zzkfVar.zzc = zzf;
            return zzf;
        }
        return zzmpVar;
    }

    public static zzlp zzl(zzlj zzljVar, zzla zzlaVar, zzmo zzmoVar, zzjs zzjsVar, zzlh zzlhVar) {
        if (zzljVar instanceof zzlw) {
            return zzm((zzlw) zzljVar, zzlaVar, zzmoVar, zzjsVar, zzlhVar);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0263  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.measurement.zzlp zzm(com.google.android.gms.internal.measurement.zzlw r33, com.google.android.gms.internal.measurement.zzla r34, com.google.android.gms.internal.measurement.zzmo r35, com.google.android.gms.internal.measurement.zzjs r36, com.google.android.gms.internal.measurement.zzlh r37) {
        /*
            Method dump skipped, instructions count: 999
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzm(com.google.android.gms.internal.measurement.zzlw, com.google.android.gms.internal.measurement.zzla, com.google.android.gms.internal.measurement.zzmo, com.google.android.gms.internal.measurement.zzjs, com.google.android.gms.internal.measurement.zzlh):com.google.android.gms.internal.measurement.zzlp");
    }

    public static int zzr(long j, Object obj) {
        return ((Integer) zzmy.zzf(j, obj)).intValue();
    }

    public final int zzB(int r2) {
        return this.zzc[r2 + 1];
    }

    public final zzlx zzE(int r4) {
        int r42 = r4 / 3;
        int r43 = r42 + r42;
        Object[] objArr = this.zzd;
        zzlx zzlxVar = (zzlx) objArr[r43];
        if (zzlxVar != null) {
            return zzlxVar;
        }
        zzlx zzb2 = zzlu.zza.zzb((Class) objArr[r43 + 1]);
        objArr[r43] = zzb2;
        return zzb2;
    }

    public final Object zzF(int r2) {
        int r22 = r2 / 3;
        return this.zzd[r22 + r22];
    }

    public final Object zzG(int r4, Object obj) {
        zzlx zzE = zzE(r4);
        long zzB = zzB(r4) & 1048575;
        if (!zzT(r4, obj)) {
            return zzE.zze();
        }
        Object object = zzb.getObject(obj, zzB);
        if (zzW(object)) {
            return object;
        }
        zzkf zze = zzE.zze();
        if (object != null) {
            zzE.zzg(zze, object);
        }
        return zze;
    }

    public final Object zzH(int r3, int r4, Object obj) {
        zzlx zzE = zzE(r4);
        if (!zzX(r3, r4, obj)) {
            return zzE.zze();
        }
        Object object = zzb.getObject(obj, zzB(r4) & 1048575);
        if (zzW(object)) {
            return object;
        }
        zzkf zze = zzE.zze();
        if (object != null) {
            zzE.zzg(zze, object);
        }
        return zze;
    }

    public final void zzK(Object obj, int r7, Object obj2) {
        if (!zzT(r7, obj2)) {
            return;
        }
        long zzB = zzB(r7) & 1048575;
        Unsafe unsafe = zzb;
        Object object = unsafe.getObject(obj2, zzB);
        if (object != null) {
            zzlx zzE = zzE(r7);
            if (!zzT(r7, obj)) {
                if (!zzW(object)) {
                    unsafe.putObject(obj, zzB, object);
                } else {
                    zzkf zze = zzE.zze();
                    zzE.zzg(zze, object);
                    unsafe.putObject(obj, zzB, zze);
                }
                zzM(r7, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzB);
            if (!zzW(object2)) {
                zzkf zze2 = zzE.zze();
                zzE.zzg(zze2, object2);
                unsafe.putObject(obj, zzB, zze2);
                object2 = zze2;
            }
            zzE.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[r7] + " is present but null: " + obj2.toString());
    }

    public final void zzL(Object obj, int r8, Object obj2) {
        int[] r0 = this.zzc;
        int r1 = r0[r8];
        if (!zzX(r1, r8, obj2)) {
            return;
        }
        long zzB = zzB(r8) & 1048575;
        Unsafe unsafe = zzb;
        Object object = unsafe.getObject(obj2, zzB);
        if (object != null) {
            zzlx zzE = zzE(r8);
            if (!zzX(r1, r8, obj)) {
                if (!zzW(object)) {
                    unsafe.putObject(obj, zzB, object);
                } else {
                    zzkf zze = zzE.zze();
                    zzE.zzg(zze, object);
                    unsafe.putObject(obj, zzB, zze);
                }
                zzN(r1, r8, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzB);
            if (!zzW(object2)) {
                zzkf zze2 = zzE.zze();
                zzE.zzg(zze2, object2);
                unsafe.putObject(obj, zzB, zze2);
                object2 = zze2;
            }
            zzE.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + r0[r8] + " is present but null: " + obj2.toString());
    }

    public final void zzM(int r5, Object obj) {
        int r52 = this.zzc[r5 + 2];
        long j = 1048575 & r52;
        if (j == 1048575) {
            return;
        }
        zzmy.zzq(j, (1 << (r52 >>> 20)) | zzmy.zzc(j, obj), obj);
    }

    public final void zzN(int r3, int r4, Object obj) {
        zzmy.zzq(this.zzc[r4 + 2] & 1048575, r3, obj);
    }

    public final void zzO(Object obj, int r5, Object obj2) {
        zzb.putObject(obj, zzB(r5) & 1048575, obj2);
        zzM(r5, obj);
    }

    public final void zzP(int r4, int r5, Object obj, Object obj2) {
        zzb.putObject(obj, zzB(r5) & 1048575, obj2);
        zzN(r4, r5, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x003e. Please report as an issue. */
    public final void zzQ(Object obj, zzjn zzjnVar) throws IOException {
        int r4;
        if (!this.zzh) {
            int[] r3 = this.zzc;
            int length = r3.length;
            int r6 = 1048575;
            int r9 = 1048575;
            int r8 = 0;
            int r10 = 0;
            while (r8 < length) {
                int zzB = zzB(r8);
                int r12 = r3[r8];
                int r13 = (zzB >>> 20) & 255;
                Unsafe unsafe = zzb;
                if (r13 <= 17) {
                    int r14 = r3[r8 + 2];
                    int r42 = r14 & r6;
                    if (r42 != r9) {
                        r10 = unsafe.getInt(obj, r42);
                        r9 = r42;
                    }
                    r4 = 1 << (r14 >>> 20);
                } else {
                    r4 = 0;
                }
                long j = zzB & r6;
                switch (r13) {
                    case 0:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzf(r12, zzmy.zza(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 1:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzo(zzmy.zzb(j, obj), r12);
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 2:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzt(r12, unsafe.getLong(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 3:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzJ(r12, unsafe.getLong(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 4:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzr(r12, unsafe.getInt(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 5:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzm(r12, unsafe.getLong(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 6:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzk(r12, unsafe.getInt(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 7:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzb(r12, zzmy.zzw(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 8:
                        if ((r4 & r10) != 0) {
                            zzZ(r12, unsafe.getObject(obj, j), zzjnVar);
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 9:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzv(r12, zzE(r8), unsafe.getObject(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 10:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzd(r12, (zzje) unsafe.getObject(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 11:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzH(r12, unsafe.getInt(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 12:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzi(r12, unsafe.getInt(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 13:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzw(r12, unsafe.getInt(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 14:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzy(r12, unsafe.getLong(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 15:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzA(r12, unsafe.getInt(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 16:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzC(r12, unsafe.getLong(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 17:
                        if ((r4 & r10) != 0) {
                            zzjnVar.zzq(r12, zzE(r8), unsafe.getObject(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 18:
                        zzlz.zzJ(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 19:
                        zzlz.zzN(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 20:
                        zzlz.zzQ(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 21:
                        zzlz.zzY(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 22:
                        zzlz.zzP(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 23:
                        zzlz.zzM(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 24:
                        zzlz.zzL(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 25:
                        zzlz.zzH(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 26:
                        zzlz.zzW(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar);
                        r8 += 3;
                        r6 = 1048575;
                    case 27:
                        zzlz.zzR(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, zzE(r8));
                        r8 += 3;
                        r6 = 1048575;
                    case 28:
                        zzlz.zzI(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar);
                        r8 += 3;
                        r6 = 1048575;
                    case 29:
                        zzlz.zzX(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 30:
                        zzlz.zzK(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 31:
                        zzlz.zzS(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 32:
                        zzlz.zzT(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 33:
                        zzlz.zzU(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 34:
                        zzlz.zzV(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, false);
                        r8 += 3;
                        r6 = 1048575;
                    case 35:
                        zzlz.zzJ(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 36:
                        zzlz.zzN(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 37:
                        zzlz.zzQ(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 38:
                        zzlz.zzY(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 39:
                        zzlz.zzP(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 40:
                        zzlz.zzM(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 41:
                        zzlz.zzL(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 42:
                        zzlz.zzH(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 43:
                        zzlz.zzX(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 44:
                        zzlz.zzK(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 45:
                        zzlz.zzS(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 46:
                        zzlz.zzT(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 47:
                        zzlz.zzU(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 48:
                        zzlz.zzV(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, true);
                        r8 += 3;
                        r6 = 1048575;
                    case 49:
                        zzlz.zzO(r3[r8], (List) unsafe.getObject(obj, j), zzjnVar, zzE(r8));
                        r8 += 3;
                        r6 = 1048575;
                    case 50:
                        if (unsafe.getObject(obj, j) != null) {
                            throw null;
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 51:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzf(r12, ((Double) zzmy.zzf(j, obj)).doubleValue());
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 52:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzo(((Float) zzmy.zzf(j, obj)).floatValue(), r12);
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 53:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzt(r12, zzC(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 54:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzJ(r12, zzC(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 55:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzr(r12, zzr(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 56:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzm(r12, zzC(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 57:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzk(r12, zzr(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 58:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzb(r12, ((Boolean) zzmy.zzf(j, obj)).booleanValue());
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 59:
                        if (zzX(r12, r8, obj)) {
                            zzZ(r12, unsafe.getObject(obj, j), zzjnVar);
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 60:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzv(r12, zzE(r8), unsafe.getObject(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 61:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzd(r12, (zzje) unsafe.getObject(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 62:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzH(r12, zzr(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 63:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzi(r12, zzr(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 64:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzw(r12, zzr(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 65:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzy(r12, zzC(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 66:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzA(r12, zzr(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 67:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzC(r12, zzC(j, obj));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    case 68:
                        if (zzX(r12, r8, obj)) {
                            zzjnVar.zzq(r12, zzE(r8), unsafe.getObject(obj, j));
                        }
                        r8 += 3;
                        r6 = 1048575;
                    default:
                        r8 += 3;
                        r6 = 1048575;
                }
            }
            zzmo zzmoVar = this.zzn;
            zzmoVar.zzi(zzmoVar.zzd(obj), zzjnVar);
            return;
        }
        this.zzo.zza(obj);
        throw null;
    }

    public final boolean zzS(Object obj, int r2, Object obj2) {
        if (zzT(r2, obj) == zzT(r2, obj2)) {
            return true;
        }
        return false;
    }

    public final boolean zzT(int r8, Object obj) {
        int r0 = this.zzc[r8 + 2];
        long j = r0 & 1048575;
        if (j == 1048575) {
            int zzB = zzB(r8);
            long j2 = zzB & 1048575;
            switch ((zzB >>> 20) & 255) {
                case 0:
                    if (Double.doubleToRawLongBits(zzmy.zza(j2, obj)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzmy.zzb(j2, obj)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzmy.zzd(j2, obj) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzmy.zzd(j2, obj) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzmy.zzc(j2, obj) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzmy.zzd(j2, obj) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzmy.zzc(j2, obj) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzmy.zzw(j2, obj);
                case 8:
                    Object zzf = zzmy.zzf(j2, obj);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    }
                    if (zzf instanceof zzje) {
                        if (zzje.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (zzmy.zzf(j2, obj) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzje.zzb.equals(zzmy.zzf(j2, obj))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzmy.zzc(j2, obj) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzmy.zzc(j2, obj) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzmy.zzc(j2, obj) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzmy.zzd(j2, obj) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzmy.zzc(j2, obj) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzmy.zzd(j2, obj) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzmy.zzf(j2, obj) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zzmy.zzc(j, obj) & (1 << (r0 >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    public final boolean zzX(int r3, int r4, Object obj) {
        if (zzmy.zzc(this.zzc[r4 + 2] & 1048575, obj) == r3) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final int zza(Object obj) {
        if (this.zzi) {
            return zzq(obj);
        }
        return zzp(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f1, code lost:            if (r4 != false) goto L85;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d9, code lost:            if (r4 != false) goto L85;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01f4, code lost:            r8 = 1237;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01f5, code lost:            r4 = r8;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001a. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzlx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzb(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 748
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzb(java.lang.Object):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:197:0x03a0, code lost:            if (r0 != r3) goto L134;     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0415, code lost:            r6 = r39;        r2 = r0;        r7 = r16;        r10 = r25;     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0403, code lost:            r11 = r35;        r1 = r39;        r8 = r40;        r7 = r16;        r5 = r19;        r6 = r20;        r9 = r21;        r3 = r25;     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0401, code lost:            if (r0 != r14) goto L134;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0495, code lost:            if (r5 == 1048575) goto L157;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0497, code lost:            r31.putInt(r11, r5, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x049d, code lost:            r3 = r15.zzk;     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x04a1, code lost:            if (r3 >= r15.zzl) goto L219;     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x04a3, code lost:            r5 = r15.zzj[r3];        r6 = r26[r5];        r6 = com.google.android.gms.internal.measurement.zzmy.zzf(r15.zzB(r5) & 1048575, r11);     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x04b3, code lost:            if (r6 != null) goto L163;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x04b6, code lost:            r7 = r5 / 3;     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x04bf, code lost:            if (((com.google.android.gms.internal.measurement.zzkj) r22[(r7 + r7) + 1]) != null) goto L220;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x04c4, code lost:            r6 = (com.google.android.gms.internal.measurement.zzlg) r6;        r0 = (com.google.android.gms.internal.measurement.zzlf) r15.zzF(r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x04cc, code lost:            throw null;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x04c1, code lost:            r3 = r3 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x04cd, code lost:            if (r1 != 0) goto L174;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x04d1, code lost:            if (r0 != r38) goto L172;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x04d8, code lost:            throw com.google.android.gms.internal.measurement.zzkp.zze();     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x04df, code lost:            return r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x04db, code lost:            if (r0 > r38) goto L178;     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x04dd, code lost:            if (r4 != r1) goto L178;     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x04e4, code lost:            throw com.google.android.gms.internal.measurement.zzkp.zze();     */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x00b2. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.measurement.zzir r40) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzir):int");
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final zzkf zze() {
        return (zzkf) ((zzkf) this.zzg).zzl(4);
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzf(Object obj) {
        if (!zzW(obj)) {
            return;
        }
        if (obj instanceof zzkf) {
            zzkf zzkfVar = (zzkf) obj;
            zzkfVar.zzbM();
            zzkfVar.zzb = 0;
            zzkfVar.zzbK();
        }
        int length = this.zzc.length;
        for (int r1 = 0; r1 < length; r1 += 3) {
            int zzB = zzB(r1);
            long j = 1048575 & zzB;
            int r2 = (zzB >>> 20) & 255;
            Unsafe unsafe = zzb;
            if (r2 != 9) {
                switch (r2) {
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzm.zza(j, obj);
                        break;
                    case 50:
                        Object object = unsafe.getObject(obj, j);
                        if (object != null) {
                            ((zzlg) object).zzc();
                            unsafe.putObject(obj, j, object);
                            break;
                        } else {
                            break;
                        }
                }
            }
            if (zzT(r1, obj)) {
                zzE(r1).zzf(unsafe.getObject(obj, j));
            }
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zzb(obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzg(Object obj, Object obj2) {
        zzJ(obj);
        obj2.getClass();
        int r0 = 0;
        while (true) {
            int[] r1 = this.zzc;
            if (r0 < r1.length) {
                int zzB = zzB(r0);
                long j = 1048575 & zzB;
                int r12 = r1[r0];
                switch ((zzB >>> 20) & 255) {
                    case 0:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzo(obj, j, zzmy.zza(j, obj2));
                            zzM(r0, obj);
                            break;
                        }
                    case 1:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzp(obj, j, zzmy.zzb(j, obj2));
                            zzM(r0, obj);
                            break;
                        }
                    case 2:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzf.zzo(obj, j, zzmy.zzd(j, obj2));
                            zzM(r0, obj);
                            break;
                        }
                    case 3:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzf.zzo(obj, j, zzmy.zzd(j, obj2));
                            zzM(r0, obj);
                            break;
                        }
                    case 4:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzq(j, zzmy.zzc(j, obj2), obj);
                            zzM(r0, obj);
                            break;
                        }
                    case 5:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzf.zzo(obj, j, zzmy.zzd(j, obj2));
                            zzM(r0, obj);
                            break;
                        }
                    case 6:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzq(j, zzmy.zzc(j, obj2), obj);
                            zzM(r0, obj);
                            break;
                        }
                    case 7:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzm(obj, j, zzmy.zzw(j, obj2));
                            zzM(r0, obj);
                            break;
                        }
                    case 8:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzs(j, obj, zzmy.zzf(j, obj2));
                            zzM(r0, obj);
                            break;
                        }
                    case 9:
                        zzK(obj, r0, obj2);
                        break;
                    case 10:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzs(j, obj, zzmy.zzf(j, obj2));
                            zzM(r0, obj);
                            break;
                        }
                    case 11:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzq(j, zzmy.zzc(j, obj2), obj);
                            zzM(r0, obj);
                            break;
                        }
                    case 12:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzq(j, zzmy.zzc(j, obj2), obj);
                            zzM(r0, obj);
                            break;
                        }
                    case 13:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzq(j, zzmy.zzc(j, obj2), obj);
                            zzM(r0, obj);
                            break;
                        }
                    case 14:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzf.zzo(obj, j, zzmy.zzd(j, obj2));
                            zzM(r0, obj);
                            break;
                        }
                    case 15:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzq(j, zzmy.zzc(j, obj2), obj);
                            zzM(r0, obj);
                            break;
                        }
                    case 16:
                        if (!zzT(r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzf.zzo(obj, j, zzmy.zzd(j, obj2));
                            zzM(r0, obj);
                            break;
                        }
                    case 17:
                        zzK(obj, r0, obj2);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzm.zzb(j, obj, obj2);
                        break;
                    case 50:
                        Class cls = zzlz.zza;
                        zzmy.zzs(j, obj, zzlh.zzb(zzmy.zzf(j, obj), zzmy.zzf(j, obj2)));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zzX(r12, r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzs(j, obj, zzmy.zzf(j, obj2));
                            zzN(r12, r0, obj);
                            break;
                        }
                    case 60:
                        zzL(obj, r0, obj2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zzX(r12, r0, obj2)) {
                            break;
                        } else {
                            zzmy.zzs(j, obj, zzmy.zzf(j, obj2));
                            zzN(r12, r0, obj);
                            break;
                        }
                    case 68:
                        zzL(obj, r0, obj2);
                        break;
                }
                r0 += 3;
            } else {
                Class cls2 = zzlz.zza;
                zzmo zzmoVar = this.zzn;
                zzmoVar.zzh(obj, zzmoVar.zze(zzmoVar.zzd(obj), zzmoVar.zzd(obj2)));
                if (!this.zzh) {
                    return;
                }
                this.zzo.zza(obj2);
                throw null;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzh(Object obj, byte[] bArr, int r11, int r12, zzir zzirVar) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, r11, r12, zzirVar);
        } else {
            zzc(obj, bArr, r11, r12, 0, zzirVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzi(Object obj, zzjn zzjnVar) throws IOException {
        if (this.zzi) {
            if (!this.zzh) {
                int[] r0 = this.zzc;
                int length = r0.length;
                for (int r4 = 0; r4 < length; r4 += 3) {
                    int zzB = zzB(r4);
                    int r6 = r0[r4];
                    switch ((zzB >>> 20) & 255) {
                        case 0:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzf(r6, zzmy.zza(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzo(zzmy.zzb(zzB & 1048575, obj), r6);
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzt(r6, zzmy.zzd(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzJ(r6, zzmy.zzd(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzr(r6, zzmy.zzc(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzm(r6, zzmy.zzd(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzk(r6, zzmy.zzc(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzb(r6, zzmy.zzw(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (zzT(r4, obj)) {
                                zzZ(r6, zzmy.zzf(zzB & 1048575, obj), zzjnVar);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzv(r6, zzE(r4), zzmy.zzf(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzd(r6, (zzje) zzmy.zzf(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzH(r6, zzmy.zzc(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzi(r6, zzmy.zzc(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzw(r6, zzmy.zzc(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzy(r6, zzmy.zzd(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzA(r6, zzmy.zzc(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzC(r6, zzmy.zzd(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (zzT(r4, obj)) {
                                zzjnVar.zzq(r6, zzE(r4), zzmy.zzf(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            zzlz.zzJ(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 19:
                            zzlz.zzN(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 20:
                            zzlz.zzQ(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 21:
                            zzlz.zzY(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 22:
                            zzlz.zzP(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 23:
                            zzlz.zzM(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 24:
                            zzlz.zzL(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 25:
                            zzlz.zzH(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 26:
                            zzlz.zzW(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar);
                            break;
                        case 27:
                            zzlz.zzR(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, zzE(r4));
                            break;
                        case 28:
                            zzlz.zzI(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar);
                            break;
                        case 29:
                            zzlz.zzX(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 30:
                            zzlz.zzK(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 31:
                            zzlz.zzS(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 32:
                            zzlz.zzT(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 33:
                            zzlz.zzU(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 34:
                            zzlz.zzV(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, false);
                            break;
                        case 35:
                            zzlz.zzJ(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 36:
                            zzlz.zzN(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 37:
                            zzlz.zzQ(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 38:
                            zzlz.zzY(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 39:
                            zzlz.zzP(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 40:
                            zzlz.zzM(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 41:
                            zzlz.zzL(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 42:
                            zzlz.zzH(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 43:
                            zzlz.zzX(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 44:
                            zzlz.zzK(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 45:
                            zzlz.zzS(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 46:
                            zzlz.zzT(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 47:
                            zzlz.zzU(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 48:
                            zzlz.zzV(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, true);
                            break;
                        case 49:
                            zzlz.zzO(r6, (List) zzmy.zzf(zzB & 1048575, obj), zzjnVar, zzE(r4));
                            break;
                        case 50:
                            if (zzmy.zzf(zzB & 1048575, obj) != null) {
                                throw null;
                            }
                            break;
                        case 51:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzf(r6, ((Double) zzmy.zzf(zzB & 1048575, obj)).doubleValue());
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzo(((Float) zzmy.zzf(zzB & 1048575, obj)).floatValue(), r6);
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzt(r6, zzC(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzJ(r6, zzC(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzr(r6, zzr(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzm(r6, zzC(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzk(r6, zzr(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzb(r6, ((Boolean) zzmy.zzf(zzB & 1048575, obj)).booleanValue());
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (zzX(r6, r4, obj)) {
                                zzZ(r6, zzmy.zzf(zzB & 1048575, obj), zzjnVar);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzv(r6, zzE(r4), zzmy.zzf(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzd(r6, (zzje) zzmy.zzf(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzH(r6, zzr(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzi(r6, zzr(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzw(r6, zzr(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzy(r6, zzC(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzA(r6, zzr(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzC(r6, zzC(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (zzX(r6, r4, obj)) {
                                zzjnVar.zzq(r6, zzE(r4), zzmy.zzf(zzB & 1048575, obj));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                zzmo zzmoVar = this.zzn;
                zzmoVar.zzi(zzmoVar.zzd(obj), zzjnVar);
                return;
            }
            this.zzo.zza(obj);
            throw null;
        }
        zzQ(obj, zzjnVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c3 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzlx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzj(java.lang.Object r10, java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzj(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zzk(Object obj) {
        boolean z;
        int r3 = 1048575;
        int r2 = 0;
        int r4 = 0;
        while (true) {
            boolean z2 = true;
            if (r2 < this.zzk) {
                int r6 = this.zzj[r2];
                int[] r8 = this.zzc;
                int r9 = r8[r6];
                int zzB = zzB(r6);
                int r82 = r8[r6 + 2];
                int r11 = r82 & 1048575;
                int r83 = 1 << (r82 >>> 20);
                if (r11 != r3) {
                    if (r11 != 1048575) {
                        r4 = zzb.getInt(obj, r11);
                    }
                    r3 = r11;
                }
                if ((268435456 & zzB) != 0) {
                    if (r3 == 1048575) {
                        z = zzT(r6, obj);
                    } else if ((r4 & r83) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return false;
                    }
                }
                int r112 = (zzB >>> 20) & 255;
                if (r112 != 9 && r112 != 17) {
                    if (r112 != 27) {
                        if (r112 != 60 && r112 != 68) {
                            if (r112 != 49) {
                                if (r112 == 50 && !((zzlg) zzmy.zzf(zzB & 1048575, obj)).isEmpty()) {
                                    throw null;
                                }
                            }
                        } else if (zzX(r9, r6, obj) && !zzE(r6).zzk(zzmy.zzf(zzB & 1048575, obj))) {
                            return false;
                        }
                    }
                    List list = (List) zzmy.zzf(zzB & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        zzlx zzE = zzE(r6);
                        for (int r7 = 0; r7 < list.size(); r7++) {
                            if (!zzE.zzk(list.get(r7))) {
                                return false;
                            }
                        }
                    }
                } else {
                    if (r3 == 1048575) {
                        z2 = zzT(r6, obj);
                    } else if ((r4 & r83) == 0) {
                        z2 = false;
                    }
                    if (z2 && !zzE(r6).zzk(zzmy.zzf(zzB & 1048575, obj))) {
                        return false;
                    }
                }
                r2++;
            } else {
                if (!this.zzh) {
                    return true;
                }
                this.zzo.zza(obj);
                throw null;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0038. Please report as an issue. */
    public final int zzp(Object obj) {
        int r8;
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzv;
        int zzA5;
        int zzA6;
        int zzd;
        int zzA7;
        int zzo;
        int zzi;
        int zzz;
        int zzA8;
        int r82;
        int zzA9;
        int zzd2;
        int zzA10;
        int r2 = 1048575;
        int r6 = 1048575;
        int r4 = 0;
        int r5 = 0;
        int r7 = 0;
        while (true) {
            int[] r83 = this.zzc;
            if (r4 < r83.length) {
                int zzB2 = zzB(r4);
                int r10 = r83[r4];
                int r11 = (zzB2 >>> 20) & 255;
                Unsafe unsafe = zzb;
                if (r11 <= 17) {
                    int r84 = r83[r4 + 2];
                    int r12 = r84 & r2;
                    r8 = 1 << (r84 >>> 20);
                    if (r12 != r6) {
                        r7 = unsafe.getInt(obj, r12);
                        r6 = r12;
                    }
                } else {
                    r8 = 0;
                }
                long j = zzB2 & r2;
                switch (r11) {
                    case 0:
                        if ((r7 & r8) == 0) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r10 << 3);
                            zzo = zzA + 8;
                            r5 += zzo;
                            break;
                        }
                    case 1:
                        if ((r7 & r8) == 0) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r10 << 3);
                            zzo = zzA2 + 4;
                            r5 += zzo;
                            break;
                        }
                    case 2:
                        if ((r8 & r7) == 0) {
                            break;
                        } else {
                            long j2 = unsafe.getLong(obj, j);
                            zzA3 = zzjm.zzA(r10 << 3);
                            zzB = zzjm.zzB(j2);
                            zzo = zzB + zzA3;
                            r5 += zzo;
                            break;
                        }
                    case 3:
                        if ((r8 & r7) == 0) {
                            break;
                        } else {
                            long j3 = unsafe.getLong(obj, j);
                            zzA3 = zzjm.zzA(r10 << 3);
                            zzB = zzjm.zzB(j3);
                            zzo = zzB + zzA3;
                            r5 += zzo;
                            break;
                        }
                    case 4:
                        if ((r8 & r7) == 0) {
                            break;
                        } else {
                            int r22 = unsafe.getInt(obj, j);
                            zzA4 = zzjm.zzA(r10 << 3);
                            zzv = zzjm.zzv(r22);
                            zzo = zzv + zzA4;
                            r5 += zzo;
                            break;
                        }
                    case 5:
                        if ((r7 & r8) == 0) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r10 << 3);
                            zzo = zzA + 8;
                            r5 += zzo;
                            break;
                        }
                    case 6:
                        if ((r7 & r8) == 0) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r10 << 3);
                            zzo = zzA2 + 4;
                            r5 += zzo;
                            break;
                        }
                    case 7:
                        if ((r7 & r8) == 0) {
                            break;
                        } else {
                            zzA5 = zzjm.zzA(r10 << 3);
                            zzo = zzA5 + 1;
                            r5 += zzo;
                            break;
                        }
                    case 8:
                        if ((r8 & r7) == 0) {
                            break;
                        } else {
                            Object object = unsafe.getObject(obj, j);
                            if (object instanceof zzje) {
                                zzA6 = zzjm.zzA(r10 << 3);
                                zzd = ((zzje) object).zzd();
                                zzA7 = zzjm.zzA(zzd);
                                r5 += zzA7 + zzd + zzA6;
                                break;
                            } else {
                                zzA4 = zzjm.zzA(r10 << 3);
                                zzv = zzjm.zzy((String) object);
                                zzo = zzv + zzA4;
                                r5 += zzo;
                                break;
                            }
                        }
                    case 9:
                        if ((r8 & r7) == 0) {
                            break;
                        } else {
                            zzo = zzlz.zzo(r10, zzE(r4), unsafe.getObject(obj, j));
                            r5 += zzo;
                            break;
                        }
                    case 10:
                        if ((r8 & r7) == 0) {
                            break;
                        } else {
                            zzje zzjeVar = (zzje) unsafe.getObject(obj, j);
                            zzA6 = zzjm.zzA(r10 << 3);
                            zzd = zzjeVar.zzd();
                            zzA7 = zzjm.zzA(zzd);
                            r5 += zzA7 + zzd + zzA6;
                            break;
                        }
                    case 11:
                        if ((r8 & r7) == 0) {
                            break;
                        } else {
                            int r23 = unsafe.getInt(obj, j);
                            zzA4 = zzjm.zzA(r10 << 3);
                            zzv = zzjm.zzA(r23);
                            zzo = zzv + zzA4;
                            r5 += zzo;
                            break;
                        }
                    case 12:
                        if ((r8 & r7) == 0) {
                            break;
                        } else {
                            int r24 = unsafe.getInt(obj, j);
                            zzA4 = zzjm.zzA(r10 << 3);
                            zzv = zzjm.zzv(r24);
                            zzo = zzv + zzA4;
                            r5 += zzo;
                            break;
                        }
                    case 13:
                        if ((r7 & r8) == 0) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r10 << 3);
                            zzo = zzA2 + 4;
                            r5 += zzo;
                            break;
                        }
                    case 14:
                        if ((r7 & r8) == 0) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r10 << 3);
                            zzo = zzA + 8;
                            r5 += zzo;
                            break;
                        }
                    case 15:
                        if ((r8 & r7) == 0) {
                            break;
                        } else {
                            int r25 = unsafe.getInt(obj, j);
                            zzA4 = zzjm.zzA(r10 << 3);
                            zzv = zzjm.zzA((r25 >> 31) ^ (r25 + r25));
                            zzo = zzv + zzA4;
                            r5 += zzo;
                            break;
                        }
                    case 16:
                        if ((r8 & r7) == 0) {
                            break;
                        } else {
                            long j4 = unsafe.getLong(obj, j);
                            zzA3 = zzjm.zzA(r10 << 3);
                            zzB = zzjm.zzB((j4 >> 63) ^ (j4 + j4));
                            zzo = zzB + zzA3;
                            r5 += zzo;
                            break;
                        }
                    case 17:
                        if ((r8 & r7) == 0) {
                            break;
                        } else {
                            zzo = zzjm.zzu(r10, (zzlm) unsafe.getObject(obj, j), zzE(r4));
                            r5 += zzo;
                            break;
                        }
                    case 18:
                        zzo = zzlz.zzh(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 19:
                        zzo = zzlz.zzf(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 20:
                        zzo = zzlz.zzm(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 21:
                        zzo = zzlz.zzx(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 22:
                        zzo = zzlz.zzk(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 23:
                        zzo = zzlz.zzh(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 24:
                        zzo = zzlz.zzf(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 25:
                        zzo = zzlz.zza(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 26:
                        zzo = zzlz.zzu(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 27:
                        zzo = zzlz.zzp(r10, (List) unsafe.getObject(obj, j), zzE(r4));
                        r5 += zzo;
                        break;
                    case 28:
                        zzo = zzlz.zzc(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 29:
                        zzo = zzlz.zzv(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 30:
                        zzo = zzlz.zzd(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 31:
                        zzo = zzlz.zzf(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 32:
                        zzo = zzlz.zzh(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 33:
                        zzo = zzlz.zzq(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 34:
                        zzo = zzlz.zzs(r10, (List) unsafe.getObject(obj, j));
                        r5 += zzo;
                        break;
                    case 35:
                        zzi = zzlz.zzi((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 36:
                        zzi = zzlz.zzg((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 37:
                        zzi = zzlz.zzn((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 38:
                        zzi = zzlz.zzy((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 39:
                        zzi = zzlz.zzl((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 40:
                        zzi = zzlz.zzi((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 41:
                        zzi = zzlz.zzg((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 42:
                        zzi = zzlz.zzb((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 43:
                        zzi = zzlz.zzw((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 44:
                        zzi = zzlz.zze((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 45:
                        zzi = zzlz.zzg((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 46:
                        zzi = zzlz.zzi((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 47:
                        zzi = zzlz.zzr((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 48:
                        zzi = zzlz.zzt((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r10);
                            zzA8 = zzjm.zzA(zzi);
                            r82 = zzA8 + zzz + zzi;
                            r5 += r82;
                            break;
                        }
                    case 49:
                        zzo = zzlz.zzj(r10, (List) unsafe.getObject(obj, j), zzE(r4));
                        r5 += zzo;
                        break;
                    case 50:
                        zzlh.zza(unsafe.getObject(obj, j), zzF(r4));
                        break;
                    case 51:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r10 << 3);
                            zzo = zzA + 8;
                            r5 += zzo;
                            break;
                        }
                    case 52:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r10 << 3);
                            zzo = zzA2 + 4;
                            r5 += zzo;
                            break;
                        }
                    case 53:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            long zzC = zzC(j, obj);
                            zzA3 = zzjm.zzA(r10 << 3);
                            zzB = zzjm.zzB(zzC);
                            zzo = zzB + zzA3;
                            r5 += zzo;
                            break;
                        }
                    case 54:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            long zzC2 = zzC(j, obj);
                            zzA3 = zzjm.zzA(r10 << 3);
                            zzB = zzjm.zzB(zzC2);
                            zzo = zzB + zzA3;
                            r5 += zzo;
                            break;
                        }
                    case 55:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            int zzr = zzr(j, obj);
                            zzA4 = zzjm.zzA(r10 << 3);
                            zzv = zzjm.zzv(zzr);
                            zzo = zzv + zzA4;
                            r5 += zzo;
                            break;
                        }
                    case 56:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r10 << 3);
                            zzo = zzA + 8;
                            r5 += zzo;
                            break;
                        }
                    case 57:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r10 << 3);
                            zzo = zzA2 + 4;
                            r5 += zzo;
                            break;
                        }
                    case 58:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            zzA5 = zzjm.zzA(r10 << 3);
                            zzo = zzA5 + 1;
                            r5 += zzo;
                            break;
                        }
                    case 59:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            Object object2 = unsafe.getObject(obj, j);
                            if (object2 instanceof zzje) {
                                zzA9 = zzjm.zzA(r10 << 3);
                                zzd2 = ((zzje) object2).zzd();
                                zzA10 = zzjm.zzA(zzd2);
                                r82 = zzA10 + zzd2 + zzA9;
                                r5 += r82;
                                break;
                            } else {
                                zzA4 = zzjm.zzA(r10 << 3);
                                zzv = zzjm.zzy((String) object2);
                                zzo = zzv + zzA4;
                                r5 += zzo;
                                break;
                            }
                        }
                    case 60:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            zzo = zzlz.zzo(r10, zzE(r4), unsafe.getObject(obj, j));
                            r5 += zzo;
                            break;
                        }
                    case 61:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            zzje zzjeVar2 = (zzje) unsafe.getObject(obj, j);
                            zzA9 = zzjm.zzA(r10 << 3);
                            zzd2 = zzjeVar2.zzd();
                            zzA10 = zzjm.zzA(zzd2);
                            r82 = zzA10 + zzd2 + zzA9;
                            r5 += r82;
                            break;
                        }
                    case 62:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            int zzr2 = zzr(j, obj);
                            zzA4 = zzjm.zzA(r10 << 3);
                            zzv = zzjm.zzA(zzr2);
                            zzo = zzv + zzA4;
                            r5 += zzo;
                            break;
                        }
                    case 63:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            int zzr3 = zzr(j, obj);
                            zzA4 = zzjm.zzA(r10 << 3);
                            zzv = zzjm.zzv(zzr3);
                            zzo = zzv + zzA4;
                            r5 += zzo;
                            break;
                        }
                    case 64:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r10 << 3);
                            zzo = zzA2 + 4;
                            r5 += zzo;
                            break;
                        }
                    case 65:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r10 << 3);
                            zzo = zzA + 8;
                            r5 += zzo;
                            break;
                        }
                    case 66:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            int zzr4 = zzr(j, obj);
                            zzA4 = zzjm.zzA(r10 << 3);
                            zzv = zzjm.zzA((zzr4 >> 31) ^ (zzr4 + zzr4));
                            zzo = zzv + zzA4;
                            r5 += zzo;
                            break;
                        }
                    case 67:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            long zzC3 = zzC(j, obj);
                            zzA3 = zzjm.zzA(r10 << 3);
                            zzB = zzjm.zzB((zzC3 >> 63) ^ (zzC3 + zzC3));
                            zzo = zzB + zzA3;
                            r5 += zzo;
                            break;
                        }
                    case 68:
                        if (!zzX(r10, r4, obj)) {
                            break;
                        } else {
                            zzo = zzjm.zzu(r10, (zzlm) unsafe.getObject(obj, j), zzE(r4));
                            r5 += zzo;
                            break;
                        }
                }
                r4 += 3;
                r2 = 1048575;
            } else {
                zzmo zzmoVar = this.zzn;
                int zza2 = zzmoVar.zza(zzmoVar.zzd(obj)) + r5;
                if (!this.zzh) {
                    return zza2;
                }
                this.zzo.zza(obj);
                throw null;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x002e. Please report as an issue. */
    public final int zzq(Object obj) {
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzv;
        int zzA5;
        int zzA6;
        int zzd;
        int zzA7;
        int zzo;
        int zzA8;
        int zzB2;
        int zzi;
        int zzz;
        int zzA9;
        int r4;
        int r0 = 0;
        int r1 = 0;
        while (true) {
            int[] r2 = this.zzc;
            if (r0 < r2.length) {
                int zzB3 = zzB(r0);
                int r42 = (zzB3 >>> 20) & 255;
                int r5 = r2[r0];
                long j = zzB3 & 1048575;
                if (r42 >= zzjx.zzJ.zza() && r42 <= zzjx.zzW.zza()) {
                    int r22 = r2[r0 + 2];
                }
                Unsafe unsafe = zzb;
                switch (r42) {
                    case 0:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r5 << 3);
                            zzo = zzA + 8;
                            r1 += zzo;
                            break;
                        }
                    case 1:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r5 << 3);
                            zzo = zzA2 + 4;
                            r1 += zzo;
                            break;
                        }
                    case 2:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            long zzd2 = zzmy.zzd(j, obj);
                            zzA3 = zzjm.zzA(r5 << 3);
                            zzB = zzjm.zzB(zzd2);
                            zzo = zzB + zzA3;
                            r1 += zzo;
                            break;
                        }
                    case 3:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            long zzd3 = zzmy.zzd(j, obj);
                            zzA3 = zzjm.zzA(r5 << 3);
                            zzB = zzjm.zzB(zzd3);
                            zzo = zzB + zzA3;
                            r1 += zzo;
                            break;
                        }
                    case 4:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            int zzc = zzmy.zzc(j, obj);
                            zzA4 = zzjm.zzA(r5 << 3);
                            zzv = zzjm.zzv(zzc);
                            zzo = zzv + zzA4;
                            r1 += zzo;
                            break;
                        }
                    case 5:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r5 << 3);
                            zzo = zzA + 8;
                            r1 += zzo;
                            break;
                        }
                    case 6:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r5 << 3);
                            zzo = zzA2 + 4;
                            r1 += zzo;
                            break;
                        }
                    case 7:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            zzA5 = zzjm.zzA(r5 << 3);
                            zzo = zzA5 + 1;
                            r1 += zzo;
                            break;
                        }
                    case 8:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            Object zzf = zzmy.zzf(j, obj);
                            if (zzf instanceof zzje) {
                                zzA6 = zzjm.zzA(r5 << 3);
                                zzd = ((zzje) zzf).zzd();
                                zzA7 = zzjm.zzA(zzd);
                                r4 = zzA7 + zzd + zzA6;
                                r1 += r4;
                                break;
                            } else {
                                zzA4 = zzjm.zzA(r5 << 3);
                                zzv = zzjm.zzy((String) zzf);
                                zzo = zzv + zzA4;
                                r1 += zzo;
                                break;
                            }
                        }
                    case 9:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            zzo = zzlz.zzo(r5, zzE(r0), zzmy.zzf(j, obj));
                            r1 += zzo;
                            break;
                        }
                    case 10:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            zzje zzjeVar = (zzje) zzmy.zzf(j, obj);
                            zzA6 = zzjm.zzA(r5 << 3);
                            zzd = zzjeVar.zzd();
                            zzA7 = zzjm.zzA(zzd);
                            r4 = zzA7 + zzd + zzA6;
                            r1 += r4;
                            break;
                        }
                    case 11:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            int zzc2 = zzmy.zzc(j, obj);
                            zzA4 = zzjm.zzA(r5 << 3);
                            zzv = zzjm.zzA(zzc2);
                            zzo = zzv + zzA4;
                            r1 += zzo;
                            break;
                        }
                    case 12:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            int zzc3 = zzmy.zzc(j, obj);
                            zzA4 = zzjm.zzA(r5 << 3);
                            zzv = zzjm.zzv(zzc3);
                            zzo = zzv + zzA4;
                            r1 += zzo;
                            break;
                        }
                    case 13:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r5 << 3);
                            zzo = zzA2 + 4;
                            r1 += zzo;
                            break;
                        }
                    case 14:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r5 << 3);
                            zzo = zzA + 8;
                            r1 += zzo;
                            break;
                        }
                    case 15:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            int zzc4 = zzmy.zzc(j, obj);
                            zzA4 = zzjm.zzA(r5 << 3);
                            zzv = zzjm.zzA((zzc4 >> 31) ^ (zzc4 + zzc4));
                            zzo = zzv + zzA4;
                            r1 += zzo;
                            break;
                        }
                    case 16:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            long zzd4 = zzmy.zzd(j, obj);
                            zzA8 = zzjm.zzA(r5 << 3);
                            zzB2 = zzjm.zzB((zzd4 >> 63) ^ (zzd4 + zzd4));
                            zzo = zzB2 + zzA8;
                            r1 += zzo;
                            break;
                        }
                    case 17:
                        if (!zzT(r0, obj)) {
                            break;
                        } else {
                            zzo = zzjm.zzu(r5, (zzlm) zzmy.zzf(j, obj), zzE(r0));
                            r1 += zzo;
                            break;
                        }
                    case 18:
                        zzo = zzlz.zzh(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 19:
                        zzo = zzlz.zzf(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 20:
                        zzo = zzlz.zzm(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 21:
                        zzo = zzlz.zzx(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 22:
                        zzo = zzlz.zzk(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 23:
                        zzo = zzlz.zzh(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 24:
                        zzo = zzlz.zzf(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 25:
                        zzo = zzlz.zza(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 26:
                        zzo = zzlz.zzu(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 27:
                        zzo = zzlz.zzp(r5, (List) zzmy.zzf(j, obj), zzE(r0));
                        r1 += zzo;
                        break;
                    case 28:
                        zzo = zzlz.zzc(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 29:
                        zzo = zzlz.zzv(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 30:
                        zzo = zzlz.zzd(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 31:
                        zzo = zzlz.zzf(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 32:
                        zzo = zzlz.zzh(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 33:
                        zzo = zzlz.zzq(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 34:
                        zzo = zzlz.zzs(r5, (List) zzmy.zzf(j, obj));
                        r1 += zzo;
                        break;
                    case 35:
                        zzi = zzlz.zzi((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 36:
                        zzi = zzlz.zzg((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 37:
                        zzi = zzlz.zzn((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 38:
                        zzi = zzlz.zzy((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 39:
                        zzi = zzlz.zzl((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 40:
                        zzi = zzlz.zzi((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 41:
                        zzi = zzlz.zzg((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 42:
                        zzi = zzlz.zzb((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 43:
                        zzi = zzlz.zzw((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 44:
                        zzi = zzlz.zze((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 45:
                        zzi = zzlz.zzg((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 46:
                        zzi = zzlz.zzi((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 47:
                        zzi = zzlz.zzr((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 48:
                        zzi = zzlz.zzt((List) unsafe.getObject(obj, j));
                        if (zzi <= 0) {
                            break;
                        } else {
                            zzz = zzjm.zzz(r5);
                            zzA9 = zzjm.zzA(zzi);
                            r4 = zzA9 + zzz + zzi;
                            r1 += r4;
                            break;
                        }
                    case 49:
                        zzo = zzlz.zzj(r5, (List) zzmy.zzf(j, obj), zzE(r0));
                        r1 += zzo;
                        break;
                    case 50:
                        zzlh.zza(zzmy.zzf(j, obj), zzF(r0));
                        break;
                    case 51:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r5 << 3);
                            zzo = zzA + 8;
                            r1 += zzo;
                            break;
                        }
                    case 52:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r5 << 3);
                            zzo = zzA2 + 4;
                            r1 += zzo;
                            break;
                        }
                    case 53:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            long zzC = zzC(j, obj);
                            zzA3 = zzjm.zzA(r5 << 3);
                            zzB = zzjm.zzB(zzC);
                            zzo = zzB + zzA3;
                            r1 += zzo;
                            break;
                        }
                    case 54:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            long zzC2 = zzC(j, obj);
                            zzA3 = zzjm.zzA(r5 << 3);
                            zzB = zzjm.zzB(zzC2);
                            zzo = zzB + zzA3;
                            r1 += zzo;
                            break;
                        }
                    case 55:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            int zzr = zzr(j, obj);
                            zzA4 = zzjm.zzA(r5 << 3);
                            zzv = zzjm.zzv(zzr);
                            zzo = zzv + zzA4;
                            r1 += zzo;
                            break;
                        }
                    case 56:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r5 << 3);
                            zzo = zzA + 8;
                            r1 += zzo;
                            break;
                        }
                    case 57:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r5 << 3);
                            zzo = zzA2 + 4;
                            r1 += zzo;
                            break;
                        }
                    case 58:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            zzA5 = zzjm.zzA(r5 << 3);
                            zzo = zzA5 + 1;
                            r1 += zzo;
                            break;
                        }
                    case 59:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            Object zzf2 = zzmy.zzf(j, obj);
                            if (zzf2 instanceof zzje) {
                                zzA6 = zzjm.zzA(r5 << 3);
                                zzd = ((zzje) zzf2).zzd();
                                zzA7 = zzjm.zzA(zzd);
                                r4 = zzA7 + zzd + zzA6;
                                r1 += r4;
                                break;
                            } else {
                                zzA4 = zzjm.zzA(r5 << 3);
                                zzv = zzjm.zzy((String) zzf2);
                                zzo = zzv + zzA4;
                                r1 += zzo;
                                break;
                            }
                        }
                    case 60:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            zzo = zzlz.zzo(r5, zzE(r0), zzmy.zzf(j, obj));
                            r1 += zzo;
                            break;
                        }
                    case 61:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            zzje zzjeVar2 = (zzje) zzmy.zzf(j, obj);
                            zzA6 = zzjm.zzA(r5 << 3);
                            zzd = zzjeVar2.zzd();
                            zzA7 = zzjm.zzA(zzd);
                            r4 = zzA7 + zzd + zzA6;
                            r1 += r4;
                            break;
                        }
                    case 62:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            int zzr2 = zzr(j, obj);
                            zzA4 = zzjm.zzA(r5 << 3);
                            zzv = zzjm.zzA(zzr2);
                            zzo = zzv + zzA4;
                            r1 += zzo;
                            break;
                        }
                    case 63:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            int zzr3 = zzr(j, obj);
                            zzA4 = zzjm.zzA(r5 << 3);
                            zzv = zzjm.zzv(zzr3);
                            zzo = zzv + zzA4;
                            r1 += zzo;
                            break;
                        }
                    case 64:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            zzA2 = zzjm.zzA(r5 << 3);
                            zzo = zzA2 + 4;
                            r1 += zzo;
                            break;
                        }
                    case 65:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            zzA = zzjm.zzA(r5 << 3);
                            zzo = zzA + 8;
                            r1 += zzo;
                            break;
                        }
                    case 66:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            int zzr4 = zzr(j, obj);
                            zzA4 = zzjm.zzA(r5 << 3);
                            zzv = zzjm.zzA((zzr4 >> 31) ^ (zzr4 + zzr4));
                            zzo = zzv + zzA4;
                            r1 += zzo;
                            break;
                        }
                    case 67:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            long zzC3 = zzC(j, obj);
                            zzA8 = zzjm.zzA(r5 << 3);
                            zzB2 = zzjm.zzB((zzC3 >> 63) ^ (zzC3 + zzC3));
                            zzo = zzB2 + zzA8;
                            r1 += zzo;
                            break;
                        }
                    case 68:
                        if (!zzX(r5, r0, obj)) {
                            break;
                        } else {
                            zzo = zzjm.zzu(r5, (zzlm) zzmy.zzf(j, obj), zzE(r0));
                            r1 += zzo;
                            break;
                        }
                }
                r0 += 3;
            } else {
                zzmo zzmoVar = this.zzn;
                return zzmoVar.zza(zzmoVar.zzd(obj)) + r1;
            }
        }
    }

    public final void zzs(Object obj, int r5, long j) throws IOException {
        Object zzF = zzF(r5);
        Unsafe unsafe = zzb;
        Object object = unsafe.getObject(obj, j);
        if (!((zzlg) object).zze()) {
            zzlg zzb2 = zzlg.zza().zzb();
            zzlh.zzb(zzb2, object);
            unsafe.putObject(obj, j, zzb2);
        }
        throw null;
    }

    public final int zzt(Object obj, byte[] bArr, int r21, int r22, int r23, int r24, int r25, int r26, int r27, long j, int r30, zzir zzirVar) throws IOException {
        long j2 = this.zzc[r30 + 2] & 1048575;
        boolean z = true;
        Unsafe unsafe = zzb;
        switch (r27) {
            case 51:
                if (r25 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzis.zzp(r21, bArr))));
                    unsafe.putInt(obj, j2, r24);
                    return r21 + 8;
                }
                break;
            case 52:
                if (r25 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzis.zzb(r21, bArr))));
                    unsafe.putInt(obj, j2, r24);
                    return r21 + 4;
                }
                break;
            case 53:
            case 54:
                if (r25 == 0) {
                    int zzm = zzis.zzm(bArr, r21, zzirVar);
                    unsafe.putObject(obj, j, Long.valueOf(zzirVar.zzb));
                    unsafe.putInt(obj, j2, r24);
                    return zzm;
                }
                break;
            case 55:
            case 62:
                if (r25 == 0) {
                    int zzj = zzis.zzj(bArr, r21, zzirVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zzirVar.zza));
                    unsafe.putInt(obj, j2, r24);
                    return zzj;
                }
                break;
            case 56:
            case 65:
                if (r25 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(zzis.zzp(r21, bArr)));
                    unsafe.putInt(obj, j2, r24);
                    return r21 + 8;
                }
                break;
            case 57:
            case 64:
                if (r25 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(zzis.zzb(r21, bArr)));
                    unsafe.putInt(obj, j2, r24);
                    return r21 + 4;
                }
                break;
            case 58:
                if (r25 == 0) {
                    int zzm2 = zzis.zzm(bArr, r21, zzirVar);
                    if (zzirVar.zzb == 0) {
                        z = false;
                    }
                    unsafe.putObject(obj, j, Boolean.valueOf(z));
                    unsafe.putInt(obj, j2, r24);
                    return zzm2;
                }
                break;
            case 59:
                if (r25 == 2) {
                    int zzj2 = zzis.zzj(bArr, r21, zzirVar);
                    int r3 = zzirVar.zza;
                    if (r3 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else {
                        if ((r26 & 536870912) != 0 && !zznd.zzf(bArr, zzj2, zzj2 + r3)) {
                            throw zzkp.zzc();
                        }
                        unsafe.putObject(obj, j, new String(bArr, zzj2, r3, zzkn.zzb));
                        zzj2 += r3;
                    }
                    unsafe.putInt(obj, j2, r24);
                    return zzj2;
                }
                break;
            case 60:
                if (r25 == 2) {
                    Object zzH = zzH(r24, r30, obj);
                    int zzo = zzis.zzo(zzH, zzE(r30), bArr, r21, r22, zzirVar);
                    zzP(r24, r30, obj, zzH);
                    return zzo;
                }
                break;
            case 61:
                if (r25 == 2) {
                    int zza2 = zzis.zza(bArr, r21, zzirVar);
                    unsafe.putObject(obj, j, zzirVar.zzc);
                    unsafe.putInt(obj, j2, r24);
                    return zza2;
                }
                break;
            case 63:
                if (r25 == 0) {
                    int zzj3 = zzis.zzj(bArr, r21, zzirVar);
                    int r4 = zzirVar.zza;
                    int r5 = r30 / 3;
                    zzkj zzkjVar = (zzkj) this.zzd[r5 + r5 + 1];
                    if (zzkjVar != null && !zzkjVar.zza(r4)) {
                        zzd(obj).zzj(r23, Long.valueOf(r4));
                    } else {
                        unsafe.putObject(obj, j, Integer.valueOf(r4));
                        unsafe.putInt(obj, j2, r24);
                    }
                    return zzj3;
                }
                break;
            case 66:
                if (r25 == 0) {
                    int zzj4 = zzis.zzj(bArr, r21, zzirVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zzji.zzb(zzirVar.zza)));
                    unsafe.putInt(obj, j2, r24);
                    return zzj4;
                }
                break;
            case 67:
                if (r25 == 0) {
                    int zzm3 = zzis.zzm(bArr, r21, zzirVar);
                    unsafe.putObject(obj, j, Long.valueOf(zzji.zzc(zzirVar.zzb)));
                    unsafe.putInt(obj, j2, r24);
                    return zzm3;
                }
                break;
            case 68:
                if (r25 == 3) {
                    Object zzH2 = zzH(r24, r30, obj);
                    int zzn = zzis.zzn(zzH2, zzE(r30), bArr, r21, r22, (r23 & (-8)) | 4, zzirVar);
                    zzP(r24, r30, obj, zzH2);
                    return zzn;
                }
                break;
        }
        return r21;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x009d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    public final void zzu(Object obj, byte[] bArr, int r32, int r33, zzir zzirVar) throws IOException {
        byte b;
        int r4;
        int zzz;
        int r20;
        int r2;
        int r25;
        int r19;
        Unsafe unsafe;
        Object obj2;
        int r15;
        int r26;
        int r27;
        int r17;
        int r42;
        int r1;
        int r172;
        int r6;
        int r7;
        int r322;
        int r43;
        int zzm;
        int r44;
        int r0;
        int r45;
        int zzm2;
        boolean z;
        zzlp<T> zzlpVar = this;
        Object obj3 = obj;
        byte[] bArr2 = bArr;
        int r13 = r33;
        zzir zzirVar2 = zzirVar;
        zzJ(obj);
        Unsafe unsafe2 = zzb;
        int r8 = 0;
        int r02 = r32;
        int r22 = 0;
        int r62 = 0;
        int r12 = -1;
        int r5 = 1048575;
        while (r02 < r13) {
            int r3 = r02 + 1;
            byte b2 = bArr2[r02];
            if (b2 < 0) {
                r4 = zzis.zzk(b2, bArr2, r3, zzirVar2);
                b = zzirVar2.zza;
            } else {
                b = b2;
                r4 = r3;
            }
            int r34 = b >>> 3;
            int r03 = b & 7;
            int r10 = zzlpVar.zzf;
            int r72 = zzlpVar.zze;
            if (r34 > r12) {
                int r23 = r22 / 3;
                if (r34 >= r72 && r34 <= r10) {
                    zzz = zzlpVar.zzz(r34, r23);
                }
                zzz = -1;
            } else {
                if (r34 >= r72 && r34 <= r10) {
                    zzz = zzlpVar.zzz(r34, r8);
                }
                zzz = -1;
            }
            int r102 = zzz;
            if (r102 == -1) {
                r20 = r34;
                r2 = r4;
                r25 = r5;
                r19 = r8;
                unsafe = unsafe2;
                obj2 = obj3;
            } else {
                int[] r24 = zzlpVar.zzc;
                int r14 = r24[r102 + 1];
                int r73 = (r14 >>> 20) & 255;
                r20 = r34;
                int r323 = r4;
                long j = r14 & 1048575;
                if (r73 <= 17) {
                    int r28 = r24[r102 + 2];
                    int r82 = 1 << (r28 >>> 20);
                    int r29 = r28 & 1048575;
                    if (r29 != r5) {
                        if (r5 != 1048575) {
                            unsafe2.putInt(obj3, r5, r62);
                        }
                        if (r29 != 1048575) {
                            r62 = unsafe2.getInt(obj3, r29);
                        }
                        r172 = r62;
                        r6 = r29;
                    } else {
                        r172 = r62;
                        r6 = r5;
                    }
                    switch (r73) {
                        case 0:
                            r7 = r323;
                            r322 = r6;
                            if (r03 == 1) {
                                zzmy.zzo(obj3, j, Double.longBitsToDouble(zzis.zzp(r7, bArr2)));
                                r43 = r7 + 8;
                                zzm = r43;
                                r0 = r172 | r82;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 1:
                            r7 = r323;
                            r322 = r6;
                            if (r03 == 5) {
                                zzmy.zzp(obj3, j, Float.intBitsToFloat(zzis.zzb(r7, bArr2)));
                                r43 = r7 + 4;
                                zzm = r43;
                                r0 = r172 | r82;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 2:
                        case 3:
                            r7 = r323;
                            r322 = r6;
                            if (r03 == 0) {
                                zzm = zzis.zzm(bArr2, r7, zzirVar2);
                                unsafe2.putLong(obj, j, zzirVar2.zzb);
                                r62 = r172 | r82;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 4:
                        case 11:
                            r7 = r323;
                            r322 = r6;
                            if (r03 == 0) {
                                int zzj = zzis.zzj(bArr2, r7, zzirVar2);
                                unsafe2.putInt(obj3, j, zzirVar2.zza);
                                zzm = zzj;
                                r0 = r172 | r82;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 5:
                        case 14:
                            r44 = r323;
                            r322 = r6;
                            if (r03 == 1) {
                                r7 = r44;
                                unsafe2.putLong(obj, j, zzis.zzp(r44, bArr2));
                                r43 = r7 + 8;
                                zzm = r43;
                                r0 = r172 | r82;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r7 = r44;
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 6:
                        case 13:
                            r44 = r323;
                            r322 = r6;
                            if (r03 == 5) {
                                unsafe2.putInt(obj3, j, zzis.zzb(r44, bArr2));
                                r43 = r44 + 4;
                                zzm = r43;
                                r0 = r172 | r82;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r7 = r44;
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 7:
                            r45 = r323;
                            if (r03 == 0) {
                                zzm2 = zzis.zzm(bArr2, r45, zzirVar2);
                                if (zzirVar2.zzb != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                zzmy.zzm(obj3, j, z);
                                zzm = zzm2;
                                r0 = r172 | r82;
                                r322 = r6;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r7 = r45;
                                r322 = r6;
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 8:
                            r45 = r323;
                            if (r03 == 2) {
                                if ((536870912 & r14) == 0) {
                                    zzm2 = zzis.zzg(bArr2, r45, zzirVar2);
                                } else {
                                    zzm2 = zzis.zzh(bArr2, r45, zzirVar2);
                                }
                                unsafe2.putObject(obj3, j, zzirVar2.zzc);
                                zzm = zzm2;
                                r0 = r172 | r82;
                                r322 = r6;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r7 = r45;
                                r322 = r6;
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 9:
                            r45 = r323;
                            if (r03 == 2) {
                                Object zzG = zzlpVar.zzG(r102, obj3);
                                zzm2 = zzis.zzo(zzG, zzlpVar.zzE(r102), bArr, r45, r33, zzirVar);
                                zzlpVar.zzO(obj3, r102, zzG);
                                zzm = zzm2;
                                r0 = r172 | r82;
                                r322 = r6;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r7 = r45;
                                r322 = r6;
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 10:
                            r45 = r323;
                            if (r03 == 2) {
                                zzm2 = zzis.zza(bArr2, r45, zzirVar2);
                                unsafe2.putObject(obj3, j, zzirVar2.zzc);
                                zzm = zzm2;
                                r0 = r172 | r82;
                                r322 = r6;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r7 = r45;
                                r322 = r6;
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 12:
                            r45 = r323;
                            if (r03 == 0) {
                                zzm2 = zzis.zzj(bArr2, r45, zzirVar2);
                                unsafe2.putInt(obj3, j, zzirVar2.zza);
                                zzm = zzm2;
                                r0 = r172 | r82;
                                r322 = r6;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r7 = r45;
                                r322 = r6;
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 15:
                            r45 = r323;
                            if (r03 == 0) {
                                zzm2 = zzis.zzj(bArr2, r45, zzirVar2);
                                unsafe2.putInt(obj3, j, zzji.zzb(zzirVar2.zza));
                                zzm = zzm2;
                                r0 = r172 | r82;
                                r322 = r6;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r7 = r45;
                                r322 = r6;
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        case 16:
                            if (r03 == 0) {
                                zzm = zzis.zzm(bArr2, r323, zzirVar2);
                                unsafe2.putLong(obj, j, zzji.zzc(zzirVar2.zzb));
                                r0 = r172 | r82;
                                r322 = r6;
                                r62 = r0;
                                r5 = r322;
                                r02 = zzm;
                                r13 = r33;
                                r22 = r102;
                                r12 = r20;
                                r8 = 0;
                                break;
                            } else {
                                r45 = r323;
                                r7 = r45;
                                r322 = r6;
                                r25 = r322;
                                r2 = r7;
                                unsafe = unsafe2;
                                r8 = r102;
                                obj2 = obj3;
                                r62 = r172;
                                r19 = 0;
                                break;
                            }
                        default:
                            r7 = r323;
                            r322 = r6;
                            r25 = r322;
                            r2 = r7;
                            unsafe = unsafe2;
                            r8 = r102;
                            obj2 = obj3;
                            r62 = r172;
                            r19 = 0;
                            break;
                    }
                } else {
                    int r173 = r5;
                    int r83 = r62;
                    if (r73 == 27) {
                        if (r03 == 2) {
                            zzkm zzkmVar = (zzkm) unsafe2.getObject(obj3, j);
                            if (!zzkmVar.zzc()) {
                                int size = zzkmVar.size();
                                if (size == 0) {
                                    r1 = 10;
                                } else {
                                    r1 = size + size;
                                }
                                zzkmVar = zzkmVar.zzd(r1);
                                unsafe2.putObject(obj3, j, zzkmVar);
                            }
                            r02 = zzis.zze(zzlpVar.zzE(r102), b, bArr, r323, r33, zzkmVar, zzirVar);
                            r5 = r173;
                            r62 = r83;
                            r13 = r33;
                            r22 = r102;
                            r12 = r20;
                            r8 = 0;
                        } else {
                            r15 = r323;
                            r26 = r83;
                            unsafe = unsafe2;
                            r27 = r102;
                            r25 = r173;
                            r19 = 0;
                        }
                    } else if (r73 <= 49) {
                        r25 = r173;
                        r26 = r83;
                        r19 = 0;
                        unsafe = unsafe2;
                        r02 = zzv(obj, bArr, r323, r33, b, r20, r03, r102, r14, r73, j, zzirVar);
                        if (r02 != r323) {
                            obj2 = obj;
                            r17 = r102;
                            r22 = r17;
                            r5 = r25;
                            r62 = r26;
                            bArr2 = bArr;
                            r13 = r33;
                            zzirVar2 = zzirVar;
                            obj3 = obj2;
                            r8 = r19;
                            r12 = r20;
                            unsafe2 = unsafe;
                            zzlpVar = this;
                        } else {
                            obj2 = obj;
                            r42 = r02;
                            r17 = r102;
                            r2 = r42;
                            r8 = r17;
                            r62 = r26;
                        }
                    } else {
                        r25 = r173;
                        r15 = r323;
                        r26 = r83;
                        unsafe = unsafe2;
                        r27 = r102;
                        r19 = 0;
                        if (r73 == 50) {
                            if (r03 == 2) {
                                zzs(obj, r27, j);
                                throw null;
                            }
                        } else {
                            obj2 = obj;
                            r17 = r27;
                            r02 = zzt(obj, bArr, r15, r33, b, r20, r03, r14, r73, j, r27, zzirVar);
                            if (r02 == r15) {
                                r42 = r02;
                                r2 = r42;
                                r8 = r17;
                                r62 = r26;
                            }
                            r22 = r17;
                            r5 = r25;
                            r62 = r26;
                            bArr2 = bArr;
                            r13 = r33;
                            zzirVar2 = zzirVar;
                            obj3 = obj2;
                            r8 = r19;
                            r12 = r20;
                            unsafe2 = unsafe;
                            zzlpVar = this;
                        }
                    }
                    r42 = r15;
                    r17 = r27;
                    obj2 = obj;
                    r2 = r42;
                    r8 = r17;
                    r62 = r26;
                }
            }
            r02 = zzis.zzi(b, bArr, r2, r33, zzd(obj), zzirVar);
            r22 = r8;
            r5 = r25;
            bArr2 = bArr;
            r13 = r33;
            zzirVar2 = zzirVar;
            obj3 = obj2;
            r8 = r19;
            r12 = r20;
            unsafe2 = unsafe;
            zzlpVar = this;
        }
        int r262 = r62;
        Unsafe unsafe3 = unsafe2;
        Object obj4 = obj3;
        if (r5 != 1048575) {
            unsafe3.putInt(obj4, r5, r262);
        }
        if (r02 == r33) {
        } else {
            throw zzkp.zze();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0039. Please report as an issue. */
    public final int zzv(Object obj, byte[] bArr, int r19, int r20, int r21, int r22, int r23, int r24, long j, int r27, long j2, zzir zzirVar) throws IOException {
        int r4;
        int r42;
        int r43;
        int r44;
        boolean z;
        boolean z2;
        int zzj;
        boolean z3;
        int r13;
        int r45 = r19;
        Unsafe unsafe = zzb;
        zzkm zzkmVar = (zzkm) unsafe.getObject(obj, j2);
        if (!zzkmVar.zzc()) {
            int size = zzkmVar.size();
            if (size == 0) {
                r13 = 10;
            } else {
                r13 = size + size;
            }
            zzkmVar = zzkmVar.zzd(r13);
            unsafe.putObject(obj, j2, zzkmVar);
        }
        switch (r27) {
            case 18:
            case 35:
                if (r23 == 2) {
                    zzjo zzjoVar = (zzjo) zzkmVar;
                    int zzj2 = zzis.zzj(bArr, r45, zzirVar);
                    int r2 = zzirVar.zza + zzj2;
                    while (zzj2 < r2) {
                        zzjoVar.zze(Double.longBitsToDouble(zzis.zzp(zzj2, bArr)));
                        zzj2 += 8;
                    }
                    if (zzj2 != r2) {
                        throw zzkp.zzf();
                    }
                    return zzj2;
                }
                if (r23 == 1) {
                    zzjo zzjoVar2 = (zzjo) zzkmVar;
                    zzjoVar2.zze(Double.longBitsToDouble(zzis.zzp(r45, bArr)));
                    while (true) {
                        r4 = r45 + 8;
                        if (r4 < r20) {
                            int zzj3 = zzis.zzj(bArr, r4, zzirVar);
                            if (r21 == zzirVar.zza) {
                                zzjoVar2.zze(Double.longBitsToDouble(zzis.zzp(zzj3, bArr)));
                                r45 = zzj3;
                            }
                        }
                    }
                    return r4;
                }
                return r45;
            case 19:
            case 36:
                if (r23 == 2) {
                    zzjy zzjyVar = (zzjy) zzkmVar;
                    int zzj4 = zzis.zzj(bArr, r45, zzirVar);
                    int r25 = zzirVar.zza + zzj4;
                    while (zzj4 < r25) {
                        zzjyVar.zze(Float.intBitsToFloat(zzis.zzb(zzj4, bArr)));
                        zzj4 += 4;
                    }
                    if (zzj4 != r25) {
                        throw zzkp.zzf();
                    }
                    return zzj4;
                }
                if (r23 == 5) {
                    zzjy zzjyVar2 = (zzjy) zzkmVar;
                    zzjyVar2.zze(Float.intBitsToFloat(zzis.zzb(r45, bArr)));
                    while (true) {
                        r42 = r45 + 4;
                        if (r42 < r20) {
                            int zzj5 = zzis.zzj(bArr, r42, zzirVar);
                            if (r21 == zzirVar.zza) {
                                zzjyVar2.zze(Float.intBitsToFloat(zzis.zzb(zzj5, bArr)));
                                r45 = zzj5;
                            }
                        }
                    }
                    return r42;
                }
                return r45;
            case 20:
            case 21:
            case 37:
            case 38:
                if (r23 == 2) {
                    zzlb zzlbVar = (zzlb) zzkmVar;
                    int zzj6 = zzis.zzj(bArr, r45, zzirVar);
                    int r26 = zzirVar.zza + zzj6;
                    while (zzj6 < r26) {
                        zzj6 = zzis.zzm(bArr, zzj6, zzirVar);
                        zzlbVar.zzg(zzirVar.zzb);
                    }
                    if (zzj6 != r26) {
                        throw zzkp.zzf();
                    }
                    return zzj6;
                }
                if (r23 == 0) {
                    zzlb zzlbVar2 = (zzlb) zzkmVar;
                    int zzm = zzis.zzm(bArr, r45, zzirVar);
                    zzlbVar2.zzg(zzirVar.zzb);
                    while (zzm < r20) {
                        int zzj7 = zzis.zzj(bArr, zzm, zzirVar);
                        if (r21 == zzirVar.zza) {
                            zzm = zzis.zzm(bArr, zzj7, zzirVar);
                            zzlbVar2.zzg(zzirVar.zzb);
                        } else {
                            return zzm;
                        }
                    }
                    return zzm;
                }
                return r45;
            case 22:
            case 29:
            case 39:
            case 43:
                if (r23 == 2) {
                    return zzis.zzf(bArr, r45, zzkmVar, zzirVar);
                }
                if (r23 == 0) {
                    return zzis.zzl(r21, bArr, r19, r20, zzkmVar, zzirVar);
                }
                return r45;
            case 23:
            case 32:
            case 40:
            case 46:
                if (r23 == 2) {
                    zzlb zzlbVar3 = (zzlb) zzkmVar;
                    int zzj8 = zzis.zzj(bArr, r45, zzirVar);
                    int r28 = zzirVar.zza + zzj8;
                    while (zzj8 < r28) {
                        zzlbVar3.zzg(zzis.zzp(zzj8, bArr));
                        zzj8 += 8;
                    }
                    if (zzj8 != r28) {
                        throw zzkp.zzf();
                    }
                    return zzj8;
                }
                if (r23 == 1) {
                    zzlb zzlbVar4 = (zzlb) zzkmVar;
                    zzlbVar4.zzg(zzis.zzp(r45, bArr));
                    while (true) {
                        r43 = r45 + 8;
                        if (r43 < r20) {
                            int zzj9 = zzis.zzj(bArr, r43, zzirVar);
                            if (r21 == zzirVar.zza) {
                                zzlbVar4.zzg(zzis.zzp(zzj9, bArr));
                                r45 = zzj9;
                            }
                        }
                    }
                    return r43;
                }
                return r45;
            case 24:
            case 31:
            case 41:
            case 45:
                if (r23 == 2) {
                    zzkg zzkgVar = (zzkg) zzkmVar;
                    int zzj10 = zzis.zzj(bArr, r45, zzirVar);
                    int r29 = zzirVar.zza + zzj10;
                    while (zzj10 < r29) {
                        zzkgVar.zzh(zzis.zzb(zzj10, bArr));
                        zzj10 += 4;
                    }
                    if (zzj10 != r29) {
                        throw zzkp.zzf();
                    }
                    return zzj10;
                }
                if (r23 == 5) {
                    zzkg zzkgVar2 = (zzkg) zzkmVar;
                    zzkgVar2.zzh(zzis.zzb(r45, bArr));
                    while (true) {
                        r44 = r45 + 4;
                        if (r44 < r20) {
                            int zzj11 = zzis.zzj(bArr, r44, zzirVar);
                            if (r21 == zzirVar.zza) {
                                zzkgVar2.zzh(zzis.zzb(zzj11, bArr));
                                r45 = zzj11;
                            }
                        }
                    }
                    return r44;
                }
                return r45;
            case 25:
            case 42:
                if (r23 == 2) {
                    zzit zzitVar = (zzit) zzkmVar;
                    zzj = zzis.zzj(bArr, r45, zzirVar);
                    int r46 = zzirVar.zza + zzj;
                    while (zzj < r46) {
                        zzj = zzis.zzm(bArr, zzj, zzirVar);
                        if (zzirVar.zzb != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zzitVar.zze(z3);
                    }
                    if (zzj != r46) {
                        throw zzkp.zzf();
                    }
                    return zzj;
                }
                if (r23 == 0) {
                    zzit zzitVar2 = (zzit) zzkmVar;
                    int zzm2 = zzis.zzm(bArr, r45, zzirVar);
                    if (zzirVar.zzb != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzitVar2.zze(z);
                    while (zzm2 < r20) {
                        int zzj12 = zzis.zzj(bArr, zzm2, zzirVar);
                        if (r21 == zzirVar.zza) {
                            zzm2 = zzis.zzm(bArr, zzj12, zzirVar);
                            if (zzirVar.zzb != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            zzitVar2.zze(z2);
                        } else {
                            return zzm2;
                        }
                    }
                    return zzm2;
                }
                return r45;
            case 26:
                if (r23 == 2) {
                    if ((j & 536870912) == 0) {
                        int zzj13 = zzis.zzj(bArr, r45, zzirVar);
                        int r47 = zzirVar.zza;
                        if (r47 >= 0) {
                            if (r47 == 0) {
                                zzkmVar.add("");
                            } else {
                                zzkmVar.add(new String(bArr, zzj13, r47, zzkn.zzb));
                                zzj13 += r47;
                            }
                            while (zzj13 < r20) {
                                int zzj14 = zzis.zzj(bArr, zzj13, zzirVar);
                                if (r21 == zzirVar.zza) {
                                    zzj13 = zzis.zzj(bArr, zzj14, zzirVar);
                                    int r48 = zzirVar.zza;
                                    if (r48 >= 0) {
                                        if (r48 == 0) {
                                            zzkmVar.add("");
                                        } else {
                                            zzkmVar.add(new String(bArr, zzj13, r48, zzkn.zzb));
                                            zzj13 += r48;
                                        }
                                    } else {
                                        throw zzkp.zzd();
                                    }
                                } else {
                                    return zzj13;
                                }
                            }
                            return zzj13;
                        }
                        throw zzkp.zzd();
                    }
                    int zzj15 = zzis.zzj(bArr, r45, zzirVar);
                    int r49 = zzirVar.zza;
                    if (r49 >= 0) {
                        if (r49 == 0) {
                            zzkmVar.add("");
                        } else {
                            int r8 = zzj15 + r49;
                            if (zznd.zzf(bArr, zzj15, r8)) {
                                zzkmVar.add(new String(bArr, zzj15, r49, zzkn.zzb));
                                zzj15 = r8;
                            } else {
                                throw zzkp.zzc();
                            }
                        }
                        while (zzj15 < r20) {
                            int zzj16 = zzis.zzj(bArr, zzj15, zzirVar);
                            if (r21 == zzirVar.zza) {
                                zzj15 = zzis.zzj(bArr, zzj16, zzirVar);
                                int r410 = zzirVar.zza;
                                if (r410 >= 0) {
                                    if (r410 == 0) {
                                        zzkmVar.add("");
                                    } else {
                                        int r82 = zzj15 + r410;
                                        if (zznd.zzf(bArr, zzj15, r82)) {
                                            zzkmVar.add(new String(bArr, zzj15, r410, zzkn.zzb));
                                            zzj15 = r82;
                                        } else {
                                            throw zzkp.zzc();
                                        }
                                    }
                                } else {
                                    throw zzkp.zzd();
                                }
                            } else {
                                return zzj15;
                            }
                        }
                        return zzj15;
                    }
                    throw zzkp.zzd();
                }
                return r45;
            case 27:
                if (r23 == 2) {
                    return zzis.zze(zzE(r24), r21, bArr, r19, r20, zzkmVar, zzirVar);
                }
                return r45;
            case 28:
                if (r23 == 2) {
                    int zzj17 = zzis.zzj(bArr, r45, zzirVar);
                    int r411 = zzirVar.zza;
                    if (r411 >= 0) {
                        if (r411 <= bArr.length - zzj17) {
                            if (r411 == 0) {
                                zzkmVar.add(zzje.zzb);
                            } else {
                                zzkmVar.add(zzje.zzl(bArr, zzj17, r411));
                                zzj17 += r411;
                            }
                            while (zzj17 < r20) {
                                int zzj18 = zzis.zzj(bArr, zzj17, zzirVar);
                                if (r21 == zzirVar.zza) {
                                    zzj17 = zzis.zzj(bArr, zzj18, zzirVar);
                                    int r412 = zzirVar.zza;
                                    if (r412 >= 0) {
                                        if (r412 <= bArr.length - zzj17) {
                                            if (r412 == 0) {
                                                zzkmVar.add(zzje.zzb);
                                            } else {
                                                zzkmVar.add(zzje.zzl(bArr, zzj17, r412));
                                                zzj17 += r412;
                                            }
                                        } else {
                                            throw zzkp.zzf();
                                        }
                                    } else {
                                        throw zzkp.zzd();
                                    }
                                } else {
                                    return zzj17;
                                }
                            }
                            return zzj17;
                        }
                        throw zzkp.zzf();
                    }
                    throw zzkp.zzd();
                }
                return r45;
            case 30:
            case 44:
                if (r23 == 2) {
                    zzj = zzis.zzf(bArr, r45, zzkmVar, zzirVar);
                } else {
                    if (r23 == 0) {
                        zzj = zzis.zzl(r21, bArr, r19, r20, zzkmVar, zzirVar);
                    }
                    return r45;
                }
                int r3 = r24 / 3;
                zzlz.zzC(obj, r22, zzkmVar, (zzkj) this.zzd[r3 + r3 + 1], this.zzn);
                return zzj;
            case 33:
            case 47:
                if (r23 == 2) {
                    zzkg zzkgVar3 = (zzkg) zzkmVar;
                    int zzj19 = zzis.zzj(bArr, r45, zzirVar);
                    int r210 = zzirVar.zza + zzj19;
                    while (zzj19 < r210) {
                        zzj19 = zzis.zzj(bArr, zzj19, zzirVar);
                        zzkgVar3.zzh(zzji.zzb(zzirVar.zza));
                    }
                    if (zzj19 != r210) {
                        throw zzkp.zzf();
                    }
                    return zzj19;
                }
                if (r23 == 0) {
                    zzkg zzkgVar4 = (zzkg) zzkmVar;
                    int zzj20 = zzis.zzj(bArr, r45, zzirVar);
                    zzkgVar4.zzh(zzji.zzb(zzirVar.zza));
                    while (zzj20 < r20) {
                        int zzj21 = zzis.zzj(bArr, zzj20, zzirVar);
                        if (r21 == zzirVar.zza) {
                            zzj20 = zzis.zzj(bArr, zzj21, zzirVar);
                            zzkgVar4.zzh(zzji.zzb(zzirVar.zza));
                        } else {
                            return zzj20;
                        }
                    }
                    return zzj20;
                }
                return r45;
            case 34:
            case 48:
                if (r23 == 2) {
                    zzlb zzlbVar5 = (zzlb) zzkmVar;
                    int zzj22 = zzis.zzj(bArr, r45, zzirVar);
                    int r211 = zzirVar.zza + zzj22;
                    while (zzj22 < r211) {
                        zzj22 = zzis.zzm(bArr, zzj22, zzirVar);
                        zzlbVar5.zzg(zzji.zzc(zzirVar.zzb));
                    }
                    if (zzj22 != r211) {
                        throw zzkp.zzf();
                    }
                    return zzj22;
                }
                if (r23 == 0) {
                    zzlb zzlbVar6 = (zzlb) zzkmVar;
                    int zzm3 = zzis.zzm(bArr, r45, zzirVar);
                    zzlbVar6.zzg(zzji.zzc(zzirVar.zzb));
                    while (zzm3 < r20) {
                        int zzj23 = zzis.zzj(bArr, zzm3, zzirVar);
                        if (r21 == zzirVar.zza) {
                            zzm3 = zzis.zzm(bArr, zzj23, zzirVar);
                            zzlbVar6.zzg(zzji.zzc(zzirVar.zzb));
                        } else {
                            return zzm3;
                        }
                    }
                    return zzm3;
                }
                return r45;
            default:
                if (r23 == 3) {
                    zzlx zzE = zzE(r24);
                    int r6 = (r21 & (-8)) | 4;
                    int zzc = zzis.zzc(zzE, bArr, r19, r20, r6, zzirVar);
                    zzkmVar.add(zzirVar.zzc);
                    while (zzc < r20) {
                        int zzj24 = zzis.zzj(bArr, zzc, zzirVar);
                        if (r21 == zzirVar.zza) {
                            zzc = zzis.zzc(zzE, bArr, zzj24, r20, r6, zzirVar);
                            zzkmVar.add(zzirVar.zzc);
                        } else {
                            return zzc;
                        }
                    }
                    return zzc;
                }
                return r45;
        }
    }

    public final int zzz(int r7, int r8) {
        int[] r0 = this.zzc;
        int length = (r0.length / 3) - 1;
        while (r8 <= length) {
            int r3 = (length + r8) >>> 1;
            int r4 = r3 * 3;
            int r5 = r0[r4];
            if (r7 == r5) {
                return r4;
            }
            if (r7 < r5) {
                length = r3 - 1;
            } else {
                r8 = r3 + 1;
            }
        }
        return -1;
    }
}
