package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChunkBuffer.kt */
/* loaded from: classes3.dex */
public final class ChunkBuffer extends Buffer {
    public static final ChunkBuffer Empty;
    public static final ChunkBuffer$Companion$EmptyPool$1 EmptyPool;
    public static final ChunkBuffer$Companion$Pool$1 Pool = new ChunkBuffer$Companion$Pool$1();
    public static final /* synthetic */ AtomicReferenceFieldUpdater nextRef$FU;
    public static final /* synthetic */ AtomicIntegerFieldUpdater refCount$FU;
    private volatile /* synthetic */ Object nextRef;
    public ChunkBuffer origin;
    public final ObjectPool<ChunkBuffer> parentPool;
    private volatile /* synthetic */ int refCount;

    static {
        ChunkBuffer$Companion$EmptyPool$1 chunkBuffer$Companion$EmptyPool$1 = new ChunkBuffer$Companion$EmptyPool$1();
        EmptyPool = chunkBuffer$Companion$EmptyPool$1;
        Empty = new ChunkBuffer(Memory.Empty, null, chunkBuffer$Companion$EmptyPool$1);
        nextRef$FU = AtomicReferenceFieldUpdater.newUpdater(ChunkBuffer.class, Object.class, "nextRef");
        refCount$FU = AtomicIntegerFieldUpdater.newUpdater(ChunkBuffer.class, "refCount");
    }

    public ChunkBuffer() {
        throw null;
    }

    public ChunkBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, ObjectPool objectPool) {
        super(byteBuffer);
        this.parentPool = objectPool;
        if (chunkBuffer != this) {
            this.nextRef = null;
            this.refCount = 1;
            this.origin = chunkBuffer;
            return;
        }
        throw new IllegalArgumentException("A chunk couldn't be a view of itself.".toString());
    }

    public final ChunkBuffer cleanNext() {
        return (ChunkBuffer) nextRef$FU.getAndSet(this, null);
    }

    public final ChunkBuffer duplicate() {
        int r1;
        ChunkBuffer chunkBuffer = this.origin;
        if (chunkBuffer == null) {
            chunkBuffer = this;
        }
        do {
            r1 = chunkBuffer.refCount;
            if (r1 > 0) {
            } else {
                throw new IllegalStateException("Unable to acquire chunk: it is already released.");
            }
        } while (!refCount$FU.compareAndSet(chunkBuffer, r1, r1 + 1));
        ChunkBuffer chunkBuffer2 = new ChunkBuffer(this.memory, chunkBuffer, this.parentPool);
        chunkBuffer2.limit = this.limit;
        chunkBuffer2.startGap = this.startGap;
        chunkBuffer2.readPosition = this.readPosition;
        chunkBuffer2.writePosition = this.writePosition;
        return chunkBuffer2;
    }

    public final ChunkBuffer getNext() {
        return (ChunkBuffer) this.nextRef;
    }

    public final int getReferenceCount() {
        return this.refCount;
    }

    public final void release(ObjectPool<ChunkBuffer> pool) {
        int r0;
        int r1;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        boolean z;
        Intrinsics.checkNotNullParameter(pool, "pool");
        do {
            r0 = this.refCount;
            if (r0 > 0) {
                r1 = r0 - 1;
                atomicIntegerFieldUpdater = refCount$FU;
            } else {
                throw new IllegalStateException("Unable to release: it is already released.");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, r0, r1));
        if (r1 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ChunkBuffer chunkBuffer = this.origin;
            if (chunkBuffer != null) {
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, -1)) {
                    cleanNext();
                    this.origin = null;
                    chunkBuffer.release(pool);
                    return;
                }
                throw new IllegalStateException("Unable to unlink: buffer is in use.");
            }
            ObjectPool<ChunkBuffer> objectPool = this.parentPool;
            if (objectPool != null) {
                pool = objectPool;
            }
            pool.recycle(this);
        }
    }

    public final void reset() {
        boolean z;
        if (this.origin == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            releaseStartGap$ktor_io(0);
            int r0 = this.capacity;
            this.limit = r0;
            resetForWrite(r0 - this.startGap);
            this.nextRef = null;
            return;
        }
        throw new IllegalArgumentException("Unable to reset buffer with origin".toString());
    }

    public final void setNext(ChunkBuffer chunkBuffer) {
        boolean z;
        if (chunkBuffer == null) {
            cleanNext();
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = nextRef$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, chunkBuffer)) {
                z = true;
                break;
            } else if (atomicReferenceFieldUpdater.get(this) != null) {
                z = false;
                break;
            }
        }
        if (z) {
        } else {
            throw new IllegalStateException("This chunk has already a next chunk.");
        }
    }

    public final void unpark$ktor_io() {
        int r0;
        do {
            r0 = this.refCount;
            if (r0 >= 0) {
                if (r0 > 0) {
                    throw new IllegalStateException("This instance is already in use but somehow appeared in the pool.");
                }
            } else {
                throw new IllegalStateException("This instance is already disposed and couldn't be borrowed.");
            }
        } while (!refCount$FU.compareAndSet(this, r0, 1));
    }
}
