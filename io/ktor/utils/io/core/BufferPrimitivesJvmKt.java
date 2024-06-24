package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferPrimitivesJvm.kt */
/* loaded from: classes3.dex */
public final class BufferPrimitivesJvmKt {
    public static final void writeFully(Buffer buffer, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int remaining = byteBuffer.remaining();
        int r1 = buffer.writePosition;
        int r2 = buffer.limit - r1;
        if (r2 >= remaining) {
            ByteBuffer destination = buffer.memory;
            Intrinsics.checkNotNullParameter(destination, "destination");
            if (byteBuffer.hasArray() && !byteBuffer.isReadOnly()) {
                byte[] array = byteBuffer.array();
                Intrinsics.checkNotNullExpressionValue(array, "array()");
                int position = byteBuffer.position() + byteBuffer.arrayOffset();
                int remaining2 = byteBuffer.remaining();
                ByteBuffer order = ByteBuffer.wrap(array, position, remaining2).slice().order(ByteOrder.BIG_ENDIAN);
                Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
                Memory.m1654copyToJT6ljtQ(order, destination, 0, remaining2, r1);
                byteBuffer.position(byteBuffer.limit());
            } else {
                MemoryJvmKt.sliceSafe(destination, r1, byteBuffer.remaining()).put(byteBuffer);
            }
            buffer.commitWritten(remaining);
            return;
        }
        throw new InsufficientSpaceException("buffer content", remaining, r2);
    }
}
