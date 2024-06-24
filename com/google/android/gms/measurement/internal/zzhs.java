package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhs implements Runnable {
    public final /* synthetic */ zzai zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzai zze;
    public final /* synthetic */ zzhx zzf;

    public zzhs(zzhx zzhxVar, zzai zzaiVar, int r3, long j, boolean z, zzai zzaiVar2) {
        this.zzf = zzhxVar;
        this.zza = zzaiVar;
        this.zzb = r3;
        this.zzc = j;
        this.zzd = z;
        this.zze = zzaiVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhx zzhxVar = this.zzf;
        zzai zzaiVar = this.zza;
        zzhxVar.zzV(zzaiVar);
        zzhx.zzw(this.zzf, this.zza, this.zzb, this.zzc, false, this.zzd);
        zzpd.zzc();
        if (zzhxVar.zzt.zzk.zzs(null, zzdu.zzam)) {
            zzhx.zzv(zzhxVar, zzaiVar, this.zze);
        }
    }
}
