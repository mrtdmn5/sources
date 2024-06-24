package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.SingleInstancePool;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteReadPacketExtensions.kt */
/* loaded from: classes3.dex */
public final class SingleByteBufferPool extends SingleInstancePool<ChunkBuffer> {
    public final ByteBuffer instance;
    public final Function1<ByteBuffer, Unit> release;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleByteBufferPool(ByteBuffer byteBuffer, Function1<? super ByteBuffer, Unit> function1) {
        this.instance = byteBuffer;
        this.release = function1;
    }

    @Override // io.ktor.utils.io.pool.SingleInstancePool
    public final void disposeInstance(ChunkBuffer chunkBuffer) {
        ChunkBuffer instance = chunkBuffer;
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.release.invoke(this.instance);
    }

    @Override // io.ktor.utils.io.pool.SingleInstancePool
    public final ChunkBuffer produceInstance() {
        return BufferUtilsJvmKt.ChunkBuffer(this.instance, this);
    }
}
