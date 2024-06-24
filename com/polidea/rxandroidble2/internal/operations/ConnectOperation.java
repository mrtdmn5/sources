package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.DeadObjectException;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.serialization.QueueSemaphore;
import com.polidea.rxandroidble2.internal.util.BleConnectionCompat;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableElementAtSingle;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleInternalHelper$ToFlowable;
import io.reactivex.observers.DisposableSingleObserver;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ConnectOperation extends QueueOperation<BluetoothGatt> {
    public final boolean autoConnect;
    public final BluetoothDevice bluetoothDevice;
    public final BluetoothGattProvider bluetoothGattProvider;
    public final TimeoutConfiguration connectTimeout;
    public final BleConnectionCompat connectionCompat;
    public final ConnectionStateChangeListener connectionStateChangedAction;
    public final RxBleGattCallback rxBleGattCallback;

    /* renamed from: com.polidea.rxandroidble2.internal.operations.ConnectOperation$1 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements Action {
        public AnonymousClass1() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            QueueSemaphore.this.release();
        }
    }

    /* renamed from: com.polidea.rxandroidble2.internal.operations.ConnectOperation$3 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass3 implements Callable<BluetoothGatt> {
        public AnonymousClass3() {
        }

        @Override // java.util.concurrent.Callable
        public final BluetoothGatt call() throws Exception {
            throw new BleGattCallbackTimeoutException(ConnectOperation.this.bluetoothGattProvider.reference.get(), BleGattOperationType.CONNECTION_STATE);
        }
    }

    /* renamed from: com.polidea.rxandroidble2.internal.operations.ConnectOperation$4 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass4 implements SingleOnSubscribe<BluetoothGatt> {

        /* renamed from: com.polidea.rxandroidble2.internal.operations.ConnectOperation$4$1 */
        /* loaded from: classes3.dex */
        public final class AnonymousClass1 implements Predicate<RxBleConnection.RxBleConnectionState> {
            @Override // io.reactivex.functions.Predicate
            public final boolean test(RxBleConnection.RxBleConnectionState rxBleConnectionState) throws Exception {
                if (rxBleConnectionState == RxBleConnection.RxBleConnectionState.CONNECTED) {
                    return true;
                }
                return false;
            }
        }

        public AnonymousClass4() {
        }

        public final void subscribe(final SingleCreate.Emitter emitter) {
            BluetoothGatt connectGatt;
            ConnectOperation connectOperation = ConnectOperation.this;
            connectOperation.getClass();
            SingleFromCallable singleFromCallable = new SingleFromCallable(new Callable<BluetoothGatt>() { // from class: com.polidea.rxandroidble2.internal.operations.ConnectOperation.5
                public AnonymousClass5() {
                }

                @Override // java.util.concurrent.Callable
                public final BluetoothGatt call() throws Exception {
                    ConnectOperation connectOperation2 = ConnectOperation.this;
                    connectOperation2.connectionStateChangedAction.onConnectionStateChange(RxBleConnection.RxBleConnectionState.CONNECTED);
                    return connectOperation2.bluetoothGattProvider.reference.get();
                }
            });
            RxBleGattCallback rxBleGattCallback = connectOperation.rxBleGattCallback;
            rxBleGattCallback.getClass();
            SingleDelayWithObservable singleDelayWithObservable = new SingleDelayWithObservable(singleFromCallable, new ObservableFilter(rxBleGattCallback.connectionStatePublishRelay.delay(0L, TimeUnit.SECONDS, rxBleGattCallback.callbackScheduler), new AnonymousClass1()));
            Observable<Object> observable = rxBleGattCallback.disconnectionRouter.firstDisconnectionExceptionObs;
            observable.getClass();
            SingleSource[] singleSourceArr = {singleDelayWithObservable, new ObservableElementAtSingle(observable)};
            int r3 = Flowable.BUFFER_SIZE;
            FlowableElementAtSingle flowableElementAtSingle = new FlowableElementAtSingle(new FlowableFlatMapPublisher(new FlowableFromArray(singleSourceArr), SingleInternalHelper$ToFlowable.INSTANCE, Flowable.BUFFER_SIZE));
            DisposableSingleObserver<Object> disposableSingleObserver = new DisposableSingleObserver<Object>() { // from class: com.polidea.rxandroidble2.internal.util.DisposableUtil$1
                @Override // io.reactivex.SingleObserver
                public final void onError(Throwable th) {
                    ((SingleCreate.Emitter) emitter).tryOnError(th);
                }

                @Override // io.reactivex.SingleObserver
                public final void onSuccess(Object obj) {
                    Disposable andSet;
                    SingleCreate.Emitter emitter2 = (SingleCreate.Emitter) emitter;
                    Disposable disposable = emitter2.get();
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    if (disposable != disposableHelper && (andSet = emitter2.getAndSet(disposableHelper)) != disposableHelper) {
                        SingleObserver<? super T> singleObserver = emitter2.downstream;
                        try {
                            if (obj == null) {
                                singleObserver.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                            } else {
                                singleObserver.onSuccess(obj);
                            }
                            if (andSet != null) {
                                andSet.dispose();
                            }
                        } catch (Throwable th) {
                            if (andSet != null) {
                                andSet.dispose();
                            }
                            throw th;
                        }
                    }
                }
            };
            flowableElementAtSingle.subscribe(disposableSingleObserver);
            DisposableHelper.set(emitter, disposableSingleObserver);
            connectOperation.connectionStateChangedAction.onConnectionStateChange(RxBleConnection.RxBleConnectionState.CONNECTING);
            RxBleGattCallback.AnonymousClass2 anonymousClass2 = rxBleGattCallback.bluetoothGattCallback;
            BleConnectionCompat bleConnectionCompat = connectOperation.connectionCompat;
            BluetoothDevice bluetoothDevice = connectOperation.bluetoothDevice;
            if (bluetoothDevice == null) {
                bleConnectionCompat.getClass();
                connectGatt = null;
            } else {
                bleConnectionCompat.getClass();
                RxBleLog.v("Connecting without reflection", new Object[0]);
                connectGatt = bluetoothDevice.connectGatt(bleConnectionCompat.context, connectOperation.autoConnect, anonymousClass2, 2);
            }
            AtomicReference<BluetoothGatt> atomicReference = connectOperation.bluetoothGattProvider.reference;
            while (!atomicReference.compareAndSet(null, connectGatt) && atomicReference.get() == null) {
            }
        }
    }

    /* renamed from: com.polidea.rxandroidble2.internal.operations.ConnectOperation$5 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass5 implements Callable<BluetoothGatt> {
        public AnonymousClass5() {
        }

        @Override // java.util.concurrent.Callable
        public final BluetoothGatt call() throws Exception {
            ConnectOperation connectOperation2 = ConnectOperation.this;
            connectOperation2.connectionStateChangedAction.onConnectionStateChange(RxBleConnection.RxBleConnectionState.CONNECTED);
            return connectOperation2.bluetoothGattProvider.reference.get();
        }
    }

    public ConnectOperation(BluetoothDevice bluetoothDevice, BleConnectionCompat bleConnectionCompat, RxBleGattCallback rxBleGattCallback, BluetoothGattProvider bluetoothGattProvider, TimeoutConfiguration timeoutConfiguration, boolean z, ConnectionStateChangeListener connectionStateChangeListener) {
        this.bluetoothDevice = bluetoothDevice;
        this.connectionCompat = bleConnectionCompat;
        this.rxBleGattCallback = rxBleGattCallback;
        this.bluetoothGattProvider = bluetoothGattProvider;
        this.connectTimeout = timeoutConfiguration;
        this.autoConnect = z;
        this.connectionStateChangedAction = connectionStateChangeListener;
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public final void protectedRun(final ObservableCreate.CreateEmitter createEmitter, QueueSemaphore queueSemaphore) {
        AnonymousClass1 anonymousClass1 = new Action() { // from class: com.polidea.rxandroidble2.internal.operations.ConnectOperation.1
            public AnonymousClass1() {
            }

            @Override // io.reactivex.functions.Action
            public final void run() {
                QueueSemaphore.this.release();
            }
        };
        Single singleCreate = new SingleCreate(new AnonymousClass4());
        boolean z = this.autoConnect;
        if (!z) {
            TimeoutConfiguration timeoutConfiguration = this.connectTimeout;
            singleCreate = singleCreate.timeout(timeoutConfiguration.timeout, timeoutConfiguration.timeoutTimeUnit, timeoutConfiguration.timeoutScheduler, new SingleFromCallable(new Callable<BluetoothGatt>() { // from class: com.polidea.rxandroidble2.internal.operations.ConnectOperation.3
                public AnonymousClass3() {
                }

                @Override // java.util.concurrent.Callable
                public final BluetoothGatt call() throws Exception {
                    throw new BleGattCallbackTimeoutException(ConnectOperation.this.bluetoothGattProvider.reference.get(), BleGattOperationType.CONNECTION_STATE);
                }
            }));
        }
        SingleDoFinally singleDoFinally = new SingleDoFinally(singleCreate, anonymousClass1);
        DisposableSingleObserver<Object> disposableSingleObserver = new DisposableSingleObserver<Object>() { // from class: com.polidea.rxandroidble2.internal.util.DisposableUtil$3
            @Override // io.reactivex.SingleObserver
            public final void onError(Throwable th) {
                ((ObservableCreate.CreateEmitter) createEmitter).tryOnError(th);
            }

            @Override // io.reactivex.SingleObserver
            public final void onSuccess(Object obj) {
                ObservableEmitter observableEmitter = createEmitter;
                ((ObservableCreate.CreateEmitter) observableEmitter).onNext(obj);
                ((ObservableCreate.CreateEmitter) observableEmitter).onComplete();
            }
        };
        singleDoFinally.subscribe(disposableSingleObserver);
        DisposableHelper.set(createEmitter, disposableSingleObserver);
        if (z) {
            queueSemaphore.release();
        }
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public final BleException provideException(DeadObjectException deadObjectException) {
        return new BleDisconnectedException(this.bluetoothDevice.getAddress(), deadObjectException);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConnectOperation{");
        sb.append(LoggerUtil.commonMacMessage(this.bluetoothDevice.getAddress()));
        sb.append(", autoConnect=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.autoConnect, '}');
    }
}
