package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.Deserializer$EntryIterator;
import aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator;
import aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.json.JsonToken;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: JsonDeserializer.kt */
/* loaded from: classes.dex */
public final class JsonDeserializer implements PrimitiveDeserializer, Deserializer$EntryIterator {
    public static final Set<String> validNumberStrings = SetsKt__SetsKt.setOf((Object[]) new String[]{"Infinity", "-Infinity", "NaN"});
    public final JsonLexer reader;

    public JsonDeserializer(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.reader = new JsonLexer(payload);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public final boolean deserializeBoolean() {
        JsonToken nextToken = this.reader.nextToken();
        if (nextToken.getClass() == JsonToken.Bool.class) {
            return ((JsonToken.Bool) nextToken).value;
        }
        throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Bool.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken.getClass()));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public final int deserializeInt() {
        Object invoke;
        JsonToken nextToken = this.reader.nextToken();
        boolean z = nextToken instanceof JsonToken.Number;
        JsonDeserializer$deserializeInt$1 jsonDeserializer$deserializeInt$1 = JsonDeserializer$deserializeInt$1.INSTANCE;
        if (z) {
            invoke = jsonDeserializer$deserializeInt$1.invoke(((JsonToken.Number) nextToken).value);
        } else {
            if (nextToken instanceof JsonToken.String) {
                JsonToken.String string = (JsonToken.String) nextToken;
                if (validNumberStrings.contains(string.value)) {
                    invoke = jsonDeserializer$deserializeInt$1.invoke(string.value);
                }
            }
            throw new DeserializationException(nextToken + " cannot be deserialized as type Number");
        }
        return ((Number) invoke).intValue();
    }

    public final JsonDeserializer deserializeList(SdkFieldDescriptor sdkFieldDescriptor) {
        JsonToken nextToken = this.reader.nextToken();
        if (nextToken.getClass() == JsonToken.BeginArray.class) {
            return this;
        }
        throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.BeginArray.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken.getClass()));
    }

    public final Deserializer$EntryIterator deserializeMap(SdkFieldDescriptor sdkFieldDescriptor) {
        JsonToken nextToken = this.reader.nextToken();
        if (nextToken.getClass() == JsonToken.BeginObject.class) {
            return this;
        }
        throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.BeginObject.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken.getClass()));
    }

    public final void deserializeNull() {
        JsonToken nextToken = this.reader.nextToken();
        if (nextToken.getClass() == JsonToken.Null.class) {
            return;
        }
        throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Null.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken.getClass()));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public final String deserializeString() {
        JsonToken nextToken = this.reader.nextToken();
        if (nextToken instanceof JsonToken.String) {
            return ((JsonToken.String) nextToken).value;
        }
        if (nextToken instanceof JsonToken.Number) {
            return ((JsonToken.Number) nextToken).value;
        }
        if (nextToken instanceof JsonToken.Bool) {
            return String.valueOf(((JsonToken.Bool) nextToken).value);
        }
        throw new DeserializationException(nextToken + " cannot be deserialized as type String");
    }

    public final Deserializer$FieldIterator deserializeStruct(SdkObjectDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonLexer jsonLexer = this.reader;
        JsonToken peek = jsonLexer.peek();
        if (Intrinsics.areEqual(peek, JsonToken.BeginObject.INSTANCE)) {
            JsonToken nextToken = jsonLexer.nextToken();
            if (nextToken.getClass() == JsonToken.BeginObject.class) {
                return new JsonFieldIterator(jsonLexer, descriptor, this);
            }
            throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.BeginObject.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken.getClass()));
        }
        if (Intrinsics.areEqual(peek, JsonToken.Null.INSTANCE)) {
            return new JsonNullFieldIterator(this);
        }
        throw new DeserializationException("Unexpected token type " + jsonLexer.peek());
    }

    public final boolean hasNextElement() {
        JsonLexer jsonLexer = this.reader;
        JsonToken peek = jsonLexer.peek();
        if (Intrinsics.areEqual(peek, JsonToken.EndArray.INSTANCE)) {
            JsonToken nextToken = jsonLexer.nextToken();
            if (nextToken.getClass() == JsonToken.EndArray.class) {
            } else {
                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.EndArray.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken.getClass()));
            }
        } else if (!Intrinsics.areEqual(peek, JsonToken.EndDocument.INSTANCE)) {
            return true;
        }
        return false;
    }

    public final boolean hasNextEntry() {
        boolean areEqual;
        JsonLexer jsonLexer = this.reader;
        JsonToken peek = jsonLexer.peek();
        if (Intrinsics.areEqual(peek, JsonToken.EndObject.INSTANCE)) {
            JsonToken nextToken = jsonLexer.nextToken();
            if (nextToken.getClass() == JsonToken.EndObject.class) {
            } else {
                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.EndObject.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken.getClass()));
            }
        } else {
            if (Intrinsics.areEqual(peek, JsonToken.Null.INSTANCE)) {
                areEqual = true;
            } else {
                areEqual = Intrinsics.areEqual(peek, JsonToken.EndDocument.INSTANCE);
            }
            if (!areEqual) {
                return true;
            }
        }
        return false;
    }

    public final String key() {
        JsonToken nextToken = this.reader.nextToken();
        if (nextToken.getClass() == JsonToken.Name.class) {
            return ((JsonToken.Name) nextToken).value;
        }
        throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Name.class) + "; found " + Reflection.getOrCreateKotlinClass(nextToken.getClass()));
    }

    public final boolean nextHasValue() {
        return !Intrinsics.areEqual(this.reader.peek(), JsonToken.Null.INSTANCE);
    }
}
