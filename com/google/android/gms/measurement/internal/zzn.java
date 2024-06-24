package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzn implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzn(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcfVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        AppMeasurementDynamiteService appMeasurementDynamiteService = this.zzb;
        zzlb zzlbVar = appMeasurementDynamiteService.zza.zzp;
        zzfr.zzP(zzlbVar);
        zzfr zzfrVar = appMeasurementDynamiteService.zza;
        if (zzfrVar.zzE != null && zzfrVar.zzE.booleanValue()) {
            z = true;
        } else {
            z = false;
        }
        zzlbVar.zzP(this.zza, z);
    }
}
