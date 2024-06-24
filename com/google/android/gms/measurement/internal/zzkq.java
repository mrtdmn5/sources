package com.google.android.gms.measurement.internal;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkq {
    public com.google.android.gms.internal.measurement.zzgd zza;
    public ArrayList zzb;
    public ArrayList zzc;
    public long zzd;
    public final /* synthetic */ zzkt zze;

    public /* synthetic */ zzkq(zzkt zzktVar) {
        this.zze = zzktVar;
    }

    public final boolean zza(long j, com.google.android.gms.internal.measurement.zzft zzftVar) {
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (!this.zzc.isEmpty() && ((((com.google.android.gms.internal.measurement.zzft) this.zzc.get(0)).zzd() / 1000) / 60) / 60 != ((zzftVar.zzd() / 1000) / 60) / 60) {
            return false;
        }
        long zzbw = this.zzd + zzftVar.zzbw();
        zzkt zzktVar = this.zze;
        zzktVar.zzg();
        if (zzbw >= Math.max(0, ((Integer) zzdu.zzh.zza(null)).intValue())) {
            return false;
        }
        this.zzd = zzbw;
        this.zzc.add(zzftVar);
        this.zzb.add(Long.valueOf(j));
        int size = this.zzc.size();
        zzktVar.zzg();
        if (size >= Math.max(1, ((Integer) zzdu.zzi.zza(null)).intValue())) {
            return false;
        }
        return true;
    }
}
