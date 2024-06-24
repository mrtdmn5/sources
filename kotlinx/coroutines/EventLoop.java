package kotlinx.coroutines;

import kotlin.collections.ArrayDeque;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public abstract class EventLoop extends CoroutineDispatcher {
    public static final /* synthetic */ int $r8$clinit = 0;
    public boolean shared;
    public ArrayDeque<DispatchedTask<?>> unconfinedQueue;
    public long useCount;

    public final void decrementUseCount(boolean z) {
        long j;
        long j2 = this.useCount;
        if (z) {
            j = 4294967296L;
        } else {
            j = 1;
        }
        long j3 = j2 - j;
        this.useCount = j3;
        if (j3 <= 0 && this.shared) {
            shutdown();
        }
    }

    public final void dispatchUnconfined(DispatchedTask<?> dispatchedTask) {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque<>();
            this.unconfinedQueue = arrayDeque;
        }
        arrayDeque.addLast(dispatchedTask);
    }

    public final void incrementUseCount(boolean z) {
        long j;
        long j2 = this.useCount;
        if (z) {
            j = 4294967296L;
        } else {
            j = 1;
        }
        this.useCount = j + j2;
        if (!z) {
            this.shared = true;
        }
    }

    public final boolean isUnconfinedLoopActive() {
        if (this.useCount >= 4294967296L) {
            return true;
        }
        return false;
    }

    public long processNextEvent() {
        if (!processUnconfinedEvent()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final boolean processUnconfinedEvent() {
        DispatchedTask<?> removeFirst;
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            return false;
        }
        if (arrayDeque.isEmpty()) {
            removeFirst = null;
        } else {
            removeFirst = arrayDeque.removeFirst();
        }
        DispatchedTask<?> dispatchedTask = removeFirst;
        if (dispatchedTask == null) {
            return false;
        }
        dispatchedTask.run();
        return true;
    }

    public void shutdown() {
    }
}
