package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$1;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: ByteWriteChannel.kt */
/* loaded from: classes3.dex */
public interface ByteWriteChannel {
    boolean close(Throwable th);

    void flush();

    boolean getAutoFlush();

    boolean isClosedForWrite();

    Object writeFully(Buffer buffer, ContinuationImpl continuationImpl);

    Object writeFully(ByteBuffer byteBuffer, ReadingKt$toByteReadChannel$1 readingKt$toByteReadChannel$1);

    Object writeFully(byte[] bArr, int r2, ContinuationImpl continuationImpl);

    Object writePacket(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation);
}
