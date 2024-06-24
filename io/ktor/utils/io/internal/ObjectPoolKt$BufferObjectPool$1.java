package io.ktor.utils.io.internal;

import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.pool.DefaultPool;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObjectPool.kt */
/* loaded from: classes3.dex */
public final class ObjectPoolKt$BufferObjectPool$1 extends DefaultPool<ReadWriteBufferState.Initial> {
    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void disposeInstance(ReadWriteBufferState.Initial initial) {
        ReadWriteBufferState.Initial instance = initial;
        Intrinsics.checkNotNullParameter(instance, "instance");
        ObjectPoolKt.BufferPool.recycle(instance.backingBuffer);
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final ReadWriteBufferState.Initial produceInstance() {
        return new ReadWriteBufferState.Initial(ObjectPoolKt.BufferPool.borrow());
    }
}
