package com.polidea.rxandroidble2.internal.serialization;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class RxBleThreadFactory extends AtomicLong implements ThreadFactory {

    /* loaded from: classes3.dex */
    public static final class RxBleNonBlockingThread extends Thread {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        RxBleNonBlockingThread rxBleNonBlockingThread = new RxBleNonBlockingThread(runnable, "RxBleThread-" + incrementAndGet());
        rxBleNonBlockingThread.setPriority(5);
        rxBleNonBlockingThread.setDaemon(true);
        return rxBleNonBlockingThread;
    }
}
