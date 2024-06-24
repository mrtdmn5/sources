package io.ktor.util.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: ConcurrentMapJvm.kt */
/* loaded from: classes3.dex */
public final class ConcurrentMap<Key, Value> implements Map<Key, Value>, KMutableMap {
    public final ConcurrentHashMap<Key, Value> delegate = new ConcurrentHashMap<>(32);

    @Override // java.util.Map
    public final void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.delegate.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<Key, Value>> entrySet() {
        Set<Map.Entry<Key, Value>> entrySet = this.delegate.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "delegate.entries");
        return entrySet;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        return Intrinsics.areEqual(obj, this.delegate);
    }

    @Override // java.util.Map
    public final Value get(Object obj) {
        return this.delegate.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public final Set<Key> keySet() {
        Set<Key> keySet = this.delegate.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "delegate.keys");
        return keySet;
    }

    @Override // java.util.Map
    public final Value put(Key key, Value value) {
        return this.delegate.put(key, value);
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends Key, ? extends Value> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.delegate.putAll(from);
    }

    @Override // java.util.Map
    public final Value remove(Object obj) {
        return this.delegate.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.delegate.size();
    }

    public final String toString() {
        return "ConcurrentMapJvm by " + this.delegate;
    }

    @Override // java.util.Map
    public final Collection<Value> values() {
        Collection<Value> values = this.delegate.values();
        Intrinsics.checkNotNullExpressionValue(values, "delegate.values");
        return values;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        return this.delegate.remove(obj, obj2);
    }
}
