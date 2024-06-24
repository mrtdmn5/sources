package com.polidea.rxandroidble2.internal.util;

import android.content.Context;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideLocationServicesStatusFactory;

/* loaded from: classes3.dex */
public final class LocationServicesOkObservableApi23Factory_Factory implements Provider {
    public final Provider<Context> contextProvider;
    public final Provider<LocationServicesStatus> locationServicesStatusProvider;

    public LocationServicesOkObservableApi23Factory_Factory(Provider provider, ClientComponent_ClientModule_ProvideLocationServicesStatusFactory clientComponent_ClientModule_ProvideLocationServicesStatusFactory) {
        this.contextProvider = provider;
        this.locationServicesStatusProvider = clientComponent_ClientModule_ProvideLocationServicesStatusFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new LocationServicesOkObservableApi23Factory(this.contextProvider.get(), this.locationServicesStatusProvider.get());
    }
}
