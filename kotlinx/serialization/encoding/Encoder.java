package kotlinx.serialization.encoding;

import com.google.common.hash.AbstractHasher;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: Encoding.kt */
/* loaded from: classes4.dex */
public interface Encoder {
    CompositeEncoder beginCollection(SerialDescriptor serialDescriptor);

    CompositeEncoder beginStructure(SerialDescriptor serialDescriptor);

    void encodeBoolean(boolean z);

    void encodeByte(byte b);

    void encodeChar(char c);

    void encodeDouble(double d);

    void encodeEnum(SerialDescriptor serialDescriptor, int r2);

    void encodeFloat(float f);

    Encoder encodeInline(SerialDescriptor serialDescriptor);

    void encodeInt(int r1);

    void encodeLong(long j);

    void encodeNotNullMark();

    void encodeNull();

    <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t);

    void encodeShort(short s);

    void encodeString(String str);

    AbstractHasher getSerializersModule();
}
