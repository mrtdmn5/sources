package io.ktor.utils.io.pool;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: ByteBufferPools.kt */
/* loaded from: classes3.dex */
public final class ByteBufferPool extends DefaultPool<ByteBuffer> {
    public final int bufferSize;

    public ByteBufferPool() {
        super(2048);
        this.bufferSize = DfuBaseService.ERROR_FILE_ERROR;
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
        ByteBuffer allocate = ByteBuffer.allocate(this.bufferSize);
        Intrinsics.checkNotNull(allocate);
        return allocate;
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
            if (!instance.isDirect()) {
                return;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
