package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothDevice;
import bleshadow.javax.inject.Provider;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.Connector;

/* loaded from: classes3.dex */
public final class RxBleDeviceImpl_Factory implements Provider {
    public final Provider<BluetoothDevice> bluetoothDeviceProvider;
    public final Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> connectionStateRelayProvider;
    public final Provider<Connector> connectorProvider;

    public RxBleDeviceImpl_Factory(Provider<BluetoothDevice> provider, Provider<Connector> provider2, Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provider3) {
        this.bluetoothDeviceProvider = provider;
        this.connectorProvider = provider2;
        this.connectionStateRelayProvider = provider3;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        BluetoothDevice bluetoothDevice = this.bluetoothDeviceProvider.get();
        Connector connector = this.connectorProvider.get();
        this.connectionStateRelayProvider.get();
        return new RxBleDeviceImpl(bluetoothDevice, connector);
    }
}
