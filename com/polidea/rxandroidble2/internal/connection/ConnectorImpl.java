package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.ConnectionSetup;
import com.polidea.rxandroidble2.DaggerClientComponent$ConnectionComponentBuilder;
import com.polidea.rxandroidble2.DaggerClientComponent$ConnectionComponentImpl;
import com.polidea.rxandroidble2.DaggerClientComponent$DeviceComponentImpl;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import com.polidea.rxandroidble2.internal.operations.ConnectOperation;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl;
import com.polidea.rxandroidble2.internal.util.BleConnectionCompat;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ConnectorImpl implements Connector {
    public final Scheduler callbacksScheduler;
    public final ClientOperationQueue clientOperationQueue;
    public final ConnectionComponent.Builder connectionComponentBuilder;

    public ConnectorImpl(ClientOperationQueue clientOperationQueue, ConnectionComponent.Builder builder, Scheduler scheduler) {
        this.clientOperationQueue = clientOperationQueue;
        this.connectionComponentBuilder = builder;
        this.callbacksScheduler = scheduler;
    }

    @Override // com.polidea.rxandroidble2.internal.connection.Connector
    public final ObservableDefer prepareConnection(final ConnectionSetup connectionSetup) {
        return new ObservableDefer(new Callable() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                final Set unmodifiableSet;
                ConnectorImpl connectorImpl = ConnectorImpl.this;
                connectorImpl.getClass();
                ConnectionSetup connectionSetup2 = connectionSetup;
                DaggerClientComponent$ConnectionComponentBuilder autoConnect = connectorImpl.connectionComponentBuilder.autoConnect(connectionSetup2.autoConnect);
                autoConnect.suppressOperationChecks(connectionSetup2.suppressOperationCheck);
                Timeout timeout = connectionSetup2.operationTimeout;
                timeout.getClass();
                autoConnect.operationTimeout = timeout;
                final DaggerClientComponent$ConnectionComponentImpl build = autoConnect.build();
                ArrayList arrayList = new ArrayList(3);
                ConnectionSubscriptionWatcher connectionSubscriptionWatcher = (ConnectionSubscriptionWatcher) build.mtuWatcherProvider.get();
                if (connectionSubscriptionWatcher != null) {
                    arrayList.add(connectionSubscriptionWatcher);
                    ConnectionSubscriptionWatcher connectionSubscriptionWatcher2 = (ConnectionSubscriptionWatcher) build.disconnectActionProvider.get();
                    if (connectionSubscriptionWatcher2 != null) {
                        arrayList.add(connectionSubscriptionWatcher2);
                        ConnectionOperationQueueImpl connectionOperationQueueImpl = build.connectionOperationQueueImplProvider.get();
                        if (connectionOperationQueueImpl != null) {
                            arrayList.add(connectionOperationQueueImpl);
                            if (arrayList.isEmpty()) {
                                unmodifiableSet = Collections.emptySet();
                            } else if (arrayList.size() == 1) {
                                unmodifiableSet = Collections.singleton(arrayList.get(0));
                            } else {
                                unmodifiableSet = Collections.unmodifiableSet(new HashSet(arrayList));
                            }
                            ObservableFromCallable observableFromCallable = new ObservableFromCallable(new Callable() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl$$ExternalSyntheticLambda3
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    return (RxBleConnection) ((DaggerClientComponent$ConnectionComponentImpl) ConnectionComponent.this).rxBleConnectionImplProvider.get();
                                }
                            });
                            Observable<Object> observable = build.rxBleGattCallbackProvider.get().disconnectionRouter.firstDisconnectionExceptionObs;
                            if (observable != null) {
                                Observable merge = Observable.merge(observableFromCallable, observable);
                                DaggerClientComponent$DeviceComponentImpl daggerClientComponent$DeviceComponentImpl = build.deviceComponentImpl;
                                daggerClientComponent$DeviceComponentImpl.clientComponentImpl.getClass();
                                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                                if (defaultAdapter != null) {
                                    BluetoothDevice remoteDevice = defaultAdapter.getRemoteDevice(daggerClientComponent$DeviceComponentImpl.macAddress);
                                    UnsignedKt.checkNotNullFromProvides(remoteDevice);
                                    BleConnectionCompat bleConnectionCompat = new BleConnectionCompat(build.clientComponentImpl.applicationContext);
                                    RxBleGattCallback rxBleGattCallback = build.rxBleGattCallbackProvider.get();
                                    BluetoothGattProvider bluetoothGattProvider = build.bluetoothGattProvider.get();
                                    Scheduler scheduler = Schedulers.COMPUTATION;
                                    UnsignedKt.checkNotNullFromProvides(scheduler);
                                    Observable queue = connectorImpl.clientOperationQueue.queue(new ConnectOperation(remoteDevice, bleConnectionCompat, rxBleGattCallback, bluetoothGattProvider, new TimeoutConfiguration(35L, TimeUnit.SECONDS, scheduler), build.autoConnect.booleanValue(), daggerClientComponent$DeviceComponentImpl.provideConnectionStateChangeListenerProvider.get()));
                                    merge.getClass();
                                    if (queue != null) {
                                        ObservableDoFinally observableDoFinally = new ObservableDoFinally(new ObservableDoOnLifecycle(new ObservableDelaySubscriptionOther(merge, queue), new Consumer() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl$$ExternalSyntheticLambda1
                                            @Override // io.reactivex.functions.Consumer
                                            public final void accept(Object obj) {
                                                Iterator it = unmodifiableSet.iterator();
                                                while (it.hasNext()) {
                                                    ((ConnectionSubscriptionWatcher) it.next()).onConnectionSubscribed();
                                                }
                                            }
                                        }), new Action() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl$$ExternalSyntheticLambda2
                                            @Override // io.reactivex.functions.Action
                                            public final void run() {
                                                Iterator it = unmodifiableSet.iterator();
                                                while (it.hasNext()) {
                                                    ((ConnectionSubscriptionWatcher) it.next()).onConnectionUnsubscribed();
                                                }
                                            }
                                        });
                                        Scheduler scheduler2 = connectorImpl.callbacksScheduler;
                                        return observableDoFinally.subscribeOn(scheduler2).unsubscribeOn(scheduler2);
                                    }
                                    throw new NullPointerException("other is null");
                                }
                                throw RxBleAdapterWrapper.nullBluetoothAdapter;
                            }
                            throw new NullPointerException("other is null");
                        }
                        throw new NullPointerException("Set contributions cannot be null");
                    }
                    throw new NullPointerException("Set contributions cannot be null");
                }
                throw new NullPointerException("Set contributions cannot be null");
            }
        });
    }
}
