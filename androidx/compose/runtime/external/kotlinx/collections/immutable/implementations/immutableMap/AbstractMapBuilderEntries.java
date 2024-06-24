package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentHashMapBuilderContentViews.kt */
/* loaded from: classes.dex */
public abstract class AbstractMapBuilderEntries<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry element = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        Object key = element.getKey();
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder = ((PersistentHashMapBuilderEntries) this).builder;
        Object obj2 = persistentHashMapBuilder.get(key);
        if (obj2 != null) {
            return Intrinsics.areEqual(obj2, element.getValue());
        }
        if (element.getValue() != null || !persistentHashMapBuilder.containsKey(element.getKey())) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry element = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return ((PersistentHashMapBuilderEntries) this).builder.remove(element.getKey(), element.getValue());
    }
}
