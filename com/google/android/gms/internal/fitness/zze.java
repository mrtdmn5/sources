package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.fitness.zzf;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public abstract class zze extends GmsClient {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zze(int r9, Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings) {
        super(r9 - 2, context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings);
        if (r9 != 1) {
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return zzf.zzc;
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.api.Api.Client
    public final Set getScopesForConnectionlessNonSignIn() {
        return this.zac;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean requiresAccount() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        if (!DeviceProperties.isWearable(this.zzl)) {
            return true;
        }
        return false;
    }
}
