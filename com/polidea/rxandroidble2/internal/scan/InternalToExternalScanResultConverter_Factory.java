package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;

/* loaded from: classes3.dex */
public final class InternalToExternalScanResultConverter_Factory implements Provider {
    public final Provider<RxBleDeviceProvider> deviceProvider;

    public InternalToExternalScanResultConverter_Factory(Provider<RxBleDeviceProvider> provider) {
        this.deviceProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new InternalToExternalScanResultConverter(this.deviceProvider.get());
    }
}
