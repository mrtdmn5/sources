package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzft extends zzkf implements zzln {
    private static final zzft zza;
    private int zzd;
    private zzkm zze = zzlv.zza;
    private String zzf = "";
    private long zzg;
    private long zzh;
    private int zzi;

    static {
        zzft zzftVar = new zzft();
        zza = zzftVar;
        zzkf.zzbL(zzft.class, zzftVar);
    }

    public static zzfs zze() {
        return (zzfs) zza.zzbx();
    }

    public static /* synthetic */ void zzj(zzft zzftVar, int r1, zzfx zzfxVar) {
        zzftVar.zzv();
        zzftVar.zze.set(r1, zzfxVar);
    }

    public static /* synthetic */ void zzk(zzft zzftVar, zzfx zzfxVar) {
        zzftVar.zzv();
        zzftVar.zze.add(zzfxVar);
    }

    public static /* synthetic */ void zzm(zzft zzftVar, Iterable iterable) {
        zzftVar.zzv();
        zzio.zzbt(iterable, zzftVar.zze);
    }

    public static void zzn(zzft zzftVar) {
        zzftVar.zze = zzlv.zza;
    }

    public static /* synthetic */ void zzo(zzft zzftVar, int r1) {
        zzftVar.zzv();
        zzftVar.zze.remove(r1);
    }

    public static /* synthetic */ void zzp(zzft zzftVar, String str) {
        str.getClass();
        zzftVar.zzd |= 1;
        zzftVar.zzf = str;
    }

    public static /* synthetic */ void zzq(long j, zzft zzftVar) {
        zzftVar.zzd |= 2;
        zzftVar.zzg = j;
    }

    public static /* synthetic */ void zzr(long j, zzft zzftVar) {
        zzftVar.zzd |= 4;
        zzftVar.zzh = j;
    }

    public final int zza() {
        return this.zzi;
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final long zzc() {
        return this.zzh;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final zzfx zzg(int r2) {
        return (zzfx) this.zze.get(r2);
    }

    public final String zzh() {
        return this.zzf;
    }

    public final zzkm zzi() {
        return this.zze;
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
                    return new zzfs(0);
                }
                return new zzft();
            }
            return new zzlw(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzd", "zze", zzfx.class, "zzf", "zzg", "zzh", "zzi"});
        }
        return (byte) 1;
    }

    public final boolean zzs() {
        if ((this.zzd & 8) != 0) {
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

    public final boolean zzu() {
        if ((this.zzd & 2) != 0) {
            return true;
        }
        return false;
    }

    public final void zzv() {
        zzkm zzkmVar = this.zze;
        if (!zzkmVar.zzc()) {
            this.zze = zzkf.zzbF(zzkmVar);
        }
    }
}
