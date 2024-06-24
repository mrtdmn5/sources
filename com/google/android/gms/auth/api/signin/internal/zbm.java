package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.base.zau;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public final class zbm {
    public static final Logger zba = new Logger("GoogleSignInCommon", new String[0]);

    public static Intent zbc(Context context, GoogleSignInOptions googleSignInOptions) {
        zba.d("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static void zbh(Context context) {
        zbn.zbc(context).zbd();
        Set set = GoogleApiClient.zaa;
        synchronized (set) {
        }
        Iterator it = set.iterator();
        if (!it.hasNext()) {
            synchronized (GoogleApiManager.zac) {
                GoogleApiManager googleApiManager = GoogleApiManager.zad;
                if (googleApiManager != null) {
                    googleApiManager.zao.incrementAndGet();
                    zau zauVar = googleApiManager.zat;
                    zauVar.sendMessageAtFrontOfQueue(zauVar.obtainMessage(10));
                }
            }
            return;
        }
        ((GoogleApiClient) it.next()).getClass();
        throw new UnsupportedOperationException();
    }
}
