package kotlinx.serialization.encoding;

import com.google.common.hash.AbstractHasher;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;

/* compiled from: Decoding.kt */
/* loaded from: classes4.dex */
public interface CompositeDecoder {
    boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int r2);

    byte decodeByteElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int r2);

    char decodeCharElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int r2);

    double decodeDoubleElement(SerialDescriptor serialDescriptor, int r2);

    int decodeElementIndex(SerialDescriptor serialDescriptor);

    float decodeFloatElement(SerialDescriptor serialDescriptor, int r2);

    Decoder decodeInlineElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int r2);

    int decodeIntElement(SerialDescriptor serialDescriptor, int r2);

    long decodeLongElement(SerialDescriptor serialDescriptor, int r2);

    Object decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int r2, KSerializer kSerializer, Object obj);

    void decodeSequentially();

    <T> T decodeSerializableElement(SerialDescriptor serialDescriptor, int r2, DeserializationStrategy<? extends T> deserializationStrategy, T t);

    short decodeShortElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int r2);

    String decodeStringElement(SerialDescriptor serialDescriptor, int r2);

    void endStructure(SerialDescriptor serialDescriptor);

    AbstractHasher getSerializersModule();
}
