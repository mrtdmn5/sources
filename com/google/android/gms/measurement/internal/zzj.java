package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzj implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ zzaw zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ AppMeasurementDynamiteService zzd;

    public zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcfVar, zzaw zzawVar, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzcfVar;
        this.zzb = zzawVar;
        this.zzc = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjm zzt = this.zzd.zza.zzt();
        zzt.zzg();
        zzt.zza();
        zzfr zzfrVar = zzt.zzt;
        zzlb zzlbVar = zzfrVar.zzp;
        zzfr.zzP(zzlbVar);
        zzlbVar.getClass();
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(zzlbVar.zzt.zze, 12451000);
        zzcf zzcfVar = this.zza;
        if (isGooglePlayServicesAvailable != 0) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zza("Not bundling data. Service unavailable or out of date");
            zzlb zzlbVar2 = zzfrVar.zzp;
            zzfr.zzP(zzlbVar2);
            zzlbVar2.zzS(zzcfVar, new byte[0]);
            return;
        }
        zzt.zzR(new zzix(zzt, this.zzb, this.zzc, zzcfVar));
    }
}
