package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        MapMakerInternalMap.WriteThroughEntry writeThroughEntry = (MapMakerInternalMap.WriteThroughEntry) this;
        sb.append(writeThroughEntry.key);
        sb.append("=");
        sb.append(writeThroughEntry.value);
        return sb.toString();
    }
}
