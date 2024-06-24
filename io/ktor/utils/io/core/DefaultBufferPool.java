package io.ktor.utils.io.core;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import io.ktor.utils.io.bits.Allocator;
import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.DefaultPool;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferFactory.kt */
/* loaded from: classes3.dex */
public final class DefaultBufferPool extends DefaultPool<ChunkBuffer> {
    public final Allocator allocator;
    public final int bufferSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultBufferPool() {
        super(1000);
        DefaultAllocator defaultAllocator = DefaultAllocator.INSTANCE;
        this.bufferSize = 4096;
        this.allocator = defaultAllocator;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final ChunkBuffer clearInstance(ChunkBuffer chunkBuffer) {
        ChunkBuffer chunkBuffer2 = chunkBuffer;
        chunkBuffer2.unpark$ktor_io();
        chunkBuffer2.reset();
        return chunkBuffer2;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void disposeInstance(ChunkBuffer chunkBuffer) {
        ChunkBuffer instance = chunkBuffer;
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.allocator.mo1653free3GNKZMM(instance.memory);
        if (ChunkBuffer.refCount$FU.compareAndSet(instance, 0, -1)) {
            instance.cleanNext();
            instance.origin = null;
            return;
        }
        throw new IllegalStateException("Unable to unlink: buffer is in use.");
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final ChunkBuffer produceInstance() {
        return new ChunkBuffer(this.allocator.mo1652allocgFvZug(this.bufferSize), null, this);
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void validateInstance(ChunkBuffer chunkBuffer) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ChunkBuffer instance = chunkBuffer;
        Intrinsics.checkNotNullParameter(instance, "instance");
        long limit = instance.memory.limit();
        int r3 = this.bufferSize;
        boolean z6 = true;
        if (limit == r3) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ChunkBuffer chunkBuffer2 = ChunkBuffer.Empty;
            if (instance != chunkBuffer2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (instance != chunkBuffer2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (instance.getReferenceCount() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        if (instance.getNext() == null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            if (instance.origin != null) {
                                z6 = false;
                            }
                            if (z6) {
                                return;
                            } else {
                                throw new IllegalStateException("Recycled instance shouldn't be a view or another buffer.".toString());
                            }
                        }
                        throw new IllegalStateException("Recycled instance shouldn't be a part of a chain.".toString());
                    }
                    throw new IllegalStateException("Unable to clear buffer: it is still in use.".toString());
                }
                throw new IllegalStateException("Empty instance couldn't be recycled".toString());
            }
            throw new IllegalStateException("ChunkBuffer.Empty couldn't be recycled".toString());
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Buffer size mismatch. Expected: ", r3, ", actual: ");
        m.append(r0.limit());
        throw new IllegalStateException(m.toString().toString());
    }
}
