package kotlinx.serialization.json.internal;

import aws.sdk.kotlin.runtime.config.imds.EndpointMode$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import com.google.common.hash.AbstractHasher;
import io.ktor.http.ContentTypesKt;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: TreeJsonDecoder.kt */
/* loaded from: classes4.dex */
public abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {
    public final JsonConfiguration configuration;
    public final Json json;

    public AbstractJsonTreeDecoder(Json json) {
        this.json = json;
        this.configuration = json.configuration;
    }

    public static JsonLiteral asLiteral(JsonPrimitive jsonPrimitive, String str) {
        JsonLiteral jsonLiteral;
        if (jsonPrimitive instanceof JsonLiteral) {
            jsonLiteral = (JsonLiteral) jsonPrimitive;
        } else {
            jsonLiteral = null;
        }
        if (jsonLiteral != null) {
            return jsonLiteral;
        }
        throw ContentTypesKt.JsonDecodingException(-1, "Unexpected 'null' when " + str + " was expected");
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        boolean z;
        CompositeDecoder jsonTreeDecoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonElement currentObject = currentObject();
        SerialKind kind = descriptor.getKind();
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE)) {
            z = true;
        } else {
            z = kind instanceof PolymorphicKind;
        }
        Json json = this.json;
        if (z) {
            if (currentObject instanceof JsonArray) {
                jsonTreeDecoder = new JsonTreeListDecoder(json, (JsonArray) currentObject);
            } else {
                throw ContentTypesKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
            }
        } else if (Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            SerialDescriptor carrierDescriptor = WriteModeKt.carrierDescriptor(descriptor.getElementDescriptor(0), json.serializersModule);
            SerialKind kind2 = carrierDescriptor.getKind();
            if (!(kind2 instanceof PrimitiveKind) && !Intrinsics.areEqual(kind2, SerialKind.ENUM.INSTANCE)) {
                if (json.configuration.allowStructuredMapKeys) {
                    if (currentObject instanceof JsonArray) {
                        jsonTreeDecoder = new JsonTreeListDecoder(json, (JsonArray) currentObject);
                    } else {
                        throw ContentTypesKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
                    }
                } else {
                    throw ContentTypesKt.InvalidKeyKindException(carrierDescriptor);
                }
            } else if (currentObject instanceof JsonObject) {
                jsonTreeDecoder = new JsonTreeMapDecoder(json, (JsonObject) currentObject);
            } else {
                throw ContentTypesKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
            }
        } else if (currentObject instanceof JsonObject) {
            jsonTreeDecoder = new JsonTreeDecoder(json, (JsonObject) currentObject, null, null);
        } else {
            throw ContentTypesKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
        }
        return jsonTreeDecoder;
    }

    public abstract JsonElement currentElement(String str);

    public final JsonElement currentObject() {
        JsonElement currentElement;
        String str = (String) CollectionsKt___CollectionsKt.lastOrNull(this.tagStack);
        if (str == null || (currentElement = currentElement(str)) == null) {
            return getValue();
        }
        return currentElement;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final JsonElement decodeJsonElement() {
        return currentObject();
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !(currentObject() instanceof JsonNull);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public final <T> T decodeSerializableValue$1(DeserializationStrategy<? extends T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) PolymorphicKt.decodeSerializableValuePolymorphic(this, deserializer);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final boolean decodeTaggedBoolean(String str) {
        String tag = str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive primitiveValue = getPrimitiveValue(tag);
        if (!this.json.configuration.isLenient && asLiteral(primitiveValue, "boolean").isString) {
            throw ContentTypesKt.JsonDecodingException(-1, zzav$$ExternalSyntheticOutline0.m("Boolean literal for key '", tag, "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON."), currentObject().toString());
        }
        try {
            Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(primitiveValue);
            if (booleanOrNull != null) {
                return booleanOrNull.booleanValue();
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("boolean");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final byte decodeTaggedByte(String str) {
        boolean z;
        Byte b;
        String tag = str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive primitiveValue = getPrimitiveValue(tag);
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
            int parseInt = Integer.parseInt(primitiveValue.getContent());
            if (-128 <= parseInt && parseInt <= 127) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                b = Byte.valueOf((byte) parseInt);
            } else {
                b = null;
            }
            if (b != null) {
                return b.byteValue();
            }
            unparsedPrimitive("byte");
            throw null;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("byte");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final char decodeTaggedChar(String str) {
        String tag = str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            String content = getPrimitiveValue(tag).getContent();
            Intrinsics.checkNotNullParameter(content, "<this>");
            int length = content.length();
            if (length != 0) {
                if (length == 1) {
                    return content.charAt(0);
                }
                throw new IllegalArgumentException("Char sequence has more than one element.");
            }
            throw new NoSuchElementException("Char sequence is empty.");
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("char");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final double decodeTaggedDouble(String str) {
        boolean z;
        String tag = str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive primitiveValue = getPrimitiveValue(tag);
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
            double parseDouble = Double.parseDouble(primitiveValue.getContent());
            if (!this.json.configuration.allowSpecialFloatingPointValues) {
                if (!Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw ContentTypesKt.InvalidFloatingPointDecoded(Double.valueOf(parseDouble), tag, currentObject().toString());
                }
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(AnalyticsConstants.KEY_DOUBLE);
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final int decodeTaggedEnum(String str, SerialDescriptor enumDescriptor) {
        String tag = str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow(enumDescriptor, this.json, getPrimitiveValue(tag).getContent(), "");
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final float decodeTaggedFloat(String str) {
        boolean z;
        String tag = str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive primitiveValue = getPrimitiveValue(tag);
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
            float parseFloat = Float.parseFloat(primitiveValue.getContent());
            if (!this.json.configuration.allowSpecialFloatingPointValues) {
                if (!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw ContentTypesKt.InvalidFloatingPointDecoded(Float.valueOf(parseFloat), tag, currentObject().toString());
                }
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("float");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final Decoder decodeTaggedInline(String str, SerialDescriptor inlineDescriptor) {
        String tag = str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(inlineDescriptor)) {
            return new JsonDecoderForUnsignedTypes(new StringJsonLexer(getPrimitiveValue(tag).getContent()), this.json);
        }
        this.tagStack.add(tag);
        return this;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final int decodeTaggedInt(String str) {
        String tag = str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive primitiveValue = getPrimitiveValue(tag);
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
            return Integer.parseInt(primitiveValue.getContent());
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("int");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final long decodeTaggedLong(String str) {
        String tag = str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive primitiveValue = getPrimitiveValue(tag);
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
            return Long.parseLong(primitiveValue.getContent());
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("long");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final short decodeTaggedShort(String str) {
        boolean z;
        Short sh;
        String tag = str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive primitiveValue = getPrimitiveValue(tag);
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
            int parseInt = Integer.parseInt(primitiveValue.getContent());
            if (-32768 <= parseInt && parseInt <= 32767) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                sh = Short.valueOf((short) parseInt);
            } else {
                sh = null;
            }
            if (sh != null) {
                return sh.shortValue();
            }
            unparsedPrimitive("short");
            throw null;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("short");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final String decodeTaggedString(String str) {
        String tag = str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive primitiveValue = getPrimitiveValue(tag);
        if (!this.json.configuration.isLenient && !asLiteral(primitiveValue, "string").isString) {
            throw ContentTypesKt.JsonDecodingException(-1, zzav$$ExternalSyntheticOutline0.m("String literal for key '", tag, "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON."), currentObject().toString());
        }
        if (!(primitiveValue instanceof JsonNull)) {
            return primitiveValue.getContent();
        }
        throw ContentTypesKt.JsonDecodingException(-1, "Unexpected 'null' value instead of string literal", currentObject().toString());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final Json getJson() {
        return this.json;
    }

    public final JsonPrimitive getPrimitiveValue(String tag) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement currentElement = currentElement(tag);
        if (currentElement instanceof JsonPrimitive) {
            jsonPrimitive = (JsonPrimitive) currentElement;
        } else {
            jsonPrimitive = null;
        }
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw ContentTypesKt.JsonDecodingException(-1, "Expected JsonPrimitive at " + tag + ", found " + currentElement, currentObject().toString());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final AbstractHasher getSerializersModule() {
        return this.json.serializersModule;
    }

    public abstract JsonElement getValue();

    public final void unparsedPrimitive(String str) {
        throw ContentTypesKt.JsonDecodingException(-1, EndpointMode$Companion$$ExternalSyntheticOutline0.m("Failed to parse '", str, '\''), currentObject().toString());
    }
}
