package com.polidea.rxandroidble2.internal.util;

import android.bluetooth.BluetoothAdapter;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.RxBleClient;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.RunnableDisposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.internal.operators.single.SingleMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class ClientStateObservable extends Observable<RxBleClient.State> {
    public final Observable<RxBleAdapterStateObservable.BleAdapterState> bleAdapterStateObservable;
    public final Observable<Boolean> locationServicesOkObservable;
    public final LocationServicesStatus locationServicesStatus;
    public final RxBleAdapterWrapper rxBleAdapterWrapper;
    public final Scheduler timerScheduler;

    /* renamed from: com.polidea.rxandroidble2.internal.util.ClientStateObservable$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements Function<Long, Boolean> {
        @Override // io.reactivex.functions.Function
        public final Boolean apply(Long l) throws Exception {
            boolean z;
            if (l.longValue() == 0) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    public ClientStateObservable(RxBleAdapterWrapper rxBleAdapterWrapper, Observable<RxBleAdapterStateObservable.BleAdapterState> observable, Observable<Boolean> observable2, LocationServicesStatus locationServicesStatus, Scheduler scheduler) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.bleAdapterStateObservable = observable;
        this.locationServicesOkObservable = observable2;
        this.locationServicesStatus = locationServicesStatus;
        this.timerScheduler = scheduler;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.polidea.rxandroidble2.internal.util.ClientStateObservable$4] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.polidea.rxandroidble2.internal.util.ClientStateObservable$2] */
    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super RxBleClient.State> observer) {
        boolean z;
        if (this.rxBleAdapterWrapper.bluetoothAdapter != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            observer.onSubscribe(new RunnableDisposable(Functions.EMPTY_RUNNABLE));
            observer.onComplete();
            return;
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (timeUnit != null) {
            Scheduler scheduler = this.timerScheduler;
            if (scheduler != null) {
                ObservableInterval observableInterval = new ObservableInterval(Math.max(0L, 0L), Math.max(0L, 1L), timeUnit, scheduler);
                final LocationServicesStatus locationServicesStatus = this.locationServicesStatus;
                new SingleFlatMapObservable(new SingleMap(new ObservableCountSingle(new ObservableTakeWhile(observableInterval, new Predicate<Long>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.2
                    @Override // io.reactivex.functions.Predicate
                    public final boolean test(Long l) throws Exception {
                        return !LocationServicesStatus.this.isLocationPermissionOk();
                    }
                })), new AnonymousClass1()), new Function<Boolean, Observable<RxBleClient.State>>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.4
                    @Override // io.reactivex.functions.Function
                    public final Observable<RxBleClient.State> apply(Boolean bool) throws Exception {
                        boolean z2;
                        RxBleAdapterStateObservable.BleAdapterState bleAdapterState;
                        Boolean bool2 = bool;
                        ClientStateObservable clientStateObservable = ClientStateObservable.this;
                        BluetoothAdapter bluetoothAdapter = clientStateObservable.rxBleAdapterWrapper.bluetoothAdapter;
                        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            bleAdapterState = RxBleAdapterStateObservable.BleAdapterState.STATE_ON;
                        } else {
                            bleAdapterState = RxBleAdapterStateObservable.BleAdapterState.STATE_OFF;
                        }
                        Observable<RxBleAdapterStateObservable.BleAdapterState> startWith = clientStateObservable.bleAdapterStateObservable.startWith(bleAdapterState);
                        final Observable<Boolean> observable = clientStateObservable.locationServicesOkObservable;
                        ObservableSource switchMap = startWith.switchMap(new Function<RxBleAdapterStateObservable.BleAdapterState, Observable<RxBleClient.State>>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.3

                            /* renamed from: com.polidea.rxandroidble2.internal.util.ClientStateObservable$3$1, reason: invalid class name */
                            /* loaded from: classes3.dex */
                            public final class AnonymousClass1 implements Function<Boolean, RxBleClient.State> {
                                @Override // io.reactivex.functions.Function
                                public final RxBleClient.State apply(Boolean bool) throws Exception {
                                    if (bool.booleanValue()) {
                                        return RxBleClient.State.READY;
                                    }
                                    return RxBleClient.State.LOCATION_SERVICES_NOT_ENABLED;
                                }
                            }

                            @Override // io.reactivex.functions.Function
                            public final Observable<RxBleClient.State> apply(RxBleAdapterStateObservable.BleAdapterState bleAdapterState2) throws Exception {
                                if (bleAdapterState2 != RxBleAdapterStateObservable.BleAdapterState.STATE_ON) {
                                    return Observable.just(RxBleClient.State.BLUETOOTH_NOT_ENABLED);
                                }
                                return Observable.this.map(new AnonymousClass1());
                            }
                        });
                        switchMap.getClass();
                        ObservableDistinctUntilChanged observableDistinctUntilChanged = new ObservableDistinctUntilChanged(switchMap);
                        if (bool2.booleanValue()) {
                            return new ObservableSkip(observableDistinctUntilChanged);
                        }
                        return observableDistinctUntilChanged;
                    }
                }).subscribe(observer);
                return;
            }
            throw new NullPointerException("scheduler is null");
        }
        throw new NullPointerException("unit is null");
    }
}
