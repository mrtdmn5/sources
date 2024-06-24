package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.IStatusCallback$Stub;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzcl extends IStatusCallback$Stub {
    public final /* synthetic */ Object zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public zzcl(Boolean bool, TaskCompletionSource taskCompletionSource) {
        this.zza = bool;
        this.zzb = taskCompletionSource;
    }
}
