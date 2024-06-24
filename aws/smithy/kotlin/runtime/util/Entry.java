package aws.smithy.kotlin.runtime.util;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: CaseInsensitiveMap.kt */
/* loaded from: classes.dex */
public final class Entry<Key, Value> implements Map.Entry<Key, Value>, KMutableMap.Entry {
    public final Key key;
    public Value value;

    /* JADX WARN: Multi-variable type inference failed */
    public Entry(String str, Object obj) {
        this.key = str;
        this.value = obj;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Intrinsics.areEqual(entry.getKey(), this.key) || !Intrinsics.areEqual(entry.getValue(), this.value)) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Key getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public final Value getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Key key = this.key;
        Intrinsics.checkNotNull(key);
        int hashCode = key.hashCode() + 527;
        Value value = this.value;
        Intrinsics.checkNotNull(value);
        return value.hashCode() + hashCode;
    }

    @Override // java.util.Map.Entry
    public final Value setValue(Value value) {
        this.value = value;
        return value;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.key);
        sb.append('=');
        sb.append(this.value);
        return sb.toString();
    }
}
