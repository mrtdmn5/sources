package kotlinx.datetime.serializers;

import j$.time.format.DateTimeParseException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.LocalTime;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

/* compiled from: LocalTimeSerializers.kt */
/* loaded from: classes4.dex */
public final class LocalTimeIso8601Serializer implements KSerializer<LocalTime> {
    public static final LocalTimeIso8601Serializer INSTANCE = new LocalTimeIso8601Serializer();
    public static final PrimitiveSerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("LocalTime", PrimitiveKind.STRING.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        LocalTime.Companion companion = LocalTime.Companion;
        String isoString = decoder.decodeString();
        companion.getClass();
        Intrinsics.checkNotNullParameter(isoString, "isoString");
        try {
            return new LocalTime(j$.time.LocalTime.parse(isoString));
        } catch (DateTimeParseException e) {
            throw new DateTimeFormatException(e);
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        LocalTime value = (LocalTime) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeString(value.toString());
    }
}
