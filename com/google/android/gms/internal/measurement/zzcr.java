package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzcr extends zzdu {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzef zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcr(zzef zzefVar, Activity activity, String str, String str2) {
        super(zzefVar, true);
        this.zzd = zzefVar;
        this.zza = activity;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() throws RemoteException {
        zzcc zzccVar = this.zzd.zzj;
        Preconditions.checkNotNull(zzccVar);
        zzccVar.setCurrentScreen(new ObjectWrapper(this.zza), this.zzb, this.zzc, this.zzh);
    }
}
