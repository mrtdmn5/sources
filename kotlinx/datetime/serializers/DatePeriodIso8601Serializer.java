package kotlinx.datetime.serializers;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DatePeriod;
import kotlinx.datetime.DateTimePeriod;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

/* compiled from: DateTimePeriodSerializers.kt */
/* loaded from: classes4.dex */
public final class DatePeriodIso8601Serializer implements KSerializer<DatePeriod> {
    public static final DatePeriodIso8601Serializer INSTANCE = new DatePeriodIso8601Serializer();
    public static final PrimitiveSerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("DatePeriod", PrimitiveKind.STRING.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        DateTimePeriod.Companion companion = DateTimePeriod.Companion;
        String decodeString = decoder.decodeString();
        companion.getClass();
        DateTimePeriod parse = DateTimePeriod.Companion.parse(decodeString);
        if (parse instanceof DatePeriod) {
            return (DatePeriod) parse;
        }
        throw new SerializationException(parse + " is not a date-based period");
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        DatePeriod value = (DatePeriod) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeString(value.toString());
    }
}
