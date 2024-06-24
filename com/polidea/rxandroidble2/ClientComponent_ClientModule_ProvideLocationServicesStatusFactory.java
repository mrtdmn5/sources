package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideDeviceSdkFactory;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi18;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi18_Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi23;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi31;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideLocationServicesStatusFactory implements Provider {
    public final Provider<Integer> deviceSdkProvider;
    public final Provider<LocationServicesStatusApi18> locationServicesStatusApi18Provider;
    public final Provider<LocationServicesStatusApi23> locationServicesStatusApi23Provider;
    public final Provider<LocationServicesStatusApi31> locationServicesStatusApi31Provider;

    public ClientComponent_ClientModule_ProvideLocationServicesStatusFactory(Provider provider, Provider provider2) {
        ClientComponent_ClientModule_ProvideDeviceSdkFactory clientComponent_ClientModule_ProvideDeviceSdkFactory = ClientComponent_ClientModule_ProvideDeviceSdkFactory.InstanceHolder.INSTANCE;
        LocationServicesStatusApi18_Factory locationServicesStatusApi18_Factory = LocationServicesStatusApi18_Factory.InstanceHolder.INSTANCE;
        this.deviceSdkProvider = clientComponent_ClientModule_ProvideDeviceSdkFactory;
        this.locationServicesStatusApi18Provider = locationServicesStatusApi18_Factory;
        this.locationServicesStatusApi23Provider = provider;
        this.locationServicesStatusApi31Provider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        LocationServicesStatusApi31 locationServicesStatusApi31;
        int intValue = this.deviceSdkProvider.get().intValue();
        if (intValue < 23) {
            locationServicesStatusApi31 = this.locationServicesStatusApi18Provider.get();
        } else if (intValue < 31) {
            locationServicesStatusApi31 = this.locationServicesStatusApi23Provider.get();
        } else {
            locationServicesStatusApi31 = this.locationServicesStatusApi31Provider.get();
        }
        UnsignedKt.checkNotNullFromProvides(locationServicesStatusApi31);
        return locationServicesStatusApi31;
    }
}
