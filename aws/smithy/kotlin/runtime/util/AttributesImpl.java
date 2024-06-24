package aws.smithy.kotlin.runtime.util;

import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Attributes.kt */
/* loaded from: classes.dex */
public final class AttributesImpl implements Attributes {
    public final LinkedHashMap map = new LinkedHashMap();

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final boolean contains(AttributeKey<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.map.containsKey(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final Set<AttributeKey<?>> getKeys() {
        return this.map.keySet();
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final <T> T getOrNull(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.map.get(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final <T> void remove(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.map.remove(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final <T> void set(AttributeKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.map.put(key, value);
    }
}
