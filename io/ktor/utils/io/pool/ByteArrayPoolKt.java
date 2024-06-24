package io.ktor.utils.io.pool;

/* compiled from: ByteArrayPool.kt */
/* loaded from: classes3.dex */
public final class ByteArrayPoolKt {
    public static final ByteArrayPoolKt$ByteArrayPool$1 ByteArrayPool = new DefaultPool<byte[]>() { // from class: io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1
        @Override // io.ktor.utils.io.pool.DefaultPool
        public final byte[] produceInstance() {
            return new byte[4096];
        }
    };
}
