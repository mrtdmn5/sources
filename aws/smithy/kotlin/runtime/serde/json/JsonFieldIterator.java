package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator;
import aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.json.JsonToken;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: JsonDeserializer.kt */
/* loaded from: classes.dex */
public final class JsonFieldIterator implements Deserializer$FieldIterator, PrimitiveDeserializer {
    public final /* synthetic */ JsonDeserializer $$delegate_1;
    public final SdkObjectDescriptor descriptor;
    public final JsonStreamReader reader;

    public JsonFieldIterator(JsonLexer reader, SdkObjectDescriptor descriptor, JsonDeserializer deserializer) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        this.reader = reader;
        this.descriptor = descriptor;
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
        int r1;
        JsonStreamReader jsonStreamReader = this.reader;
        JsonToken peek = jsonStreamReader.peek();
        Integer num = null;
        num = null;
        num = null;
        Object obj = null;
        if (Intrinsics.areEqual(peek, JsonToken.EndObject.INSTANCE)) {
            JsonToken nextToken = jsonStreamReader.nextToken();
            if (nextToken.getClass() == JsonToken.EndObject.class) {
            } else {
                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.EndObject.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken.getClass()));
            }
        } else if (!Intrinsics.areEqual(peek, JsonToken.EndDocument.INSTANCE)) {
            if (Intrinsics.areEqual(peek, JsonToken.Null.INSTANCE)) {
                JsonToken nextToken2 = jsonStreamReader.nextToken();
                if (nextToken2.getClass() == JsonToken.Null.class) {
                } else {
                    throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Null.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken2.getClass()));
                }
            } else {
                JsonToken nextToken3 = jsonStreamReader.nextToken();
                if (nextToken3.getClass() == JsonToken.Name.class) {
                    JsonToken.Name name = (JsonToken.Name) nextToken3;
                    Iterator it = this.descriptor.fields.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics.areEqual(JsonFieldTraitsKt.getSerialName((SdkFieldDescriptor) next), name.value)) {
                            obj = next;
                            break;
                        }
                    }
                    SdkFieldDescriptor sdkFieldDescriptor = (SdkFieldDescriptor) obj;
                    if (sdkFieldDescriptor != null) {
                        r1 = sdkFieldDescriptor.index;
                    } else {
                        r1 = -1;
                    }
                    num = Integer.valueOf(r1);
                } else {
                    throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Name.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken3.getClass()));
                }
            }
        }
        if (num != null && Intrinsics.areEqual(jsonStreamReader.peek(), JsonToken.Null.INSTANCE)) {
            JsonToken nextToken4 = jsonStreamReader.nextToken();
            if (nextToken4.getClass() == JsonToken.Null.class) {
                return findNextFieldIndex();
            }
            throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Null.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken4.getClass()));
        }
        return num;
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator
    public final void skipValue() {
        this.reader.skipNext();
    }
}
