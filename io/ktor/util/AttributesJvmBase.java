package io.ktor.util;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributesJvm.kt */
/* loaded from: classes3.dex */
public abstract class AttributesJvmBase implements Attributes {
    @Override // io.ktor.util.Attributes
    public final boolean contains(AttributeKey<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getMap().containsKey(key);
    }

    @Override // io.ktor.util.Attributes
    public final <T> T get(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) getOrNull(key);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("No instance for key " + key);
    }

    @Override // io.ktor.util.Attributes
    public final List<AttributeKey<?>> getAllKeys() {
        return CollectionsKt___CollectionsKt.toList(getMap().keySet());
    }

    public abstract Map<AttributeKey<?>, Object> getMap();

    @Override // io.ktor.util.Attributes
    public final <T> T getOrNull(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) getMap().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.util.Attributes
    public final <T> void put(AttributeKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        getMap().put(key, value);
    }
}
