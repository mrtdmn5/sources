package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.core.BufferFactoryKt;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChunkBuffer.kt */
/* loaded from: classes3.dex */
public final class ChunkBuffer$Companion$Pool$1 implements ObjectPool<ChunkBuffer> {
    @Override // io.ktor.utils.io.pool.ObjectPool
    public final ChunkBuffer borrow() {
        return BufferFactoryKt.DefaultChunkedBufferPool.borrow();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        dispose();
    }

    public final void dispose() {
        BufferFactoryKt.DefaultChunkedBufferPool.dispose();
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void recycle(ChunkBuffer chunkBuffer) {
        ChunkBuffer instance = chunkBuffer;
        Intrinsics.checkNotNullParameter(instance, "instance");
        BufferFactoryKt.DefaultChunkedBufferPool.recycle(instance);
    }
}
