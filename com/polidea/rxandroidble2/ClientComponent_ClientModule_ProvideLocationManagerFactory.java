package com.polidea.rxandroidble2;

import android.content.Context;
import android.location.LocationManager;
import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideLocationManagerFactory implements Provider {
    public final Provider<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideLocationManagerFactory(InstanceFactory instanceFactory) {
        this.contextProvider = instanceFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        LocationManager locationManager = (LocationManager) this.contextProvider.get().getSystemService("location");
        UnsignedKt.checkNotNullFromProvides(locationManager);
        return locationManager;
    }
}
