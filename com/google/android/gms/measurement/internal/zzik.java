package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzik implements Runnable {
    public final /* synthetic */ zzie zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzim zzc;

    public zzik(zzim zzimVar, zzie zzieVar, long j) {
        this.zzc = zzimVar;
        this.zza = zzieVar;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzie zzieVar = this.zza;
        long j = this.zzb;
        zzim zzimVar = this.zzc;
        zzimVar.zzB(zzieVar, false, j);
        zzimVar.zza = null;
        zzjm zzt = zzimVar.zzt.zzt();
        zzt.zzg();
        zzt.zza();
        zzt.zzR(new zziu(zzt, null));
    }
}
