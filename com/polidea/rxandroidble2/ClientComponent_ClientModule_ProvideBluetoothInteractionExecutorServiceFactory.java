package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        UnsignedKt.checkNotNullFromProvides(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }
}
