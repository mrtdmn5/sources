package kotlinx.serialization.encoding;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;

/* compiled from: Encoding.kt */
/* loaded from: classes4.dex */
public interface CompositeEncoder {
    void encodeBooleanElement(SerialDescriptor serialDescriptor, int r2, boolean z);

    void encodeByteElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int r2, byte b);

    void encodeCharElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int r2, char c);

    void encodeDoubleElement(SerialDescriptor serialDescriptor, int r2, double d);

    void encodeFloatElement(SerialDescriptor serialDescriptor, int r2, float f);

    Encoder encodeInlineElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int r2);

    void encodeIntElement(int r1, int r2, SerialDescriptor serialDescriptor);

    void encodeLongElement(SerialDescriptor serialDescriptor, int r2, long j);

    void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int r2, KSerializer kSerializer, Object obj);

    <T> void encodeSerializableElement(SerialDescriptor serialDescriptor, int r2, SerializationStrategy<? super T> serializationStrategy, T t);

    void encodeShortElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int r2, short s);

    void encodeStringElement(SerialDescriptor serialDescriptor, int r2, String str);

    void endStructure(SerialDescriptor serialDescriptor);

    boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor);
}
