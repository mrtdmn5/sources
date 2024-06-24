package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgm extends zzkf implements zzln {
    private static final zzgm zza;
    private int zzd;
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        zzgm zzgmVar = new zzgm();
        zza = zzgmVar;
        zzkf.zzbL(zzgm.class, zzgmVar);
    }

    public static zzgl zzd$1() {
        return (zzgl) zza.zzbx();
    }

    public static /* synthetic */ void zzh(zzgm zzgmVar, long j) {
        zzgmVar.zzd |= 1;
        zzgmVar.zze = j;
    }

    public static /* synthetic */ void zzi(zzgm zzgmVar, String str) {
        str.getClass();
        zzgmVar.zzd |= 2;
        zzgmVar.zzf = str;
    }

    public static /* synthetic */ void zzj(zzgm zzgmVar, String str) {
        str.getClass();
        zzgmVar.zzd |= 4;
        zzgmVar.zzg = str;
    }

    public static /* synthetic */ void zzk(zzgm zzgmVar) {
        zzgmVar.zzd &= -5;
        zzgmVar.zzg = zza.zzg;
    }

    public static /* synthetic */ void zzm(zzgm zzgmVar, long j) {
        zzgmVar.zzd |= 8;
        zzgmVar.zzh = j;
    }

    public static /* synthetic */ void zzn(zzgm zzgmVar) {
        zzgmVar.zzd &= -9;
        zzgmVar.zzh = 0L;
    }

    public static /* synthetic */ void zzo(zzgm zzgmVar, double d) {
        zzgmVar.zzd |= 32;
        zzgmVar.zzj = d;
    }

    public static /* synthetic */ void zzp(zzgm zzgmVar) {
        zzgmVar.zzd &= -33;
        zzgmVar.zzj = 0.0d;
    }

    public final double zza() {
        return this.zzj;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final long zzc() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r8) {
        int r82 = r8 - 1;
        if (r82 != 0) {
            if (r82 != 2) {
                if (r82 != 3) {
                    if (r82 != 4) {
                        if (r82 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzgl(0);
                }
                return new zzgm();
            }
            return new zzlw(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }

    public final boolean zzq() {
        if ((this.zzd & 32) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzr() {
        if ((this.zzd & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzs() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzt() {
        if ((this.zzd & 4) != 0) {
            return true;
        }
        return false;
    }
}
