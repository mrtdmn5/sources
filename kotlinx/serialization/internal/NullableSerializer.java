package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: NullableSerializer.kt */
/* loaded from: classes4.dex */
public final class NullableSerializer<T> implements KSerializer<T> {
    public final SerialDescriptorForNullable descriptor;
    public final KSerializer<T> serializer;

    public NullableSerializer(KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.serializer = serializer;
        this.descriptor = new SerialDescriptorForNullable(serializer.getDescriptor());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (decoder.decodeNotNullMark()) {
            return (T) decoder.decodeSerializableValue$1(this.serializer);
        }
        decoder.decodeNull();
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && NullableSerializer.class == obj.getClass() && Intrinsics.areEqual(this.serializer, ((NullableSerializer) obj).serializer)) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final int hashCode() {
        return this.serializer.hashCode();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, T t) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        if (t != null) {
            encoder.encodeNotNullMark();
            encoder.encodeSerializableValue(this.serializer, t);
        } else {
            encoder.encodeNull();
        }
    }
}
