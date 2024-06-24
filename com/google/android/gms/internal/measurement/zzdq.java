package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzdq extends zzdu {
    public final /* synthetic */ zzdw zza;
    public final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdq(zzef zzefVar, zzdw zzdwVar) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = zzdwVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() throws RemoteException {
        zzcc zzccVar = this.zzb.zzj;
        Preconditions.checkNotNull(zzccVar);
        zzccVar.registerOnMeasurementEventListener(this.zza);
    }
}
