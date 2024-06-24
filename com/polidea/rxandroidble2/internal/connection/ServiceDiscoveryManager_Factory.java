package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.operations.OperationsProviderImpl_Factory;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;

/* loaded from: classes3.dex */
public final class ServiceDiscoveryManager_Factory implements Provider {
    public final Provider<BluetoothGatt> bluetoothGattProvider;
    public final Provider<OperationsProvider> operationProvider;
    public final Provider<ConnectionOperationQueue> operationQueueProvider;

    public ServiceDiscoveryManager_Factory(Provider provider, Provider provider2, OperationsProviderImpl_Factory operationsProviderImpl_Factory) {
        this.operationQueueProvider = provider;
        this.bluetoothGattProvider = provider2;
        this.operationProvider = operationsProviderImpl_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ServiceDiscoveryManager(this.operationQueueProvider.get(), this.bluetoothGattProvider.get(), this.operationProvider.get());
    }
}
