package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.serialization.RxBleThreadFactory;
import io.reactivex.internal.schedulers.SingleScheduler;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new SingleScheduler(new RxBleThreadFactory());
    }
}
