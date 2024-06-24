package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzl implements Runnable {
    public final /* synthetic */ zzo zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzo zzoVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzo zzoVar;
        boolean z;
        zzhx zzhxVar = this.zzb.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzg();
        zzhxVar.zza();
        zzo zzoVar2 = this.zza;
        if (zzoVar2 != null && zzoVar2 != (zzoVar = zzhxVar.zzd)) {
            if (zzoVar == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState("EventInterceptor already set.", z);
        }
        zzhxVar.zzd = zzoVar2;
    }
}
