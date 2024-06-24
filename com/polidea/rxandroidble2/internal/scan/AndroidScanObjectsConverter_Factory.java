package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideDeviceSdkFactory;

/* loaded from: classes3.dex */
public final class AndroidScanObjectsConverter_Factory implements Provider {
    public final Provider<Integer> deviceSdkProvider = ClientComponent_ClientModule_ProvideDeviceSdkFactory.InstanceHolder.INSTANCE;

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new AndroidScanObjectsConverter(this.deviceSdkProvider.get().intValue());
    }
}
