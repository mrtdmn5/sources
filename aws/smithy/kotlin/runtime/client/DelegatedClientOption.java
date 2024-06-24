package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.util.AttributeKey;
import aws.smithy.kotlin.runtime.util.Attributes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: ClientOptionsBuilder.kt */
/* loaded from: classes.dex */
public final class DelegatedClientOption<T> implements ReadWriteProperty<Object, T> {
    public final Attributes into;
    public final AttributeKey<T> key;

    public DelegatedClientOption(AttributeKey<T> key, Attributes into) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(into, "into");
        this.key = key;
        this.into = into;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final T getValue(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return (T) this.into.getOrNull(this.key);
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Object obj, KProperty<?> property, T t) {
        Intrinsics.checkNotNullParameter(property, "property");
        AttributeKey<T> attributeKey = this.key;
        Attributes attributes = this.into;
        if (t == null) {
            attributes.remove(attributeKey);
        } else {
            attributes.set(attributeKey, t);
        }
    }
}
