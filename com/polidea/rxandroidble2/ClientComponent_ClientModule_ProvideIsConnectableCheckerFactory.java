package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideDeviceSdkFactory;
import com.polidea.rxandroidble2.internal.scan.IsConnectableCheckerApi18;
import com.polidea.rxandroidble2.internal.scan.IsConnectableCheckerApi18_Factory;
import com.polidea.rxandroidble2.internal.scan.IsConnectableCheckerApi26;
import com.polidea.rxandroidble2.internal.scan.IsConnectableCheckerApi26_Factory;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideIsConnectableCheckerFactory implements Provider {
    public final Provider<Integer> deviceSdkProvider;
    public final Provider<IsConnectableCheckerApi18> isConnectableCheckerApi18Provider;
    public final Provider<IsConnectableCheckerApi26> isConnectableCheckerApi26Provider;

    public ClientComponent_ClientModule_ProvideIsConnectableCheckerFactory() {
        ClientComponent_ClientModule_ProvideDeviceSdkFactory clientComponent_ClientModule_ProvideDeviceSdkFactory = ClientComponent_ClientModule_ProvideDeviceSdkFactory.InstanceHolder.INSTANCE;
        IsConnectableCheckerApi18_Factory isConnectableCheckerApi18_Factory = IsConnectableCheckerApi18_Factory.InstanceHolder.INSTANCE;
        IsConnectableCheckerApi26_Factory isConnectableCheckerApi26_Factory = IsConnectableCheckerApi26_Factory.InstanceHolder.INSTANCE;
        this.deviceSdkProvider = clientComponent_ClientModule_ProvideDeviceSdkFactory;
        this.isConnectableCheckerApi18Provider = isConnectableCheckerApi18_Factory;
        this.isConnectableCheckerApi26Provider = isConnectableCheckerApi26_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        IsConnectableCheckerApi26 isConnectableCheckerApi26;
        if (this.deviceSdkProvider.get().intValue() < 26) {
            isConnectableCheckerApi26 = this.isConnectableCheckerApi18Provider.get();
        } else {
            isConnectableCheckerApi26 = this.isConnectableCheckerApi26Provider.get();
        }
        UnsignedKt.checkNotNullFromProvides(isConnectableCheckerApi26);
        return isConnectableCheckerApi26;
    }
}
