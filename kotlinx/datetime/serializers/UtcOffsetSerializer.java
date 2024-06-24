package kotlinx.datetime.serializers;

import j$.time.DateTimeException;
import j$.time.ZoneOffset;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.UtcOffset;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

/* compiled from: TimeZoneSerializers.kt */
/* loaded from: classes4.dex */
public final class UtcOffsetSerializer implements KSerializer<UtcOffset> {
    public static final UtcOffsetSerializer INSTANCE = new UtcOffsetSerializer();
    public static final PrimitiveSerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("UtcOffset", PrimitiveKind.STRING.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        UtcOffset.Companion companion = UtcOffset.Companion;
        String offsetString = decoder.decodeString();
        companion.getClass();
        Intrinsics.checkNotNullParameter(offsetString, "offsetString");
        try {
            return new UtcOffset(ZoneOffset.of(offsetString));
        } catch (DateTimeException e) {
            throw new DateTimeFormatException(e);
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        UtcOffset value = (UtcOffset) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeString(value.toString());
    }
}
