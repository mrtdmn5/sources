package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothGatt;
import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattCannotStartException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble2.internal.serialization.QueueSemaphore;
import com.polidea.rxandroidble2.internal.util.QueueReleasingEmitterWrapper;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class SingleResponseOperation<T> extends QueueOperation<T> {
    public final BluetoothGatt bluetoothGatt;
    public final BleGattOperationType operationType;
    public final RxBleGattCallback rxBleGattCallback;
    public final TimeoutConfiguration timeoutConfiguration;

    public SingleResponseOperation(BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, BleGattOperationType bleGattOperationType, TimeoutConfiguration timeoutConfiguration) {
        this.bluetoothGatt = bluetoothGatt;
        this.rxBleGattCallback = rxBleGattCallback;
        this.operationType = bleGattOperationType;
        this.timeoutConfiguration = timeoutConfiguration;
    }

    public abstract Single<T> getCallback(RxBleGattCallback rxBleGattCallback);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public final void protectedRun(ObservableCreate.CreateEmitter createEmitter, QueueSemaphore queueSemaphore) {
        Observable<T> singleToObservable;
        QueueReleasingEmitterWrapper queueReleasingEmitterWrapper = new QueueReleasingEmitterWrapper(createEmitter, queueSemaphore);
        Single<T> callback = getCallback(this.rxBleGattCallback);
        TimeoutConfiguration timeoutConfiguration = this.timeoutConfiguration;
        long j = timeoutConfiguration.timeout;
        TimeUnit timeUnit = timeoutConfiguration.timeoutTimeUnit;
        Scheduler scheduler = timeoutConfiguration.timeoutScheduler;
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        SingleTimeout timeout = callback.timeout(j, timeUnit, scheduler, timeoutFallbackProcedure(bluetoothGatt, scheduler));
        if (timeout instanceof FuseToObservable) {
            singleToObservable = ((FuseToObservable) timeout).fuseToObservable();
        } else {
            singleToObservable = new SingleToObservable(timeout);
        }
        singleToObservable.subscribe(queueReleasingEmitterWrapper);
        if (!startOperation(bluetoothGatt)) {
            queueReleasingEmitterWrapper.cancel();
            queueReleasingEmitterWrapper.onError(new BleGattCannotStartException(bluetoothGatt, this.operationType));
        }
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public final BleException provideException(DeadObjectException deadObjectException) {
        return new BleDisconnectedException(this.bluetoothGatt.getDevice().getAddress(), deadObjectException);
    }

    public abstract boolean startOperation(BluetoothGatt bluetoothGatt);

    public Single timeoutFallbackProcedure(BluetoothGatt bluetoothGatt, Scheduler scheduler) {
        return new SingleError(new Functions.JustValue(new BleGattCallbackTimeoutException(this.bluetoothGatt, this.operationType)));
    }

    public String toString() {
        return LoggerUtil.commonMacMessage(this.bluetoothGatt);
    }
}
