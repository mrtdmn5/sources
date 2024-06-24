package com.polidea.rxandroidble2.internal.util;

import android.content.ContentResolver;
import android.location.LocationManager;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideContentResolverFactory;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideLocationManagerFactory;

/* loaded from: classes3.dex */
public final class CheckerLocationProvider_Factory implements Provider {
    public final Provider<ContentResolver> contentResolverProvider;
    public final Provider<LocationManager> locationManagerProvider;

    public CheckerLocationProvider_Factory(ClientComponent_ClientModule_ProvideContentResolverFactory clientComponent_ClientModule_ProvideContentResolverFactory, ClientComponent_ClientModule_ProvideLocationManagerFactory clientComponent_ClientModule_ProvideLocationManagerFactory) {
        this.contentResolverProvider = clientComponent_ClientModule_ProvideContentResolverFactory;
        this.locationManagerProvider = clientComponent_ClientModule_ProvideLocationManagerFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new CheckerLocationProvider(this.contentResolverProvider.get(), this.locationManagerProvider.get());
    }
}
