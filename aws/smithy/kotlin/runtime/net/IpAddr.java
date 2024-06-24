package aws.smithy.kotlin.runtime.net;

import com.google.gson.stream.JsonReader;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;

/* compiled from: IpAddr.kt */
/* loaded from: classes.dex */
public abstract class IpAddr implements Encoder, CompositeEncoder {
    public static JsonReader.AnonymousClass1 INSTANCE;

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginCollection(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return beginStructure(descriptor);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void encodeBoolean(boolean z);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeBooleanElement(SerialDescriptor descriptor, int r3, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeElement(descriptor, r3);
        encodeBoolean(z);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void encodeByte(byte b);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeByteElement(PrimitiveArrayDescriptor descriptor, int r3, byte b) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeElement(descriptor, r3);
        encodeByte(b);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void encodeChar(char c);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeCharElement(PrimitiveArrayDescriptor descriptor, int r3, char c) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeElement(descriptor, r3);
        encodeChar(c);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void encodeDouble(double d);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeDoubleElement(SerialDescriptor descriptor, int r3, double d) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeElement(descriptor, r3);
        encodeDouble(d);
    }

    public abstract void encodeElement(SerialDescriptor serialDescriptor, int r2);

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void encodeFloat(float f);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeFloatElement(SerialDescriptor descriptor, int r3, float f) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeElement(descriptor, r3);
        encodeFloat(f);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract Encoder encodeInline(SerialDescriptor serialDescriptor);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public Encoder encodeInlineElement(PrimitiveArrayDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeElement(descriptor, r3);
        return encodeInline(descriptor.getElementDescriptor(r3));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void encodeInt(int r1);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeIntElement(int r2, int r3, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeElement(descriptor, r2);
        encodeInt(r3);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void encodeLong(long j);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeLongElement(SerialDescriptor descriptor, int r3, long j) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeElement(descriptor, r3);
        encodeLong(j);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeNullableSerializableElement(SerialDescriptor descriptor, int r3, KSerializer serializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        encodeElement(descriptor, r3);
        if (serializer.getDescriptor().isNullable()) {
            encodeSerializableValue(serializer, obj);
        } else if (obj == null) {
            encodeNull();
        } else {
            encodeSerializableValue(serializer, obj);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeSerializableElement(SerialDescriptor descriptor, int r3, SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        encodeElement(descriptor, r3);
        encodeSerializableValue(serializer, obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void encodeSerializableValue(SerializationStrategy serializationStrategy, Object obj);

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void encodeShort(short s);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeShortElement(PrimitiveArrayDescriptor descriptor, int r3, short s) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeElement(descriptor, r3);
        encodeShort(s);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void encodeString(String str);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeStringElement(SerialDescriptor descriptor, int r3, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        encodeElement(descriptor, r3);
        encodeString(value);
    }

    public abstract byte[] getOctets();

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNotNullMark() {
    }
}
