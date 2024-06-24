package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.exceptions.BleGattException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import io.reactivex.disposables.SerialDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class MtuWatcher implements ConnectionSubscriptionWatcher, MtuProvider, Consumer<Integer> {
    public final ObservableRetryPredicate mtuObservable;
    public final SerialDisposable serialSubscription = new SerialDisposable();

    /* renamed from: com.polidea.rxandroidble2.internal.connection.MtuWatcher$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements Predicate<Throwable> {
        @Override // io.reactivex.functions.Predicate
        public final boolean test(Throwable th) throws Exception {
            Throwable th2 = th;
            if ((th2 instanceof BleGattException) && ((BleGattException) th2).bleGattOperationType == BleGattOperationType.ON_MTU_CHANGED) {
                return true;
            }
            return false;
        }
    }

    public MtuWatcher(RxBleGattCallback rxBleGattCallback) {
        this.mtuObservable = new ObservableRetryPredicate(rxBleGattCallback.withDisconnectionHandling(rxBleGattCallback.changedMtuOutput).delay(0L, TimeUnit.SECONDS, rxBleGattCallback.callbackScheduler), new AnonymousClass1());
    }

    @Override // io.reactivex.functions.Consumer
    public final /* bridge */ /* synthetic */ void accept(Integer num) throws Exception {
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public final void onConnectionSubscribed() {
        DisposableHelper.set(this.serialSubscription.resource, this.mtuObservable.subscribe(this, Functions.EMPTY_CONSUMER));
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public final void onConnectionUnsubscribed() {
        this.serialSubscription.dispose();
    }
}
