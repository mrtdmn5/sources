package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzeb extends zzdu {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ zzee zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeb(zzee zzeeVar, Activity activity) {
        super(zzeeVar.zza, true);
        this.zzb = zzeeVar;
        this.zza = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() throws RemoteException {
        zzcc zzccVar = this.zzb.zza.zzj;
        Preconditions.checkNotNull(zzccVar);
        zzccVar.onActivityStopped(new ObjectWrapper(this.zza), this.zzi);
    }
}
