package com.polidea.rxandroidble2;

import android.content.Context;
import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class RxBleAdapterStateObservable_Factory implements Provider {
    public final Provider<Context> contextProvider;

    public RxBleAdapterStateObservable_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new RxBleAdapterStateObservable(this.contextProvider.get());
    }
}
