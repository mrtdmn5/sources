package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.util.ByteAssociationUtil$1;
import com.polidea.rxandroidble2.internal.util.ByteAssociationUtil$2;
import io.reactivex.Single;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.single.SingleMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class CharacteristicWriteOperation extends SingleResponseOperation<byte[]> {
    public final BluetoothGattCharacteristic bluetoothGattCharacteristic;
    public final byte[] data;

    public CharacteristicWriteOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.CHARACTERISTIC_WRITE, timeoutConfiguration);
        this.bluetoothGattCharacteristic = bluetoothGattCharacteristic;
        this.data = bArr;
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final Single<byte[]> getCallback(RxBleGattCallback rxBleGattCallback) {
        return new SingleMap(new ObservableElementAtSingle(new ObservableFilter(rxBleGattCallback.withDisconnectionHandling(rxBleGattCallback.writeCharacteristicOutput).delay(0L, TimeUnit.SECONDS, rxBleGattCallback.callbackScheduler), new ByteAssociationUtil$1(this.bluetoothGattCharacteristic.getUuid()))), new ByteAssociationUtil$2());
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final boolean startOperation(BluetoothGatt bluetoothGatt) {
        byte[] bArr = this.data;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.bluetoothGattCharacteristic;
        bluetoothGattCharacteristic.setValue(bArr);
        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final String toString() {
        return "CharacteristicWriteOperation{" + super.toString() + ", characteristic=" + new LoggerUtil.AttributeLogWrapper(this.bluetoothGattCharacteristic.getUuid(), this.data, true) + '}';
    }
}
