package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzda extends zzdu {
    public final /* synthetic */ zzbz zza;
    public final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzda(zzef zzefVar, zzbz zzbzVar) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = zzbzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() throws RemoteException {
        zzcc zzccVar = this.zzb.zzj;
        Preconditions.checkNotNull(zzccVar);
        zzccVar.getGmpAppId(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zzb() {
        this.zza.zze(null);
    }
}
