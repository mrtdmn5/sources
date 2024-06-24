package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;

/* compiled from: ByteReadChannelJVM.kt */
/* loaded from: classes3.dex */
public interface ByteReadChannel {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: ByteReadChannelJVM.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final SynchronizedLazyImpl Empty$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ByteChannel>() { // from class: io.ktor.utils.io.ByteReadChannel$Companion$Empty$2
            @Override // kotlin.jvm.functions.Function0
            public final ByteChannel invoke() {
                ByteBufferChannel byteBufferChannel = new ByteBufferChannel(false);
                ByteWriteChannelKt.close(byteBufferChannel);
                return byteBufferChannel;
            }
        });
    }

    /* compiled from: ByteReadChannelJVM.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    boolean cancel(Throwable th);

    Object discard(Continuation continuation);

    int getAvailableForRead();

    Throwable getClosedCause();

    boolean isClosedForRead();

    Object readAvailable(ChunkBuffer chunkBuffer, ContinuationImpl continuationImpl);

    Object readAvailable(byte[] bArr, int r2, int r3, ContinuationImpl continuationImpl);

    Object readRemaining(long j, Continuation<? super ByteReadPacket> continuation);
}
