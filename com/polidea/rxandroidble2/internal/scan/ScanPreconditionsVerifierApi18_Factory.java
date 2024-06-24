package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;

/* loaded from: classes3.dex */
public final class ScanPreconditionsVerifierApi18_Factory implements Provider {
    public final Provider<LocationServicesStatus> locationServicesStatusProvider;
    public final Provider<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;

    public ScanPreconditionsVerifierApi18_Factory(Provider<RxBleAdapterWrapper> provider, Provider<LocationServicesStatus> provider2) {
        this.rxBleAdapterWrapperProvider = provider;
        this.locationServicesStatusProvider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ScanPreconditionsVerifierApi18(this.rxBleAdapterWrapperProvider.get(), this.locationServicesStatusProvider.get());
    }
}
