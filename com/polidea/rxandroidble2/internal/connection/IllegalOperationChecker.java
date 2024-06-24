package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.internal.BleIllegalOperationException;
import io.reactivex.functions.Action;

/* loaded from: classes3.dex */
public final class IllegalOperationChecker {
    public final IllegalOperationHandler resultHandler;

    /* renamed from: com.polidea.rxandroidble2.internal.connection.IllegalOperationChecker$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements Action {
        public final /* synthetic */ BluetoothGattCharacteristic val$characteristic;
        public final /* synthetic */ int val$neededProperties;

        public AnonymousClass1(BluetoothGattCharacteristic bluetoothGattCharacteristic, int r3) {
            this.val$characteristic = bluetoothGattCharacteristic;
            this.val$neededProperties = r3;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            BleIllegalOperationException handleMismatchData;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.val$characteristic;
            int properties = bluetoothGattCharacteristic.getProperties();
            int r2 = this.val$neededProperties;
            if ((properties & r2) == 0 && (handleMismatchData = IllegalOperationChecker.this.resultHandler.handleMismatchData(bluetoothGattCharacteristic, r2)) != null) {
                throw handleMismatchData;
            }
        }
    }

    public IllegalOperationChecker(IllegalOperationHandler illegalOperationHandler) {
        this.resultHandler = illegalOperationHandler;
    }
}
