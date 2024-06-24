package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.DoubleCheck;
import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvideBluetoothDeviceFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvideConnectionStateChangeListenerFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvideConnectionStateRelayFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvidesDisconnectTimeoutConfFactory;
import com.polidea.rxandroidble2.internal.RxBleDeviceImpl_Factory;
import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.ConnectorImpl_Factory;

/* loaded from: classes3.dex */
public final class DaggerClientComponent$DeviceComponentImpl implements DeviceComponent {
    public final DaggerClientComponent$ClientComponentImpl clientComponentImpl;
    public ConnectorImpl_Factory connectorImplProvider;
    public final DaggerClientComponent$DeviceComponentImpl deviceComponentImpl = this;
    public final String macAddress;
    public InstanceFactory macAddressProvider;
    public DeviceModule_ProvideBluetoothDeviceFactory provideBluetoothDeviceProvider;
    public Provider<ConnectionStateChangeListener> provideConnectionStateChangeListenerProvider;
    public Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provideConnectionStateRelayProvider;
    public DeviceModule_ProvidesDisconnectTimeoutConfFactory providesDisconnectTimeoutConfProvider;
    public Provider rxBleDeviceImplProvider;

    /* renamed from: com.polidea.rxandroidble2.DaggerClientComponent$DeviceComponentImpl$1 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements Provider<ConnectionComponent.Builder> {
        public AnonymousClass1() {
        }

        @Override // bleshadow.javax.inject.Provider
        public final ConnectionComponent.Builder get() {
            DaggerClientComponent$DeviceComponentImpl daggerClientComponent$DeviceComponentImpl = DaggerClientComponent$DeviceComponentImpl.this;
            return new DaggerClientComponent$ConnectionComponentBuilder(daggerClientComponent$DeviceComponentImpl.clientComponentImpl, daggerClientComponent$DeviceComponentImpl.deviceComponentImpl);
        }
    }

    public DaggerClientComponent$DeviceComponentImpl(DaggerClientComponent$ClientComponentImpl daggerClientComponent$ClientComponentImpl, String str) {
        this.clientComponentImpl = daggerClientComponent$ClientComponentImpl;
        this.macAddress = str;
        InstanceFactory create = InstanceFactory.create(str);
        this.macAddressProvider = create;
        this.provideBluetoothDeviceProvider = new DeviceModule_ProvideBluetoothDeviceFactory(create, daggerClientComponent$ClientComponentImpl.rxBleAdapterWrapperProvider);
        this.connectorImplProvider = new ConnectorImpl_Factory(daggerClientComponent$ClientComponentImpl.bindClientOperationQueueProvider, new Provider<ConnectionComponent.Builder>() { // from class: com.polidea.rxandroidble2.DaggerClientComponent$DeviceComponentImpl.1
            public AnonymousClass1() {
            }

            @Override // bleshadow.javax.inject.Provider
            public final ConnectionComponent.Builder get() {
                DaggerClientComponent$DeviceComponentImpl daggerClientComponent$DeviceComponentImpl = DaggerClientComponent$DeviceComponentImpl.this;
                return new DaggerClientComponent$ConnectionComponentBuilder(daggerClientComponent$DeviceComponentImpl.clientComponentImpl, daggerClientComponent$DeviceComponentImpl.deviceComponentImpl);
            }
        }, daggerClientComponent$ClientComponentImpl.provideBluetoothCallbacksSchedulerProvider);
        Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provider = DoubleCheck.provider(DeviceModule_ProvideConnectionStateRelayFactory.InstanceHolder.INSTANCE);
        this.provideConnectionStateRelayProvider = provider;
        this.rxBleDeviceImplProvider = DoubleCheck.provider(new RxBleDeviceImpl_Factory(this.provideBluetoothDeviceProvider, this.connectorImplProvider, provider));
        this.provideConnectionStateChangeListenerProvider = DoubleCheck.provider(new DeviceModule_ProvideConnectionStateChangeListenerFactory(this.provideConnectionStateRelayProvider));
        this.providesDisconnectTimeoutConfProvider = new DeviceModule_ProvidesDisconnectTimeoutConfFactory();
    }

    @Override // com.polidea.rxandroidble2.internal.DeviceComponent
    public final RxBleDevice provideDevice() {
        return (RxBleDevice) this.rxBleDeviceImplProvider.get();
    }
}
