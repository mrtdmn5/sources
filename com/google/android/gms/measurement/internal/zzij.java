package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzij implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzim zzb;

    public zzij(zzim zzimVar, long j) {
        this.zzb = zzimVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzim zzimVar = this.zzb;
        zzimVar.zzt.zzd().zzf(this.zza);
        zzimVar.zza = null;
    }
}
