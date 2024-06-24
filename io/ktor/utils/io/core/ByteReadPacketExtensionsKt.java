package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ByteReadPacketExtensions.kt */
/* loaded from: classes3.dex */
public final class ByteReadPacketExtensionsKt {
    public static final ByteReadPacket ByteReadPacket(ByteBuffer byteBuffer, Function1<? super ByteBuffer, Unit> function1) {
        SingleByteBufferPool singleByteBufferPool = new SingleByteBufferPool(byteBuffer, function1);
        ChunkBuffer borrow = singleByteBufferPool.borrow();
        borrow.startGap = 0;
        borrow.readPosition = 0;
        borrow.writePosition = borrow.capacity;
        return new ByteReadPacket(borrow, BuffersKt.remainingAll(borrow), singleByteBufferPool);
    }
}
