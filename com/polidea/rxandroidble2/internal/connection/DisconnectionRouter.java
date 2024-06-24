package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothAdapter;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.exceptions.BleAdapterDisabledException;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableReplay;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class DisconnectionRouter implements DisconnectionRouterOutput {
    public final BehaviorRelay<BleException> bleExceptionBehaviorRelay;
    public final Observable<Object> firstDisconnectionExceptionObs;
    public final Observable<BleException> firstDisconnectionValueObs;

    /* renamed from: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Consumer<Throwable> {
        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable th) throws Exception {
            RxBleLog.throwShade(6, th, "Failed to monitor adapter state.", new Object[0]);
        }
    }

    /* renamed from: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements Consumer<BleException> {
        @Override // io.reactivex.functions.Consumer
        public final void accept(BleException bleException) throws Exception {
            RxBleLog.v("An exception received, indicating that the adapter has became unusable.", new Object[0]);
        }
    }

    /* renamed from: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter$5, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass5 implements Function<BleException, ObservableSource<?>> {
        @Override // io.reactivex.functions.Function
        public final ObservableSource<?> apply(BleException bleException) throws Exception {
            return Observable.error(bleException);
        }
    }

    /* renamed from: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter$6, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass6 implements Predicate<Boolean> {
        @Override // io.reactivex.functions.Predicate
        public final boolean test(Boolean bool) throws Exception {
            return !bool.booleanValue();
        }
    }

    /* renamed from: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter$7, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass7 implements Function<RxBleAdapterStateObservable.BleAdapterState, Boolean> {
        @Override // io.reactivex.functions.Function
        public final Boolean apply(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) throws Exception {
            return Boolean.valueOf(bleAdapterState.isUsable);
        }
    }

    public DisconnectionRouter(final String str, RxBleAdapterWrapper rxBleAdapterWrapper, Observable<RxBleAdapterStateObservable.BleAdapterState> observable) {
        boolean z;
        BehaviorRelay<BleException> behaviorRelay = new BehaviorRelay<>();
        this.bleExceptionBehaviorRelay = behaviorRelay;
        Observable<R> map = observable.map(new AnonymousClass7());
        BluetoothAdapter bluetoothAdapter = rxBleAdapterWrapper.bluetoothAdapter;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            z = true;
        } else {
            z = false;
        }
        ObservableSource map2 = new ObservableFilter(map.startWith(Boolean.valueOf(z)), new AnonymousClass6()).map(new Function<Boolean, BleException>() { // from class: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter.3
            @Override // io.reactivex.functions.Function
            public final BleException apply(Boolean bool) throws Exception {
                return new BleDisconnectedException(str, new BleAdapterDisabledException());
            }
        });
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        Functions.EmptyConsumer emptyConsumer = Functions.EMPTY_CONSUMER;
        final LambdaObserver subscribe = new ObservableDoOnEach(map2, anonymousClass2, emptyConsumer, Functions.EMPTY_ACTION).subscribe(behaviorRelay, new AnonymousClass1());
        ObservableSource fuseToObservable = new ObservableElementAtMaybe(behaviorRelay).fuseToObservable();
        Action action = new Action() { // from class: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter.4
            @Override // io.reactivex.functions.Action
            public final void run() {
                subscribe.dispose();
            }
        };
        fuseToObservable.getClass();
        ObservableDoOnEach observableDoOnEach = new ObservableDoOnEach(fuseToObservable, emptyConsumer, new Functions.ActionConsumer(action), action);
        ObservableReplay.UnBoundedFactory unBoundedFactory = ObservableReplay.DEFAULT_UNBOUNDED_FACTORY;
        AtomicReference atomicReference = new AtomicReference();
        ObservableReplay observableReplay = new ObservableReplay(new ObservableReplay.ReplaySource(atomicReference, unBoundedFactory), observableDoOnEach, atomicReference, unBoundedFactory);
        observableReplay.connect(emptyConsumer);
        this.firstDisconnectionValueObs = observableReplay;
        this.firstDisconnectionExceptionObs = observableReplay.flatMap(new AnonymousClass5());
    }

    @Override // com.polidea.rxandroidble2.internal.connection.DisconnectionRouterOutput
    public final Observable<BleException> asValueOnlyObservable() {
        return this.firstDisconnectionValueObs;
    }
}
