package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzcn extends zzdu {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcn(zzef zzefVar, Bundle bundle) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() throws RemoteException {
        zzcc zzccVar = this.zzb.zzj;
        Preconditions.checkNotNull(zzccVar);
        zzccVar.setConditionalUserProperty(this.zza, this.zzh);
    }
}
