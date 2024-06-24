package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import io.reactivex.Scheduler;

/* loaded from: classes3.dex */
public final class RxBleConnectionImpl_Factory implements Provider {
    public final Provider<BluetoothGatt> bluetoothGattProvider;
    public final Provider<Scheduler> callbackSchedulerProvider;
    public final Provider<DescriptorWriter> descriptorWriterProvider;
    public final Provider<RxBleGattCallback> gattCallbackProvider;
    public final Provider<IllegalOperationChecker> illegalOperationCheckerProvider;
    public final Provider<Object> longWriteOperationBuilderProvider;
    public final Provider<MtuProvider> mtuProvider;
    public final Provider<NotificationAndIndicationManager> notificationIndicationManagerProvider;
    public final Provider<OperationsProvider> operationProvider;
    public final Provider<ConnectionOperationQueue> operationQueueProvider;
    public final Provider<ServiceDiscoveryManager> serviceDiscoveryManagerProvider;

    public RxBleConnectionImpl_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5, Provider provider6, Provider provider7, Provider provider8, Provider provider9, Provider provider10, IllegalOperationChecker_Factory illegalOperationChecker_Factory) {
        this.operationQueueProvider = provider;
        this.gattCallbackProvider = provider2;
        this.bluetoothGattProvider = provider3;
        this.serviceDiscoveryManagerProvider = provider4;
        this.notificationIndicationManagerProvider = provider5;
        this.mtuProvider = provider6;
        this.descriptorWriterProvider = provider7;
        this.operationProvider = provider8;
        this.longWriteOperationBuilderProvider = provider9;
        this.callbackSchedulerProvider = provider10;
        this.illegalOperationCheckerProvider = illegalOperationChecker_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new RxBleConnectionImpl(this.operationQueueProvider.get(), this.gattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.serviceDiscoveryManagerProvider.get(), this.notificationIndicationManagerProvider.get(), this.mtuProvider.get(), this.descriptorWriterProvider.get(), this.operationProvider.get(), this.longWriteOperationBuilderProvider, this.callbackSchedulerProvider.get(), this.illegalOperationCheckerProvider.get());
    }
}
