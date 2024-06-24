package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzdg extends zzdu {
    public final /* synthetic */ String zza = "Error with data collection. Data lost.";
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ zzef zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdg(zzef zzefVar, Object obj) {
        super(zzefVar, false);
        this.zzc = zzefVar;
        this.zzb = obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() throws RemoteException {
        zzcc zzccVar = this.zzc.zzj;
        Preconditions.checkNotNull(zzccVar);
        zzccVar.logHealthData(5, this.zza, new ObjectWrapper(this.zzb), new ObjectWrapper(null), new ObjectWrapper(null));
    }
}
