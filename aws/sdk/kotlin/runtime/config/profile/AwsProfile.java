package aws.sdk.kotlin.runtime.config.profile;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: AwsProfile.kt */
/* loaded from: classes.dex */
public final class AwsProfile implements Map<String, String>, KMappedMarker {
    public final String name;
    public final Map<String, String> properties;

    public AwsProfile(String name, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.properties = map;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ String compute(String str, BiFunction<? super String, ? super String, ? extends String> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ String computeIfAbsent(String str, Function<? super String, ? extends String> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ String computeIfPresent(String str, BiFunction<? super String, ? super String, ? extends String> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.properties.containsKey(key);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String value = (String) obj;
        Intrinsics.checkNotNullParameter(value, "value");
        return this.properties.containsValue(value);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, String>> entrySet() {
        return this.properties.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AwsProfile)) {
            return false;
        }
        AwsProfile awsProfile = (AwsProfile) obj;
        if (Intrinsics.areEqual(this.name, awsProfile.name) && Intrinsics.areEqual(this.properties, awsProfile.properties)) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final String get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.properties.get(key);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.properties.hashCode() + (this.name.hashCode() * 31);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.properties.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.properties.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ String merge(String str, String str2, BiFunction<? super String, ? super String, ? extends String> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ String put(String str, String str2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends String> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ String putIfAbsent(String str, String str2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final String remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ String replace(String str, String str2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super String, ? extends String> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.properties.size();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AwsProfile(name=");
        sb.append(this.name);
        sb.append(", properties=");
        return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.properties, ')');
    }

    @Override // java.util.Map
    public final Collection<String> values() {
        return this.properties.values();
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String str, String str2, String str3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
