package kotlinx.serialization.encoding;

import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: Decoding.kt */
/* loaded from: classes4.dex */
public interface Decoder {
    CompositeDecoder beginStructure(SerialDescriptor serialDescriptor);

    boolean decodeBoolean();

    byte decodeByte();

    char decodeChar();

    double decodeDouble();

    int decodeEnum(SerialDescriptor serialDescriptor);

    float decodeFloat();

    Decoder decodeInline(SerialDescriptor serialDescriptor);

    int decodeInt();

    long decodeLong();

    boolean decodeNotNullMark();

    void decodeNull();

    <T> T decodeSerializableValue$1(DeserializationStrategy<? extends T> deserializationStrategy);

    short decodeShort();

    String decodeString();
}
