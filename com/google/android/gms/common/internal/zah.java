package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zah implements BaseGmsClient.BaseConnectionCallbacks {
    public final /* synthetic */ ConnectionCallbacks zaa;

    public zah(ConnectionCallbacks connectionCallbacks) {
        this.zaa = connectionCallbacks;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected() {
        this.zaa.onConnected();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int r2) {
        this.zaa.onConnectionSuspended(r2);
    }
}
