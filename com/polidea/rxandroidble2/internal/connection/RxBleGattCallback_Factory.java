package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.connection.NativeCallbackDispatcher_Factory;
import io.reactivex.Scheduler;

/* loaded from: classes3.dex */
public final class RxBleGattCallback_Factory implements Provider {
    public final Provider<BluetoothGattProvider> bluetoothGattProvider;
    public final Provider<Scheduler> callbackSchedulerProvider;
    public final Provider<DisconnectionRouter> disconnectionRouterProvider;
    public final Provider<NativeCallbackDispatcher> nativeCallbackDispatcherProvider;

    public RxBleGattCallback_Factory(Provider provider, Provider provider2, Provider provider3) {
        NativeCallbackDispatcher_Factory nativeCallbackDispatcher_Factory = NativeCallbackDispatcher_Factory.InstanceHolder.INSTANCE;
        this.callbackSchedulerProvider = provider;
        this.bluetoothGattProvider = provider2;
        this.disconnectionRouterProvider = provider3;
        this.nativeCallbackDispatcherProvider = nativeCallbackDispatcher_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new RxBleGattCallback(this.callbackSchedulerProvider.get(), this.bluetoothGattProvider.get(), this.disconnectionRouterProvider.get(), this.nativeCallbackDispatcherProvider.get());
    }
}
