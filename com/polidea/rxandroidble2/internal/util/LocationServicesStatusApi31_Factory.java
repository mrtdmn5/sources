package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideIsAndroidWearFactory;

/* loaded from: classes3.dex */
public final class LocationServicesStatusApi31_Factory implements Provider {
    public final Provider<CheckerLocationProvider> checkerLocationProvider;
    public final Provider<CheckerScanPermission> checkerScanPermissionProvider;
    public final Provider<Boolean> isAndroidWearProvider;
    public final Provider<Boolean> isNearbyPermissionNeverForLocProvider;

    public LocationServicesStatusApi31_Factory(Provider provider, Provider provider2, ClientComponent_ClientModule_ProvideIsAndroidWearFactory clientComponent_ClientModule_ProvideIsAndroidWearFactory, Provider provider3) {
        this.checkerLocationProvider = provider;
        this.checkerScanPermissionProvider = provider2;
        this.isAndroidWearProvider = clientComponent_ClientModule_ProvideIsAndroidWearFactory;
        this.isNearbyPermissionNeverForLocProvider = provider3;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new LocationServicesStatusApi31(this.checkerLocationProvider.get(), this.checkerScanPermissionProvider.get(), this.isAndroidWearProvider.get().booleanValue(), this.isNearbyPermissionNeverForLocProvider.get().booleanValue());
    }
}
