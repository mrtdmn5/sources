package kotlin.collections.builders;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapBuilder.kt */
/* loaded from: classes.dex */
public abstract class AbstractMapBuilderEntrySet<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry<? extends K, ? extends V> element = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return ((MapBuilderEntries) this).backing.containsEntry$kotlin_stdlib(element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry element = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        MapBuilder<K, V> mapBuilder = ((MapBuilderEntries) this).backing;
        mapBuilder.getClass();
        mapBuilder.checkIsMutable$kotlin_stdlib();
        int findKey = mapBuilder.findKey(element.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = mapBuilder.valuesArray;
        Intrinsics.checkNotNull(vArr);
        if (!Intrinsics.areEqual(vArr[findKey], element.getValue())) {
            return false;
        }
        mapBuilder.removeKeyAt(findKey);
        return true;
    }
}
