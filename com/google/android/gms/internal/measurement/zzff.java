package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzff extends zzkf implements zzln {
    private static final zzff zza;
    private int zzd;
    private long zze;
    private String zzf = "";
    private int zzg;
    private zzkm zzh;
    private zzkm zzi;
    private zzkm zzj;
    private String zzk;
    private boolean zzl;
    private zzkm zzm;
    private zzkm zzn;
    private String zzo;

    static {
        zzff zzffVar = new zzff();
        zza = zzffVar;
        zzkf.zzbL(zzff.class, zzffVar);
    }

    public zzff() {
        zzlv zzlvVar = zzlv.zza;
        this.zzh = zzlvVar;
        this.zzi = zzlvVar;
        this.zzj = zzlvVar;
        this.zzk = "";
        this.zzm = zzlvVar;
        this.zzn = zzlvVar;
        this.zzo = "";
    }

    public static zzfe zze() {
        return (zzfe) zza.zzbx();
    }

    public static zzff zzg() {
        return zza;
    }

    public static /* synthetic */ void zzo(zzff zzffVar, int r3, zzfd zzfdVar) {
        zzkm zzkmVar = zzffVar.zzi;
        if (!zzkmVar.zzc()) {
            zzffVar.zzi = zzkf.zzbF(zzkmVar);
        }
        zzffVar.zzi.set(r3, zzfdVar);
    }

    public static void zzp(zzff zzffVar) {
        zzffVar.zzj = zzlv.zza;
    }

    public final int zza() {
        return this.zzm.size();
    }

    public final int zzb() {
        return this.zzi.size();
    }

    public final long zzc() {
        return this.zze;
    }

    public final zzfd zzd(int r2) {
        return (zzfd) this.zzi.get(r2);
    }

    public final String zzh() {
        return this.zzf;
    }

    public final String zzi() {
        return this.zzo;
    }

    public final zzkm zzj() {
        return this.zzj;
    }

    public final List zzk() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r19) {
        int r0 = r19 - 1;
        if (r0 != 0) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 != 4) {
                        if (r0 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzfe(0);
                }
                return new zzff();
            }
            return new zzlw(zza, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzfj.class, "zzi", zzfd.class, "zzj", zzei.class, "zzk", "zzl", "zzm", zzgt.class, "zzn", zzfb.class, "zzo"});
        }
        return (byte) 1;
    }

    public final zzkm zzm() {
        return this.zzm;
    }

    public final List zzn() {
        return this.zzh;
    }

    public final boolean zzq() {
        return this.zzl;
    }

    public final boolean zzr() {
        if ((this.zzd & 2) != 0) {
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
}
