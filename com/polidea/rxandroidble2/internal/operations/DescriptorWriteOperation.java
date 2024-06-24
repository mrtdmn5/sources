package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.util.ByteAssociation;
import com.polidea.rxandroidble2.internal.util.ByteAssociationUtil$2;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.single.SingleMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class DescriptorWriteOperation extends SingleResponseOperation<byte[]> {
    public final BluetoothGattDescriptor bluetoothGattDescriptor;
    public final byte[] data;

    public DescriptorWriteOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.DESCRIPTOR_WRITE, timeoutConfiguration);
        this.bluetoothGattDescriptor = bluetoothGattDescriptor;
        this.data = bArr;
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final Single<byte[]> getCallback(RxBleGattCallback rxBleGattCallback) {
        Observable delay = rxBleGattCallback.withDisconnectionHandling(rxBleGattCallback.writeDescriptorOutput).delay(0L, TimeUnit.SECONDS, rxBleGattCallback.callbackScheduler);
        final BluetoothGattDescriptor bluetoothGattDescriptor = this.bluetoothGattDescriptor;
        return new SingleMap(new ObservableElementAtSingle(new ObservableFilter(delay, new Predicate<ByteAssociation<BluetoothGattDescriptor>>() { // from class: com.polidea.rxandroidble2.internal.util.ByteAssociationUtil$3
            @Override // io.reactivex.functions.Predicate
            public final boolean test(ByteAssociation<BluetoothGattDescriptor> byteAssociation) throws Exception {
                return byteAssociation.first.equals(bluetoothGattDescriptor);
            }
        })), new ByteAssociationUtil$2());
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final boolean startOperation(BluetoothGatt bluetoothGatt) {
        BluetoothGattDescriptor bluetoothGattDescriptor = this.bluetoothGattDescriptor;
        bluetoothGattDescriptor.setValue(this.data);
        BluetoothGattCharacteristic characteristic = bluetoothGattDescriptor.getCharacteristic();
        int writeType = characteristic.getWriteType();
        characteristic.setWriteType(2);
        boolean writeDescriptor = bluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
        characteristic.setWriteType(writeType);
        return writeDescriptor;
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final String toString() {
        return "DescriptorWriteOperation{" + super.toString() + ", descriptor=" + new LoggerUtil.AttributeLogWrapper(this.bluetoothGattDescriptor.getUuid(), this.data, true) + '}';
    }
}
