package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothGatt;
import com.animaconnected.logger.LogKt;
import com.polidea.rxandroidble2.RxBleCustomOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class GattRefresh implements RxBleCustomOperation<Object> {
    private static final String TAG = "GattRefresh";

    /* renamed from: refreshDeviceCache */
    public Object lambda$asObservable$0(BluetoothGatt bluetoothGatt) {
        try {
            Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
            if (method != null) {
                LogKt.debug((Object) this, "Gatt cache refresh successful: " + ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue(), TAG, (Throwable) null, true);
            }
        } catch (Exception unused) {
            LogKt.debug((Object) this, "An exception occurred while refreshing device", TAG, (Throwable) null, true);
        }
        return new Object();
    }

    @Override // com.polidea.rxandroidble2.RxBleCustomOperation
    public Observable<Object> asObservable(final BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, Scheduler scheduler) {
        return new ObservableFromCallable(new Callable() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.GattRefresh$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object lambda$asObservable$0;
                lambda$asObservable$0 = GattRefresh.this.lambda$asObservable$0(bluetoothGatt);
                return lambda$asObservable$0;
            }
        }).subscribeOn(scheduler);
    }
}
