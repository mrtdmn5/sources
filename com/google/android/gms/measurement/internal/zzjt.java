package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjt {
    public final Context zza;

    public zzjt(Context context) {
        Preconditions.checkNotNull(context);
        this.zza = context;
    }

    public final void zzg(Intent intent) {
        if (intent == null) {
            zzk().zzd.zza("onRebind called with null intent");
        } else {
            zzk().zzl.zzb(intent.getAction(), "onRebind called. action");
        }
    }

    public final void zzj(Intent intent) {
        if (intent == null) {
            zzk().zzd.zza("onUnbind called with null intent");
        } else {
            zzk().zzl.zzb(intent.getAction(), "onUnbind called for intent. action");
        }
    }

    public final zzeh zzk() {
        zzeh zzehVar = zzfr.zzp(this.zza, null, null).zzm;
        zzfr.zzR(zzehVar);
        return zzehVar;
    }
}
