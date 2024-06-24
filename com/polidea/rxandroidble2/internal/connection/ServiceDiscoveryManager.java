package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattService;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.maybe.MaybeFilterSingle;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleDoOnError;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.SerializedSubject;
import io.reactivex.subjects.Subject;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class ServiceDiscoveryManager {
    public final BluetoothGatt bluetoothGatt;
    public SingleCache deviceServicesObservable;
    public boolean hasCachedResults;
    public final OperationsProvider operationProvider;
    public final ConnectionOperationQueue operationQueue;
    public final Subject<TimeoutConfiguration> timeoutBehaviorSubject;

    /* renamed from: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass4 implements Function<List<BluetoothGattService>, RxBleDeviceServices> {
        @Override // io.reactivex.functions.Function
        public final RxBleDeviceServices apply(List<BluetoothGattService> list) throws Exception {
            return new RxBleDeviceServices(list);
        }
    }

    /* renamed from: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager$5, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass5 implements Predicate<List<BluetoothGattService>> {
        @Override // io.reactivex.functions.Predicate
        public final boolean test(List<BluetoothGattService> list) throws Exception {
            if (list.size() > 0) {
                return true;
            }
            return false;
        }
    }

    public ServiceDiscoveryManager(ConnectionOperationQueue connectionOperationQueue, BluetoothGatt bluetoothGatt, OperationsProvider operationsProvider) {
        Subject behaviorSubject = new BehaviorSubject();
        this.timeoutBehaviorSubject = behaviorSubject instanceof SerializedSubject ? behaviorSubject : new SerializedSubject(behaviorSubject);
        this.hasCachedResults = false;
        this.operationQueue = connectionOperationQueue;
        this.bluetoothGatt = bluetoothGatt;
        this.operationProvider = operationsProvider;
        reset();
    }

    public final void reset() {
        this.hasCachedResults = false;
        MaybeMap maybeMap = new MaybeMap(new MaybeFilterSingle(new SingleFromCallable(new Callable<List<BluetoothGattService>>() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.6
            @Override // java.util.concurrent.Callable
            public final List<BluetoothGattService> call() throws Exception {
                return ServiceDiscoveryManager.this.bluetoothGatt.getServices();
            }
        }), new AnonymousClass5()), new AnonymousClass4());
        Subject<TimeoutConfiguration> subject = this.timeoutBehaviorSubject;
        subject.getClass();
        this.deviceServicesObservable = new SingleCache(new SingleDoOnError(new SingleDoOnSuccess(new MaybeSwitchIfEmptySingle(maybeMap, new SingleFlatMap(new ObservableElementAtSingle(subject), new Function<TimeoutConfiguration, Single<RxBleDeviceServices>>() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.7
            @Override // io.reactivex.functions.Function
            public final Single<RxBleDeviceServices> apply(TimeoutConfiguration timeoutConfiguration) throws Exception {
                TimeoutConfiguration timeoutConfiguration2 = timeoutConfiguration;
                ServiceDiscoveryManager serviceDiscoveryManager = ServiceDiscoveryManager.this;
                Observable queue = serviceDiscoveryManager.operationQueue.queue(serviceDiscoveryManager.operationProvider.provideServiceDiscoveryOperation(timeoutConfiguration2.timeout, timeoutConfiguration2.timeoutTimeUnit));
                queue.getClass();
                return new ObservableElementAtSingle(queue);
            }
        })), new Functions.ActionConsumer(new Action() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.2
            @Override // io.reactivex.functions.Action
            public final void run() {
                ServiceDiscoveryManager.this.hasCachedResults = true;
            }
        })), new Functions.ActionConsumer(new Action() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.3
            @Override // io.reactivex.functions.Action
            public final void run() {
                ServiceDiscoveryManager.this.reset();
            }
        })));
    }
}
