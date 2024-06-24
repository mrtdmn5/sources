package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotStateMap.kt */
/* loaded from: classes.dex */
public abstract class StateMapMutableIterator<K, V> {
    public Map.Entry<? extends K, ? extends V> current;
    public final Iterator<Map.Entry<K, V>> iterator;
    public final SnapshotStateMap<K, V> map;
    public int modification;
    public Map.Entry<? extends K, ? extends V> next;

    /* JADX WARN: Multi-variable type inference failed */
    public StateMapMutableIterator(SnapshotStateMap<K, V> map, Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        this.map = map;
        this.iterator = iterator;
        this.modification = map.getReadable$runtime_release().modification;
        advance();
    }

    public final void advance() {
        Map.Entry<K, V> entry;
        this.current = this.next;
        Iterator<Map.Entry<K, V>> it = this.iterator;
        if (it.hasNext()) {
            entry = it.next();
        } else {
            entry = null;
        }
        this.next = entry;
    }

    public final boolean hasNext() {
        if (this.next != null) {
            return true;
        }
        return false;
    }

    public final void remove() {
        SnapshotStateMap<K, V> snapshotStateMap = this.map;
        if (snapshotStateMap.getReadable$runtime_release().modification == this.modification) {
            Map.Entry<? extends K, ? extends V> entry = this.current;
            if (entry != null) {
                snapshotStateMap.remove(entry.getKey());
                this.current = null;
                Unit unit = Unit.INSTANCE;
                this.modification = snapshotStateMap.getReadable$runtime_release().modification;
                return;
            }
            throw new IllegalStateException();
        }
        throw new ConcurrentModificationException();
    }
}
