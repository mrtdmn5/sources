package kotlinx.datetime.serializers;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimePeriod;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

/* compiled from: DateTimePeriodSerializers.kt */
/* loaded from: classes4.dex */
public final class DateTimePeriodIso8601Serializer implements KSerializer<DateTimePeriod> {
    public static final DateTimePeriodIso8601Serializer INSTANCE = new DateTimePeriodIso8601Serializer();
    public static final PrimitiveSerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("DateTimePeriod", PrimitiveKind.STRING.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        DateTimePeriod.Companion companion = DateTimePeriod.Companion;
        String decodeString = decoder.decodeString();
        companion.getClass();
        return DateTimePeriod.Companion.parse(decodeString);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        DateTimePeriod value = (DateTimePeriod) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeString(value.toString());
    }
}
