package aws.smithy.kotlin.runtime.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: CaseInsensitiveMap.kt */
/* loaded from: classes.dex */
public final class CaseInsensitiveMap<Value> implements Map<String, Value>, KMutableMap {
    public final LinkedHashMap impl = new LinkedHashMap();

    @Override // java.util.Map
    public final void clear() {
        this.impl.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.impl.containsKey(new CaseInsensitiveString(key));
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.impl.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, Value>> entrySet() {
        Set<Map.Entry> entrySet = this.impl.entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entrySet, 10));
        for (Map.Entry entry : entrySet) {
            arrayList.add(new Entry(((CaseInsensitiveString) entry.getKey()).s, entry.getValue()));
        }
        return CollectionsKt___CollectionsKt.toMutableSet(arrayList);
    }

    @Override // java.util.Map
    public final Value get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return (Value) this.impl.get(new CaseInsensitiveString(key));
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.impl.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        Set keySet = this.impl.keySet();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(keySet, 10));
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((CaseInsensitiveString) it.next()).s);
        }
        return CollectionsKt___CollectionsKt.toMutableSet(arrayList);
    }

    @Override // java.util.Map
    public final Object put(String str, Object obj) {
        String key = str;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.impl.put(new CaseInsensitiveString(key), obj);
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends Value> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        for (Map.Entry<? extends String, ? extends Value> entry : from.entrySet()) {
            String key = entry.getKey();
            Value value = entry.getValue();
            Intrinsics.checkNotNullParameter(key, "key");
            this.impl.put(new CaseInsensitiveString(key), value);
        }
    }

    @Override // java.util.Map
    public final Value remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return (Value) this.impl.remove(new CaseInsensitiveString(key));
    }

    @Override // java.util.Map
    public final int size() {
        return this.impl.size();
    }

    @Override // java.util.Map
    public final Collection<Value> values() {
        return this.impl.values();
    }
}
