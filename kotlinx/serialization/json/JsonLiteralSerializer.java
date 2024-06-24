package kotlinx.serialization.json;

import io.ktor.http.ContentTypesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes4.dex */
public final class JsonLiteralSerializer implements KSerializer<JsonLiteral> {
    public static final JsonLiteralSerializer INSTANCE = new JsonLiteralSerializer();
    public static final PrimitiveSerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("kotlinx.serialization.json.JsonLiteral", PrimitiveKind.STRING.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElement decodeJsonElement = JsonElementSerializersKt.asJsonDecoder(decoder).decodeJsonElement();
        if (decodeJsonElement instanceof JsonLiteral) {
            return (JsonLiteral) decodeJsonElement;
        }
        throw ContentTypesKt.JsonDecodingException(-1, "Unexpected JSON element, expected JsonLiteral, had " + Reflection.getOrCreateKotlinClass(decodeJsonElement.getClass()), decodeJsonElement.toString());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
    @Override // kotlinx.serialization.SerializationStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void serialize(kotlinx.serialization.encoding.Encoder r5, java.lang.Object r6) {
        /*
            r4 = this;
            kotlinx.serialization.json.JsonLiteral r6 = (kotlinx.serialization.json.JsonLiteral) r6
            java.lang.String r0 = "encoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlinx.serialization.json.JsonElementSerializersKt.access$verify(r5)
            boolean r0 = r6.isString
            java.lang.String r1 = r6.content
            if (r0 == 0) goto L19
            r5.encodeString(r1)
            goto L79
        L19:
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r6.coerceToInlineType
            if (r0 == 0) goto L25
            kotlinx.serialization.encoding.Encoder r5 = r5.encodeInline(r0)
            r5.encodeString(r1)
            goto L79
        L25:
            kotlinx.serialization.internal.InlineClassDescriptor r0 = kotlinx.serialization.json.JsonElementKt.jsonUnquotedLiteralDescriptor
            java.lang.Long r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1)
            if (r0 == 0) goto L35
            long r0 = r0.longValue()
            r5.encodeLong(r0)
            goto L79
        L35:
            kotlin.ULong r0 = kotlin.text.UStringsKt.toULongOrNull(r1)
            if (r0 == 0) goto L47
            kotlinx.serialization.internal.InlineClassDescriptor r6 = kotlinx.serialization.internal.ULongSerializer.descriptor
            kotlinx.serialization.encoding.Encoder r5 = r5.encodeInline(r6)
            long r0 = r0.data
            r5.encodeLong(r0)
            goto L79
        L47:
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            kotlin.text.Regex r0 = kotlin.text.ScreenFloatValueRegEx.value     // Catch: java.lang.NumberFormatException -> L5d
            boolean r0 = r0.matches(r1)     // Catch: java.lang.NumberFormatException -> L5d
            if (r0 == 0) goto L5d
            double r2 = java.lang.Double.parseDouble(r1)     // Catch: java.lang.NumberFormatException -> L5d
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch: java.lang.NumberFormatException -> L5d
            goto L5e
        L5d:
            r0 = 0
        L5e:
            if (r0 == 0) goto L68
            double r0 = r0.doubleValue()
            r5.encodeDouble(r0)
            goto L79
        L68:
            java.lang.Boolean r6 = kotlinx.serialization.json.JsonElementKt.getBooleanOrNull(r6)
            if (r6 == 0) goto L76
            boolean r6 = r6.booleanValue()
            r5.encodeBoolean(r6)
            goto L79
        L76:
            r5.encodeString(r1)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.JsonLiteralSerializer.serialize(kotlinx.serialization.encoding.Encoder, java.lang.Object):void");
    }
}
