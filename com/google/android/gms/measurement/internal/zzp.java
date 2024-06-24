package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzp implements zzgs {
    public final com.google.android.gms.internal.measurement.zzci zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzp(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzci zzciVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzciVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final void onEvent(long j, Bundle bundle, String str, String str2) {
        try {
            this.zza.zze(j, bundle, str, str2);
        } catch (RemoteException e) {
            zzfr zzfrVar = this.zzb.zza;
            if (zzfrVar != null) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzb(e, "Event listener threw exception");
            }
        }
    }
}
