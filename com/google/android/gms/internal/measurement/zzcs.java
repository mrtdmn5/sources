package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzcs extends zzdu {
    public final /* synthetic */ Boolean zza;
    public final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcs(zzef zzefVar, Boolean bool) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = bool;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() throws RemoteException {
        if (this.zza != null) {
            zzcc zzccVar = this.zzb.zzj;
            Preconditions.checkNotNull(zzccVar);
            zzccVar.setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
        } else {
            zzcc zzccVar2 = this.zzb.zzj;
            Preconditions.checkNotNull(zzccVar2);
            zzccVar2.clearMeasurementEnabled(this.zzh);
        }
    }
}
