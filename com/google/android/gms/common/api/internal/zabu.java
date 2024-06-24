package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zabu implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {
    public final /* synthetic */ GoogleApiManager zaa;
    public final Api.Client zab;
    public final ApiKey zac;
    public IAccountAccessor zad = null;
    public Set zae = null;
    public boolean zaf = false;

    public zabu(GoogleApiManager googleApiManager, Api.Client client, ApiKey apiKey) {
        this.zaa = googleApiManager;
        this.zab = client;
        this.zac = apiKey;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        this.zaa.zat.post(new zabt(this, connectionResult));
    }

    public final void zae(ConnectionResult connectionResult) {
        zabq zabqVar = (zabq) this.zaa.zap.get(this.zac);
        if (zabqVar != null) {
            Preconditions.checkHandlerThread(zabqVar.zaa.zat);
            Api.Client client = zabqVar.zac;
            client.disconnect("onSignInFailed for " + client.getClass().getName() + " with " + String.valueOf(connectionResult));
            zabqVar.zar(connectionResult, null);
        }
    }
}
