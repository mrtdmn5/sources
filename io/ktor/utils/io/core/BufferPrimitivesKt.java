package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferPrimitives.kt */
/* loaded from: classes3.dex */
public final class BufferPrimitivesKt {
    public static final void readFully(ChunkBuffer chunkBuffer, byte[] bArr, int r5, int r6) {
        int r0 = chunkBuffer.readPosition;
        if (chunkBuffer.writePosition - r0 >= r6) {
            ByteBuffer copyTo = chunkBuffer.memory;
            Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
            if (copyTo.hasArray() && !copyTo.isReadOnly()) {
                System.arraycopy(copyTo.array(), copyTo.arrayOffset() + r0, bArr, r5, r6);
            } else {
                copyTo.duplicate().get(bArr, r5, r6);
            }
            Unit unit = Unit.INSTANCE;
            chunkBuffer.discardExact(r6);
            return;
        }
        throw new EOFException("Not enough bytes to read a byte array of size " + r6 + '.');
    }

    public static final void writeFully(ChunkBuffer chunkBuffer, byte[] source, int r4, int r5) {
        Intrinsics.checkNotNullParameter(source, "source");
        int r0 = chunkBuffer.writePosition;
        int r1 = chunkBuffer.limit - r0;
        if (r1 >= r5) {
            ByteBuffer order = ByteBuffer.wrap(source, r4, r5).slice().order(ByteOrder.BIG_ENDIAN);
            Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
            ByteBuffer byteBuffer = Memory.Empty;
            Memory.m1654copyToJT6ljtQ(order, chunkBuffer.memory, 0, r5, r0);
            chunkBuffer.commitWritten(r5);
            return;
        }
        throw new InsufficientSpaceException("byte array", r5, r1);
    }
}
