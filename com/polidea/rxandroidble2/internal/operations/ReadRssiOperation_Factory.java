package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvidesOperationTimeoutConfFactory;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;

/* loaded from: classes3.dex */
public final class ReadRssiOperation_Factory implements Provider {
    public final Provider<RxBleGattCallback> bleGattCallbackProvider;
    public final Provider<BluetoothGatt> bluetoothGattProvider;
    public final Provider<TimeoutConfiguration> timeoutConfigurationProvider;

    public ReadRssiOperation_Factory(Provider provider, Provider provider2, ConnectionModule_ProvidesOperationTimeoutConfFactory connectionModule_ProvidesOperationTimeoutConfFactory) {
        this.bleGattCallbackProvider = provider;
        this.bluetoothGattProvider = provider2;
        this.timeoutConfigurationProvider = connectionModule_ProvidesOperationTimeoutConfFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ReadRssiOperation(this.bleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.timeoutConfigurationProvider.get());
    }
}
