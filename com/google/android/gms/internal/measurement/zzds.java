package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzds extends zzdu {
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ Bundle zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzef zzg;
    public final /* synthetic */ Long zza = null;
    public final /* synthetic */ boolean zzf = true;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzds(zzef zzefVar, String str, String str2, Bundle bundle, boolean z) {
        super(zzefVar, true);
        this.zzg = zzefVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bundle;
        this.zze = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() throws RemoteException {
        long longValue;
        Long l = this.zza;
        if (l == null) {
            longValue = this.zzh;
        } else {
            longValue = l.longValue();
        }
        zzcc zzccVar = this.zzg.zzj;
        Preconditions.checkNotNull(zzccVar);
        zzccVar.logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, longValue);
    }
}
