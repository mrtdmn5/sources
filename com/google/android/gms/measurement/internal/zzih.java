package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzih implements Runnable {
    public final /* synthetic */ zzie zza;
    public final /* synthetic */ zzie zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzim zze;

    public zzih(zzim zzimVar, zzie zzieVar, zzie zzieVar2, long j, boolean z) {
        this.zze = zzimVar;
        this.zza = zzieVar;
        this.zzb = zzieVar2;
        this.zzc = j;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzA(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
