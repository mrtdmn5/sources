package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: PersistentOrderedSetIterator.kt */
/* loaded from: classes.dex */
public final class PersistentOrderedSetIterator<E> implements Iterator<E>, KMappedMarker {
    public int index;
    public final Map<E, Links> map;
    public Object nextElement;

    public PersistentOrderedSetIterator(Object obj, PersistentHashMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.nextElement = obj;
        this.map = map;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.index < this.map.size()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final E next() {
        if (hasNext()) {
            E e = (E) this.nextElement;
            this.index++;
            Links links = this.map.get(e);
            if (links != null) {
                this.nextElement = links.next;
                return e;
            }
            throw new ConcurrentModificationException("Hash code of an element (" + e + ") has changed after it was added to the persistent set.");
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
