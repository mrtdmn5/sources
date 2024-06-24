package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.zzm;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzbo implements RemoteCall, zzcs {
    public final /* synthetic */ zzbp zza;
    public ListenerHolder zzc;
    public boolean zzd = true;

    public zzbo(zzbp zzbpVar, ListenerHolder listenerHolder) {
        this.zza = zzbpVar;
        this.zzc = listenerHolder;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Api.Client client, Object obj) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey;
        boolean z;
        ListenerHolder listenerHolder;
        zzda zzdaVar = (zzda) client;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj;
        synchronized (this) {
            listenerKey = this.zzc.zac;
            z = this.zzd;
            ListenerHolder listenerHolder2 = this.zzc;
            listenerHolder2.zab = null;
            listenerHolder2.zac = null;
        }
        if (listenerKey == null) {
            taskCompletionSource.setResult(Boolean.FALSE);
            return;
        }
        synchronized (zzdaVar.zzg) {
            zzcw zzcwVar = (zzcw) zzdaVar.zzg.remove(listenerKey);
            if (zzcwVar == null) {
                taskCompletionSource.setResult(Boolean.FALSE);
                return;
            }
            zzbo zzboVar = (zzbo) zzcwVar.zza;
            synchronized (zzboVar) {
                listenerHolder = zzboVar.zzc;
            }
            listenerHolder.zab = null;
            listenerHolder.zac = null;
            if (z) {
                if (zzdaVar.zzE(zzm.zzj)) {
                    ((zzo) zzdaVar.getService()).zzy(new zzdb(2, null, zzcwVar, null, null, null), new zzcl(Boolean.TRUE, taskCompletionSource));
                } else {
                    ((zzo) zzdaVar.getService()).zzz(new zzdf(2, null, null, zzcwVar, null, new zzcn(Boolean.TRUE, taskCompletionSource), null));
                }
            } else {
                taskCompletionSource.setResult(Boolean.TRUE);
            }
        }
    }
}
