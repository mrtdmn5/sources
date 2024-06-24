package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Buffers.kt */
/* loaded from: classes3.dex */
public final class BuffersKt {
    public static final ChunkBuffer findTail(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        while (true) {
            ChunkBuffer next = chunkBuffer.getNext();
            if (next == null) {
                return chunkBuffer;
            }
            chunkBuffer = next;
        }
    }

    public static final void releaseAll(ChunkBuffer chunkBuffer, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        while (chunkBuffer != null) {
            ChunkBuffer cleanNext = chunkBuffer.cleanNext();
            chunkBuffer.release(pool);
            chunkBuffer = cleanNext;
        }
    }

    public static final long remainingAll(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        long j = 0;
        do {
            j += chunkBuffer.writePosition - chunkBuffer.readPosition;
            chunkBuffer = chunkBuffer.getNext();
        } while (chunkBuffer != null);
        return j;
    }
}
