package io.ktor.utils.io.internal;

import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.pool.NoPoolImpl;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObjectPool.kt */
/* loaded from: classes3.dex */
public final class ObjectPoolKt$BufferObjectNoPool$1 extends NoPoolImpl<ReadWriteBufferState.Initial> {
    @Override // io.ktor.utils.io.pool.ObjectPool
    public final Object borrow() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(ObjectPoolKt.BUFFER_SIZE);
        Intrinsics.checkNotNullExpressionValue(allocateDirect, "allocateDirect(BUFFER_SIZE)");
        return new ReadWriteBufferState.Initial(8, allocateDirect);
    }
}
