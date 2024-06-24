package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzcv implements ListenerHolder.Notifier {
    public final /* synthetic */ zzcw zza;

    public zzcv(zzcw zzcwVar) {
        this.zza = zzcwVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(Object obj) {
        ListenerHolder.ListenerKey listenerKey;
        zzbo zzboVar = (zzbo) this.zza.zza;
        synchronized (zzboVar) {
            zzboVar.zzd = false;
            listenerKey = zzboVar.zzc.zac;
        }
        if (listenerKey != null) {
            zzboVar.zza.doUnregisterEventListener(listenerKey, 2441);
        }
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
