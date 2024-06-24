package aws.smithy.kotlin.runtime.util;

import java.util.Set;

/* compiled from: Attributes.kt */
/* loaded from: classes.dex */
public interface Attributes {
    public static final /* synthetic */ int $r8$clinit = 0;

    boolean contains(AttributeKey<?> attributeKey);

    Set<AttributeKey<?>> getKeys();

    <T> T getOrNull(AttributeKey<T> attributeKey);

    <T> void remove(AttributeKey<T> attributeKey);

    <T> void set(AttributeKey<T> attributeKey, T t);
}
