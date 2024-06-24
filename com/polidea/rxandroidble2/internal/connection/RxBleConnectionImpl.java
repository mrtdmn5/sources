package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.DeadObjectException;
import bleshadow.javax.inject.Provider;
import com.animaconnected.bluetooth.gatt.rxtwo.GattRefresh;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleCustomOperation;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.exceptions.BleConflictingNotificationAlreadySetException;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.Priority;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.connection.IllegalOperationChecker;
import com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager;
import com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import com.polidea.rxandroidble2.internal.serialization.QueueSemaphore;
import com.polidea.rxandroidble2.internal.util.ActiveCharacteristicNotification;
import com.polidea.rxandroidble2.internal.util.CharacteristicChangedEvent;
import com.polidea.rxandroidble2.internal.util.CharacteristicNotificationId;
import com.polidea.rxandroidble2.internal.util.QueueReleasingEmitterWrapper;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.internal.operators.completable.CompletableToObservable;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableAutoConnect;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservablePublishClassic;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleDoOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class RxBleConnectionImpl implements RxBleConnection {
    public final BluetoothGatt bluetoothGatt;
    public final Scheduler callbackScheduler;
    public final DescriptorWriter descriptorWriter;
    public final RxBleGattCallback gattCallback;
    public final IllegalOperationChecker illegalOperationChecker;
    public final MtuProvider mtuProvider;
    public final NotificationAndIndicationManager notificationIndicationManager;
    public final ConnectionOperationQueue operationQueue;
    public final OperationsProvider operationsProvider;
    public final ServiceDiscoveryManager serviceDiscoveryManager;

    public RxBleConnectionImpl(ConnectionOperationQueue connectionOperationQueue, RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, ServiceDiscoveryManager serviceDiscoveryManager, NotificationAndIndicationManager notificationAndIndicationManager, MtuProvider mtuProvider, DescriptorWriter descriptorWriter, OperationsProvider operationsProvider, Provider<Object> provider, Scheduler scheduler, IllegalOperationChecker illegalOperationChecker) {
        this.operationQueue = connectionOperationQueue;
        this.gattCallback = rxBleGattCallback;
        this.bluetoothGatt = bluetoothGatt;
        this.serviceDiscoveryManager = serviceDiscoveryManager;
        this.notificationIndicationManager = notificationAndIndicationManager;
        this.mtuProvider = mtuProvider;
        this.descriptorWriter = descriptorWriter;
        this.operationsProvider = operationsProvider;
        this.callbackScheduler = scheduler;
        this.illegalOperationChecker = illegalOperationChecker;
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public final Single<RxBleDeviceServices> discoverServices() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ServiceDiscoveryManager serviceDiscoveryManager = this.serviceDiscoveryManager;
        if (serviceDiscoveryManager.hasCachedResults) {
            return serviceDiscoveryManager.deviceServicesObservable;
        }
        SingleCache singleCache = serviceDiscoveryManager.deviceServicesObservable;
        ServiceDiscoveryManager.AnonymousClass1 anonymousClass1 = new Consumer<Disposable>() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.1
            public final /* synthetic */ long val$timeout = 20;
            public final /* synthetic */ TimeUnit val$timeoutTimeUnit;

            public AnonymousClass1(TimeUnit timeUnit2) {
                r4 = timeUnit2;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Disposable disposable) throws Exception {
                ServiceDiscoveryManager.this.timeoutBehaviorSubject.onNext(new TimeoutConfiguration(this.val$timeout, r4, Schedulers.COMPUTATION));
            }
        };
        singleCache.getClass();
        return new SingleDoOnSubscribe(singleCache, anonymousClass1);
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public final Observable queue(final GattRefresh gattRefresh) {
        return this.operationQueue.queue(new QueueOperation<Object>(this) { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.11
            public final /* synthetic */ RxBleConnectionImpl this$0;
            public final /* synthetic */ Priority val$priority;

            {
                Priority priority = Priority.NORMAL;
                this.this$0 = this;
                this.val$priority = priority;
            }

            @Override // com.polidea.rxandroidble2.internal.QueueOperation, com.polidea.rxandroidble2.internal.operations.Operation
            public final Priority definedPriority() {
                return this.val$priority;
            }

            @Override // com.polidea.rxandroidble2.internal.QueueOperation
            public final void protectedRun(ObservableCreate.CreateEmitter createEmitter, QueueSemaphore queueSemaphore) throws Throwable {
                try {
                    RxBleCustomOperation rxBleCustomOperation = gattRefresh;
                    RxBleConnectionImpl rxBleConnectionImpl = this.this$0;
                    Observable asObservable = rxBleCustomOperation.asObservable(rxBleConnectionImpl.bluetoothGatt, rxBleConnectionImpl.gattCallback, rxBleConnectionImpl.callbackScheduler);
                    if (asObservable != null) {
                        QueueReleasingEmitterWrapper queueReleasingEmitterWrapper = new QueueReleasingEmitterWrapper(createEmitter, queueSemaphore);
                        Action action = new Action() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.11.1
                            @Override // io.reactivex.functions.Action
                            public final void run() {
                                NativeCallbackDispatcher nativeCallbackDispatcher = AnonymousClass11.this.this$0.gattCallback.nativeCallbackDispatcher;
                                nativeCallbackDispatcher.nativeCallback = null;
                                nativeCallbackDispatcher.getClass();
                            }
                        };
                        new ObservableDoOnEach(asObservable, Functions.EMPTY_CONSUMER, new Functions.ActionConsumer(action), action).subscribe(queueReleasingEmitterWrapper);
                        return;
                    }
                    queueSemaphore.release();
                    throw new IllegalArgumentException("The custom operation asObservable method must return a non-null observable");
                } catch (Throwable th) {
                    queueSemaphore.release();
                    throw th;
                }
            }

            @Override // com.polidea.rxandroidble2.internal.QueueOperation
            public final BleException provideException(DeadObjectException deadObjectException) {
                return new BleDisconnectedException(this.this$0.bluetoothGatt.getDevice().getAddress(), deadObjectException);
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public final ObservableElementAtSingle readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        IllegalOperationChecker illegalOperationChecker = this.illegalOperationChecker;
        illegalOperationChecker.getClass();
        return new ObservableElementAtSingle(new CompletableFromAction(new IllegalOperationChecker.AnonymousClass1(bluetoothGattCharacteristic, 2)).andThen(this.operationQueue.queue(this.operationsProvider.provideReadCharacteristic(bluetoothGattCharacteristic))));
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public final Observable<Observable<byte[]>> setupNotification(final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        final NotificationSetupMode notificationSetupMode = NotificationSetupMode.DEFAULT;
        IllegalOperationChecker illegalOperationChecker = this.illegalOperationChecker;
        illegalOperationChecker.getClass();
        CompletableFromAction completableFromAction = new CompletableFromAction(new IllegalOperationChecker.AnonymousClass1(bluetoothGattCharacteristic, 16));
        final NotificationAndIndicationManager notificationAndIndicationManager = this.notificationIndicationManager;
        notificationAndIndicationManager.getClass();
        return completableFromAction.andThen(new ObservableDefer(new Callable() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda0
            public final /* synthetic */ boolean f$2 = false;

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [io.reactivex.internal.operators.observable.ObservableReplay] */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                final byte[] bArr;
                ObservableSource observableSource;
                final NotificationAndIndicationManager notificationAndIndicationManager2 = NotificationAndIndicationManager.this;
                final BluetoothGattCharacteristic bluetoothGattCharacteristic2 = bluetoothGattCharacteristic;
                boolean z = this.f$2;
                final NotificationSetupMode notificationSetupMode2 = notificationSetupMode;
                synchronized (notificationAndIndicationManager2.activeNotificationObservableMap) {
                    final CharacteristicNotificationId characteristicNotificationId = new CharacteristicNotificationId(bluetoothGattCharacteristic2.getUuid(), Integer.valueOf(bluetoothGattCharacteristic2.getInstanceId()));
                    ActiveCharacteristicNotification activeCharacteristicNotification = (ActiveCharacteristicNotification) notificationAndIndicationManager2.activeNotificationObservableMap.get(characteristicNotificationId);
                    boolean z2 = true;
                    if (activeCharacteristicNotification != null) {
                        if (activeCharacteristicNotification.isIndication == z) {
                            observableSource = activeCharacteristicNotification.notificationObservable;
                        } else {
                            UUID uuid = bluetoothGattCharacteristic2.getUuid();
                            if (z) {
                                z2 = false;
                            }
                            observableSource = Observable.error(new BleConflictingNotificationAlreadySetException(uuid, z2));
                        }
                    } else {
                        if (z) {
                            bArr = notificationAndIndicationManager2.configEnableIndication;
                        } else {
                            bArr = notificationAndIndicationManager2.configEnableNotification;
                        }
                        final PublishSubject publishSubject = new PublishSubject();
                        CompletableFromAction completableFromAction2 = new CompletableFromAction(new NotificationAndIndicationManager$$ExternalSyntheticLambda4(notificationAndIndicationManager2.bluetoothGatt, bluetoothGattCharacteristic2, true));
                        RxBleGattCallback rxBleGattCallback = notificationAndIndicationManager2.gattCallback;
                        Observable andThen = completableFromAction2.andThen(ObservableNever.INSTANCE.startWith(new ObservableFilter(Observable.merge(rxBleGattCallback.disconnectionRouter.firstDisconnectionExceptionObs, rxBleGattCallback.changedCharacteristicSerializedPublishRelay).delay(0L, TimeUnit.SECONDS, rxBleGattCallback.callbackScheduler), new Predicate() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda5
                            @Override // io.reactivex.functions.Predicate
                            public final boolean test(Object obj) {
                                return ((CharacteristicChangedEvent) obj).equals(CharacteristicNotificationId.this);
                            }
                        }).map(new NotificationAndIndicationManager$$ExternalSyntheticLambda6())));
                        final DescriptorWriter descriptorWriter = notificationAndIndicationManager2.descriptorWriter;
                        ObservableDoFinally observableDoFinally = new ObservableDoFinally(andThen.compose(new ObservableTransformer() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda3
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.reactivex.ObservableTransformer
                            public final Observable apply(Observable observable) {
                                Observable completableToObservable;
                                int r0 = NotificationAndIndicationManager.AnonymousClass1.$SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[notificationSetupMode2.ordinal()];
                                if (r0 != 1) {
                                    BluetoothGattCharacteristic bluetoothGattCharacteristic3 = bluetoothGattCharacteristic2;
                                    DescriptorWriter descriptorWriter2 = descriptorWriter;
                                    byte[] bArr2 = bArr;
                                    if (r0 != 2) {
                                        return NotificationAndIndicationManager.writeClientCharacteristicConfig(bluetoothGattCharacteristic3, descriptorWriter2, bArr2).andThen(observable);
                                    }
                                    Completable writeClientCharacteristicConfig = NotificationAndIndicationManager.writeClientCharacteristicConfig(bluetoothGattCharacteristic3, descriptorWriter2, bArr2);
                                    if (writeClientCharacteristicConfig instanceof FuseToObservable) {
                                        completableToObservable = ((FuseToObservable) writeClientCharacteristicConfig).fuseToObservable();
                                    } else {
                                        completableToObservable = new CompletableToObservable(writeClientCharacteristicConfig);
                                    }
                                    completableToObservable.getClass();
                                    AtomicReference atomicReference = new AtomicReference();
                                    final ObservableIgnoreElementsCompletable observableIgnoreElementsCompletable = new ObservableIgnoreElementsCompletable(new ObservableAutoConnect(new ObservablePublish(new ObservablePublish.PublishSource(atomicReference), completableToObservable, atomicReference), 2));
                                    observable.getClass();
                                    return new ObservableMergeWithCompletable(observable, observableIgnoreElementsCompletable).map(new Function() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda8
                                        @Override // io.reactivex.functions.Function
                                        public final Object apply(Object obj) {
                                            Observable observable2 = (Observable) obj;
                                            Completable completable = observableIgnoreElementsCompletable;
                                            completable.getClass();
                                            CompletableOnErrorComplete completableOnErrorComplete = new CompletableOnErrorComplete(completable);
                                            observable2.getClass();
                                            return new ObservableMergeWithCompletable(observable2, completableOnErrorComplete);
                                        }
                                    });
                                }
                                return observable;
                            }
                        }).map(new Function() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda1
                            @Override // io.reactivex.functions.Function
                            public final Object apply(Object obj) {
                                Observable observable = (Observable) obj;
                                PublishSubject publishSubject2 = PublishSubject.this;
                                publishSubject2.getClass();
                                observable.getClass();
                                List asList = Arrays.asList(publishSubject2.map(new Functions.CastToClass()), new ObservableTakeUntil(observable, publishSubject2));
                                if (asList != null) {
                                    return new ObservableAmb(asList);
                                }
                                throw new NullPointerException("sources is null");
                            }
                        }), new Action() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda2
                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Type inference failed for: r2v3, types: [io.reactivex.internal.operators.completable.CompletableAndThenCompletable] */
                            @Override // io.reactivex.functions.Action
                            public final void run() {
                                NotificationAndIndicationManager notificationAndIndicationManager3 = NotificationAndIndicationManager.this;
                                PublishSubject publishSubject2 = publishSubject;
                                CharacteristicNotificationId characteristicNotificationId2 = characteristicNotificationId;
                                BluetoothGattCharacteristic bluetoothGattCharacteristic3 = bluetoothGattCharacteristic2;
                                NotificationSetupMode notificationSetupMode3 = notificationSetupMode2;
                                notificationAndIndicationManager3.getClass();
                                publishSubject2.onComplete();
                                synchronized (notificationAndIndicationManager3.activeNotificationObservableMap) {
                                    notificationAndIndicationManager3.activeNotificationObservableMap.remove(characteristicNotificationId2);
                                }
                                CompletableFromAction completableFromAction3 = new CompletableFromAction(new NotificationAndIndicationManager$$ExternalSyntheticLambda4(notificationAndIndicationManager3.bluetoothGatt, bluetoothGattCharacteristic3, false));
                                DescriptorWriter descriptorWriter2 = notificationAndIndicationManager3.descriptorWriter;
                                byte[] bArr2 = notificationAndIndicationManager3.configDisable;
                                if (notificationSetupMode3 != NotificationSetupMode.COMPAT) {
                                    completableFromAction3 = new CompletableAndThenCompletable(completableFromAction3, NotificationAndIndicationManager.writeClientCharacteristicConfig(bluetoothGattCharacteristic3, descriptorWriter2, bArr2));
                                }
                                completableFromAction3.subscribe(new CallbackCompletableObserver());
                            }
                        });
                        Observable<Object> observable = notificationAndIndicationManager2.gattCallback.disconnectionRouter.firstDisconnectionExceptionObs;
                        if (observable != null) {
                            Observable merge = Observable.merge(observableDoFinally, observable);
                            merge.getClass();
                            ObjectHelper.verifyPositive(1, "bufferSize");
                            ObservableReplay.ReplayBufferSupplier replayBufferSupplier = new ObservableReplay.ReplayBufferSupplier();
                            AtomicReference atomicReference = new AtomicReference();
                            ?? observableReplay = new ObservableReplay(new ObservableReplay.ReplaySource(atomicReference, replayBufferSupplier), merge, atomicReference, replayBufferSupplier);
                            boolean z3 = observableReplay instanceof ObservablePublishClassic;
                            ObservablePublishAlt observablePublishAlt = observableReplay;
                            if (z3) {
                                observablePublishAlt = new ObservablePublishAlt(((ObservablePublishClassic) observableReplay).publishSource());
                            }
                            ObservableRefCount observableRefCount = new ObservableRefCount(observablePublishAlt);
                            notificationAndIndicationManager2.activeNotificationObservableMap.put(characteristicNotificationId, new ActiveCharacteristicNotification(observableRefCount, z));
                            observableSource = observableRefCount;
                        } else {
                            throw new NullPointerException("other is null");
                        }
                    }
                }
                return observableSource;
            }
        }));
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public final ObservableElementAtSingle writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        IllegalOperationChecker illegalOperationChecker = this.illegalOperationChecker;
        illegalOperationChecker.getClass();
        return new ObservableElementAtSingle(new CompletableFromAction(new IllegalOperationChecker.AnonymousClass1(bluetoothGattCharacteristic, 76)).andThen(this.operationQueue.queue(this.operationsProvider.provideWriteCharacteristic(bluetoothGattCharacteristic, bArr))));
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public final ObservableIgnoreElementsCompletable writeDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        DescriptorWriter descriptorWriter = this.descriptorWriter;
        Observable queue = descriptorWriter.operationQueue.queue(descriptorWriter.operationsProvider.provideWriteDescriptor(bluetoothGattDescriptor, bArr));
        queue.getClass();
        return new ObservableIgnoreElementsCompletable(queue);
    }
}
