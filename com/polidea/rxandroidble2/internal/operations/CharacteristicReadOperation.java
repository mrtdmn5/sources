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
public final class CharacteristicReadOperation extends SingleResponseOperation<byte[]> {
    public final BluetoothGattCharacteristic bluetoothGattCharacteristic;

    public CharacteristicReadOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.CHARACTERISTIC_READ, timeoutConfiguration);
        this.bluetoothGattCharacteristic = bluetoothGattCharacteristic;
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final Single<byte[]> getCallback(RxBleGattCallback rxBleGattCallback) {
        return new SingleMap(new ObservableElementAtSingle(new ObservableFilter(rxBleGattCallback.withDisconnectionHandling(rxBleGattCallback.readCharacteristicOutput).delay(0L, TimeUnit.SECONDS, rxBleGattCallback.callbackScheduler), new ByteAssociationUtil$1(this.bluetoothGattCharacteristic.getUuid()))), new ByteAssociationUtil$2());
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final boolean startOperation(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.readCharacteristic(this.bluetoothGattCharacteristic);
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final String toString() {
        StringBuilder sb = new StringBuilder("CharacteristicReadOperation{");
        sb.append(super.toString());
        sb.append(", characteristic=");
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.bluetoothGattCharacteristic;
        sb.append(new LoggerUtil.AttributeLogWrapper(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue(), false));
        sb.append('}');
        return sb.toString();
    }
}
