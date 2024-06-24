package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideDeviceSdkFactory;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideRecommendedConnectRuntimePermissionNamesFactory implements Provider {
    public final Provider<Integer> deviceSdkProvider = ClientComponent_ClientModule_ProvideDeviceSdkFactory.InstanceHolder.INSTANCE;
    public final Provider<Integer> targetSdkProvider;

    public ClientComponent_ClientModule_ProvideRecommendedConnectRuntimePermissionNamesFactory(Provider provider) {
        this.targetSdkProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        if (Math.min(this.deviceSdkProvider.get().intValue(), this.targetSdkProvider.get().intValue()) < 31) {
            return new String[0];
        }
        return new String[][]{new String[]{"android.permission.BLUETOOTH_CONNECT"}};
    }
}
