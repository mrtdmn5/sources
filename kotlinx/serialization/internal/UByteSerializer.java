package kotlinx.serialization.internal;

import com.google.android.gms.cloudmessaging.zzv;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ValueClasses.kt */
/* loaded from: classes4.dex */
public final class UByteSerializer implements KSerializer<UByte> {
    public static final UByteSerializer INSTANCE = new UByteSerializer();
    public static final InlineClassDescriptor descriptor = zzv.InlinePrimitiveDescriptor("kotlin.UByte", ByteSerializer.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return new UByte(decoder.decodeInline(descriptor).decodeByte());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        byte b = ((UByte) obj).data;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeInline(descriptor).encodeByte(b);
    }
}
