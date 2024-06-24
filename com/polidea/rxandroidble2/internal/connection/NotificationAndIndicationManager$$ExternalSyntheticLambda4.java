package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException;
import io.reactivex.functions.Action;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class NotificationAndIndicationManager$$ExternalSyntheticLambda4 implements Action {
    public final /* synthetic */ BluetoothGatt f$0;
    public final /* synthetic */ BluetoothGattCharacteristic f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ NotificationAndIndicationManager$$ExternalSyntheticLambda4(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        this.f$0 = bluetoothGatt;
        this.f$1 = bluetoothGattCharacteristic;
        this.f$2 = z;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        BluetoothGatt bluetoothGatt = this.f$0;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f$1;
        if (bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, this.f$2)) {
        } else {
            throw new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 1, null);
        }
    }
}
