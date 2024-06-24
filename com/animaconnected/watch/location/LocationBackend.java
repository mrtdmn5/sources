package com.animaconnected.watch.location;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: LocationBackend.kt */
/* loaded from: classes3.dex */
public interface LocationBackend {
    static /* synthetic */ Object getGeoCodedAddress$suspendImpl(LocationBackend locationBackend, Spot spot, Continuation<? super String> continuation) {
        return null;
    }

    default Object getGeoCodedAddress(Spot spot, Continuation<? super String> continuation) {
        return getGeoCodedAddress$suspendImpl(this, spot, continuation);
    }

    boolean getHasLocationPermission();

    void startLocationUpdates(Function1<? super LocationResult, Unit> function1);

    void stopUpdates();
}
