package com.google.android.gms.fitness;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.fitness.zzbh;
import org.slf4j.helpers.NormalizedParameters;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class SessionsClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    static {
        new NormalizedParameters();
    }

    public SessionsClient(Context context, zzi zziVar) {
        super(context, zzbh.zzg, zziVar, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
