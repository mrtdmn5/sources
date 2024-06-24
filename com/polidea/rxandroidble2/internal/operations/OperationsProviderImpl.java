package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import io.reactivex.Scheduler;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class OperationsProviderImpl implements OperationsProvider {
    public final LoggerUtilBluetoothServices bleServicesLogger;
    public final BluetoothGatt bluetoothGatt;
    public final RxBleGattCallback rxBleGattCallback;
    public final TimeoutConfiguration timeoutConfiguration;
    public final Scheduler timeoutScheduler;

    public OperationsProviderImpl(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, LoggerUtilBluetoothServices loggerUtilBluetoothServices, TimeoutConfiguration timeoutConfiguration, Scheduler scheduler, Provider provider) {
        this.rxBleGattCallback = rxBleGattCallback;
        this.bluetoothGatt = bluetoothGatt;
        this.bleServicesLogger = loggerUtilBluetoothServices;
        this.timeoutConfiguration = timeoutConfiguration;
        this.timeoutScheduler = scheduler;
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    public final CharacteristicReadOperation provideReadCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return new CharacteristicReadOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, bluetoothGattCharacteristic);
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    public final ServiceDiscoveryOperation provideServiceDiscoveryOperation(long j, TimeUnit timeUnit) {
        TimeoutConfiguration timeoutConfiguration = new TimeoutConfiguration(j, timeUnit, this.timeoutScheduler);
        return new ServiceDiscoveryOperation(this.rxBleGattCallback, this.bluetoothGatt, this.bleServicesLogger, timeoutConfiguration);
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    public final CharacteristicWriteOperation provideWriteCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return new CharacteristicWriteOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, bluetoothGattCharacteristic, bArr);
    }

    @Override // com.polidea.rxandroidble2.internal.operations.OperationsProvider
    public final DescriptorWriteOperation provideWriteDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return new DescriptorWriteOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, bluetoothGattDescriptor, bArr);
    }
}
