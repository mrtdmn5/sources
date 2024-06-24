package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.AbstractMutableCollection;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapBuilder.kt */
/* loaded from: classes.dex */
public final class MapBuilderValues<V> extends AbstractMutableCollection<V> {
    public final MapBuilder<?, V> backing;

    public MapBuilderValues(MapBuilder<?, V> backing) {
        Intrinsics.checkNotNullParameter(backing, "backing");
        this.backing = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends V> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backing.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.backing.containsValue(obj);
    }

    @Override // kotlin.collections.AbstractMutableCollection
    public final int getSize() {
        return this.backing.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        MapBuilder<?, V> mapBuilder = this.backing;
        mapBuilder.getClass();
        return new MapBuilder.ValuesItr(mapBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        int r2;
        MapBuilder<?, V> mapBuilder = this.backing;
        mapBuilder.checkIsMutable$kotlin_stdlib();
        int r1 = mapBuilder.length;
        while (true) {
            r2 = -1;
            r1--;
            if (r1 < 0) {
                break;
            }
            if (mapBuilder.presenceArray[r1] >= 0) {
                V[] vArr = mapBuilder.valuesArray;
                Intrinsics.checkNotNull(vArr);
                if (Intrinsics.areEqual(vArr[r1], obj)) {
                    r2 = r1;
                    break;
                }
            }
        }
        if (r2 < 0) {
            return false;
        }
        mapBuilder.removeKeyAt(r2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
