package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothManager;
import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideBluetoothManagerFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvidesDisconnectTimeoutConfFactory;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import io.reactivex.Scheduler;

/* loaded from: classes3.dex */
public final class DisconnectOperation_Factory implements Provider {
    public final Provider<BluetoothGattProvider> bluetoothGattProvider;
    public final Provider<Scheduler> bluetoothInteractionSchedulerProvider;
    public final Provider<BluetoothManager> bluetoothManagerProvider;
    public final Provider<ConnectionStateChangeListener> connectionStateChangeListenerProvider;
    public final Provider<String> macAddressProvider;
    public final Provider<RxBleGattCallback> rxBleGattCallbackProvider;
    public final Provider<TimeoutConfiguration> timeoutConfigurationProvider;

    public DisconnectOperation_Factory(Provider provider, Provider provider2, InstanceFactory instanceFactory, ClientComponent_ClientModule_ProvideBluetoothManagerFactory clientComponent_ClientModule_ProvideBluetoothManagerFactory, Provider provider3, DeviceModule_ProvidesDisconnectTimeoutConfFactory deviceModule_ProvidesDisconnectTimeoutConfFactory, Provider provider4) {
        this.rxBleGattCallbackProvider = provider;
        this.bluetoothGattProvider = provider2;
        this.macAddressProvider = instanceFactory;
        this.bluetoothManagerProvider = clientComponent_ClientModule_ProvideBluetoothManagerFactory;
        this.bluetoothInteractionSchedulerProvider = provider3;
        this.timeoutConfigurationProvider = deviceModule_ProvidesDisconnectTimeoutConfFactory;
        this.connectionStateChangeListenerProvider = provider4;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new DisconnectOperation(this.rxBleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.macAddressProvider.get(), this.bluetoothManagerProvider.get(), this.bluetoothInteractionSchedulerProvider.get(), this.timeoutConfigurationProvider.get(), this.connectionStateChangeListenerProvider.get());
    }
}
