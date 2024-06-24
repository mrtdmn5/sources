package io.ktor.utils.io.pool;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* compiled from: DefaultPool.kt */
/* loaded from: classes3.dex */
public abstract class DefaultPool<T> implements ObjectPool<T> {
    public static final AtomicLongFieldUpdater<DefaultPool<?>> Top;
    public final AtomicReferenceArray<T> instances;
    public final int maxIndex;
    public final int[] next;
    public final int shift;
    private volatile long top;

    static {
        AtomicLongFieldUpdater<DefaultPool<?>> newUpdater = AtomicLongFieldUpdater.newUpdater(DefaultPool.class, new MutablePropertyReference1Impl() { // from class: io.ktor.utils.io.pool.DefaultPool$Companion$Top$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public final Object get(Object obj) {
                long j;
                j = ((DefaultPool) obj).top;
                return Long.valueOf(j);
            }
        }.getName());
        Intrinsics.checkNotNullExpressionValue(newUpdater, "newUpdater(Owner::class.java, p.name)");
        Top = newUpdater;
    }

    public DefaultPool(int r4) {
        boolean z;
        if (r4 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r4 <= 536870911) {
                int highestOneBit = Integer.highestOneBit((r4 * 4) - 1) * 2;
                this.maxIndex = highestOneBit;
                this.shift = Integer.numberOfLeadingZeros(highestOneBit) + 1;
                int r42 = highestOneBit + 1;
                this.instances = new AtomicReferenceArray<>(r42);
                this.next = new int[r42];
                return;
            }
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("capacity should be less or equal to 536870911 but it is ", r4).toString());
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("capacity should be positive but it is ", r4).toString());
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final T borrow() {
        T clearInstance;
        T tryPop = tryPop();
        if (tryPop == null || (clearInstance = clearInstance(tryPop)) == null) {
            return produceInstance();
        }
        return clearInstance;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        dispose();
    }

    public final void dispose() {
        while (true) {
            T tryPop = tryPop();
            if (tryPop == null) {
                return;
            } else {
                disposeInstance(tryPop);
            }
        }
    }

    public void disposeInstance(T instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    public abstract T produceInstance();

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void recycle(T instance) {
        boolean z;
        long j;
        long j2;
        Intrinsics.checkNotNullParameter(instance, "instance");
        validateInstance(instance);
        boolean z2 = true;
        int identityHashCode = ((System.identityHashCode(instance) * (-1640531527)) >>> this.shift) + 1;
        boolean z3 = false;
        int r3 = 0;
        while (true) {
            if (r3 < 8) {
                AtomicReferenceArray<T> atomicReferenceArray = this.instances;
                while (true) {
                    if (atomicReferenceArray.compareAndSet(identityHashCode, null, instance)) {
                        z = true;
                        break;
                    } else if (atomicReferenceArray.get(identityHashCode) != null) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    if (identityHashCode > 0) {
                        z3 = true;
                    }
                    if (!z3) {
                        throw new IllegalArgumentException("index should be positive".toString());
                    }
                    do {
                        j = this.top;
                        j2 = identityHashCode | ((((j >> 32) & 4294967295L) + 1) << 32);
                        this.next[identityHashCode] = (int) (4294967295L & j);
                    } while (!Top.compareAndSet(this, j, j2));
                } else {
                    identityHashCode--;
                    if (identityHashCode == 0) {
                        identityHashCode = this.maxIndex;
                    }
                    r3++;
                }
            } else {
                z2 = false;
                break;
            }
        }
        if (!z2) {
            disposeInstance(instance);
        }
    }

    public final T tryPop() {
        int r1;
        while (true) {
            long j = this.top;
            r1 = 0;
            if (j == 0) {
                break;
            }
            long j2 = ((j >> 32) & 4294967295L) + 1;
            int r6 = (int) (4294967295L & j);
            if (r6 == 0) {
                break;
            }
            if (Top.compareAndSet(this, j, (j2 << 32) | this.next[r6])) {
                r1 = r6;
                break;
            }
        }
        if (r1 == 0) {
            return null;
        }
        return this.instances.getAndSet(r1, null);
    }

    public void validateInstance(T instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    public T clearInstance(T t) {
        return t;
    }
}
