package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteReadPacket.kt */
/* loaded from: classes3.dex */
public final class ByteReadPacket extends Input {
    public static final ByteReadPacket Empty = new ByteReadPacket(ChunkBuffer.Empty, 0, ChunkBuffer.EmptyPool);

    public ByteReadPacket() {
        throw null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteReadPacket(ChunkBuffer head, long j, ObjectPool<ChunkBuffer> pool) {
        super(head, j, pool);
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
        if (this.noMoreChunksAvailable) {
            return;
        }
        this.noMoreChunksAvailable = true;
    }

    public final ByteReadPacket copy() {
        ChunkBuffer head = getHead();
        ChunkBuffer duplicate = head.duplicate();
        ChunkBuffer next = head.getNext();
        if (next != null) {
            ChunkBuffer chunkBuffer = duplicate;
            while (true) {
                ChunkBuffer duplicate2 = next.duplicate();
                chunkBuffer.setNext(duplicate2);
                next = next.getNext();
                if (next == null) {
                    break;
                }
                chunkBuffer = duplicate2;
            }
        }
        return new ByteReadPacket(duplicate, getRemaining(), this.pool);
    }

    @Override // io.ktor.utils.io.core.Input
    public final ChunkBuffer fill() {
        return null;
    }

    @Override // io.ktor.utils.io.core.Input
    /* renamed from: fill-62zg_DM, reason: not valid java name */
    public final void mo1657fill62zg_DM(ByteBuffer destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
    }

    public final String toString() {
        return "ByteReadPacket(" + getRemaining() + " bytes remaining)";
    }

    @Override // io.ktor.utils.io.core.Input
    public final void closeSource() {
    }
}
