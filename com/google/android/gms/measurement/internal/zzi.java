package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzi implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcfVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjm zzt = this.zzb.zza.zzt();
        zzt.zzg();
        zzt.zza();
        zzt.zzR(new zzis(zzt, zzt.zzO(false), this.zza));
    }
}
