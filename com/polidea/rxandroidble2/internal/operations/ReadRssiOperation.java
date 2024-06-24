package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import io.reactivex.Single;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class ReadRssiOperation extends SingleResponseOperation<Integer> {
    public ReadRssiOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.READ_RSSI, timeoutConfiguration);
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final Single<Integer> getCallback(RxBleGattCallback rxBleGattCallback) {
        return new ObservableElementAtSingle(rxBleGattCallback.withDisconnectionHandling(rxBleGattCallback.readRssiOutput).delay(0L, TimeUnit.SECONDS, rxBleGattCallback.callbackScheduler));
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final boolean startOperation(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.readRemoteRssi();
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("ReadRssiOperation{"), super.toString(), '}');
    }
}
