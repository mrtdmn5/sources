package com.google.android.gms.internal.measurement;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfx extends zzkf implements zzln {
    private static final zzfx zza;
    private int zzd;
    private long zzg;
    private float zzh;
    private double zzi;
    private String zze = "";
    private String zzf = "";
    private zzkm zzj = zzlv.zza;

    static {
        zzfx zzfxVar = new zzfx();
        zza = zzfxVar;
        zzkf.zzbL(zzfx.class, zzfxVar);
    }

    public static zzfw zze$1() {
        return (zzfw) zza.zzbx();
    }

    public static /* synthetic */ void zzj(zzfx zzfxVar, String str) {
        str.getClass();
        zzfxVar.zzd |= 1;
        zzfxVar.zze = str;
    }

    public static /* synthetic */ void zzk(zzfx zzfxVar, String str) {
        str.getClass();
        zzfxVar.zzd |= 2;
        zzfxVar.zzf = str;
    }

    public static /* synthetic */ void zzm(zzfx zzfxVar) {
        zzfxVar.zzd &= -3;
        zzfxVar.zzf = zza.zzf;
    }

    public static /* synthetic */ void zzn(zzfx zzfxVar, long j) {
        zzfxVar.zzd |= 4;
        zzfxVar.zzg = j;
    }

    public static /* synthetic */ void zzo(zzfx zzfxVar) {
        zzfxVar.zzd &= -5;
        zzfxVar.zzg = 0L;
    }

    public static /* synthetic */ void zzp(zzfx zzfxVar, double d) {
        zzfxVar.zzd |= 16;
        zzfxVar.zzi = d;
    }

    public static /* synthetic */ void zzq(zzfx zzfxVar) {
        zzfxVar.zzd &= -17;
        zzfxVar.zzi = 0.0d;
    }

    public static void zzr(zzfx zzfxVar, zzfx zzfxVar2) {
        zzkm zzkmVar = zzfxVar.zzj;
        if (!zzkmVar.zzc()) {
            zzfxVar.zzj = zzkf.zzbF(zzkmVar);
        }
        zzfxVar.zzj.add(zzfxVar2);
    }

    public static void zzs(zzfx zzfxVar, ArrayList arrayList) {
        zzkm zzkmVar = zzfxVar.zzj;
        if (!zzkmVar.zzc()) {
            zzfxVar.zzj = zzkf.zzbF(zzkmVar);
        }
        zzio.zzbt(arrayList, zzfxVar.zzj);
    }

    public static void zzt(zzfx zzfxVar) {
        zzfxVar.zzj = zzlv.zza;
    }

    public final double zza() {
        return this.zzi;
    }

    public final float zzb() {
        return this.zzh;
    }

    public final int zzc() {
        return this.zzj.size();
    }

    public final long zzd() {
        return this.zzg;
    }

    public final String zzg() {
        return this.zze;
    }

    public final String zzh() {
        return this.zzf;
    }

    public final zzkm zzi() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r9) {
        int r92 = r9 - 1;
        if (r92 != 0) {
            if (r92 != 2) {
                if (r92 != 3) {
                    if (r92 != 4) {
                        if (r92 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzfw(0);
                }
                return new zzfx();
            }
            return new zzlw(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzfx.class});
        }
        return (byte) 1;
    }

    public final boolean zzu() {
        if ((this.zzd & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzv() {
        if ((this.zzd & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzw() {
        if ((this.zzd & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzx() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzy() {
        if ((this.zzd & 2) != 0) {
            return true;
        }
        return false;
    }
}
