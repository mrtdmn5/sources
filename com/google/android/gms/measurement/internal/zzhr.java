package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhr implements Runnable {
    public final /* synthetic */ zzai zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzai zzf;
    public final /* synthetic */ zzhx zzg;

    public zzhr(zzhx zzhxVar, zzai zzaiVar, long j, int r5, long j2, boolean z, zzai zzaiVar2) {
        this.zzg = zzhxVar;
        this.zza = zzaiVar;
        this.zzb = j;
        this.zzc = r5;
        this.zzd = j2;
        this.zze = z;
        this.zzf = zzaiVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhx zzhxVar = this.zzg;
        zzai zzaiVar = this.zza;
        zzhxVar.zzV(zzaiVar);
        zzhxVar.zzL(this.zzb, false);
        zzhx.zzw(this.zzg, this.zza, this.zzc, this.zzd, true, this.zze);
        zzpd.zzc();
        if (zzhxVar.zzt.zzk.zzs(null, zzdu.zzam)) {
            zzhx.zzv(zzhxVar, zzaiVar, this.zzf);
        }
    }
}
