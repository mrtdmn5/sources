package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteBuffers.kt */
/* loaded from: classes3.dex */
public final class ByteBuffersKt {
    public static final void readFully(ByteReadPacket byteReadPacket, ByteBuffer byteBuffer) {
        ChunkBuffer prepareRead;
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        while (true) {
            if (!byteBuffer.hasRemaining() || (prepareRead = byteReadPacket.prepareRead()) == null) {
                break;
            }
            int remaining = byteBuffer.remaining();
            int r2 = prepareRead.writePosition - prepareRead.readPosition;
            if (remaining >= r2) {
                BufferUtilsJvmKt.readFully(prepareRead, byteBuffer, r2);
                byteReadPacket.releaseHead$ktor_io(prepareRead);
            } else {
                BufferUtilsJvmKt.readFully(prepareRead, byteBuffer, remaining);
                byteReadPacket.headPosition = prepareRead.readPosition;
                break;
            }
        }
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        throw new EOFException("Not enough data in packet to fill buffer: " + byteBuffer.remaining() + " more bytes required");
    }
}
