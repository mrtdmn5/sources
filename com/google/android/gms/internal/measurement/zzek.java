package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzek extends zzkf implements zzln {
    private static final zzek zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzkm zzg = zzlv.zza;
    private boolean zzh;
    private zzer zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzek zzekVar = new zzek();
        zza = zzekVar;
        zzkf.zzbL(zzek.class, zzekVar);
    }

    public static zzej zzc$1() {
        return (zzej) zza.zzbx();
    }

    public static /* synthetic */ void zzi(zzek zzekVar, String str) {
        zzekVar.zzd |= 2;
        zzekVar.zzf = str;
    }

    public static /* synthetic */ void zzj(zzek zzekVar, int r3, zzem zzemVar) {
        zzkm zzkmVar = zzekVar.zzg;
        if (!zzkmVar.zzc()) {
            zzekVar.zzg = zzkf.zzbF(zzkmVar);
        }
        zzekVar.zzg.set(r3, zzemVar);
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final zzem zze(int r2) {
        return (zzem) this.zzg.get(r2);
    }

    public final zzer zzf() {
        zzer zzerVar = this.zzi;
        if (zzerVar == null) {
            return zzer.zzb();
        }
        return zzerVar;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final zzkm zzh() {
        return this.zzg;
    }

    public final boolean zzk() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r11) {
        int r112 = r11 - 1;
        if (r112 != 0) {
            if (r112 != 2) {
                if (r112 != 3) {
                    if (r112 != 4) {
                        if (r112 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzej(0);
                }
                return new zzek();
            }
            return new zzlw(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", zzem.class, "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        return (byte) 1;
    }

    public final boolean zzm() {
        return this.zzk;
    }

    public final boolean zzn() {
        return this.zzl;
    }

    public final boolean zzo() {
        if ((this.zzd & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzp() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzq() {
        if ((this.zzd & 64) != 0) {
            return true;
        }
        return false;
    }
}
