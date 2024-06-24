package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.runtime.config.imds.EndpointMode$Companion$$ExternalSyntheticOutline0;
import io.ktor.http.ContentTypesKt;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonClassDiscriminator;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: Polymorphic.kt */
/* loaded from: classes4.dex */
public final class PolymorphicKt {
    public static final String classDiscriminator(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        for (Annotation annotation : serialDescriptor.getAnnotations()) {
            if (annotation instanceof JsonClassDiscriminator) {
                return ((JsonClassDiscriminator) annotation).discriminator();
            }
        }
        return json.configuration.classDiscriminator;
    }

    public static final <T> T decodeSerializableValuePolymorphic(JsonDecoder jsonDecoder, DeserializationStrategy<? extends T> deserializer) {
        String m;
        Intrinsics.checkNotNullParameter(jsonDecoder, "<this>");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        if ((deserializer instanceof AbstractPolymorphicSerializer) && !jsonDecoder.getJson().configuration.useArrayPolymorphism) {
            String discriminator = classDiscriminator(deserializer.getDescriptor(), jsonDecoder.getJson());
            JsonElement decodeJsonElement = jsonDecoder.decodeJsonElement();
            SerialDescriptor descriptor = deserializer.getDescriptor();
            if (decodeJsonElement instanceof JsonObject) {
                JsonObject jsonObject = (JsonObject) decodeJsonElement;
                JsonElement jsonElement = (JsonElement) jsonObject.get(discriminator);
                String str = null;
                JsonPrimitive jsonPrimitive = null;
                if (jsonElement != null) {
                    InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
                    if (jsonElement instanceof JsonPrimitive) {
                        jsonPrimitive = (JsonPrimitive) jsonElement;
                    }
                    if (jsonPrimitive != null) {
                        str = jsonPrimitive.getContent();
                    } else {
                        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass(jsonElement.getClass()) + " is not a JsonPrimitive");
                    }
                }
                DeserializationStrategy<T> findPolymorphicSerializerOrNull = ((AbstractPolymorphicSerializer) deserializer).findPolymorphicSerializerOrNull(jsonDecoder, str);
                if (findPolymorphicSerializerOrNull == null) {
                    if (str == null) {
                        m = "missing class discriminator ('null')";
                    } else {
                        m = EndpointMode$Companion$$ExternalSyntheticOutline0.m("class discriminator '", str, '\'');
                    }
                    throw ContentTypesKt.JsonDecodingException(-1, ConstraintSet$$ExternalSyntheticOutline0.m("Polymorphic serializer was not found for ", m), jsonObject.toString());
                }
                Json json = jsonDecoder.getJson();
                Intrinsics.checkNotNullParameter(json, "<this>");
                Intrinsics.checkNotNullParameter(discriminator, "discriminator");
                return (T) decodeSerializableValuePolymorphic(new JsonTreeDecoder(json, jsonObject, discriminator, findPolymorphicSerializerOrNull.getDescriptor()), findPolymorphicSerializerOrNull);
            }
            throw ContentTypesKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(decodeJsonElement.getClass()));
        }
        return deserializer.deserialize(jsonDecoder);
    }
}
