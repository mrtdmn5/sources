package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.pool.ObjectPool;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChunkBuffer.kt */
/* loaded from: classes3.dex */
public final class ChunkBuffer$Companion$EmptyPool$1 implements ObjectPool<ChunkBuffer> {
    @Override // io.ktor.utils.io.pool.ObjectPool
    public final ChunkBuffer borrow() {
        return ChunkBuffer.Empty;
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void recycle(ChunkBuffer chunkBuffer) {
        boolean z;
        ChunkBuffer instance = chunkBuffer;
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (instance == ChunkBuffer.Empty) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        } else {
            throw new IllegalArgumentException("Only ChunkBuffer.Empty instance could be recycled.".toString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
