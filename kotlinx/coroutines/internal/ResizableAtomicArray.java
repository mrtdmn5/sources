package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* compiled from: ResizableAtomicArray.kt */
/* loaded from: classes4.dex */
public final class ResizableAtomicArray<T> {
    private volatile AtomicReferenceArray<T> array;

    public ResizableAtomicArray(int r2) {
        this.array = new AtomicReferenceArray<>(r2);
    }

    public final int currentLength() {
        return this.array.length();
    }

    public final T get(int r3) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        if (r3 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(r3);
        }
        return null;
    }

    public final void setSynchronized(int r6, CoroutineScheduler.Worker worker) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (r6 < length) {
            atomicReferenceArray.set(r6, worker);
            return;
        }
        int r3 = r6 + 1;
        int r4 = length * 2;
        if (r3 < r4) {
            r3 = r4;
        }
        AtomicReferenceArray<T> atomicReferenceArray2 = new AtomicReferenceArray<>(r3);
        for (int r32 = 0; r32 < length; r32++) {
            atomicReferenceArray2.set(r32, atomicReferenceArray.get(r32));
        }
        atomicReferenceArray2.set(r6, worker);
        this.array = atomicReferenceArray2;
    }
}
