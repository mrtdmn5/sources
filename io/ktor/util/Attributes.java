package io.ktor.util;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: Attributes.kt */
/* loaded from: classes3.dex */
public interface Attributes {
    <T> T computeIfAbsent(AttributeKey<T> attributeKey, Function0<? extends T> function0);

    boolean contains(AttributeKey<?> attributeKey);

    <T> T get(AttributeKey<T> attributeKey);

    List<AttributeKey<?>> getAllKeys();

    <T> T getOrNull(AttributeKey<T> attributeKey);

    <T> void put(AttributeKey<T> attributeKey, T t);
}
