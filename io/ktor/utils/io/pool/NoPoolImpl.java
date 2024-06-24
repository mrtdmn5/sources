package io.ktor.utils.io.pool;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pool.kt */
/* loaded from: classes3.dex */
public abstract class NoPoolImpl<T> implements ObjectPool<T> {
    @Override // io.ktor.utils.io.pool.ObjectPool
    public void recycle(T instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
