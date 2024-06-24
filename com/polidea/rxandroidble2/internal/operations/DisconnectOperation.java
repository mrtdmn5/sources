package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.os.DeadObjectException;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.serialization.QueueSemaphore;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleObserveOn;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class DisconnectOperation extends QueueOperation<Void> {
    public final BluetoothGattProvider bluetoothGattProvider;
    public final Scheduler bluetoothInteractionScheduler;
    public final BluetoothManager bluetoothManager;
    public final ConnectionStateChangeListener connectionStateChangeListener;
    public final String macAddress;
    public final RxBleGattCallback rxBleGattCallback;
    public final TimeoutConfiguration timeoutConfiguration;

    /* loaded from: classes3.dex */
    public static class DisconnectGattObservable extends Single<BluetoothGatt> {
        public final BluetoothGatt bluetoothGatt;
        public final Scheduler disconnectScheduler;
        public final RxBleGattCallback rxBleGattCallback;

        /* renamed from: com.polidea.rxandroidble2.internal.operations.DisconnectOperation$DisconnectGattObservable$2, reason: invalid class name */
        /* loaded from: classes3.dex */
        public class AnonymousClass2 implements Predicate<RxBleConnection.RxBleConnectionState> {
            @Override // io.reactivex.functions.Predicate
            public final boolean test(RxBleConnection.RxBleConnectionState rxBleConnectionState) throws Exception {
                if (rxBleConnectionState == RxBleConnection.RxBleConnectionState.DISCONNECTED) {
                    return true;
                }
                return false;
            }
        }

        public DisconnectGattObservable(BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, Scheduler scheduler) {
            this.bluetoothGatt = bluetoothGatt;
            this.rxBleGattCallback = rxBleGattCallback;
            this.disconnectScheduler = scheduler;
        }

        @Override // io.reactivex.Single
        public final void subscribeActual(SingleObserver<? super BluetoothGatt> singleObserver) {
            RxBleGattCallback rxBleGattCallback = this.rxBleGattCallback;
            rxBleGattCallback.getClass();
            new SingleMap(new ObservableElementAtSingle(new ObservableFilter(rxBleGattCallback.connectionStatePublishRelay.delay(0L, TimeUnit.SECONDS, rxBleGattCallback.callbackScheduler), new AnonymousClass2())), new Function<RxBleConnection.RxBleConnectionState, BluetoothGatt>() { // from class: com.polidea.rxandroidble2.internal.operations.DisconnectOperation.DisconnectGattObservable.1
                @Override // io.reactivex.functions.Function
                public final BluetoothGatt apply(RxBleConnection.RxBleConnectionState rxBleConnectionState) throws Exception {
                    return DisconnectGattObservable.this.bluetoothGatt;
                }
            }).subscribe(singleObserver);
            this.disconnectScheduler.createWorker().schedule(new Runnable() { // from class: com.polidea.rxandroidble2.internal.operations.DisconnectOperation.DisconnectGattObservable.3
                @Override // java.lang.Runnable
                public final void run() {
                    DisconnectGattObservable.this.bluetoothGatt.disconnect();
                }
            });
        }
    }

    public DisconnectOperation(RxBleGattCallback rxBleGattCallback, BluetoothGattProvider bluetoothGattProvider, String str, BluetoothManager bluetoothManager, Scheduler scheduler, TimeoutConfiguration timeoutConfiguration, ConnectionStateChangeListener connectionStateChangeListener) {
        this.rxBleGattCallback = rxBleGattCallback;
        this.bluetoothGattProvider = bluetoothGattProvider;
        this.macAddress = str;
        this.bluetoothManager = bluetoothManager;
        this.bluetoothInteractionScheduler = scheduler;
        this.timeoutConfiguration = timeoutConfiguration;
        this.connectionStateChangeListener = connectionStateChangeListener;
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public final void protectedRun(final ObservableCreate.CreateEmitter createEmitter, final QueueSemaphore queueSemaphore) {
        Single timeout;
        RxBleConnection.RxBleConnectionState rxBleConnectionState = RxBleConnection.RxBleConnectionState.DISCONNECTING;
        ConnectionStateChangeListener connectionStateChangeListener = this.connectionStateChangeListener;
        connectionStateChangeListener.onConnectionStateChange(rxBleConnectionState);
        BluetoothGatt bluetoothGatt = this.bluetoothGattProvider.reference.get();
        boolean z = false;
        if (bluetoothGatt == null) {
            RxBleLog.w("Disconnect operation has been executed but GATT instance was null - considering disconnected.", new Object[0]);
            connectionStateChangeListener.onConnectionStateChange(RxBleConnection.RxBleConnectionState.DISCONNECTED);
            queueSemaphore.release();
            createEmitter.onComplete();
            return;
        }
        if (this.bluetoothManager.getConnectionState(bluetoothGatt.getDevice(), 7) == 0) {
            z = true;
        }
        Scheduler scheduler = this.bluetoothInteractionScheduler;
        if (z) {
            timeout = new SingleJust(bluetoothGatt);
        } else {
            DisconnectGattObservable disconnectGattObservable = new DisconnectGattObservable(bluetoothGatt, this.rxBleGattCallback, scheduler);
            TimeoutConfiguration timeoutConfiguration = this.timeoutConfiguration;
            timeout = disconnectGattObservable.timeout(timeoutConfiguration.timeout, timeoutConfiguration.timeoutTimeUnit, timeoutConfiguration.timeoutScheduler, new SingleJust(bluetoothGatt));
        }
        if (scheduler != null) {
            new SingleObserveOn(timeout, scheduler).subscribe(new SingleObserver<BluetoothGatt>() { // from class: com.polidea.rxandroidble2.internal.operations.DisconnectOperation.1
                @Override // io.reactivex.SingleObserver
                public final void onError(Throwable th) {
                    RxBleLog.throwShade(5, th, "Disconnect operation has been executed but finished with an error - considering disconnected.", new Object[0]);
                    DisconnectOperation.this.connectionStateChangeListener.onConnectionStateChange(RxBleConnection.RxBleConnectionState.DISCONNECTED);
                    queueSemaphore.release();
                    ((ObservableCreate.CreateEmitter) createEmitter).onComplete();
                }

                @Override // io.reactivex.SingleObserver
                public final void onSuccess(BluetoothGatt bluetoothGatt2) {
                    bluetoothGatt2.close();
                    DisconnectOperation.this.connectionStateChangeListener.onConnectionStateChange(RxBleConnection.RxBleConnectionState.DISCONNECTED);
                    queueSemaphore.release();
                    ((ObservableCreate.CreateEmitter) createEmitter).onComplete();
                }

                @Override // io.reactivex.SingleObserver
                public final void onSubscribe(Disposable disposable) {
                }
            });
            return;
        }
        throw new NullPointerException("scheduler is null");
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public final BleException provideException(DeadObjectException deadObjectException) {
        return new BleDisconnectedException(this.macAddress, deadObjectException);
    }

    public final String toString() {
        return "DisconnectOperation{" + LoggerUtil.commonMacMessage(this.macAddress) + '}';
    }
}
