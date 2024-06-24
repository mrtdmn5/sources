package kotlinx.serialization.json.internal;

import aws.sdk.kotlin.runtime.config.imds.EndpointMode$Companion$$ExternalSyntheticOutline0;
import com.google.common.hash.AbstractHasher;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.UStringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.json.Json;

/* compiled from: StreamingJsonDecoder.kt */
/* loaded from: classes4.dex */
public final class JsonDecoderForUnsignedTypes extends AbstractDecoder {
    public final AbstractJsonLexer lexer;
    public final AbstractHasher serializersModule;

    public JsonDecoderForUnsignedTypes(AbstractJsonLexer lexer, Json json) {
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(json, "json");
        this.lexer = lexer;
        this.serializersModule = json.serializersModule;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            return UStringsKt.toUByte(consumeStringLenient);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, EndpointMode$Companion$$ExternalSyntheticOutline0.m("Failed to parse type 'UByte' for input '", consumeStringLenient, '\''), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new IllegalStateException("unsupported".toString());
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            return UStringsKt.toUInt(consumeStringLenient);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, EndpointMode$Companion$$ExternalSyntheticOutline0.m("Failed to parse type 'UInt' for input '", consumeStringLenient, '\''), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            Intrinsics.checkNotNullParameter(consumeStringLenient, "<this>");
            ULong uLongOrNull = UStringsKt.toULongOrNull(consumeStringLenient);
            if (uLongOrNull != null) {
                return uLongOrNull.data;
            }
            StringsKt__StringNumberConversionsKt.numberFormatError(consumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, EndpointMode$Companion$$ExternalSyntheticOutline0.m("Failed to parse type 'ULong' for input '", consumeStringLenient, '\''), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            Intrinsics.checkNotNullParameter(consumeStringLenient, "<this>");
            UShort uShortOrNull = UStringsKt.toUShortOrNull(10, consumeStringLenient);
            if (uShortOrNull != null) {
                return uShortOrNull.data;
            }
            StringsKt__StringNumberConversionsKt.numberFormatError(consumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, EndpointMode$Companion$$ExternalSyntheticOutline0.m("Failed to parse type 'UShort' for input '", consumeStringLenient, '\''), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final AbstractHasher getSerializersModule() {
        return this.serializersModule;
    }
}
