package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzot implements zzos {
    public static final zzhv zza;
    public static final zzhw zzb;
    public static final zzhu zzc;
    public static final zzhu zzd;
    public static final zzhx zze;

    static {
        zzhy zzhyVar = new zzhy(zzhq.zza(), false, true);
        zza = zzhyVar.zzf("measurement.test.boolean_flag", false);
        zzb = new zzhw(zzhyVar, Double.valueOf(-3.0d));
        zzc = zzhyVar.zzd(-2L, "measurement.test.int_flag");
        zzd = zzhyVar.zzd(-1L, "measurement.test.long_flag");
        zze = new zzhx(zzhyVar, "measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.zzos
    public final double zza() {
        return ((Double) zzb.zzb()).doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzos
    public final long zzb() {
        return ((Long) zzc.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzos
    public final long zzc() {
        return ((Long) zzd.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzos
    public final String zzd() {
        return (String) zze.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzos
    public final boolean zze() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
