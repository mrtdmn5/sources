package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferAppend.kt */
/* loaded from: classes3.dex */
public final class BufferAppendKt {
    public static final int writeBufferAppend(Buffer buffer, Buffer other, int r7) {
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(other.writePosition - other.readPosition, r7);
        int r0 = buffer.limit;
        int r1 = buffer.writePosition;
        int r2 = r0 - r1;
        if (r2 <= min) {
            int r3 = buffer.capacity;
            if ((r3 - r0) + r2 >= min) {
                if ((r1 + min) - r0 > 0) {
                    buffer.limit = r3;
                }
            } else {
                throw new IllegalArgumentException("Can't append buffer: not enough free space at the end");
            }
        }
        Memory.m1654copyToJT6ljtQ(other.memory, buffer.memory, other.readPosition, min, r1);
        other.discardExact(min);
        buffer.commitWritten(min);
        return min;
    }
}
