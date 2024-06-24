package io.ktor.utils.io.pool;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteBufferPools.kt */
/* loaded from: classes3.dex */
public final class DirectByteBufferPool extends DefaultPool<ByteBuffer> {
    public final int bufferSize;

    public DirectByteBufferPool(int r1, int r2) {
        super(r1);
        this.bufferSize = r2;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final ByteBuffer clearInstance(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        byteBuffer2.clear();
        byteBuffer2.order(ByteOrder.BIG_ENDIAN);
        return byteBuffer2;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final ByteBuffer produceInstance() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bufferSize);
        Intrinsics.checkNotNull(allocateDirect);
        return allocateDirect;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void validateInstance(ByteBuffer byteBuffer) {
        boolean z;
        ByteBuffer instance = byteBuffer;
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (instance.capacity() == this.bufferSize) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (instance.isDirect()) {
                return;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
