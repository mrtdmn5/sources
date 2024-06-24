package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.zzq;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzcw extends zzq {
    public final zzcs zza;

    public zzcw(zzbo zzboVar) {
        this.zza = zzboVar;
    }

    @Override // com.google.android.gms.location.zzr
    public final void zzf() {
        ListenerHolder listenerHolder;
        zzbo zzboVar = (zzbo) this.zza;
        synchronized (zzboVar) {
            listenerHolder = zzboVar.zzc;
        }
        listenerHolder.notifyListener(new zzcv(this));
    }
}
