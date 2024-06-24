package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideComputationSchedulerFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvidesOperationTimeoutConfFactory;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import io.reactivex.Scheduler;

/* loaded from: classes3.dex */
public final class OperationsProviderImpl_Factory implements Provider {
    public final Provider<LoggerUtilBluetoothServices> bleServicesLoggerProvider;
    public final Provider<BluetoothGatt> bluetoothGattProvider;
    public final Provider<Scheduler> bluetoothInteractionSchedulerProvider;
    public final Provider<ReadRssiOperation> rssiReadOperationProvider;
    public final Provider<RxBleGattCallback> rxBleGattCallbackProvider;
    public final Provider<TimeoutConfiguration> timeoutConfigurationProvider;
    public final Provider<Scheduler> timeoutSchedulerProvider;

    public OperationsProviderImpl_Factory(Provider provider, Provider provider2, Provider provider3, ConnectionModule_ProvidesOperationTimeoutConfFactory connectionModule_ProvidesOperationTimeoutConfFactory, Provider provider4, ReadRssiOperation_Factory readRssiOperation_Factory) {
        ClientComponent_ClientModule_ProvideComputationSchedulerFactory clientComponent_ClientModule_ProvideComputationSchedulerFactory = ClientComponent_ClientModule_ProvideComputationSchedulerFactory.InstanceHolder.INSTANCE;
        this.rxBleGattCallbackProvider = provider;
        this.bluetoothGattProvider = provider2;
        this.bleServicesLoggerProvider = provider3;
        this.timeoutConfigurationProvider = connectionModule_ProvidesOperationTimeoutConfFactory;
        this.bluetoothInteractionSchedulerProvider = provider4;
        this.timeoutSchedulerProvider = clientComponent_ClientModule_ProvideComputationSchedulerFactory;
        this.rssiReadOperationProvider = readRssiOperation_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        RxBleGattCallback rxBleGattCallback = this.rxBleGattCallbackProvider.get();
        BluetoothGatt bluetoothGatt = this.bluetoothGattProvider.get();
        LoggerUtilBluetoothServices loggerUtilBluetoothServices = this.bleServicesLoggerProvider.get();
        TimeoutConfiguration timeoutConfiguration = this.timeoutConfigurationProvider.get();
        this.bluetoothInteractionSchedulerProvider.get();
        return new OperationsProviderImpl(rxBleGattCallback, bluetoothGatt, loggerUtilBluetoothServices, timeoutConfiguration, this.timeoutSchedulerProvider.get(), this.rssiReadOperationProvider);
    }
}
