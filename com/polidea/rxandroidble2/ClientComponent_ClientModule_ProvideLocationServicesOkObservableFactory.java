package com.polidea.rxandroidble2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideDeviceSdkFactory;
import com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory_Factory;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.schedulers.Schedulers;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory implements Provider {
    public final Provider<Integer> deviceSdkProvider = ClientComponent_ClientModule_ProvideDeviceSdkFactory.InstanceHolder.INSTANCE;
    public final Provider<LocationServicesOkObservableApi23Factory> locationServicesOkObservableApi23FactoryProvider;

    public ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory(LocationServicesOkObservableApi23Factory_Factory locationServicesOkObservableApi23Factory_Factory) {
        this.locationServicesOkObservableApi23FactoryProvider = locationServicesOkObservableApi23Factory_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        int intValue = this.deviceSdkProvider.get().intValue();
        LocationServicesOkObservableApi23Factory locationServicesOkObservableApi23Factory = this.locationServicesOkObservableApi23FactoryProvider.get();
        if (intValue < 23) {
            return ObservableNever.INSTANCE.startWith(Boolean.TRUE);
        }
        locationServicesOkObservableApi23Factory.getClass();
        ObservableDistinctUntilChanged observableDistinctUntilChanged = new ObservableDistinctUntilChanged(new ObservableCreate(new ObservableOnSubscribe<Boolean>() { // from class: com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory.1

            /* renamed from: com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory$1$1 */
            /* loaded from: classes3.dex */
            public final class C01381 extends BroadcastReceiver {
                public final /* synthetic */ ObservableEmitter val$emitter;

                public C01381(ObservableCreate.CreateEmitter createEmitter) {
                    r2 = createEmitter;
                }

                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    ((ObservableCreate.CreateEmitter) r2).onNext(Boolean.valueOf(LocationServicesOkObservableApi23Factory.this.locationServicesStatus.isLocationProviderOk()));
                }
            }

            /* renamed from: com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory$1$2 */
            /* loaded from: classes3.dex */
            public final class AnonymousClass2 implements Cancellable {
                public final /* synthetic */ BroadcastReceiver val$broadcastReceiver;

                public AnonymousClass2(C01381 c01381) {
                    r2 = c01381;
                }

                @Override // io.reactivex.functions.Cancellable
                public final void cancel() {
                    LocationServicesOkObservableApi23Factory.this.context.unregisterReceiver(r2);
                }
            }

            public AnonymousClass1() {
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableCreate.CreateEmitter createEmitter) {
                LocationServicesOkObservableApi23Factory locationServicesOkObservableApi23Factory2 = LocationServicesOkObservableApi23Factory.this;
                boolean isLocationProviderOk = locationServicesOkObservableApi23Factory2.locationServicesStatus.isLocationProviderOk();
                C01381 c01381 = new BroadcastReceiver() { // from class: com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory.1.1
                    public final /* synthetic */ ObservableEmitter val$emitter;

                    public C01381(ObservableCreate.CreateEmitter createEmitter2) {
                        r2 = createEmitter2;
                    }

                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context, Intent intent) {
                        ((ObservableCreate.CreateEmitter) r2).onNext(Boolean.valueOf(LocationServicesOkObservableApi23Factory.this.locationServicesStatus.isLocationProviderOk()));
                    }
                };
                createEmitter2.onNext(Boolean.valueOf(isLocationProviderOk));
                locationServicesOkObservableApi23Factory2.context.registerReceiver(c01381, new IntentFilter("android.location.MODE_CHANGED"));
                DisposableHelper.set(createEmitter2, new CancellableDisposable(new Cancellable() { // from class: com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory.1.2
                    public final /* synthetic */ BroadcastReceiver val$broadcastReceiver;

                    public AnonymousClass2(C01381 c013812) {
                        r2 = c013812;
                    }

                    @Override // io.reactivex.functions.Cancellable
                    public final void cancel() {
                        LocationServicesOkObservableApi23Factory.this.context.unregisterReceiver(r2);
                    }
                }));
            }
        }));
        TrampolineScheduler trampolineScheduler = Schedulers.TRAMPOLINE;
        return observableDistinctUntilChanged.subscribeOn(trampolineScheduler).unsubscribeOn(trampolineScheduler);
    }
}
