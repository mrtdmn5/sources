package kotlin.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Maps.kt */
/* loaded from: classes.dex */
public class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    public static final Object getValue(Object obj, Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map instanceof MapWithDefault) {
            return ((MapWithDefault) map).getOrImplicitDefault();
        }
        Object obj2 = map.get(obj);
        if (obj2 == null && !map.containsKey(obj)) {
            throw new NoSuchElementException("Key " + obj + " is missing in the map.");
        }
        return obj2;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        if (pairs.length > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(pairs.length));
            putAll(linkedHashMap, pairs);
            return linkedHashMap;
        }
        return EmptyMap.INSTANCE;
    }

    public static final LinkedHashMap mutableMapOf(Pair... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(pairs.length));
        putAll(linkedHashMap, pairs);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        if (map.isEmpty()) {
            return MapsKt__MapsJVMKt.mapOf(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.first, pair.second);
        return linkedHashMap;
    }

    public static final void putAll(HashMap hashMap, Pair[] pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        for (Pair pair : pairs) {
            hashMap.put(pair.first, pair.second);
        }
    }

    public static final void toMap(ArrayList arrayList, LinkedHashMap linkedHashMap) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            linkedHashMap.put(pair.first, pair.second);
        }
    }

    public static final LinkedHashMap toMutableMap(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new LinkedHashMap(map);
    }

    public static final LinkedHashMap plus(Map map, Map map2) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final Map toMap(ArrayList arrayList) {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        int size = arrayList.size();
        if (size == 0) {
            return emptyMap;
        }
        if (size != 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(arrayList.size()));
            toMap(arrayList, linkedHashMap);
            return linkedHashMap;
        }
        return MapsKt__MapsJVMKt.mapOf((Pair) arrayList.get(0));
    }

    public static final <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return EmptyMap.INSTANCE;
        }
        if (size != 1) {
            return toMutableMap(map);
        }
        return MapsKt__MapsJVMKt.toSingletonMap(map);
    }
}
