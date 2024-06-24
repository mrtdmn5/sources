package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper_Factory;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class DeviceModule_ProvideBluetoothDeviceFactory implements Provider {
    public final Provider<RxBleAdapterWrapper> adapterWrapperProvider;
    public final Provider<String> macAddressProvider;

    public DeviceModule_ProvideBluetoothDeviceFactory(InstanceFactory instanceFactory, RxBleAdapterWrapper_Factory rxBleAdapterWrapper_Factory) {
        this.macAddressProvider = instanceFactory;
        this.adapterWrapperProvider = rxBleAdapterWrapper_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        String str = this.macAddressProvider.get();
        BluetoothAdapter bluetoothAdapter = this.adapterWrapperProvider.get().bluetoothAdapter;
        if (bluetoothAdapter != null) {
            BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(str);
            UnsignedKt.checkNotNullFromProvides(remoteDevice);
            return remoteDevice;
        }
        throw RxBleAdapterWrapper.nullBluetoothAdapter;
    }
}
