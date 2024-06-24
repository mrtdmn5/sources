package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.signin.zaa;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zact extends com.google.android.gms.signin.internal.zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static final zaa zaa = com.google.android.gms.signin.zad.zac;
    public final Context zab;
    public final Handler zac;
    public final zaa zad = zaa;
    public final Set zae;
    public final ClientSettings zaf;
    public com.google.android.gms.signin.zae zag;
    public zacs zah;

    public zact(Context context, zau zauVar, ClientSettings clientSettings) {
        this.zab = context;
        this.zac = zauVar;
        this.zaf = clientSettings;
        this.zae = clientSettings.zab;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected() {
        this.zag.zad(this);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        ((zabu) this.zah).zae(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int r1) {
        this.zag.disconnect();
    }
}
