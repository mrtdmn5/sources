package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferUtilsJvm.kt */
/* loaded from: classes3.dex */
public final class BufferUtilsJvmKt {
    public static final ChunkBuffer ChunkBuffer(ByteBuffer buffer, ObjectPool<ChunkBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ByteBuffer byteBuffer = Memory.Empty;
        ByteBuffer order = buffer.slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "buffer.slice().order(ByteOrder.BIG_ENDIAN)");
        return new ChunkBuffer(order, null, objectPool);
    }

    public static final void readFully(Buffer buffer, ByteBuffer byteBuffer, int r6) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer byteBuffer2 = buffer.memory;
        int r1 = buffer.readPosition;
        if (buffer.writePosition - r1 >= r6) {
            int limit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + r6);
                MemoryJvmKt.m1655copyTo62zg_DM(byteBuffer2, byteBuffer, r1);
                byteBuffer.limit(limit);
                Unit unit = Unit.INSTANCE;
                buffer.discardExact(r6);
                return;
            } catch (Throwable th) {
                byteBuffer.limit(limit);
                throw th;
            }
        }
        throw new EOFException("Not enough bytes to read a buffer content of size " + r6 + '.');
    }

    public static final void resetFromContentToWrite(ChunkBuffer chunkBuffer, ByteBuffer child) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        chunkBuffer.resetForWrite(child.limit());
        chunkBuffer.commitWrittenUntilIndex(child.position());
    }
}
