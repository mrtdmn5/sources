package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.IAccountAccessor;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zabt implements Runnable {
    public final /* synthetic */ ConnectionResult zaa;
    public final /* synthetic */ zabu zab;

    public zabt(zabu zabuVar, ConnectionResult connectionResult) {
        this.zab = zabuVar;
        this.zaa = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAccountAccessor iAccountAccessor;
        zabu zabuVar = this.zab;
        zabq zabqVar = (zabq) zabuVar.zaa.zap.get(zabuVar.zac);
        if (zabqVar == null) {
            return;
        }
        ConnectionResult connectionResult = this.zaa;
        if (connectionResult.isSuccess()) {
            zabuVar.zaf = true;
            Api.Client client = zabuVar.zab;
            if (client.requiresSignIn()) {
                if (zabuVar.zaf && (iAccountAccessor = zabuVar.zad) != null) {
                    client.getRemoteService(iAccountAccessor, zabuVar.zae);
                    return;
                }
                return;
            }
            try {
                client.getRemoteService(null, client.getScopesForConnectionlessNonSignIn());
                return;
            } catch (SecurityException e) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
                client.disconnect("Failed to get service from broker.");
                zabqVar.zar(new ConnectionResult(10), null);
                return;
            }
        }
        zabqVar.zar(connectionResult, null);
    }
}
