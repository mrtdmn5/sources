package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzcn extends zzj {
    public final /* synthetic */ Object zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public zzcn(Boolean bool, TaskCompletionSource taskCompletionSource) {
        this.zza = bool;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzk
    public final void zzd(zzg zzgVar) {
        TaskUtil.setResultOrApiException(zzgVar.zzb, this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.location.zzk
    public final void zze() {
    }
}
