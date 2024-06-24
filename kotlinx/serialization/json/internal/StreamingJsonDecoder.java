package kotlinx.serialization.json.internal;

import aws.sdk.kotlin.runtime.config.imds.EndpointMode$Companion$$ExternalSyntheticOutline0;
import com.google.common.hash.AbstractHasher;
import io.ktor.http.ContentTypesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.internal.JsonPath;

/* compiled from: StreamingJsonDecoder.kt */
/* loaded from: classes4.dex */
public final class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder {
    public final JsonConfiguration configuration;
    public int currentIndex;
    public DiscriminatorHolder discriminatorHolder;
    public final JsonElementMarker elementMarker;
    public final Json json;
    public final AbstractJsonLexer lexer;
    public final WriteMode mode;
    public final AbstractHasher serializersModule;

    /* compiled from: StreamingJsonDecoder.kt */
    /* loaded from: classes4.dex */
    public static final class DiscriminatorHolder {
        public String discriminatorToSkip;

        public DiscriminatorHolder(String str) {
            this.discriminatorToSkip = str;
        }
    }

    /* compiled from: StreamingJsonDecoder.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WriteMode.values().length];
            try {
                r0[WriteMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WriteMode.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WriteMode.POLY_OBJ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[WriteMode.OBJ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public StreamingJsonDecoder(Json json, WriteMode mode, AbstractJsonLexer lexer, SerialDescriptor descriptor, DiscriminatorHolder discriminatorHolder) {
        JsonElementMarker jsonElementMarker;
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.json = json;
        this.mode = mode;
        this.lexer = lexer;
        this.serializersModule = json.serializersModule;
        this.currentIndex = -1;
        this.discriminatorHolder = discriminatorHolder;
        JsonConfiguration jsonConfiguration = json.configuration;
        this.configuration = jsonConfiguration;
        if (jsonConfiguration.explicitNulls) {
            jsonElementMarker = null;
        } else {
            jsonElementMarker = new JsonElementMarker(descriptor);
        }
        this.elementMarker = jsonElementMarker;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Json json = this.json;
        WriteMode switchMode = WriteModeKt.switchMode(descriptor, json);
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        JsonPath jsonPath = abstractJsonLexer.path;
        jsonPath.getClass();
        int r4 = jsonPath.currentDepth + 1;
        jsonPath.currentDepth = r4;
        if (r4 == jsonPath.currentObjectPath.length) {
            jsonPath.resize();
        }
        jsonPath.currentObjectPath[r4] = descriptor;
        abstractJsonLexer.consumeNextToken(switchMode.begin);
        if (abstractJsonLexer.peekNextToken() != 4) {
            int r1 = WhenMappings.$EnumSwitchMapping$0[switchMode.ordinal()];
            if (r1 != 1 && r1 != 2 && r1 != 3) {
                if (this.mode == switchMode && json.configuration.explicitNulls) {
                    return this;
                }
                return new StreamingJsonDecoder(this.json, switchMode, this.lexer, descriptor, this.discriminatorHolder);
            }
            return new StreamingJsonDecoder(this.json, switchMode, this.lexer, descriptor, this.discriminatorHolder);
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        boolean z;
        boolean z2 = this.configuration.isLenient;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        if (z2) {
            int skipWhitespaces = abstractJsonLexer.skipWhitespaces();
            if (skipWhitespaces != abstractJsonLexer.getSource().length()) {
                if (abstractJsonLexer.getSource().charAt(skipWhitespaces) == '\"') {
                    skipWhitespaces++;
                    z = true;
                } else {
                    z = false;
                }
                boolean consumeBoolean = abstractJsonLexer.consumeBoolean(skipWhitespaces);
                if (z) {
                    if (abstractJsonLexer.currentPosition != abstractJsonLexer.getSource().length()) {
                        if (abstractJsonLexer.getSource().charAt(abstractJsonLexer.currentPosition) == '\"') {
                            abstractJsonLexer.currentPosition++;
                            return consumeBoolean;
                        }
                        AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected closing quotation mark", 0, null, 6);
                        throw null;
                    }
                    AbstractJsonLexer.fail$default(abstractJsonLexer, "EOF", 0, null, 6);
                    throw null;
                }
                return consumeBoolean;
            }
            AbstractJsonLexer.fail$default(abstractJsonLexer, "EOF", 0, null, 6);
            throw null;
        }
        return abstractJsonLexer.consumeBoolean(abstractJsonLexer.skipWhitespaces());
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        long consumeNumericLiteral = abstractJsonLexer.consumeNumericLiteral();
        byte b = (byte) consumeNumericLiteral;
        if (consumeNumericLiteral == b) {
            return b;
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse byte for input '" + consumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        if (consumeStringLenient.length() == 1) {
            return consumeStringLenient.charAt(0);
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, EndpointMode$Companion$$ExternalSyntheticOutline0.m("Expected single char, but got '", consumeStringLenient, '\''), 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        boolean z = false;
        try {
            double parseDouble = Double.parseDouble(consumeStringLenient);
            if (!this.json.configuration.allowSpecialFloatingPointValues) {
                if (!Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble)) {
                    z = true;
                }
                if (!z) {
                    ContentTypesKt.throwInvalidFloatingPointDecoded(abstractJsonLexer, Double.valueOf(parseDouble));
                    throw null;
                }
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, EndpointMode$Companion$$ExternalSyntheticOutline0.m("Failed to parse type 'double' for input '", consumeStringLenient, '\''), 0, null, 6);
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x00d2, code lost:            if (r7 == null) goto L373;     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00d4, code lost:            r1 = r7.origin;     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00d8, code lost:            if (r12 >= 64) goto L266;     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00da, code lost:            r1.lowerMarks |= 1 << r12;     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00e4, code lost:            r2 = (r12 >>> 6) - 1;        r1 = r1.highMarksArray;        r1[r2] = (1 << (r12 & 63)) | r1[r2];     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00d2 A[EDGE_INSN: B:105:0x00d2->B:106:0x00d2 BREAK  A[LOOP:0: B:21:0x004d->B:57:0x01dd], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
    @Override // kotlinx.serialization.encoding.CompositeDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int decodeElementIndex(kotlinx.serialization.descriptors.SerialDescriptor r18) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeElementIndex(kotlinx.serialization.descriptors.SerialDescriptor):int");
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow(enumDescriptor, this.json, decodeString(), " at path ".concat(this.lexer.path.getPath()));
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        boolean z = false;
        try {
            float parseFloat = Float.parseFloat(consumeStringLenient);
            if (!this.json.configuration.allowSpecialFloatingPointValues) {
                if (!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat)) {
                    z = true;
                }
                if (!z) {
                    ContentTypesKt.throwInvalidFloatingPointDecoded(abstractJsonLexer, Float.valueOf(parseFloat));
                    throw null;
                }
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, EndpointMode$Companion$$ExternalSyntheticOutline0.m("Failed to parse type 'float' for input '", consumeStringLenient, '\''), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(descriptor)) {
            return new JsonDecoderForUnsignedTypes(this.lexer, this.json);
        }
        return this;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        long consumeNumericLiteral = abstractJsonLexer.consumeNumericLiteral();
        int r3 = (int) consumeNumericLiteral;
        if (consumeNumericLiteral == r3) {
            return r3;
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse int for input '" + consumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final JsonElement decodeJsonElement() {
        return new JsonTreeReader(this.json.configuration, this.lexer).read();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean decodeNotNullMark() {
        boolean z;
        JsonElementMarker jsonElementMarker = this.elementMarker;
        if (jsonElementMarker != null) {
            z = jsonElementMarker.isUnmarkedNull;
        } else {
            z = false;
        }
        if (z || this.lexer.tryConsumeNull(true)) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T decodeSerializableElement(SerialDescriptor descriptor, int r9, DeserializationStrategy<? extends T> deserializer, T t) {
        boolean z;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        if (this.mode == WriteMode.MAP && (r9 & 1) == 0) {
            z = true;
        } else {
            z = false;
        }
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        if (z) {
            JsonPath jsonPath = abstractJsonLexer.path;
            int[] r5 = jsonPath.indicies;
            int r6 = jsonPath.currentDepth;
            if (r5[r6] == -2) {
                jsonPath.currentObjectPath[r6] = JsonPath.Tombstone.INSTANCE;
            }
        }
        T t2 = (T) super.decodeSerializableElement(descriptor, r9, deserializer, t);
        if (z) {
            JsonPath jsonPath2 = abstractJsonLexer.path;
            int[] r10 = jsonPath2.indicies;
            int r11 = jsonPath2.currentDepth;
            if (r10[r11] != -2) {
                int r112 = r11 + 1;
                jsonPath2.currentDepth = r112;
                if (r112 == jsonPath2.currentObjectPath.length) {
                    jsonPath2.resize();
                }
            }
            Object[] objArr = jsonPath2.currentObjectPath;
            int r113 = jsonPath2.currentDepth;
            objArr[r113] = t2;
            jsonPath2.indicies[r113] = -2;
        }
        return t2;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final <T> T decodeSerializableValue$1(DeserializationStrategy<? extends T> deserializer) {
        DeserializationStrategy<T> deserializationStrategy;
        Json json = this.json;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        try {
            if ((deserializer instanceof AbstractPolymorphicSerializer) && !json.configuration.useArrayPolymorphism) {
                String classDiscriminator = PolymorphicKt.classDiscriminator(deserializer.getDescriptor(), json);
                String consumeLeadingMatchingValue = abstractJsonLexer.consumeLeadingMatchingValue(classDiscriminator, this.configuration.isLenient);
                if (consumeLeadingMatchingValue != null) {
                    deserializationStrategy = ((AbstractPolymorphicSerializer) deserializer).findPolymorphicSerializerOrNull(this, consumeLeadingMatchingValue);
                } else {
                    deserializationStrategy = null;
                }
                if (deserializationStrategy == null) {
                    return (T) PolymorphicKt.decodeSerializableValuePolymorphic(this, deserializer);
                }
                this.discriminatorHolder = new DiscriminatorHolder(classDiscriminator);
                return deserializationStrategy.deserialize(this);
            }
            return deserializer.deserialize(this);
        } catch (MissingFieldException e) {
            throw new MissingFieldException(e.missingFields, e.getMessage() + " at path: " + abstractJsonLexer.path.getPath(), e);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        long consumeNumericLiteral = abstractJsonLexer.consumeNumericLiteral();
        short s = (short) consumeNumericLiteral;
        if (consumeNumericLiteral == s) {
            return s;
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse short for input '" + consumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        boolean z = this.configuration.isLenient;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        if (z) {
            return abstractJsonLexer.consumeStringLenientNotNull();
        }
        return abstractJsonLexer.consumeString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:            if (r6.getElementsCount() == 0) goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:            if (decodeElementIndex(r6) != (-1)) goto L34;     */
    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void endStructure(kotlinx.serialization.descriptors.SerialDescriptor r6) {
        /*
            r5 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlinx.serialization.json.Json r0 = r5.json
            kotlinx.serialization.json.JsonConfiguration r0 = r0.configuration
            boolean r0 = r0.ignoreUnknownKeys
            r1 = -1
            if (r0 == 0) goto L1a
            int r0 = r6.getElementsCount()
            if (r0 != 0) goto L1a
        L14:
            int r0 = r5.decodeElementIndex(r6)
            if (r0 != r1) goto L14
        L1a:
            kotlinx.serialization.json.internal.WriteMode r6 = r5.mode
            char r6 = r6.end
            kotlinx.serialization.json.internal.AbstractJsonLexer r0 = r5.lexer
            r0.consumeNextToken(r6)
            kotlinx.serialization.json.internal.JsonPath r6 = r0.path
            int r0 = r6.currentDepth
            int[] r2 = r6.indicies
            r3 = r2[r0]
            r4 = -2
            if (r3 != r4) goto L33
            r2[r0] = r1
            int r0 = r0 + r1
            r6.currentDepth = r0
        L33:
            int r0 = r6.currentDepth
            if (r0 == r1) goto L3a
            int r0 = r0 + r1
            r6.currentDepth = r0
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonDecoder.endStructure(kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final Json getJson() {
        return this.json;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final AbstractHasher getSerializersModule() {
        return this.serializersModule;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final void decodeNull() {
    }
}
