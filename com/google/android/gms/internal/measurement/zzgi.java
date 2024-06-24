package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgi extends zzkf implements zzln {
    private static final zzgi zza;
    private zzkl zzd;
    private zzkl zze;
    private zzkm zzf;
    private zzkm zzg;

    static {
        zzgi zzgiVar = new zzgi();
        zza = zzgiVar;
        zzkf.zzbL(zzgi.class, zzgiVar);
    }

    public zzgi() {
        zzlb zzlbVar = zzlb.zza;
        this.zzd = zzlbVar;
        this.zze = zzlbVar;
        zzlv zzlvVar = zzlv.zza;
        this.zzf = zzlvVar;
        this.zzg = zzlvVar;
    }

    public static zzgh zzf() {
        return (zzgh) zza.zzbx();
    }

    public static zzgi zzh() {
        return zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void zzo(zzgi zzgiVar, List list) {
        zzkl zzklVar = zzgiVar.zzd;
        if (!((zzip) zzklVar).zza) {
            zzgiVar.zzd = zzkf.zzbD(zzklVar);
        }
        zzio.zzbt(list, zzgiVar.zzd);
    }

    public static void zzp(zzgi zzgiVar) {
        zzgiVar.zzd = zzlb.zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void zzq(zzgi zzgiVar, List list) {
        zzkl zzklVar = zzgiVar.zze;
        if (!((zzip) zzklVar).zza) {
            zzgiVar.zze = zzkf.zzbD(zzklVar);
        }
        zzio.zzbt(list, zzgiVar.zze);
    }

    public static void zzr(zzgi zzgiVar) {
        zzgiVar.zze = zzlb.zza;
    }

    public static /* synthetic */ void zzs(zzgi zzgiVar, ArrayList arrayList) {
        zzgiVar.zzy$1();
        zzio.zzbt(arrayList, zzgiVar.zzf);
    }

    public static void zzt(zzgi zzgiVar) {
        zzgiVar.zzf = zzlv.zza;
    }

    public static /* synthetic */ void zzu(zzgi zzgiVar, int r1) {
        zzgiVar.zzy$1();
        zzgiVar.zzf.remove(r1);
    }

    public static void zzv(zzgi zzgiVar, List list) {
        zzkm zzkmVar = zzgiVar.zzg;
        if (!zzkmVar.zzc()) {
            zzgiVar.zzg = zzkf.zzbF(zzkmVar);
        }
        zzio.zzbt(list, zzgiVar.zzg);
    }

    public static void zzw(zzgi zzgiVar) {
        zzgiVar.zzg = zzlv.zza;
    }

    public static void zzx(zzgi zzgiVar, int r3) {
        zzkm zzkmVar = zzgiVar.zzg;
        if (!zzkmVar.zzc()) {
            zzgiVar.zzg = zzkf.zzbF(zzkmVar);
        }
        zzgiVar.zzg.remove(r3);
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final int zzc() {
        return this.zzg.size();
    }

    public final int zzd() {
        return this.zzd.size();
    }

    public final zzfr zze(int r2) {
        return (zzfr) this.zzf.get(r2);
    }

    public final zzgk zzi(int r2) {
        return (zzgk) this.zzg.get(r2);
    }

    public final zzkm zzj() {
        return this.zzf;
    }

    public final List zzk() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r7) {
        int r72 = r7 - 1;
        if (r72 != 0) {
            if (r72 != 2) {
                if (r72 != 3) {
                    if (r72 != 4) {
                        if (r72 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzgh(0);
                }
                return new zzgi();
            }
            return new zzlw(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzd", "zze", "zzf", zzfr.class, "zzg", zzgk.class});
        }
        return (byte) 1;
    }

    public final zzkm zzm() {
        return this.zzg;
    }

    public final List zzn() {
        return this.zzd;
    }

    public final void zzy$1() {
        zzkm zzkmVar = this.zzf;
        if (!zzkmVar.zzc()) {
            this.zzf = zzkf.zzbF(zzkmVar);
        }
    }
}
