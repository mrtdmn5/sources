package com.polidea.rxandroidble2.internal.serialization;

import com.polidea.rxandroidble2.internal.RxBleLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class QueueSemaphore {
    public final AtomicBoolean isReleased = new AtomicBoolean(false);

    public final synchronized void awaitRelease() throws InterruptedException {
        while (!this.isReleased.get()) {
            try {
                wait();
            } catch (InterruptedException e) {
                if (!this.isReleased.get()) {
                    RxBleLog.throwShade(5, e, "Queue's awaitRelease() has been interrupted abruptly while it wasn't released by the release() method.", new Object[0]);
                }
            }
        }
    }

    public final synchronized void release() {
        if (this.isReleased.compareAndSet(false, true)) {
            notify();
        }
    }
}
