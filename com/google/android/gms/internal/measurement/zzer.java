package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzer extends zzkf implements zzln {
    private static final zzer zza;
    private int zzd;
    private int zze;
    private boolean zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzer zzerVar = new zzer();
        zza = zzerVar;
        zzkf.zzbL(zzer.class, zzerVar);
    }

    public static zzer zzb() {
        return zza;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final String zzd() {
        return this.zzi;
    }

    public final String zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzh() {
        if ((this.zzd & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzi() {
        if ((this.zzd & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzj() {
        if ((this.zzd & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzk() {
        if ((this.zzd & 8) != 0) {
            return true;
        }
        return false;
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
                    return new zzen();
                }
                return new zzer();
            }
            return new zzlw(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzd", "zze", zzep.zza, "zzf", "zzg", "zzh", "zzi"});
        }
        return (byte) 1;
    }

    public final int zzm() {
        int r2;
        int r0 = this.zze;
        if (r0 != 0) {
            r2 = 2;
            if (r0 != 1) {
                if (r0 != 2) {
                    r2 = 4;
                    if (r0 != 3) {
                        if (r0 != 4) {
                            r2 = 0;
                        } else {
                            r2 = 5;
                        }
                    }
                } else {
                    r2 = 3;
                }
            }
        } else {
            r2 = 1;
        }
        if (r2 == 0) {
            return 1;
        }
        return r2;
    }
}
