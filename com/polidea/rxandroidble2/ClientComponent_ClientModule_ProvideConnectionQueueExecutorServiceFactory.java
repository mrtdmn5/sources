package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory INSTANCE = new ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        UnsignedKt.checkNotNullFromProvides(newCachedThreadPool);
        return newCachedThreadPool;
    }
}
