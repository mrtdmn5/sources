package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable_Factory;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper_Factory;
import io.reactivex.Observable;

/* loaded from: classes3.dex */
public final class DisconnectionRouter_Factory implements Provider {
    public final Provider<Observable<RxBleAdapterStateObservable.BleAdapterState>> adapterStateObservableProvider;
    public final Provider<RxBleAdapterWrapper> adapterWrapperProvider;
    public final Provider<String> macAddressProvider;

    public DisconnectionRouter_Factory(InstanceFactory instanceFactory, RxBleAdapterWrapper_Factory rxBleAdapterWrapper_Factory, RxBleAdapterStateObservable_Factory rxBleAdapterStateObservable_Factory) {
        this.macAddressProvider = instanceFactory;
        this.adapterWrapperProvider = rxBleAdapterWrapper_Factory;
        this.adapterStateObservableProvider = rxBleAdapterStateObservable_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new DisconnectionRouter(this.macAddressProvider.get(), this.adapterWrapperProvider.get(), this.adapterStateObservableProvider.get());
    }
}
