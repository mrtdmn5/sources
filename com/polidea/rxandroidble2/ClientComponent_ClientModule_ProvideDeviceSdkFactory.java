package com.polidea.rxandroidble2;

import android.os.Build;
import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideDeviceSdkFactory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final ClientComponent_ClientModule_ProvideDeviceSdkFactory INSTANCE = new ClientComponent_ClientModule_ProvideDeviceSdkFactory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return Integer.valueOf(Build.VERSION.SDK_INT);
    }
}
