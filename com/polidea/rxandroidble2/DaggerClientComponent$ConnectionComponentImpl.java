package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.DelegateFactory;
import bleshadow.dagger.internal.DoubleCheck;
import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider_Factory;
import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvideBluetoothGattFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvideIllegalOperationHandlerFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvidesOperationTimeoutConfFactory;
import com.polidea.rxandroidble2.internal.connection.DescriptorWriter_Factory;
import com.polidea.rxandroidble2.internal.connection.DisconnectAction_Factory;
import com.polidea.rxandroidble2.internal.connection.DisconnectionRouter_Factory;
import com.polidea.rxandroidble2.internal.connection.IllegalOperationChecker_Factory;
import com.polidea.rxandroidble2.internal.connection.IllegalOperationMessageCreator_Factory;
import com.polidea.rxandroidble2.internal.connection.LoggingIllegalOperationHandler_Factory;
import com.polidea.rxandroidble2.internal.connection.LongWriteOperationBuilderImpl_Factory;
import com.polidea.rxandroidble2.internal.connection.MtuBasedPayloadSizeLimit_Factory;
import com.polidea.rxandroidble2.internal.connection.MtuWatcher_Factory;
import com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager_Factory;
import com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl_Factory;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback_Factory;
import com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager_Factory;
import com.polidea.rxandroidble2.internal.connection.ThrowingIllegalOperationHandler_Factory;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices_Factory;
import com.polidea.rxandroidble2.internal.operations.DisconnectOperation_Factory;
import com.polidea.rxandroidble2.internal.operations.OperationsProviderImpl_Factory;
import com.polidea.rxandroidble2.internal.operations.ReadRssiOperation_Factory;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl_Factory;

/* loaded from: classes3.dex */
public final class DaggerClientComponent$ConnectionComponentImpl implements ConnectionComponent {
    public final Boolean autoConnect;
    public Provider<BluetoothGattProvider> bluetoothGattProvider = DoubleCheck.provider(BluetoothGattProvider_Factory.InstanceHolder.INSTANCE);
    public final DaggerClientComponent$ClientComponentImpl clientComponentImpl;
    public Provider<ConnectionOperationQueueImpl> connectionOperationQueueImplProvider;
    public Provider descriptorWriterProvider;
    public final DaggerClientComponent$DeviceComponentImpl deviceComponentImpl;
    public Provider disconnectActionProvider;
    public Provider disconnectionRouterProvider;
    public LoggerUtilBluetoothServices_Factory loggerUtilBluetoothServicesProvider;
    public LongWriteOperationBuilderImpl_Factory longWriteOperationBuilderImplProvider;
    public Provider mtuWatcherProvider;
    public Provider notificationAndIndicationManagerProvider;
    public OperationsProviderImpl_Factory operationsProviderImplProvider;
    public ConnectionModule_ProvideBluetoothGattFactory provideBluetoothGattProvider;
    public DelegateFactory rxBleConnectionImplProvider;
    public Provider<RxBleGattCallback> rxBleGattCallbackProvider;
    public Provider serviceDiscoveryManagerProvider;

