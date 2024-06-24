package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferIterator.kt */
/* loaded from: classes.dex */
public final class BufferIterator<T> extends AbstractListIterator<T> {
    public final T[] buffer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BufferIterator(int r2, int r3, Object[] buffer) {
        super(r2, r3);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final T next() {
        if (hasNext()) {
            int r0 = this.index;
            this.index = r0 + 1;
            return this.buffer[r0];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        if (hasPrevious()) {
            int r0 = this.index - 1;
            this.index = r0;
            return this.buffer[r0];
        }
        throw new NoSuchElementException();
    }
}
