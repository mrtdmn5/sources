package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zaab implements PendingResult.StatusListener {
    public final /* synthetic */ BasePendingResult zaa;
    public final /* synthetic */ zaad zab;

    public zaab(zaad zaadVar, BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        this.zab = zaadVar;
        this.zaa = baseImplementation$ApiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        this.zab.zaa.remove(this.zaa);
    }
}
