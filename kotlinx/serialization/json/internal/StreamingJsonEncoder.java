package kotlinx.serialization.json.internal;

import aws.smithy.kotlin.runtime.net.IpAddr;
import com.amazonaws.services.s3.internal.Constants;
import com.google.common.hash.AbstractHasher;
import io.ktor.http.ContentTypesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import okhttp3.internal._HostnamesJvmKt;

/* compiled from: StreamingJsonEncoder.kt */
/* loaded from: classes4.dex */
public final class StreamingJsonEncoder extends IpAddr implements JsonEncoder {
    public final Composer composer;
    public final JsonConfiguration configuration;
    public boolean forceQuoting;
    public final Json json;
    public final WriteMode mode;
    public final JsonEncoder[] modeReuseCache;
    public String polymorphicDiscriminator;
    public final AbstractHasher serializersModule;

    /* compiled from: StreamingJsonEncoder.kt */
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
            $EnumSwitchMapping$0 = r0;
        }
    }

    public StreamingJsonEncoder(Composer composer, Json json, WriteMode mode, JsonEncoder[] jsonEncoderArr) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.composer = composer;
        this.json = json;
        this.mode = mode;
        this.modeReuseCache = jsonEncoderArr;
        this.serializersModule = json.serializersModule;
        this.configuration = json.configuration;
        int ordinal = mode.ordinal();
        if (jsonEncoderArr != null) {
            JsonEncoder jsonEncoder = jsonEncoderArr[ordinal];
            if (jsonEncoder != null || jsonEncoder != this) {
                jsonEncoderArr[ordinal] = this;
            }
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        JsonEncoder jsonEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Json json = this.json;
        WriteMode switchMode = WriteModeKt.switchMode(descriptor, json);
        char c = switchMode.begin;
        Composer composer = this.composer;
        if (c != 0) {
            composer.print(c);
            composer.indent();
        }
        if (this.polymorphicDiscriminator != null) {
            composer.nextItem();
            String str = this.polymorphicDiscriminator;
            Intrinsics.checkNotNull(str);
            encodeString(str);
            composer.print(':');
            composer.space();
            encodeString(descriptor.getSerialName());
            this.polymorphicDiscriminator = null;
        }
        if (this.mode == switchMode) {
            return this;
        }
        JsonEncoder[] jsonEncoderArr = this.modeReuseCache;
        if (jsonEncoderArr == null || (jsonEncoder = jsonEncoderArr[switchMode.ordinal()]) == null) {
            return new StreamingJsonEncoder(composer, json, switchMode, jsonEncoderArr);
        }
        return jsonEncoder;
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.Encoder
    public final void encodeBoolean(boolean z) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(z));
        } else {
            this.composer.writer.write(String.valueOf(z));
        }
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.Encoder
    public final void encodeByte(byte b) {
        if (this.forceQuoting) {
            encodeString(String.valueOf((int) b));
        } else {
            this.composer.print(b);
        }
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.Encoder
    public final void encodeChar(char c) {
        encodeString(String.valueOf(c));
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.Encoder
    public final void encodeDouble(double d) {
        boolean z;
        boolean z2 = this.forceQuoting;
        Composer composer = this.composer;
        if (z2) {
            encodeString(String.valueOf(d));
        } else {
            composer.writer.write(String.valueOf(d));
        }
        if (!this.configuration.allowSpecialFloatingPointValues) {
            if (!Double.isInfinite(d) && !Double.isNaN(d)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw ContentTypesKt.InvalidFloatingPointEncoded(Double.valueOf(d), composer.writer.toString());
            }
        }
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr
    public final void encodeElement(SerialDescriptor descriptor, int r9) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        boolean z = true;
        Composer composer = this.composer;
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (!composer.writingFirst) {
                        composer.print(',');
                    }
                    composer.nextItem();
                    Json json = this.json;
                    Intrinsics.checkNotNullParameter(json, "json");
                    JsonNamesMapKt.namingStrategy(descriptor, json);
                    encodeString(descriptor.getElementName(r9));
                    composer.print(':');
                    composer.space();
                    return;
                }
                if (r9 == 0) {
                    this.forceQuoting = true;
                }
                if (r9 == 1) {
                    composer.print(',');
                    composer.space();
                    this.forceQuoting = false;
                    return;
                }
                return;
            }
            if (!composer.writingFirst) {
                if (r9 % 2 == 0) {
                    composer.print(',');
                    composer.nextItem();
                } else {
                    composer.print(':');
                    composer.space();
                    z = false;
                }
                this.forceQuoting = z;
                return;
            }
            this.forceQuoting = true;
            composer.nextItem();
            return;
        }
        if (!composer.writingFirst) {
            composer.print(',');
        }
        composer.nextItem();
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeEnum(SerialDescriptor enumDescriptor, int r3) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeString(enumDescriptor.getElementName(r3));
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.Encoder
    public final void encodeFloat(float f) {
        boolean z;
        boolean z2 = this.forceQuoting;
        Composer composer = this.composer;
        if (z2) {
            encodeString(String.valueOf(f));
        } else {
            composer.writer.write(String.valueOf(f));
        }
        if (!this.configuration.allowSpecialFloatingPointValues) {
            if (!Float.isInfinite(f) && !Float.isNaN(f)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw ContentTypesKt.InvalidFloatingPointEncoded(Float.valueOf(f), composer.writer.toString());
            }
        }
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.Encoder
    public final Encoder encodeInline(SerialDescriptor descriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        boolean isUnsignedNumber = StreamingJsonEncoderKt.isUnsignedNumber(descriptor);
        WriteMode writeMode = this.mode;
        Json json = this.json;
        Composer composer = this.composer;
        if (isUnsignedNumber) {
            if (!(composer instanceof ComposerForUnsignedNumbers)) {
                composer = new ComposerForUnsignedNumbers(composer.writer, this.forceQuoting);
            }
            return new StreamingJsonEncoder(composer, json, writeMode, null);
        }
        if (descriptor.isInline() && Intrinsics.areEqual(descriptor, JsonElementKt.jsonUnquotedLiteralDescriptor)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (!(composer instanceof ComposerForUnquotedLiterals)) {
                composer = new ComposerForUnquotedLiterals(composer.writer, this.forceQuoting);
            }
            return new StreamingJsonEncoder(composer, json, writeMode, null);
        }
        return this;
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.Encoder
    public final void encodeInt(int r2) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(r2));
        } else {
            this.composer.print(r2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.Encoder
    public final void encodeLong(long j) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(j));
        } else {
            this.composer.print(j);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeNull() {
        this.composer.print(Constants.NULL_VERSION_ID);
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeNullableSerializableElement(SerialDescriptor descriptor, int r3, KSerializer serializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (obj != null || this.configuration.explicitNulls) {
            super.encodeNullableSerializableElement(descriptor, r3, serializer, obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.Encoder
    public final <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (serializer instanceof AbstractPolymorphicSerializer) {
            Json json = this.json;
            if (!json.configuration.useArrayPolymorphism) {
                AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializer;
                String classDiscriminator = PolymorphicKt.classDiscriminator(serializer.getDescriptor(), json);
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Any");
                SerializationStrategy findPolymorphicSerializer = _HostnamesJvmKt.findPolymorphicSerializer(abstractPolymorphicSerializer, this, t);
                if (abstractPolymorphicSerializer instanceof SealedClassSerializer) {
                    SerialDescriptor descriptor = findPolymorphicSerializer.getDescriptor();
                    Intrinsics.checkNotNullParameter(descriptor, "<this>");
                    if (Platform_commonKt.cachedSerialNames(descriptor).contains(classDiscriminator)) {
                        String serialName = abstractPolymorphicSerializer.getDescriptor().getSerialName();
                        throw new IllegalStateException(("Sealed class '" + findPolymorphicSerializer.getDescriptor().getSerialName() + "' cannot be serialized as base class '" + serialName + "' because it has property name that conflicts with JSON class discriminator '" + classDiscriminator + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
                    }
                }
                SerialKind kind = findPolymorphicSerializer.getDescriptor().getKind();
                Intrinsics.checkNotNullParameter(kind, "kind");
                if (!(kind instanceof SerialKind.ENUM)) {
                    if (!(kind instanceof PrimitiveKind)) {
                        if (!(kind instanceof PolymorphicKind)) {
                            this.polymorphicDiscriminator = classDiscriminator;
                            findPolymorphicSerializer.serialize(this, t);
                            return;
                        }
                        throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
                    }
                    throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
                }
                throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
            }
        }
        serializer.serialize(this, t);
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.Encoder
    public final void encodeShort(short s) {
        if (this.forceQuoting) {
            encodeString(String.valueOf((int) s));
        } else {
            this.composer.print(s);
        }
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr, kotlinx.serialization.encoding.Encoder
    public final void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.composer.printQuoted(value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        WriteMode writeMode = this.mode;
        if (writeMode.end != 0) {
            Composer composer = this.composer;
            composer.unIndent();
            composer.nextItem();
            composer.print(writeMode.end);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final AbstractHasher getSerializersModule() {
        return this.serializersModule;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final boolean shouldEncodeElementDefault(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.configuration.encodeDefaults;
    }
}
