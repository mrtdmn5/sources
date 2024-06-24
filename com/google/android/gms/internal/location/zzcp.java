package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.zzr;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzcp extends zzj {
    public final /* synthetic */ TaskCompletionSource zza;
    public final /* synthetic */ zzr zzb;

    public zzcp(TaskCompletionSource taskCompletionSource, zzcw zzcwVar) {
        this.zza = taskCompletionSource;
        this.zzb = zzcwVar;
    }

    @Override // com.google.android.gms.internal.location.zzk
    public final void zzd(zzg zzgVar) {
        TaskUtil.setResultOrApiException(zzgVar.zzb, null, this.zza);
    }

    @Override // com.google.android.gms.internal.location.zzk
    public final void zze() throws RemoteException {
        this.zzb.zzf();
    }
}
