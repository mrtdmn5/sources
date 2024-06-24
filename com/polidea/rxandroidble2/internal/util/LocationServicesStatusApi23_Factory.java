package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideDeviceSdkFactory;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideIsAndroidWearFactory;

/* loaded from: classes3.dex */
public final class LocationServicesStatusApi23_Factory implements Provider {
    public final Provider<CheckerLocationProvider> checkerLocationProvider;
    public final Provider<CheckerScanPermission> checkerScanPermissionProvider;
    public final Provider<Integer> deviceSdkProvider;
    public final Provider<Boolean> isAndroidWearProvider;
    public final Provider<Integer> targetSdkProvider;

    public LocationServicesStatusApi23_Factory(Provider provider, Provider provider2, Provider provider3, ClientComponent_ClientModule_ProvideIsAndroidWearFactory clientComponent_ClientModule_ProvideIsAndroidWearFactory) {
        ClientComponent_ClientModule_ProvideDeviceSdkFactory clientComponent_ClientModule_ProvideDeviceSdkFactory = ClientComponent_ClientModule_ProvideDeviceSdkFactory.InstanceHolder.INSTANCE;
        this.checkerLocationProvider = provider;
        this.checkerScanPermissionProvider = provider2;
        this.targetSdkProvider = provider3;
        this.deviceSdkProvider = clientComponent_ClientModule_ProvideDeviceSdkFactory;
        this.isAndroidWearProvider = clientComponent_ClientModule_ProvideIsAndroidWearFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new LocationServicesStatusApi23(this.checkerLocationProvider.get(), this.checkerScanPermissionProvider.get(), this.targetSdkProvider.get().intValue(), this.deviceSdkProvider.get().intValue(), this.isAndroidWearProvider.get().booleanValue());
    }
}
