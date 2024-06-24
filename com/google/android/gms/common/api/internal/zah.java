package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zah extends zad {
    public final ListenerHolder.ListenerKey zab;

    public zah(ListenerHolder.ListenerKey listenerKey, TaskCompletionSource taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zab = listenerKey;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq zabqVar) {
        zaci zaciVar = (zaci) zabqVar.zag.get(this.zab);
        if (zaciVar != null && zaciVar.zaa.zac) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabq zabqVar) {
        zaci zaciVar = (zaci) zabqVar.zag.get(this.zab);
        if (zaciVar == null) {
            return null;
        }
        return zaciVar.zaa.zab;
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void zac(zabq zabqVar) throws RemoteException {
        zaci zaciVar = (zaci) zabqVar.zag.remove(this.zab);
        TaskCompletionSource taskCompletionSource = this.zaa;
        if (zaciVar != null) {
            ((zacl) zaciVar.zab).zaa.zab.accept(zabqVar.zac, taskCompletionSource);
            ListenerHolder listenerHolder = zaciVar.zaa.zaa;
            listenerHolder.zab = null;
            listenerHolder.zac = null;
            return;
        }
        taskCompletionSource.trySetResult(Boolean.FALSE);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void zag(zaad zaadVar, boolean z) {
    }
}
