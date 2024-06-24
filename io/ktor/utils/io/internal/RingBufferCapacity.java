package io.ktor.utils.io.internal;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: RingBufferCapacity.kt */
/* loaded from: classes3.dex */
public final class RingBufferCapacity {
    public static final /* synthetic */ AtomicIntegerFieldUpdater _availableForRead$FU$internal = AtomicIntegerFieldUpdater.newUpdater(RingBufferCapacity.class, "_availableForRead$internal");
    public static final /* synthetic */ AtomicIntegerFieldUpdater _availableForWrite$FU$internal = AtomicIntegerFieldUpdater.newUpdater(RingBufferCapacity.class, "_availableForWrite$internal");
    public static final /* synthetic */ AtomicIntegerFieldUpdater _pendingToFlush$FU = AtomicIntegerFieldUpdater.newUpdater(RingBufferCapacity.class, "_pendingToFlush");
    public volatile /* synthetic */ int _availableForWrite$internal;
    public final int totalCapacity;
    public volatile /* synthetic */ int _availableForRead$internal = 0;
    volatile /* synthetic */ int _pendingToFlush = 0;

    public RingBufferCapacity(int r2) {
        this.totalCapacity = r2;
        this._availableForWrite$internal = r2;
    }

    public final void completeRead(int r7) {
        int r0;
        int r1;
        do {
            r0 = this._availableForWrite$internal;
            r1 = r0 + r7;
            if (r1 > this.totalCapacity) {
                StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("Completed read overflow: ", r0, " + ", r7, " = ");
                m.append(r1);
                m.append(" > ");
                m.append(this.totalCapacity);
                throw new IllegalArgumentException(m.toString());
            }
        } while (!_availableForWrite$FU$internal.compareAndSet(this, r0, r1));
    }

    public final void completeWrite(int r6) {
        int r0;
        int r1;
        do {
            r0 = this._pendingToFlush;
            r1 = r0 + r6;
            if (r1 > this.totalCapacity) {
                StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("Complete write overflow: ", r0, " + ", r6, " > ");
                m.append(this.totalCapacity);
                throw new IllegalArgumentException(m.toString());
            }
        } while (!_pendingToFlush$FU.compareAndSet(this, r0, r1));
    }

    public final boolean flush() {
        int andSet = _pendingToFlush$FU.getAndSet(this, 0);
        if (andSet == 0) {
            if (this._availableForRead$internal <= 0) {
                return false;
            }
            return true;
        }
        if (_availableForRead$FU$internal.addAndGet(this, andSet) <= 0) {
            return false;
        }
        return true;
    }

    public final boolean isFull() {
        if (this._availableForWrite$internal == 0) {
            return true;
        }
        return false;
    }

    public final void resetForRead() {
        this._availableForRead$internal = this.totalCapacity;
        this._availableForWrite$internal = 0;
        this._pendingToFlush = 0;
    }

    public final void resetForWrite() {
        this._availableForRead$internal = 0;
        this._pendingToFlush = 0;
        this._availableForWrite$internal = this.totalCapacity;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RingBufferCapacity[read: ");
        sb.append(this._availableForRead$internal);
        sb.append(", write: ");
        sb.append(this._availableForWrite$internal);
        sb.append(", flush: ");
        sb.append(this._pendingToFlush);
        sb.append(", capacity: ");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.totalCapacity, ']');
    }

    public final boolean tryLockForRelease() {
        int r0;
        do {
            r0 = this._availableForWrite$internal;
            if (this._pendingToFlush > 0 || this._availableForRead$internal > 0 || r0 != this.totalCapacity) {
                return false;
            }
        } while (!_availableForWrite$FU$internal.compareAndSet(this, r0, 0));
        return true;
    }

    public final int tryReadAtMost(int r4) {
        int r0;
        int min;
        do {
            r0 = this._availableForRead$internal;
            min = Math.min(r4, r0);
            if (min == 0) {
                return 0;
            }
        } while (!_availableForRead$FU$internal.compareAndSet(this, r0, r0 - min));
        return Math.min(r4, r0);
    }

    public final int tryWriteAtMost(int r4) {
        int r0;
        int min;
        do {
            r0 = this._availableForWrite$internal;
            min = Math.min(r4, r0);
            if (min == 0) {
                return 0;
            }
        } while (!_availableForWrite$FU$internal.compareAndSet(this, r0, r0 - min));
        return Math.min(r4, r0);
    }
}