    public DaggerClientComponent$ConnectionComponentImpl(DaggerClientComponent$ClientComponentImpl daggerClientComponent$ClientComponentImpl, DaggerClientComponent$DeviceComponentImpl daggerClientComponent$DeviceComponentImpl, Boolean bool, Boolean bool2, Timeout timeout) {
        this.clientComponentImpl = daggerClientComponent$ClientComponentImpl;
        this.deviceComponentImpl = daggerClientComponent$DeviceComponentImpl;
        this.autoConnect = bool;
        Provider provider = DoubleCheck.provider(new DisconnectionRouter_Factory(daggerClientComponent$DeviceComponentImpl.macAddressProvider, daggerClientComponent$ClientComponentImpl.rxBleAdapterWrapperProvider, daggerClientComponent$ClientComponentImpl.rxBleAdapterStateObservableProvider));
        this.disconnectionRouterProvider = provider;
        this.rxBleGattCallbackProvider = DoubleCheck.provider(new RxBleGattCallback_Factory(daggerClientComponent$ClientComponentImpl.provideBluetoothCallbacksSchedulerProvider, this.bluetoothGattProvider, provider));
        this.connectionOperationQueueImplProvider = DoubleCheck.provider(new ConnectionOperationQueueImpl_Factory(daggerClientComponent$DeviceComponentImpl.macAddressProvider, this.disconnectionRouterProvider, daggerClientComponent$ClientComponentImpl.provideConnectionQueueExecutorServiceProvider, daggerClientComponent$ClientComponentImpl.provideBluetoothInteractionSchedulerProvider));
        this.provideBluetoothGattProvider = new ConnectionModule_ProvideBluetoothGattFactory(this.bluetoothGattProvider);
        this.loggerUtilBluetoothServicesProvider = new LoggerUtilBluetoothServices_Factory();
        ConnectionModule_ProvidesOperationTimeoutConfFactory connectionModule_ProvidesOperationTimeoutConfFactory = new ConnectionModule_ProvidesOperationTimeoutConfFactory(InstanceFactory.create(timeout));
        Provider<RxBleGattCallback> provider2 = this.rxBleGattCallbackProvider;
        ConnectionModule_ProvideBluetoothGattFactory connectionModule_ProvideBluetoothGattFactory = this.provideBluetoothGattProvider;
        OperationsProviderImpl_Factory operationsProviderImpl_Factory = new OperationsProviderImpl_Factory(provider2, connectionModule_ProvideBluetoothGattFactory, this.loggerUtilBluetoothServicesProvider, connectionModule_ProvidesOperationTimeoutConfFactory, daggerClientComponent$ClientComponentImpl.provideBluetoothInteractionSchedulerProvider, new ReadRssiOperation_Factory(provider2, connectionModule_ProvideBluetoothGattFactory, connectionModule_ProvidesOperationTimeoutConfFactory));
        this.operationsProviderImplProvider = operationsProviderImpl_Factory;
        this.serviceDiscoveryManagerProvider = DoubleCheck.provider(new ServiceDiscoveryManager_Factory(this.connectionOperationQueueImplProvider, connectionModule_ProvideBluetoothGattFactory, operationsProviderImpl_Factory));
        Provider provider3 = DoubleCheck.provider(new DescriptorWriter_Factory(this.connectionOperationQueueImplProvider, this.operationsProviderImplProvider));
        this.descriptorWriterProvider = provider3;
        this.notificationAndIndicationManagerProvider = DoubleCheck.provider(new NotificationAndIndicationManager_Factory(this.provideBluetoothGattProvider, this.rxBleGattCallbackProvider, provider3));
        this.mtuWatcherProvider = DoubleCheck.provider(new MtuWatcher_Factory(this.rxBleGattCallbackProvider));
        DelegateFactory delegateFactory = new DelegateFactory();
        this.rxBleConnectionImplProvider = delegateFactory;
        this.longWriteOperationBuilderImplProvider = new LongWriteOperationBuilderImpl_Factory(this.connectionOperationQueueImplProvider, DoubleCheck.provider(new MtuBasedPayloadSizeLimit_Factory(delegateFactory)), this.rxBleConnectionImplProvider, this.operationsProviderImplProvider);
        InstanceFactory create = InstanceFactory.create(bool2);
        IllegalOperationMessageCreator_Factory illegalOperationMessageCreator_Factory = new IllegalOperationMessageCreator_Factory();
        IllegalOperationChecker_Factory illegalOperationChecker_Factory = new IllegalOperationChecker_Factory(new ConnectionModule_ProvideIllegalOperationHandlerFactory(create, new LoggingIllegalOperationHandler_Factory(illegalOperationMessageCreator_Factory), new ThrowingIllegalOperationHandler_Factory(illegalOperationMessageCreator_Factory)));
        DelegateFactory delegateFactory2 = this.rxBleConnectionImplProvider;
        Provider<T> provider4 = DoubleCheck.provider(new RxBleConnectionImpl_Factory(this.connectionOperationQueueImplProvider, this.rxBleGattCallbackProvider, this.provideBluetoothGattProvider, this.serviceDiscoveryManagerProvider, this.notificationAndIndicationManagerProvider, this.mtuWatcherProvider, this.descriptorWriterProvider, this.operationsProviderImplProvider, this.longWriteOperationBuilderImplProvider, daggerClientComponent$ClientComponentImpl.provideBluetoothInteractionSchedulerProvider, illegalOperationChecker_Factory));
        if (delegateFactory2.delegate == null) {
            delegateFactory2.delegate = provider4;
            this.disconnectActionProvider = DoubleCheck.provider(new DisconnectAction_Factory(daggerClientComponent$ClientComponentImpl.bindClientOperationQueueProvider, new DisconnectOperation_Factory(this.rxBleGattCallbackProvider, this.bluetoothGattProvider, daggerClientComponent$DeviceComponentImpl.macAddressProvider, daggerClientComponent$ClientComponentImpl.provideBluetoothManagerProvider, daggerClientComponent$ClientComponentImpl.provideBluetoothInteractionSchedulerProvider, daggerClientComponent$DeviceComponentImpl.providesDisconnectTimeoutConfProvider, daggerClientComponent$DeviceComponentImpl.provideConnectionStateChangeListenerProvider)));
            return;
        }
        throw new IllegalStateException();
    }
}
