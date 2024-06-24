package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: SnapshotStateMap.kt */
/* loaded from: classes.dex */
public final class StateMapMutableEntriesIterator$next$1 implements Map.Entry<Object, Object>, KMutableMap.Entry {
    public final Object key;
    public final /* synthetic */ StateMapMutableEntriesIterator<Object, Object> this$0;
    public Object value;

    public StateMapMutableEntriesIterator$next$1(StateMapMutableEntriesIterator<Object, Object> stateMapMutableEntriesIterator) {
        this.this$0 = stateMapMutableEntriesIterator;
        Map.Entry<? extends Object, ? extends Object> entry = stateMapMutableEntriesIterator.current;
        Intrinsics.checkNotNull(entry);
        this.key = entry.getKey();
        Map.Entry<? extends Object, ? extends Object> entry2 = stateMapMutableEntriesIterator.current;
        Intrinsics.checkNotNull(entry2);
        this.value = entry2.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        StateMapMutableEntriesIterator<Object, Object> stateMapMutableEntriesIterator = this.this$0;
        if (stateMapMutableEntriesIterator.map.getReadable$runtime_release().modification == stateMapMutableEntriesIterator.modification) {
            Object obj2 = this.value;
            stateMapMutableEntriesIterator.map.put(this.key, obj);
            this.value = obj;
            return obj2;
        }
        throw new ConcurrentModificationException();
    }
}
