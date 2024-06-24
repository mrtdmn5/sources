package com.polidea.rxandroidble2.internal;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.DaggerClientComponent$ClientComponentImpl;
import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentCache;

/* loaded from: classes3.dex */
public final class RxBleDeviceProvider_Factory implements Provider {
    public final Provider<DeviceComponent.Builder> deviceComponentBuilderProvider;
    public final Provider<DeviceComponentCache> deviceComponentCacheProvider;

    public RxBleDeviceProvider_Factory(Provider provider, DaggerClientComponent$ClientComponentImpl.AnonymousClass1 anonymousClass1) {
        this.deviceComponentCacheProvider = provider;
        this.deviceComponentBuilderProvider = anonymousClass1;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new RxBleDeviceProvider(this.deviceComponentCacheProvider.get(), this.deviceComponentBuilderProvider);
    }
}
