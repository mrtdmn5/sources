package com.polidea.rxandroidble2;

import android.content.Context;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideDeviceSdkFactory;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideIsAndroidWearFactory implements Provider {
    public final Provider<Context> contextProvider;
    public final Provider<Integer> deviceSdkProvider;

    public ClientComponent_ClientModule_ProvideIsAndroidWearFactory(Provider provider) {
        ClientComponent_ClientModule_ProvideDeviceSdkFactory clientComponent_ClientModule_ProvideDeviceSdkFactory = ClientComponent_ClientModule_ProvideDeviceSdkFactory.InstanceHolder.INSTANCE;
        this.contextProvider = provider;
        this.deviceSdkProvider = clientComponent_ClientModule_ProvideDeviceSdkFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        boolean z;
        Context context = this.contextProvider.get();
        if (this.deviceSdkProvider.get().intValue() >= 20 && context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
