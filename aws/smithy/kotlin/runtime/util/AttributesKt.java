package aws.smithy.kotlin.runtime.util;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Attributes.kt */
/* loaded from: classes.dex */
public final class AttributesKt {
    public static final Object get(AttributeKey key, Attributes attributes) {
        Intrinsics.checkNotNullParameter(attributes, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object orNull = attributes.getOrNull(key);
        if (orNull != null) {
            return orNull;
        }
        throw new IllegalStateException("No instance for " + key);
    }

    public static final <T> void putIfAbsent(Attributes attributes, AttributeKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(attributes, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!attributes.contains(key)) {
            attributes.set(key, value);
        }
    }
}
