package io.ktor.utils.io.pool;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pool.kt */
/* loaded from: classes3.dex */
public abstract class SingleInstancePool<T> implements ObjectPool<T> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater borrowed$FU = AtomicIntegerFieldUpdater.newUpdater(SingleInstancePool.class, "borrowed");
    public static final /* synthetic */ AtomicIntegerFieldUpdater disposed$FU = AtomicIntegerFieldUpdater.newUpdater(SingleInstancePool.class, "disposed");
    private volatile /* synthetic */ int borrowed = 0;
    private volatile /* synthetic */ int disposed = 0;
    private volatile /* synthetic */ Object instance = null;

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final T borrow() {
        int r0;
        do {
            r0 = this.borrowed;
            if (r0 != 0) {
                throw new IllegalStateException("Instance is already consumed");
            }
        } while (!borrowed$FU.compareAndSet(this, r0, 1));
        T produceInstance = produceInstance();
        this.instance = produceInstance;
        return produceInstance;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispose() {
        Object obj;
        if (!disposed$FU.compareAndSet(this, 0, 1) || (obj = this.instance) == null) {
            return;
        }
        this.instance = null;
        disposeInstance(obj);
    }

    public abstract void disposeInstance(T t);

    public abstract T produceInstance();

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void recycle(T instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (this.instance != instance) {
            if (this.instance == null && this.borrowed != 0) {
                throw new IllegalStateException("Already recycled or an irrelevant instance tried to be recycled");
            }
            throw new IllegalStateException("Unable to recycle irrelevant instance");
        }
        this.instance = null;
        if (disposed$FU.compareAndSet(this, 0, 1)) {
            disposeInstance(instance);
            return;
        }
        throw new IllegalStateException("An instance is already disposed");
    }
}
