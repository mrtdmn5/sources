package io.ktor.utils.io.internal;

import io.ktor.utils.io.pool.DirectByteBufferPool;

/* compiled from: ObjectPool.kt */
/* loaded from: classes3.dex */
public final class ObjectPoolKt {
    public static final int BUFFER_SIZE;
    public static final ObjectPoolKt$BufferObjectNoPool$1 BufferObjectNoPool;
    public static final ObjectPoolKt$BufferObjectPool$1 BufferObjectPool;
    public static final DirectByteBufferPool BufferPool;

    static {
        int iOIntProperty = UtilsKt.getIOIntProperty(4096, "BufferSize");
        BUFFER_SIZE = iOIntProperty;
        int iOIntProperty2 = UtilsKt.getIOIntProperty(2048, "BufferPoolSize");
        int iOIntProperty3 = UtilsKt.getIOIntProperty(1024, "BufferObjectPoolSize");
        BufferPool = new DirectByteBufferPool(iOIntProperty2, iOIntProperty);
        BufferObjectPool = new ObjectPoolKt$BufferObjectPool$1(iOIntProperty3);
        BufferObjectNoPool = new ObjectPoolKt$BufferObjectNoPool$1();
    }
}
