package androidx.compose.runtime.snapshots;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SnapshotStateMap.kt */
/* loaded from: classes.dex */
public final class StateMapMutableEntriesIterator<K, V> extends StateMapMutableIterator<K, V> implements Iterator<Map.Entry<K, V>>, KMappedMarker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateMapMutableEntriesIterator(SnapshotStateMap<K, V> map, Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator) {
        super(map, iterator);
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
    }

    @Override // java.util.Iterator
    public final Object next() {
        advance();
        if (this.current != null) {
            return new StateMapMutableEntriesIterator$next$1(this);
        }
        throw new IllegalStateException();
    }
}
