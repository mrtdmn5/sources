package io.ktor.utils.io.pool;

import java.io.Closeable;

/* compiled from: Pool.kt */
/* loaded from: classes3.dex */
public interface ObjectPool<T> extends Closeable {
    T borrow();

    void recycle(T t);
}
