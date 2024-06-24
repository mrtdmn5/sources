package io.ktor.utils.io;

import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteWriteChannel.kt */
/* loaded from: classes3.dex */
public final class ByteWriteChannelKt {
    public static final void close(ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        byteWriteChannel.close(null);
    }

    public static final Object writeFully(ByteWriteChannel byteWriteChannel, byte[] bArr, ContinuationImpl continuationImpl) {
        Object writeFully = byteWriteChannel.writeFully(bArr, bArr.length, continuationImpl);
        if (writeFully == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return writeFully;
        }
        return Unit.INSTANCE;
    }
}
