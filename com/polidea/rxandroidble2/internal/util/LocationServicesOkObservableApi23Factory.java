package com.polidea.rxandroidble2.internal.util;

import android.annotation.TargetApi;
import android.content.Context;

@TargetApi(19)
/* loaded from: classes3.dex */
public final class LocationServicesOkObservableApi23Factory {
    public final Context context;
    public final LocationServicesStatus locationServicesStatus;

    public LocationServicesOkObservableApi23Factory(Context context, LocationServicesStatus locationServicesStatus) {
        this.context = context;
        this.locationServicesStatus = locationServicesStatus;
    }
}
