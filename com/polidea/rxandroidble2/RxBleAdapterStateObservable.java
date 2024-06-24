package com.polidea.rxandroidble2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.polidea.rxandroidble2.internal.RxBleLog;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class RxBleAdapterStateObservable extends Observable<BleAdapterState> {
    public final ObservableRefCount bleAdapterStateObservable;

    /* loaded from: classes3.dex */
    public static class BleAdapterState {
        public final boolean isUsable;
        public final String stateName;
        public static final BleAdapterState STATE_ON = new BleAdapterState(true, "STATE_ON");
        public static final BleAdapterState STATE_OFF = new BleAdapterState(false, "STATE_OFF");
        public static final BleAdapterState STATE_TURNING_ON = new BleAdapterState(false, "STATE_TURNING_ON");
        public static final BleAdapterState STATE_TURNING_OFF = new BleAdapterState(false, "STATE_TURNING_OFF");

        public BleAdapterState(boolean z, String str) {
            this.isUsable = z;
            this.stateName = str;
        }

        public final String toString() {
            return this.stateName;
        }
    }

    public RxBleAdapterStateObservable(final Context context) {
        ObservableCreate observableCreate = new ObservableCreate(new ObservableOnSubscribe<BleAdapterState>() { // from class: com.polidea.rxandroidble2.RxBleAdapterStateObservable.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.polidea.rxandroidble2.RxBleAdapterStateObservable$1$1, android.content.BroadcastReceiver] */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableCreate.CreateEmitter createEmitter) {
                final ?? r0 = new BroadcastReceiver() { // from class: com.polidea.rxandroidble2.RxBleAdapterStateObservable.1.1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context2, Intent intent) {
                        BleAdapterState bleAdapterState;
                        switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1)) {
                            case 11:
                                bleAdapterState = BleAdapterState.STATE_TURNING_ON;
                                break;
                            case 12:
                                bleAdapterState = BleAdapterState.STATE_ON;
                                break;
                            case 13:
                                bleAdapterState = BleAdapterState.STATE_TURNING_OFF;
                                break;
                            default:
                                bleAdapterState = BleAdapterState.STATE_OFF;
                                break;
                        }
                        RxBleLog.i("Adapter state changed: %s", bleAdapterState);
                        ((ObservableCreate.CreateEmitter) createEmitter).onNext(bleAdapterState);
                    }
                };
                context.registerReceiver(r0, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                DisposableHelper.set(createEmitter, new CancellableDisposable(new Cancellable() { // from class: com.polidea.rxandroidble2.RxBleAdapterStateObservable.1.2
                    @Override // io.reactivex.functions.Cancellable
                    public final void cancel() {
                        context.unregisterReceiver(r0);
                    }
                }));
            }
        });
        TrampolineScheduler trampolineScheduler = Schedulers.TRAMPOLINE;
        ObservableUnsubscribeOn unsubscribeOn = observableCreate.subscribeOn(trampolineScheduler).unsubscribeOn(trampolineScheduler);
        AtomicReference atomicReference = new AtomicReference();
        this.bleAdapterStateObservable = new ObservableRefCount(new ObservablePublishAlt(new ObservablePublish(new ObservablePublish.PublishSource(atomicReference), unsubscribeOn, atomicReference).publishSource()));
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super BleAdapterState> observer) {
        this.bleAdapterStateObservable.subscribe(observer);
    }
}
