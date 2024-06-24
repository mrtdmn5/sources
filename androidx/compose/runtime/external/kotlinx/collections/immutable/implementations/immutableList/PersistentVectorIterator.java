package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentVectorIterator.kt */
/* loaded from: classes.dex */
public final class PersistentVectorIterator<T> extends AbstractListIterator<T> {
    public final T[] tail;
    public final TrieIterator<T> trieIterator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PersistentVectorIterator(int r2, int r3, int r4, Object[] root, Object[] tail) {
        super(r2, r3);
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(tail, "tail");
        this.tail = tail;
        int r32 = (r3 - 1) & (-32);
        this.trieIterator = new TrieIterator<>(root, r2 > r32 ? r32 : r2, r32, r4);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final T next() {
        if (hasNext()) {
            TrieIterator<T> trieIterator = this.trieIterator;
            if (trieIterator.hasNext()) {
                this.index++;
                return trieIterator.next();
            }
            int r1 = this.index;
            this.index = r1 + 1;
            return this.tail[r1 - trieIterator.size];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        if (hasPrevious()) {
            int r0 = this.index;
            TrieIterator<T> trieIterator = this.trieIterator;
            int r2 = trieIterator.size;
            if (r0 > r2) {
                int r02 = r0 - 1;
                this.index = r02;
                return this.tail[r02 - r2];
            }
            this.index = r0 - 1;
            return trieIterator.previous();
        }
        throw new NoSuchElementException();
    }
}
