package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzec extends zzdu {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ zzbz zzb;
    public final /* synthetic */ zzee zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzec(zzee zzeeVar, Activity activity, zzbz zzbzVar) {
        super(zzeeVar.zza, true);
        this.zzc = zzeeVar;
        this.zza = activity;
        this.zzb = zzbzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() throws RemoteException {
        zzcc zzccVar = this.zzc.zza.zzj;
        Preconditions.checkNotNull(zzccVar);
        zzccVar.onActivitySaveInstanceState(new ObjectWrapper(this.zza), this.zzb, this.zzi);
    }
}
