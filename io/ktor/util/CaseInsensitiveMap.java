package io.ktor.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: CaseInsensitiveMap.kt */
/* loaded from: classes3.dex */
public final class CaseInsensitiveMap<Value> implements Map<String, Value>, KMutableMap {
    public final LinkedHashMap delegate = new LinkedHashMap();

    @Override // java.util.Map
    public final void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.delegate.containsKey(new CaseInsensitiveString(key));
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.delegate.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, Value>> entrySet() {
        return new DelegatingMutableSet(this.delegate.entrySet(), new Function1<Map.Entry<CaseInsensitiveString, Object>, Map.Entry<String, Object>>() { // from class: io.ktor.util.CaseInsensitiveMap$entries$1
            @Override // kotlin.jvm.functions.Function1
            public final Map.Entry<String, Object> invoke(Map.Entry<CaseInsensitiveString, Object> entry) {
                Map.Entry<CaseInsensitiveString, Object> $receiver = entry;
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                return new Entry($receiver.getKey().content, $receiver.getValue());
            }
        }, new Function1<Map.Entry<String, Object>, Map.Entry<CaseInsensitiveString, Object>>() { // from class: io.ktor.util.CaseInsensitiveMap$entries$2
            @Override // kotlin.jvm.functions.Function1
            public final Map.Entry<CaseInsensitiveString, Object> invoke(Map.Entry<String, Object> entry) {
                Map.Entry<String, Object> $receiver = entry;
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                return new Entry(TextKt.caseInsensitive($receiver.getKey()), $receiver.getValue());
            }
        });
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof CaseInsensitiveMap)) {
            return Intrinsics.areEqual(((CaseInsensitiveMap) obj).delegate, this.delegate);
        }
        return false;
    }

    @Override // java.util.Map
    public final Value get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return (Value) this.delegate.get(TextKt.caseInsensitive(key));
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
    public final Set<String> keySet() {
        return new DelegatingMutableSet(this.delegate.keySet(), new Function1<CaseInsensitiveString, String>() { // from class: io.ktor.util.CaseInsensitiveMap$keys$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(CaseInsensitiveString caseInsensitiveString) {
                CaseInsensitiveString $receiver = caseInsensitiveString;
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                return $receiver.content;
            }
        }, new Function1<String, CaseInsensitiveString>() { // from class: io.ktor.util.CaseInsensitiveMap$keys$2
            @Override // kotlin.jvm.functions.Function1
            public final CaseInsensitiveString invoke(String str) {
                String $receiver = str;
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                return TextKt.caseInsensitive($receiver);
            }
        });
    }

    @Override // java.util.Map
    public final Object put(String str, Object value) {
        String key = str;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.delegate.put(TextKt.caseInsensitive(key), value);
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends Value> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        for (Map.Entry<? extends String, ? extends Value> entry : from.entrySet()) {
            String key = entry.getKey();
            Value value = entry.getValue();
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.delegate.put(TextKt.caseInsensitive(key), value);
        }
    }

    @Override // java.util.Map
    public final Value remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return (Value) this.delegate.remove(TextKt.caseInsensitive(key));
    }

    @Override // java.util.Map
    public final int size() {
        return this.delegate.size();
    }

    @Override // java.util.Map
    public final Collection<Value> values() {
        return this.delegate.values();
    }
}
