package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentVectorMutableIterator.kt */
/* loaded from: classes.dex */
public final class PersistentVectorMutableIterator<T> extends AbstractListIterator<T> {
    public final PersistentVectorBuilder<T> builder;
    public int expectedModCount;
    public int lastIteratedIndex;
    public TrieIterator<? extends T> trieIterator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentVectorMutableIterator(PersistentVectorBuilder<T> builder, int r3) {
        super(r3, builder.getSize());
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.expectedModCount = builder.getModCount$runtime_release();
        this.lastIteratedIndex = -1;
        setupTrieIterator();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator
    public final void add(T t) {
        checkForComodification();
        int r0 = this.index;
        PersistentVectorBuilder<T> persistentVectorBuilder = this.builder;
        persistentVectorBuilder.add(r0, t);
        this.index++;
        this.size = persistentVectorBuilder.getSize();
        this.expectedModCount = persistentVectorBuilder.getModCount$runtime_release();
        this.lastIteratedIndex = -1;
        setupTrieIterator();
    }

    public final void checkForComodification() {
        if (this.expectedModCount == this.builder.getModCount$runtime_release()) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final T next() {
        checkForComodification();
        if (hasNext()) {
            int r0 = this.index;
            this.lastIteratedIndex = r0;
            TrieIterator<? extends T> trieIterator = this.trieIterator;
            PersistentVectorBuilder<T> persistentVectorBuilder = this.builder;
            if (trieIterator == null) {
                Object[] objArr = persistentVectorBuilder.tail;
                this.index = r0 + 1;
                return (T) objArr[r0];
            }
            if (trieIterator.hasNext()) {
                this.index++;
                return trieIterator.next();
            }
            Object[] objArr2 = persistentVectorBuilder.tail;
            int r2 = this.index;
            this.index = r2 + 1;
            return (T) objArr2[r2 - trieIterator.size];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        checkForComodification();
        if (hasPrevious()) {
            int r0 = this.index;
            int r1 = r0 - 1;
            this.lastIteratedIndex = r1;
            TrieIterator<? extends T> trieIterator = this.trieIterator;
            PersistentVectorBuilder<T> persistentVectorBuilder = this.builder;
            if (trieIterator == null) {
                Object[] objArr = persistentVectorBuilder.tail;
                this.index = r1;
                return (T) objArr[r1];
            }
            int r4 = trieIterator.size;
            if (r0 > r4) {
                Object[] objArr2 = persistentVectorBuilder.tail;
                this.index = r1;
                return (T) objArr2[r1 - r4];
            }
            this.index = r1;
            return trieIterator.previous();
        }
        throw new NoSuchElementException();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        checkForComodification();
        int r0 = this.lastIteratedIndex;
        if (r0 != -1) {
            PersistentVectorBuilder<T> persistentVectorBuilder = this.builder;
            persistentVectorBuilder.removeAt(r0);
            int r02 = this.lastIteratedIndex;
            if (r02 < this.index) {
                this.index = r02;
            }
            this.size = persistentVectorBuilder.getSize();
            this.expectedModCount = persistentVectorBuilder.getModCount$runtime_release();
            this.lastIteratedIndex = -1;
            setupTrieIterator();
            return;
        }
        throw new IllegalStateException();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator
    public final void set(T t) {
        checkForComodification();
        int r0 = this.lastIteratedIndex;
        if (r0 != -1) {
            PersistentVectorBuilder<T> persistentVectorBuilder = this.builder;
            persistentVectorBuilder.set(r0, t);
            this.expectedModCount = persistentVectorBuilder.getModCount$runtime_release();
            setupTrieIterator();
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v4 */
    public final void setupTrieIterator() {
        PersistentVectorBuilder<T> persistentVectorBuilder = this.builder;
        Object[] objArr = persistentVectorBuilder.root;
        if (objArr == null) {
            this.trieIterator = null;
            return;
        }
        int size = (persistentVectorBuilder.getSize() - 1) & (-32);
        int r3 = this.index;
        if (r3 > size) {
            r3 = size;
        }
        int r0 = (persistentVectorBuilder.rootShift / 5) + 1;
        TrieIterator<? extends T> trieIterator = this.trieIterator;
        if (trieIterator == null) {
            this.trieIterator = new TrieIterator<>(objArr, r3, size, r0);
            return;
        }
        Intrinsics.checkNotNull(trieIterator);
        trieIterator.index = r3;
        trieIterator.size = size;
        trieIterator.height = r0;
        if (trieIterator.path.length < r0) {
            trieIterator.path = new Object[r0];
        }
        ?? r6 = 0;
        trieIterator.path[0] = objArr;
        if (r3 == size) {
            r6 = 1;
        }
        trieIterator.isInRightEdge = r6;
        trieIterator.fillPath(r3 - r6, 1);
    }
}
