package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.animaconnected.bluetooth.gatt.rxtwo.GattRefresh;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;

/* loaded from: classes3.dex */
public interface RxBleConnection {

    /* loaded from: classes3.dex */
    public enum RxBleConnectionState {
        CONNECTING("CONNECTING"),
        CONNECTED("CONNECTED"),
        DISCONNECTED("DISCONNECTED"),
        DISCONNECTING("DISCONNECTING");

        private final String description;

        RxBleConnectionState(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("RxBleConnectionState{"), this.description, '}');
        }
    }

    Single<RxBleDeviceServices> discoverServices();

    Observable queue(GattRefresh gattRefresh);

    ObservableElementAtSingle readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    Observable<Observable<byte[]>> setupNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    ObservableElementAtSingle writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr);

    ObservableIgnoreElementsCompletable writeDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr);
}
