package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public interface OperationsProvider {
    CharacteristicReadOperation provideReadCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    ServiceDiscoveryOperation provideServiceDiscoveryOperation(long j, TimeUnit timeUnit);

    CharacteristicWriteOperation provideWriteCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr);

    DescriptorWriteOperation provideWriteDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr);
}
