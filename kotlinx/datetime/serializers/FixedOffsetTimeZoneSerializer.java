package kotlinx.datetime.serializers;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.FixedOffsetTimeZone;
import kotlinx.datetime.TimeZone;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

/* compiled from: TimeZoneSerializers.kt */
/* loaded from: classes4.dex */
public final class FixedOffsetTimeZoneSerializer implements KSerializer<FixedOffsetTimeZone> {
    public static final FixedOffsetTimeZoneSerializer INSTANCE = new FixedOffsetTimeZoneSerializer();
    public static final PrimitiveSerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("FixedOffsetTimeZone", PrimitiveKind.STRING.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        TimeZone.Companion companion = TimeZone.Companion;
        String decodeString = decoder.decodeString();
        companion.getClass();
        TimeZone of = TimeZone.Companion.of(decodeString);
        if (of instanceof FixedOffsetTimeZone) {
            return (FixedOffsetTimeZone) of;
        }
        throw new SerializationException("Timezone identifier '" + of + "' does not correspond to a fixed-offset timezone");
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        FixedOffsetTimeZone value = (FixedOffsetTimeZone) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeString(value.getId());
    }
}
