package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideComputationSchedulerFactory;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideLocationServicesStatusFactory;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable_Factory;
import io.reactivex.Observable;
import io.reactivex.Scheduler;

/* loaded from: classes3.dex */
public final class ClientStateObservable_Factory implements Provider {
    public final Provider<Observable<RxBleAdapterStateObservable.BleAdapterState>> bleAdapterStateObservableProvider;
    public final Provider<Observable<Boolean>> locationServicesOkObservableProvider;
    public final Provider<LocationServicesStatus> locationServicesStatusProvider;
    public final Provider<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
    public final Provider<Scheduler> timerSchedulerProvider;

    public ClientStateObservable_Factory(Provider provider, RxBleAdapterStateObservable_Factory rxBleAdapterStateObservable_Factory, ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory clientComponent_ClientModule_ProvideLocationServicesOkObservableFactory, ClientComponent_ClientModule_ProvideLocationServicesStatusFactory clientComponent_ClientModule_ProvideLocationServicesStatusFactory) {
        ClientComponent_ClientModule_ProvideComputationSchedulerFactory clientComponent_ClientModule_ProvideComputationSchedulerFactory = ClientComponent_ClientModule_ProvideComputationSchedulerFactory.InstanceHolder.INSTANCE;
        this.rxBleAdapterWrapperProvider = provider;
        this.bleAdapterStateObservableProvider = rxBleAdapterStateObservable_Factory;
        this.locationServicesOkObservableProvider = clientComponent_ClientModule_ProvideLocationServicesOkObservableFactory;
        this.locationServicesStatusProvider = clientComponent_ClientModule_ProvideLocationServicesStatusFactory;
        this.timerSchedulerProvider = clientComponent_ClientModule_ProvideComputationSchedulerFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ClientStateObservable(this.rxBleAdapterWrapperProvider.get(), this.bleAdapterStateObservableProvider.get(), this.locationServicesOkObservableProvider.get(), this.locationServicesStatusProvider.get(), this.timerSchedulerProvider.get());
    }
}
