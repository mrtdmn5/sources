package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator;
import aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonDeserializer.kt */
/* loaded from: classes.dex */
public final class JsonNullFieldIterator implements Deserializer$FieldIterator, PrimitiveDeserializer {
    public final /* synthetic */ JsonDeserializer $$delegate_1;

    public JsonNullFieldIterator(JsonDeserializer deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        this.$$delegate_1 = deserializer;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public final boolean deserializeBoolean() {
        return this.$$delegate_1.deserializeBoolean();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public final int deserializeInt() {
        return this.$$delegate_1.deserializeInt();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public final String deserializeString() {
        return this.$$delegate_1.deserializeString();
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator
    public final Integer findNextFieldIndex() {
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator
    public final void skipValue() {
        throw new DeserializationException("This should not be called during deserialization.");
    }
}
