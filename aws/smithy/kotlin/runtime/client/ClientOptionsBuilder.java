package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.util.AttributeKey;
import aws.smithy.kotlin.runtime.util.Attributes;
import aws.smithy.kotlin.runtime.util.AttributesImpl;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientOptionsBuilder.kt */
/* loaded from: classes.dex */
public abstract class ClientOptionsBuilder implements Attributes {
    public final Attributes options = new AttributesImpl();
    public final LinkedHashSet requiredKeys = new LinkedHashSet();

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final boolean contains(AttributeKey<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.options.contains(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final Set<AttributeKey<?>> getKeys() {
        return this.options.getKeys();
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final <T> T getOrNull(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.options.getOrNull(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final <T> void remove(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.options.remove(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.Attributes
    public final <T> void set(AttributeKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.options.set(key, value);
    }
}
