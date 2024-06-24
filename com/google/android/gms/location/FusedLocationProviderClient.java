package com.google.android.gms.location;

import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public interface FusedLocationProviderClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    com.google.android.gms.tasks.zzw getLastLocation();

    Task<Void> removeLocationUpdates(LocationCallback locationCallback);

    com.google.android.gms.tasks.zzw requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper);
}
